package br.ufpe.cin.futebolamigotime.repositories;

import br.ufpe.cin.futebolamigotime.models.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
}
