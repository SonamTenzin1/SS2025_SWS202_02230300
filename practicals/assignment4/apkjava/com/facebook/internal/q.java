package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.FacebookException;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: AttributionIdentifiers.kt */
/* loaded from: classes2.dex */
public final class q {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final String f9826b = q.class.getCanonicalName();

    /* renamed from: c, reason: collision with root package name */
    public static q f9827c;

    /* renamed from: d, reason: collision with root package name */
    private String f9828d;

    /* renamed from: e, reason: collision with root package name */
    private long f9829e;

    /* renamed from: f, reason: collision with root package name */
    private String f9830f;

    /* renamed from: g, reason: collision with root package name */
    private String f9831g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9832h;

    /* compiled from: AttributionIdentifiers.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final q a(q qVar) {
            qVar.f9829e = System.currentTimeMillis();
            q.f9827c = qVar;
            return qVar;
        }

        private final q b(Context context) {
            q c2 = c(context);
            if (c2 != null) {
                return c2;
            }
            q d2 = d(context);
            return d2 == null ? new q() : d2;
        }

        private final q c(Context context) {
            Object R;
            try {
                if (!g(context)) {
                    return null;
                }
                p0 p0Var = p0.a;
                boolean z = false;
                Method J = p0.J("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
                if (J == null || (R = p0.R(null, J, context)) == null) {
                    return null;
                }
                Method I = p0.I(R.getClass(), "getId", new Class[0]);
                Method I2 = p0.I(R.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
                if (I != null && I2 != null) {
                    q qVar = new q();
                    qVar.f9828d = (String) p0.R(R, I, new Object[0]);
                    Boolean bool = (Boolean) p0.R(R, I2, new Object[0]);
                    if (bool != null) {
                        z = bool.booleanValue();
                    }
                    qVar.f9832h = z;
                    return qVar;
                }
                return null;
            } catch (Exception e2) {
                p0 p0Var2 = p0.a;
                p0.i0("android_id", e2);
                return null;
            }
        }

        private final q d(Context context) {
            if (!g(context)) {
                return null;
            }
            c cVar = new c();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                try {
                    if (context.bindService(intent, cVar, 1)) {
                        b bVar = new b(cVar.a());
                        q qVar = new q();
                        qVar.f9828d = bVar.H();
                        qVar.f9832h = bVar.P();
                        return qVar;
                    }
                } catch (Exception e2) {
                    p0 p0Var = p0.a;
                    p0.i0("android_id", e2);
                } finally {
                    context.unbindService(cVar);
                }
            } catch (SecurityException unused) {
            }
            return null;
        }

        private final String f(Context context) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return packageManager.getInstallerPackageName(context.getPackageName());
        }

        private final boolean g(Context context) {
            p0 p0Var = p0.a;
            Method J = p0.J("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
            if (J == null) {
                return false;
            }
            Object R = p0.R(null, J, context);
            return (R instanceof Integer) && kotlin.jvm.internal.m.a(R, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x008b A[Catch: all -> 0x00fc, Exception -> 0x00fe, TryCatch #4 {Exception -> 0x00fe, all -> 0x00fc, blocks: (B:3:0x0010, B:5:0x001e, B:7:0x0022, B:11:0x0033, B:13:0x0055, B:15:0x0064, B:17:0x0085, B:19:0x008b, B:21:0x0090, B:23:0x0095, B:57:0x006e, B:59:0x007d, B:61:0x00f4, B:62:0x00fb), top: B:2:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0090 A[Catch: all -> 0x00fc, Exception -> 0x00fe, TryCatch #4 {Exception -> 0x00fe, all -> 0x00fc, blocks: (B:3:0x0010, B:5:0x001e, B:7:0x0022, B:11:0x0033, B:13:0x0055, B:15:0x0064, B:17:0x0085, B:19:0x008b, B:21:0x0090, B:23:0x0095, B:57:0x006e, B:59:0x007d, B:61:0x00f4, B:62:0x00fb), top: B:2:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0095 A[Catch: all -> 0x00fc, Exception -> 0x00fe, TRY_LEAVE, TryCatch #4 {Exception -> 0x00fe, all -> 0x00fc, blocks: (B:3:0x0010, B:5:0x001e, B:7:0x0022, B:11:0x0033, B:13:0x0055, B:15:0x0064, B:17:0x0085, B:19:0x008b, B:21:0x0090, B:23:0x0095, B:57:0x006e, B:59:0x007d, B:61:0x00f4, B:62:0x00fb), top: B:2:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x011b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final q e(Context context) {
            Cursor cursor;
            Uri uri;
            Uri parse;
            String f2;
            kotlin.jvm.internal.m.f(context, "context");
            q b2 = b(context);
            Cursor cursor2 = null;
            try {
                if (!kotlin.jvm.internal.m.a(Looper.myLooper(), Looper.getMainLooper())) {
                    q qVar = q.f9827c;
                    if (qVar != null && System.currentTimeMillis() - qVar.f9829e < 3600000) {
                        return qVar;
                    }
                    String[] strArr = {"aid", "androidid", "limit_tracking"};
                    ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", 0);
                    ProviderInfo resolveContentProvider2 = context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", 0);
                    if (resolveContentProvider != null) {
                        y yVar = y.a;
                        String str = resolveContentProvider.packageName;
                        kotlin.jvm.internal.m.e(str, "contentProviderInfo.packageName");
                        if (y.a(context, str)) {
                            parse = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
                            uri = parse;
                            f2 = f(context);
                            if (f2 != null) {
                                b2.f9831g = f2;
                            }
                            if (uri == null) {
                                return a(b2);
                            }
                            Cursor query = context.getContentResolver().query(uri, strArr, null, null, null);
                            if (query != null) {
                                try {
                                    if (query.moveToFirst()) {
                                        int columnIndex = query.getColumnIndex("aid");
                                        int columnIndex2 = query.getColumnIndex("androidid");
                                        int columnIndex3 = query.getColumnIndex("limit_tracking");
                                        b2.f9830f = query.getString(columnIndex);
                                        if (columnIndex2 > 0 && columnIndex3 > 0 && b2.h() == null) {
                                            b2.f9828d = query.getString(columnIndex2);
                                            b2.f9832h = Boolean.parseBoolean(query.getString(columnIndex3));
                                        }
                                        query.close();
                                        return a(b2);
                                    }
                                } catch (Exception e2) {
                                    cursor = query;
                                    e = e2;
                                    try {
                                        p0 p0Var = p0.a;
                                        p0.j0(q.f9826b, kotlin.jvm.internal.m.n("Caught unexpected exception in getAttributionId(): ", e));
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        return null;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor2 = cursor;
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    cursor2 = query;
                                    th = th2;
                                    if (cursor2 != null) {
                                    }
                                    throw th;
                                }
                            }
                            q a = a(b2);
                            if (query != null) {
                                query.close();
                            }
                            return a;
                        }
                    }
                    if (resolveContentProvider2 != null) {
                        y yVar2 = y.a;
                        String str2 = resolveContentProvider2.packageName;
                        kotlin.jvm.internal.m.e(str2, "wakizashiProviderInfo.packageName");
                        if (y.a(context, str2)) {
                            parse = Uri.parse("content://com.facebook.wakizashi.provider.AttributionIdProvider");
                            uri = parse;
                            f2 = f(context);
                            if (f2 != null) {
                            }
                            if (uri == null) {
                            }
                        }
                    }
                    uri = null;
                    f2 = f(context);
                    if (f2 != null) {
                    }
                    if (uri == null) {
                    }
                } else {
                    throw new FacebookException("getAttributionIdentifiers cannot be called on the main thread.");
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
        }

        public final boolean h(Context context) {
            kotlin.jvm.internal.m.f(context, "context");
            q e2 = e(context);
            return e2 != null && e2.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AttributionIdentifiers.kt */
    /* loaded from: classes2.dex */
    public static final class b implements IInterface {

