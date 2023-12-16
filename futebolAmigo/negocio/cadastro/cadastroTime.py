from dados.iRepositorioTime import IRepositorioTime

from utils import SingletonMetaclass

class CadastroTime(metaclass=SingletonMetaclass):
    def __init__(self, repositorio_time):
        self.repositorio_time: IRepositorioTime = repositorio_time

    def cadastrar_time(self, data):
        time = self.repositorio_time.create(data)
        return time

    def editar_time(self, data):
        time = self.repositorio_time.update(data)
        return time
    
    def deletar_time(self, data):
        deleted = self.repositorio_time.delete(data)
        return deleted

    def read_time(self, id_list):
        return self.repositorio_time.read_time(id_list)