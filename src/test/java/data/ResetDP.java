package data;

import POJO.PasswordResetModel;
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
        PasswordResetModel[] passwordResetModelList = objectMapper.readValue(jsonFile, PasswordResetModel[].class);

        for (PasswordResetModel lm : passwordResetModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }
}
