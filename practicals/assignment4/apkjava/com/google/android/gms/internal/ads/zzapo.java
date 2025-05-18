package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import okhttp3.HttpUrl;

@zzard
/* loaded from: classes2.dex */
public final class zzapo extends zzaqb {

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, String> f14036c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f14037d;

    /* renamed from: e, reason: collision with root package name */
    private String f14038e;

    /* renamed from: f, reason: collision with root package name */
    private long f14039f;

    /* renamed from: g, reason: collision with root package name */
    private long f14040g;

    /* renamed from: h, reason: collision with root package name */
    private String f14041h;

    /* renamed from: i, reason: collision with root package name */
    private String f14042i;

    public zzapo(zzbgz zzbgzVar, Map<String, String> map) {
        super(zzbgzVar, "createCalendarEvent");
        this.f14036c = map;
        this.f14037d = zzbgzVar.a();
        this.f14038e = k("description");
        this.f14041h = k("summary");
        this.f14039f = l("start_ticks");
        this.f14040g = l("end_ticks");
        this.f14042i = k("location");
    }

    private final String k(String str) {
        return TextUtils.isEmpty(this.f14036c.get(str)) ? HttpUrl.FRAGMENT_ENCODE_SET : this.f14036c.get(str);
    }

    private final long l(String str) {
        String str2 = this.f14036c.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(14)
    public final Intent h() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.f14038e);
        data.putExtra("eventLocation", this.f14042i);
        data.putExtra("description", this.f14041h);
        long j2 = this.f14039f;
        if (j2 > -1) {
            data.putExtra("beginTime", j2);
        }
        long j3 = this.f14040g;
        if (j3 > -1) {
            data.putExtra("endTime", j3);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void i() {
        if (this.f14037d == null) {
            e("Activity context is not available.");
            return;
        }
        zzk.zzlg();
        if (!zzaxi.y(this.f14037d).e()) {
            e("This feature is not available on the device.");
            return;
        }
        zzk.zzlg();
        AlertDialog.Builder x = zzaxi.x(this.f14037d);
        Resources b2 = zzk.zzlk().b();
        x.setTitle(b2 != null ? b2.getString(R.string.s5) : "Create calendar event");
        x.setMessage(b2 != null ? b2.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        x.setPositiveButton(b2 != null ? b2.getString(R.string.s3) : "Accept", new h3(this));
        x.setNegativeButton(b2 != null ? b2.getString(R.string.s4) : "Decline", new i3(this));
        x.create().show();
    }
}
