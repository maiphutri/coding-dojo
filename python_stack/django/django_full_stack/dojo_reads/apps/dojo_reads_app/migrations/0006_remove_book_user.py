# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-06-21 19:11
from __future__ import unicode_literals

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('dojo_reads_app', '0005_auto_20190621_1511'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='book',
            name='user',
        ),
    ]
