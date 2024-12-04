package POJO;

public class ResetAccountModel {
    private String email;

    public ResetAccountModel(){super();}

    public ResetAccountModel (String email){
        this.email = email;
    }

    public String getEmail(){return email;}

    public void setEmail(String email) {
        this.email = email;
    }
}

