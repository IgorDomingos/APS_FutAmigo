from futebolAmigo.domain.abstract_repository_factory import AbstractRepositoryFactory

class GestorRepositoryFactory(AbstractRepositoryFactory):
  def criar_time_repository(self) -> TimeRepository:
    return GestorTimeRepository()

  def criar_jogador_repository(self) -> JogadorRepository:
    return GestorJogadorRepository()