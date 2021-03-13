package pl.edu.wszib.bank.model.view;

public class InnerTransModel {
    private Double amount;

    public InnerTransModel(Double amount) {
        this.amount = amount;
    }

    public InnerTransModel() {
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }
}
