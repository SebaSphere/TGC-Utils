package io.github.teamgalacticraft.tgcutils;

import io.github.teamgalacticraft.tgcutils.api.updatechecker.ModUpdateChecker;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * @author <a href="https://github.com/teamgalacticraft">TeamGalacticraft</a>
 */
public class TGCUtil implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger("TGC-Utils");
    public static ModUpdateChecker modUpdateChecker = new ModUpdateChecker("tgc-utils", "https://gist.githubusercontent.com/JoeZwet/d7128d0dac8cff47f1e3bd4710d38b2b/raw/086140d136ca2a6fcdf6ed720628e64ed5b2af48/update.json");

    @Override
    public void onInitialize() {
        LOGGER.info("[TGC-Utils] Checking for updates...");
        LOGGER.info("[TGC-Utils] Version is " + modUpdateChecker.getStatus().name());
    }
}
