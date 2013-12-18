package ncpmodcompact.perms;

import ncpmodcompact.Config;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import fr.neatmonster.nocheatplus.checks.CheckType;
import fr.neatmonster.nocheatplus.checks.access.IViolationInfo;
import fr.neatmonster.nocheatplus.checks.blockbreak.BlockBreakData;
import fr.neatmonster.nocheatplus.hooks.NCPHook;

public class FakePlayersIgnoreHook implements NCPHook, Listener {

	private Config config;
	public FakePlayersIgnoreHook(Config config)
	{
		this.config = config;
	}
	
	
	@Override
	public String getHookName() 
	{
		return "FakePlayersIgnore";
	}

	@Override
	public String getHookVersion() 
	{
		return "1.0";
	}

	@Override
	public boolean onCheckFailure(CheckType check, Player player, IViolationInfo vlevel) 
	{
		if (!config.fakeplayerignoresncp) {return false;}
		
		if (player.getName().contains("[") && player.getName().contains("]"))
		{
			BlockBreakData.removeData(player.getName());
			return true;
		}
		return false;
	}

}
