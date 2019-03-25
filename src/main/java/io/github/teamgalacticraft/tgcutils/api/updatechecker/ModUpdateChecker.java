package io.github.teamgalacticraft.tgcutils.api.updatechecker;

import io.github.teamgalacticraft.tgcutils.TGCUtil;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.SharedConstants;

/**
 * @author <a href="https://github.com/teamgalacticraft">TeamGalacticraft</a>
 */
public class ModUpdateChecker {

    private String modId;
    private Checker rawChecker;

    public ModUpdateChecker(String modId, String updateUrl) {
        this.modId = modId;
        this.rawChecker = new Checker(updateUrl, modId);
    }

    public VersionStatus getStatus() {
        String currentMCVersion = SharedConstants.getGameVersion().getName();
        TGCUtil.LOGGER.info("Minecraft: " + currentMCVersion);
        String currentModVersion = FabricLoader.getInstance().getModContainer(modId).get().getMetadata().getVersion().getFriendlyString();
        if(rawChecker.getUpdates() == null || rawChecker.getUpdates().getVersions() == null) return VersionStatus.NOT_FOUND;

        TGCUtil.LOGGER.info(currentModVersion);
        if(rawChecker.getUpdates().getModVersions().contains(currentModVersion)) {
            TGCUtil.LOGGER.info(rawChecker.getUpdates().getModVersions().indexOf(currentModVersion));
        }

        if(rawChecker.getUpdates().getVersions().containsKey(currentMCVersion)) {
            int key = rawChecker.getUpdates().getModVersions().indexOf(currentModVersion);
            if(key == 0) return VersionStatus.UP_TO_DATE;
            if(key <= 1) return VersionStatus.OUTDATED;
            return VersionStatus.NOT_FOUND;
        } else {
            return VersionStatus.NOT_FOUND;
        }
    }


    public enum VersionStatus {

        /**
         * The mod is up to date.
         */
        UP_TO_DATE,

        /**
         * The mod is outdated.
         */
        OUTDATED,

        /**
         * Version checker cant find the current Minecraft version in the update file.
         */
        NOT_FOUND,
        ;
    }
}
