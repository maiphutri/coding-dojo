from django.shortcuts import render, redirect
import random, datetime
time = datetime.datetime.now()
def index(request):
  if not 'total_gold' in request.session:
    request.session['total_gold'] = 0

  if not 'activities' in request.session:
    request.session['activities'] = []
  if not 'attempts' in request.session:
    request.session['attempts'] = 0
  else:
    if request.session['attempts'] <= 15 and request.session['total_gold'] >= 300:
      request.session['gameover'] = True
      request.session['activities'].append({'msg': "You win", 'isLost': False})
    elif request.session['attempts'] >= 15 and request.session['total_gold'] < 300:
      request.session['gameover'] = True
      request.session['activities'].append({'msg': "You lost", 'isLost': True})
    else:
      request.session['gameover'] = False

  return render(request, 'money/index.html')

def farm(request):
  rand10to20 = random.randint(9, 20)
  request.session['total_gold'] += rand10to20
  request.session['activities'].append({
    'msg': f"Earned {rand10to20} golds from the farm ({time.strftime('%Y/%m/%d %X %p')})",
    'isLost': False
  })
  request.session['attempts'] += 1
  return redirect("/")

def cave(request):
  rand5to10 = random.randint(4, 10)
  request.session['total_gold'] += rand5to10
  request.session['activities'].append({
    'msg': f"Earned {rand5to10} golds from the farm ({time.strftime('%Y/%m/%d %X %p')})",
    'isLost': False
  })
  request.session['attempts'] += 1
  return redirect("/")

def house(request):
  rand2to5 = random.randint(1, 5)
  request.session['total_gold'] += rand2to5
  request.session['activities'].append({
    'msg': f"Earned {rand2to5} golds from the farm ({time.strftime('%Y/%m/%d %X %p')})",
    'isLost': False
  })
  request.session['attempts'] += 1
  return redirect("/")

def casino(request):
  rand_casino = random.randint(-51, 50)  
  request.session['total_gold'] += rand_casino
  if rand_casino > 0:
    request.session['activities'].append({
      'msg':f"Earned {rand_casino} golds from the casino ({time.strftime('%Y/%m/%d %X %p')})",
      'isLost': False
    })
  elif rand_casino < 0 and request.session['total_gold'] > 0:
    request.session['activities'].append({
      'msg':f"Enter a casino and lost {rand_casino} golds... Ouch... ({time.strftime('%Y/%m/%d %X %p')})",
      'isLost': True
    })
  elif rand_casino < 0 and request.session['total_gold'] < 0:
    request.session['activities'].append({
      'msg': f"Enter a casino and lost {rand_casino} golds. Now you are in casino's debt for {request.session['total_gold']} golds ({time.strftime('%Y/%m/%d %X %p')})",
      'isLost': True
    })
  else:
    request.session['activities'].append({'msg': "Enter a casino for fun", 'isLost': False})
  request.session['attempts'] += 1
  return redirect("/")

def reset(request):
  try:
    del request.session['activities']
    del request.session['total_gold']
    del request.session['attempts']
    request.session['gameover'] = False
    return redirect("/")
  except:
    return redirect("/")

# Create your views here.
