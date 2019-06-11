from flask import Flask, render_template
app = Flask(__name__)

@app.route("/")
def home():
  return render_template("index.html", col=8, row=8)

@app.route("/<num>")
def num(num):
  return render_template("index.html", col=8, row=int(num))

@app.route("/<x>/<y>")
def x_y(x, y):
  return render_template("index.html", col=int(x), row=int(y))

@app.route("/<x>/<y>/<color1>/<color2>")
def x_y_colors(x, y, color1, color2):
  color_one = f"background-color: {color1}"
  color_two = f"background-color: {color2}"
  return render_template("index.html", col=int(x), row=int(y), color1=color_one, color2=color_two)

if __name__ == "__main__":
  app.run(debug=True)
