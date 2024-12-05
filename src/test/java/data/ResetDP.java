package data;

import POJO.PassResetModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ResetDP {
    @DataProvider(name = "resetJsonDataProvider")
    public Iterator<Object[]> regJsonDataProvider() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

        File jsonFile = new File("src/test/resources/testData/PasswordResetTestData.json");

        ObjectMapper objectMapper = new ObjectMapper();
        PassResetModel[] passResetModelList = objectMapper.readValue(jsonFile, PassResetModel[].class);

        for (PassResetModel lm : passResetModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }
}
