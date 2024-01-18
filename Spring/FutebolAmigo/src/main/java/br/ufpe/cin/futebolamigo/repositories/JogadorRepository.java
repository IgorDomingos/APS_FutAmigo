package br.ufpe.cin.futebolamigo.repositories;

import br.ufpe.cin.futebolamigo.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, String> {
}
