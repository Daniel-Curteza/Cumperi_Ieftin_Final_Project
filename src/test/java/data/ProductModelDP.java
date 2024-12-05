package data;

import POJO.ProductModelModel;
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
        ProductModelModel[] modelModelList = objectMapper.readValue(jsonFile, ProductModelModel[].class);

        for (ProductModelModel lm : modelModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }
}