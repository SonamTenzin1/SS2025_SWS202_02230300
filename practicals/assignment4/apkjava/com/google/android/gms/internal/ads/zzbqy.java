package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes2.dex */
public class zzbqy {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final zzcxv f14705b;

    /* renamed from: c, reason: collision with root package name */
    private final String f14706c;

    /* renamed from: d, reason: collision with root package name */
    private Bundle f14707d;

    /* loaded from: classes2.dex */
    public static class zza {
        private Context a;

        /* renamed from: b, reason: collision with root package name */
        private zzcxv f14708b;

        /* renamed from: c, reason: collision with root package name */
        private Bundle f14709c;

        /* renamed from: d, reason: collision with root package name */
        private String f14710d;

        public final zza b(zzcxv zzcxvVar) {
            this.f14708b = zzcxvVar;
            return this;
        }

        public final zzbqy c() {
            return new zzbqy(this);
        }

        public final zza e(Context context) {
            this.a = context;
            return this;
        }

        public final zza h(Bundle bundle) {
            this.f14709c = bundle;
            return this;
        }

        public final zza i(String str) {
            this.f14710d = str;
            return this;
        }
    }

    private zzbqy(zza zzaVar) {
        this.a = zzaVar.a;
        this.f14705b = zzaVar.f14708b;
        this.f14707d = zzaVar.f14709c;
        this.f14706c = zzaVar.f14710d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zza a() {
        return new zza().e(this.a).b(this.f14705b).i(this.f14706c).h(this.f14707d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcxv b() {
        return this.f14705b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle c() {
        return this.f14707d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.f14706c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context e(Context context) {
        return this.f14706c != null ? context : this.a;
    }
}
