package net.chaimae.bankaccountservice.service;

import jakarta.transaction.Transactional;
import net.chaimae.bankaccountservice.dto.BankAccountRequestDTO;
import net.chaimae.bankaccountservice.dto.BankAccountResponseDTO;
import net.chaimae.bankaccountservice.entities.BankAccount;
import net.chaimae.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final BankAccountRepository bankAccountRepository;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccountResponseDTO addAccount(
            BankAccountRequestDTO bankAccountRequestDTO) {

        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .type(bankAccountRequestDTO.getType())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();

        BankAccount saveBankAccount =
                bankAccountRepository.save(bankAccount);

        BankAccountResponseDTO bankAccountResponseDTO =
                BankAccountResponseDTO.builder()
                        .id(saveBankAccount.getId())
                        .type(saveBankAccount.getType())
                        .balance(saveBankAccount.getBalance())
                        .currency(saveBankAccount.getCurrency())
                        .build();

        return bankAccountResponseDTO;
    }
}