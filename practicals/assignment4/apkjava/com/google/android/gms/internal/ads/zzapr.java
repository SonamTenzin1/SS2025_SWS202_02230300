package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import cm.aptoide.pt.BuildConfig;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;
import java.util.Set;

@zzard
/* loaded from: classes2.dex */
public final class zzapr extends zzaqb {

    /* renamed from: c, reason: collision with root package name */
    private static final Set<String> f14043c = CollectionUtils.g("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");

    /* renamed from: d, reason: collision with root package name */
    private String f14044d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f14045e;

    /* renamed from: f, reason: collision with root package name */
    private int f14046f;

    /* renamed from: g, reason: collision with root package name */
    private int f14047g;

    /* renamed from: h, reason: collision with root package name */
    private int f14048h;

    /* renamed from: i, reason: collision with root package name */
    private int f14049i;

    /* renamed from: j, reason: collision with root package name */
    private int f14050j;

    /* renamed from: k, reason: collision with root package name */
    private int f14051k;
    private final Object l;
    private final zzbgz m;
    private final Activity n;
    private zzbin o;
    private ImageView p;
    private LinearLayout q;
    private zzaqc r;
    private PopupWindow s;
    private RelativeLayout t;
    private ViewGroup u;

    public zzapr(zzbgz zzbgzVar, zzaqc zzaqcVar) {
        super(zzbgzVar, "resize");
        this.f14044d = "top-right";
        this.f14045e = true;
        this.f14046f = 0;
        this.f14047g = 0;
        this.f14048h = -1;
        this.f14049i = 0;
        this.f14050j = 0;
        this.f14051k = -1;
        this.l = new Object();
        this.m = zzbgzVar;
        this.n = zzbgzVar.a();
        this.r = zzaqcVar;
    }

