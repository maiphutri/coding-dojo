# -*- coding: utf-8 -*-
# Generated by Django 1.10 on 2019-06-21 00:27
from __future__ import unicode_literals

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('dojo_reads_app', '0003_auto_20190621_0026'),
    ]

    operations = [
        migrations.RenameModel(
            old_name='Reviews',
            new_name='Review',
        ),
    ]