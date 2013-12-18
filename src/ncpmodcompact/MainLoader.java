package ncpmodcompact;

import org.bukkit.plugin.java.JavaPlugin;

import fr.neatmonster.nocheatplus.checks.CheckType;
import fr.neatmonster.nocheatplus.hooks.NCPHookManager;
import ncpmodcompact.ic2.JetPackHook;
import ncpmodcompact.ic2.QuantumLegginsHook;
import ncpmodcompact.perms.FakePlayersIgnoreHook;



public class MainLoader extends JavaPlugin {

	Config config;
	
	Commands commands;
	
	JetPackHook jethook;
	QuantumLegginsHook legginshook;
	FakePlayersIgnoreHook fakeplayersignorehook;
	
	@Override
	public void onEnable() {
		
		config = new Config();
		config.LoadCFG();
		
		commands = new Commands(config);
		getCommand("ncpmc").setExecutor(commands);
		
		jethook = new JetPackHook(config);
		NCPHookManager.addHook(CheckType.MOVING_SURVIVALFLY, jethook);
		legginshook = new QuantumLegginsHook(config);
		NCPHookManager.addHook(CheckType.MOVING, legginshook);
		fakeplayersignorehook = new FakePlayersIgnoreHook(config);
		NCPHookManager.addHook(new CheckType[]{CheckType.ALL}, fakeplayersignorehook);
	}
	
	@Override
	public void onDisable() {
		NCPHookManager.removeHook(jethook);
		NCPHookManager.removeHook(legginshook);
		NCPHookManager.removeHook(fakeplayersignorehook);
		fakeplayersignorehook = null;
		jethook = null;
		legginshook = null;
		config = null;
		commands = null;
	}
	
}
