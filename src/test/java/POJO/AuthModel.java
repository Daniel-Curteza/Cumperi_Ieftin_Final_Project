package POJO;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthModel {
    private AuthAccountModel authAccount;
    private  String authErr;
    public AuthModel(){}

    public AuthModel(String email, String password, String name, String loginErr) {
        this.authAccount = new AuthAccountModel(email, password, name);
        this.authErr = loginErr;
    }
    public AuthAccountModel getAuthAccount(){return authAccount;}

    @XmlElement
    public void setAuthAccount(AuthAccountModel authAccount) {
        this.authAccount = authAccount;
    }

    public String getAuthErr() {return authErr;}

    @XmlElement
    public void setAuthErr(String authErr) {
        this.authErr = authErr;
    }

    @Override
    public String toString() {
        return "AuthModel value: {\n" +
                "authAccount:{ \n email=" + authAccount.getEmail() +
                ",\n password=" + authAccount.getPassword() +
                "\n name=" + authAccount.getName() + '}';
    }
}


