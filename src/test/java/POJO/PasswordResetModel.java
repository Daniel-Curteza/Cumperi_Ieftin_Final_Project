package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class PasswordResetModel {
    private PasswordResetAccountModel resetAccount;
    private String resetErr;
    public PasswordResetModel(){}

public PasswordResetModel(String email, String resetErr){
        this.resetAccount = new PasswordResetAccountModel(email);
        this.resetErr = resetErr;
}

    public PasswordResetAccountModel getResetAccount(){return resetAccount;}

    @XmlElement
    public void setResetAccount(PasswordResetAccountModel resetAccount){this.resetAccount = resetAccount;}

    public String getResetErr(){return resetErr;}

    @XmlElement
    public void setResetErr(String resetErr){this.resetErr = resetErr;}

    @Override
    public String toString(){
        return "PasswordResetAccountModel value:{ \n " +
                "resetAccount: { \n email=" + resetAccount.getEmail() + '"';
    }
}
