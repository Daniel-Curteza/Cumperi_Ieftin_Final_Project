package POJO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductModelModel {
    private String model;
    private int quantity;

    public ProductModelModel() {super();}

    public ProductModelModel(String model, int quantity) {
        this.model = model;
        this.quantity = quantity;
    }

}
