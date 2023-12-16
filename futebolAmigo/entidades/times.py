from sqlalchemy import Column, Integer, String, ForeignKey, relationship
from sqlalchemy.orm import relationship
from sqlalchemy.ext.declarative import declarative_base
from .contas import ContaJogador, ContaGestor, ContaPadrao

Base = declarative_base()

class Time(Base):
    __tablename__ = 'time'

    id = Column(Integer, primary_key=True)
    nome = Column(String)
    cidade = Column(String)

    # Relacionamento com o gestor utilizando o atributo 'proprietario' da ContaGestor
    gestor_id = Column(Integer, ForeignKey('conta_padrao.id'))
    gestor = relationship(ContaGestor, back_populates='time')

    # Relacionamento com os jogadores utilizando a tabela intermediária 'time_jogador'
    jogadores = relationship(
        ContaJogador,
        secondary='time_jogador',
        back_populates='times'
    )

    def __init__(self, nome: str, cidade: str, gestor: ContaGestor):
        self.nome = nome
        self.cidade = cidade
        self.gestor = gestor

    def adicionar_jogador(self, jogador: ContaJogador):
        # Adiciona o jogador à lista de jogadores do time
        self.jogadores.append(jogador)

        # Adiciona o time à lista de times do jogador
        jogador.times.append(self)

    def __repr__(self):
        return f'<Time {self.id}: {self.nome}>'

# Define a tabela intermediária 'time_jogador' para o relacionamento muitos-para-muitos entre Time e ContaJogador
class TimeJogador(Base):
    __tablename__ = 'time_jogador'

    time_id = Column(Integer, ForeignKey('time.id'), primary_key=True)
    jogador_id = Column(Integer, ForeignKey('conta_padrao.id'), primary_key=True)

    time = relationship(Time, back_populates='jogadores')
    jogador = relationship(ContaJogador, back_populates='times')

