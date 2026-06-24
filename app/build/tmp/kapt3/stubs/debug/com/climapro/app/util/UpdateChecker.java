package com.climapro.app.util;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\tH\u0086@\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/climapro/app/util/UpdateChecker;", "", "api", "Lcom/climapro/app/util/UpdateApi;", "(Lcom/climapro/app/util/UpdateApi;)V", "repoUrl", "", "versionActual", "check", "Lcom/climapro/app/util/UpdateInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class UpdateChecker {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.util.UpdateApi api = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String repoUrl = "https://api.github.com/repos/TU_USUARIO/TU_REPO/releases/latest";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String versionActual = "1.0.0";
    
    @javax.inject.Inject()
    public UpdateChecker(@org.jetbrains.annotations.NotNull()
    com.climapro.app.util.UpdateApi api) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object check(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.climapro.app.util.UpdateInfo> $completion) {
        return null;
    }
}