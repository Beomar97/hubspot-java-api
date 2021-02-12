package config;

import lombok.extern.java.Log;
import lombok.val;
import org.yaml.snakeyaml.Yaml;

import java.lang.reflect.Field;
import java.util.Map;

@Log
public class EnvironmentVariables {

    public static String API_KEY;
    public static String COMPANY_ID;

    private static final String CONFIG_FILE = "EnvironmentVariables.yaml";

    static {
        try {
            val classObject = EnvironmentVariables.class;
            val classFields = classObject.getFields();

            val properties = getPropertiesFromYaml(classObject);
            setClassFieldsWithProperties(classObject, classFields, properties);
        } catch (Exception e) {
            log.warning("Initialization of Environment Variables failed!");
        }
    }

    private static Map<String, String> getPropertiesFromYaml(Class<EnvironmentVariables> classObject) {
        val yaml = new Yaml();
        val inputStream = classObject
                .getClassLoader()
                .getResourceAsStream(EnvironmentVariables.CONFIG_FILE);
        return yaml.load(inputStream);
    }

    private static void setClassFieldsWithProperties(Class<EnvironmentVariables> classObject, Field[] classFields, Map<String, String> properties) {
        for (Field field : classFields) {
            try {
                field.set(classObject, properties.get(field.getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
