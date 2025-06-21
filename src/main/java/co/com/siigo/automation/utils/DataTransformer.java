package co.com.siigo.automation.utils;

import co.com.siigo.automation.models.UserData;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class DataTransformer {

    public static UserData fromDataTable(DataTable dataTable) {
        List<String> values = dataTable.transpose().asLists().get(1);
        String name = values.get(0);
        String job = values.get(1);
        String id = values.size() > 2 ? values.get(2) : null;
        return new UserData(name, job, id);
    }
}
