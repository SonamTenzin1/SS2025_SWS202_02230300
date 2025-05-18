package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
final class n40 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ m40 f13021f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n40(m40 m40Var) {
        this.f13021f = m40Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean z;
        boolean z2;
        List list;
        obj = this.f13021f.f12959h;
        synchronized (obj) {
            z = this.f13021f.f12960i;
            if (z) {
                z2 = this.f13021f.f12961j;
                if (z2) {
                    m40.g(this.f13021f, false);
                    zzbad.e("App went background");
                    list = this.f13021f.f12962k;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            ((zzut) it.next()).a(false);
                        } catch (Exception e2) {
                            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
                        }
                    }
                }
            }
            zzbad.e("App is still foreground");
        }
    }
}
