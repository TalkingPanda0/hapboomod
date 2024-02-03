package org.talkingpanda.mixin.client;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.*;

import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.chunk.ChunkBuilder;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.Cancellable;
import org.talkingpanda.Hapboo;
import org.talkingpanda.HapbooClient;

import java.util.List;

/*@Mixin(SpriteAtlasTexture.class)
public abstract class TestMixin {
  @Shadow private Map<Identifier, Sprite> sprites;

  @Inject(method = "getSprite", at = @At("HEAD"),cancellable = true)
    public void injected(CallbackInfoReturnable<Sprite> cir){
    SpriteContents spriteContents = new SpriteContents(HapbooClient.HAPBOO[HapbooClient.hapbooindex], );
      Sprite sprite = new Sprite(HapbooClient.HAPBOO[HapbooClient.hapbooindex],spriteContents,32,32,0,0 );
      cir.setReturnValue(sprite);

  }
}*/
/*@Mixin(SpriteContents.class)
public abstract class TestMixin {

  private SpriteContents contents;
  @Shadow private Identifier id;

  @Inject(method = "<init>",at = @At("TAIL"))
  private void injected(Identifier id, SpriteDimensions dimensions, NativeImage image, ResourceMetadata metadata, CallbackInfo ci){
    contents = (SpriteContents)(Object)this;
    TestMixin.this.id = HapbooClient.HAPBOO[HapbooClient.hapbooindex];
  }
}*/
/*
@Mixin(WorldRenderer.class)
public class TestMixin {
  @Final
  @Shadow
  private ObjectArrayList<ChunkBuilder.BuiltChunk> field_45616;
  @Final
  @Shadow
  private BufferBuilderStorage bufferBuilders;

  @Shadow @Final private BlockEntityRenderDispatcher blockEntityRenderDispatcher;

  @Inject(cancellable = true,method = "render", at = @At("TAIL" +
          ""))
  private void injected( MatrixStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f projectionMatrix, CallbackInfo ci) {

    for (ChunkBuilder.BuiltChunk builtChunk : this.field_45616) {
      List<BlockEntity> list = builtChunk.getData().getBlockEntities();
      if (list.isEmpty()) continue;
      for (BlockEntity blockEntity : list) {

        VertexConsumerProvider.Immediate immediate = this.bufferBuilders.getEntityVertexConsumers();
        VertexConsumerProvider vertexConsumerProvider2 = immediate;
        Hapboo.LOGGER.info(blockEntity.getPos().toString());
        MatrixStack.Entry entry = matrices.peek();
        OverlayVertexConsumer vertexConsumer = new OverlayVertexConsumer(this.bufferBuilders.getEffectVertexConsumers().getBuffer(ModelLoader.BLOCK_DESTRUCTION_RENDER_LAYERS.get(0)), entry.getPositionMatrix(), entry.getNormalMatrix(), 1.0f);
        vertexConsumerProvider2 = renderLayer -> {
          VertexConsumer vertexConsumer2 = immediate.getBuffer(renderLayer);
          if (renderLayer.hasCrumbling()) {
            return VertexConsumers.union(vertexConsumer, vertexConsumer2);
          }
          return vertexConsumer2;
        };
        this.blockEntityRenderDispatcher.render(blockEntity, tickDelta, matrices, vertexConsumerProvider2);
        matrices.pop();
      }
    }
  }
}*/
@Mixin(PlayerEntityRenderer.class)
public class TestMixin {
  @Inject(method = "getTexture(Lnet/minecraft/client/network/AbstractClientPlayerEntity;)Lnet/minecraft/util/Identifier;",at = @At("HEAD"),cancellable = true)
  public void injected(CallbackInfoReturnable<Identifier> cir){
    cir.setReturnValue(HapbooClient.HAPBOO[HapbooClient.hapbooindex]);
  }
}