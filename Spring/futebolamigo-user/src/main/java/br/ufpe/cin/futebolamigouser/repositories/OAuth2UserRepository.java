package br.ufpe.cin.futebolamigo.repositories;

import br.ufpe.cin.futebolamigo.models.OAuth2User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface OAuth2UserRepository extends JpaRepository<OAuth2User, Long> {
    OAuth2User findByProviderAndProviderId(String provider, String providerId);
}
