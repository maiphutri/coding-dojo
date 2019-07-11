from __future__ import unicode_literals
from django.db import models
import re, bcrypt
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

class UserManager(models.Manager):
  def registration_validator(self, postData):
    errors = {}
    isAlpha = True
    if len(postData['first_name']) < 2 or len(postData['last_name']) < 2:
      errors['name-len'] = "First name and last name must be at least 2 characters"
    for char in postData['first_name']:
      if not char.isalpha():
        isAlpha = False
        break
    for char in postData['last_name']:
      if not char.isalpha():
        isAlpha = False
        break
    if not isAlpha:
      errors['name-letters'] = "First name and last name should only contains letters"
    if not EMAIL_REGEX.match(postData["email"]):
      errors['email'] = "Invalid email"
    if User.objects.filter(email = postData['email']).exists():
      errors['email-exist'] = "Email you typed in is already existed"
    if len(postData['password']) < 8:
      errors['pw'] = 'Password must be at least 8 characters'
    if postData['confirm-password'] != postData['password']:
      errors['confirm-pw'] = "Confirm password does not match password"
    return errors

  def login_validator(self, postData):
    errors = {}
    if not User.objects.filter(email = postData['login-email']).exists():
      errors['login-email'] = "Invalid email or password"
      return errors
    user = User.objects.get(email = postData['login-email'])
    if not bcrypt.checkpw(postData['login-password'].encode(), user.password.encode()):
      errors['login-pw'] = "Invalid email or password"
    return errors

class BookManager(models.Manager):
  def book_validator(self, postData):
    errors = {}
    if len(postData['title']) < 2:
      errors['title'] = "Title must be at least 2 characters "
    if postData['author-select'] == "null" and len(postData['add-author']) < 2:
      errors['author'] = "Please assign an author to the book"
    if len(postData['review']) < 10:
      errors['review'] = "Review must be at least 10 characters"
    if postData['rating'] == 'null':
      errors['rating'] = "Please rate the book"
    return errors

class ReviewManager(models.Manager):
  def review_validator(self, postData):
    errors = {}
    if len(postData['review']) < 10:
      errors['review'] = "Review must be at least 10 characters"
    if postData['rating'] == 'null':
      errors['rating'] = "Please rate the book"
    return errors


class User(models.Model):
  first_name = models.CharField(max_length=45)
  last_name = models.CharField(max_length=45)
  email = models.CharField(max_length=255)
  password = models.TextField()
  created_at = models.DateTimeField(auto_now_add=True)
  updated_at = models.DateTimeField(auto_now=True)
  objects = UserManager()

class Author(models.Model):
  name = models.CharField(max_length=60)
  created_at = models.DateTimeField(auto_now_add=True)
  updated_at = models.DateTimeField(auto_now=True)

class Book(models.Model):
  title = models.CharField(max_length=60)
  author = models.ForeignKey(Author, on_delete=models.CASCADE, related_name="books")
  created_at = models.DateTimeField(auto_now_add=True)
  updated_at = models.DateTimeField(auto_now=True)
  objects = BookManager()

class Review(models.Model):
  content = models.TextField()
  rating =  models.CharField(max_length=1, null=True)
  user = models.ForeignKey(User, on_delete=models.CASCADE, related_name="reviews")
  book = models.ForeignKey(Book, on_delete=models.CASCADE, related_name="reviews")
  created_at = models.DateTimeField(auto_now_add=True)
  updated_at = models.DateTimeField(auto_now=True)
  objects = ReviewManager()