        /* renamed from: f, reason: collision with root package name */
        public static final a f9833f = new a(null);

        /* renamed from: g, reason: collision with root package name */
        private final IBinder f9834g;

        /* compiled from: AttributionIdentifiers.kt */
        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public b(IBinder iBinder) {
            kotlin.jvm.internal.m.f(iBinder, "binder");
            this.f9834g = iBinder;
        }

        public final String H() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            kotlin.jvm.internal.m.e(obtain, "obtain()");
            Parcel obtain2 = Parcel.obtain();
            kotlin.jvm.internal.m.e(obtain2, "obtain()");
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f9834g.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean P() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            kotlin.jvm.internal.m.e(obtain, "obtain()");
            Parcel obtain2 = Parcel.obtain();
            kotlin.jvm.internal.m.e(obtain2, "obtain()");
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f9834g.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f9834g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AttributionIdentifiers.kt */
    /* loaded from: classes2.dex */
    public static final class c implements ServiceConnection {

        /* renamed from: f, reason: collision with root package name */
        private final AtomicBoolean f9835f = new AtomicBoolean(false);

        /* renamed from: g, reason: collision with root package name */
        private final BlockingQueue<IBinder> f9836g = new LinkedBlockingDeque();

        public final IBinder a() throws InterruptedException {
            if (!this.f9835f.compareAndSet(true, true)) {
                IBinder take = this.f9836g.take();
                kotlin.jvm.internal.m.e(take, "queue.take()");
                return take;
            }
            throw new IllegalStateException("Binder already consumed".toString());
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.f9836g.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public final String h() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (com.facebook.a0.w() && com.facebook.a0.b()) {
            return this.f9828d;
        }
        return null;
    }

    public final String i() {
        return this.f9831g;
    }

    public final String j() {
        return this.f9830f;
    }

    public final boolean k() {
        return this.f9832h;
    }
}
