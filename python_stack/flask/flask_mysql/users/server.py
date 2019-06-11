from flask import Flask, render_template, request, redirect, session
from mysqlconnection import connectToMySQL
app = Flask(__name__)
app.secret_key = "key"

@app.route("/")
def index():
  return redirect("/users")

@app.route("/users")
def users():
  mysql = connectToMySQL("users_flask")
  users = mysql.query_db("SELECT * FROM users;")
  return render_template("users.html", users = users)

@app.route("/users/new")
def new_user():
  return render_template("new.html")

@app.route("/users/create", methods=["POST"])
def create_user():
  mysql = connectToMySQL("users_flask")
  query = "INSERT INTO users(first_name, last_name, email, created_at) VALUES (%(fn)s, %(ln)s, %(email)s, NOW())"
  data = {
    "fn": request.form['first-name'],
    "ln": request.form['last-name'],
    "email": request.form['email']
  }
  user_id = mysql.query_db(query, data)
  return redirect(f"/users/{user_id}")

@app.route("/users/<id>")
def show_user(id):
  mysql = connectToMySQL("users_flask")
  query = "SELECT * FROM users WHERE id = %(id)s"
  data = {
    "id": id
  }
  user = mysql.query_db(query, data)
  return render_template("show.html", user = user[0])

@app.route("/users/<id>/edit")
def edit_user(id):
  mysql = connectToMySQL("users_flask")
  query = "SELECT * FROM users WHERE id = %(id)s"
  data = {
    "id": id
  }
  user = mysql.query_db(query, data)
  return render_template("edit.html", user = user[0])

@app.route("/users/<id>/update", methods=["POST"])
def update_user(id):
  mysql = connectToMySQL("users_flask")
  query = "UPDATE users SET first_name = %(fn)s, last_name = %(ln)s, email = %(email)s WHERE id = %(id)s"
  data = {
    'id': id,
    'fn': request.form['first-name'],
    'ln': request.form['last-name'],
    'email': request.form['email']
  }
  mysql.query_db(query, data)
  return redirect(f"/users/{id}")

@app.route("/users/<id>/destroy", methods=["POST"])
def delete_user(id):
  mysql = connectToMySQL("users_flask")
  query = "DELETE FROM users WHERE id = %(id)s"
  data = {
    "id": id
  }
  mysql.query_db(query, data)
  return redirect('/users')

if __name__ == "__main__":
  app.run(debug=True)