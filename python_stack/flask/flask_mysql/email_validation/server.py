from flask import Flask, render_template, request, redirect, session, flash
from mysqlconnection import connectToMySQL
import re

app = Flask(__name__)
app.secret_key = "key"
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

@app.route("/")
def index():
  return render_template("index.html")

@app.route("/create", methods=["POST"])
def create():
  mysql = connectToMySQL('email_validation')
  emails = mysql.query_db("SELECT * FROM emails")
  for email in emails:
    if email['email'] == request.form['email']:
      flash("The email that you typed is already been used.")
      return redirect("/")

  if not EMAIL_REGEX.match(request.form['email']):
    flash("Invalid email!")
    return redirect("/")
  else:
    mysql = connectToMySQL('email_validation')
    query = "INSERT INTO emails(email) VALUES (%(email)s)"
    data = {
      'email': request.form['email']
    }
    mysql.query_db(query, data)
    flash(f"The email address you entered {request.form['email']} is a VALID email address! Thank you!")
    return redirect("/success")

@app.route("/<id>/destroy", methods=['POST'])
def delete(id):
  mysql = connectToMySQL("email_validation")
  mysql.query_db(f"DELETE FROM emails WHERE id = {id}")
  return redirect("/success")

@app.route("/success")
def success():
  mysql = connectToMySQL('email_validation')
  emails = mysql.query_db("SELECT * FROM emails;")
  print(emails)
  return render_template("success.html", emails=emails)

if __name__ == "__main__":
  app.run(debug=True)