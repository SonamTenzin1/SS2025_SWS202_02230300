package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: LazyStringArrayList.java */
/* loaded from: classes.dex */
public class e0 extends c<String> implements f0, RandomAccess {

    /* renamed from: g, reason: collision with root package name */
    private static final e0 f1290g;

    /* renamed from: h, reason: collision with root package name */
    public static final f0 f1291h;

    /* renamed from: i, reason: collision with root package name */
    private final List<Object> f1292i;

    static {
        e0 e0Var = new e0();
        f1290g = e0Var;
        e0Var.B();
        f1291h = e0Var;
    }

    public e0() {
        this(10);
    }

    private static String g(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof h) {
            return ((h) obj).E();
        }
        return a0.j((byte[]) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public void a0(h hVar) {
        c();
        this.f1292i.add(hVar);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public Object c1(int i2) {
        return this.f1292i.get(i2);
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        c();
        this.f1292i.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void add(int i2, String str) {
        c();
        this.f1292i.add(i2, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public String get(int i2) {
        Object obj = this.f1292i.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            String E = hVar.E();
            if (hVar.s()) {
                this.f1292i.set(i2, E);
            }
            return E;
        }
        byte[] bArr = (byte[]) obj;
        String j2 = a0.j(bArr);
        if (a0.g(bArr)) {
            this.f1292i.set(i2, j2);
        }
        return j2;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.a0.i
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public e0 J(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f1292i);
            return new e0((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public List<?> j() {
        return Collections.unmodifiableList(this.f1292i);
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public f0 k() {
        return l1() ? new o1(this) : this;
    }

    @Override // androidx.datastore.preferences.protobuf.c, androidx.datastore.preferences.protobuf.a0.i
    public /* bridge */ /* synthetic */ boolean l1() {
        return super.l1();
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public String remove(int i2) {
        c();
        Object remove = this.f1292i.remove(i2);
        ((AbstractList) this).modCount++;
        return g(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public String set(int i2, String str) {
        c();
        return g(this.f1292i.set(i2, str));
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1292i.size();
    }

    public e0(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.List
    public boolean addAll(int i2, Collection<? extends String> collection) {
        c();
        if (collection instanceof f0) {
            collection = ((f0) collection).j();
        }
        boolean addAll = this.f1292i.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private e0(ArrayList<Object> arrayList) {
        this.f1292i = arrayList;
    }
}
