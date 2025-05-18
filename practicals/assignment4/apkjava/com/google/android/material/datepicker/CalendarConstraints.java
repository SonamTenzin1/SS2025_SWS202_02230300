package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    private final Month f18541f;

    /* renamed from: g, reason: collision with root package name */
    private final Month f18542g;

    /* renamed from: h, reason: collision with root package name */
    private final Month f18543h;

    /* renamed from: i, reason: collision with root package name */
    private final DateValidator f18544i;

    /* renamed from: j, reason: collision with root package name */
    private final int f18545j;

    /* renamed from: k, reason: collision with root package name */
    private final int f18546k;

    /* loaded from: classes2.dex */
    public interface DateValidator extends Parcelable {
        boolean F0(long j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<CalendarConstraints> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints[] newArray(int i2) {
            return new CalendarConstraints[i2];
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        static final long a = o.a(Month.k(1900, 0).l);

        /* renamed from: b, reason: collision with root package name */
        static final long f18547b = o.a(Month.k(2100, 11).l);

        /* renamed from: c, reason: collision with root package name */
        private long f18548c;

        /* renamed from: d, reason: collision with root package name */
        private long f18549d;

        /* renamed from: e, reason: collision with root package name */
        private Long f18550e;

        /* renamed from: f, reason: collision with root package name */
        private DateValidator f18551f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(CalendarConstraints calendarConstraints) {
            this.f18548c = a;
            this.f18549d = f18547b;
            this.f18551f = DateValidatorPointForward.a(Long.MIN_VALUE);
            this.f18548c = calendarConstraints.f18541f.l;
            this.f18549d = calendarConstraints.f18542g.l;
            this.f18550e = Long.valueOf(calendarConstraints.f18543h.l);
            this.f18551f = calendarConstraints.f18544i;
        }

        public CalendarConstraints a() {
            if (this.f18550e == null) {
                long u = f.u();
                long j2 = this.f18548c;
                if (j2 > u || u > this.f18549d) {
                    u = j2;
                }
                this.f18550e = Long.valueOf(u);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f18551f);
            return new CalendarConstraints(Month.q(this.f18548c), Month.q(this.f18549d), Month.q(this.f18550e.longValue()), (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY"), null);
        }

        public b b(long j2) {
            this.f18550e = Long.valueOf(j2);
            return this;
        }
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, Month month3, DateValidator dateValidator, a aVar) {
        this(month, month2, month3, dateValidator);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month e(Month month) {
        if (month.compareTo(this.f18541f) < 0) {
            return this.f18541f;
        }
        return month.compareTo(this.f18542g) > 0 ? this.f18542g : month;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f18541f.equals(calendarConstraints.f18541f) && this.f18542g.equals(calendarConstraints.f18542g) && this.f18543h.equals(calendarConstraints.f18543h) && this.f18544i.equals(calendarConstraints.f18544i);
    }

    public DateValidator f() {
        return this.f18544i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month g() {
        return this.f18542g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f18546k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f18541f, this.f18542g, this.f18543h, this.f18544i});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month i() {
        return this.f18543h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month j() {
        return this.f18541f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f18545j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f18541f, 0);
        parcel.writeParcelable(this.f18542g, 0);
        parcel.writeParcelable(this.f18543h, 0);
        parcel.writeParcelable(this.f18544i, 0);
    }

    private CalendarConstraints(Month month, Month month2, Month month3, DateValidator dateValidator) {
        this.f18541f = month;
        this.f18542g = month2;
        this.f18543h = month3;
        this.f18544i = dateValidator;
        if (month.compareTo(month3) <= 0) {
            if (month3.compareTo(month2) <= 0) {
                this.f18546k = month.G(month2) + 1;
                this.f18545j = (month2.f18558i - month.f18558i) + 1;
                return;
            }
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        throw new IllegalArgumentException("start Month cannot be after current Month");
    }
}
