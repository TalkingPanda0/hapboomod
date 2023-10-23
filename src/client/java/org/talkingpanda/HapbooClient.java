package org.talkingpanda;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.Identifier;

public class HapbooClient implements ClientModInitializer {
	final static public Identifier[] HAPBOO = new Identifier[7];
	final static public float  hapbooframetime = 0.08F * 20F;
	final public  static Identifier hapbooidentifier = new Identifier("minecraft:servers/35ad5a769f69f7183ed52014e44e9a4eb4241769/icon");

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		for(int i=1;i<8;i++) {
			HAPBOO[i-1] = new Identifier("hapboo:textures/" + String.valueOf(i) + ".png");
		}

	}
}