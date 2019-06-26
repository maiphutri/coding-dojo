from django.shortcuts import render, redirect
from .models import Shows
from django.contrib import messages

def home(request):
  return redirect("/shows")

def index(request):
  context = {
    'shows': Shows.objects.all()
  }
  return render(request, 'tv_shows_app/index.html', context)

def new(request):
  if request.method == "GET":
    return render(request, 'tv_shows_app/new.html')
  if request.method == "POST":
    errors = Shows.objects.basic_validator(request.POST)
    if len(errors) > 0:
      for key, value in errors.items():
        messages.error(request, value)
      return redirect("/shows/new")
    else:
      Shows.objects.create(
        title = request.POST['title'],
        network = request.POST['network'],
        release_date = request.POST['release_date'],
        description = request.POST['desc']
      )
      return redirect("/shows")

def edit(request, id):
  context = {
    'show': Shows.objects.get(id=id)
  }
  return render(request, 'tv_shows_app/edit.html', context)

def update(request, id):
  if request.method == "POST":
    errors = Shows.objects.basic_validator(request.POST)
    if len(errors) > 0:
      if not 'user_errors' in request.session:
        request.session['user_errors'] = request.POST
      for key, value in errors.items():
        messages.error(request, value)
      return redirect(f"/shows/{id}/edit")
    else:
      show = Shows.objects.get(id=id)
      print(show.__dict__)
      show.title = request.POST['title']
      show.network = request.POST['network']
      show.release_date = request.POST['release_date']
      show.description = request.POST['desc']
      show.save()
      if 'user_errors' in request.session:
        del request.session['user_errors']
      return redirect(f"/shows/{id}")

def show(request, id):
  context = {
    'show': Shows.objects.get(id=id)
  }
  return render(request, 'tv_shows_app/show.html', context)

def destroy(request, id):
  if request.method == "POST":
    show = Shows.objects.get(id=id)
    show.delete()
    return redirect("/shows")
