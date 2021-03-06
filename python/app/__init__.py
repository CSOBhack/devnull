from flask import Flask
from flask.ext.bootstrap import Bootstrap, StaticCDN
from flask.ext.sqlalchemy import SQLAlchemy
from config import config


bootstrap = Bootstrap()
db = SQLAlchemy()


def create_app(config_name):
    app = Flask(__name__)
    app.config.from_object(config[config_name])
    config[config_name].init_app(app)

    bootstrap.init_app(app)
    app.extensions['bootstrap']['cdns']['bootstrap'] = StaticCDN()
    db.init_app(app)

    from .main import main as main_blueprint
    app.register_blueprint(main_blueprint)

    return app
