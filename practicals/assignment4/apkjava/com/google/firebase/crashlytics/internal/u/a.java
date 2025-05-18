package com.google.firebase.crashlytics.internal.u;

/* compiled from: MiddleOutFallbackStrategy.java */
/* loaded from: classes2.dex */
public class a implements d {
    private final int a;

    /* renamed from: b, reason: collision with root package name */
    private final d[] f19575b;

    /* renamed from: c, reason: collision with root package name */
    private final b f19576c;

    public a(int i2, d... dVarArr) {
        this.a = i2;
        this.f19575b = dVarArr;
        this.f19576c = new b(i2);
    }

    @Override // com.google.firebase.crashlytics.internal.u.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (d dVar : this.f19575b) {
            if (stackTraceElementArr2.length <= this.a) {
                break;
            }
            stackTraceElementArr2 = dVar.a(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.a ? this.f19576c.a(stackTraceElementArr2) : stackTraceElementArr2;
    }
}
