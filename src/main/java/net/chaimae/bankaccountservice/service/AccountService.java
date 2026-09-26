package net.chaimae.bankaccountservice.service;


import net.chaimae.bankaccountservice.dto.BankAccountRequestDTO;
import net.chaimae.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO request);

    BankAccountResponseDTO updateAccount(
            String id, BankAccountRequestDTO bankAccountRequestDTO);
}
