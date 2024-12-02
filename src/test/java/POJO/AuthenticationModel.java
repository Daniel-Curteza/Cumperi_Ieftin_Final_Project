package POJO;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthenticationModel {
    private AuthenticationAccountModel account;
    private  String authErr;
    public AuthenticationModel(){

    }

    public AuthenticationModel(String email, String password, String name, String loginErr) {
        this.account = new AuthenticationAccountModel(email, password, name);
        this.authErr = loginErr;
    }
    public AuthenticationAccountModel getAccount(){return account;}

    @XmlElement
    public void setAccount(AuthenticationAccountModel account) {
        this.account = account;
    }

    public String getAuthErr() {return authErr;}

    @XmlElement
    public void setAuthErr(String authErr) {
        this.authErr = authErr;
    }

    @Override
    public String toString() {
        return "AuthenticationModel value: {\n" +
                "account:{ \n email=" + account.getEmail() + ",\n password=" + account.getPassword() +
                "\n name=" + account.getName() + '}';
    }
}


