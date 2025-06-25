package co.com.siigo.automation.utils;

import co.com.siigo.automation.models.UserData;
import io.cucumber.datatable.DataTable;

import java.util.Map;

public class DataTransformer {

    public static UserData fromDataTable(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        return new UserData(data.get("name"), data.get("job"));
    }
}
