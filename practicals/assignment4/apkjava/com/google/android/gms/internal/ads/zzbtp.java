package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbtp extends zzbts<AppEventListener> implements zzagx {
    public zzbtp(Set<zzbuz<AppEventListener>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzagx
    public final synchronized void onAppEvent(final String str, final String str2) {
        T(new zzbtu(str, str2) { // from class: com.google.android.gms.internal.ads.se
            private final String a;

            /* renamed from: b, reason: collision with root package name */
            private final String f13324b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = str;
                this.f13324b = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                ((AppEventListener) obj).onAppEvent(this.a, this.f13324b);
            }
        });
    }
}
