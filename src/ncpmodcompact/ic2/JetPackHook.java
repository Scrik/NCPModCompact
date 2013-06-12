package ncpmodcompact.ic2;

import ncpmodcompact.Config;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import fr.neatmonster.nocheatplus.checks.CheckType;
import fr.neatmonster.nocheatplus.checks.access.IViolationInfo;
import fr.neatmonster.nocheatplus.hooks.NCPHook;

public class JetPackHook implements NCPHook {

	Config config;
	
	public JetPackHook(Config config)
	{
		this.config = config;
	}


	@Override
	public String getHookName() {
		// TODO Auto-generated method stub
		return "IC2.jetpack";
	}
	@Override
	public String getHookVersion() {
		return "1";
	}
	
	
	@Override
	public boolean onCheckFailure(CheckType arg0, Player player,
			IViolationInfo vlevel) {
		System.out.println(player.getName());
		System.out.println(player.getInventory().getChestplate());
		System.out.println(player.getInventory().getChestplate().getTypeId());
		System.out.println(player.getInventory().getChestplate().getDurability());
		System.out.println(vlevel.getTotalVl());
		
		if (config.jetids.contains(player.getInventory().getChestplate().getTypeId())) {System.out.println("jetpack found"); return true;}
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
