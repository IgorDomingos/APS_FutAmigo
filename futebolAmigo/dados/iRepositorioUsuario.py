from abc import ABC, abstractmethod


class IRepositorioUsuario(ABC):
    @abstractmethod
    def create(self, data):
        pass

    @abstractmethod
    def create_gestor(self, data):
        pass

    @abstractmethod
    def create_jogador(self, data):
        pass

    @abstractmethod
    def read(self, id):
        pass
    
    @abstractmethod
    def update(self, id, data):
        pass
    
    @abstractmethod
    def delete(self, id):
        pass

    @abstractmethod
    def get_by_id(self, id):
        pass

