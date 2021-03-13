package pl.edu.wszib.bank.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "ttransaction")
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @OneToOne(fetch = FetchType.EAGER)
    private Account fromAccount;
    @OneToOne(fetch = FetchType.EAGER)
    private Account toAccount;
    private Double transferAmount;
    @Temporal(TemporalType.TIME)
    private LocalDate date;

    public TransactionDetails(int id, String title, Account fromAccount, Account toAccount, Double transAmount) {
        this.id = id;
        this.title = title;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.transferAmount = transAmount;
        this.date = LocalDate.now();;
    }

    public TransactionDetails() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setTransferAmount(Double transAmount) {
        this.transferAmount = transAmount;
    }

    public Double getTransferAmount() {
        return transferAmount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
