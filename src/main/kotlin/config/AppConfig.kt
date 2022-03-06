package config

import org.yaml.snakeyaml.Yaml

class AppConfig private constructor(){
    lateinit var server: ServerConfig

    companion object {
        private val yaml = Yaml()
        private var instance: AppConfig? = null

        fun loadConfig(): AppConfig {
            instance = yaml.loadAs(AppConfig::class.java.getResourceAsStream("/config/config.yaml"), AppConfig::class.java)
            return instance!!
        }

        fun getInstance(): AppConfig {
            if (instance == null)
                instance = loadConfig()
            return instance!!
        }
    }
}