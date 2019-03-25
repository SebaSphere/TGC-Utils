package io.github.teamgalacticraft.tgcutils;

import io.github.teamgalacticraft.tgcutils.api.updatechecker.ModUpdateChecker;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author <a href="https://github.com/teamgalacticraft">TeamGalacticraft</a>
 */
public class TGCUtil implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger("TGC-Utils");
    private static ModUpdateChecker modUpdateChecker = new ModUpdateChecker(
            "tgc-utils",
            "https://raw.githubusercontent.com/teamgalacticraft/TGC-Utils/master/updates.json"
    );

    @Override
    public void onInitialize() {
        LOGGER.info("[TGC-Utils] Checking for updates...");
        LOGGER.info("[TGC-Utils] Version is " + modUpdateChecker.getStatus().name());
    }
}
