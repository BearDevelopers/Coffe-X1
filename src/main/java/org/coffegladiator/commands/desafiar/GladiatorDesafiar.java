package org.coffegladiator.commands.desafiar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.apis.TitleAPI;
import org.coffegladiator.gui.AcceptGUI;

import java.util.Objects;

public class GladiatorDesafiar implements CommandExecutor {
    public static Player ps;
    FileConfiguration config = Coffe_Gladiators.getInstance().getConfig();
    TitleAPI titles = new TitleAPI();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Apenas no jogo!");
        }
        if (cmd.getName().equalsIgnoreCase("desafiar")) {
            Player p = (Player) sender;
            if (args[0].length() == 0) {
                sender.sendMessage(ChatColor.RED + "É necessario inserir um jogador. Exemplo: /desafiar <name>");
                return false;
            }
            else {
                ps = Bukkit.getPlayerExact(args[0]);
                if (ps.isDead()) {
                    sender.sendMessage(ChatColor.RED + "O jogador está morto!");
                    return false;
                }
                if (ps.getName().equalsIgnoreCase(sender.getName())) {
                    sender.sendMessage(ChatColor.RED + "Você não pode convidar você mesmo!");
                    return false;
                }
                else {

                    if (p.hasPermission(config.getString("desafiar.permission"))) {
                        ps.sendMessage(ChatColor.RED + "Você foi desafiado por " + p.getName() + " um inventario ira abrir em 15 segundos, Nele você podera escolher sera ira querer ir o pvp!");
                        p.sendMessage(ChatColor.GREEN + "Jogador desafiado com sucesso!");
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                AcceptGUI.createGuiAccept(ps);
                            }
                        }.runTaskLater(Coffe_Gladiators.getInstance(), 20L * 15);
                    }
                }
            }
        }
        return false;
    }
}
