package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzn {
    private static final Uri a = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: b, reason: collision with root package name */
    private final String f12069b;

    /* renamed from: c, reason: collision with root package name */
    private final String f12070c;

    /* renamed from: d, reason: collision with root package name */
    private final ComponentName f12071d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12072e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f12073f;

    public zzn(String str, String str2, int i2, boolean z) {
        Preconditions.g(str);
        this.f12069b = str;
        Preconditions.g(str2);
        this.f12070c = str2;
        this.f12071d = null;
        this.f12072e = i2;
        this.f12073f = z;
    }

    public final int a() {
        return this.f12072e;
    }

    public final ComponentName b() {
        return this.f12071d;
    }

    public final Intent c(Context context) {
        Bundle bundle;
        if (this.f12069b == null) {
            return new Intent().setComponent(this.f12071d);
        }
        if (this.f12073f) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.f12069b);
            try {
                bundle = context.getContentResolver().call(a, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e2) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e2.toString()));
                bundle = null;
            }
            r2 = bundle != null ? (Intent) bundle.getParcelable("serviceResponseIntentKey") : null;
            if (r2 == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f12069b)));
            }
        }
        return r2 != null ? r2 : new Intent(this.f12069b).setPackage(this.f12070c);
    }

    public final String d() {
        return this.f12070c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzn)) {
            return false;
        }
        zzn zznVar = (zzn) obj;
        return Objects.a(this.f12069b, zznVar.f12069b) && Objects.a(this.f12070c, zznVar.f12070c) && Objects.a(this.f12071d, zznVar.f12071d) && this.f12072e == zznVar.f12072e && this.f12073f == zznVar.f12073f;
    }

    public final int hashCode() {
        return Objects.b(this.f12069b, this.f12070c, this.f12071d, Integer.valueOf(this.f12072e), Boolean.valueOf(this.f12073f));
    }

    public final String toString() {
        String str = this.f12069b;
        if (str != null) {
            return str;
        }
        Preconditions.k(this.f12071d);
        return this.f12071d.flattenToString();
    }
}
