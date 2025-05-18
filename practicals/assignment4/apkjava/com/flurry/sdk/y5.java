package com.flurry.sdk;

import android.location.Location;
import android.os.Build;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class y5 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public final int f11149b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11150c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f11151d;

    /* renamed from: e, reason: collision with root package name */
    public final Location f11152e;

    public y5(int i2, boolean z, boolean z2, Location location) {
        this.f11149b = i2;
        this.f11150c = z;
        this.f11151d = z2;
        this.f11152e = location;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        Location location;
        double d2;
        double d3;
        boolean z;
        JSONObject a = super.a();
        a.put("fl.report.location.enabled", this.f11150c);
        if (this.f11150c) {
            a.put("fl.location.permission.status", this.f11151d);
            if (this.f11151d && (location = this.f11152e) != null) {
                int i2 = Build.VERSION.SDK_INT;
                boolean z2 = false;
                double d4 = 0.0d;
                if (i2 >= 26) {
                    d4 = location.getVerticalAccuracyMeters();
                    double bearingAccuracyDegrees = this.f11152e.getBearingAccuracyDegrees();
                    double speedAccuracyMetersPerSecond = this.f11152e.getSpeedAccuracyMetersPerSecond();
                    boolean hasBearingAccuracy = this.f11152e.hasBearingAccuracy();
                    z = this.f11152e.hasSpeedAccuracy();
                    d3 = speedAccuracyMetersPerSecond;
                    d2 = bearingAccuracyDegrees;
                    z2 = hasBearingAccuracy;
                } else {
                    d2 = 0.0d;
                    d3 = 0.0d;
                    z = false;
                }
                a.put("fl.precision.value", this.f11149b);
                a.put("fl.latitude.value", this.f11152e.getLatitude());
                a.put("fl.longitude.value", this.f11152e.getLongitude());
                a.put("fl.horizontal.accuracy.value", this.f11152e.getAccuracy());
                a.put("fl.time.epoch.value", this.f11152e.getTime());
                if (i2 >= 17) {
                    a.put("fl.time.uptime.value", TimeUnit.NANOSECONDS.toMillis(this.f11152e.getElapsedRealtimeNanos()));
                }
                a.put("fl.altitude.value", this.f11152e.getAltitude());
                a.put("fl.vertical.accuracy.value", d4);
                a.put("fl.bearing.value", this.f11152e.getBearing());
                a.put("fl.speed.value", this.f11152e.getSpeed());
                a.put("fl.bearing.accuracy.available", z2);
                a.put("fl.speed.accuracy.available", z);
                a.put("fl.bearing.accuracy.degrees", d2);
                a.put("fl.speed.accuracy.meters.per.sec", d3);
            }
        }
        return a;
    }
}
