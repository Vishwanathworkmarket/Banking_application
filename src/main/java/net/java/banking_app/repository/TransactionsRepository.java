package net.java.banking_app.repository;

import net.java.banking_app.entity.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<TransactionHistory, Integer> {
    List<TransactionHistory> findAccountByIdOrderByTimeStampDesc(int accountId);
}
