package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegistrationModel {
    private RegistrationAccountModel regAccount;
    private String regErr;
    public RegistrationModel(){

    }

    public RegistrationModel(String name, String firstName, String email, String phone, String address, String city, String county,String password,String regErr) {
        this.regAccount = new RegistrationAccountModel(name, firstName, email, phone, address, city, county, password);
        this.regErr = regErr;
    }

    public RegistrationAccountModel getRegAccount(){return regAccount;}

    @XmlElement
    public  void setRegAccount(RegistrationAccountModel account){this.regAccount = account;}

    public String getRegErr() {return regErr;}

    @XmlElement
    public void setRegErr(String regErr) {this.regErr = regErr;}

    @Override
    public  String toString(){
        return "RegistrationModel value: \n" +
                "regAccount:{ \n name=" + regAccount.getName() + ",\n firstName=" + regAccount.getFirstName() +
                ",\n email=" + regAccount.getEmail() + ",\n phone=" + regAccount.getPhone() +
                ",\n address=" + regAccount.getAddress() + ",\n city=" + regAccount.getCity() + ",\n county=" + regAccount.getCounty() +  ",\n password=" +
                regAccount.getPassword() + '}';
    }


}
