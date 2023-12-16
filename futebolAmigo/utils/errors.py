class CamposVaziosError(Exception):
    def __init__(self, campos):
        self.campos = campos

    def __str__(self):
        return f'Existem campos não preenchidos: {", ".join(self.campos)}.'