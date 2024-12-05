package POJO;

public class PassResetAccountModel {
    private String email;

    public PassResetAccountModel(){super();}

    public PassResetAccountModel(String email){
        this.email = email;
    }

    public String getEmail(){return email;}

    public void setEmail(String email) {
        this.email = email;
    }
}

