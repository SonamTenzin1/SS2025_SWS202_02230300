package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Looper;
import android.telephony.CellSignalStrength;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.flurry.sdk.v;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Scanner;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public class w extends d7<v> {
    protected static long p = 3600000;
    private int A;
    private h7 B;
    private BroadcastReceiver C;
    private ConnectivityManager.NetworkCallback D;
    private PhoneStateListener E;
    protected f7<i7> F;
    private boolean q;
    private boolean r;
    private boolean s;
    private v.a t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    /* loaded from: classes2.dex */
    final class a implements f7<i7> {
        a() {
        }

        @Override // com.flurry.sdk.f7
        public final /* synthetic */ void a(i7 i7Var) {
            if (i7Var.f10835b == g7.FOREGROUND) {
                w.this.d0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network network) {
            w.B(w.this, null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network network) {
            w.B(w.this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            w.B(w.this, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class d extends PhoneStateListener {
        private long a;

        d() {
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.a > w.p) {
                this.a = currentTimeMillis;
                w.B(w.this, signalStrength);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class e extends f2 {

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ SignalStrength f11114h;

        e(SignalStrength signalStrength) {
            this.f11114h = signalStrength;
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            w.this.Q(this.f11114h);
            w.this.d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class f extends f2 {
        f() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() throws Exception {
            w.z().registerNetworkCallback(new NetworkRequest.Builder().build(), w.this.R());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class g extends f2 {
        g() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            w wVar = w.this;
            wVar.r = wVar.H();
            w wVar2 = w.this;
            wVar2.t = wVar2.T();
            w wVar3 = w.this;
            wVar3.t(new v(wVar3.t, w.this.r, w.this.u, w.this.v, w.this.w, w.this.x, w.this.y, w.this.z, w.this.A));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class h extends f2 {
        h() {
        }

        @Override // com.flurry.sdk.f2
        public final void a() {
            boolean H = w.this.H();
            v.a T = w.this.T();
            if (w.this.r == H && w.this.t == T && !w.this.s) {
                return;
            }
            w.this.r = H;
            w.this.t = T;
            w.c0(w.this);
            w wVar = w.this;
            wVar.t(new v(wVar.T(), w.this.r, w.this.u, w.this.v, w.this.w, w.this.x, w.this.y, w.this.z, w.this.A));
        }
    }

    public w(h7 h7Var) {
        super("NetworkProvider");
        this.s = false;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = -1;
        this.F = new a();
        if (o2.a("android.permission.ACCESS_NETWORK_STATE")) {
            I();
            this.B = h7Var;
            h7Var.v(this.F);
        } else {
            this.r = true;
            this.t = v.a.NONE_OR_UNKNOWN;
        }
    }

    static /* synthetic */ void B(w wVar, SignalStrength signalStrength) {
        wVar.m(new e(signalStrength));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public boolean H() {
        if (!o2.a("android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        ConnectivityManager K = K();
        if (K == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return U(K) != v.a.NONE_OR_UNKNOWN;
            }
            NetworkInfo activeNetworkInfo = K.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Throwable th) {
            d1.c(5, "NetworkProvider", "Failed to get Network status: " + th.toString());
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    private synchronized void I() {
        if (this.q) {
            return;
        }
        this.r = H();
        this.t = T();
        if (Build.VERSION.SDK_INT >= 29) {
            m(new f());
        } else {
            b0.a().registerReceiver(S(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        M().listen(W(), 256);
        this.q = true;
    }

    private static ConnectivityManager K() {
        return (ConnectivityManager) b0.a().getSystemService("connectivity");
    }

    private static TelephonyManager M() {
        return (TelephonyManager) b0.a().getSystemService("phone");
    }

    static /* synthetic */ boolean c0(w wVar) {
        wVar.s = false;
        return false;
    }

    private int x(SignalStrength signalStrength) {
        if (signalStrength == null) {
            return this.A;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                Iterator<CellSignalStrength> it = signalStrength.getCellSignalStrengths().iterator();
                while (it.hasNext()) {
                    int dbm = it.next().getDbm();
                    if (dbm != Integer.MAX_VALUE) {
                        return dbm;
                    }
                }
            } catch (NoSuchMethodError unused) {
            }
        }
        char c2 = 0;
        try {
            return ((Integer) signalStrength.getClass().getMethod("getDbm", new Class[0]).invoke(signalStrength, new Object[0])).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            if (signalStrength.isGsm()) {
                int y = y(signalStrength, "getLteDbm", "rsrp", 9);
                if (y != Integer.MAX_VALUE) {
                    return y;
                }
                int y2 = y(signalStrength, "getTdScdmaDbm", "mTdscdma", 14);
                if (y2 <= -25 && y2 != Integer.MAX_VALUE) {
                    if (y2 >= -49) {
                        c2 = 4;
                    } else if (y2 >= -73) {
                        c2 = 3;
                    } else if (y2 >= -97) {
                        c2 = 2;
                    } else if (y2 >= -110) {
                        c2 = 1;
                    }
                }
                if (c2 != 0) {
                    return y2;
                }
                int y3 = y(signalStrength, "getWcdmaDbm", "mWcdma", 17);
                if (y3 != Integer.MAX_VALUE) {
                    return y3;
                }
                int gsmSignalStrength = signalStrength.getGsmSignalStrength();
                if ((gsmSignalStrength == 99 ? -1 : gsmSignalStrength) != -1) {
                    return (gsmSignalStrength * 2) - 113;
                }
                return -1;
            }
            int cdmaDbm = signalStrength.getCdmaDbm();
            int evdoDbm = signalStrength.getEvdoDbm();
            return (evdoDbm != -120 && (cdmaDbm == -120 || cdmaDbm >= evdoDbm)) ? evdoDbm : cdmaDbm;
        }
    }

    private static int y(SignalStrength signalStrength, String str, String str2, int i2) {
        int i3;
        try {
            i3 = ((Integer) signalStrength.getClass().getMethod(str, new Class[0]).invoke(signalStrength, new Object[0])).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            i3 = Integer.MAX_VALUE;
        }
        if (i3 == Integer.MAX_VALUE) {
            String signalStrength2 = signalStrength.toString();
            int indexOf = signalStrength2.indexOf(str2 + "=");
            if (indexOf != -1) {
                Scanner scanner = new Scanner(signalStrength2.substring(indexOf + str2.length() + 1));
                if (scanner.hasNextInt() && (i3 = scanner.nextInt()) == 99) {
                    i3 = Integer.MAX_VALUE;
                }
            }
        }
        if (i3 != Integer.MAX_VALUE) {
            return i3;
        }
        String[] split = signalStrength.toString().split(" ");
        if (split.length <= i2) {
            return i3;
        }
        try {
            int parseInt = Integer.parseInt(split[i2]);
            return parseInt != 99 ? parseInt : Integer.MAX_VALUE;
        } catch (NumberFormatException unused2) {
            return i3;
        }
    }

    static /* synthetic */ ConnectivityManager z() {
        return K();
    }

    @SuppressLint({"MissingPermission"})
    public void Q(SignalStrength signalStrength) {
        TelephonyManager M = M();
        String networkOperatorName = M.getNetworkOperatorName();
        String networkOperator = M.getNetworkOperator();
        String simOperator = M.getSimOperator();
        String simOperatorName = M.getSimOperatorName();
        int i2 = Build.VERSION.SDK_INT;
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        if (i2 >= 28) {
            try {
                CharSequence simCarrierIdName = M.getSimCarrierIdName();
                if (simCarrierIdName != null) {
                    str = simCarrierIdName.toString();
                }
            } catch (NoSuchMethodError unused) {
            }
        }
        int i3 = 0;
        try {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 < 24) {
                i3 = M.getNetworkType();
            } else if (o2.a("android.permission.READ_PHONE_STATE")) {
                i3 = M.getDataNetworkType();
            } else if (i4 < 29) {
                i3 = M.getNetworkType();
            }
        } catch (SecurityException unused2) {
        }
        String num = Integer.toString(i3);
        int x = x(signalStrength);
        if (TextUtils.equals(this.u, networkOperatorName) && TextUtils.equals(this.v, networkOperator) && TextUtils.equals(this.w, simOperator) && TextUtils.equals(this.x, str) && TextUtils.equals(this.y, simOperatorName) && TextUtils.equals(this.z, num) && this.A == x) {
            return;
        }
        d1.c(3, "NetworkProvider", "Cellular Name: " + networkOperatorName + ", Operator: " + networkOperator + ", Sim Operator: " + simOperator + ", Sim Id: " + str + ", Sim Name: " + simOperatorName + ", Band: " + num + ", Signal Strength: " + x);
        this.s = true;
        this.u = networkOperatorName;
        this.v = networkOperator;
        this.w = simOperator;
        this.x = str;
        this.y = simOperatorName;
        this.z = num;
        this.A = x;
    }

    protected ConnectivityManager.NetworkCallback R() {
        if (this.D == null) {
            this.D = new b();
        }
        return this.D;
    }

    protected BroadcastReceiver S() {
        if (this.C == null) {
            this.C = new c();
        }
        return this.C;
    }

    @SuppressLint({"MissingPermission"})
    public v.a T() {
        if (!o2.a("android.permission.ACCESS_NETWORK_STATE")) {
            return v.a.NONE_OR_UNKNOWN;
        }
        ConnectivityManager K = K();
        if (K == null) {
            return v.a.NONE_OR_UNKNOWN;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return U(K);
            }
            return V(K);
        } catch (Throwable th) {
            d1.c(5, "NetworkProvider", "Failed to get Network type: " + th.toString());
            return v.a.NONE_OR_UNKNOWN;
        }
    }

    @SuppressLint({"MissingPermission"})
    public v.a U(ConnectivityManager connectivityManager) {
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            return v.a.NONE_OR_UNKNOWN;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities == null) {
            return v.a.NONE_OR_UNKNOWN;
        }
        if (networkCapabilities.hasTransport(1)) {
            return v.a.WIFI;
        }
        if (networkCapabilities.hasTransport(0)) {
            return v.a.CELL;
        }
        return v.a.NETWORK_AVAILABLE;
    }

    @SuppressLint({"MissingPermission"})
    public v.a V(ConnectivityManager connectivityManager) {
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            int type = activeNetworkInfo.getType();
            if (type != 0) {
                if (type == 1) {
                    return v.a.WIFI;
                }
                if (type != 2 && type != 3 && type != 4 && type != 5) {
                    if (type != 8) {
                        return v.a.NETWORK_AVAILABLE;
                    }
                    return v.a.NONE_OR_UNKNOWN;
                }
            }
            return v.a.CELL;
        }
        return v.a.NONE_OR_UNKNOWN;
    }

    protected PhoneStateListener W() {
        if (this.E == null) {
            try {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                    Looper.loop();
                }
                this.E = new d();
            } catch (Throwable th) {
                d1.c(5, "NetworkProvider", "Failed to initialize PhoneStateListener: " + th.toString());
            }
        }
        return this.E;
    }

    public boolean Z() {
        return this.r;
    }

    public void d0() {
        m(new h());
    }

    @Override // com.flurry.sdk.d7
    public void v(f7<v> f7Var) {
        super.v(f7Var);
        m(new g());
    }
}
