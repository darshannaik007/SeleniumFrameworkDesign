package org.example.TestData;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;


public class DataReader {

    public List<HashMap<String, String>> getJsonData(String data) throws IOException {
        String path = System.getProperty("user.dir")+"/src/main/java/org/example/TestData/Cities.json";
        path=path.replace("/","\\");
        String content = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> ls= mapper.readValue(content, new TypeReference<List<HashMap<String, String>>>(){});
        return ls;
    }
}
