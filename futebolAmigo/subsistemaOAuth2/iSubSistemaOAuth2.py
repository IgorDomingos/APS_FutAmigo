from requests import HTTPError
from oauth2client.client import OAuth2WebServerFlow
from utils import SingletonMetaclass
from negocio.controladores.controladorConta import ControladorConta
from negocio.cadastro.cadastroConta import CadastroConta
from oauth2client.client import InsufficientScopeError
from oauth2client.client import TokenExpiredError

class iSubsistemaOAuth2(metaclass=SingletonMetaclass):
    def __init__(self, config):
        # Configure OAuth2 flow
        self.flow = OAuth2WebServerFlow(
            client_id=config['client_id'],
            client_secret=config['client_secret'],
            scope=config['scopes'],
            redirect_uri=config['redirect_uri'])

    def validarToken(self, token):
        try:
            # Verifica a validade do token
            credentials = self.flow.step2_exchange(token)
            # Obtém informações do usuário com base na biblioteca escolhida
            user_info = credentials.getuserinfo()

            # Seleciona informações relevantes
            return {
                'id': user_info['sub'],
                'name': user_info['name'],
                'email': user_info['email'],
            }
        except TokenExpiredError:
            raise HTTPError(401, 'Token expirado')
        except InsufficientScopeError:
            raise HTTPError(403, 'Token com escopo insuficiente')
        except Exception as e:
            print(e)
            raise HTTPError(401, 'Token inválido')

controlador_conta = ControladorConta(CadastroConta, iSubsistemaOAuth2(config))

def efetuarLogin(request):
    token = request.headers.get('Authorization')
    usuario = controlador_conta.efetuarLoginOAuth2(token)
    # ...

