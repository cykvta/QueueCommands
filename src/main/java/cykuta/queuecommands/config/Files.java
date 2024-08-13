package cykuta.queuecommands.config;

import org.bukkit.configuration.InvalidConfigurationException;

import java.io.IOException;

public enum Files {
    DATA("data.yml"),
    CONFIG("config.yml");

    private final String fileName;

    Files(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        try {
            return new File(fileName);
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
