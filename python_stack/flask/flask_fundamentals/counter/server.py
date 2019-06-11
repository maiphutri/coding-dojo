from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = "key"
@app.route("/")
def index():
  if 'count' in session:
    session['count'] += 1
  else:
    session['count'] = 0

  if 'visit' in session:
    session['visit'] += 1
  else:
    session['visit'] = 0
  return render_template("index.html")
@app.route("/destroy_session", methods=["POST"])
def reset():
  session.pop('count')
  return redirect("/")

@app.route("/add_two", methods=['POST'])
def add_two():
  session['count'] += 1
  return redirect("/")

@app.route("/add_num", methods=['POST'])
def add_num():
  session['count'] += int(request.form['num']) - 1
  return redirect("/")

if __name__ == "__main__":
  app.run(debug=True)