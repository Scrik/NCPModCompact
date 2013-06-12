package ncpmodcompact;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	public List<Integer> jetids = new ArrayList<Integer>();
	
	
	public void LoadCFG()
	{
		FileConfiguration config = YamlConfiguration.loadConfiguration(new File("plugins/NCPModCompact/config.yml"));
		jetids =  config.getIntegerList("ic2.jetpack.ids");
		
		saveCFG();
	}
	
	public void saveCFG()
	{
		FileConfiguration config = new YamlConfiguration();
		config.set("ic2.jetpack.ids", jetids);
		try {
			config.save(new File("plugins/NCPModCompact/config.yml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
