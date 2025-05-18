package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseMenuWrapper.java */
/* loaded from: classes.dex */
public abstract class c {
    final Context a;

    /* renamed from: b, reason: collision with root package name */
    private c.e.g<c.i.f.a.b, MenuItem> f273b;

    /* renamed from: c, reason: collision with root package name */
    private c.e.g<c.i.f.a.c, SubMenu> f274c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof c.i.f.a.b)) {
            return menuItem;
        }
        c.i.f.a.b bVar = (c.i.f.a.b) menuItem;
        if (this.f273b == null) {
            this.f273b = new c.e.g<>();
        }
        MenuItem menuItem2 = this.f273b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.a, bVar);
        this.f273b.put(bVar, jVar);
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof c.i.f.a.c)) {
            return subMenu;
        }
        c.i.f.a.c cVar = (c.i.f.a.c) subMenu;
        if (this.f274c == null) {
            this.f274c = new c.e.g<>();
        }
        SubMenu subMenu2 = this.f274c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        s sVar = new s(this.a, cVar);
        this.f274c.put(cVar, sVar);
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        c.e.g<c.i.f.a.b, MenuItem> gVar = this.f273b;
        if (gVar != null) {
            gVar.clear();
        }
        c.e.g<c.i.f.a.c, SubMenu> gVar2 = this.f274c;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i2) {
        if (this.f273b == null) {
            return;
        }
        int i3 = 0;
        while (i3 < this.f273b.size()) {
            if (this.f273b.j(i3).getGroupId() == i2) {
                this.f273b.l(i3);
                i3--;
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(int i2) {
        if (this.f273b == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f273b.size(); i3++) {
            if (this.f273b.j(i3).getItemId() == i2) {
                this.f273b.l(i3);
                return;
            }
        }
    }
}
