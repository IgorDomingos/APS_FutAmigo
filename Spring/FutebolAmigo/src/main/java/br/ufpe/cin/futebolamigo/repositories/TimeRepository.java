package br.ufpe.cin.futebolamigo.repositories;

import br.ufpe.cin.futebolamigo.models.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
    Time findByNome(String nome);

    void deleteByNome(String nome);
}
