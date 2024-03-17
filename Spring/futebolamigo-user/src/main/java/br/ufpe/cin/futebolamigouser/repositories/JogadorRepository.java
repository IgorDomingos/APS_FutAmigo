package br.ufpe.cin.futebolamigouser.repositories;

import br.ufpe.cin.futebolamigouser.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, String> {
    void deleteByCpf(String cpf);

    Jogador findByCpf(String cpf);

//    List<Jogador> findByTimeId(Long timeId);
}
