from abc import ABC, abstractmethod

class AbstractRepositoryFactory(ABC):
    @abstractmethod
    def create_usuario_repository(self) -> UsuarioRepository:
        pass

    @abstractmethod
    def create_time_repository(self) -> TimeRepository:
        pass

    @abstractmethod
    def create_jogador_repository(self) -> JogadorRepository:
        pass