from flask import Flask, render_template, request, redirect, session
import random, datetime
app = Flask(__name__)
app.secret_key = "key"

@app.route("/")
def index():
  if not 'total_gold' in session:
    session['total_gold'] = 0
  
  if not 'activities' in session:
    session['activities'] = []

  return render_template("index.html")

@app.route("/process_money", methods=["POST"])
def process_money():
  time = datetime.datetime.now()
  if request.form['which_form'] == 'farm':
    rand10to20 = random.randint(9, 20)
    session['total_gold'] += rand10to20
    session['activities'].append(f"<li class='earned'>Earned {rand10to20} golds from the farm ({time.strftime('%Y/%m/%d %X %p')})</li>")

  if request.form['which_form'] == 'cave':
    rand5to10 = random.randint(4, 10)
    session['total_gold'] += rand5to10
    session['activities'].append(f"<li class='earned'>Earned {rand5to10} golds from the cave ({time.strftime('%Y/%m/%d %X %p')})</li>")
  
  if request.form['which_form'] == 'house':
    rand2to5 = random.randint(1, 5)
    session['total_gold'] += rand2to5
    session['activities'].append(f"<li class='earned'>Earned {rand2to5} golds from the house ({time.strftime('%Y/%m/%d %X %p')})</li>")

  if request.form['which_form'] == 'casino':
    rand_casino = random.randint(-51, 50)
    session['total_gold'] += rand_casino
    print(rand_casino, session['total_gold'])
    if rand_casino > 0:
      session['activities'].append(f"<li class='earned'>Earned {rand_casino} golds from the casino ({time.strftime('%Y/%m/%d %X %p')})</li>")
    elif rand_casino < 0 and session['total_gold'] > 0:
      session['activities'].append(f"<li class='lost'>Enter a casino and lost {rand_casino} golds... Ouch... ({time.strftime('%Y/%m/%d %X %p')})</li>")
    elif rand_casino < 0 and session['total_gold'] < 0:
      session['activities'].append(f"<li class='lost'>Enter a casino and lost {rand_casino} golds. Now you are in casino's debt for {rand_casino} golds ({time.strftime('%Y/%m/%d %X %p')})</li>")
    else:
      session['activities'].append(f"<li>Enter a casino for fun</li>")

  return redirect("/")

@app.route("/reset", methods=["POST"])
def reset():
  session.clear()
  return redirect('/')
  
if __name__ == "__main__":
  app.run(debug=True)