package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegistrationModel {
    private RegistrationAccountModel account;
    private String regErr;
    public RegistrationModel(){

    }

    public RegistrationModel(String name, String firstName, String email, String phone, String address, String city, String password,String regErr) {
        this.account = new RegistrationAccountModel(name, firstName, email, phone, address,city, password);
        this.regErr = regErr;
    }

    public RegistrationAccountModel getAccount(){return account;}

    @XmlElement
    public  void setAccount(RegistrationAccountModel account){this.account = account;}

    public String getRegErr() {return regErr;}

    @XmlElement

    public void setRegErr(String regErr) {this.regErr = regErr;}

    @Override
    public  String toString(){
        return "RegistrationModel value: \n" +
                "account:{ \n name=" + account.getName() + ",\n firstName=" + account.getFirstName() +
                ",\n email=" + account.getEmail() + ",\n phone=" + account.getPhone() +
                ",\n address=" + account.getAddress() + ",\n city=" + account.getCity() + ",\n password=" +
                account.getPassword() + '}';
    }


}
