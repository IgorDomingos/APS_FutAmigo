package br.ufpe.cin.futebolamigo.repositories;

import br.ufpe.cin.futebolamigo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String username);
}
