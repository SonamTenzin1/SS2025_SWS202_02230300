package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: TimeSource.java */
/* loaded from: classes2.dex */
class n {
    private static final n a = new n(null, null);

    /* renamed from: b, reason: collision with root package name */
    private final Long f18622b;

    /* renamed from: c, reason: collision with root package name */
    private final TimeZone f18623c;

    private n(Long l, TimeZone timeZone) {
        this.f18622b = l;
        this.f18623c = timeZone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n c() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Calendar a() {
        return b(this.f18623c);
    }

    Calendar b(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.f18622b;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }
}
