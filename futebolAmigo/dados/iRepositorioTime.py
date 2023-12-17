from abc import ABC, abstractmethod

class IRepositorioTime(ABC):
    @abstractmethod
    def create(self, data):
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
    def get_time(self, id):
        pass