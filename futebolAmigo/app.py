import os
from flask import Flask, request, redirect, url_for
from flask_sqlalchemy import SQLAlchemy
from futebolAmigo.domain.usuario import Usuario
from oauth2client.client import OAuth2WebServerFlow
from flask import jsonify
from flask import session
from futebolAmigo import usuario_repository

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = os.environ['DATABASE_URL']
db = SQLAlchemy(app)

# Credenciais do Google
CLIENT_ID = os.environ['CLIENT_ID']
CLIENT_SECRET = os.environ['CLIENT_SECRET']

# Rotas
@app.route('/login', methods=['GET'])
def login():
    # Se o usuário já estiver logado, redirecione para a página inicial
    if session.get('user'):
        return redirect(url_for('index'))

    # Inicie o fluxo de autorização
    flow = OAuth2WebServerFlow(
        CLIENT_ID,
        CLIENT_SECRET,
        'https://www.googleapis.com/auth/userinfo.email',
        'https://www.googleapis.com/auth/userinfo.profile'
    )

    # Redirecione o usuário para o Google para conceder permissão
    return redirect(flow.authorization_url())

@app.route('/login/callback', methods=['GET'])
def login_callback():
    # Obtenha o código de autorização do Google
    code = request.args.get('code')

    # Obter o token de acesso
    access_token, refresh_token, expires_in, token_uri = flow.step2_exchange(code)

    # Criar um usuário
    user = Usuario(
        email=access_token['email'],
        nome=access_token['name'],
        token=access_token['id_token']
    )

    # Salvar o usuário no banco
    db.session.add(user)
    db.session.commit()

    # Salvar o token de acesso na sessão
    session['user'] = user.id

    return redirect(url_for('index'))

@app.route("/cadastro", methods=["POST"])
def cadastro():
    # Pegar os dados do usuário
    email = request.json["email"]
    nome = request.json["nome"]
    papel = request.json["papel"]

    # Validar os dados
    if not email or not nome or not papel:
        return jsonify({"mensagem": "Dados inválidos"})

    # Criar o usuário
    if papel == "jogador":
        altura = request.json["altura"]
        peso = request.json["peso"]
        pe_dominante = request.json["pe_dominante"]
        posicao = request.json["posicao"]
        idade = request.json["idade"]

        if not altura.isdigit():
            return jsonify({"mensagem": "Altura deve ser um número inteiro"})
        if not peso.isdigit():
            return jsonify({"mensagem": "Peso deve ser um número inteiro"})
        if pe_dominante not in ["direito", "esquerdo"]:
            return jsonify({"mensagem": "Pé dominante deve ser 'direito' ou 'esquerdo'"})
        if posicao not in ["goleiro", "zagueiro", "lateral", "volante", "meia", "atacante"]:
            return jsonify({"mensagem": "Posição deve ser 'goleiro', 'zagueiro', 'lateral', 'volante', 'meia' ou 'atacante'"})
        if not idade.isdigit():
            return jsonify({"mensagem": "Idade deve ser um número inteiro"})

        usuario = Usuario(
            email=email,
            nome=nome,
            papel=papel,
            altura=altura,
            peso=peso,
            pe_dominante=pe_dominante,
            posicao=posicao,
            idade=idade
        )
    else:
        usuario = Usuario(
            email=email,
            nome=nome,
            papel=papel
        )

    # Salvar o usuário no banco
    usuario_repository.salvar(usuario)

    return jsonify({"mensagem": "Usuário criado com sucesso"})


@app.route("/jogadores/buscar", methods=["POST"])
def buscar_jogadores():
    email = request.json["email"]

    jogador = jogador_repository.encontrar_por_email(email)

    if jogador is None:
        return jsonify({"mensagem": "Jogador não encontrado"})

    return jsonify(jogador.to_dict())
