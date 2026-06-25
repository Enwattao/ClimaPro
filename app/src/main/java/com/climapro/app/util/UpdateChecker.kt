package com.climapro.app.util

import retrofit2.http.GET
import retrofit2.http.Url
import javax.inject.Inject
import javax.inject.Singleton

data class UpdateInfo(val version: String, val apkUrl: String, val changelog: String, val hayActualizacion: Boolean)

data class ReleaseDto(val tag_name: String, val body: String, val assets: List<AssetDto>)
data class AssetDto(val browser_download_url: String, val name: String)

interface UpdateApi {
    @GET
    suspend fun getLatestRelease(@Url url: String): ReleaseDto
}

@Singleton
class UpdateChecker @Inject constructor(private val api: UpdateApi) {

    private val repoUrl = "https://api.github.com/repos/Enwattao/ClimaPro/releases/latest"
    private val versionActual = com.climapro.app.BuildConfig.VERSION_NAME

    suspend fun check(): UpdateInfo? = runCatching {
        val release = api.getLatestRelease(repoUrl)
        val version = release.tag_name.trimStart('v')
        val apkAsset = release.assets.firstOrNull { it.name.endsWith(".apk") }
        UpdateInfo(
            version = version,
            apkUrl = apkAsset?.browser_download_url ?: "",
            changelog = release.body,
            hayActualizacion = version != versionActual && apkAsset != null
        )
    }.getOrNull()
}
