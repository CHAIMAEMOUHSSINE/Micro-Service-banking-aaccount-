package net.chaimae.bankaccountservice.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.chaimae.bankaccountservice.dto.BankAccountRequestDTO;
import net.chaimae.bankaccountservice.dto.BankAccountResponseDTO;
import net.chaimae.bankaccountservice.entities.BankAccount;
import net.chaimae.bankaccountservice.enums.AccountType;
import net.chaimae.bankaccountservice.repositories.BankAccountRepository;
import net.chaimae.bankaccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class BankAccountGraphQlController {
    @Autowired
    private BankAccountRepository bankAccountRepository ;
    @Autowired
    public AccountService accountService;
    @QueryMapping
    public List<BankAccount> accountsList() {
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccounById(String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(String.format("Account %s not found", id))
                );
    }
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {

        return accountService.addAccount(bankAccount);
    }


/*record BankAccountDTO (Double balance, String currency, String type) {}*/

}
