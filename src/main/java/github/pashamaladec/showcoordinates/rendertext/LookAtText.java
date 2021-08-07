package github.pashamaladec.showcoordinates.rendertext;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

public class LookAtText extends TextRenderer
{
	
	protected void RenderText(MatrixStack stack)
	{
		BlockState block = getLookAt(7);
		
		if(block != null)
		{
			minecraft.fontRenderer.drawText(stack, block.getBlock().getTranslatedName(), textX, textY, 0xFFFFFF);
			minecraft.fontRenderer.drawString(stack, block.getBlock().getRegistryName().getNamespace() + block.getBlock().getRegistryName().getPath(), textX, textY + 10, 0xFFFFFF);
		}
	}
	
	@Nullable
	private BlockState getLookAt(float maxDistance)
	{
		Vector3d look = player.getLookVec();
		Vector3d start = player.getEyePosition(minecraft.getRenderPartialTicks());
		
		RayTraceContext ray = new RayTraceContext(start, start.add(look.scale(maxDistance)), RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, null);
		BlockRayTraceResult result = player.world.rayTraceBlocks(ray);
		
		if(result.getType() != RayTraceResult.Type.BLOCK)
			return null;
		
		return player.world.getBlockState(result.getPos());
	}
}
