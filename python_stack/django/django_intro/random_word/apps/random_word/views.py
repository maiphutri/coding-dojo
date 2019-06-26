from django.shortcuts import render, redirect
from django.utils.crypto import get_random_string

def index(request):
  if request.method == "GET":
    if not 'count' in request.session:
      request.session['count'] = 0
    return render(request, 'random_word/index.html')
  if request.method == "POST":
    if not 'random' in request.session:
      request.session['random'] = get_random_string(length=14)
    else:
      request.session['random'] = get_random_string(length=14)
    request.session['count'] += 1
    return redirect("/random_word")

def reset(request):
  try:
    del request.session['count']
    return redirect('/random_word')
  except:
    return redirect('/random_word')

# Create your views here.
