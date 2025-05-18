package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.u;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* compiled from: MaterialCalendar.java */
/* loaded from: classes2.dex */
public final class e<S> extends com.google.android.material.datepicker.l<S> {

    /* renamed from: g, reason: collision with root package name */
    static final Object f18577g = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: h, reason: collision with root package name */
    static final Object f18578h = "NAVIGATION_PREV_TAG";

    /* renamed from: i, reason: collision with root package name */
    static final Object f18579i = "NAVIGATION_NEXT_TAG";

    /* renamed from: j, reason: collision with root package name */
    static final Object f18580j = "SELECTOR_TOGGLE_TAG";

    /* renamed from: k, reason: collision with root package name */
    private int f18581k;
    private DateSelector<S> l;
    private CalendarConstraints m;
    private Month n;
    private k o;
    private com.google.android.material.datepicker.b p;
    private RecyclerView q;
    private RecyclerView r;
    private View s;
    private View t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f18582f;

        a(int i2) {
            this.f18582f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.r.smoothScrollToPosition(this.f18582f);
        }
    }

    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes2.dex */
    class b extends androidx.core.view.a {
        b() {
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.d0.c cVar) {
            super.g(view, cVar);
            cVar.a0(null);
        }
    }

    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes2.dex */
    class c extends m {
        final /* synthetic */ int a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i2, boolean z, int i3) {
            super(context, i2, z);
            this.a = i3;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void calculateExtraLayoutSpace(RecyclerView.z zVar, int[] iArr) {
            if (this.a == 0) {
                iArr[0] = e.this.r.getWidth();
                iArr[1] = e.this.r.getWidth();
            } else {
                iArr[0] = e.this.r.getHeight();
                iArr[1] = e.this.r.getHeight();
            }
        }
    }

    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes2.dex */
    class d implements l {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.e.l
        public void a(long j2) {
            if (e.this.m.f().F0(j2)) {
                e.this.l.f1(j2);
                Iterator<com.google.android.material.datepicker.k<S>> it = e.this.f18621f.iterator();
                while (it.hasNext()) {
                    it.next().a(e.this.l.V0());
                }
                e.this.r.getAdapter().notifyDataSetChanged();
                if (e.this.q != null) {
                    e.this.q.getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* renamed from: com.google.android.material.datepicker.e$e, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0197e extends RecyclerView.n {
        private final Calendar a = o.l();

        /* renamed from: b, reason: collision with root package name */
        private final Calendar f18586b = o.l();

        C0197e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.z zVar) {
            int width;
            if ((recyclerView.getAdapter() instanceof p) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                p pVar = (p) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (c.i.j.e<Long, Long> eVar : e.this.l.D()) {
                    Long l = eVar.a;
                    if (l != null && eVar.f3281b != null) {
                        this.a.setTimeInMillis(l.longValue());
                        this.f18586b.setTimeInMillis(eVar.f3281b.longValue());
                        int i2 = pVar.i(this.a.get(1));
                        int i3 = pVar.i(this.f18586b.get(1));
                        View findViewByPosition = gridLayoutManager.findViewByPosition(i2);
                        View findViewByPosition2 = gridLayoutManager.findViewByPosition(i3);
                        int spanCount = i2 / gridLayoutManager.getSpanCount();
                        int spanCount2 = i3 / gridLayoutManager.getSpanCount();
                        int i4 = spanCount;
                        while (i4 <= spanCount2) {
                            View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * i4);
                            if (findViewByPosition3 != null) {
                                int top = findViewByPosition3.getTop() + e.this.p.f18568d.c();
                                int bottom = findViewByPosition3.getBottom() - e.this.p.f18568d.b();
                                int left = i4 == spanCount ? findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2) : 0;
                                if (i4 == spanCount2) {
                                    width = findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2);
                                } else {
                                    width = recyclerView.getWidth();
                                }
                                canvas.drawRect(left, top, width, bottom, e.this.p.f18572h);
                            }
                            i4++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes2.dex */
    public class f extends androidx.core.view.a {
        f() {
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.d0.c cVar) {
            String string;
            super.g(view, cVar);
            if (e.this.t.getVisibility() == 0) {
                string = e.this.getString(e.e.b.c.j.r);
            } else {
                string = e.this.getString(e.e.b.c.j.p);
            }
            cVar.j0(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes2.dex */
    public class g extends RecyclerView.t {
        final /* synthetic */ com.google.android.material.datepicker.j a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MaterialButton f18589b;

        g(com.google.android.material.datepicker.j jVar, MaterialButton materialButton) {
            this.a = jVar;
            this.f18589b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            if (i2 == 0) {
                CharSequence text = this.f18589b.getText();
                if (Build.VERSION.SDK_INT >= 16) {
                    recyclerView.announceForAccessibility(text);
                } else {
                    recyclerView.sendAccessibilityEvent(RecyclerView.l.FLAG_MOVED);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            int findLastVisibleItemPosition;
            if (i2 < 0) {
                findLastVisibleItemPosition = e.this.t().findFirstVisibleItemPosition();
            } else {
                findLastVisibleItemPosition = e.this.t().findLastVisibleItemPosition();
            }
            e.this.n = this.a.h(findLastVisibleItemPosition);
            this.f18589b.setText(this.a.i(findLastVisibleItemPosition));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes2.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes2.dex */
    public class i implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.j f18592f;

        i(com.google.android.material.datepicker.j jVar) {
            this.f18592f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findFirstVisibleItemPosition = e.this.t().findFirstVisibleItemPosition() + 1;
            if (findFirstVisibleItemPosition < e.this.r.getAdapter().getItemCount()) {
                e.this.w(this.f18592f.h(findFirstVisibleItemPosition));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.datepicker.j f18594f;

        j(com.google.android.material.datepicker.j jVar) {
            this.f18594f = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findLastVisibleItemPosition = e.this.t().findLastVisibleItemPosition() - 1;
            if (findLastVisibleItemPosition >= 0) {
                e.this.w(this.f18594f.h(findLastVisibleItemPosition));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes2.dex */
    public enum k {
        DAY,
        YEAR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MaterialCalendar.java */
    /* loaded from: classes2.dex */
    public interface l {
        void a(long j2);
    }

    private void m(View view, com.google.android.material.datepicker.j jVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(e.e.b.c.f.f21007j);
        materialButton.setTag(f18580j);
        u.i0(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(e.e.b.c.f.l);
        materialButton2.setTag(f18578h);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(e.e.b.c.f.f21008k);
        materialButton3.setTag(f18579i);
        this.s = view.findViewById(e.e.b.c.f.s);
        this.t = view.findViewById(e.e.b.c.f.n);
        x(k.DAY);
        materialButton.setText(this.n.y());
        this.r.addOnScrollListener(new g(jVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(jVar));
        materialButton2.setOnClickListener(new j(jVar));
    }

    private RecyclerView.n n() {
        return new C0197e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(Context context) {
        return context.getResources().getDimensionPixelSize(e.e.b.c.d.y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> e<T> u(DateSelector<T> dateSelector, int i2, CalendarConstraints calendarConstraints) {
        e<T> eVar = new e<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.i());
        eVar.setArguments(bundle);
        return eVar;
    }

    private void v(int i2) {
        this.r.post(new a(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarConstraints o() {
        return this.m;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f18581k = bundle.getInt("THEME_RES_ID_KEY");
        this.l = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.m = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.n = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f18581k);
        this.p = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month j2 = this.m.j();
        if (com.google.android.material.datepicker.f.s(contextThemeWrapper)) {
            i2 = e.e.b.c.h.l;
            i3 = 1;
        } else {
            i2 = e.e.b.c.h.f21018j;
            i3 = 0;
        }
        View inflate = cloneInContext.inflate(i2, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(e.e.b.c.f.o);
        u.i0(gridView, new b());
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.d());
        gridView.setNumColumns(j2.f18559j);
        gridView.setEnabled(false);
        this.r = (RecyclerView) inflate.findViewById(e.e.b.c.f.r);
        this.r.setLayoutManager(new c(getContext(), i3, false, i3));
        this.r.setTag(f18577g);
        com.google.android.material.datepicker.j jVar = new com.google.android.material.datepicker.j(contextThemeWrapper, this.l, this.m, new d());
        this.r.setAdapter(jVar);
        int integer = contextThemeWrapper.getResources().getInteger(e.e.b.c.g.f21009b);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(e.e.b.c.f.s);
        this.q = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.q.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.q.setAdapter(new p(this));
            this.q.addItemDecoration(n());
        }
        if (inflate.findViewById(e.e.b.c.f.f21007j) != null) {
            m(inflate, jVar);
        }
        if (!com.google.android.material.datepicker.f.s(contextThemeWrapper)) {
            new androidx.recyclerview.widget.k().attachToRecyclerView(this.r);
        }
        this.r.scrollToPosition(jVar.j(this.n));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f18581k);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.l);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.m);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.android.material.datepicker.b p() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month q() {
        return this.n;
    }

    public DateSelector<S> r() {
        return this.l;
    }

    LinearLayoutManager t() {
        return (LinearLayoutManager) this.r.getLayoutManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(Month month) {
        com.google.android.material.datepicker.j jVar = (com.google.android.material.datepicker.j) this.r.getAdapter();
        int j2 = jVar.j(month);
        int j3 = j2 - jVar.j(this.n);
        boolean z = Math.abs(j3) > 3;
        boolean z2 = j3 > 0;
        this.n = month;
        if (z && z2) {
            this.r.scrollToPosition(j2 - 3);
            v(j2);
        } else if (z) {
            this.r.scrollToPosition(j2 + 3);
            v(j2);
        } else {
            v(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(k kVar) {
        this.o = kVar;
        if (kVar == k.YEAR) {
            this.q.getLayoutManager().scrollToPosition(((p) this.q.getAdapter()).i(this.n.f18558i));
            this.s.setVisibility(0);
            this.t.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.s.setVisibility(8);
            this.t.setVisibility(0);
            w(this.n);
        }
    }

    void y() {
        k kVar = this.o;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            x(k.DAY);
        } else if (kVar == k.DAY) {
            x(kVar2);
        }
    }
}
