package POJO;

public class ModelModel {
    private String model;
    private String quantity;

    public ModelModel() {super();}

    public ModelModel(String model, String quantity) {
        this.model = model;
        this.quantity = quantity;
    }

    public String getModel(){return model;}
    public void setModel(String model) {this.model = model;}

    public String getQuantity(){return quantity;}
    public void setQuantity(String quantity) {this.quantity = quantity;}
}
