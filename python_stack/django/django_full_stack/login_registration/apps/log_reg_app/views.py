from django.shortcuts import render, redirect
from django.contrib import messages
from .models import User
import bcrypt

def index(request):
  return render(request, "log_reg_app/index.html")

def create(request):
  if request.method == "POST":
    errors = User.objects.registration_validator(request.POST)
    if len(errors) > 0:
      for key, value in errors.items():
        messages.error(request, value)
      return redirect("/")
    else:
      hash_pw = bcrypt.hashpw(request.POST['password'].encode(), bcrypt.gensalt())
      user = User.objects.create(
        first_name = request.POST['first_name'],
        last_name = request.POST['last_name'],
        email = request.POST['email'],
        password = hash_pw
      )
      if not 'user' in request.session:
        request.session['user_fn'] = user.first_name
      return redirect("/success")

def login(request):
  if request.method == "POST":
    errors = User.objects.login_validator(request.POST)
    if len(errors) > 0:
      for key, value in errors.items():
        messages.error(request, value)
      return redirect("/")
    else:
      if not 'user' in request.session:
        user = User.objects.get(email=request.POST['login-email'])
        request.session['user_fn'] = user.first_name
      return redirect("/success")

def success(request):
  if not 'user_fn' in request.session:
    messages.error(request, "You must sign up or login to have the access.")
    return redirect("/")
  messages.success(request, "Successfully log in!")
  return render(request, "log_reg_app/success.html")

def logout(request):
  del request.session['user_fn']
  return redirect("/")