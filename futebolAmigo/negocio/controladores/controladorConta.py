from utils import SingletonMetaclass

class ControladorConta(metaclass=SingletonMetaclass):
    def __init__(self, cadastroConta, iSubsistemaOAuth2):
        self.__cadastroConta = cadastroConta
        self.__iSubsistemaOAuth2 = iSubsistemaOAuth2

    def get_user_by_email(self, email):
        user = self.__cadastroConta.get_by_email(email)
        if user:
            return user
        else:
            return {'error': 'usuário não encontrado'}, 404

    def efetuarLoginOAuth2(self, credentials):
        usuário = self.__iSubsistemaOAuth2.validarLogin(credentials)
        if usuário:
            return usuário
        else:
            return {'error': 'e-mail ou senha inválidos'}, 401