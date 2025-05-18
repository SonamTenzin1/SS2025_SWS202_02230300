package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import cm.aptoide.pt.account.view.LoginActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.HttpUrl;

/* compiled from: NativeProtocol.kt */
/* loaded from: classes2.dex */
public final class k0 {
    public static final k0 a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f9789b;

    /* renamed from: c, reason: collision with root package name */
    private static final List<e> f9790c;

    /* renamed from: d, reason: collision with root package name */
    private static final List<e> f9791d;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, List<e>> f9792e;

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicBoolean f9793f;

    /* renamed from: g, reason: collision with root package name */
    private static final Integer[] f9794g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.kt */
    /* loaded from: classes2.dex */
    public static final class a extends e {
        @Override // com.facebook.internal.k0.e
        public /* bridge */ /* synthetic */ String c() {
            return (String) g();
        }

        @Override // com.facebook.internal.k0.e
        public String d() {
            return "com.facebook.arstudio.player";
        }

        public Void g() {
            return null;
        }
    }

    /* compiled from: NativeProtocol.kt */
    /* loaded from: classes2.dex */
    private static final class b extends e {
        @Override // com.facebook.internal.k0.e
        public String c() {
            return "com.instagram.platform.AppAuthorizeActivity";
        }

        @Override // com.facebook.internal.k0.e
        public String d() {
            return "com.instagram.android";
        }

