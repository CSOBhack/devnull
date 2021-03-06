#!/usr/bin/env python
# -*- coding: utf-8 -*-
import os
from app import create_app
from app import db
from flask.ext.script import Manager, Shell, Server


app = create_app('development')
manager = Manager(app)

def make_shell_context():
    return dict(app=app)

manager.add_command("shell", Shell(make_context=make_shell_context))
manager.add_command("runserverany", Server(host='0.0.0.0'))

if __name__ == '__main__':
    manager.run()
