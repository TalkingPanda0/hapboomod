package org.talkingpanda.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerServerListWidget;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.ColorHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.talkingpanda.Hapboo;
import org.talkingpanda.HapbooClient;

@Mixin(MultiplayerServerListWidget.ServerEntry.class)
public class HapbooMixin {
	private static int hapbooindex = 0;
	private static float timeDeltaSinceLastFrame = 0;

	@Inject(cancellable = false,method = "render", at = @At("TAIL"))
	public void render(DrawContext context, int index, int y, int x, int entryWidth, int entryHeight, int mouseX, int mouseY, boolean hovered, float tickDelta,CallbackInfo ci)
	{
		MultiplayerServerListWidget.ServerEntry se = (MultiplayerServerListWidget.ServerEntry)(Object)this;
		if(!se.getServer().label.getString().startsWith("HAPBOO")) return;
		timeDeltaSinceLastFrame += tickDelta;
	}

	@Inject(cancellable = true, method = "draw", at = @At("HEAD"))
	void draw(DrawContext context, int x, int y, Identifier textureId,CallbackInfo ci) {

		if( textureId.equals(HapbooClient.HAPBOO[hapbooindex])){
			// HAPBOOOOO
			if(timeDeltaSinceLastFrame >= HapbooClient.hapbooframetime) {
				hapbooindex = hapbooindex + 1 > HapbooClient.HAPBOO.length-1 ? 0 : hapbooindex+1;
				timeDeltaSinceLastFrame = 0;
			}

			context.drawTexture(HapbooClient.HAPBOO[hapbooindex],x,y,0,0,32,32,32,32);
			//context.drawText(MinecraftClient.getInstance().textRenderer,String.valueOf(hapbooindex),mouseX,mouseY, ColorHelper.Argb.getArgb(255,255,255,255),true);
			ci.cancel();

		}


	}
}