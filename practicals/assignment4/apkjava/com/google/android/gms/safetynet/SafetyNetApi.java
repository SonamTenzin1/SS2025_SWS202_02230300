package com.google.android.gms.safetynet;

import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import java.util.List;

@KeepForSdkWithMembers
/* loaded from: classes2.dex */
public interface SafetyNetApi {

    /* loaded from: classes2.dex */
    public static class AttestationResponse extends Response<zza> {
    }

    /* loaded from: classes2.dex */
    public static class HarmfulAppsResponse extends Response<zzb> {
        public List<HarmfulAppsData> h() {
            return f().f();
        }
    }

    /* loaded from: classes2.dex */
    public static class RecaptchaTokenResponse extends Response<RecaptchaTokenResult> {
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface RecaptchaTokenResult extends Result {
    }

    @KeepForSdkWithMembers
    /* loaded from: classes2.dex */
    public static class SafeBrowsingResponse extends Response<SafeBrowsingResult> {
    }

    @KeepForSdkWithMembers
    @Deprecated
    /* loaded from: classes2.dex */
    public interface SafeBrowsingResult extends Result {
    }

    /* loaded from: classes2.dex */
    public static class VerifyAppsUserResponse extends Response<zzc> {
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface zza extends Result {
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface zzb extends Result {
        List<HarmfulAppsData> f();
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface zzc extends Result {
    }

    @Deprecated
    PendingResult<zzb> a(GoogleApiClient googleApiClient);
}
