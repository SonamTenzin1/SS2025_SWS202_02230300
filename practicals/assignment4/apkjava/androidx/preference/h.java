package androidx.preference;

import android.R;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.u;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.j;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PreferenceGroupAdapter.java */
/* loaded from: classes.dex */
public class h extends RecyclerView.g<l> implements Preference.b, PreferenceGroup.c {

    /* renamed from: f, reason: collision with root package name */
    private PreferenceGroup f1829f;

    /* renamed from: g, reason: collision with root package name */
    private List<Preference> f1830g;

    /* renamed from: h, reason: collision with root package name */
    private List<Preference> f1831h;

    /* renamed from: i, reason: collision with root package name */
    private List<d> f1832i;

    /* renamed from: k, reason: collision with root package name */
    private Runnable f1834k = new a();

    /* renamed from: j, reason: collision with root package name */
    private Handler f1833j = new Handler();

    /* compiled from: PreferenceGroupAdapter.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PreferenceGroupAdapter.java */
    /* loaded from: classes.dex */
    public class b extends f.b {
        final /* synthetic */ List a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f1836b;

        b(List list, List list2, j.d dVar) {
            this.a = list;
            this.f1836b = list2;
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean areContentsTheSame(int i2, int i3) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.f.b
        public boolean areItemsTheSame(int i2, int i3) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.f.b
        public int getNewListSize() {
            return this.f1836b.size();
        }

        @Override // androidx.recyclerview.widget.f.b
        public int getOldListSize() {
            return this.a.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PreferenceGroupAdapter.java */
    /* loaded from: classes.dex */
    public class c implements Preference.d {
        final /* synthetic */ PreferenceGroup a;

        c(PreferenceGroup preferenceGroup) {
            this.a = preferenceGroup;
        }

        @Override // androidx.preference.Preference.d
        public boolean onPreferenceClick(Preference preference) {
            this.a.k1(Integer.MAX_VALUE);
            h.this.a(preference);
            PreferenceGroup.b d1 = this.a.d1();
            if (d1 == null) {
                return true;
            }
            d1.a();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PreferenceGroupAdapter.java */
    /* loaded from: classes.dex */
    public static class d {
        int a;

        /* renamed from: b, reason: collision with root package name */
        int f1839b;

        /* renamed from: c, reason: collision with root package name */
        String f1840c;

        d(Preference preference) {
            this.f1840c = preference.getClass().getName();
            this.a = preference.K();
            this.f1839b = preference.X();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.f1839b == dVar.f1839b && TextUtils.equals(this.f1840c, dVar.f1840c);
        }

        public int hashCode() {
            return ((((527 + this.a) * 31) + this.f1839b) * 31) + this.f1840c.hashCode();
        }
    }

    public h(PreferenceGroup preferenceGroup) {
        this.f1829f = preferenceGroup;
        this.f1829f.M0(this);
        this.f1830g = new ArrayList();
        this.f1831h = new ArrayList();
        this.f1832i = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.f1829f;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).n1());
        } else {
            setHasStableIds(true);
        }
        n();
    }

    private androidx.preference.b g(PreferenceGroup preferenceGroup, List<Preference> list) {
        androidx.preference.b bVar = new androidx.preference.b(preferenceGroup.D(), list, preferenceGroup.H());
        bVar.N0(new c(preferenceGroup));
        return bVar;
    }

    private List<Preference> h(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int f1 = preferenceGroup.f1();
        int i2 = 0;
        for (int i3 = 0; i3 < f1; i3++) {
            Preference e1 = preferenceGroup.e1(i3);
            if (e1.d0()) {
                if (k(preferenceGroup) && i2 >= preferenceGroup.c1()) {
                    arrayList2.add(e1);
                } else {
                    arrayList.add(e1);
                }
                if (e1 instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) e1;
                    if (!preferenceGroup2.g1()) {
                        continue;
                    } else {
                        if (k(preferenceGroup) && k(preferenceGroup2)) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        for (Preference preference : h(preferenceGroup2)) {
                            if (k(preferenceGroup) && i2 >= preferenceGroup.c1()) {
                                arrayList2.add(preference);
                            } else {
                                arrayList.add(preference);
                            }
                            i2++;
                        }
                    }
                } else {
                    i2++;
                }
            }
        }
        if (k(preferenceGroup) && i2 > preferenceGroup.c1()) {
            arrayList.add(g(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    private void i(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.m1();
        int f1 = preferenceGroup.f1();
        for (int i2 = 0; i2 < f1; i2++) {
            Preference e1 = preferenceGroup.e1(i2);
            list.add(e1);
            d dVar = new d(e1);
            if (!this.f1832i.contains(dVar)) {
                this.f1832i.add(dVar);
            }
            if (e1 instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) e1;
                if (preferenceGroup2.g1()) {
                    i(list, preferenceGroup2);
                }
            }
            e1.M0(this);
        }
    }

    private boolean k(PreferenceGroup preferenceGroup) {
        return preferenceGroup.c1() != Integer.MAX_VALUE;
    }

    @Override // androidx.preference.Preference.b
    public void a(Preference preference) {
        this.f1833j.removeCallbacks(this.f1834k);
        this.f1833j.post(this.f1834k);
    }

    @Override // androidx.preference.Preference.b
    public void b(Preference preference) {
        a(preference);
    }

    @Override // androidx.preference.PreferenceGroup.c
    public int c(Preference preference) {
        int size = this.f1831h.size();
        for (int i2 = 0; i2 < size; i2++) {
            Preference preference2 = this.f1831h.get(i2);
            if (preference2 != null && preference2.equals(preference)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.preference.Preference.b
    public void e(Preference preference) {
        int indexOf = this.f1831h.indexOf(preference);
        if (indexOf != -1) {
            notifyItemChanged(indexOf, preference);
        }
    }

    @Override // androidx.preference.PreferenceGroup.c
    public int f(String str) {
        int size = this.f1831h.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(str, this.f1831h.get(i2).J())) {
                return i2;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f1831h.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        if (hasStableIds()) {
            return j(i2).H();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        d dVar = new d(j(i2));
        int indexOf = this.f1832i.indexOf(dVar);
        if (indexOf != -1) {
            return indexOf;
        }
        int size = this.f1832i.size();
        this.f1832i.add(dVar);
        return size;
    }

    public Preference j(int i2) {
        if (i2 < 0 || i2 >= getItemCount()) {
            return null;
        }
        return this.f1831h.get(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(l lVar, int i2) {
        j(i2).k0(lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public l onCreateViewHolder(ViewGroup viewGroup, int i2) {
        d dVar = this.f1832i.get(i2);
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        TypedArray obtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, t.p);
        Drawable drawable = obtainStyledAttributes.getDrawable(t.q);
        if (drawable == null) {
            drawable = c.a.k.a.a.d(viewGroup.getContext(), R.drawable.list_selector_background);
        }
        obtainStyledAttributes.recycle();
        View inflate = from.inflate(dVar.a, viewGroup, false);
        if (inflate.getBackground() == null) {
            u.m0(inflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate.findViewById(R.id.widget_frame);
        if (viewGroup2 != null) {
            int i3 = dVar.f1839b;
            if (i3 != 0) {
                from.inflate(i3, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new l(inflate);
    }

    void n() {
        Iterator<Preference> it = this.f1830g.iterator();
        while (it.hasNext()) {
            it.next().M0(null);
        }
        ArrayList arrayList = new ArrayList(this.f1830g.size());
        this.f1830g = arrayList;
        i(arrayList, this.f1829f);
        List<Preference> list = this.f1831h;
        List<Preference> h2 = h(this.f1829f);
        this.f1831h = h2;
        j S = this.f1829f.S();
        if (S != null && S.g() != null) {
            androidx.recyclerview.widget.f.a(new b(list, h2, S.g())).e(this);
        } else {
            notifyDataSetChanged();
        }
        Iterator<Preference> it2 = this.f1830g.iterator();
        while (it2.hasNext()) {
            it2.next().q();
        }
    }
}
