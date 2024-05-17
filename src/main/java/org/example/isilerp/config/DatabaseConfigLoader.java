package org.example.isilerp.config;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//para obtener todos los datos sensibles para la conexion a la base de datos desde mi archivo config.properties

public class DatabaseConfigLoader {
    private String url;
    private String user;
    private String password;
    private String name;

    public DatabaseConfigLoader() throws IOException {
        InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();

        if (input == null) {
            try {
                throw new Exception("Unable to find config.properties");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        prop.load(input);

        url = prop.getProperty("database.url");
        user = prop.getProperty("database.user");
        password = prop.getProperty("database.password");
        name = prop.getProperty("database.name");
    }


    // Getters for the properties
    public String getURL() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
