package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class PassResetModel {
    private PassResetAccountModel resetAccount;
    private String resetErr;
    public PassResetModel(){}

public PassResetModel(String email, String resetErr){
        this.resetAccount = new PassResetAccountModel(email);
        this.resetErr = resetErr;
}

    public PassResetAccountModel getResetAccount(){return resetAccount;}

    @XmlElement
    public void setResetAccount(PassResetAccountModel resetAccount){this.resetAccount = resetAccount;}

    public String getResetErr(){return resetErr;}

    @XmlElement
    public void setResetErr(String resetErr){this.resetErr = resetErr;}

    @Override
    public String toString(){
        return "PassResetAccountModel value:{ \n " +
                "resetAccount: { \n email=" + resetAccount.getEmail() + '"';
    }
}
