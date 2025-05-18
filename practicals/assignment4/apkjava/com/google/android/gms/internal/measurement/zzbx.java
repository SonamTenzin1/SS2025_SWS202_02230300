package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;
import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzbx implements m0 {
    private static final Map<Uri, zzbx> a = new c.e.a();

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f17334b = {RoomNotification.KEY, "value"};

    /* renamed from: c, reason: collision with root package name */
    private final ContentResolver f17335c;

    /* renamed from: d, reason: collision with root package name */
    private final Uri f17336d;

    /* renamed from: e, reason: collision with root package name */
    private final ContentObserver f17337e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f17338f;

    /* renamed from: g, reason: collision with root package name */
    private volatile Map<String, String> f17339g;

    /* renamed from: h, reason: collision with root package name */
    private final List<zzcc> f17340h;

    private zzbx(ContentResolver contentResolver, Uri uri) {
        k0 k0Var = new k0(this, null);
        this.f17337e = k0Var;
        this.f17338f = new Object();
        this.f17340h = new ArrayList();
        this.f17335c = contentResolver;
        this.f17336d = uri;
        contentResolver.registerContentObserver(uri, false, k0Var);
    }

    public static zzbx a(ContentResolver contentResolver, Uri uri) {
        zzbx zzbxVar;
        synchronized (zzbx.class) {
            Map<Uri, zzbx> map = a;
            zzbxVar = map.get(uri);
            if (zzbxVar == null) {
                try {
                    zzbx zzbxVar2 = new zzbx(contentResolver, uri);
                    try {
                        map.put(uri, zzbxVar2);
                    } catch (SecurityException unused) {
                    }
                    zzbxVar = zzbxVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzbxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void d() {
        synchronized (zzbx.class) {
            for (zzbx zzbxVar : a.values()) {
                zzbxVar.f17335c.unregisterContentObserver(zzbxVar.f17337e);
            }
            a.clear();
        }
    }

    private final Map<String, String> f() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                return (Map) zzce.a(new zzcd(this) { // from class: com.google.android.gms.internal.measurement.l0
                    private final zzbx a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = this;
                    }

                    @Override // com.google.android.gms.internal.measurement.zzcd
                    public final Object a() {
                        return this.a.e();
                    }
                });
            } catch (SQLiteException | IllegalStateException | SecurityException unused) {
                Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public final Map<String, String> b() {
        Map<String, String> map = this.f17339g;
        if (map == null) {
            synchronized (this.f17338f) {
                map = this.f17339g;
                if (map == null) {
                    map = f();
                    this.f17339g = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void c() {
        synchronized (this.f17338f) {
            this.f17339g = null;
            zzcl.g();
        }
        synchronized (this) {
            Iterator<zzcc> it = this.f17340h.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map e() {
        Map hashMap;
        Cursor query = this.f17335c.query(this.f17336d, f17334b, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                hashMap = new c.e.a(count);
            } else {
                hashMap = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                hashMap.put(query.getString(0), query.getString(1));
            }
            return hashMap;
        } finally {
            query.close();
        }
    }

    @Override // com.google.android.gms.internal.measurement.m0
    public final /* synthetic */ Object u(String str) {
        return b().get(str);
    }
}
