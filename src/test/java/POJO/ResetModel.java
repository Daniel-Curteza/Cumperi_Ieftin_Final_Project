package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class ResetModel {
    private ResetAccountModel resetAccount;
    private String resetErr;
    public ResetModel(){}

public ResetModel (String email, String resetErr){
        this.resetAccount = new ResetAccountModel(email);
        this.resetErr = resetErr;
}

    public ResetAccountModel getResetAccount(){return resetAccount;}

    @XmlElement
    public void setResetAccount(ResetAccountModel resetAccount){this.resetAccount = resetAccount;}

    public String getResetErr(){return resetErr;}

    @XmlElement
    public void setResetErr(String resetErr){this.resetErr = resetErr;}

    @Override
    public String toString(){
        return "ResetAccountModel value:{ \n +" +
                "resetAccount: { \n email=" + resetAccount.getEmail() + '"';
    }
}
