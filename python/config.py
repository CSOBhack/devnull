class Config:
    SECRET_KEY = 'sdjgkljdkjfksjkgjkdfklfjgkldfjgkld'
    SQLALCHEMY_COMMIT_ON_TEARDOWN = True
    APP_NAME = 'Devnull'
    APP_VERSION = '1.0'
    BOOTSTRAP_SERVE_LOCAL = True

    @staticmethod
    def init_app(app):
        pass


class DevelopmentConfig(Config):
    DEBUG = True
    BOOTSTRAP_SERVE_LOCAL = True

    # SQLALCHEMY_DATABASE_URI = 'postgresql://uploader:tseuploader007@bsd/uploader_dev'

config = {
    'development': DevelopmentConfig
}
