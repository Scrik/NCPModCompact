package ncpmodcompact.ic2;

import ncpmodcompact.Config;

import org.bukkit.entity.Player;

import fr.neatmonster.nocheatplus.checks.CheckType;
import fr.neatmonster.nocheatplus.checks.access.IViolationInfo;
import fr.neatmonster.nocheatplus.checks.moving.MovingData;
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
		if (player.getInventory().getChestplate() != null && config.jetids.contains(player.getInventory().getChestplate().getTypeId())) {
			System.out.println("jetpack found");
			MovingData.getData(player).clearFlyData();
			MovingData.getData(player).survivalFlyVL = vlevel.getTotalVl() - vlevel.getAddedVl();
			return true;
		}

		return false;
	}
	
	
}