        @Override // com.facebook.internal.k0.e
        public String e() {
            return "token,signed_request,graph_domain,granted_scopes";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.kt */
    /* loaded from: classes2.dex */
    public static final class c extends e {
        private final boolean g() {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            return com.facebook.a0.c().getApplicationInfo().targetSdkVersion >= 30;
        }

        @Override // com.facebook.internal.k0.e
        public String c() {
            return "com.facebook.katana.ProxyAuth";
        }

        @Override // com.facebook.internal.k0.e
        public String d() {
            return "com.facebook.katana";
        }

        @Override // com.facebook.internal.k0.e
        public void f() {
            if (g()) {
                Log.w(k0.f9789b, "Apps that target Android API 30+ (Android 11+) cannot call Facebook native apps unless the package visibility needs are declared. Please follow https://developers.facebook.com/docs/android/troubleshooting/#faq_267321845055988 to make the declaration.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.kt */
    /* loaded from: classes2.dex */
    public static final class d extends e {
        @Override // com.facebook.internal.k0.e
        public /* bridge */ /* synthetic */ String c() {
            return (String) g();
        }

        @Override // com.facebook.internal.k0.e
        public String d() {
            return "com.facebook.orca";
        }

        public Void g() {
            return null;
        }
    }

    /* compiled from: NativeProtocol.kt */
    /* loaded from: classes2.dex */
    public static abstract class e {
        private TreeSet<Integer> a;

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0019, code lost:
        
            if (kotlin.jvm.internal.m.a(r2 == null ? null : java.lang.Boolean.valueOf(r2.isEmpty()), java.lang.Boolean.FALSE) == false) goto L11;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0033 A[Catch: all -> 0x0038, TRY_LEAVE, TryCatch #0 {, blocks: (B:20:0x0003, B:24:0x0013, B:4:0x0023, B:6:0x0027, B:11:0x0033, B:26:0x000b, B:3:0x001b), top: B:19:0x0003 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final synchronized void a(boolean z) {
            boolean z2;
            if (!z) {
                TreeSet<Integer> treeSet = this.a;
                if (treeSet != null) {
                }
            }
            this.a = k0.a.n(this);
            TreeSet<Integer> treeSet2 = this.a;
            if (treeSet2 != null && !treeSet2.isEmpty()) {
                z2 = false;
                if (z2) {
                    f();
                }
            }
            z2 = true;
            if (z2) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        
            if (kotlin.jvm.internal.m.a(r0 == null ? null : java.lang.Boolean.valueOf(r0.isEmpty()), java.lang.Boolean.FALSE) == false) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final TreeSet<Integer> b() {
            TreeSet<Integer> treeSet = this.a;
            if (treeSet != null) {
            }
            a(false);
            return this.a;
        }

        public abstract String c();

        public abstract String d();

        public String e() {
            return "id_token,token,signed_request,graph_domain";
        }

        public void f() {
        }
    }

    /* compiled from: NativeProtocol.kt */
    /* loaded from: classes2.dex */
    public static final class f {
        public static final a a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private e f9795b;

        /* renamed from: c, reason: collision with root package name */
        private int f9796c;

        /* compiled from: NativeProtocol.kt */
        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }

            public final f a(e eVar, int i2) {
                f fVar = new f(null);
                fVar.f9795b = eVar;
                fVar.f9796c = i2;
                return fVar;
            }

            public final f b() {
                f fVar = new f(null);
                fVar.f9796c = -1;
                return fVar;
            }
        }

        private f() {
        }

        public /* synthetic */ f(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final int c() {
            return this.f9796c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NativeProtocol.kt */
    /* loaded from: classes2.dex */
    public static final class g extends e {
        @Override // com.facebook.internal.k0.e
        public String c() {
            return "com.facebook.katana.ProxyAuth";
        }

        @Override // com.facebook.internal.k0.e
        public String d() {
            return "com.facebook.wakizashi";
        }
    }

    static {
        k0 k0Var = new k0();
        a = k0Var;
        f9789b = k0.class.getName();
        f9790c = k0Var.e();
        f9791d = k0Var.d();
        f9792e = k0Var.c();
        f9793f = new AtomicBoolean(false);
        f9794g = new Integer[]{20210906, 20171115, 20170417, 20170411, 20170213, 20161017, 20160327, 20150702, 20150401, 20141218, 20141107, 20141028, 20141001, 20140701, 20140324, 20140313, 20140204, 20131107, 20131024, 20130618, 20130502, 20121101};
    }

    private k0() {
    }

    public static final Intent A(Context context, Intent intent, e eVar) {
        ResolveInfo resolveService;
        kotlin.jvm.internal.m.f(context, "context");
        if (intent == null || (resolveService = context.getPackageManager().resolveService(intent, 0)) == null) {
            return null;
        }
        y yVar = y.a;
        String str = resolveService.serviceInfo.packageName;
        kotlin.jvm.internal.m.e(str, "resolveInfo.serviceInfo.packageName");
        if (y.a(context, str)) {
            return intent;
        }
        return null;
    }

    private final Map<String, List<e>> c() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d());
        List<e> list = f9790c;
        hashMap.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", list);
        hashMap.put("com.facebook.platform.action.request.FEED_DIALOG", list);
        hashMap.put("com.facebook.platform.action.request.LIKE_DIALOG", list);
        hashMap.put("com.facebook.platform.action.request.APPINVITES_DIALOG", list);
        hashMap.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList);
        hashMap.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList);
        hashMap.put("com.facebook.platform.action.request.CAMERA_EFFECT", f9791d);
        hashMap.put("com.facebook.platform.action.request.SHARE_STORY", list);
        return hashMap;
    }

    private final List<e> d() {
        ArrayList f2;
        f2 = kotlin.collections.u.f(new a());
        f2.addAll(e());
        return f2;
    }

    private final List<e> e() {
        ArrayList f2;
        f2 = kotlin.collections.u.f(new c(), new g());
        return f2;
    }

    private final Uri f(e eVar) {
        Uri parse = Uri.parse("content://" + eVar.d() + ".provider.PlatformProvider/versions");
        kotlin.jvm.internal.m.e(parse, "parse(CONTENT_SCHEME + appInfo.getPackage() + PLATFORM_PROVIDER_VERSIONS)");
        return parse;
    }

    public static final int g(TreeSet<Integer> treeSet, int i2, int[] iArr) {
        kotlin.jvm.internal.m.f(iArr, "versionSpec");
        if (treeSet == null) {
            return -1;
        }
        int length = iArr.length - 1;
        Iterator<Integer> descendingIterator = treeSet.descendingIterator();
        int i3 = -1;
        while (descendingIterator.hasNext()) {
            Integer next = descendingIterator.next();
            kotlin.jvm.internal.m.e(next, "fbAppVersion");
            i3 = Math.max(i3, next.intValue());
            while (length >= 0 && iArr[length] > next.intValue()) {
                length--;
            }
            if (length < 0) {
                return -1;
            }
            if (iArr[length] == next.intValue()) {
                if (length % 2 == 0) {
                    return Math.min(i3, i2);
                }
                return -1;
            }
        }
        return -1;
    }

    public static final Bundle h(FacebookException facebookException) {
        if (facebookException == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("error_description", facebookException.toString());
        if (facebookException instanceof FacebookOperationCanceledException) {
            bundle.putString("error_type", "UserCanceled");
        }
        return bundle;
    }

    public static final Intent i(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, com.facebook.login.r rVar, String str3, String str4, String str5, boolean z3, boolean z4, boolean z5) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(str, "applicationId");
        kotlin.jvm.internal.m.f(collection, "permissions");
        kotlin.jvm.internal.m.f(str2, "e2e");
        kotlin.jvm.internal.m.f(rVar, "defaultAudience");
        kotlin.jvm.internal.m.f(str3, "clientState");
        kotlin.jvm.internal.m.f(str4, "authType");
        b bVar = new b();
        return z(context, a.j(bVar, str, collection, str2, z2, rVar, str3, str4, false, str5, z3, com.facebook.login.z.INSTAGRAM, z4, z5, HttpUrl.FRAGMENT_ENCODE_SET, null, null), bVar);
    }

    private final Intent j(e eVar, String str, Collection<String> collection, String str2, boolean z, com.facebook.login.r rVar, String str3, String str4, boolean z2, String str5, boolean z3, com.facebook.login.z zVar, boolean z4, boolean z5, String str6, String str7, String str8) {
        String c2 = eVar.c();
        if (c2 == null) {
            return null;
        }
        Intent putExtra = new Intent().setClassName(eVar.d(), c2).putExtra("client_id", str);
        kotlin.jvm.internal.m.e(putExtra, "Intent()\n            .setClassName(appInfo.getPackage(), activityName)\n            .putExtra(FACEBOOK_PROXY_AUTH_APP_ID_KEY, applicationId)");
        com.facebook.a0 a0Var = com.facebook.a0.a;
        putExtra.putExtra("facebook_sdk_version", com.facebook.a0.s());
        p0 p0Var = p0.a;
        if (!p0.b0(collection)) {
            putExtra.putExtra("scope", TextUtils.join(",", collection));
        }
        if (!p0.a0(str2)) {
            putExtra.putExtra("e2e", str2);
        }
        putExtra.putExtra("state", str3);
        putExtra.putExtra("response_type", eVar.e());
        putExtra.putExtra("nonce", str6);
        putExtra.putExtra("return_scopes", "true");
        if (z) {
            putExtra.putExtra("default_audience", rVar.k());
        }
        putExtra.putExtra("legacy_override", com.facebook.a0.n());
        putExtra.putExtra(LoginActivity.AUTH_TYPE, str4);
        if (z2) {
            putExtra.putExtra("fail_on_logged_out", true);
        }
        putExtra.putExtra("messenger_page_id", str5);
        putExtra.putExtra("reset_messenger_state", z3);
        if (z4) {
            putExtra.putExtra("fx_app", zVar.toString());
        }
        if (z5) {
            putExtra.putExtra("skip_dedupe", true);
        }
        return putExtra;
    }

    public static final Intent k(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        for (e eVar : f9790c) {
            Intent A = A(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(eVar.d()).addCategory("android.intent.category.DEFAULT"), eVar);
            if (A != null) {
                return A;
            }
        }
        return null;
    }

    public static final Intent l(Intent intent, Bundle bundle, FacebookException facebookException) {
        kotlin.jvm.internal.m.f(intent, "requestIntent");
        UUID o = o(intent);
        if (o == null) {
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", u(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", o.toString());
        if (facebookException != null) {
            bundle2.putBundle("error", h(facebookException));
        }
        intent2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bundle2);
        if (bundle != null) {
            intent2.putExtra("com.facebook.platform.protocol.RESULT_ARGS", bundle);
        }
        return intent2;
    }

    public static final List<Intent> m(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, com.facebook.login.r rVar, String str3, String str4, boolean z3, String str5, boolean z4, boolean z5, boolean z6, String str6, String str7, String str8) {
        kotlin.jvm.internal.m.f(str, "applicationId");
        kotlin.jvm.internal.m.f(collection, "permissions");
        kotlin.jvm.internal.m.f(str2, "e2e");
        kotlin.jvm.internal.m.f(rVar, "defaultAudience");
        kotlin.jvm.internal.m.f(str3, "clientState");
        kotlin.jvm.internal.m.f(str4, "authType");
        List<e> list = f9790c;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            Iterator it2 = it;
            ArrayList arrayList2 = arrayList;
            Intent j2 = a.j(eVar, str, collection, str2, z2, rVar, str3, str4, z3, str5, z4, com.facebook.login.z.FACEBOOK, z5, z6, str6, str7, str8);
            if (j2 != null) {
                arrayList2.add(j2);
            }
            arrayList = arrayList2;
            it = it2;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TreeSet<Integer> n(e eVar) {
        ProviderInfo providerInfo;
        TreeSet<Integer> treeSet = new TreeSet<>();
        com.facebook.a0 a0Var = com.facebook.a0.a;
        ContentResolver contentResolver = com.facebook.a0.c().getContentResolver();
        String[] strArr = {"version"};
        Uri f2 = f(eVar);
        Cursor cursor = null;
        try {
            try {
                providerInfo = com.facebook.a0.c().getPackageManager().resolveContentProvider(kotlin.jvm.internal.m.n(eVar.d(), ".provider.PlatformProvider"), 0);
            } catch (RuntimeException e2) {
                Log.e(f9789b, "Failed to query content resolver.", e2);
                providerInfo = null;
            }
            if (providerInfo != null) {
                try {
                    try {
                        try {
                            cursor = contentResolver.query(f2, strArr, null, null, null);
                        } catch (NullPointerException unused) {
                            Log.e(f9789b, "Failed to query content resolver.");
                        }
                    } catch (SecurityException unused2) {
                        Log.e(f9789b, "Failed to query content resolver.");
                    }
                } catch (IllegalArgumentException unused3) {
                    Log.e(f9789b, "Failed to query content resolver.");
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        treeSet.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("version"))));
                    }
                }
            }
            return treeSet;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static final UUID o(Intent intent) {
        String stringExtra;
        if (intent == null) {
            return null;
        }
        if (v(u(intent))) {
            Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
            stringExtra = bundleExtra != null ? bundleExtra.getString("action_id") : null;
        } else {
            stringExtra = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        }
        if (stringExtra == null) {
            return null;
        }
        try {
            return UUID.fromString(stringExtra);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static final FacebookException p(Bundle bundle) {
        boolean q;
        if (bundle == null) {
            return null;
        }
        String string = bundle.getString("error_type");
        if (string == null) {
            string = bundle.getString("com.facebook.platform.status.ERROR_TYPE");
        }
        String string2 = bundle.getString("error_description");
        if (string2 == null) {
            string2 = bundle.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
        }
        if (string != null) {
            q = kotlin.text.u.q(string, "UserCanceled", true);
            if (q) {
                return new FacebookOperationCanceledException(string2);
            }
        }
        return new FacebookException(string2);
    }

    private final f q(List<? extends e> list, int[] iArr) {
        x();
        if (list == null) {
            return f.a.b();
        }
        for (e eVar : list) {
            int g2 = g(eVar.b(), s(), iArr);
            if (g2 != -1) {
                return f.a.a(eVar, g2);
            }
        }
        return f.a.b();
    }

    public static final int r(int i2) {
        return a.q(f9790c, new int[]{i2}).c();
    }

    public static final int s() {
        return f9794g[0].intValue();
    }

    public static final Bundle t(Intent intent) {
        kotlin.jvm.internal.m.f(intent, "intent");
        if (!v(u(intent))) {
            return intent.getExtras();
        }
        return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
    }

    public static final int u(Intent intent) {
        kotlin.jvm.internal.m.f(intent, "intent");
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    }

    public static final boolean v(int i2) {
        boolean t;
        t = kotlin.collections.n.t(f9794g, Integer.valueOf(i2));
        return t && i2 >= 20140701;
    }

    public static final void x() {
        if (f9793f.compareAndSet(false, true)) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            com.facebook.a0.k().execute(new Runnable() { // from class: com.facebook.internal.j
                @Override // java.lang.Runnable
                public final void run() {
                    k0.y();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y() {
        try {
            Iterator<e> it = f9790c.iterator();
            while (it.hasNext()) {
                it.next().a(true);
            }
        } finally {
            f9793f.set(false);
        }
    }

    public static final Intent z(Context context, Intent intent, e eVar) {
        ResolveInfo resolveActivity;
        kotlin.jvm.internal.m.f(context, "context");
        if (intent == null || (resolveActivity = context.getPackageManager().resolveActivity(intent, 0)) == null) {
            return null;
        }
        y yVar = y.a;
        String str = resolveActivity.activityInfo.packageName;
        kotlin.jvm.internal.m.e(str, "resolveInfo.activityInfo.packageName");
        if (y.a(context, str)) {
            return intent;
        }
        return null;
    }
}
