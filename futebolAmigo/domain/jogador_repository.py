class JogadorRepository():

    def __init__(self, session):
        self.session = session

    def salvar(self, jogador):
        return self.session.add(jogador)

    def encontrar_por_email(self, email):
        return self.session.query(Jogador).filter_by(email=email).first()

    def encontrar_todos(self):
        return self.session.query(Jogador).all()
