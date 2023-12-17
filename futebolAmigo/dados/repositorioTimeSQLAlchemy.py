from .iRepositorioTime import IRepositorioTime
from entidades import times
from sqlalchemy.orm import joinedload

class RepositorioTimeSQLAlchemy(IRepositorioTime):
    def __init__(self, Session):
        self.Session = Session

    def create(self, data):
        with self.Session() as session:
            novo_time = times(**data)
            session.add(novo_time)
            session.commit()
            novo_time = session.query(times).filter_by(id=novo_time.id).options(joinedload('*')).first()
            return novo_time

    def read(self, id):
        with self.Session() as session:
            return session.query(times).filter_by(id=id).first()

    def update(self, id, data):
        with self.Session() as session:
            time = session.query(times).filter_by(id=id).first()
            if time:
                for key, value in data.items():
                    setattr(time, key, value)
                session.commit()
            else:
                #TODO lembrar de levantar um erro caso a cadeira não exista
                pass

    def delete(self, id):
        with self.Session() as session:
            time = session.query(times).filter_by(id=id).first()
            if time:
                session.delete(time)
                session.commit()
                return True
            else:
                # TODO fazer um raise
                return False

    def read_id_in_list(self, id_list):
        with self.Session() as session:
            return {time.id: time for time in session.query(times).filter(times.id.in_(id_list)).all()}