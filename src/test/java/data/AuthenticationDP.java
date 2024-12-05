package data;

import POJO.AuthModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class AuthenticationDP {
    @DataProvider(name = "authJsonDataProvider")
    public Iterator<Object[]> authJsonDataProvider() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();

        File jsonFile = new File("src/test/resources/testData/AuthTestData.json");

        ObjectMapper objectMapper = new ObjectMapper();
        AuthModel[] authModelList = objectMapper.readValue(jsonFile, AuthModel[].class);

        for (AuthModel lm : authModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }
}
