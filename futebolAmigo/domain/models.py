from sqlalchemy import Column, Integer, String

class Time(db.Model):
    id = Column(Integer, primary_key=True)
    nome = Column(String(255))
    cidade = Column(String(255))

class Jogador(db.Model):
    id = Column(Integer, primary_key=True)
    nome = Column(String(255))
    email = Column(String(255))
    telefone = Column(String(255))
    time_id = Column(Integer, ForeignKey('time.id'))

