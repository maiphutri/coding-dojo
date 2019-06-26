from django.shortcuts import render, redirect
from django.contrib import messages
from .models import User, Author, Book, Review
import bcrypt

def users(request): #/
  if 'user' in request.session:
    return redirect("/books")
  return render(request, "dojo_reads_app/users/index.html")

def create_user(request): #/user/register
  errors = User.objects.registration_validator(request.POST)
  if len(errors) > 0:
    for key, value in errors.items():
      messages.error(request, value)
    request.session['invalid_input'] = request.POST
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
      request.session['user'] = user.id
    if 'invalid_input' in request.session:
      del request.session['invalid_input']
    return redirect("/books")

def user_login(request): #/user/login
  errors = User.objects.login_validator(request.POST)
  if len(errors) > 0:
    for key, value in errors.items():
      messages.error(request, value)
    return redirect("/")
  else:
    if not 'user' in request.session:
      user = User.objects.get(email=request.POST['login-email'])
      request.session['user'] = user.id
    return redirect("/books")

def show_user(request, user_id):
  if not 'user' in request.session:
    messages.error(request, "Please sign up or log in")
    return redirect("/")
  user = User.objects.get(id=user_id)
  reviews = Review.objects.filter(user=user)
  context = {
    'user': user,
    'total_reviews': reviews.count(),
    'reviews': reviews

  }
  return render(request, 'dojo_reads_app/users/show.html', context)
def user_logout(request): #/users/logout
  request.session.clear()
  return redirect("/")

def books(request): #/books
  if not 'user' in request.session:
    messages.error(request, "Please sign up or log in")
    return redirect("/")
  context = {
    'books': Book.objects.all(),
    'recent_reviews': Review.objects.all()[::-1][:3],
    'user': User.objects.get(id=request.session['user'])
  }
  return render(request, "dojo_reads_app/books/index.html", context)

def book_add(request): #/books/add
  if not 'user' in request.session:
    messages.error(request, "Please sign up or log in")
    return redirect("/")
  context = {
    'authors': Author.objects.all()
  }
  return render(request, "dojo_reads_app/books/new.html", context)

def create_book(request): #books/create
  errors = Book.objects.book_validator(request.POST)
  if len(errors) > 0:
    for key, value in errors.items():
      messages.error(request, value)
    return redirect("/books/add")
  else:
    author = None
    if request.POST['author-select'] == "null":
      author = Author.objects.create(name=request.POST['add-author'])
    else:
      author = Author.objects.get(id=request.POST['author-select'])
    book = Book.objects.create(title=request.POST['title'], author=author)
    user = User.objects.get(id=request.session['user'])
    review = Review.objects.create(
      content = request.POST['review'],
      rating = int(request.POST['rating']),
      user = user,
      book = book
    )
    return redirect(f"/books/{book.id}")

def show_book(request, book_id):
  if not 'user' in request.session:
    messages.error(request, "Please sign up or log in")
    return redirect("/")
  book = Book.objects.get(id = book_id)
  reviews = Review.objects.filter(book=book)
  isReviewed = False
  rating_sum = 0
  for r in reviews:
    if r.user.id == request.session['user']:
      isReviewed =  True
    rating_sum += int(r.rating)
  context = {
    'book': book,
    'reviews': reviews,
    'isReviewed': isReviewed,
    'avg_rating': round(rating_sum / len(reviews))
  }
  return render(request, "dojo_reads_app/books/show.html", context)

def add_review(request, book_id):
  errors = Review.objects.review_validator(request.POST)
  if len(errors) > 0:
    for key, value in errors.items():
      messages.error(request, value)
    return redirect(f"/books/{book_id}")
  else:
    user = User.objects.get(id = request.session['user'])
    book = Book.objects.get(id = book_id)
    Review.objects.create(
      content = request.POST['review'],
      rating = request.POST['rating'],
      user = user,
      book = book
    )
    return redirect(f"/books/{book_id}")
    
def review_destroy(request, book_id, review_id):
  if not 'user' in request.session:
    messages.error(request, "Please sign up or log in")
    return redirect("/")
  try:
    Review.objects.get(id=review_id).delete()
    return redirect(f"/books/{book_id}")
  except Review.DoesNotExist:
    return redirect(f"/books/{book_id}")

  