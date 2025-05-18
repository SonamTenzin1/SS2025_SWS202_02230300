package kotlin.reflect.y.internal.j0.e.a0.b;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.collections.u;
import kotlin.internal.c;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* compiled from: ClassMapperLite.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final b a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final String f23881b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f23882c;

    static {
        List m;
        String e0;
        List m2;
        List<String> m3;
        List<String> m4;
        List<String> m5;
        m = u.m('k', 'o', 't', 'l', 'i', 'n');
        e0 = c0.e0(m, HttpUrl.FRAGMENT_ENCODE_SET, null, null, 0, null, null, 62, null);
        f23881b = e0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        m2 = u.m("Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int c2 = c.c(0, m2.size() - 1, 2);
        if (c2 >= 0) {
            int i2 = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f23881b;
                sb.append(str);
                sb.append('/');
                sb.append((String) m2.get(i2));
                int i3 = i2 + 1;
                linkedHashMap.put(sb.toString(), m2.get(i3));
                linkedHashMap.put(str + '/' + ((String) m2.get(i2)) + "Array", '[' + ((String) m2.get(i3)));
                if (i2 == c2) {
                    break;
                } else {
                    i2 += 2;
                }
            }
        }
        linkedHashMap.put(f23881b + "/Unit", "V");
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        m3 = u.m("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum");
        for (String str2 : m3) {
            a(linkedHashMap, str2, "java/lang/" + str2);
        }
        m4 = u.m("Iterator", "Collection", "List", "Set", "Map", "ListIterator");
        for (String str3 : m4) {
            a(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            a(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i4 = 0; i4 < 23; i4++) {
            StringBuilder sb2 = new StringBuilder();
            String str4 = f23881b;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i4);
            a(linkedHashMap, "Function" + i4, sb2.toString());
            a(linkedHashMap, "reflect/KFunction" + i4, str4 + "/reflect/KFunction");
        }
        m5 = u.m("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum");
        for (String str5 : m5) {
            a(linkedHashMap, str5 + ".Companion", f23881b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f23882c = linkedHashMap;
    }

    private b() {
    }

    private static final void a(Map<String, String> map, String str, String str2) {
        map.put(f23881b + '/' + str, 'L' + str2 + ';');
    }

    public static final String b(String str) {
        String z;
        m.f(str, "classId");
        String str2 = f23882c.get(str);
        if (str2 != null) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('L');
        z = kotlin.text.u.z(str, '.', '$', false, 4, null);
        sb.append(z);
        sb.append(';');
        return sb.toString();
    }
}
