from flask import Flask, request
from flask_cors import CORS
from flask_restful import Api, Resource, reqparse
from presenters import *
from flask_oauthlib.client import OAuth

app = Flask(__name__)
CORS(app)
api = Api(app)

# Configure OAuth
oauth = OAuth(app)

# Create OAuth2 client
google = oauth.register(
    name='google',
    client_id='YOUR_CLIENT_ID',
    client_secret='YOUR_CLIENT_SECRET',
    access_token_url='https://accounts.google.com/o/oauth2/token',
    authorize_url='https://accounts.google.com/o/oauth2/auth',
    userinfo_url='https://www.googleapis.com/oauth2/v3/userinfo'
)

if __name__ == '__main__':
    app.run(debug=True)
