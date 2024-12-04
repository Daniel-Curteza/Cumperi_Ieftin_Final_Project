package POJO;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthenticationModel {
    private AuthenticationAccountModel authAccount;
    private  String authErr;
    public AuthenticationModel(){

    }

    public AuthenticationModel(String email, String password, String name, String loginErr) {
        this.authAccount = new AuthenticationAccountModel(email, password, name);
        this.authErr = loginErr;
    }
    public AuthenticationAccountModel getAuthAccount(){return authAccount;}

    @XmlElement
    public void setAuthAccount(AuthenticationAccountModel authAccount) {
        this.authAccount = authAccount;
    }

    public String getAuthErr() {return authErr;}

    @XmlElement
    public void setAuthErr(String authErr) {
        this.authErr = authErr;
    }

    @Override
    public String toString() {
        return "AuthenticationModel value: {\n" +
                "authAccount:{ \n email=" + authAccount.getEmail() + ",\n password=" + authAccount.getPassword() +
                "\n name=" + authAccount.getName() + '}';
    }
}


