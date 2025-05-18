package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzcu implements m0 {
    private static final Map<String, zzcu> a = new c.e.a();

    /* renamed from: b, reason: collision with root package name */
    private final SharedPreferences f17360b;

    /* renamed from: c, reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f17361c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f17362d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Map<String, ?> f17363e;

    /* renamed from: f, reason: collision with root package name */
    private final List<zzcc> f17364f;

    private zzcu(SharedPreferences sharedPreferences) {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.google.android.gms.internal.measurement.x0

            /* renamed from: f, reason: collision with root package name */
            private final zzcu f17283f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f17283f = this;
            }

            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                this.f17283f.c(sharedPreferences2, str);
            }
        };
        this.f17361c = onSharedPreferenceChangeListener;
        this.f17362d = new Object();
        this.f17364f = new ArrayList();
        this.f17360b = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcu a(Context context, String str) {
        zzcu zzcuVar;
        SharedPreferences sharedPreferences;
        if (!((!zzby.a() || str.startsWith("direct_boot:")) ? true : zzby.b(context))) {
            return null;
        }
        synchronized (zzcu.class) {
            Map<String, zzcu> map = a;
            zzcuVar = map.get(str);
            if (zzcuVar == null) {
                if (str.startsWith("direct_boot:")) {
                    if (zzby.a()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(str.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(str, 0);
                }
                zzcuVar = new zzcu(sharedPreferences);
                map.put(str, zzcuVar);
            }
        }
        return zzcuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void b() {
        synchronized (zzcu.class) {
            for (zzcu zzcuVar : a.values()) {
                zzcuVar.f17360b.unregisterOnSharedPreferenceChangeListener(zzcuVar.f17361c);
            }
            a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(SharedPreferences sharedPreferences, String str) {
        synchronized (this.f17362d) {
            this.f17363e = null;
            zzcl.g();
        }
        synchronized (this) {
            Iterator<zzcc> it = this.f17364f.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.m0
    public final Object u(String str) {
        Map<String, ?> map = this.f17363e;
        if (map == null) {
            synchronized (this.f17362d) {
                map = this.f17363e;
                if (map == null) {
                    map = this.f17360b.getAll();
                    this.f17363e = map;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
