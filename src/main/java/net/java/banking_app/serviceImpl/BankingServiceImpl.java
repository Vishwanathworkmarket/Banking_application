package net.java.banking_app.serviceImpl;

import net.java.banking_app.entity.Accounts;
import net.java.banking_app.repository.BankingRepository;
import net.java.banking_app.service.BankingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BankingServiceImpl implements BankingService {

    private BankingRepository bankingRepository;

    public BankingServiceImpl(BankingRepository bankingRepository) {
        this.bankingRepository = bankingRepository;
    }


    @Override
    public List<Accounts> saveAccounts(List<Accounts> accounts) {
       return bankingRepository.saveAll(accounts);
    }

    @Override
    public Accounts getAccountById(int id) {
        return bankingRepository.getReferenceById(id);
    }

    @Override
    public List<Accounts> getAllAccounts() {
       return bankingRepository.findAll();

    }

    @Override
    public void deleteAccount(int id) {
      Accounts accounts =  bankingRepository.getReferenceById(id);
      bankingRepository.delete(accounts);
    }

    @Override
    public Accounts depositAccount(int id, BigDecimal amount) {
       Accounts acc =  bankingRepository.getReferenceById(id);
        BigDecimal current = acc.getBalance() == null ? BigDecimal.ZERO : acc.getBalance();
        acc.setBalance(current.add(amount));
        Accounts save = bankingRepository.save(acc);

        return save;
    }

    @Override
    public Accounts withdrawAmount(int id, BigDecimal amount) {
        Accounts accounts = bankingRepository.getReferenceById(id);
        BigDecimal current1 = accounts.getBalance() == null ? BigDecimal.ZERO : accounts.getBalance();
        accounts.setBalance(current1.subtract(amount));
        Accounts save1 = bankingRepository.save(accounts);

        return save1;
    }

    @Override
    public Accounts transferAmount(int fromId, int toId, BigDecimal amount) {
         Accounts first = bankingRepository.getReferenceById(fromId);
         Accounts second = bankingRepository.getReferenceById(toId);

        BigDecimal fromBal =  first.getBalance();
        BigDecimal toBal = second.getBalance();
        BigDecimal amt = amount;

        first.setBalance(fromBal.subtract(amt));
        second.setBalance(toBal.add(amt));

        bankingRepository.save(first);
        bankingRepository.save(second);

        return first;
    }


}



