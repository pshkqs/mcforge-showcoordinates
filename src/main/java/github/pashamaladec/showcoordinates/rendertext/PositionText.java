package github.pashamaladec.showcoordinates.rendertext;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;

import java.util.HashMap;
import java.util.Map;

public class PositionText extends TextRenderer
{
	private final LanguageManager language;
	
	private final Map<String, String> russianFacings = new HashMap<String, String>();
	
	public PositionText()
	{
		language = getMinecraft().getLanguageManager();
		russianFacings.put("west", "Запад");
		russianFacings.put("north", "Север");
		russianFacings.put("east", "Восток");
		russianFacings.put("south", "Юг");
	}
	
	@Override
	protected void RenderText(MatrixStack stack)
	{
		Direction direction = player.getHorizontalFacing();
		minecraft.fontRenderer.drawStringWithShadow(stack, formatPlayerPosition(player.getPosition()), textX, textY, 0xFFFFFF);
		minecraft.fontRenderer.drawStringWithShadow(stack, formatDirection(direction)  + " (" + direction.getString() + ")", textX, textY + 10, 0xFFFFFF);
	}
	
	private String formatPlayerPosition(BlockPos position)
	{
		StringBuilder builder = new StringBuilder();
		builder
				.append(position.getX())
				.append(TextFormatting.GRAY).append(" / ").append(TextFormatting.WHITE).append(position.getY())
				.append(TextFormatting.GRAY).append(" / ").append(TextFormatting.WHITE).append(position.getZ());
		
		return builder.toString();
	}
	
	private String formatDirection(Direction direction)
	{
		switch ((int) direction.getHorizontalAngle())
		{
			case 0:
				return "+Z";
			case 90:
				return "-X";
			case 180:
				return "-Z";
			case 270:
				return "+X";
				
			default:
				return "";
		}
	}
}
