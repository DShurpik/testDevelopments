package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.load("apps.conf");
    }

    static Config readConfig(String conf){
        return ConfigFactory.load(conf);
    }
}
