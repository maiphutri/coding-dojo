from flask import Flask, render_template, request, redirect, flash, session
from mysqlconnection import connectToMySQL
app = Flask(__name__)
app.secret_key = "key"

@app.route("/")
def index():
  return render_template("index.html")

@app.route("/create", methods=["POST"])
def create():
  is_valid = True
  print(request.form['gender'])
  print(request.form['location'])
  print(request.form['language'])
  if len(request.form['name']) < 1:
    is_valid = False
    flash("Invalid name input")
  if request.form['location'] == "None":
    is_valid = False
    flash("Please choose a location")
  if request.form['language'] == "None":
    is_valid = False
    flash("Please choose your favorite language")
  if len(request.form['comment']) > 120:
    is_valid = False
    flash("Your comment cannot exceed 120 characters")
  if not is_valid:
    return redirect("/")
  else:
    flash("Survey successfully submitted")
    mysql = connectToMySQL("dojo_survey")
    query = "INSERT INTO surveys (name, gender, dojo_location, fav_language, comment) VALUES (%(name)s, %(gender)s, %(location)s, %(language)s, %(comment)s);"
    data = {
      'name': request.form['name'],
      'gender': request.form['gender'],
      'location': request.form['location'],
      'language': request.form['language'],
      'comment': request.form['comment']
    }
    user_id = mysql.query_db(query, data)
    if not 'id' in session:
      session['id'] = user_id
    return redirect('/result')

@app.route("/result")
def result():
  mysql = connectToMySQL("dojo_survey")
  user = mysql.query_db(f"SELECT * FROM surveys WHERE id = {session['id']}")
  session.clear()
  return render_template("result.html", user = user[0])
  
if __name__ == "__main__":
  app.run(debug=True)