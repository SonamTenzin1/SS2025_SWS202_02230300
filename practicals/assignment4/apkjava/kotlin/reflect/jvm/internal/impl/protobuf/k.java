package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

/* compiled from: LazyFieldLite.java */
/* loaded from: classes3.dex */
public class k {
    private d a;

    /* renamed from: b, reason: collision with root package name */
    private f f25443b;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f25444c;

    /* renamed from: d, reason: collision with root package name */
    protected volatile o f25445d;

    protected void a(o oVar) {
        if (this.f25445d != null) {
            return;
        }
        synchronized (this) {
            if (this.f25445d != null) {
                return;
            }
            try {
                if (this.a != null) {
                    this.f25445d = oVar.g().d(this.a, this.f25443b);
                } else {
                    this.f25445d = oVar;
                }
            } catch (IOException unused) {
            }
        }
    }

    public int b() {
        if (this.f25444c) {
            return this.f25445d.e();
        }
        return this.a.size();
    }

    public o c(o oVar) {
        a(oVar);
        return this.f25445d;
    }

    public o d(o oVar) {
        o oVar2 = this.f25445d;
        this.f25445d = oVar;
        this.a = null;
        this.f25444c = true;
        return oVar2;
    }
}
