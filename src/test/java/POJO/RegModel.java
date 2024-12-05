package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RegModel {
    private RegAccountModel regAccount;
    private String regErr;
    public RegModel(){

    }

    public RegModel(String name, String firstName, String email, String phone, String address, String city, String county, String password, String regErr) {
        this.regAccount = new RegAccountModel(name, firstName, email, phone, address, city, county, password);
        this.regErr = regErr;
    }

    public RegAccountModel getRegAccount(){return regAccount;}

    @XmlElement
    public  void setRegAccount(RegAccountModel account){this.regAccount = account;}

    public String getRegErr() {return regErr;}

    @XmlElement
    public void setRegErr(String regErr) {this.regErr = regErr;}

    @Override
    public  String toString(){
        return "RegModel value: \n" +
                "regAccount:{ \n name=" + regAccount.getName() + ",\n firstName=" + regAccount.getFirstName() +
                ",\n email=" + regAccount.getEmail() + ",\n phone=" + regAccount.getPhone() +
                ",\n address=" + regAccount.getAddress() + ",\n city=" + regAccount.getCity() + ",\n county=" + regAccount.getCounty() +  ",\n password=" +
                regAccount.getPassword() + '}';
    }


}
