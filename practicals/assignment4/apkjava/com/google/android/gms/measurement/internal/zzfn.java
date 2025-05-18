package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzfn {
    private final zzfs a;

    public zzfn(zzfs zzfsVar) {
        Preconditions.k(zzfsVar);
        this.a = zzfsVar;
    }

    public static boolean b(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.k(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final void a(Context context, Intent intent) {
        zzfx a = zzfx.a(context, null);
        zzet h2 = a.h();
        if (intent == null) {
            h2.K().a("Receiver called with null intent");
            return;
        }
        a.G();
        String action = intent.getAction();
        h2.P().b("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            h2.P().a("Starting wakeful intent.");
            this.a.a(context, className);
            return;
        }
        if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                a.g().z(new u3(this, a, h2));
            } catch (Exception e2) {
                h2.K().b("Install Referrer Reporter encountered a problem", e2);
            }
            BroadcastReceiver.PendingResult b2 = this.a.b();
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra == null) {
                h2.P().a("Install referrer extras are null");
                if (b2 != null) {
                    b2.finish();
                    return;
                }
                return;
            }
            h2.N().b("Install referrer extras are", stringExtra);
            if (!stringExtra.contains("?")) {
                stringExtra = stringExtra.length() != 0 ? "?".concat(stringExtra) : new String("?");
            }
            Bundle y = a.I().y(Uri.parse(stringExtra));
            if (y == null) {
                h2.P().a("No campaign defined in install referrer broadcast");
                if (b2 != null) {
                    b2.finish();
                    return;
                }
                return;
            }
            long longExtra = intent.getLongExtra("referrer_timestamp_seconds", 0L) * 1000;
            if (longExtra == 0) {
                h2.K().a("Install referrer is missing timestamp");
            }
            a.g().z(new t3(this, a, longExtra, y, context, h2, b2));
        }
    }
}
