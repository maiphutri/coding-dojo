from django.conf.urls import url
from . import views

urlpatterns = [
  url(r'^$', views.users),
  url(r'^users/register$', views.create_user),
  url(r'^users/login$', views.user_login),
  url(r'^users/logout$', views.user_logout),
  url(r'^users/(?P<user_id>\d+)$', views.show_user),
  url(r'^books$', views.books),
  url(r'^books/add$', views.book_add),
  url(r'^books/create', views.create_book),
  url(r'^books/(?P<book_id>\d+)$', views.show_book),
  url(r'^books/(?P<book_id>\d+)/add_review$', views.add_review),
  url(r'^books/(?P<book_id>\d+)/reviews/(?P<review_id>\d+)/destroy$', views.review_destroy)
]