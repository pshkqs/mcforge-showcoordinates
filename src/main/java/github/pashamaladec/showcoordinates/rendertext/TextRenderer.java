package github.pashamaladec.showcoordinates.rendertext;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public abstract class TextRenderer
{
	protected ClientPlayerEntity player;
	protected Minecraft minecraft;
	
	protected float textX = 0;
	protected float textY = 0;
	
	@SubscribeEvent
	public void OnRender(RenderGameOverlayEvent.Text event)
	{
		minecraft = Minecraft.getInstance();
		player = minecraft.player;
		RenderText(event.getMatrixStack());
	}
	
	public void setTextState(float x, float y)
	{
		textX = x;
		textY = y;
	}
	
	protected Minecraft getMinecraft()
	{
		return Minecraft.getInstance();
	}
	
	protected abstract void RenderText(MatrixStack stack);
}
