from flask import Flask, render_template, request, redirect, session
import random
app = Flask(__name__)
app.secret_key = 'key'

@app.route("/")
def index():
  if not 'random' in session:
    session['random'] = random.randint(1,100)

  if 'attempts' in session:
    session['attempts'] += 1
  else:
    session['attempts'] = 0
  
  if session['attempts'] > 5:
    session['answer'] = "You Lose!"
    session['color'] = 'red'

  return render_template("index.html")

@app.route("/guess", methods=["POST"])
def play():
  guess = int(request.form['guess'])
  color = 'orange'
  if not 'answer' in session:
    session['answer'] = ""

  if guess == session['random']:
    session['answer'] = f"{guess} was the number!"
    color = 'green'

  if (session['random'] - 5 < guess < session['random']) or (session['random'] < guess < session['random'] + 5):
    session['answer'] = "Close!"
    color = 'aquamarine'

  if guess > session['random'] + 5:
    session['answer'] = "Too high!"

  if guess < session['random'] - 5:
    session['answer'] = "Too low!"
  
  session['guess'] = guess
  session['color'] = color
  return redirect('/')

@app.route("/reset", methods=["POST"])
def reset():
  session.clear()
  return redirect("/")
if __name__ == '__main__':
  app.run(debug=True)