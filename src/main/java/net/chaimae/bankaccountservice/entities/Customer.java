package net.chaimae.bankaccountservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer")
    private List<BankAccount> bankAccounts;
}