package e.e.b.a.i.d0;

import android.util.SparseArray;
import e.e.b.a.d;
import java.util.HashMap;

/* compiled from: PriorityMapping.java */
/* loaded from: classes2.dex */
public final class a {
    private static SparseArray<d> a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<d, Integer> f20827b;

    static {
        HashMap<d, Integer> hashMap = new HashMap<>();
        f20827b = hashMap;
        hashMap.put(d.DEFAULT, 0);
        f20827b.put(d.VERY_LOW, 1);
        f20827b.put(d.HIGHEST, 2);
        for (d dVar : f20827b.keySet()) {
            a.append(f20827b.get(dVar).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = f20827b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    public static d b(int i2) {
        d dVar = a.get(i2);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i2);
    }
}
