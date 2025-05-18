package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: Access modifiers changed from: package-private */
@zzard
/* loaded from: classes2.dex */
public final class u4 {
    private long a = -1;

    /* renamed from: b, reason: collision with root package name */
    private long f13385b = -1;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzawj f13386c;

    public u4(zzawj zzawjVar) {
        this.f13386c = zzawjVar;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putLong("topen", this.a);
        bundle.putLong("tclose", this.f13385b);
        return bundle;
    }

    public final long b() {
        return this.f13385b;
    }

    public final void c() {
        Clock clock;
        clock = this.f13386c.a;
        this.f13385b = clock.b();
    }

    public final void d() {
        Clock clock;
        clock = this.f13386c.a;
        this.a = clock.b();
    }
}
