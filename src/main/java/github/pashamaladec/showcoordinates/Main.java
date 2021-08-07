package github.pashamaladec.showcoordinates;

import github.pashamaladec.showcoordinates.rendertext.LookAtText;
import github.pashamaladec.showcoordinates.rendertext.PositionText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("showcoordinates")
public class Main
{
	private final PositionText positionText = new PositionText();
	private final LookAtText lookAtText = new LookAtText();
	
	public Main()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
	}
	
	public void setup(FMLCommonSetupEvent event)
	{
		MinecraftForge.EVENT_BUS.register(positionText);
		positionText.setTextState(100, 100);
	}
}
