package pl.edu.wszib.bank.model.view;

public class TransactionModel {
    private String title;
    private String accNumber;
    private Double amount;

    public TransactionModel(String title, String accNumber, Double amount) {
        this.title = title;
        this.accNumber = accNumber;
        this.amount = amount;
    }

    public TransactionModel() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }
}
