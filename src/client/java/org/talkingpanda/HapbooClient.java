package org.talkingpanda;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.apache.commons.lang3.ObjectUtils;
import org.lwjgl.glfw.GLFW;

public class HapbooClient implements ClientModInitializer {
	final static public Identifier[] HAPBOO = new Identifier[7];
	public  static  int hapbooindex = 0;
	static public long  hapbooframetime = 80;
    public static Identifier hapbooidentifier;
    private static KeyBinding increaseBind;
	private static KeyBinding decreaseBind;
	@Override
	public void onInitializeClient() {
		for(int i=1;i<8;i++) {
			HAPBOO[i-1] = new Identifier("hapboo:textures/" + i + ".png");
		}
		// Keybinds
		increaseBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.hapboo.increase",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_KP_ADD,
				"category.hapboo.hapboo"));
		decreaseBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.hapboo.decrease",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_KP_SUBTRACT,
				"category.hapboo.hapboo"));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (increaseBind.wasPressed()) {
				HapbooClient.hapbooframetime -= 1;
				Hapboo.LOGGER.info(String.valueOf(HapbooClient.hapbooframetime));
				client.player.sendMessage(Text.literal("Hapboo Speed: " + 8000 / HapbooClient.hapbooframetime + "%").formatted(Formatting.GREEN), true);
			}
			while (decreaseBind.wasPressed()) {
				HapbooClient.hapbooframetime += 1;
				Hapboo.LOGGER.info(String.valueOf(HapbooClient.hapbooframetime));
				client.player.sendMessage(Text.literal("Hapboo Speed: " + 8000 / HapbooClient.hapbooframetime + "%").formatted(Formatting.RED), true);
			}
		});
	}
}