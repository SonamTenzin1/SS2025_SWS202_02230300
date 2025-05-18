package io.rakam.api;

import android.util.Log;

/* compiled from: RakamLog.java */
/* loaded from: classes2.dex */
public class h {
    protected static h a = new h();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f21984b = true;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f21985c = 4;

    private h() {
    }

    public static h d() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str, String str2) {
        if (!this.f21984b || this.f21985c > 3) {
            return 0;
        }
        return Log.d(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(String str, String str2) {
        if (!this.f21984b || this.f21985c > 6) {
            return 0;
        }
        return Log.e(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(String str, String str2, Throwable th) {
        if (!this.f21984b || this.f21985c > 6) {
            return 0;
        }
        return Log.e(str, str2, th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e(String str, String str2) {
        if (!this.f21984b || this.f21985c > 4) {
            return 0;
        }
        return Log.i(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h f(int i2) {
        this.f21985c = i2;
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(String str, String str2) {
        if (!this.f21984b || this.f21985c > 5) {
            return 0;
        }
        return Log.w(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(String str, Throwable th) {
        if (!this.f21984b || this.f21985c > 5) {
            return 0;
        }
        return Log.w(str, th);
    }
}
