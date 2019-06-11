from flask import Flask, render_template
app = Flask(__name__)
@app.route("/play")
def level_1():
  return render_template("play.html")
@app.route("/play/<num>")
def level_2(num):
  return render_template("play.html", times=int(num))
@app.route("/play/<num>/<color>")
def level_3(num, color):
  return render_template("play.html", color=color, times=int(num))
if __name__ == "__main__":
  app.run(debug=True)