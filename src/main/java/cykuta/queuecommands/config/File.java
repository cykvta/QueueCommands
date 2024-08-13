package cykuta.queuecommands.config;

import cykuta.queuecommands.QueueCommands;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.IOException;

public class File {
        private FileConfiguration fileConfiguration;
        private final String fileName;
        private final java.io.File dataFolder = QueueCommands.getPlugin().getDataFolder();
        private java.io.File file;

        public File(String filename) throws IOException, InvalidConfigurationException {
            this.fileName = filename;
            this.register();
        }

        public void register() throws IOException, InvalidConfigurationException {
            this.file = new java.io.File(dataFolder, fileName);
            if (!this.file.exists()) {
                QueueCommands.getPlugin().saveResource(fileName, false);
            }

            this.fileConfiguration = new YamlConfiguration();
            this.fileConfiguration.load(this.file);
        }

        public void reload() throws IOException, InvalidConfigurationException {
            this.file = new java.io.File(dataFolder, fileName);
            this.fileConfiguration = new YamlConfiguration();
            this.fileConfiguration.load(this.file);
        }

        public FileConfiguration getFileConfiguration() {
            return this.fileConfiguration;
        }

        public void save() {
            try {
                this.fileConfiguration.save(this.file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

}
