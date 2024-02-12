package br.ufpe.cin.futebolamigo.repositories;

import br.ufpe.cin.futebolamigo.models.Time.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimeRepository extends JpaRepository<Time, Long> {
    Optional<Time> findByNome(String nome);
}
