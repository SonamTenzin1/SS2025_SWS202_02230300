package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzet extends q4 {

    /* renamed from: c, reason: collision with root package name */
    private char f18105c;

    /* renamed from: d, reason: collision with root package name */
    private long f18106d;

    /* renamed from: e, reason: collision with root package name */
    private String f18107e;

    /* renamed from: f, reason: collision with root package name */
    private final zzev f18108f;

    /* renamed from: g, reason: collision with root package name */
    private final zzev f18109g;

    /* renamed from: h, reason: collision with root package name */
    private final zzev f18110h;

    /* renamed from: i, reason: collision with root package name */
    private final zzev f18111i;

    /* renamed from: j, reason: collision with root package name */
    private final zzev f18112j;

    /* renamed from: k, reason: collision with root package name */
    private final zzev f18113k;
    private final zzev l;
    private final zzev m;
    private final zzev n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzet(zzfx zzfxVar) {
        super(zzfxVar);
        this.f18105c = (char) 0;
        this.f18106d = -1L;
        this.f18108f = new zzev(this, 6, false, false);
        this.f18109g = new zzev(this, 6, true, false);
        this.f18110h = new zzev(this, 6, false, true);
        this.f18111i = new zzev(this, 5, false, false);
        this.f18112j = new zzev(this, 5, true, false);
        this.f18113k = new zzev(this, 5, false, true);
        this.l = new zzev(this, 4, false, false);
        this.m = new zzev(this, 3, false, false);
        this.n = new zzev(this, 2, false, false);
    }

    @VisibleForTesting
    private final String D() {
        String str;
        synchronized (this) {
            if (this.f18107e == null) {
                if (this.a.O() != null) {
                    this.f18107e = this.a.O();
                } else {
                    this.f18107e = zzx.z();
                }
            }
            str = this.f18107e;
        }
        return str;
    }

    private static String F(String str) {
        if (TextUtils.isEmpty(str)) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object x(String str) {
        if (str == null) {
            return null;
        }
        return new i3(str);
    }

    @VisibleForTesting
    private static String y(boolean z, Object obj) {
        String str;
        String className;
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (obj == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i2 = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str2 = "-";
            }
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str2.length() + 43 + str2.length());
            sb.append(str2);
            sb.append(round);
            sb.append("...");
            sb.append(str2);
            sb.append(round2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String F = F(zzfx.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && F(className).equals(F)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
                i2++;
            }
            return sb2.toString();
        }
        if (!(obj instanceof i3)) {
            return z ? "-" : String.valueOf(obj);
        }
        str = ((i3) obj).a;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String z(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String y = y(z, obj);
        String y2 = y(z, obj2);
        String y3 = y(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(y)) {
            sb.append(str2);
            sb.append(y);
            str2 = ", ";
        }
        if (TextUtils.isEmpty(y2)) {
            str3 = str2;
        } else {
            sb.append(str2);
            sb.append(y2);
        }
        if (!TextUtils.isEmpty(y3)) {
            sb.append(str3);
            sb.append(y3);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final void A(int i2, String str) {
        Log.println(i2, D(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B(int i2, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && C(i2)) {
            A(i2, z(false, str, obj, obj2, obj3));
        }
        if (z2 || i2 < 5) {
            return;
        }
        Preconditions.k(str);
        zzfu F = this.a.F();
        if (F == null) {
            A(6, "Scheduler not set. Not logging error/warn");
        } else {
            if (!F.t()) {
                A(6, "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            F.z(new h3(this, i2 >= 9 ? 8 : i2, str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final boolean C(int i2) {
        return Log.isLoggable(D(), i2);
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    public final zzev H() {
        return this.f18108f;
    }

    public final zzev I() {
        return this.f18109g;
    }

    public final zzev J() {
        return this.f18110h;
    }

    public final zzev K() {
        return this.f18111i;
    }

    public final zzev L() {
        return this.f18112j;
    }

    public final zzev M() {
        return this.f18113k;
    }

    public final zzev N() {
        return this.l;
    }

    public final zzev O() {
        return this.m;
    }

    public final zzev P() {
        return this.n;
    }

    public final String Q() {
        Pair<String, Long> a = m().f17921e.a();
        if (a == null || a == r3.f17919c) {
            return null;
        }
        String valueOf = String.valueOf(a.second);
        String str = (String) a.first;
        StringBuilder sb = new StringBuilder(valueOf.length() + 1 + String.valueOf(str).length());
        sb.append(valueOf);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.q4
    protected final boolean s() {
        return false;
    }
}
