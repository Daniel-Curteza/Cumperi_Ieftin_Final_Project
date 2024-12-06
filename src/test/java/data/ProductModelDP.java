package data;

import POJO.ProductModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ProductModelDP {
    @DataProvider(name = "productModelJsonDataProvider")
    public Iterator<Object[]> productModelJsonDataProvider() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

        File jsonFile = new File("src/test/resources/testData/ProductModelTestData.json");

        ObjectMapper objectMapper = new ObjectMapper();
        ProductModel[] modelModelList = objectMapper.readValue(jsonFile, ProductModel[].class);

        for (ProductModel lm : modelModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }
}