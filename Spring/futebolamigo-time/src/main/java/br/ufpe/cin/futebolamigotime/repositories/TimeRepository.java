package br.ufpe.cin.futebolamigotime.repositories;

import br.ufpe.cin.futebolamigotime.models.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimeRepository extends JpaRepository<Time, Long> {
    Time findByNome(String nome);

    void deleteByNome(String nome);
}
