package com.facebook.o0.k0;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.text.v;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MetadataRule.kt */
/* loaded from: classes.dex */
public final class e {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Set<e> f10153b = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    private final String f10154c;

    /* renamed from: d, reason: collision with root package name */
    private final String f10155d;

    /* renamed from: e, reason: collision with root package name */
    private final List<String> f10156e;

    /* compiled from: MetadataRule.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        private final void a(JSONObject jSONObject) {
            List v0;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("k");
                    String optString2 = optJSONObject.optString("v");
                    m.e(optString, "k");
                    if (!(optString.length() == 0)) {
                        Set set = e.f10153b;
                        m.e(next, RoomNotification.KEY);
                        v0 = v.v0(optString, new String[]{","}, false, 0, 6, null);
                        m.e(optString2, "v");
                        set.add(new e(next, v0, optString2, null));
                    }
                }
            }
        }

        public final Set<String> b() {
            HashSet hashSet = new HashSet();
            Iterator it = e.f10153b.iterator();
            while (it.hasNext()) {
                hashSet.add(((e) it.next()).c());
            }
            return hashSet;
        }

        public final Set<e> c() {
            return new HashSet(e.f10153b);
        }

        public final void d(String str) {
            m.f(str, "rulesFromServer");
            try {
                e.f10153b.clear();
                a(new JSONObject(str));
            } catch (JSONException unused) {
            }
        }
    }

    private e(String str, List<String> list, String str2) {
        this.f10154c = str;
        this.f10155d = str2;
        this.f10156e = list;
    }

    public /* synthetic */ e(String str, List list, String str2, g gVar) {
        this(str, list, str2);
    }

    public final List<String> b() {
        return new ArrayList(this.f10156e);
    }

    public final String c() {
        return this.f10154c;
    }

    public final String d() {
        return this.f10155d;
    }
}
