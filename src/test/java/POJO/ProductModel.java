package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductModel {
    private ProductModelModel prodModel;
    private String modelError;
    public ProductModel() {}

    public ProductModel(String model, String quantity, String modelError) {
        this.prodModel= new ProductModelModel(model, quantity);
        this.modelError = modelError;
    }

    public ProductModelModel getProdModel() {return prodModel;}

    @XmlElement
    public void setProdModel(ProductModelModel prodModel) {this.prodModel = prodModel;}

    public String getModelError() {return modelError;}

    @XmlElement
    public void setModelError(String modelError) {this.modelError = modelError;}

    @Override
    public String toString() {
        return "ProductModel value: \n" +
                "prodModel :{ \n model= " + prodModel.getModel() +
                "\n quantity= " + prodModel.getQuantity() + '"';

    }
}
