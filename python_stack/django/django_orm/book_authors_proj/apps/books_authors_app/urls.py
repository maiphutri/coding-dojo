from django.conf.urls import url
from . import views

urlpatterns = [
  url(r'^$', views.index),
  url(r'^add_book$', views.add_book),
  url(r'^book/(?P<id>[0-9]+)$', views.show_book),
  url(r'^book/(?P<id>[0-9]+)/assign_author$', views.assign_author),
  url(r'^authors$', views.authors),
  url(r'^add_author$', views.add_author),
  url(r'^authors/(?P<id>[0-9]+)$', views.show_author),
  url(r'^authors/(?P<id>[0-9]+)/assign_book$', views.assign_book)
]