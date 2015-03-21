from .. import db


class Node(db.Model):
    __tablename__ = 'nodes'

    ip = db.Column(db.String(255))
    name = db.Column(db.String(255))
    node_id = db.Column(db.Integer, primary_key=True)
    parent_id = db.Column(db.Integer)
    users = db.Column(db.Integer)
    events = db.relationship('Event', backref='node')

    @staticmethod
    def all():
        return Node.query.all()


class Event(db.Model):
    __tablename__ = 'events'

    action = db.Column(db.String(255))
    event_id = db.Column(db.Integer, primary_key=True)
    actor_id = db.Column(db.Integer)
    happened_at = db.Column(db.DateTime)
    node_id = db.Column(db.Integer, db.ForeignKey('nodes.node_id'))

    @staticmethod
    def all():
        return Event.query.all()


class Hacker(db.Model):
    __tablename__ = 'hackers'

    name = db.Column(db.String(255))
    hacker_id = db.Column(db.Integer, primary_key=True)
    points = db.Column(db.Integer)

    @staticmethod
    def all():
        return Hacker.query.all()
