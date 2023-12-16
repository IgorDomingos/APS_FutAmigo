from oauth2client.client import OAuth2WebServerFlow
from utils import SingletonMetaclass
from negocio.controladores.controladorConta import ControladorConta
from negocio.cadastro.cadastroConta import CadastroConta

class iSubsistemaOAuth2(metaclass=SingletonMetaclass):
    def __init__(self, config):
        # Configure o fluxo OAuth2
        self.flow = OAuth2WebServerFlow(
            client_id=config['client_id'],
            client_secret=config['client_secret'],
            scope=config['scopes'],
            redirect_uri=config['redirect_uri'])

    def validarToken(self, token):
        try:
            # Verifica a validade do token
            credentials = self.flow.step2_exchange(token)
            # Obtém informações do usuário
            user_info = credentials.getuserinfo()
            return user_info
        except Exception as e:
            # Trata o erro
            print(e)
            return None

# ...

controlador_conta = ControladorConta(CadastroConta, iSubsistemaOAuth2(config))

def efetuarLogin(request):
    token = request.headers.get('Authorization')
    usuario = controlador_conta.efetuarLoginOAuth2(token)
    # ...

