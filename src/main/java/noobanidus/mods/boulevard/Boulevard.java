package noobanidus.mods.boulevard;

import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IWorld;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Boulevard.MODID)
@Mod.EventBusSubscriber(modid = Boulevard.MODID)
public class Boulevard {
  public static final String MODID = "boulevard";

  public Boulevard() {
  }

  @SubscribeEvent
  public static void onBlockBreak(BlockEvent.BreakEvent event) {
    IWorld world = event.getWorld();
    TileEntity te = world.getTileEntity(event.getPos());
    if (te instanceof LockableLootTileEntity) {
      LockableLootTileEntity tile = (LockableLootTileEntity) te;
      if (tile.lootTable != null) {
        tile.fillWithLoot(event.getPlayer());
      }
    }
  }
}
