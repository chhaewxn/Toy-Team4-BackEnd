package efub.toy.twitter.account.repository;

import efub.toy.twitter.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Boolean existsByEmail(String email);

    Optional<Account> findByEmail(String email);
}