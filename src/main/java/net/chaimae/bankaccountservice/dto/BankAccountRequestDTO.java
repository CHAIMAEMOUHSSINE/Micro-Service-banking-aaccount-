package net.chaimae.bankaccountservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.chaimae.bankaccountservice.enums.AccountType;

import java.util.Date;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountRequestDTO {

    private String id;
    private Date createAt;
    private Double balance;
    private String currency;
    private AccountType type;
}