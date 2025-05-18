package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.HarmfulAppsData;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.zzd;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class zzk implements SafetyNetApi {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class a extends com.google.android.gms.internal.safetynet.a<SafetyNetApi.zzb> {
        protected final zzg s;

        public a(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.s = new c(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result h(Status status) {
            return new b(status, null);
        }
    }

    /* loaded from: classes2.dex */
    static class b implements SafetyNetApi.zzb {

        /* renamed from: f, reason: collision with root package name */
        private final Status f17590f;

        /* renamed from: g, reason: collision with root package name */
        private final zzd f17591g;

        public b(Status status, zzd zzdVar) {
            this.f17590f = status;
            this.f17591g = zzdVar;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.zzb
        public final List<HarmfulAppsData> f() {
            zzd zzdVar = this.f17591g;
            return zzdVar == null ? Collections.emptyList() : Arrays.asList(zzdVar.f18265g);
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.f17590f;
        }
    }

    /* loaded from: classes2.dex */
    public static class zzi implements SafetyNetApi.SafeBrowsingResult {

        /* renamed from: f, reason: collision with root package name */
        private Status f17592f;

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.f17592f;
        }
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.zzb> a(GoogleApiClient googleApiClient) {
        return googleApiClient.j(new com.google.android.gms.internal.safetynet.b(this, googleApiClient));
    }
}
