package net.chaimae.bankaccountservice.entities;

import jakarta.persistence.*;
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
    @ManyToOne
    private customer customer;
}
