package me.ivanyf.iphider.mixins;

import me.ivanyf.iphider.config.Configs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiplayerScreen.class)
public class MultiplayerScreenMixin {
    MultiplayerScreen screen = (MultiplayerScreen)(Object) this;
    @Shadow private ButtonWidget buttonEdit;

    @Inject(method = "render", at = @At("TAIL"))
    private void render(int mouseX, int mouseY, float delta, CallbackInfo ci) {
        screen.drawString(MinecraftClient.getInstance().textRenderer, "Hide IP: Enabled", 0, 0, 16777215);
    }

    @Inject(method = "updateButtonActivationStates", at = @At("TAIL"))
    private void updateButtonActivationStates(CallbackInfo ci) {
        Configs.read();
        if (Configs.enabled) {
            buttonEdit.active = false;
        }
    }
}
