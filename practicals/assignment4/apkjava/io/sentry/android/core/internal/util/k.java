package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import io.sentry.android.core.s0;
import io.sentry.s4;
import io.sentry.w1;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: ConnectivityChecker.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class k {

    /* compiled from: ConnectivityChecker.java */
    /* loaded from: classes2.dex */
    public enum a {
        CONNECTED,
        NOT_CONNECTED,
        NO_PERMISSION,
        UNKNOWN
    }

    private static a a(Context context, ConnectivityManager connectivityManager, w1 w1Var) {
        if (!q.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            w1Var.c(s4.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return a.NO_PERMISSION;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected() ? a.CONNECTED : a.NOT_CONNECTED;
            }
            w1Var.c(s4.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
            return a.NOT_CONNECTED;
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Could not retrieve Connection Status", th);
            return a.UNKNOWN;
        }
    }

    public static a b(Context context, w1 w1Var) {
        ConnectivityManager e2 = e(context, w1Var);
        if (e2 == null) {
            return a.UNKNOWN;
        }
        return a(context, e2, w1Var);
    }

    @SuppressLint({"ObsoleteSdkInt", "MissingPermission", "NewApi"})
    public static String c(Context context, w1 w1Var, s0 s0Var) {
        boolean z;
        boolean z2;
        ConnectivityManager e2 = e(context, w1Var);
        if (e2 == null) {
            return null;
        }
        boolean z3 = false;
        if (!q.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            w1Var.c(s4.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return null;
        }
        try {
            z = true;
            if (s0Var.d() >= 23) {
                Network activeNetwork = e2.getActiveNetwork();
                if (activeNetwork == null) {
                    w1Var.c(s4.INFO, "Network is null and cannot check network status", new Object[0]);
                    return null;
                }
                NetworkCapabilities networkCapabilities = e2.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities == null) {
                    w1Var.c(s4.INFO, "NetworkCapabilities is null and cannot check network type", new Object[0]);
                    return null;
                }
                boolean hasTransport = networkCapabilities.hasTransport(3);
                z2 = networkCapabilities.hasTransport(1);
                z = networkCapabilities.hasTransport(0);
                z3 = hasTransport;
            } else {
                NetworkInfo activeNetworkInfo = e2.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    w1Var.c(s4.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
                    return null;
                }
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        z2 = true;
                    } else if (type != 9) {
                        z2 = false;
                    } else {
                        z2 = false;
                        z3 = true;
                    }
                    z = false;
                } else {
                    z2 = false;
                }
            }
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Failed to retrieve network info", th);
        }
        if (z3) {
            return "ethernet";
        }
        if (z2) {
            return "wifi";
        }
        if (z) {
            return "cellular";
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    public static String d(NetworkCapabilities networkCapabilities, s0 s0Var) {
        if (s0Var.d() < 21) {
            return null;
        }
        if (networkCapabilities.hasTransport(3)) {
            return "ethernet";
        }
        if (networkCapabilities.hasTransport(1)) {
            return "wifi";
        }
        if (networkCapabilities.hasTransport(0)) {
            return "cellular";
        }
        return null;
    }

    private static ConnectivityManager e(Context context, w1 w1Var) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            w1Var.c(s4.INFO, "ConnectivityManager is null and cannot check network status", new Object[0]);
        }
        return connectivityManager;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static boolean f(Context context, w1 w1Var, s0 s0Var, ConnectivityManager.NetworkCallback networkCallback) {
        if (s0Var.d() < 24) {
            w1Var.c(s4.DEBUG, "NetworkCallbacks need Android N+.", new Object[0]);
            return false;
        }
        ConnectivityManager e2 = e(context, w1Var);
        if (e2 == null) {
            return false;
        }
        if (!q.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            w1Var.c(s4.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return false;
        }
        try {
            e2.registerDefaultNetworkCallback(networkCallback);
            return true;
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "registerDefaultNetworkCallback failed", th);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static void g(Context context, w1 w1Var, s0 s0Var, ConnectivityManager.NetworkCallback networkCallback) {
        ConnectivityManager e2;
        if (s0Var.d() >= 21 && (e2 = e(context, w1Var)) != null) {
            try {
                e2.unregisterNetworkCallback(networkCallback);
            } catch (Throwable th) {
                w1Var.b(s4.ERROR, "unregisterNetworkCallback failed", th);
            }
        }
    }
}
