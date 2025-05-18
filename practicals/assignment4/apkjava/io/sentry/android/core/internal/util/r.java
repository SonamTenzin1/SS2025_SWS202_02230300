package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import io.sentry.android.core.s0;
import io.sentry.s4;
import io.sentry.w1;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: RootChecker.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class r {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    private final Context f22196b;

    /* renamed from: c, reason: collision with root package name */
    private final s0 f22197c;

    /* renamed from: d, reason: collision with root package name */
    private final w1 f22198d;

    /* renamed from: e, reason: collision with root package name */
    private final String[] f22199e;

    /* renamed from: f, reason: collision with root package name */
    private final String[] f22200f;

    /* renamed from: g, reason: collision with root package name */
    private final Runtime f22201g;

    public r(Context context, s0 s0Var, w1 w1Var) {
        this(context, s0Var, w1Var, new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"}, new String[]{"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"}, Runtime.getRuntime());
    }

    private boolean a() {
        for (String str : this.f22199e) {
            try {
            } catch (RuntimeException e2) {
                this.f22198d.a(s4.ERROR, e2, "Error when trying to check if root file %s exists.", str);
            }
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private boolean b(w1 w1Var) {
        s0 s0Var = new s0(w1Var);
        PackageManager packageManager = this.f22196b.getPackageManager();
        if (packageManager != null) {
            for (String str : this.f22200f) {
                try {
                    if (s0Var.d() >= 33) {
                        packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(0L));
                        return true;
                    }
                    packageManager.getPackageInfo(str, 0);
                    return true;
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        if (0 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean c() {
        Process process = null;
        try {
            try {
                Process exec = this.f22201g.exec(new String[]{"/system/xbin/which", "su"});
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream(), a));
                try {
                    boolean z = bufferedReader.readLine() != null;
                    bufferedReader.close();
                    exec.destroy();
                    return z;
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                    throw th;
                }
            } finally {
                if (0 != 0) {
                    process.destroy();
                }
            }
        } catch (IOException unused2) {
            this.f22198d.c(s4.DEBUG, "SU isn't found on this Device.", new Object[0]);
        } catch (Throwable th2) {
            this.f22198d.b(s4.DEBUG, "Error when trying to check if SU exists.", th2);
        }
    }

    private boolean d() {
        String a2 = this.f22197c.a();
        return a2 != null && a2.contains("test-keys");
    }

    public boolean e() {
        return d() || a() || c() || b(this.f22198d);
    }

    r(Context context, s0 s0Var, w1 w1Var, String[] strArr, String[] strArr2, Runtime runtime) {
        this.f22196b = (Context) io.sentry.util.q.c(context, "The application context is required.");
        this.f22197c = (s0) io.sentry.util.q.c(s0Var, "The BuildInfoProvider is required.");
        this.f22198d = (w1) io.sentry.util.q.c(w1Var, "The Logger is required.");
        this.f22199e = (String[]) io.sentry.util.q.c(strArr, "The root Files are required.");
        this.f22200f = (String[]) io.sentry.util.q.c(strArr2, "The root packages are required.");
        this.f22201g = (Runtime) io.sentry.util.q.c(runtime, "The Runtime is required.");
    }
}
