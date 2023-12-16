from utils import SingletonMetaclass

class CadastroConta(metaclass=SingletonMetaclass):
    def __init__(self, repositorio_conta):
        self.repositorio_conta = repositorio_conta

    def busca_conta(self, email):
        user = self.repositorio_conta.busca_conta(email)
        return user