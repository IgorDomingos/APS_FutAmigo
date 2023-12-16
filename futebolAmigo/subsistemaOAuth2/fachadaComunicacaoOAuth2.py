import requests
import json
from requests import Session
from requests.exceptions import HTTPError
from oauth2client.client import OAuth2WebServerFlow
from utils import SingletonMetaclass

class OAuth2(metaclass=SingletonMetaclass):
    def __init__(self, config):
        # Configure OAuth2 flow using client ID, secret, scopes, etc.
        self.flow = OAuth2WebServerFlow(client_id=config['client_id'],
                                         client_secret=config['client_secret'],
                                         scope=config['scopes'],
                                         redirect_uri=config['redirect_uri'])

    def validarLogin(self, token):
        try:
            credentials = self.flow.step2_exchange(token)
            # Use credentials to get user info from Google endpoint
            user_info = ...

            return user_info
        except Exception as e:
            raise HTTPError(401, 'Token inválido')

