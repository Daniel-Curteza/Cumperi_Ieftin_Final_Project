package POJO;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ComparisonModel {
    private ProdComparisonModel comparisonModel;
    private String emptyErr;
    public ComparisonModel() {}

    public ComparisonModel(String model1, String model2, String errorMessage) {
        this.comparisonModel = new ProdComparisonModel(model1, model2);
        this.emptyErr = errorMessage;
    }

    public ProdComparisonModel getComparisonModel() { return comparisonModel; }

    @XmlElement
    public void setProdComparisonModel(ProdComparisonModel comparisonModel) {this.comparisonModel = comparisonModel;}

    public String getEmptyErr() {return emptyErr;}

    @XmlElement
    public void setEmptyErr(String emptyErr) {this.emptyErr = emptyErr;}

    @Override
    public String toString() {
        return "ComparisonModel value: {\n" +
        "comparisonModel :{ \n model1=" + comparisonModel.getModel1() +
                ",\n model2=" + comparisonModel.getModel2() + "}";
    }
}
