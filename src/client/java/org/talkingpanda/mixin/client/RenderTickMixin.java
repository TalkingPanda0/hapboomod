package org.talkingpanda.mixin.client;

import net.minecraft.client.gui.Drawable;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.world.tick.Tick;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.talkingpanda.Hapboo;
import org.talkingpanda.HapbooClient;

@Mixin(RenderTickCounter.class)
public class RenderTickMixin {
    @Inject(at = @At("TAIL"),method = "beginRenderTick")
    public void beginRenderTick(long timeMillis, CallbackInfoReturnable<Integer> cir) {
        if(HapbooClient.hapbooframetime == 0) {
            HapbooClient.hapbooindex = HapbooClient.hapbooindex+1 <7 ? 0 : HapbooClient.hapbooindex+1;
            return;
        }
            HapbooClient.hapbooindex = (int) ((timeMillis / HapbooClient.hapbooframetime) % 7);
    }
}
