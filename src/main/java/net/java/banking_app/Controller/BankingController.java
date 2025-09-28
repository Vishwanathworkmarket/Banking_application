package net.java.banking_app.Controller;

import net.java.banking_app.entity.Accounts;
import net.java.banking_app.exception.AccountNotFoundException;
import net.java.banking_app.service.BankingService;
import net.java.banking_app.serviceImpl.BankingServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@RestController
public class BankingController {

    private BankingService bankingService;

    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @PostMapping(value = "/saveAccounts")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveAcounts(@RequestBody List<Accounts> accounts) {
//        List<Accounts> accounts = Arrays.asList(
//                new Accounts("Vishwanath", new BigDecimal("900000.00")),
//                new Accounts("Mallesh", new BigDecimal("900000.00"))
//        );
        bankingService.saveAccounts(accounts);
    }

    @GetMapping("/accounts/{id}")
    public Accounts getAccountById(@PathVariable("id") int id) {
        if (id < 0) {
            throw new AccountNotFoundException("Account Id Not Found" +id);
        }
        return bankingService.getAccountById(id);
    }

    @GetMapping("/getAllAcounts")
    public List<Accounts> getAllAccounts() {
        return bankingService.getAllAccounts();
        }

    @DeleteMapping("/account/delete/{id}")
    public void removeAccount(@PathVariable("id") int id) {
      bankingService.deleteAccount(id);
    }

    @PutMapping("/depositAmount/{id}")
    public Accounts depositAmount(@PathVariable("id") int id, @RequestBody BigDecimal amount) {
        return bankingService.depositAccount(id, amount);
    }

    @PutMapping("/withdrawAmount/{id}")
    public Accounts withdrawAmount(@PathVariable("id") int id, @RequestBody BigDecimal amount) {
        return bankingService.withdrawAmount(id, amount);
    }

    @PutMapping("/depositAmount")
    public Accounts transferAmount(@RequestParam("fromId") int fromId,
                                   @RequestParam("toId") int toId,
                                   @RequestBody BigDecimal amount) {
        return bankingService.transferAmount(fromId, toId, amount);
    }




}