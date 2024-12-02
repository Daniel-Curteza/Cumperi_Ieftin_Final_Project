package POJO;

public class RegistrationAccountModel {
    private String name;
    private String firstName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String password;

    public RegistrationAccountModel(){
        super();
    }

    public RegistrationAccountModel(String name, String firstName, String email, String phone, String address, String city, String password){
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.password = password;

    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

}
