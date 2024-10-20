package info.preva1l.kitfix;

import dev.continuum.kits.api.KitsAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Preva1l
 */
public final class KitFix extends JavaPlugin implements Listener {
    public static final ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
    public static final List<UUID> cooldown = new ArrayList<>();

    @Override
    public void onEnable() {
        KitsAPI.api().listeners().register(Listeners.class);
    }

    public static boolean onCooldown(Player player) {
        return cooldown.contains(player.getUniqueId());
    }

    public static void addCooldown(Player player) {
        cooldown.add(player.getUniqueId());
        service.schedule(() -> {
            cooldown.remove(player.getUniqueId());
        }, 3, TimeUnit.SECONDS);
    }
}
