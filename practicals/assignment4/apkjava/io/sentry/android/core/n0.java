package io.sentry.android.core;

import android.content.Context;
import io.sentry.android.core.internal.util.k;
import io.sentry.w1;

/* compiled from: AndroidTransportGate.java */
/* loaded from: classes2.dex */
final class n0 implements io.sentry.transport.s {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final w1 f22244b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AndroidTransportGate.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[k.a.values().length];
            a = iArr;
            try {
                iArr[k.a.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[k.a.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[k.a.NO_PERMISSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n0(Context context, w1 w1Var) {
        this.a = context;
        this.f22244b = w1Var;
    }

    boolean a(k.a aVar) {
        int i2 = a.a[aVar.ordinal()];
        return i2 == 1 || i2 == 2 || i2 == 3;
    }

    @Override // io.sentry.transport.s
    public boolean isConnected() {
        return a(io.sentry.android.core.internal.util.k.b(this.a, this.f22244b));
    }
}
