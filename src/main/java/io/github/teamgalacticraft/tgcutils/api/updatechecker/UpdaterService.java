package io.github.teamgalacticraft.tgcutils.api.updatechecker;

import io.github.teamgalacticraft.tgcutils.api.updatechecker.models.VersionsModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

/**
 * @author <a href="https://github.com/teamgalacticraft">TeamGalacticraft</a>
 */
public interface UpdaterService {
    @Headers({
            "Content-Type: application/json",
            "User-Agent: TGC-Utils Fabric mod Update Checker"
    })
    @GET
    Call<VersionsModel> getVersions(@Url String url);
}
