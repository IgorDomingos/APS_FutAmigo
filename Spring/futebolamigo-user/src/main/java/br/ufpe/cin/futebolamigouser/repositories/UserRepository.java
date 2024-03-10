package br.ufpe.cin.futebolamigouser.repositories;

import br.ufpe.cin.futebolamigouser.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String username);
}
