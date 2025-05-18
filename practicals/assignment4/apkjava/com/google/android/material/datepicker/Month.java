package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    private final Calendar f18555f;

    /* renamed from: g, reason: collision with root package name */
    private final String f18556g;

    /* renamed from: h, reason: collision with root package name */
    final int f18557h;

    /* renamed from: i, reason: collision with root package name */
    final int f18558i;

    /* renamed from: j, reason: collision with root package name */
    final int f18559j;

    /* renamed from: k, reason: collision with root package name */
    final int f18560k;
    final long l;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<Month> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(Parcel parcel) {
            return Month.k(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i2) {
            return new Month[i2];
        }
    }

    private Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar d2 = o.d(calendar);
        this.f18555f = d2;
        this.f18557h = d2.get(2);
        this.f18558i = d2.get(1);
        this.f18559j = d2.getMaximum(7);
        this.f18560k = d2.getActualMaximum(5);
        this.f18556g = o.o().format(d2.getTime());
        this.l = d2.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month k(int i2, int i3) {
        Calendar l = o.l();
        l.set(1, i2);
        l.set(2, i3);
        return new Month(l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month q(long j2) {
        Calendar l = o.l();
        l.setTimeInMillis(j2);
        return new Month(l);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Month u() {
        return new Month(o.j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long E() {
        return this.f18555f.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month F(int i2) {
        Calendar d2 = o.d(this.f18555f);
        d2.add(2, i2);
        return new Month(d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int G(Month month) {
        if (this.f18555f instanceof GregorianCalendar) {
            return ((month.f18558i - this.f18558i) * 12) + (month.f18557h - this.f18557h);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f18557h == month.f18557h && this.f18558i == month.f18558i;
    }

    @Override // java.lang.Comparable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(Month month) {
        return this.f18555f.compareTo(month.f18555f);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f18557h), Integer.valueOf(this.f18558i)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int v() {
        int firstDayOfWeek = this.f18555f.get(7) - this.f18555f.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.f18559j : firstDayOfWeek;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f18558i);
        parcel.writeInt(this.f18557h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long x(int i2) {
        Calendar d2 = o.d(this.f18555f);
        d2.set(5, i2);
        return d2.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String y() {
        return this.f18556g;
    }
}
