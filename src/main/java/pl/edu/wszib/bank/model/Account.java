package pl.edu.wszib.bank.model;

import javax.persistence.*;
import java.util.Random;
import java.util.Set;

@Entity(name = "taccount")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String accNumber;
    private Double balance;
    @ManyToOne(fetch = FetchType.EAGER)
    private User userID;
    private String bankInfo;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<TransactionDetails> history;

    public Account(int id, User user){
        this.id = id;
        setAccNumber();
        this.balance = 0.0;
        this.userID = user;
        this.bankInfo = "@Frorlduk's_Holding_Union";
    }

    public Account(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setAccNumber() {
        Random random = new Random();
        String accNum = random.ints(48, 58)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(16)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        this.accNumber = "135674667" + this.id%10 + accNum;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setUser(User user) {
        this.userID = user;
    }

    public User getUser() {
        return userID;
    }

    public void setBank(String bank) {
        this.bankInfo = bank;
    }

    public String getBank() {
        return bankInfo;
    }

    public void addnewTransactionToHistory(TransactionDetails transaction) {
        this.history.add(transaction);
    }

    public Set<TransactionDetails> getHistory() {
        return history;
    }
}
