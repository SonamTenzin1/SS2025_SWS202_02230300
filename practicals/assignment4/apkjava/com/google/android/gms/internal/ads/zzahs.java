package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbhx;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbic;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzbih;
import java.net.URISyntaxException;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzahs<T extends zzbhx & zzbhy & zzbic & zzbif & zzbih> implements zzaho<T> {
    private final com.google.android.gms.ads.internal.zzb a;

    /* renamed from: b, reason: collision with root package name */
    private final zzapr f13901b;

    public zzahs(com.google.android.gms.ads.internal.zzb zzbVar, zzapr zzaprVar) {
        this.a = zzbVar;
        this.f13901b = zzaprVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static String b(Context context, zzdh zzdhVar, String str, View view, Activity activity) {
        if (zzdhVar == null) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (zzdhVar.g(parse)) {
                parse = zzdhVar.a(parse, context, view, activity);
            }
            return parse.toString();
        } catch (zzdi unused) {
            return str;
        } catch (Exception e2) {
            zzk.zzlk().e(e2, "OpenGmsgHandler.maybeAddClickSignalsToUrl");
            return str;
        }
    }

    private static boolean c(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int d(Map<String, String> map) {
        String str = map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            zzk.zzli();
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            zzk.zzli();
            return 6;
        }
        if ("c".equalsIgnoreCase(str)) {
            return zzk.zzli().s();
        }
        return -1;
    }

    private final void e(boolean z) {
        zzapr zzaprVar = this.f13901b;
        if (zzaprVar != null) {
            zzaprVar.l(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(Object obj, Map map) {
        zzbhx zzbhxVar = (zzbhx) obj;
        String c2 = zzavx.c((String) map.get("u"), zzbhxVar.getContext(), true);
        String str = (String) map.get("a");
        if (str == null) {
            zzbad.i("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.a;
        if (zzbVar != null && !zzbVar.zzkx()) {
            this.a.zzbk(c2);
            return;
        }
        if ("expand".equalsIgnoreCase(str)) {
            if (((zzbhy) zzbhxVar).m()) {
                zzbad.i("Cannot expand WebView that is already expanded.");
                return;
            } else {
                e(false);
                ((zzbic) zzbhxVar).B(c(map), d(map));
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str)) {
            e(false);
            if (c2 != null) {
                ((zzbic) zzbhxVar).g0(c(map), d(map), c2);
                return;
            } else {
                ((zzbic) zzbhxVar).w0(c(map), d(map), (String) map.get("html"), (String) map.get("baseurl"));
                return;
            }
        }
        if ("app".equalsIgnoreCase(str) && "true".equalsIgnoreCase((String) map.get("system_browser"))) {
            e(true);
            if (TextUtils.isEmpty(c2)) {
                zzbad.i("Destination url cannot be empty.");
                return;
            }
            try {
                ((zzbic) zzbhxVar).L(new com.google.android.gms.ads.internal.overlay.zzc(new zzaht(zzbhxVar.getContext(), ((zzbif) zzbhxVar).d(), ((zzbih) zzbhxVar).getView()).d(map)));
                return;
            } catch (ActivityNotFoundException e2) {
                zzbad.i(e2.getMessage());
                return;
            }
        }
        e(true);
        String str2 = (String) map.get("intent_url");
        Intent intent = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                intent = Intent.parseUri(str2, 0);
            } catch (URISyntaxException e3) {
                String valueOf = String.valueOf(str2);
                zzbad.c(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e3);
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            String uri = data.toString();
            if (!TextUtils.isEmpty(uri)) {
                try {
                    uri = b(zzbhxVar.getContext(), ((zzbif) zzbhxVar).d(), uri, ((zzbih) zzbhxVar).getView(), zzbhxVar.a());
                } catch (Exception e4) {
                    zzbad.c("Error occurred while adding signals.", e4);
                    zzk.zzlk().e(e4, "OpenGmsgHandler.onGmsg");
                }
                try {
                    data = Uri.parse(uri);
                } catch (Exception e5) {
                    String valueOf2 = String.valueOf(uri);
                    zzbad.c(valueOf2.length() != 0 ? "Error parsing the uri: ".concat(valueOf2) : new String("Error parsing the uri: "), e5);
                    zzk.zzlk().e(e5, "OpenGmsgHandler.onGmsg");
                }
            }
            intent.setData(data);
        }
        if (intent != null) {
            ((zzbic) zzbhxVar).L(new com.google.android.gms.ads.internal.overlay.zzc(intent));
            return;
        }
        if (!TextUtils.isEmpty(c2)) {
            c2 = b(zzbhxVar.getContext(), ((zzbif) zzbhxVar).d(), c2, ((zzbih) zzbhxVar).getView(), zzbhxVar.a());
        }
        ((zzbic) zzbhxVar).L(new com.google.android.gms.ads.internal.overlay.zzc((String) map.get("i"), c2, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
    }
}
