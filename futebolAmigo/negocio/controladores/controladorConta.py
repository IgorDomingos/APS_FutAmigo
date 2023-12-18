from utils import SingletonMetaclass
from negocio.cadastro.cadastroConta import CadastroConta

class ControladorConta(metaclass=SingletonMetaclass):
    def __init__(self, cadastroConta):
        self.__cadastroConta = cadastroConta

    def get_user_by_email(self, email):
        user = self.__cadastroConta.get_by_email(email)
        if user:
            return user
        else:
            return {'error': 'usuário não encontrado'}, 404