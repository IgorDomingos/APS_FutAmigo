from sqlalchemy import Column, Integer, String, ForeignKey, Table, Date, JSON
from sqlalchemy.orm import relationship
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()

class ContaPadrao(Base):
    __tablename__ = 'conta_padrao'
    
    id = Column(Integer, primary_key=True)
    email = Column(String)
    cpf = Column(String)
    nome = Column(String)

    discriminator = Column(String)  # Discriminator column for identifying user types
    __mapper_args__ = {
        'polymorphic_identity': 'conta_padrao',
        'polymorphic_on': discriminator
    }

    def __init__(
            self,
            email: str,
            cpf: str,
            nome: str) -> None:
        self.email = email
        self.cpf = cpf
        self.nome = nome

    def __repr__(self) -> str:
        return f'<User {self.id}: {self.email}>'
    

class ContaGestor(ContaPadrao):
    __tablename__ = 'conta_gestor'
    
    id = Column(Integer, ForeignKey('conta_padrao.id'), primary_key=True)
    proprietario = Column(String)

    discriminator = Column(String, default='conta_gestor')
    __mapper_args__ = {
        'polymorphic_identity': 'conta_gestor',
    }
    time = relationship('Time', back_populates='gestor')

    def __init__(self, proprietario: str, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.proprietario = proprietario


class ContaJogador(ContaPadrao):
    __tablename__ = 'conta_jogador'

    id = Column(Integer, ForeignKey('conta_padrao.id'), primary_key=True)
    idade = Column(String)
    peso = Column(String)
    altura = Column(String)
    posicao = Column(String)
    discriminator = Column(String, default='conta_jogador')
    __mapper_args__ = {
        'polymorphic_identity': 'conta_jogador',
    }
    time = relationship('Time', back_populates='jogador')

    def __init__(self, idade: int, peso: int, altura: int, posicao: str, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.idade = idade
        self.peso = peso
        self.altura = altura
        self.posicao = posicao

