package ncpmodcompact.ic2;

import ncpmodcompact.Config;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import fr.neatmonster.nocheatplus.checks.CheckType;
import fr.neatmonster.nocheatplus.checks.access.IViolationInfo;
import fr.neatmonster.nocheatplus.checks.moving.MovingData;
import fr.neatmonster.nocheatplus.hooks.NCPHook;

public class JetPackHook implements NCPHook, Listener {

	private Config config;
	public JetPackHook(Config config)
	{
		this.config = config;
	}


	@Override
	public String getHookName()
	{
		return "IC2.jetpack";
	}
	@Override
	public String getHookVersion() 
	{
		return "1";
	}
	
	
	@Override
	public boolean onCheckFailure(CheckType check, Player player, IViolationInfo vlevel) 
	{
		if (player.getInventory().getChestplate() != null && config.jetids.contains(player.getInventory().getChestplate().getTypeId())) 
		{
			if (player.getLocation().getY() > MovingData.getData(player).fromY)
			{
				MovingData.getData(player).noFallFallDistance = 0;
				MovingData.getData(player).survivalFlyVL = vlevel.getTotalVl() - vlevel.getAddedVl();
				return true;
			}
		}
		return false;
	}

}
