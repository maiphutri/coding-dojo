from django.shortcuts import render, redirect
from .models import Book, Author

def index(request):
  context = {
    "all_books": Book.objects.all()
  }
  return render(request, "books_authors_app/books/index.html", context)

def add_book(request):
  if request.method == "POST":
    Book.objects.create(title = request.POST['title'], desc = request.POST['desc'])
    return redirect("/")

def show_book(request, id):
  exclude_author_id = [a['id'] for a in Book.objects.get(id=id).authors.values('id')] # for every object author add author_id to the list
  context = {
    'book': Book.objects.get(id=id),
    'authors': Book.objects.get(id=id).authors.values('first_name', 'last_name'),
    'not_authors': Author.objects.exclude(id__in=exclude_author_id).values('id', 'first_name', 'last_name') # exclude multiple author by id in a list []

  }
  return render(request, 'books_authors_app/books/show.html', context)

def assign_author(request, id):
  if request.method == "POST":
    this_book = Book.objects.get(id=id)
    this_author = Author.objects.get(id=int(request.POST['author'][0]))
    this_book.authors.add(this_author)
    return redirect(f"/book/{id}")

def authors(request):
  context = {
    'authors': Author.objects.all()
  }
  return render(request, "books_authors_app/authors/index.html", context)

def add_author(request):
  if request.method == "POST":
    Author.objects.create(first_name = request.POST["fn"], last_name = request.POST['ln'], notes = request.POST['note'])
    return redirect("/authors")

def show_author(request, id):
  exclude_book_id = [b['id'] for b in Author.objects.get(id=id).books.values('id')]
  context = {
    'author': Author.objects.get(id=id),
    'books': Author.objects.get(id=id).books.values('title'),
    'not_books': Book.objects.exclude(id__in=exclude_book_id).values('id', 'title')
  }
  return render(request, "books_authors_app/authors/show.html", context)

def assign_book(request, id):
  if request.method == 'POST':
    this_author = Author.objects.get(id=id)
    this_book = Book.objects.get(id=int(request.POST['book'][0]))
    this_author.books.add(this_book)
    return redirect(f"/authors/{id}")

