package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;

@Getter
@XmlRootElement
public class ProductModel {
    private ProductModelModel prodModel;
    private String modelError;
    public ProductModel() {}

    public ProductModel(String model, int quantity, String modelError) {
        this.prodModel= new ProductModelModel(model, quantity);
        this.modelError = modelError;
    }

    @XmlElement
    public void setProdModel(ProductModelModel prodModel) {this.prodModel = prodModel;}

    @XmlElement
    public void setModelError(String modelError) {this.modelError = modelError;}

    @Override
    public String toString() {
        return "ProductModel value: \n" +
                "prodModel :{ \n model= " + prodModel.getModel() +
                "\n quantity= " + prodModel.getQuantity() + '"';

    }
}
