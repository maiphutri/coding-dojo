from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def hello_world():
    return render_template('index.html', phrase="hello", times=5)

@app.route("/dojo")
def dojo():
  return "Dojo!"

@app.route("/say/<name>")
def hello_name(name):
  if name.isdigit():
    return "Invalid input"
  return f"Hi {str(name)}!"

@app.route("/repeat/<num>/<word>")
def repeat_str(num, word):
  if not num.isdigit():
    return "Invalid input number or word"
  new_str = ""
  for i in range(1, int(num)+1):
    new_str += f"{i}. {str(word)}<br>"
  return new_str

@app.route("/lists")
def render_lists():
  student_info = [
       {'name' : 'Michael', 'age' : 35},
       {'name' : 'John', 'age' : 30 },
       {'name' : 'Mark', 'age' : 25},
       {'name' : 'KB', 'age' : 27}
  ]
  return render_template("lists.html", random_numbers = [3,1,5], students = student_info)
  
@app.route("/<path:path>")
def catch_all(path):
  return "Sorry! No response. Try again."
if __name__ == '__main__':
  app.run(debug=True)
