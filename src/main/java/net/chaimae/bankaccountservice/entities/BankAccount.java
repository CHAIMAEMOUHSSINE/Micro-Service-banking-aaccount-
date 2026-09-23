package net.chaimae.bankaccountservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.chaimae.bankaccountservice.enums.AccountType;

import java.util.Date;
@Entity
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class BankAccount {
    @Id
    private String id;
    private Date createAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
}
