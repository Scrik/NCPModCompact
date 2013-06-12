package ncpmodcompact;

import org.bukkit.plugin.java.JavaPlugin;

import fr.neatmonster.nocheatplus.checks.CheckType;
import fr.neatmonster.nocheatplus.hooks.NCPHook;
import fr.neatmonster.nocheatplus.hooks.NCPHookManager;

import ncpmodcompact.ic2.JetPackHook;



public class MainLoader extends JavaPlugin {

	Config config;
	
	Commands commands;
	
	NCPHook jethook;
	
	@Override
	public void onDisable() {
		NCPHookManager.removeHook(jethook);
	}
	
	
	@Override
	public void onEnable() {
		
		config = new Config();
		config.LoadCFG();
		
		commands = new Commands(config);
		getCommand("ncpmc").setExecutor(commands);
		
		jethook = new JetPackHook(config);
		NCPHookManager.addHook(new CheckType[]{CheckType.MOVING_SURVIVALFLY}, jethook);

	}
	
}
