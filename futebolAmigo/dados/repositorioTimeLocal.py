from .iRepositorioTime import IRepositorioTime
from entidades import times


class RepositorioTimeLocal(IRepositorioTime):
    def __init__(self):
        self._times = []
        self._count = len(self._times) + 1

    def create(self, data):
        time = times(**data)
        time.id = self._count
        self._count += 1
        self._times.append(time)
        return time

    def read(self, id):
        for time in self._times:
            if time.id == id:
                return time
        return None

    def update(self, id, data):
        for time in self._times:
            if time.id == id:
                for key, value in data.items():
                    setattr(time, key, value)
                return True
        # TODO Retornar erro de objeto não encontrado
        return False

    def delete(self, id):
        for i, item in enumerate(self._times):
            if item.id == id:
                del self._times[i]
                return True
        # TODO Retornar erro de objeto não encontrado
        return False