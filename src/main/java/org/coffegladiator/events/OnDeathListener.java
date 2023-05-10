package org.coffegladiator.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.coffegladiator.Coffe_Gladiators;
import org.coffegladiator.apis.TitleAPI;
import org.coffegladiator.getinfos.GetInfosConfig;
import org.coffegladiator.manager.Utils;

public class OnDeathListener implements Listener {
    TitleAPI titles = new TitleAPI();
    static FileConfiguration kills = Coffe_Gladiators.getInstance().getConfig();
    public static int souls;
    public static int vitorias;
    public static int perdas;

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        Player killer = e.getEntity().getKiller();
        souls = kills.getInt("infos." + p.getName() + "." + "mortes");
        vitorias = kills.getInt("infos." + p.getName() + "." + "vitorias");
        perdas = kills.getInt("infos." + p.getName() + "." + "perdas");

        if (Coffe_Gladiators.battleplayers.containsKey(p.getUniqueId()) || Coffe_Gladiators.battleplayers.containsKey(killer.getUniqueId())) {
            for (Player ss : Bukkit.getOnlinePlayers()) {
                titles.sendSubtitle(ss,5,5,5, "O jogador " + killer.getName() + " ganhou do jogador " + p.getName() + " é venceu o x1");
            }
            Utils.sendTitles(p, killer);
            Utils.removePlayers(p,killer);
            Utils.removeMove(p,killer);
            souls++;
            vitorias++;
            perdas++;
            GetInfosConfig.setSouls(p,souls);
            GetInfosConfig.setVitorys(p,vitorias);
            GetInfosConfig.setPerdas(p,perdas);
            Coffe_Gladiators.getInstance().saveConfig();
            killer.sendMessage(ChatColor.RED + "Você sera teletranportado em 10 segundos!");
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.dispatchCommand(killer, "camarote");
                }
            }.runTaskLater(Coffe_Gladiators.getInstance(), 20L*10);
        }
        else if(killer.getName().equalsIgnoreCase(p.getName())){
            killer.sendMessage(ChatColor.RED + "Você morreu usando o /kill!");
        }
    }
}
