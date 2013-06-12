package ncpmodcompact;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;

public class Commands implements CommandExecutor{

	Config config;
	
	public Commands(Config config)
	{
		this.config = config;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
	String commandLabel, String[] args) {
		boolean hasperm = false;
	if (sender instanceof ConsoleCommandSender || sender instanceof RemoteConsoleCommandSender) {hasperm = true;}
	if (hasperm)
		{
			config.LoadCFG();
			return true;
		}
	return false;
	}
	
}
