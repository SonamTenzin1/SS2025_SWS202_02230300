package androidx.room.t;

import android.database.Cursor;
import android.os.Build;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: TableInfo.java */
/* loaded from: classes.dex */
public class g {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, a> f2213b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<b> f2214c;

    /* renamed from: d, reason: collision with root package name */
    public final Set<d> f2215d;

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class a {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final String f2216b;

        /* renamed from: c, reason: collision with root package name */
        public final int f2217c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f2218d;

        /* renamed from: e, reason: collision with root package name */
        public final int f2219e;

        /* renamed from: f, reason: collision with root package name */
        public final String f2220f;

        /* renamed from: g, reason: collision with root package name */
        private final int f2221g;

        public a(String str, String str2, boolean z, int i2, String str3, int i3) {
            this.a = str;
            this.f2216b = str2;
            this.f2218d = z;
            this.f2219e = i2;
            this.f2217c = a(str2);
            this.f2220f = str3;
            this.f2221g = i3;
        }

        private static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean b() {
            return this.f2219e > 0;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.f2219e != aVar.f2219e) {
                    return false;
                }
            } else if (b() != aVar.b()) {
                return false;
            }
            if (!this.a.equals(aVar.a) || this.f2218d != aVar.f2218d) {
                return false;
            }
            if (this.f2221g == 1 && aVar.f2221g == 2 && (str3 = this.f2220f) != null && !str3.equals(aVar.f2220f)) {
                return false;
            }
            if (this.f2221g == 2 && aVar.f2221g == 1 && (str2 = aVar.f2220f) != null && !str2.equals(this.f2220f)) {
                return false;
            }
            int i2 = this.f2221g;
            return (i2 == 0 || i2 != aVar.f2221g || ((str = this.f2220f) == null ? aVar.f2220f == null : str.equals(aVar.f2220f))) && this.f2217c == aVar.f2217c;
        }

        public int hashCode() {
            return (((((this.a.hashCode() * 31) + this.f2217c) * 31) + (this.f2218d ? 1231 : 1237)) * 31) + this.f2219e;
        }

        public String toString() {
            return "Column{name='" + this.a + "', type='" + this.f2216b + "', affinity='" + this.f2217c + "', notNull=" + this.f2218d + ", primaryKeyPosition=" + this.f2219e + ", defaultValue='" + this.f2220f + "'}";
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class b {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final String f2222b;

        /* renamed from: c, reason: collision with root package name */
        public final String f2223c;

        /* renamed from: d, reason: collision with root package name */
        public final List<String> f2224d;

        /* renamed from: e, reason: collision with root package name */
        public final List<String> f2225e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.a = str;
            this.f2222b = str2;
            this.f2223c = str3;
            this.f2224d = Collections.unmodifiableList(list);
            this.f2225e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a.equals(bVar.a) && this.f2222b.equals(bVar.f2222b) && this.f2223c.equals(bVar.f2223c) && this.f2224d.equals(bVar.f2224d)) {
                return this.f2225e.equals(bVar.f2225e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.a.hashCode() * 31) + this.f2222b.hashCode()) * 31) + this.f2223c.hashCode()) * 31) + this.f2224d.hashCode()) * 31) + this.f2225e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.a + "', onDelete='" + this.f2222b + "', onUpdate='" + this.f2223c + "', columnNames=" + this.f2224d + ", referenceColumnNames=" + this.f2225e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class c implements Comparable<c> {

        /* renamed from: f, reason: collision with root package name */
        final int f2226f;

        /* renamed from: g, reason: collision with root package name */
        final int f2227g;

        /* renamed from: h, reason: collision with root package name */
        final String f2228h;

        /* renamed from: i, reason: collision with root package name */
        final String f2229i;

        c(int i2, int i3, String str, String str2) {
            this.f2226f = i2;
            this.f2227g = i3;
            this.f2228h = str;
            this.f2229i = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            int i2 = this.f2226f - cVar.f2226f;
            return i2 == 0 ? this.f2227g - cVar.f2227g : i2;
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class d {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f2230b;

        /* renamed from: c, reason: collision with root package name */
        public final List<String> f2231c;

        public d(String str, boolean z, List<String> list) {
            this.a = str;
            this.f2230b = z;
            this.f2231c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (this.f2230b != dVar.f2230b || !this.f2231c.equals(dVar.f2231c)) {
                return false;
            }
            if (this.a.startsWith("index_")) {
                return dVar.a.startsWith("index_");
            }
            return this.a.equals(dVar.a);
        }

        public int hashCode() {
            return ((((this.a.startsWith("index_") ? -1184239155 : this.a.hashCode()) * 31) + (this.f2230b ? 1 : 0)) * 31) + this.f2231c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.a + "', unique=" + this.f2230b + ", columns=" + this.f2231c + '}';
        }
    }

    public g(String str, Map<String, a> map, Set<b> set, Set<d> set2) {
        this.a = str;
        this.f2213b = Collections.unmodifiableMap(map);
        this.f2214c = Collections.unmodifiableSet(set);
        this.f2215d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public static g a(c.u.a.b bVar, String str) {
        return new g(str, b(bVar, str), d(bVar, str), f(bVar, str));
    }

    private static Map<String, a> b(c.u.a.b bVar, String str) {
        Cursor u0 = bVar.u0("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (u0.getColumnCount() > 0) {
                int columnIndex = u0.getColumnIndex("name");
                int columnIndex2 = u0.getColumnIndex("type");
                int columnIndex3 = u0.getColumnIndex("notnull");
                int columnIndex4 = u0.getColumnIndex("pk");
                int columnIndex5 = u0.getColumnIndex("dflt_value");
                while (u0.moveToNext()) {
                    String string = u0.getString(columnIndex);
                    hashMap.put(string, new a(string, u0.getString(columnIndex2), u0.getInt(columnIndex3) != 0, u0.getInt(columnIndex4), u0.getString(columnIndex5), 2));
                }
            }
            return hashMap;
        } finally {
            u0.close();
        }
    }

    private static List<c> c(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex(DeepLinkIntentReceiver.DeepLinksKeys.ID);
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < count; i2++) {
            cursor.moveToPosition(i2);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Set<b> d(c.u.a.b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor u0 = bVar.u0("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = u0.getColumnIndex(DeepLinkIntentReceiver.DeepLinksKeys.ID);
            int columnIndex2 = u0.getColumnIndex("seq");
            int columnIndex3 = u0.getColumnIndex("table");
            int columnIndex4 = u0.getColumnIndex("on_delete");
            int columnIndex5 = u0.getColumnIndex("on_update");
            List<c> c2 = c(u0);
            int count = u0.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                u0.moveToPosition(i2);
                if (u0.getInt(columnIndex2) == 0) {
                    int i3 = u0.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : c2) {
                        if (cVar.f2226f == i3) {
                            arrayList.add(cVar.f2228h);
                            arrayList2.add(cVar.f2229i);
                        }
                    }
                    hashSet.add(new b(u0.getString(columnIndex3), u0.getString(columnIndex4), u0.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            u0.close();
        }
    }

    private static d e(c.u.a.b bVar, String str, boolean z) {
        Cursor u0 = bVar.u0("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = u0.getColumnIndex("seqno");
            int columnIndex2 = u0.getColumnIndex("cid");
            int columnIndex3 = u0.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (u0.moveToNext()) {
                    if (u0.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(u0.getInt(columnIndex)), u0.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new d(str, z, arrayList);
            }
            return null;
        } finally {
            u0.close();
        }
    }

    private static Set<d> f(c.u.a.b bVar, String str) {
        Cursor u0 = bVar.u0("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = u0.getColumnIndex("name");
            int columnIndex2 = u0.getColumnIndex("origin");
            int columnIndex3 = u0.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (u0.moveToNext()) {
                    if ("c".equals(u0.getString(columnIndex2))) {
                        String string = u0.getString(columnIndex);
                        boolean z = true;
                        if (u0.getInt(columnIndex3) != 1) {
                            z = false;
                        }
                        d e2 = e(bVar, string, z);
                        if (e2 == null) {
                            return null;
                        }
                        hashSet.add(e2);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            u0.close();
        }
    }

    public boolean equals(Object obj) {
        Set<d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        String str = this.a;
        if (str == null ? gVar.a != null : !str.equals(gVar.a)) {
            return false;
        }
        Map<String, a> map = this.f2213b;
        if (map == null ? gVar.f2213b != null : !map.equals(gVar.f2213b)) {
            return false;
        }
        Set<b> set2 = this.f2214c;
        if (set2 == null ? gVar.f2214c != null : !set2.equals(gVar.f2214c)) {
            return false;
        }
        Set<d> set3 = this.f2215d;
        if (set3 == null || (set = gVar.f2215d) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.f2213b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f2214c;
        return hashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "TableInfo{name='" + this.a + "', columns=" + this.f2213b + ", foreignKeys=" + this.f2214c + ", indices=" + this.f2215d + '}';
    }
}
