package me.ivanyf.iphider.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.ivanyf.iphider.IpHider;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;

public class Configs {
    private static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDir().toFile(), IpHider.MOD_ID + ".json");
    public static boolean enabled = true;
    public static void read() {
        if (CONFIG_FILE.exists() && CONFIG_FILE.canRead() && CONFIG_FILE.isFile()) {
            try {
                JsonParser parser = new JsonParser();
                JsonElement jsonElement = parser.parse(new FileReader(CONFIG_FILE));
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                enabled = jsonObject.get("enabled").getAsBoolean();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            write();
        }
    }
    public static void write() {
        try {
            if ((CONFIG_FILE.exists() && CONFIG_FILE.isFile()) || CONFIG_FILE.createNewFile()) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("enabled", enabled);
                FileWriter fileWriter = new FileWriter(CONFIG_FILE);
                fileWriter.write(jsonObject.toString());
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
