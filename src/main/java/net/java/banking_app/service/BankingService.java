package net.java.banking_app.service;

import net.java.banking_app.entity.Accounts;
import net.java.banking_app.entity.TransactionHistory;

import java.math.BigDecimal;
import java.util.List;

public interface BankingService {

    public List<Accounts> saveAccounts(List<Accounts> accounts);

    public Accounts getAccountById(int id);

    public List<Accounts> getAllAccounts();

    public void deleteAccount(int id);

    public Accounts depositAccount(int id, BigDecimal amount);

    public Accounts withdrawAmount(int id, BigDecimal amount);

    public Accounts transferAmount(int fromId, int toId, BigDecimal  amount);

    public List<TransactionHistory> getTransactions();

    public List<TransactionHistory> getTransactionByAccountId(int accountId);
}
