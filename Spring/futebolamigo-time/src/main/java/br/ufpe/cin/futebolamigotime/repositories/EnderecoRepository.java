package br.ufpe.cin.futebolamigotime.repositories;

import br.ufpe.cin.futebolamigotime.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
