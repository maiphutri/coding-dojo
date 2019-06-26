from __future__ import unicode_literals
from django.db import models
from datetime import datetime

class ShowManager(models.Manager):
  def basic_validator(self, postData):
    errors = {}
    if len(postData['title']) < 2:
      errors['title'] = "Title must be at least 2 characters"
    if len(postData['network']) < 3:
      errors['network'] = "Network must be at least 3 characters"
    if postData['desc'] and len(postData['desc']) < 10:
      errors['desc'] = "Description must be at least 10 characters"
    # Convert string date from request post to a date data type 
    if datetime.strptime(postData['release_date'], "%Y-%m-%d").date() >= datetime.today().date():
      errors['release_date'] = "Release date must be in the past"
    show_title = Shows.objects.get(title=postData['title'])
    if show_title:
      errors['title_exist'] = "Title is already existed"
    return errors

class Shows(models.Model):
  title = models.CharField(max_length=45)
  network = models.CharField(max_length=45)
  release_date = models.DateField('Release Date', blank=True, null=True)
  description = models.TextField(null=True)
  created_at = models.DateTimeField(auto_now_add=True)
  updated_at = models.DateTimeField(auto_now=True)
  objects = ShowManager()


