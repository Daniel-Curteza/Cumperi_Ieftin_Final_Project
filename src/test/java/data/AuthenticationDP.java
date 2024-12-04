package data;

import POJO.AuthenticationModel;
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

        File jsonFile = new File("src/test/resources/testData/authTestDataInput.json");

        ObjectMapper objectMapper = new ObjectMapper();
        AuthenticationModel[] authenticationModelList = objectMapper.readValue(jsonFile, AuthenticationModel[].class);

        for (AuthenticationModel lm : authenticationModelList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }
}