    public final void h(int i2, int i3, boolean z) {
        synchronized (this.l) {
            this.f14046f = i2;
            this.f14047g = i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x0235 A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:72:0x0291, B:73:0x0296, B:75:0x0298, B:77:0x02ba, B:79:0x02be, B:81:0x02ce, B:82:0x02fe, B:85:0x0330, B:86:0x0364, B:98:0x03ba, B:99:0x03e9, B:101:0x0401, B:102:0x0420, B:104:0x0428, B:105:0x042f, B:106:0x0455, B:110:0x0458, B:112:0x0468, B:113:0x0472, B:115:0x0484, B:116:0x049b, B:118:0x046d, B:119:0x03c1, B:120:0x03c8, B:121:0x03cf, B:122:0x03d6, B:123:0x03dc, B:124:0x03e3, B:125:0x0368, B:128:0x0372, B:131:0x037c, B:134:0x0386, B:137:0x0390, B:140:0x039a, B:144:0x02fb, B:145:0x049d, B:146:0x04a2, B:148:0x0235, B:150:0x0239, B:151:0x024a, B:154:0x0276, B:156:0x027a, B:157:0x0289, B:158:0x027d, B:160:0x0285, B:161:0x026e, B:163:0x0274, B:164:0x014b, B:166:0x014f, B:167:0x0155, B:176:0x01a2, B:177:0x0213, B:179:0x0216, B:181:0x0219, B:183:0x021d, B:186:0x01b0, B:187:0x01e0, B:188:0x01c1, B:189:0x01d4, B:190:0x01e3, B:191:0x01fa, B:192:0x020a, B:193:0x0159, B:196:0x0163, B:199:0x016d, B:202:0x0177, B:205:0x0181, B:208:0x018b, B:212:0x0225, B:213:0x022b, B:214:0x04a4, B:215:0x04a9), top: B:3:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0216 A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:72:0x0291, B:73:0x0296, B:75:0x0298, B:77:0x02ba, B:79:0x02be, B:81:0x02ce, B:82:0x02fe, B:85:0x0330, B:86:0x0364, B:98:0x03ba, B:99:0x03e9, B:101:0x0401, B:102:0x0420, B:104:0x0428, B:105:0x042f, B:106:0x0455, B:110:0x0458, B:112:0x0468, B:113:0x0472, B:115:0x0484, B:116:0x049b, B:118:0x046d, B:119:0x03c1, B:120:0x03c8, B:121:0x03cf, B:122:0x03d6, B:123:0x03dc, B:124:0x03e3, B:125:0x0368, B:128:0x0372, B:131:0x037c, B:134:0x0386, B:137:0x0390, B:140:0x039a, B:144:0x02fb, B:145:0x049d, B:146:0x04a2, B:148:0x0235, B:150:0x0239, B:151:0x024a, B:154:0x0276, B:156:0x027a, B:157:0x0289, B:158:0x027d, B:160:0x0285, B:161:0x026e, B:163:0x0274, B:164:0x014b, B:166:0x014f, B:167:0x0155, B:176:0x01a2, B:177:0x0213, B:179:0x0216, B:181:0x0219, B:183:0x021d, B:186:0x01b0, B:187:0x01e0, B:188:0x01c1, B:189:0x01d4, B:190:0x01e3, B:191:0x01fa, B:192:0x020a, B:193:0x0159, B:196:0x0163, B:199:0x016d, B:202:0x0177, B:205:0x0181, B:208:0x018b, B:212:0x0225, B:213:0x022b, B:214:0x04a4, B:215:0x04a9), top: B:3:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0291 A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:72:0x0291, B:73:0x0296, B:75:0x0298, B:77:0x02ba, B:79:0x02be, B:81:0x02ce, B:82:0x02fe, B:85:0x0330, B:86:0x0364, B:98:0x03ba, B:99:0x03e9, B:101:0x0401, B:102:0x0420, B:104:0x0428, B:105:0x042f, B:106:0x0455, B:110:0x0458, B:112:0x0468, B:113:0x0472, B:115:0x0484, B:116:0x049b, B:118:0x046d, B:119:0x03c1, B:120:0x03c8, B:121:0x03cf, B:122:0x03d6, B:123:0x03dc, B:124:0x03e3, B:125:0x0368, B:128:0x0372, B:131:0x037c, B:134:0x0386, B:137:0x0390, B:140:0x039a, B:144:0x02fb, B:145:0x049d, B:146:0x04a2, B:148:0x0235, B:150:0x0239, B:151:0x024a, B:154:0x0276, B:156:0x027a, B:157:0x0289, B:158:0x027d, B:160:0x0285, B:161:0x026e, B:163:0x0274, B:164:0x014b, B:166:0x014f, B:167:0x0155, B:176:0x01a2, B:177:0x0213, B:179:0x0216, B:181:0x0219, B:183:0x021d, B:186:0x01b0, B:187:0x01e0, B:188:0x01c1, B:189:0x01d4, B:190:0x01e3, B:191:0x01fa, B:192:0x020a, B:193:0x0159, B:196:0x0163, B:199:0x016d, B:202:0x0177, B:205:0x0181, B:208:0x018b, B:212:0x0225, B:213:0x022b, B:214:0x04a4, B:215:0x04a9), top: B:3:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0298 A[Catch: all -> 0x04ab, TryCatch #1 {, blocks: (B:4:0x0007, B:6:0x000b, B:7:0x0010, B:10:0x0012, B:12:0x001a, B:13:0x001f, B:15:0x0021, B:17:0x002d, B:18:0x0032, B:20:0x0034, B:22:0x003c, B:23:0x0041, B:25:0x0043, B:27:0x0051, B:28:0x0062, B:30:0x0070, B:31:0x0081, B:33:0x008f, B:34:0x00a0, B:36:0x00ae, B:37:0x00bf, B:39:0x00cd, B:40:0x00db, B:42:0x00e9, B:43:0x00eb, B:45:0x00f1, B:49:0x00fa, B:50:0x00ff, B:52:0x0101, B:54:0x0109, B:57:0x0111, B:61:0x0138, B:67:0x0144, B:72:0x0291, B:73:0x0296, B:75:0x0298, B:77:0x02ba, B:79:0x02be, B:81:0x02ce, B:82:0x02fe, B:85:0x0330, B:86:0x0364, B:98:0x03ba, B:99:0x03e9, B:101:0x0401, B:102:0x0420, B:104:0x0428, B:105:0x042f, B:106:0x0455, B:110:0x0458, B:112:0x0468, B:113:0x0472, B:115:0x0484, B:116:0x049b, B:118:0x046d, B:119:0x03c1, B:120:0x03c8, B:121:0x03cf, B:122:0x03d6, B:123:0x03dc, B:124:0x03e3, B:125:0x0368, B:128:0x0372, B:131:0x037c, B:134:0x0386, B:137:0x0390, B:140:0x039a, B:144:0x02fb, B:145:0x049d, B:146:0x04a2, B:148:0x0235, B:150:0x0239, B:151:0x024a, B:154:0x0276, B:156:0x027a, B:157:0x0289, B:158:0x027d, B:160:0x0285, B:161:0x026e, B:163:0x0274, B:164:0x014b, B:166:0x014f, B:167:0x0155, B:176:0x01a2, B:177:0x0213, B:179:0x0216, B:181:0x0219, B:183:0x021d, B:186:0x01b0, B:187:0x01e0, B:188:0x01c1, B:189:0x01d4, B:190:0x01e3, B:191:0x01fa, B:192:0x020a, B:193:0x0159, B:196:0x0163, B:199:0x016d, B:202:0x0177, B:205:0x0181, B:208:0x018b, B:212:0x0225, B:213:0x022b, B:214:0x04a4, B:215:0x04a9), top: B:3:0x0007, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(Map<String, String> map) {
        boolean z;
        int[] iArr;
        char c2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        synchronized (this.l) {
            if (this.n == null) {
                e("Not an activity context. Cannot resize.");
                return;
            }
            if (this.m.o() == null) {
                e("Webview is not yet available, size is not set.");
                return;
            }
            if (this.m.o().e()) {
                e("Is interstitial. Cannot resize an interstitial.");
                return;
            }
            if (this.m.m()) {
                e("Cannot resize an expanded banner.");
                return;
            }
            if (!TextUtils.isEmpty(map.get("width"))) {
                zzk.zzlg();
                this.f14051k = zzaxi.Q(map.get("width"));
            }
            if (!TextUtils.isEmpty(map.get("height"))) {
                zzk.zzlg();
                this.f14048h = zzaxi.Q(map.get("height"));
            }
            if (!TextUtils.isEmpty(map.get("offsetX"))) {
                zzk.zzlg();
                this.f14049i = zzaxi.Q(map.get("offsetX"));
            }
            if (!TextUtils.isEmpty(map.get("offsetY"))) {
                zzk.zzlg();
                this.f14050j = zzaxi.Q(map.get("offsetY"));
            }
            if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
                this.f14045e = Boolean.parseBoolean(map.get("allowOffscreen"));
            }
            String str = map.get("customClosePosition");
            if (!TextUtils.isEmpty(str)) {
                this.f14044d = str;
            }
            if (!(this.f14051k >= 0 && this.f14048h >= 0)) {
                e("Invalid width and height options. Cannot resize.");
                return;
            }
            Window window = this.n.getWindow();
            if (window != null && window.getDecorView() != null) {
                int[] S = zzk.zzlg().S(this.n);
                int[] W = zzk.zzlg().W(this.n);
                int i8 = S[0];
                int i9 = S[1];
                int i10 = this.f14051k;
                char c3 = 65535;
                if (i10 >= 50 && i10 <= i8) {
                    int i11 = this.f14048h;
                    if (i11 >= 50 && i11 <= i9) {
                        if (i11 == i9 && i10 == i8) {
                            zzbad.i("Cannot resize to a full-screen ad.");
                        } else {
                            if (this.f14045e) {
                                String str2 = this.f14044d;
                                switch (str2.hashCode()) {
                                    case -1364013995:
                                        if (str2.equals("center")) {
                                            c2 = 2;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -1012429441:
                                        if (str2.equals("top-left")) {
                                            c2 = 0;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case -655373719:
                                        if (str2.equals("bottom-left")) {
                                            c2 = 3;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 1163912186:
                                        if (str2.equals("bottom-right")) {
                                            c2 = 5;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 1288627767:
                                        if (str2.equals("bottom-center")) {
                                            c2 = 4;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    case 1755462605:
                                        if (str2.equals("top-center")) {
                                            c2 = 1;
                                            break;
                                        }
                                        c2 = 65535;
                                        break;
                                    default:
                                        c2 = 65535;
                                        break;
                                }
                                if (c2 == 0) {
                                    i2 = this.f14046f + this.f14049i;
                                    i3 = this.f14047g;
                                    i4 = this.f14050j;
                                } else if (c2 != 1) {
                                    if (c2 != 2) {
                                        if (c2 == 3) {
                                            i2 = this.f14046f + this.f14049i;
                                            i6 = this.f14047g + this.f14050j;
                                            i7 = this.f14048h;
                                        } else if (c2 == 4) {
                                            i2 = ((this.f14046f + this.f14049i) + (this.f14051k / 2)) - 25;
                                            i6 = this.f14047g + this.f14050j;
                                            i7 = this.f14048h;
                                        } else if (c2 != 5) {
                                            i2 = ((this.f14046f + this.f14049i) + this.f14051k) - 50;
                                            i3 = this.f14047g;
                                            i4 = this.f14050j;
                                        } else {
                                            i2 = ((this.f14046f + this.f14049i) + this.f14051k) - 50;
                                            i6 = this.f14047g + this.f14050j;
                                            i7 = this.f14048h;
                                        }
                                        i5 = (i6 + i7) - 50;
                                    } else {
                                        i2 = ((this.f14046f + this.f14049i) + (this.f14051k / 2)) - 25;
                                        i5 = ((this.f14047g + this.f14050j) + (this.f14048h / 2)) - 25;
                                    }
                                    if (i2 >= 0) {
                                        if (i2 + 50 <= i8) {
                                            if (i5 >= W[0]) {
                                                if (i5 + 50 <= W[1]) {
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    i2 = ((this.f14046f + this.f14049i) + (this.f14051k / 2)) - 25;
                                    i3 = this.f14047g;
                                    i4 = this.f14050j;
                                }
                                i5 = i3 + i4;
                                if (i2 >= 0) {
                                }
                            }
                            z = true;
                            if (z) {
                                iArr = null;
                            } else if (this.f14045e) {
                                iArr = new int[]{this.f14046f + this.f14049i, this.f14047g + this.f14050j};
                            } else {
                                int[] S2 = zzk.zzlg().S(this.n);
                                int[] W2 = zzk.zzlg().W(this.n);
                                int i12 = S2[0];
                                int i13 = this.f14046f + this.f14049i;
                                int i14 = this.f14047g + this.f14050j;
                                if (i13 < 0) {
                                    i13 = 0;
                                } else {
                                    int i15 = this.f14051k;
                                    if (i13 + i15 > i12) {
                                        i13 = i12 - i15;
                                    }
                                }
                                if (i14 < W2[0]) {
                                    i14 = W2[0];
                                } else {
                                    int i16 = this.f14048h;
                                    if (i14 + i16 > W2[1]) {
                                        i14 = W2[1] - i16;
                                    }
                                }
                                iArr = new int[]{i13, i14};
                            }
                            if (iArr != null) {
                                e("Resize location out of screen or close button is not visible.");
                                return;
                            }
                            zzyt.a();
                            int a = zzazt.a(this.n, this.f14051k);
                            zzyt.a();
                            int a2 = zzazt.a(this.n, this.f14048h);
                            ViewParent parent = this.m.getView().getParent();
                            if (parent != null && (parent instanceof ViewGroup)) {
                                ((ViewGroup) parent).removeView(this.m.getView());
                                PopupWindow popupWindow = this.s;
                                if (popupWindow == null) {
                                    this.u = (ViewGroup) parent;
                                    zzk.zzlg();
                                    Bitmap Z = zzaxi.Z(this.m.getView());
                                    ImageView imageView = new ImageView(this.n);
                                    this.p = imageView;
                                    imageView.setImageBitmap(Z);
                                    this.o = this.m.o();
                                    this.u.addView(this.p);
                                } else {
                                    popupWindow.dismiss();
                                }
                                RelativeLayout relativeLayout = new RelativeLayout(this.n);
                                this.t = relativeLayout;
                                relativeLayout.setBackgroundColor(0);
                                this.t.setLayoutParams(new ViewGroup.LayoutParams(a, a2));
                                zzk.zzlg();
                                PopupWindow c4 = zzaxi.c(this.t, a, a2, false);
                                this.s = c4;
                                c4.setOutsideTouchable(true);
                                this.s.setTouchable(true);
                                this.s.setClippingEnabled(!this.f14045e);
                                this.t.addView(this.m.getView(), -1, -1);
                                this.q = new LinearLayout(this.n);
                                zzyt.a();
                                int a3 = zzazt.a(this.n, 50);
                                zzyt.a();
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a3, zzazt.a(this.n, 50));
                                String str3 = this.f14044d;
                                switch (str3.hashCode()) {
                                    case -1364013995:
                                        if (str3.equals("center")) {
                                            c3 = 2;
                                            break;
                                        }
                                        break;
                                    case -1012429441:
                                        if (str3.equals("top-left")) {
                                            c3 = 0;
                                            break;
                                        }
                                        break;
                                    case -655373719:
                                        if (str3.equals("bottom-left")) {
                                            c3 = 3;
                                            break;
                                        }
                                        break;
                                    case 1163912186:
                                        if (str3.equals("bottom-right")) {
                                            c3 = 5;
                                            break;
                                        }
                                        break;
                                    case 1288627767:
                                        if (str3.equals("bottom-center")) {
                                            c3 = 4;
                                            break;
                                        }
                                        break;
                                    case 1755462605:
                                        if (str3.equals("top-center")) {
                                            c3 = 1;
                                            break;
                                        }
                                        break;
                                }
                                if (c3 == 0) {
                                    layoutParams.addRule(10);
                                    layoutParams.addRule(9);
                                } else if (c3 == 1) {
                                    layoutParams.addRule(10);
                                    layoutParams.addRule(14);
                                } else if (c3 == 2) {
                                    layoutParams.addRule(13);
                                } else if (c3 == 3) {
                                    layoutParams.addRule(12);
                                    layoutParams.addRule(9);
                                } else if (c3 == 4) {
                                    layoutParams.addRule(12);
                                    layoutParams.addRule(14);
                                } else if (c3 != 5) {
                                    layoutParams.addRule(10);
                                    layoutParams.addRule(11);
                                } else {
                                    layoutParams.addRule(12);
                                    layoutParams.addRule(11);
                                }
                                this.q.setOnClickListener(new j3(this));
                                this.q.setContentDescription("Close button");
                                this.t.addView(this.q, layoutParams);
                                try {
                                    PopupWindow popupWindow2 = this.s;
                                    View decorView = window.getDecorView();
                                    zzyt.a();
                                    int a4 = zzazt.a(this.n, iArr[0]);
                                    zzyt.a();
                                    popupWindow2.showAtLocation(decorView, 0, a4, zzazt.a(this.n, iArr[1]));
                                    int i17 = iArr[0];
                                    int i18 = iArr[1];
                                    zzaqc zzaqcVar = this.r;
                                    if (zzaqcVar != null) {
                                        zzaqcVar.b(i17, i18, this.f14051k, this.f14048h);
                                    }
                                    this.m.A(zzbin.j(a, a2));
                                    b(iArr[0], iArr[1] - zzk.zzlg().W(this.n)[0], this.f14051k, this.f14048h);
                                    g("resized");
                                    return;
                                } catch (RuntimeException e2) {
                                    String valueOf = String.valueOf(e2.getMessage());
                                    e(valueOf.length() != 0 ? "Cannot show popup window: ".concat(valueOf) : new String("Cannot show popup window: "));
                                    this.t.removeView(this.m.getView());
                                    ViewGroup viewGroup = this.u;
                                    if (viewGroup != null) {
                                        viewGroup.removeView(this.p);
                                        this.u.addView(this.m.getView());
                                        this.m.A(this.o);
                                    }
                                    return;
                                }
                            }
                            e("Webview is detached, probably in the middle of a resize or expand.");
                            return;
                        }
                        z = false;
                        if (z) {
                        }
                        if (iArr != null) {
                        }
                    }
                    zzbad.i("Height is too small or too large.");
                    z = false;
                    if (z) {
                    }
                    if (iArr != null) {
                    }
                }
                zzbad.i("Width is too small or too large.");
                z = false;
                if (z) {
                }
                if (iArr != null) {
                }
            }
            e("Activity context is not ready, cannot get window or decor view.");
        }
    }

    public final void j(int i2, int i3) {
        this.f14046f = i2;
        this.f14047g = i3;
    }

    public final boolean k() {
        boolean z;
        synchronized (this.l) {
            z = this.s != null;
        }
        return z;
    }

    public final void l(boolean z) {
        synchronized (this.l) {
            PopupWindow popupWindow = this.s;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.t.removeView(this.m.getView());
                ViewGroup viewGroup = this.u;
                if (viewGroup != null) {
                    viewGroup.removeView(this.p);
                    this.u.addView(this.m.getView());
                    this.m.A(this.o);
                }
                if (z) {
                    g(BuildConfig.APTOIDE_THEME);
                    zzaqc zzaqcVar = this.r;
                    if (zzaqcVar != null) {
                        zzaqcVar.c();
                    }
                }
                this.s = null;
                this.t = null;
                this.u = null;
                this.q = null;
            }
        }
    }
}
