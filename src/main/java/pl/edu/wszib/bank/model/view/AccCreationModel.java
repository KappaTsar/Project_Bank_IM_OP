package pl.edu.wszib.bank.model.view;

public class AccCreationModel {
    private String chosenLogin;

    public AccCreationModel(String login) {
        this.chosenLogin = login;
    }

    public AccCreationModel() {
    }

    public void setChosenLogin(String chosenLogin) {
        this.chosenLogin = chosenLogin;
    }

    public String getChosenLogin() {
        return chosenLogin;
    }
}
