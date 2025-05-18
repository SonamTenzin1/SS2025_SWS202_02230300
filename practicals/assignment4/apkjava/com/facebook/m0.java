package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;

/* compiled from: RequestProgress.kt */
/* loaded from: classes.dex */
public final class m0 {
    private final Handler a;

    /* renamed from: b, reason: collision with root package name */
    private final GraphRequest f10071b;

    /* renamed from: c, reason: collision with root package name */
    private final long f10072c;

    /* renamed from: d, reason: collision with root package name */
    private long f10073d;

    /* renamed from: e, reason: collision with root package name */
    private long f10074e;

    /* renamed from: f, reason: collision with root package name */
    private long f10075f;

    public m0(Handler handler, GraphRequest graphRequest) {
        kotlin.jvm.internal.m.f(graphRequest, "request");
        this.a = handler;
        this.f10071b = graphRequest;
        a0 a0Var = a0.a;
        this.f10072c = a0.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(GraphRequest.b bVar, long j2, long j3) {
        ((GraphRequest.f) bVar).a(j2, j3);
    }

    public final void a(long j2) {
        long j3 = this.f10073d + j2;
        this.f10073d = j3;
        if (j3 >= this.f10074e + this.f10072c || j3 >= this.f10075f) {
            d();
        }
    }

    public final void b(long j2) {
        this.f10075f += j2;
    }

    public final void d() {
        if (this.f10073d > this.f10074e) {
            final GraphRequest.b n = this.f10071b.n();
            final long j2 = this.f10075f;
            if (j2 <= 0 || !(n instanceof GraphRequest.f)) {
                return;
            }
            final long j3 = this.f10073d;
            Handler handler = this.a;
            if ((handler == null ? null : Boolean.valueOf(handler.post(new Runnable() { // from class: com.facebook.s
                @Override // java.lang.Runnable
                public final void run() {
                    m0.e(GraphRequest.b.this, j3, j2);
                }
            }))) == null) {
                ((GraphRequest.f) n).a(j3, j2);
            }
            this.f10074e = this.f10073d;
        }
    }
}
