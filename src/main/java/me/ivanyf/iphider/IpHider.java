package me.ivanyf.iphider;

import me.ivanyf.iphider.config.Configs;
import net.fabricmc.api.ModInitializer;

public class IpHider implements ModInitializer {
    public static String MOD_ID = "ip-hider";
    @Override
    public void onInitialize() {
        Configs.read();
    }
}
