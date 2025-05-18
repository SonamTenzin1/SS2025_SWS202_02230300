package com.facebook.o0.m0;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* compiled from: ViewIndexingTrigger.kt */
/* loaded from: classes.dex */
public final class m implements SensorEventListener {

    /* renamed from: f, reason: collision with root package name */
    public static final a f10300f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private b f10301g;

    /* compiled from: ViewIndexingTrigger.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* compiled from: ViewIndexingTrigger.kt */
    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    public final void a(b bVar) {
        this.f10301g = bVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        kotlin.jvm.internal.m.f(sensor, "sensor");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        kotlin.jvm.internal.m.f(sensorEvent, "event");
        b bVar = this.f10301g;
        if (bVar == null) {
            return;
        }
        float[] fArr = sensorEvent.values;
        double d2 = fArr[0] / 9.80665f;
        double d3 = fArr[1] / 9.80665f;
        double d4 = fArr[2] / 9.80665f;
        Double.isNaN(d2);
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d3);
        Double.isNaN(d4);
        Double.isNaN(d4);
        if (Math.sqrt((d2 * d2) + (d3 * d3) + (d4 * d4)) > 2.3d) {
            bVar.a();
        }
    }
}
