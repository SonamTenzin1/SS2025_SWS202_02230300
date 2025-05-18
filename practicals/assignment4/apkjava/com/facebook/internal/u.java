package com.facebook.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import c.c.b.c;
import java.util.ArrayList;

/* compiled from: CustomTab.kt */
/* loaded from: classes2.dex */
public class u {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private Uri f9900b;

    /* compiled from: CustomTab.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public Uri a(String str, Bundle bundle) {
            kotlin.jvm.internal.m.f(str, "action");
            p0 p0Var = p0.a;
            n0 n0Var = n0.a;
            String b2 = n0.b();
            StringBuilder sb = new StringBuilder();
            com.facebook.a0 a0Var = com.facebook.a0.a;
            sb.append(com.facebook.a0.n());
            sb.append("/dialog/");
            sb.append(str);
            return p0.e(b2, sb.toString(), bundle);
        }
    }

    public u(String str, Bundle bundle) {
        Uri a2;
        kotlin.jvm.internal.m.f(str, "action");
        bundle = bundle == null ? new Bundle() : bundle;
        e0[] valuesCustom = e0.valuesCustom();
        ArrayList arrayList = new ArrayList(valuesCustom.length);
        for (e0 e0Var : valuesCustom) {
            arrayList.add(e0Var.k());
        }
        if (arrayList.contains(str)) {
            p0 p0Var = p0.a;
            n0 n0Var = n0.a;
            a2 = p0.e(n0.g(), kotlin.jvm.internal.m.n("/dialog/", str), bundle);
        } else {
            a2 = a.a(str, bundle);
        }
        this.f9900b = a2;
    }

    public final boolean a(Activity activity, String str) {
        kotlin.jvm.internal.m.f(activity, "activity");
        c.c.b.c c2 = new c.a(com.facebook.login.q.f10020f.b()).c();
        c2.a.setPackage(str);
        try {
            c2.a(activity, this.f9900b);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(Uri uri) {
        kotlin.jvm.internal.m.f(uri, "<set-?>");
        this.f9900b = uri;
    }
}
