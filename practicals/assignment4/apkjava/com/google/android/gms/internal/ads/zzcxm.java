package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.google.android.gms.ads.internal.zzk;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcxm {
    public final JSONObject A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final int H;
    public final int I;
    public final boolean J;
    public final String K;
    public final JSONObject L;
    public final boolean M;
    public final boolean N;
    public final int O;
    public final List<String> a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15724b;

    /* renamed from: c, reason: collision with root package name */
    public final List<String> f15725c;

    /* renamed from: d, reason: collision with root package name */
    public final List<String> f15726d;

    /* renamed from: e, reason: collision with root package name */
    public final int f15727e;

    /* renamed from: f, reason: collision with root package name */
    public final List<String> f15728f;

    /* renamed from: g, reason: collision with root package name */
    public final List<String> f15729g;

    /* renamed from: h, reason: collision with root package name */
    public final List<String> f15730h;

    /* renamed from: i, reason: collision with root package name */
    public final List<String> f15731i;

    /* renamed from: j, reason: collision with root package name */
    public final String f15732j;

    /* renamed from: k, reason: collision with root package name */
    public final String f15733k;
    public final zzato l;
    public final List<String> m;
    public final List<String> n;
    public final List<zzcxn> o;
    public final zzcxq p;
    public final List<String> q;
    public final List<zzcxn> r;
    public final JSONObject s;
    public final String t;
    public final String u;
    public final String v;
    public final String w;
    public final zzauy x;
    public final String y;
    public final JSONObject z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x039e. Please report as an issue. */
    public zzcxm(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        List<String> list;
        char c2;
        List<String> emptyList = Collections.emptyList();
        List<String> emptyList2 = Collections.emptyList();
        List<String> emptyList3 = Collections.emptyList();
        List<String> emptyList4 = Collections.emptyList();
        List<String> emptyList5 = Collections.emptyList();
        Collections.emptyList();
        List<String> emptyList6 = Collections.emptyList();
        List<String> emptyList7 = Collections.emptyList();
        List<String> emptyList8 = Collections.emptyList();
        List<String> emptyList9 = Collections.emptyList();
        List<zzcxn> emptyList10 = Collections.emptyList();
        List<String> emptyList11 = Collections.emptyList();
        List<zzcxn> emptyList12 = Collections.emptyList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        jsonReader.beginObject();
        List<String> list2 = emptyList11;
        List<zzcxn> list3 = emptyList12;
        JSONObject jSONObject5 = jSONObject;
        JSONObject jSONObject6 = jSONObject4;
        zzauy zzauyVar = null;
        zzcxq zzcxqVar = null;
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        String str2 = str;
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i4 = -1;
        int i5 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        int i6 = 0;
        JSONObject jSONObject7 = jSONObject3;
        zzato zzatoVar = null;
        JSONObject jSONObject8 = jSONObject2;
        String str8 = str7;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            String str9 = nextName == null ? HttpUrl.FRAGMENT_ENCODE_SET : nextName;
            List<zzcxn> list4 = emptyList10;
            switch (str9.hashCode()) {
                case -1980587809:
                    list = emptyList9;
                    if (str9.equals("debug_signals")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1965512151:
                    list = emptyList9;
                    if (str9.equals("omid_settings")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1440104884:
                    list = emptyList9;
                    if (str9.equals("is_custom_close_blocked")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1439500848:
                    list = emptyList9;
                    if (str9.equals("orientation")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1428969291:
                    list = emptyList9;
                    if (str9.equals("enable_omid")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1403779768:
                    list = emptyList9;
                    if (str9.equals("showable_impression_type")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -1360811658:
                    list = emptyList9;
                    if (str9.equals("ad_sizes")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -1306015996:
                    list = emptyList9;
                    if (str9.equals("adapters")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -1289032093:
                    list = emptyList9;
                    if (str9.equals("extras")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case -1234181075:
                    list = emptyList9;
                    if (str9.equals("allow_pub_rendered_attribution")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case -1152230954:
                    list = emptyList9;
                    if (str9.equals("ad_type")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case -1146534047:
                    list = emptyList9;
                    if (str9.equals("is_scroll_aware")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case -1115838944:
                    list = emptyList9;
                    if (str9.equals("fill_urls")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case -1081936678:
                    list = emptyList9;
                    if (str9.equals("allocation_id")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case -1078050970:
                    list = emptyList9;
                    if (str9.equals("video_complete_urls")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case -1051269058:
                    list = emptyList9;
                    if (str9.equals("active_view")) {
                        c2 = 15;
                        break;
                    }
                    break;
                case -982608540:
                    list = emptyList9;
                    if (str9.equals("valid_from_timestamp")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case -776859333:
                    list = emptyList9;
                    if (str9.equals("click_urls")) {
                        c2 = 17;
                        break;
                    }
                    break;
                case -544216775:
                    list = emptyList9;
                    if (str9.equals("safe_browsing")) {
                        c2 = 18;
                        break;
                    }
                    break;
                case -437057161:
                    list = emptyList9;
                    if (str9.equals("imp_urls")) {
                        c2 = 19;
                        break;
                    }
                    break;
                case -404326515:
                    list = emptyList9;
                    if (str9.equals("render_timeout_ms")) {
                        c2 = 20;
                        break;
                    }
                    break;
                case -29338502:
                    list = emptyList9;
                    if (str9.equals("allow_custom_click_gesture")) {
                        c2 = 21;
                        break;
                    }
                    break;
                case 3107:
                    list = emptyList9;
                    if (str9.equals("ad")) {
                        c2 = 22;
                        break;
                    }
                    break;
                case 3355:
                    list = emptyList9;
                    if (str9.equals(DeepLinkIntentReceiver.DeepLinksKeys.ID)) {
                        c2 = 23;
                        break;
                    }
                    break;
                case 3076010:
                    list = emptyList9;
                    if (str9.equals("data")) {
                        c2 = 24;
                        break;
                    }
                    break;
                case 63195984:
                    list = emptyList9;
                    if (str9.equals("render_test_label")) {
                        c2 = 25;
                        break;
                    }
                    break;
                case 107433883:
                    list = emptyList9;
                    if (str9.equals("qdata")) {
                        c2 = 26;
                        break;
                    }
                    break;
                case 230323073:
                    list = emptyList9;
                    if (str9.equals("ad_load_urls")) {
                        c2 = 27;
                        break;
                    }
                    break;
                case 418392395:
                    list = emptyList9;
                    if (str9.equals("is_closable_area_disabled")) {
                        c2 = 28;
                        break;
                    }
                    break;
                case 597473788:
                    list = emptyList9;
                    if (str9.equals("debug_dialog_string")) {
                        c2 = 29;
                        break;
                    }
                    break;
                case 673261304:
                    list = emptyList9;
                    if (str9.equals("reward_granted_urls")) {
                        c2 = 30;
                        break;
                    }
                    break;
                case 754887508:
                    list = emptyList9;
                    if (str9.equals("container_sizes")) {
                        c2 = 31;
                        break;
                    }
                    break;
                case 791122864:
                    list = emptyList9;
                    if (str9.equals("impression_type")) {
                        c2 = ' ';
                        break;
                    }
                    break;
                case 1010584092:
                    list = emptyList9;
                    if (str9.equals("transaction_id")) {
                        c2 = '!';
                        break;
                    }
                    break;
                case 1100650276:
                    list = emptyList9;
                    if (str9.equals("rewards")) {
                        c2 = '\"';
                        break;
                    }
                    break;
                case 1321720943:
                    list = emptyList9;
                    if (str9.equals("allow_pub_owned_ad_view")) {
                        c2 = '#';
                        break;
                    }
                    break;
                case 1637553475:
                    list = emptyList9;
                    if (str9.equals("bid_response")) {
                        c2 = '$';
                        break;
                    }
                    break;
                case 1638957285:
                    list = emptyList9;
                    if (str9.equals("video_start_urls")) {
                        c2 = '%';
                        break;
                    }
                    break;
                case 1688341040:
                    list = emptyList9;
                    if (str9.equals("video_reward_urls")) {
                        c2 = '&';
                        break;
                    }
                    break;
                case 1839650832:
                    list = emptyList9;
                    if (str9.equals("renderers")) {
                        c2 = '\'';
                        break;
                    }
                    break;
                case 1875425491:
                    list = emptyList9;
                    if (str9.equals("is_analytics_logging_enabled")) {
                        c2 = '(';
                        break;
                    }
                    break;
                case 2072888499:
                    list = emptyList9;
                    if (str9.equals("manual_tracking_urls")) {
                        c2 = ')';
                        break;
                    }
                    break;
                default:
                    list = emptyList9;
                    break;
            }
            c2 = 65535;
            switch (c2) {
                case 0:
                    jSONObject8 = zzazc.m(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 1:
                    jSONObject6 = zzazc.m(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 2:
                    z5 = jsonReader.nextBoolean();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 3:
                    String nextString = jsonReader.nextString();
                    if ("landscape".equalsIgnoreCase(nextString)) {
                        zzk.zzli();
                        i4 = 6;
                    } else if ("portrait".equalsIgnoreCase(nextString)) {
                        zzk.zzli();
                        i4 = 7;
                    } else {
                        i4 = -1;
                    }
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 4:
                    z7 = jsonReader.nextBoolean();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 5:
                    i6 = jsonReader.nextInt();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 6:
                    list3 = zzcxn.a(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 7:
                    list2 = zzazc.b(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '\b':
                    jSONObject7 = zzazc.m(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '\t':
                    z = jsonReader.nextBoolean();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '\n':
                    String nextString2 = jsonReader.nextString();
                    if ("banner".equals(nextString2)) {
                        i3 = 1;
                    } else if ("interstitial".equals(nextString2)) {
                        i3 = 2;
                    } else if ("native_express".equals(nextString2)) {
                        i3 = 3;
                    } else if ("native".equals(nextString2)) {
                        i3 = 4;
                    } else {
                        i3 = "rewarded".equals(nextString2) ? 5 : 0;
                    }
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 11:
                    z9 = jsonReader.nextBoolean();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '\f':
                    emptyList8 = zzazc.b(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '\r':
                    str2 = jsonReader.nextString();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 14:
                    emptyList7 = zzazc.b(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 15:
                    str5 = zzazc.m(jsonReader).toString();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 16:
                    str8 = jsonReader.nextString();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 17:
                    emptyList2 = zzazc.b(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 18:
                    zzauyVar = zzauy.y(zzazc.m(jsonReader));
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 19:
                    emptyList3 = zzazc.b(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 20:
                    i5 = jsonReader.nextInt();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 21:
                    z3 = jsonReader.nextBoolean();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 22:
                    zzcxqVar = new zzcxq(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 23:
                    str3 = jsonReader.nextString();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 24:
                    jSONObject5 = zzazc.m(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 25:
                    z4 = jsonReader.nextBoolean();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 26:
                    str4 = jsonReader.nextString();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 27:
                    emptyList4 = zzazc.b(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 28:
                    z6 = jsonReader.nextBoolean();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 29:
                    str6 = jsonReader.nextString();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 30:
                    zzazc.b(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case 31:
                    emptyList10 = zzcxn.a(jsonReader);
                    emptyList9 = list;
                    break;
                case ' ':
                    int nextInt = jsonReader.nextInt();
                    i2 = (nextInt == 0 || nextInt == 1) ? nextInt : 0;
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '!':
                    str = jsonReader.nextString();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '\"':
                    zzatoVar = zzato.y(zzazc.n(jsonReader));
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '#':
                    z2 = jsonReader.nextBoolean();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '$':
                    str7 = jsonReader.nextString();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '%':
                    emptyList5 = zzazc.b(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '&':
                    emptyList6 = zzazc.b(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '\'':
                    emptyList = zzazc.b(jsonReader);
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case '(':
                    z8 = jsonReader.nextBoolean();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
                case ')':
                    emptyList9 = zzazc.b(jsonReader);
                    emptyList10 = list4;
                    break;
                default:
                    jsonReader.skipValue();
                    emptyList10 = list4;
                    emptyList9 = list;
                    break;
            }
        }
        jsonReader.endObject();
        this.a = emptyList;
        this.f15724b = i3;
        this.f15725c = emptyList2;
        this.f15726d = emptyList3;
        this.f15728f = emptyList4;
        this.f15727e = i2;
        this.f15729g = emptyList5;
        this.f15730h = emptyList6;
        this.f15731i = emptyList7;
        this.f15732j = str;
        this.f15733k = str8;
        this.l = zzatoVar;
        this.m = emptyList8;
        this.n = emptyList9;
        this.o = emptyList10;
        this.p = zzcxqVar;
        this.q = list2;
        this.r = list3;
        this.t = str2;
        this.s = jSONObject5;
        this.u = str3;
        this.v = str4;
        this.w = str5;
        this.x = zzauyVar;
        this.y = str6;
        this.z = jSONObject8;
        this.A = jSONObject7;
        this.B = z;
        this.C = z2;
        this.D = z3;
        this.E = z4;
        this.F = z5;
        this.G = z6;
        this.H = i4;
        this.I = i5;
        this.J = z7;
        this.K = str7;
        this.L = jSONObject6;
        this.M = z8;
        this.N = z9;
        this.O = i6;
    }
}
