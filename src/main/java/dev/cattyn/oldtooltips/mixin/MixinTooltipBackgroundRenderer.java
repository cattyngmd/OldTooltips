package dev.cattyn.oldtooltips.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.tooltip.TooltipBackgroundRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TooltipBackgroundRenderer.class)
public abstract class MixinTooltipBackgroundRenderer {
    @Shadow
    private static void renderRectangle(DrawContext context, int x, int y, int width, int height, int z, int color) { }

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private static void render(DrawContext ctx, int x, int y, int width, int height, int z, CallbackInfo ci) {
        renderRectangle(ctx,x - 3, y - 3, width + 6, height + 6, z, 0xC0000000);
        ci.cancel();
    }
}
