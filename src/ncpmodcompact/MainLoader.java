package ncpmodcompact;

import org.bukkit.plugin.java.JavaPlugin;

import fr.neatmonster.nocheatplus.checks.CheckType;
import fr.neatmonster.nocheatplus.hooks.NCPHookManager;
import ncpmodcompact.ic2.JetPackHook;
import ncpmodcompact.ic2.QuantumLegginsHook;



public class MainLoader extends JavaPlugin {

	Config config;
	
	Commands commands;
	
	JetPackHook jethook;
	QuantumLegginsHook legginshook;
	
	@Override
	public void onEnable() {
		
		config = new Config();
		config.LoadCFG();
		
		commands = new Commands(config);
		getCommand("ncpmc").setExecutor(commands);
		
		jethook = new JetPackHook(config);
		NCPHookManager.addHook(new CheckType[]{CheckType.MOVING_SURVIVALFLY}, jethook);
		legginshook = new QuantumLegginsHook(config);
		NCPHookManager.addHook(new CheckType[]{CheckType.MOVING}, legginshook);

	}
	
	@Override
	public void onDisable() {
		NCPHookManager.removeHook(jethook);
		NCPHookManager.removeHook(legginshook);
		jethook = null;
		legginshook = null;
		config = null;
		commands = null;
	}
	
}
