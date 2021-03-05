package me.ivanyf.iphider.mixins;

import it.unimi.dsi.fastutil.booleans.BooleanConsumer;
import me.ivanyf.iphider.config.Configs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.AddServerScreen;
import net.minecraft.client.gui.screen.ConfirmScreen;
import net.minecraft.client.gui.screen.DisconnectedScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AddServerScreen.class)
public class AddServerScreenMixin {
    @Shadow private TextFieldWidget addressField;
    @Shadow @Final private ServerInfo server;
    @Shadow @Final private BooleanConsumer callback;

    private String serverAddress;
    private boolean newServer;

    private final AddServerScreen screen = (AddServerScreen)(Object) this;

    @Inject(method = "init", at = @At("TAIL"))
    private void init(CallbackInfo ci) {

    }

    private void callback(boolean confirmedAction) {
        System.out.println(confirmedAction);
        if (confirmedAction) {
//            MinecraftClient.getInstance().openScreen(new AddServerScreen(screen, screen::));
        }
    }
}
