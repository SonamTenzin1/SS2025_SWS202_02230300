package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public final class y {
    private final String a = Preconditions.h("MESSAGE_DELIVERED", "evenType must be non-null");

    /* renamed from: b, reason: collision with root package name */
    private final Intent f19883b;

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes2.dex */
    static class a implements com.google.firebase.encoders.c<y> {
        @Override // com.google.firebase.encoders.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(y yVar, com.google.firebase.encoders.d dVar) throws EncodingException, IOException {
            Intent b2 = yVar.b();
            dVar.e("ttl", f0.q(b2));
            dVar.h("event", yVar.a());
            dVar.h("instanceId", f0.e(b2));
            dVar.e("priority", f0.n(b2));
            dVar.h("packageName", f0.m());
            dVar.h("sdkPlatform", "ANDROID");
            dVar.h("messageType", f0.k(b2));
            String g2 = f0.g(b2);
            if (g2 != null) {
                dVar.h("messageId", g2);
            }
            String p = f0.p(b2);
            if (p != null) {
                dVar.h("topic", p);
            }
            String b3 = f0.b(b2);
            if (b3 != null) {
                dVar.h("collapseKey", b3);
            }
            if (f0.h(b2) != null) {
                dVar.h("analyticsLabel", f0.h(b2));
            }
            if (f0.d(b2) != null) {
                dVar.h("composerLabel", f0.d(b2));
            }
            String o = f0.o(b2);
            if (o != null) {
                dVar.h("projectNumber", o);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes2.dex */
    public static final class b {
        private final y a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(y yVar) {
            this.a = (y) Preconditions.k(yVar);
        }

        y a() {
            return this.a;
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes2.dex */
    static final class c implements com.google.firebase.encoders.c<b> {
        @Override // com.google.firebase.encoders.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(b bVar, com.google.firebase.encoders.d dVar) throws EncodingException, IOException {
            dVar.h("messaging_client_event", bVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(String str, Intent intent) {
        this.f19883b = (Intent) Preconditions.l(intent, "intent must be non-null");
    }

    String a() {
        return this.a;
    }

    Intent b() {
        return this.f19883b;
    }
}
