package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class zzbjn {
    private final zzbai a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f14489b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakReference<Context> f14490c;

    /* loaded from: classes2.dex */
    public static class zza {
        private zzbai a;

        /* renamed from: b, reason: collision with root package name */
        private Context f14491b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<Context> f14492c;

        public final zza b(zzbai zzbaiVar) {
            this.a = zzbaiVar;
            return this;
        }

        public final zza d(Context context) {
            this.f14492c = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f14491b = context;
            return this;
        }
    }

    private zzbjn(zza zzaVar) {
        this.a = zzaVar.a;
        this.f14489b = zzaVar.f14491b;
        this.f14490c = zzaVar.f14492c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context a() {
        return this.f14489b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context b() {
        if (this.f14490c.get() != null) {
            return this.f14490c.get();
        }
        return this.f14489b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbai c() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return zzk.zzlg().g0(this.f14489b, this.a.f14326f);
    }
}
