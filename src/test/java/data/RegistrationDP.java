package data;

import POJO.RegModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class RegistrationDP {
    @DataProvider(name = "regJsonDataProvider")
    public Iterator<Object[]> regJsonDataProvider() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

        File jsonFile = new File("src/test/resources/testData/RegistrationTestData.json");

        ObjectMapper objectMapper = new ObjectMapper();
        RegModel[] regModelList = objectMapper.readValue(jsonFile, RegModel[].class);

        for (RegModel lm : regModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }
}
