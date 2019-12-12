package com.voidcitymc.www;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
//import java.util.UUID;
//import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

public class Police implements CommandExecutor {

// This method is called, when somebody uses our command
@Override
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
if (sender instanceof Player) {
Player player = (Player) sender;
worker work = new worker();


//String uuidString = player.getUniqueId().toString();
//convert string to player

//creates string called playerFromCommand that is the selected player uuid
String playerFromCommand = "null";
String playerFromCommandString = "null";
if (args.length > 1) {
	playerFromCommand = Bukkit.getPlayer(args[1]).getUniqueId().toString();	
	playerFromCommandString = Bukkit.getPlayer(args[1]).toString();	
}

// convert string to uuid: UUID returnUUID = UUID.fromString(uuidVarname);




//Add police
if (player.hasPermission()) {
// need to check if player has perm ^
if (args[0].equalsIgnoreCase("add")) {
	if (playerFromCommand != "null") {
		work.addPolice(playerFromCommand);	
		player.sendMessage("Added "+args[1]+" as a police officer!");
		} else if (playerFromCommand == "null") {
		player.sendMessage("You need to specify a player!");
	}
	
}

}

//Remove
if (player.hasPermission()) {

if (args[0].equalsIgnoreCase("remove")) {
	if (playerFromCommand != "null") {
		work.removePolice(playerFromCommand);	
		player.sendMessage("Removed "+args[1]+" as a police officer!");
		} else if (playerFromCommand == "null") {
		player.sendMessage("You need to specify a player!");
	}
}

}


if (player.hasPermission()) {
	
if (args[0].equalsIgnoreCase("help")) {
	player.sendMessage("[ramdon_person's Police Plugin]");
	player.sendMessage("Commands:");
	player.sendMessage("");
}
}





}
// If the command is used correctly return true
return true;
}
}
