package data;

import POJO.ComparisonModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ComparisonDP {
    @DataProvider(name = "productComparisonJsonDataProvider")
    public Iterator<Object[]> productComparisonJsonDataProvider() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

        File jsonFile = new File("src/test/resources/testData/ProdComparisonTestData.json");

        ObjectMapper objectMapper = new ObjectMapper();
        ComparisonModel[] comparisonModelList = objectMapper.readValue(jsonFile, ComparisonModel[].class);

        for (ComparisonModel lm : comparisonModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }
}