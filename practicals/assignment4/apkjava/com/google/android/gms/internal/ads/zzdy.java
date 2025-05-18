package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzbp;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class zzdy {
    private static final String a = "zzdy";

    /* renamed from: b, reason: collision with root package name */
    protected Context f16182b;

    /* renamed from: c, reason: collision with root package name */
    private ExecutorService f16183c;

    /* renamed from: d, reason: collision with root package name */
    private DexClassLoader f16184d;

    /* renamed from: e, reason: collision with root package name */
    private zzdj f16185e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f16186f;

    /* renamed from: j, reason: collision with root package name */
    private boolean f16190j;
    private zzda m;
    private Map<Pair<String, String>, zzfi> p;

    /* renamed from: g, reason: collision with root package name */
    private volatile AdvertisingIdClient f16187g = null;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f16188h = false;

    /* renamed from: i, reason: collision with root package name */
    private Future f16189i = null;

    /* renamed from: k, reason: collision with root package name */
    private volatile zzbp.zza f16191k = null;
    private Future l = null;
    protected boolean n = false;
    private boolean o = false;
    private boolean q = false;
    private boolean r = true;
    private boolean s = false;

    /* loaded from: classes2.dex */
    final class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zzdy.this.r = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zzdy.this.r = false;
            }
        }

        /* synthetic */ a(zzdy zzdyVar, ly lyVar) {
            this();
        }
    }

    private zzdy(Context context) {
        Context applicationContext = context.getApplicationContext();
        boolean z = applicationContext != null;
        this.f16190j = z;
        this.f16182b = z ? applicationContext : context;
        this.p = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B() {
        try {
            if (this.f16187g == null && this.f16190j) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.f16182b);
                advertisingIdClient.start();
                this.f16187g = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.f16187g = null;
        }
    }

    private final zzbp.zza C() {
        try {
            PackageInfo packageInfo = this.f16182b.getPackageManager().getPackageInfo(this.f16182b.getPackageName(), 0);
            Context context = this.f16182b;
            return zzdal.a(context, context.getPackageName(), Integer.toString(packageInfo.versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static zzdy d(Context context, String str, String str2, boolean z) {
        ly lyVar;
        zzdy zzdyVar = new zzdy(context);
        try {
            zzdyVar.f16183c = Executors.newCachedThreadPool(new ly());
            zzdyVar.f16188h = z;
            if (z) {
                zzdyVar.f16189i = zzdyVar.f16183c.submit(new ny(zzdyVar));
            }
            zzdyVar.f16183c.execute(new py(zzdyVar));
            try {
                GoogleApiAvailabilityLight h2 = GoogleApiAvailabilityLight.h();
                zzdyVar.n = h2.b(zzdyVar.f16182b) > 0;
                zzdyVar.o = h2.i(zzdyVar.f16182b) == 0;
            } catch (Throwable unused) {
            }
            zzdyVar.e(0, true);
            if (zzef.a() && ((Boolean) zzyt.e().c(zzacu.u2)).booleanValue()) {
                throw new IllegalStateException("Task Context initialization must not be called from the UI thread.");
            }
            lyVar = null;
            zzdj zzdjVar = new zzdj(null);
            zzdyVar.f16185e = zzdjVar;
            try {
                zzdyVar.f16186f = zzdjVar.c(str);
            } catch (zzdk e2) {
                throw new zzdv(e2);
            }
        } catch (zzdv unused2) {
        }
        try {
            try {
                try {
                    File cacheDir = zzdyVar.f16182b.getCacheDir();
                    if (cacheDir == null && (cacheDir = zzdyVar.f16182b.getDir("dex", 0)) == null) {
                        throw new zzdv();
                    }
                    File file = new File(String.format("%s/%s.jar", cacheDir, "1542658731108"));
                    if (!file.exists()) {
                        byte[] b2 = zzdyVar.f16185e.b(zzdyVar.f16186f, str2);
                        file.createNewFile();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(b2, 0, b2.length);
                        fileOutputStream.close();
                    }
                    zzdyVar.o(cacheDir, "1542658731108");
                    try {
                        zzdyVar.f16184d = new DexClassLoader(file.getAbsolutePath(), cacheDir.getAbsolutePath(), null, zzdyVar.f16182b.getClassLoader());
                        m(file);
                        zzdyVar.g(cacheDir, "1542658731108");
                        k(String.format("%s/%s.dex", cacheDir, "1542658731108"));
                        if (!zzdyVar.s) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("android.intent.action.USER_PRESENT");
                            intentFilter.addAction("android.intent.action.SCREEN_OFF");
                            zzdyVar.f16182b.registerReceiver(new a(zzdyVar, lyVar), intentFilter);
                            zzdyVar.s = true;
                        }
                        zzdyVar.m = new zzda(zzdyVar);
                        zzdyVar.q = true;
                        return zzdyVar;
                    } catch (Throwable th) {
                        m(file);
                        zzdyVar.g(cacheDir, "1542658731108");
                        k(String.format("%s/%s.dex", cacheDir, "1542658731108"));
                        throw th;
                    }
                } catch (FileNotFoundException e3) {
                    throw new zzdv(e3);
                }
            } catch (IOException e4) {
                throw new zzdv(e4);
            }
        } catch (zzdk e5) {
            throw new zzdv(e5);
        } catch (NullPointerException e6) {
            throw new zzdv(e6);
        }
    }

    private final void g(File file, String str) {
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (file2.exists()) {
            return;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (!file3.exists()) {
            return;
        }
        long length = file3.length();
        if (length <= 0) {
            return;
        }
        byte[] bArr = new byte[(int) length];
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file3);
            try {
                try {
                    if (fileInputStream2.read(bArr) <= 0) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                        m(file3);
                        return;
                    }
                    System.out.print("test");
                    System.out.print("test");
                    System.out.print("test");
                    zzbp.zzd.zza w = zzbp.zzd.D().A(zzdmr.D(Build.VERSION.SDK.getBytes())).w(zzdmr.D(str.getBytes()));
                    byte[] bytes = this.f16185e.d(this.f16186f, bArr).getBytes();
                    w.u(zzdmr.D(bytes)).v(zzdmr.D(ij.e(bytes)));
                    file2.createNewFile();
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        byte[] g2 = ((zzbp.zzd) ((zzdob) w.p0())).g();
                        fileOutputStream.write(g2, 0, g2.length);
                        fileOutputStream.close();
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused2) {
                        }
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                        m(file3);
                    } catch (zzdk | IOException | NoSuchAlgorithmException unused4) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                        m(file3);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused8) {
                            }
                        }
                        m(file3);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (zzdk | IOException | NoSuchAlgorithmException unused9) {
                fileOutputStream = null;
            }
        } catch (zzdk | IOException | NoSuchAlgorithmException unused10) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(int i2, zzbp.zza zzaVar) {
        if (i2 < 4) {
            return zzaVar == null || !zzaVar.d0() || zzaVar.U().equals("0000000000000000000000000000000000000000000000000000000000000000") || !zzaVar.i0() || !zzaVar.j0().x() || zzaVar.j0().y() == -2;
        }
        return false;
    }

    private static void k(String str) {
        m(new File(str));
    }

    private static void m(File file) {
        if (!file.exists()) {
            Log.d(a, String.format("File %s not found. No need for deletion", file.getAbsolutePath()));
        } else {
            file.delete();
        }
    }

    private final boolean o(File file, String str) {
        FileOutputStream fileOutputStream;
        File file2 = new File(String.format("%s/%s.tmp", file, str));
        if (!file2.exists()) {
            return false;
        }
        File file3 = new File(String.format("%s/%s.dex", file, str));
        if (file3.exists()) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            long length = file2.length();
            if (length <= 0) {
                m(file2);
                return false;
            }
            byte[] bArr = new byte[(int) length];
            FileInputStream fileInputStream2 = new FileInputStream(file2);
            try {
                try {
                    if (fileInputStream2.read(bArr) <= 0) {
                        Log.d(a, "Cannot read the cache data.");
                        m(file2);
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                        return false;
                    }
                    zzbp.zzd F = zzbp.zzd.F(bArr, zzdno.e());
                    if (str.equals(new String(F.B().c())) && Arrays.equals(F.z().c(), ij.e(F.y().c())) && Arrays.equals(F.C().c(), Build.VERSION.SDK.getBytes())) {
                        byte[] b2 = this.f16185e.b(this.f16186f, new String(F.y().c()));
                        file3.createNewFile();
                        fileOutputStream = new FileOutputStream(file3);
                        try {
                            fileOutputStream.write(b2, 0, b2.length);
                            try {
                                fileInputStream2.close();
                            } catch (IOException unused2) {
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                            return true;
                        } catch (zzdk | IOException | NoSuchAlgorithmException unused4) {
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused6) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException unused7) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    throw th;
                                } catch (IOException unused8) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    }
                    m(file2);
                    try {
                        fileInputStream2.close();
                    } catch (IOException unused9) {
                    }
                    return false;
                } catch (zzdk | IOException | NoSuchAlgorithmException unused10) {
                    fileOutputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (zzdk | IOException | NoSuchAlgorithmException unused11) {
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public final Future A() {
        return this.l;
    }

    public final AdvertisingIdClient D() {
        if (!this.f16188h) {
            return null;
        }
        if (this.f16187g != null) {
            return this.f16187g;
        }
        Future future = this.f16189i;
        if (future != null) {
            try {
                future.get(2000L, TimeUnit.MILLISECONDS);
                this.f16189i = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.f16189i.cancel(true);
            }
        }
        return this.f16187g;
    }

    public final Context a() {
        return this.f16182b;
    }

    public final boolean b() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(int i2, boolean z) {
        if (this.o) {
            Future<?> submit = this.f16183c.submit(new oy(this, i2, z));
            if (i2 == 0) {
                this.l = submit;
            }
        }
    }

    public final boolean j(String str, String str2, Class<?>... clsArr) {
        if (this.p.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.p.put(new Pair<>(str, str2), new zzfi(this, str, str2, clsArr));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbp.zza l(int i2, boolean z) {
        if (i2 > 0 && z) {
            try {
                Thread.sleep(i2 * 1000);
            } catch (InterruptedException unused) {
            }
        }
        return C();
    }

    public final Method p(String str, String str2) {
        zzfi zzfiVar = this.p.get(new Pair(str, str2));
        if (zzfiVar == null) {
            return null;
        }
        return zzfiVar.d();
    }

    public final int q() {
        if (this.m != null) {
            return zzda.d();
        }
        return Integer.MIN_VALUE;
    }

    public final ExecutorService r() {
        return this.f16183c;
    }

    public final DexClassLoader s() {
        return this.f16184d;
    }

    public final zzdj t() {
        return this.f16185e;
    }

    public final byte[] u() {
        return this.f16186f;
    }

    public final boolean v() {
        return this.n;
    }

    public final zzda w() {
        return this.m;
    }

    public final boolean x() {
        return this.o;
    }

    public final boolean y() {
        return this.r;
    }

    public final zzbp.zza z() {
        return this.f16191k;
    }
}
