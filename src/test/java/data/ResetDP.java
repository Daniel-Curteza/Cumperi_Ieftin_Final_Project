package data;

import POJO.RegistrationModel;
import POJO.ResetModel;
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

        File jsonFile = new File("src/test/resources/testData/resetTestDataInput.json");

        ObjectMapper objectMapper = new ObjectMapper();
        ResetModel[] resetModelList = objectMapper.readValue(jsonFile, ResetModel[].class);

        for (ResetModel lm : resetModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }
}
