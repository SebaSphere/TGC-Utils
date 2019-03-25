package io.github.teamgalacticraft.tgcutils.api.updatechecker.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/teamgalacticraft">TeamGalacticraft</a>
 */
public class VersionsModel {

    @SerializedName("mod_id")
    private String modId;

    @SerializedName("mcVersions")
    private Map<String, VersionModel> mcVersions;

    @SerializedName("modVersions")
    private List<String> modVersions;

    @SerializedName("download_page")
    private String downloads;

    /**
     *
     * @return The mod id for this version
     */
    public String getModId() {
        return modId;
    }

    /**
     *
     * @return The download page for the mod.
     */
    public String getDownloads() {
        return downloads;
    }

    /**
     *
     * @return The versions for this mod.
     */
    public Map<String, VersionModel> getVersions() {
        return mcVersions;
    }

    /**
     *
     * @return Versions of the mod in order, the first being the latest version.
     */
    public List<String> getModVersions() {
        return modVersions;
    }
}
