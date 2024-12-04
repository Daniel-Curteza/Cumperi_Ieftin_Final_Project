package POJO;

public class PasswordResetAccountModel {
    private String email;

    public PasswordResetAccountModel(){super();}

    public PasswordResetAccountModel(String email){
        this.email = email;
    }

    public String getEmail(){return email;}

    public void setEmail(String email) {
        this.email = email;
    }
}

