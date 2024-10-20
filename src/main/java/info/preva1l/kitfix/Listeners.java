package info.preva1l.kitfix;

import dev.continuum.kits.api.event.Events;
import dev.continuum.kits.api.event.impl.load.KitLoadEvent;
import dev.continuum.kits.api.event.impl.load.PremadeKitLoadEvent;

/**
 * @author Preva1l
 */
public class Listeners {
    @Events.Subscribe
    public void onKitLoad(KitLoadEvent event) {
        if (KitFix.onCooldown(event.player())) {
            event.cancel();
            return;
        }
        KitFix.addCooldown(event.player());
    }

    @Events.Subscribe
    public void onKitLoad(PremadeKitLoadEvent event) {
        if (KitFix.onCooldown(event.player())) {
            event.cancel();
            return;
        }
        KitFix.addCooldown(event.player());
    }
}
