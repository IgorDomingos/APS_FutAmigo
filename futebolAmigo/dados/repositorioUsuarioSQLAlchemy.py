from .iRepositorioUsuario import IRepositorioUsuario
from entidades import ContaPadrao, ContaGestor, ContaJogador
from sqlalchemy.orm import joinedload

class RepositorioUsuarioSQLAlchemy(IRepositorioUsuario):
    def __init__(self, Session):
        self.Session = Session

    def create(self, data):
        with self.Session() as session:
            nova_conta = ContaPadrao(**data)
            session.add(nova_conta)
            session.commit()
            return nova_conta

    def create_gestor(self, data):
        with self.Session() as session:
            nova_conta = ContaGestor(**data)
            session.add(nova_conta)
            session.commit()
            return nova_conta

    def create_jogador(self, data):
        with self.Session() as session:
            nova_conta = ContaJogador(**data)
            session.add(nova_conta)
            session.commit()
            return nova_conta

    def read(self, id):
        with self.Session() as session:
            return session.query(ContaPadrao).filter_by(id=id).first()

    def update(self, id, data):
        with self.Session() as session:
            conta = session.query(ContaPadrao).filter_by(id=id).first()
            if conta:
                pass
            else:
                # Retornar um erro caso a conta não exista
                pass

    def delete(self, id):
        with self.Session() as session:
            conta = session.query(ContaPadrao).filter_by(id=id).first()
            if conta:
                session.delete(conta)
                session.commit()
                return True
            else:
                # fazer um raise
                return False

    def get_by_id(self, id):
        with self.Session() as session:
            return session.query(ContaPadrao).filter_by(id=id).options(joinedload('*')).first()