package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: e, reason: collision with root package name */
    private static volatile zzaf f12081e;

    /* renamed from: g, reason: collision with root package name */
    private static Context f12083g;
    static final i a = new c(g.k0("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* renamed from: b, reason: collision with root package name */
    static final i f12078b = new d(g.k0("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* renamed from: c, reason: collision with root package name */
    static final i f12079c = new e(g.k0("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* renamed from: d, reason: collision with root package name */
    static final i f12080d = new f(g.k0("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* renamed from: f, reason: collision with root package name */
    private static final Object f12082f = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m a(String str, g gVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return f(str, gVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m b(String str, boolean z, boolean z2, boolean z3) {
        return g(str, z, false, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String c(boolean z, String str, g gVar) throws Exception {
        String str2 = true != (!z && f(str, gVar, true, false).f12088b) ? "not allowed" : "debug cert rejected";
        MessageDigest b2 = AndroidUtilsLight.b("SHA-256");
        Preconditions.k(b2);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, Hex.a(b2.digest(gVar.E0())), Boolean.valueOf(z), "12451000.false");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void d(Context context) {
        synchronized (k.class) {
            if (f12083g != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f12083g = context.getApplicationContext();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                h();
                return f12081e.l();
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return false;
        }
    }

    private static m f(final String str, final g gVar, final boolean z, boolean z2) {
        try {
            h();
            Preconditions.k(f12083g);
            try {
                return f12081e.C1(new zzs(str, gVar, z, z2), ObjectWrapper.E0(f12083g.getPackageManager())) ? m.b() : new l(new Callable() { // from class: com.google.android.gms.common.zze
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return k.c(z, str, gVar);
                    }
                }, null);
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return m.d("module call", e2);
            }
        } catch (DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            return m.d("module init: ".concat(String.valueOf(e3.getMessage())), e3);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    private static m g(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        m d2;
        zzq c4;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.k(f12083g);
            try {
                h();
                zzo zzoVar = new zzo(str, z, false, ObjectWrapper.E0(f12083g), false);
                try {
                    if (z4) {
                        c4 = f12081e.q3(zzoVar);
                    } else {
                        c4 = f12081e.c4(zzoVar);
                    }
                    if (c4.z()) {
                        d2 = m.f(c4.W());
                    } else {
                        String y = c4.y();
                        PackageManager.NameNotFoundException nameNotFoundException = c4.Y() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (y == null) {
                            y = "error checking package certificate";
                        }
                        d2 = m.g(c4.W(), c4.Y(), y, nameNotFoundException);
                    }
                } catch (RemoteException e2) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                    d2 = m.d("module call", e2);
                }
            } catch (DynamiteModule.LoadingException e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                d2 = m.d("module init: ".concat(String.valueOf(e3.getMessage())), e3);
            }
            return d2;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static void h() throws DynamiteModule.LoadingException {
        if (f12081e != null) {
            return;
        }
        Preconditions.k(f12083g);
        synchronized (f12082f) {
            if (f12081e == null) {
                f12081e = com.google.android.gms.common.internal.zzae.P(DynamiteModule.e(f12083g, DynamiteModule.f12196e, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }
}
