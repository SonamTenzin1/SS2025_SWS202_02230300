package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzfw extends i1<String> implements zzfv, RandomAccess {

    /* renamed from: g, reason: collision with root package name */
    private static final zzfw f17421g;

    /* renamed from: h, reason: collision with root package name */
    private static final zzfv f17422h;

    /* renamed from: i, reason: collision with root package name */
    private final List<Object> f17423i;

    static {
        zzfw zzfwVar = new zzfw();
        f17421g = zzfwVar;
        zzfwVar.I();
        f17422h = zzfwVar;
    }

    public zzfw() {
        this(10);
    }

    private static String f(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdu) {
            return ((zzdu) obj).w();
        }
        return zzff.i((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.i1, com.google.android.gms.internal.measurement.zzfl
    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        c();
        this.f17423i.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzfv
    public final List<?> b() {
        return Collections.unmodifiableList(this.f17423i);
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        c();
        this.f17423i.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzfl
    public final /* synthetic */ zzfl d(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f17423i);
            return new zzfw((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.measurement.zzfv
    public final Object e(int i2) {
        return this.f17423i.get(i2);
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f17423i.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzdu) {
            zzdu zzduVar = (zzdu) obj;
            String w = zzduVar.w();
            if (zzduVar.y()) {
                this.f17423i.set(i2, w);
            }
            return w;
        }
        byte[] bArr = (byte[]) obj;
        String i3 = zzff.i(bArr);
        if (zzff.h(bArr)) {
            this.f17423i.set(i2, i3);
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzfv
    public final void n1(zzdu zzduVar) {
        c();
        this.f17423i.add(zzduVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        c();
        return f(this.f17423i.set(i2, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f17423i.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzfv
    public final zzfv y0() {
        return a() ? new zzia(this) : this;
    }

    public zzfw(int i2) {
        this((ArrayList<Object>) new ArrayList(i2));
    }

    @Override // com.google.android.gms.internal.measurement.i1, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection<? extends String> collection) {
        c();
        if (collection instanceof zzfv) {
            collection = ((zzfv) collection).b();
        }
        boolean addAll = this.f17423i.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        c();
        Object remove = this.f17423i.remove(i2);
        ((AbstractList) this).modCount++;
        return f(remove);
    }

    private zzfw(ArrayList<Object> arrayList) {
        this.f17423i = arrayList;
    }
}
