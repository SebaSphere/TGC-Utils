package io.github.teamgalacticraft.tgcutils.api.updatechecker.models;

import com.google.gson.annotations.SerializedName;

/**
 * @author <a href="https://github.com/teamgalacticraft">TeamGalacticraft</a>
 */
public class VersionModel {

    @SerializedName("latest")
    private String latest;

    @SerializedName("recommended")
    private String recommended;

    /**
     *
     * @return THe latest mod version for this Minecraft version
     */
    public String getLatest() {
        return latest;
    }

    /**
     *
     * @return The recommended version for this Minecraft version
     */
    public String getRecommended() {
        return recommended;
    }
}
