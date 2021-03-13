package pl.edu.wszib.bank.model.view;

public class NewPassModel {
    private String old_pass;
    private String new_pass;
    private String new_pass2;

    public NewPassModel(String oldpass, String npass, String npass2) {
        this.old_pass = oldpass;
        this.new_pass = npass;
        this.new_pass2 = npass2;
    }

    public NewPassModel() {
    }

    public void setOld_pass(String old_pass) {
        this.old_pass = old_pass;
    }

    public String getOld_pass() {
        return old_pass;
    }

    public void setNew_pass(String new_pass) {
        this.new_pass = new_pass;
    }

    public String getNew_pass() {
        return new_pass;
    }

    public void setNew_pass2(String new_pass2) {
        this.new_pass2 = new_pass2;
    }

    public String getNew_pass2() {
        return new_pass2;
    }
}
