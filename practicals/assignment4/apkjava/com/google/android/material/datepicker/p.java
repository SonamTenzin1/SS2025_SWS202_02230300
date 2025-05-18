package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.e;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: YearGridAdapter.java */
/* loaded from: classes2.dex */
public class p extends RecyclerView.g<b> {
    private final e<?> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: YearGridAdapter.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f18624f;

        a(int i2) {
            this.f18624f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p.this.a.w(p.this.a.o().e(Month.k(this.f18624f, p.this.a.q().f18557h)));
            p.this.a.x(e.k.DAY);
        }
    }

    /* compiled from: YearGridAdapter.java */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.c0 {
        final TextView a;

        b(TextView textView) {
            super(textView);
            this.a = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(e<?> eVar) {
        this.a = eVar;
    }

    private View.OnClickListener h(int i2) {
        return new a(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.a.o().k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i2) {
        return i2 - this.a.o().j().f18558i;
    }

    int j(int i2) {
        return this.a.o().j().f18558i + i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i2) {
        int j2 = j(i2);
        String string = bVar.a.getContext().getString(e.e.b.c.j.n);
        bVar.a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(j2)));
        bVar.a.setContentDescription(String.format(string, Integer.valueOf(j2)));
        com.google.android.material.datepicker.b p = this.a.p();
        Calendar j3 = o.j();
        com.google.android.material.datepicker.a aVar = j3.get(1) == j2 ? p.f18570f : p.f18568d;
        Iterator<Long> it = this.a.r().Q0().iterator();
        while (it.hasNext()) {
            j3.setTimeInMillis(it.next().longValue());
            if (j3.get(1) == j2) {
                aVar = p.f18569e;
            }
        }
        aVar.d(bVar.a);
        bVar.a.setOnClickListener(h(j2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(e.e.b.c.h.m, viewGroup, false));
    }
}
