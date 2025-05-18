package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public final class DynamiteModule {

    /* renamed from: g, reason: collision with root package name */
    private static Boolean f12198g = null;

    /* renamed from: h, reason: collision with root package name */
    private static String f12199h = null;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f12200i = false;

    /* renamed from: j, reason: collision with root package name */
    private static int f12201j = -1;

    /* renamed from: k, reason: collision with root package name */
    private static Boolean f12202k;
    private static zzq p;
    private static zzr q;
    private final Context r;
    private static final ThreadLocal l = new ThreadLocal();
    private static final ThreadLocal m = new c();
    private static final VersionPolicy.IVersions n = new d();

    @KeepForSdk
    public static final VersionPolicy a = new e();

    /* renamed from: b, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f12193b = new f();

    /* renamed from: c, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f12194c = new g();

    /* renamed from: d, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f12195d = new h();

    /* renamed from: e, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f12196e = new i();

    /* renamed from: f, reason: collision with root package name */
    @KeepForSdk
    public static final VersionPolicy f12197f = new j();
    public static final VersionPolicy o = new k();

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @DynamiteApi
    /* loaded from: classes2.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @KeepForSdk
    /* loaded from: classes2.dex */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzpVar) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzpVar) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes2.dex */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        @KeepForSdk
        /* loaded from: classes2.dex */
        public interface IVersions {
            int a(Context context, String str, boolean z) throws LoadingException;

            int b(Context context, String str);
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
        @KeepForSdk
        /* loaded from: classes2.dex */
        public static class SelectionResult {

            @KeepForSdk
            public int a = 0;

            /* renamed from: b, reason: collision with root package name */
            @KeepForSdk
            public int f12203b = 0;

            /* renamed from: c, reason: collision with root package name */
            @KeepForSdk
            public int f12204c = 0;
        }

        @KeepForSdk
        SelectionResult a(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.k(context);
        this.r = context;
    }

    @KeepForSdk
    public static int a(Context context, String str) {
        try {
            Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!Objects.a(declaredField.get(null), str)) {
                Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
                return 0;
            }
            return declaredField2.getInt(null);
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e2) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage())));
            return 0;
        }
    }

    @KeepForSdk
    public static int c(Context context, String str) {
        return f(context, str, false);
    }

    @KeepForSdk
    public static DynamiteModule e(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        Boolean bool;
        IObjectWrapper y4;
        DynamiteModule dynamiteModule;
        zzr zzrVar;
        Boolean valueOf;
        IObjectWrapper E0;
        ThreadLocal threadLocal = l;
        l lVar = (l) threadLocal.get();
        l lVar2 = new l(null);
        threadLocal.set(lVar2);
        ThreadLocal threadLocal2 = m;
        long longValue = ((Long) threadLocal2.get()).longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            VersionPolicy.SelectionResult a2 = versionPolicy.a(context, str, n);
            Log.i("DynamiteModule", "Considering local module " + str + ":" + a2.a + " and remote module " + str + ":" + a2.f12203b);
            int i2 = a2.f12204c;
            if (i2 != 0) {
                if (i2 == -1) {
                    if (a2.a != 0) {
                        i2 = -1;
                    }
                }
                if (i2 != 1 || a2.f12203b != 0) {
                    if (i2 == -1) {
                        DynamiteModule h2 = h(context, str);
                        if (longValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(Long.valueOf(longValue));
                        }
                        Cursor cursor = lVar2.a;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal.set(lVar);
                        return h2;
                    }
                    if (i2 == 1) {
                        try {
                            int i3 = a2.f12203b;
                            try {
                                synchronized (DynamiteModule.class) {
                                    if (k(context)) {
                                        bool = f12198g;
                                    } else {
                                        throw new LoadingException("Remote loading disabled", null);
                                    }
                                }
                                if (bool != null) {
                                    if (bool.booleanValue()) {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i3);
                                        synchronized (DynamiteModule.class) {
                                            zzrVar = q;
                                        }
                                        if (zzrVar != null) {
                                            l lVar3 = (l) threadLocal.get();
                                            if (lVar3 != null && lVar3.a != null) {
                                                Context applicationContext = context.getApplicationContext();
                                                Cursor cursor2 = lVar3.a;
                                                ObjectWrapper.E0(null);
                                                synchronized (DynamiteModule.class) {
                                                    valueOf = Boolean.valueOf(f12201j >= 2);
                                                }
                                                if (valueOf.booleanValue()) {
                                                    Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                    E0 = zzrVar.E3(ObjectWrapper.E0(applicationContext), str, i3, ObjectWrapper.E0(cursor2));
                                                } else {
                                                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                    E0 = zzrVar.E0(ObjectWrapper.E0(applicationContext), str, i3, ObjectWrapper.E0(cursor2));
                                                }
                                                Context context2 = (Context) ObjectWrapper.k0(E0);
                                                if (context2 != null) {
                                                    dynamiteModule = new DynamiteModule(context2);
                                                } else {
                                                    throw new LoadingException("Failed to get module context", null);
                                                }
                                            } else {
                                                throw new LoadingException("No result cursor", null);
                                            }
                                        } else {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                                        }
                                    } else {
                                        Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i3);
                                        zzq l2 = l(context);
                                        if (l2 != null) {
                                            int E02 = l2.E0();
                                            if (E02 >= 3) {
                                                l lVar4 = (l) threadLocal.get();
                                                if (lVar4 != null) {
                                                    y4 = l2.S4(ObjectWrapper.E0(context), str, i3, ObjectWrapper.E0(lVar4.a));
                                                } else {
                                                    throw new LoadingException("No cached result cursor holder", null);
                                                }
                                            } else if (E02 == 2) {
                                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                y4 = l2.Y4(ObjectWrapper.E0(context), str, i3);
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                y4 = l2.y4(ObjectWrapper.E0(context), str, i3);
                                            }
                                            Object k0 = ObjectWrapper.k0(y4);
                                            if (k0 != null) {
                                                dynamiteModule = new DynamiteModule((Context) k0);
                                            } else {
                                                throw new LoadingException("Failed to load remote module.", null);
                                            }
                                        } else {
                                            throw new LoadingException("Failed to create IDynamiteLoader.", null);
                                        }
                                    }
                                    if (longValue == 0) {
                                        threadLocal2.remove();
                                    } else {
                                        threadLocal2.set(Long.valueOf(longValue));
                                    }
                                    Cursor cursor3 = lVar2.a;
                                    if (cursor3 != null) {
                                        cursor3.close();
                                    }
                                    threadLocal.set(lVar);
                                    return dynamiteModule;
                                }
                                throw new LoadingException("Failed to determine which loading route to use.", null);
                            } catch (RemoteException e2) {
                                throw new LoadingException("Failed to load remote module.", e2, null);
                            } catch (LoadingException e3) {
                                throw e3;
                            } catch (Throwable th) {
                                CrashUtils.a(context, th);
                                throw new LoadingException("Failed to load remote module.", th, null);
                            }
                        } catch (LoadingException e4) {
                            Log.w("DynamiteModule", "Failed to load remote module: " + e4.getMessage());
                            int i4 = a2.a;
                            if (i4 != 0 && versionPolicy.a(context, str, new m(i4, 0)).f12204c == -1) {
                                DynamiteModule h3 = h(context, str);
                                if (longValue == 0) {
                                    m.remove();
                                } else {
                                    m.set(Long.valueOf(longValue));
                                }
                                Cursor cursor4 = lVar2.a;
                                if (cursor4 != null) {
                                    cursor4.close();
                                }
                                l.set(lVar);
                                return h3;
                            }
                            throw new LoadingException("Remote load failed. No local fallback found.", e4, null);
                        }
                    }
                    throw new LoadingException("VersionPolicy returned invalid code:" + i2, null);
                }
            }
            throw new LoadingException("No acceptable module " + str + " found. Local version is " + a2.a + " and remote version is " + a2.f12203b + ".", null);
        } catch (Throwable th2) {
            if (longValue == 0) {
                m.remove();
            } else {
                m.set(Long.valueOf(longValue));
            }
            Cursor cursor5 = lVar2.a;
            if (cursor5 != null) {
                cursor5.close();
            }
            l.set(lVar);
            throw th2;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x01b1 -> B:24:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x01b3 -> B:24:0x01b6). Please report as a decompilation issue!!! */
    public static int f(Context context, String str, boolean z) {
        Field declaredField;
        Throwable th;
        RemoteException e2;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = f12198g;
                int i2 = 0;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e3) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e3.toString());
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                            bool = Boolean.FALSE;
                        } else if (classLoader != null) {
                            try {
                                i(classLoader);
                            } catch (LoadingException unused) {
                            }
                            bool = Boolean.TRUE;
                        } else {
                            if (!k(context)) {
                                return 0;
                            }
                            if (!f12200i) {
                                Boolean bool2 = Boolean.TRUE;
                                if (!bool2.equals(null)) {
                                    try {
                                        int g2 = g(context, str, z, true);
                                        String str2 = f12199h;
                                        if (str2 != null && !str2.isEmpty()) {
                                            ClassLoader a2 = zzb.a();
                                            if (a2 == null) {
                                                if (Build.VERSION.SDK_INT >= 29) {
                                                    String str3 = f12199h;
                                                    Preconditions.k(str3);
                                                    a2 = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                                } else {
                                                    String str4 = f12199h;
                                                    Preconditions.k(str4);
                                                    a2 = new b(str4, ClassLoader.getSystemClassLoader());
                                                }
                                            }
                                            i(a2);
                                            declaredField.set(null, a2);
                                            f12198g = bool2;
                                            return g2;
                                        }
                                        return g2;
                                    } catch (LoadingException unused2) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        }
                        f12198g = bool;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return g(context, str, z, false);
                    } catch (LoadingException e4) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e4.getMessage());
                        return 0;
                    }
                }
                zzq l2 = l(context);
                try {
                    if (l2 != null) {
                        try {
                            int E0 = l2.E0();
                            if (E0 >= 3) {
                                l lVar = (l) l.get();
                                if (lVar != null && (cursor = lVar.a) != null) {
                                    i2 = cursor.getInt(0);
                                } else {
                                    Cursor cursor2 = (Cursor) ObjectWrapper.k0(l2.p5(ObjectWrapper.E0(context), str, z, ((Long) m.get()).longValue()));
                                    if (cursor2 != null) {
                                        try {
                                            if (cursor2.moveToFirst()) {
                                                int i3 = cursor2.getInt(0);
                                                r2 = (i3 <= 0 || !j(cursor2)) ? cursor2 : null;
                                                if (r2 != null) {
                                                    r2.close();
                                                }
                                                i2 = i3;
                                            }
                                        } catch (RemoteException e5) {
                                            e2 = e5;
                                            r2 = cursor2;
                                            Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e2.getMessage());
                                            if (r2 != null) {
                                                r2.close();
                                            }
                                            return i2;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            r2 = cursor2;
                                            if (r2 != null) {
                                                r2.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                }
                            } else if (E0 == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                i2 = l2.V3(ObjectWrapper.E0(context), str, z);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                i2 = l2.E3(ObjectWrapper.E0(context), str, z);
                            }
                        } catch (RemoteException e6) {
                            e2 = e6;
                        }
                    }
                    return i2;
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        } catch (Throwable th4) {
            CrashUtils.a(context, th4);
            throw th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x009f, code lost:
    
        r10.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c9  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int g(Context context, String str, boolean z, boolean z2) throws LoadingException {
        Throwable th;
        Exception e2;
        ?? r0 = 0;
        ?? r02 = 0;
        ?? r03 = 0;
        ?? r04 = 0;
        try {
            try {
                boolean z3 = true;
                Cursor query = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) m.get()).longValue())).build(), null, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            boolean z4 = false;
                            int i2 = query.getInt(0);
                            if (i2 > 0) {
                                synchronized (DynamiteModule.class) {
                                    f12199h = query.getString(2);
                                    int columnIndex = query.getColumnIndex("loaderVersion");
                                    if (columnIndex >= 0) {
                                        f12201j = query.getInt(columnIndex);
                                    }
                                    int columnIndex2 = query.getColumnIndex("disableStandaloneDynamiteLoader2");
                                    if (columnIndex2 >= 0) {
                                        if (query.getInt(columnIndex2) == 0) {
                                            z3 = false;
                                        }
                                        f12200i = z3;
                                        z4 = z3;
                                    }
                                }
                                if (j(query)) {
                                    query = null;
                                }
                            }
                            if (z2 && z4) {
                                throw new LoadingException("forcing fallback to container DynamiteLoader impl", r03 == true ? 1 : 0);
                            }
                            return i2;
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        if (e2 instanceof LoadingException) {
                            throw e2;
                        }
                        throw new LoadingException("V2 version check failed", e2, r02 == true ? 1 : 0);
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.", r04 == true ? 1 : 0);
            } catch (Throwable th2) {
                th = th2;
                r0 = context;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e2 = e4;
        } catch (Throwable th3) {
            th = th3;
            if (r0 != 0) {
            }
            throw th;
        }
    }

    private static DynamiteModule h(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static void i(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        zzp zzpVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzrVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzrVar = (zzr) queryLocalInterface;
                } else {
                    zzrVar = new zzr(iBinder);
                }
            }
            q = zzrVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to instantiate dynamite loader", e2, zzpVar);
        }
    }

    private static boolean j(Cursor cursor) {
        l lVar = (l) l.get();
        if (lVar == null || lVar.a != null) {
            return false;
        }
        lVar.a = cursor;
        return true;
    }

    private static boolean k(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f12202k)) {
            return true;
        }
        boolean z = false;
        if (f12202k == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.h().j(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            f12202k = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider != null && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f12200i = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    private static zzq l(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = p;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzqVar != null) {
                    p = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e2) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e2.getMessage());
            }
            return null;
        }
    }

    @KeepForSdk
    public Context b() {
        return this.r;
    }

    @KeepForSdk
    public IBinder d(String str) throws LoadingException {
        try {
            return (IBinder) this.r.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e2, null);
        }
    }
}
