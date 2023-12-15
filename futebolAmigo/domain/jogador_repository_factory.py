from futebolAmigo.domain.abstract_repository_factory import AbstractRepositoryFactory

class JogadorRepositoryFactory(AbstractRepositoryFactory):
  def criar_time_repository(self) -> TimeRepository:
    return JogadorTimeRepository()

  def criar_jogador_repository(self) -> JogadorRepository:
    return JogadorJogadorRepository()