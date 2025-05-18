package i.a.g;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: DNSCache.java */
/* loaded from: classes2.dex */
public class a extends ConcurrentHashMap<String, List<b>> {
    public a(a aVar) {
        this(aVar != null ? aVar.size() : 1024);
        if (aVar != null) {
            putAll(aVar);
        }
    }

    private Collection<? extends b> a(String str) {
        return get(str != null ? str.toLowerCase() : null);
    }

    public boolean b(b bVar) {
        if (bVar == null) {
            return false;
        }
        List<b> list = get(bVar.b());
        if (list == null) {
            putIfAbsent(bVar.b(), new ArrayList());
            list = get(bVar.b());
        }
        synchronized (list) {
            list.add(bVar);
        }
        return true;
    }

    public Collection<b> c() {
        ArrayList arrayList = new ArrayList();
        for (List<b> list : values()) {
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        return arrayList;
    }

    @Override // java.util.AbstractMap
    protected Object clone() throws CloneNotSupportedException {
        return new a(this);
    }

    public b d(String str, i.a.g.s.e eVar, i.a.g.s.d dVar) {
        Collection<? extends b> a = a(str);
        b bVar = null;
        if (a != null) {
            synchronized (a) {
                Iterator<? extends b> it = a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b next = it.next();
                    if (next.t(eVar) && next.s(dVar)) {
                        bVar = next;
                        break;
                    }
                }
            }
        }
        return bVar;
    }

    public b e(b bVar) {
        Collection<? extends b> a;
        b bVar2 = null;
        if (bVar != null && (a = a(bVar.b())) != null) {
            synchronized (a) {
                Iterator<? extends b> it = a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b next = it.next();
                    if (next.l(bVar)) {
                        bVar2 = next;
                        break;
                    }
                }
            }
        }
        return bVar2;
    }

    public Collection<? extends b> f(String str) {
        ArrayList arrayList;
        Collection<? extends b> a = a(str);
        if (a != null) {
            synchronized (a) {
                arrayList = new ArrayList(a);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public Collection<? extends b> h(String str, i.a.g.s.e eVar, i.a.g.s.d dVar) {
        ArrayList arrayList;
        Collection<? extends b> a = a(str);
        if (a != null) {
            synchronized (a) {
                arrayList = new ArrayList(a);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (!bVar.t(eVar) || !bVar.s(dVar)) {
                        it.remove();
                    }
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public boolean i(b bVar) {
        List<b> list;
        if (bVar == null || (list = get(bVar.b())) == null) {
            return false;
        }
        synchronized (list) {
            list.remove(bVar);
        }
        return false;
    }

    public boolean j(b bVar, b bVar2) {
        if (bVar == null || bVar2 == null || !bVar.b().equals(bVar2.b())) {
            return false;
        }
        List<b> list = get(bVar.b());
        if (list == null) {
            putIfAbsent(bVar.b(), new ArrayList());
            list = get(bVar.b());
        }
        synchronized (list) {
            list.remove(bVar2);
            list.add(bVar);
        }
        return true;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap
    public synchronized String toString() {
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer(2000);
        stringBuffer.append("\t---- cache ----");
        Enumeration keys = keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            stringBuffer.append("\n\t\t");
            stringBuffer.append("\n\t\tname '");
            stringBuffer.append(str);
            stringBuffer.append("' ");
            List<b> list = (List) get(str);
            if (list != null && !list.isEmpty()) {
                synchronized (list) {
                    for (b bVar : list) {
                        stringBuffer.append("\n\t\t\t");
                        stringBuffer.append(bVar.toString());
                    }
                }
            } else {
                stringBuffer.append(" no entries");
            }
        }
        return stringBuffer.toString();
    }

    public a(int i2) {
        super(i2);
    }
}
