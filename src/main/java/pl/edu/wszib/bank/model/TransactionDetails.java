package pl.edu.wszib.bank.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "ttransaction")
public class TransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne(fetch = FetchType.EAGER)
    private Account account;
    private Double transferAmount;
    private LocalDate date;

    public TransactionDetails(int id, String title, Account account, Double transAmount) {
        this.id = id;
        this.title = title;
        this.account = account;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
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
