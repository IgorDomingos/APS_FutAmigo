package br.ufpe.cin.futebolamigo.repositories;

import br.ufpe.cin.futebolamigo.models.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
}
