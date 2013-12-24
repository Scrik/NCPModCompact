package ncpmodcompact.ic2;

import ncpmodcompact.Config;

import org.bukkit.entity.Player;

import fr.neatmonster.nocheatplus.checks.CheckType;
import fr.neatmonster.nocheatplus.checks.access.IViolationInfo;
import fr.neatmonster.nocheatplus.checks.moving.MovingData;
import fr.neatmonster.nocheatplus.hooks.NCPHook;

public class QuantumLegginsHook implements NCPHook {

	private Config config;
	public QuantumLegginsHook(Config config)
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
		if (player.getInventory().getLeggings() != null && config.quantumlegginsid == player.getInventory().getLeggings().getTypeId()) 
		{
			//TODO: add speed check here
			if (player.isSprinting())
			{
				MovingData.getData(player).survivalFlyVL = vlevel.getTotalVl() - vlevel.getAddedVl();
				return true;
			}
		}
		return false;
	}
	
}
