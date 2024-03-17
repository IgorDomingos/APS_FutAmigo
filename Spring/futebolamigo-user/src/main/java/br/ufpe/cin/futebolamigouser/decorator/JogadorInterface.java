package br.ufpe.cin.futebolamigouser.decorator;

//import br.ufpe.cin.futebolamigouser.models.Time;
import br.ufpe.cin.futebolamigouser.models.User;

public interface JogadorInterface {
    String getCpf();
//    Time getTime();
    User getUser();
    String getIdade();
    double getPeso();
    double getAltura();
    String getPosicao();
    void updateSkills(String cpf, String skills);

    void setSkills(String skills);
}
