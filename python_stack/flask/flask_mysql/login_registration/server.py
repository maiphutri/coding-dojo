from flask import Flask, render_template, request, redirect, session, flash
from mysqlconnection import connectToMySQL
from flask_bcrypt import Bcrypt
import re, datetime
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

app = Flask(__name__)
app.secret_key = "key"
bcrypt = Bcrypt(app)

@app.route("/")
def index():
  return render_template("index.html")

@app.route("/create", methods=['POST'])
def create():
  if not 'user_input' in session:
    session['user_input'] = {}

  if len(request.form['first-name']) < 1:
    flash("Please enter a first name", 'fn')
  else:
    session['user_input']['fn'] = request.form['first-name']

  if len(request.form['last-name']) < 1:
    flash("Please enter a last name", 'ln')
  else:
    session['user_input']['ln'] = request.form['last-name']

  if not EMAIL_REGEX.match(request.form['email']):
    flash("Invalid email input!", 'email')
  else:
    mysql = connectToMySQL("login_registration")
    query = ("SELECT users.email FROM users WHERE email = %(email)s")
    email = mysql.query_db(query, request.form)
    if email:
      flash("The email you typed in is already in used!", "email")
    session['user_input']['email'] = request.form['email']

  if len(request.form['password']) < 8:
    flash("The Password must be at least 8 characters", 'pw')

  if not any(x.isupper() for x in request.form['password']):
    flash("Password must have at least 1 uppercase", 'pw')

  if not any(x.isdigit() for x in request.form['password']):
    flash("Password must have at least 1 number", 'pw')

  if request.form['password'] != request.form['confirm-password']:
    flash("The Confirm password confirmation does not match", 'confirm-pw')
  
  if not '_flashes' in session.keys():
    mysql = connectToMySQL('login_registration')
    pw_hash = bcrypt.generate_password_hash(request.form['password'])
    query = "INSERT INTO users (first_name, last_name, email, password) VALUES (%(fn)s, %(ln)s, %(email)s, %(pw)s);"
    data = {
      'fn': request.form['first-name'],
      'ln': request.form['last-name'],
      'email': request.form['email'],
      'pw': pw_hash
    }

    user_id = mysql.query_db(query, data)

    if not 'user' in session:
      mysql = connectToMySQL("login_registration")
      result = mysql.query_db(f"SELECT * FROM users WHERE id = {user_id}")
      session['user'] = result[0]
    return redirect("/wall")
  else:
    return redirect("/")

@app.route("/login", methods=["POST"])
def login():
  mysql = connectToMySQL("login_registration")
  query = "SELECT * FROM users WHERE email = %(login-email)s;"
  result = mysql.query_db(query, request.form)
  if len(result) > 0:
    if bcrypt.check_password_hash(result[0]['password'], request.form['login-password']):
      if not 'user' in session:
        session['user'] = result[0]
      flash("You've been successfully logged in!", "login")
      return redirect("/wall")

  flash("Inlavid email or password", "invalid")
  return redirect("/")

@app.route("/logout")
def logout():
  session.clear()
  flash("You've been successfully logged out!", "logout")
  return redirect("/")

@app.route("/wall")
def wall():
  if not 'user' in session:
    return redirect("/")
  mysql = connectToMySQL("login_registration")
  recievers = mysql.query_db("SELECT * FROM users")
  mysql = connectToMySQL("login_registration")
  result = mysql.query_db(f"SELECT users.first_name, message, messages.created_at FROM users JOIN message_relationships ON users.id = message_relationships.user_id JOIN messages ON messages.id  = message_relationships.message_id WHERE reciever_id = {session['user']['id']};")
  print(result)
  count = 0
  for i in result:
    count += 1
  return render_template("wall.html", recievers = recievers, messages = result, current_time = datetime.datetime.now(), count=count)

@app.route("/send/<reciever_id>", methods=['POST'])
def send_msg(reciever_id):
    mysql = connectToMySQL("login_registration")
    query = "INSERT INTO messages (message) VALUES (%(message)s);"
    msg_id = mysql.query_db(query, request.form)
    mysql = connectToMySQL("login_registration")
    query = "INSERT INTO message_relationships (user_id, reciever_id, message_id) VALUES (%(user_id)s, %(reciever_id)s, %(msg_id)s);"
    data = {
      'user_id': session['user']['id'],
      'reciever_id': reciever_id,
      'msg_id': msg_id
    }
    mysql.query_db(query, data)
    return redirect("/wall")
  

if __name__ == "__main__":
  app.run(debug=True)