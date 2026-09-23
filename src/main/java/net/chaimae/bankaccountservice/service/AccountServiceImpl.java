package net.chaimae.bankaccountservice.service;

import jakarta.transaction.Transactional;
import net.chaimae.bankaccountservice.dto.BankAccountRequestDTO;
import net.chaimae.bankaccountservice.dto.BankAccountResponseDTO;
import net.chaimae.bankaccountservice.entities.BankAccount;
import net.chaimae.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static org.springframework.data.util.TypeUtils.type;

@Service
@Transactional
public class AccountServiceImpl  implements AccountService {
    @Override

    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountRequestDTO.getType())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = BankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = BankAccountResponseDTO.builder()
                .id(saveBankAccount.getId())
                .type(saveBankAccount.getType())
                .balance(saveBankAccount.getBalance())
                .currency(saveBankAccount.getCurrency())
                .build();
        return bankAccountResponseDTO;


        return null;
    }

}

