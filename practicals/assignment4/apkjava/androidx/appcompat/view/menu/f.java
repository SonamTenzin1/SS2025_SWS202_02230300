package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* compiled from: MenuAdapter.java */
/* loaded from: classes.dex */
public class f extends BaseAdapter {

    /* renamed from: f, reason: collision with root package name */
    g f297f;

    /* renamed from: g, reason: collision with root package name */
    private int f298g = -1;

    /* renamed from: h, reason: collision with root package name */
    private boolean f299h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f300i;

    /* renamed from: j, reason: collision with root package name */
    private final LayoutInflater f301j;

    /* renamed from: k, reason: collision with root package name */
    private final int f302k;

    public f(g gVar, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f300i = z;
        this.f301j = layoutInflater;
        this.f297f = gVar;
        this.f302k = i2;
        a();
    }

    void a() {
        i x = this.f297f.x();
        if (x != null) {
            ArrayList<i> B = this.f297f.B();
            int size = B.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (B.get(i2) == x) {
                    this.f298g = i2;
                    return;
                }
            }
        }
        this.f298g = -1;
    }

    public g b() {
        return this.f297f;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public i getItem(int i2) {
        ArrayList<i> B = this.f300i ? this.f297f.B() : this.f297f.G();
        int i3 = this.f298g;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return B.get(i2);
    }

    public void d(boolean z) {
        this.f299h = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<i> B = this.f300i ? this.f297f.B() : this.f297f.G();
        if (this.f298g < 0) {
            return B.size();
        }
        return B.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f301j.inflate(this.f302k, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i3 = i2 - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f297f.H() && groupId != (i3 >= 0 ? getItem(i3).getGroupId() : groupId));
        n.a aVar = (n.a) view;
        if (this.f299h) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.e(getItem(i2), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
