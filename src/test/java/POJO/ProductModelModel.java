package POJO;

public class ProductModelModel {
    private String model;
    private String quantity;

    public ProductModelModel() {super();}

    public ProductModelModel(String model, String quantity) {
        this.model = model;
        this.quantity = quantity;
    }

    public String getModel(){return model;}
    public void setModel(String model) {this.model = model;}

    public String getQuantity(){return quantity;}
    public void setQuantity(String quantity) {this.quantity = quantity;}

}
