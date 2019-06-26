from django.conf.urls import url
from . import views

urlpatterns = [
  url(r'^$', views.home),
  url(r'^shows$', views.index),
  url(r'^shows/new$', views.new),
  url(r'^shows/(?P<id>[0-9]+)/edit$', views.edit),
  url(r'^shows/(?P<id>[0-9]+)/update$', views.update),
  url(r'^shows/(?P<id>[0-9]+)/destroy$', views.destroy),
  url(r'^shows/(?P<id>[0-9]+)$', views.show)
]