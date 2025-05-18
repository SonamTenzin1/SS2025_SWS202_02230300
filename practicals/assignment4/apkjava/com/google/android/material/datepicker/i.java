package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MonthAdapter.java */
/* loaded from: classes2.dex */
public class i extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    static final int f18610f = o.l().getMaximum(4);

    /* renamed from: g, reason: collision with root package name */
    final Month f18611g;

    /* renamed from: h, reason: collision with root package name */
    final DateSelector<?> f18612h;

    /* renamed from: i, reason: collision with root package name */
    b f18613i;

    /* renamed from: j, reason: collision with root package name */
    final CalendarConstraints f18614j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f18611g = month;
        this.f18612h = dateSelector;
        this.f18614j = calendarConstraints;
    }

    private void e(Context context) {
        if (this.f18613i == null) {
            this.f18613i = new b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i2) {
        return b() + (i2 - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f18611g.v();
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i2) {
        if (i2 < this.f18611g.v() || i2 > h()) {
            return null;
        }
        return Long.valueOf(this.f18611g.x(i(i2)));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextView getView(int i2, View view, ViewGroup viewGroup) {
        Long item;
        e(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(e.e.b.c.h.f21016h, viewGroup, false);
        }
        int b2 = i2 - b();
        if (b2 >= 0) {
            Month month = this.f18611g;
            if (b2 < month.f18560k) {
                int i3 = b2 + 1;
                textView.setTag(month);
                textView.setText(String.valueOf(i3));
                long x = this.f18611g.x(i3);
                if (this.f18611g.f18558i == Month.u().f18558i) {
                    textView.setContentDescription(c.a(x));
                } else {
                    textView.setContentDescription(c.c(x));
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
                item = getItem(i2);
                if (item != null) {
                    return textView;
                }
                if (this.f18614j.f().F0(item.longValue())) {
                    textView.setEnabled(true);
                    Iterator<Long> it = this.f18612h.Q0().iterator();
                    while (it.hasNext()) {
                        if (o.a(item.longValue()) == o.a(it.next().longValue())) {
                            this.f18613i.f18566b.d(textView);
                            return textView;
                        }
                    }
                    if (o.j().getTimeInMillis() == item.longValue()) {
                        this.f18613i.f18567c.d(textView);
                        return textView;
                    }
                    this.f18613i.a.d(textView);
                    return textView;
                }
                textView.setEnabled(false);
                this.f18613i.f18571g.d(textView);
                return textView;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        item = getItem(i2);
        if (item != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(int i2) {
        return i2 % this.f18611g.f18559j == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i2) {
        return (i2 + 1) % this.f18611g.f18559j == 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f18611g.f18560k + b();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2 / this.f18611g.f18559j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return (this.f18611g.v() + this.f18611g.f18560k) - 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    int i(int i2) {
        return (i2 - this.f18611g.v()) + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j(int i2) {
        return i2 >= b() && i2 <= h();
    }
}
