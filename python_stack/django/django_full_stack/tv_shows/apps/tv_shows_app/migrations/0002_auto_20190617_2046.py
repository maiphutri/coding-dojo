# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-06-17 20:46
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('tv_shows_app', '0001_initial'),
    ]

    operations = [
        migrations.AlterField(
            model_name='shows',
            name='release_date',
            field=models.DateField(blank=True, null=True, verbose_name='Release Date'),
        ),
    ]