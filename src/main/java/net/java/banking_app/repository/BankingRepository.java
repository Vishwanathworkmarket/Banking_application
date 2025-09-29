package net.java.banking_app.repository;

import net.java.banking_app.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingRepository extends JpaRepository<Accounts, Integer> {

}
