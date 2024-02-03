package org.talkingpanda;

import net.minecraft.client.gui.DrawContext;

public class DrawHapboo {
    public static void drawHapboo(DrawContext context,int x,int y,int width,int height){

        context.drawTexture(HapbooClient.HAPBOO[HapbooClient.hapbooindex],x,y,0,0,width,height,width,height);

    }
}
