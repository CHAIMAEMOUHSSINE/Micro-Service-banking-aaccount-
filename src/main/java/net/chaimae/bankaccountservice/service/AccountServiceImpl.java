package net.chaimae.bankaccountservice.service;

import jakarta.transaction.Transactional;
import net.chaimae.bankaccountservice.dto.BankAccountRequestDTO;
import net.chaimae.bankaccountservice.dto.BankAccountResponseDTO;
import net.chaimae.bankaccountservice.entities.BankAccount;
import net.chaimae.bankaccountservice.mappers.AccountMapper;
import net.chaimae.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private  BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(
            BankAccountRequestDTO bankAccountRequestDTO) {

        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createAt(new Date())
                .type(bankAccountRequestDTO.getType())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();

        BankAccount saveBankAccount =
                bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBnkAccount(saveBankAccount);

        return accountMapper.fromBnkAccount(saveBankAccount);
    }
    @Override
    public BankAccountResponseDTO updateAccount(
            String id, BankAccountRequestDTO bankAccountRequestDTO) {

        BankAccount bankAccount = BankAccount.builder()
                .id(id)
                .createAt(new Date())
                .type(bankAccountRequestDTO.getType())
                .balance(bankAccountRequestDTO.getBalance())
                .currency(bankAccountRequestDTO.getCurrency())
                .build();

        BankAccount saveBankAccount =
                bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBnkAccount(saveBankAccount);

        return accountMapper.fromBnkAccount(saveBankAccount);
    }}



