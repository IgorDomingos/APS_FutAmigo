from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from entidades import Base
from .repositorioTimeSQLAlchemy import repositorioTimeSQLAlchemy
from .repositorioUsuarioSQLAlchemy import repositorioUsuarioSQLAlchemy
from .repositorioTimeLocal import repositorioTimeLocal
from .repositorioUsuarioLocal import repositorioUsuarioLocal

from abc import ABC, abstractmethod

class AbstractRepositorioFactory(ABC):
    @abstractmethod
    def criar_repositorio_time(self):
        pass

    @abstractmethod
    def criar_repositorio_usuario(self):
        pass

class SQLAlchemyRepositorioFactory(AbstractRepositorioFactory):
    def __init__(self) -> None:
        self.engine = create_engine('sqlite:///futamigo.db')
        Base.metadata.create_all(self.engine)
        self.Session = sessionmaker(bind=self.engine)

    def criar_repositorio_time(self):
        return repositorioTimeSQLAlchemy(Session=self.Session)

    def criar_repositorio_usuario(self):
        return repositorioUsuarioSQLAlchemy(Session=self.Session)
    
class ListRepositorioFactory:
    def criar_repositorio_time(self):
        return repositorioTimeLocal()

    def criar_repositorio_usuario(self):
        return repositorioUsuarioLocal()

