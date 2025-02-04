package com.thejas.banking.entity;

import java.math.BigDecimal;

import com.thejas.banking.dto.SignupRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.*;

@Entity
@Getter @Setter

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String accountNumber;
    private String accountType; // SAVINGS, CHECKING
    private BigDecimal balance = BigDecimal.ZERO;

    @ManyToOne
    private User owner;

    public Account() {
    }

    public Account(String accountNumber, String accountType, BigDecimal balance, User owner) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.owner = owner;
    }

    public Account(SignupRequest signupRequest) {
        this.accountNumber = signupRequest.getUsername();
        this.accountType = "SAVINGS";
        this.balance = BigDecimal.ZERO;
        this.owner = new User();
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public void transfer(Account recipient, BigDecimal amount) {
        this.withdraw(amount);
        recipient.deposit(amount);
    }

    @Override

    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                ", owner=" + owner +
                '}';
    }

    public void setOwner(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOwner'");
    }

   
}

