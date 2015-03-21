# -*- coding: utf-8 -*-
from flask import render_template
from . import main
from app.main.models import Node, Event


@main.route('/')
def index():
    nodes = Node.all()
    return render_template('index.html', nodes=nodes)
