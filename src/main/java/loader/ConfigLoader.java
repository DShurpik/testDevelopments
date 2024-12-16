package loader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        String profile = System.getProperty("profile", "dev"); // Устанавливаем профиль по умолчанию: "dev"
        try {
            String configFile = "c-" + profile + ".properties"; // Путь к файлам в папке ресурсов
            FileInputStream input = new FileInputStream(
                    ConfigLoader.class.getClassLoader().getResource(configFile).getFile()  // Загрузка файла из ресурсов
            );
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
