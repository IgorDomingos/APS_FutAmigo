from utils import SingletonMetaclass
from negocio.cadastro.cadastroTime import CadastroTime

class ControladorTime(metaclass=SingletonMetaclass):
  def __init__(self, cadastro_time: CadastroTime) -> None:
    self.cadastro_time = cadastro_time

  def cadastrar_time(self, data):
    novo_time = self.cadastro_time.cadastrar_time(data)
    if novo_time:
      return novo_time
    else:
      return False

  def editar_time(self, data):
    novo_time = self.cadastro_time.editar_time(data)
    return novo_time

  def deletar_time(self, data):
    deleted = self.cadastro_time.deletar_time(data)
    return deleted

