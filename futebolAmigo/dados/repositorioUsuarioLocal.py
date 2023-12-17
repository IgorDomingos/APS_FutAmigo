from .iRepositorioUsuario import IRepositorioUsuario
from entidades import ContaPadrao, ContaGestor, ContaJogador

from datetime import date

class RepositorioUsuarioLocal(IRepositorioUsuario):
    def __init__(self): 
        conta_padrao_inicial = ContaPadrao('idrs@cin.ufpe.br', '87200887200', 'Igor Domingos da Rocha e Silva')
        self._contas = [conta_padrao_inicial]
        self._count = len(self._contas) + 1

    def create(self, data):
        nova_conta = ContaPadrao(**data)
        self._contas.append(nova_conta)
        self._count += 1
        return nova_conta

    def create_gestor(self, data):
        nova_conta = ContaGestor(**data)
        self._contas.append(nova_conta)
        self._count += 1
        return nova_conta

    def create_jogador(self, data):
        nova_conta = ContaJogador(**data)
        self._contas.append(nova_conta)
        self._count += 1
        return nova_conta

    def read(self, id):
        for item in self.data:
            if item.id == id:
                return item
        return None

    def update(self, id, data):
        for conta in self._contas:
            if conta.id == id:
                for key, value in data.items():
                    setattr(conta, key, value)
                return True
        # TODO Retornar erro de objeto não encontrado
        return False

    def delete(self, id):
        for i, item in enumerate(self._contas):
            if item.id == id:
                del self.data[i]
                return True
        # TODO Retornar erro de objeto não encontrado
        return False

    def get_by_id(self, id): #"get_by_email"
        for item in self._contas:
            if item.id == id:
                return item
        return None