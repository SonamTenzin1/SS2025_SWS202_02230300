package com.facebook.o0.m0.n;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.root.execution.Command;
import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import org.json.JSONObject;

/* compiled from: PathComponent.kt */
/* loaded from: classes.dex */
public final class c {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final String f10322b;

    /* renamed from: c, reason: collision with root package name */
    private final int f10323c;

    /* renamed from: d, reason: collision with root package name */
    private final int f10324d;

    /* renamed from: e, reason: collision with root package name */
    private final String f10325e;

    /* renamed from: f, reason: collision with root package name */
    private final String f10326f;

    /* renamed from: g, reason: collision with root package name */
    private final String f10327g;

    /* renamed from: h, reason: collision with root package name */
    private final String f10328h;

    /* renamed from: i, reason: collision with root package name */
    private final int f10329i;

    /* compiled from: PathComponent.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* compiled from: PathComponent.kt */
    /* loaded from: classes.dex */
    public enum b {
        ID(1),
        TEXT(2),
        TAG(4),
        DESCRIPTION(8),
        HINT(16);

        private final int l;

        b(int i2) {
            this.l = i2;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static b[] valuesCustom() {
            b[] valuesCustom = values();
            return (b[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        public final int k() {
            return this.l;
        }
    }

    public c(JSONObject jSONObject) {
        m.f(jSONObject, "component");
        String string = jSONObject.getString("class_name");
        m.e(string, "component.getString(PATH_CLASS_NAME_KEY)");
        this.f10322b = string;
        this.f10323c = jSONObject.optInt("index", -1);
        this.f10324d = jSONObject.optInt(DeepLinkIntentReceiver.DeepLinksKeys.ID);
        String optString = jSONObject.optString(Command.CommandHandler.TEXT);
        m.e(optString, "component.optString(PATH_TEXT_KEY)");
        this.f10325e = optString;
        String optString2 = jSONObject.optString(StoreTabGridRecyclerFragment.BundleCons.TAG);
        m.e(optString2, "component.optString(PATH_TAG_KEY)");
        this.f10326f = optString2;
        String optString3 = jSONObject.optString("description");
        m.e(optString3, "component.optString(PATH_DESCRIPTION_KEY)");
        this.f10327g = optString3;
        String optString4 = jSONObject.optString("hint");
        m.e(optString4, "component.optString(PATH_HINT_KEY)");
        this.f10328h = optString4;
        this.f10329i = jSONObject.optInt("match_bitmask");
    }

    public final String a() {
        return this.f10322b;
    }

    public final String b() {
        return this.f10327g;
    }

    public final String c() {
        return this.f10328h;
    }

    public final int d() {
        return this.f10324d;
    }

    public final int e() {
        return this.f10323c;
    }

    public final int f() {
        return this.f10329i;
    }

    public final String g() {
        return this.f10326f;
    }

    public final String h() {
        return this.f10325e;
    }
}
