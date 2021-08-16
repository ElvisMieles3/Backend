package co.certificacion.reqres.utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class CreateBody {

    private String routeTemplate;

    public CreateBody(String routeTemplate, String endPoint) {

        this.routeTemplate = routeTemplate;
    }

    public static CreateBody withTheTemplate(String plantilla) {

        return new CreateBody(plantilla, null);
    }

    public static CreateBody withTheEndPoint(String endPoint) {

        return new CreateBody(null, endPoint);

    }

    public String andTheValues(List<Map<String, String>> values) {
        String newTemplate = parseJson(routeTemplate);
        for (Map<String, String> value : values) {
            for (Map.Entry<String, String> entry : value.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();
                String key = "${" + k + "}";
                newTemplate = newTemplate.replace(key, v);
            }
        }
        return newTemplate;
    }

    public String parseJson(String ruta) {
        String resultStr = "";
        try {
            resultStr = readFileAsString(ruta);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return resultStr;
        }
    }

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }
}