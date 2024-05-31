package csv;

import org.testng.annotations.DataProvider;

import java.util.List;

public class SignUpDataProvider {
    @DataProvider(name = "signUpData")
    public Object[][] signUpData() {
        List<String[]> csvData = CSVReader.readCSV("src/main/resources/csv/csvtesting.csv");
        Object[][] data = new Object[csvData.size()][csvData.get(0).length];
        for (int i = 0; i < csvData.size(); i++) {
            data[i] = csvData.get(i);
        }
        return data;
    }
}
