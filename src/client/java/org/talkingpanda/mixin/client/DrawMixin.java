package org.talkingpanda.mixin.client;

import net.minecraft.client.font.TextRenderer;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.texture.Scaling;
import net.minecraft.client.texture.Sprite;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.commons.compress.harmony.pack200.NewAttributeBands;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.talkingpanda.DrawHapboo;
import org.talkingpanda.HapbooClient;

@Mixin(DrawContext.class)
public class DrawMixin {

    @Inject(cancellable = true,at = @At("HEAD"),method = "drawSprite(IIIIILnet/minecraft/client/texture/Sprite;)V")
    private void drawSprite(int x, int y, int z, int width, int height, Sprite sprite,CallbackInfo ci){
        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
    @Inject(cancellable = true,at = @At("HEAD"),method = "drawSprite(IIIIILnet/minecraft/client/texture/Sprite;FFFF)V")
    private void drawSprite(int x, int y, int z, int width, int height, Sprite sprite, float red, float green, float blue, float alpha, CallbackInfo ci){
        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
    @Inject(cancellable = true,at = @At("HEAD"),method = "drawSprite(Lnet/minecraft/client/texture/Sprite;IIIII)V")
    private void drawSprite(Sprite sprite, int x, int y, int z, int width, int height, CallbackInfo ci){
        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
    @Inject(cancellable = true,at = @At("HEAD"),method = "drawSprite(Lnet/minecraft/client/texture/Sprite;IIIIIIIII)V")
    private void drawSprite(Sprite sprite, int i, int j, int k, int l, int x, int y, int z, int width, int height, CallbackInfo ci){
        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
    @Inject(cancellable = true,at = @At("HEAD"),method = "drawSprite(Lnet/minecraft/client/texture/Sprite;Lnet/minecraft/client/texture/Scaling$NineSlice;IIIII)V")
    private void drawSprite(Sprite sprite, Scaling.NineSlice nineSlice, int x, int y, int z, int width, int height, CallbackInfo ci){
        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
    @Inject(cancellable = true,at = @At("HEAD"), method = "drawTexture(Lnet/minecraft/util/Identifier;IIIIII)V")
    private void drawTexture(Identifier texture, int x, int y, int u, int v, int width, int height,CallbackInfo ci) {

        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
    @Inject(cancellable = true,at = @At("HEAD"), method = "drawTexture(Lnet/minecraft/util/Identifier;IIIFFIIII)V")
    private void drawTexture1(Identifier texture, int x, int y, int z, float u, float v, int width, int height, int textureWidth, int textureHeight, CallbackInfo ci) {

        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
    @Inject(cancellable = true,at = @At("HEAD"), method = "drawTexture(Lnet/minecraft/util/Identifier;IIFFIIII)V")
    private void drawTexture2(Identifier texture, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight, CallbackInfo ci) {
        if (texture == HapbooClient.HAPBOO[HapbooClient.hapbooindex]) return;
        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
    @Inject(cancellable = true,at = @At("HEAD"), method = "drawTexture(Lnet/minecraft/util/Identifier;IIIIFFIIII)V")
    private void drawTexture3(Identifier texture, int x, int y, int width, int height, float u, float v, int regionWidth, int regionHeight, int textureWidth, int textureHeight, CallbackInfo ci) {
        if (texture == HapbooClient.HAPBOO[HapbooClient.hapbooindex]) return;
        DrawContext context = (DrawContext)(Object)this;

        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
    @Inject(cancellable = true,at = @At("HEAD"), method = "drawTexture(Lnet/minecraft/util/Identifier;IIIIIIIFFII)V")
    private void drawTexture4(Identifier texture, int x1, int x2, int y1, int y2, int z, int regionWidth, int regionHeight, float u, float v, int textureWidth, int textureHeight, CallbackInfo ci) {
        if (texture == HapbooClient.HAPBOO[HapbooClient.hapbooindex]) return;
        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x1,y1,regionWidth,regionHeight);
        ci.cancel();
    }


    @Inject(cancellable = true,at = @At("HEAD"), method = "drawGuiTexture(Lnet/minecraft/util/Identifier;IIII)V")
    private void drawGuiTexture(Identifier texture, int x, int y, int width, int height,CallbackInfo ci) {
        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
    @Inject(cancellable = true,at = @At("HEAD"), method = "drawGuiTexture(Lnet/minecraft/util/Identifier;IIIII)V")
    private void drawGuiTexture1(Identifier texture, int x, int y, int z, int width, int height, CallbackInfo ci) {
        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
    @Inject(cancellable = true,at = @At("HEAD"), method = "drawGuiTexture(Lnet/minecraft/util/Identifier;IIIIIIII)V")
    private void drawGuiTexture2(Identifier texture, int i, int j, int k, int l, int x, int y, int width, int height, CallbackInfo ci) {
        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
    @Inject(cancellable = true,at = @At("HEAD"), method = "drawGuiTexture(Lnet/minecraft/util/Identifier;IIIIIIIII)V")
    private void drawGuiTexture3(Identifier texture, int i, int j, int k, int l, int x, int y, int z, int width, int height, CallbackInfo ci) {
        DrawContext context = (DrawContext)(Object)this;
        DrawHapboo.drawHapboo(context,x,y,width,height);
        ci.cancel();
    }
}
