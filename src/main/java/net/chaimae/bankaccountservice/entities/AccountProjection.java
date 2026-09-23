package net.chaimae.bankaccountservice.entities;

import net.chaimae.bankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

import java.net.InterfaceAddress;

@Projection(types=BankAccount.class , name="C1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public String getBalance();

}
