package io.github.teamgalacticraft.tgcutils.api.updatechecker;


import io.github.teamgalacticraft.tgcutils.TGCUtil;
import io.github.teamgalacticraft.tgcutils.api.updatechecker.models.VersionsModel;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * @author <a href="https://github.com/teamgalacticraft">TeamGalacticraft</a>
 */
public class Checker {

    private UpdaterService service;
    private String url;
    private String modId;

    Checker(String url, String modId) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://example.com")
                .build();
        service = retrofit.create(UpdaterService.class);
        this.url = url;
        this.modId = modId;
    }

    public VersionsModel getUpdates() {
        VersionsModel model;
        try {
            model = service.getVersions(url).execute().body();
        } catch (IOException e) {
            TGCUtil.LOGGER.error("[TGC-Utils] Failed to get update URL for " + modId, e);
            return null;
        }
        return model;
    }

}
