package br.ufpe.cin.futebolamigotime.repositories;

import br.ufpe.cin.futebolamigotime.models.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRepository extends JpaRepository<Local, String> {
}
