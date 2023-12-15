class Time():
    nome: str
    cidade: str
    permissao_edicao: bool
    proprietario: str

    def __init__(self, nome, cidade, permissao_edicao, proprietario):
        self.nome = nome
        self.cidade = cidade
        self.permissao_edicao = permissao_edicao
        self.proprietario = proprietario
