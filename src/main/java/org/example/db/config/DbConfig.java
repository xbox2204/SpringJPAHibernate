package org.example.db.config;

import java.util.HashMap;
import java.util.Map;

public class DbConfig {
    public Map<String, Object> setPropFromEnv(){
        // jdbc:mysql://localhost:3306/library?user=root&password=root
        Map<String, String> env = System.getenv();
        Map<String, Object> hibernateConfigMap = new HashMap<String, Object>();
        for(String keyName:env.keySet()){
            if(keyName.contains("DATABASE_URL")){
                String dbUrl = (String)env.get(keyName);
                String[] dbValues= null;
                String[] authValues= null;
                String[] userValues= null;
                String[] passValues= null;
                if(dbUrl.contains("?")){
                    dbValues = dbUrl.split("\\?");
                    hibernateConfigMap.put("hibernate.connection.url", dbValues[0]+"?autoReconnect=true&useSSL=false");
                    if(dbValues[1].contains("&")){
                        authValues = dbValues[1].split("\\&");
                    }
                    if(authValues[0].contains("=")){
                        userValues = authValues[0].split("=");
                        hibernateConfigMap.put("hibernate.connection.username", userValues[1]);
                    }
                    if(authValues[1].contains("=")){
                        passValues = authValues[1].split("=");
                        hibernateConfigMap.put("hibernate.connection.password", passValues[1]);
                    }
                }
            }

        }
        hibernateConfigMap.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        hibernateConfigMap.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateConfigMap.put("hibernate.format_sql","true");
        hibernateConfigMap.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        return hibernateConfigMap;
    }
}
