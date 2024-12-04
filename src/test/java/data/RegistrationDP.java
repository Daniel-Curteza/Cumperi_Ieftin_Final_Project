package data;

import POJO.AuthenticationModel;
import POJO.RegistrationModel;
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
        RegistrationModel[] registrationModelList = objectMapper.readValue(jsonFile, RegistrationModel[].class);

        for (RegistrationModel lm : registrationModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }
}
