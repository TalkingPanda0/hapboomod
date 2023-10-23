package org.talkingpanda.mixin.client;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.talkingpanda.HapbooClient;

@Mixin(MinecraftClient.class)
public class RegisterMixin {
    @Inject(method = "onInitFinished",at = @At("TAIL"))
    private static void injected(CallbackInfoReturnable<Runnable> cir){

    }
}
