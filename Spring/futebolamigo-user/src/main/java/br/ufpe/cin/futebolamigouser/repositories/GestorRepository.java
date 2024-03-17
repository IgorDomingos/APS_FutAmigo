package br.ufpe.cin.futebolamigouser.repositories;

import br.ufpe.cin.futebolamigouser.models.Gestor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GestorRepository extends JpaRepository<Gestor, String> {

    Gestor findByCpfGestor(String cpf);

    void deleteByCpfGestor(String cpf);
}
