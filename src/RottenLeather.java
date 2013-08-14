package assets.rottenleather.src;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@NetworkMod(clientSideRequired=true, serverSideRequired=true)

@Mod(modid=ModInfo.MODID, name=ModInfo.NAME, version=ModInfo.VERSION)

public class RottenLeather {
	
 public static Block FleshBlock;
 public static int FleshBlockID;
 public static Block LeatherBlock;
 public static int LeatherBlockID;
 
    @Mod.Instance(ModInfo.MODID)
    public static RottenLeather mod;
 
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		FleshBlockID = config.getBlock("FleshBlock", 3001).getInt();
		LeatherBlockID = config.getBlock("LeatherBlock", 3002).getInt();
		config.save();
    }
 
 
    @Init
    public void load(FMLInitializationEvent event)
    {
    	FleshBlock = new FleshBlock(FleshBlockID,0).setUnlocalizedName("Block of Flesh").setHardness(0.5F);
    	LeatherBlock = new LeatherBlock(LeatherBlockID,0).setUnlocalizedName("Block of Leather").setHardness(0.5F);
    	
    	GameRegistry.registerBlock(FleshBlock);
		LanguageRegistry.addName(FleshBlock, "Block of Flesh");
		GameRegistry.registerBlock(LeatherBlock);
		LanguageRegistry.addName(LeatherBlock, "Block of Leather");
		
		GameRegistry.addRecipe(new ItemStack(RottenLeather.FleshBlock, 1), new Object[]{ "XXX", "XXX", "XXX", Character.valueOf('X'), Item.rottenFlesh});
		GameRegistry.addSmelting(FleshBlockID, new ItemStack(RottenLeather.LeatherBlock, 1), 0.1F);
		GameRegistry.addShapelessRecipe(new ItemStack(Item.leather, 3), new Object[] {RottenLeather.LeatherBlock});
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
 
    }
 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
 
    }
 
    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
 
    }
}
