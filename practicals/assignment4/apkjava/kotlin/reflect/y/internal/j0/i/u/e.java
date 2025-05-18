package kotlin.reflect.y.internal.j0.i.u;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.y.internal.j0.b.i;
import kotlin.reflect.y.internal.j0.f.c;

/* compiled from: JvmPrimitiveType.java */
/* loaded from: classes3.dex */
public enum e {
    BOOLEAN(i.BOOLEAN, "boolean", "Z", "java.lang.Boolean"),
    CHAR(i.CHAR, "char", "C", "java.lang.Character"),
    BYTE(i.BYTE, "byte", "B", "java.lang.Byte"),
    SHORT(i.SHORT, "short", "S", "java.lang.Short"),
    INT(i.INT, "int", "I", "java.lang.Integer"),
    FLOAT(i.FLOAT, "float", "F", "java.lang.Float"),
    LONG(i.LONG, "long", "J", "java.lang.Long"),
    DOUBLE(i.DOUBLE, "double", "D", "java.lang.Double");

    private static final Set<c> n = new HashSet();
    private static final Map<String, e> o = new HashMap();
    private static final Map<i, e> p = new EnumMap(i.class);
    private static final Map<String, e> q = new HashMap();
    private final i s;
    private final String t;
    private final String u;
    private final c v;

    static {
        for (e eVar : values()) {
            n.add(eVar.y());
            o.put(eVar.v(), eVar);
            p.put(eVar.x(), eVar);
            q.put(eVar.u(), eVar);
        }
    }

    e(i iVar, String str, String str2, String str3) {
        if (iVar == null) {
            g(6);
        }
        if (str == null) {
            g(7);
        }
        if (str2 == null) {
            g(8);
        }
        if (str3 == null) {
            g(9);
        }
        this.s = iVar;
        this.t = str;
        this.u = str2;
        this.v = new c(str3);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void g(int i2) {
        String str;
        int i3;
        Object[] objArr;
        if (i2 != 2 && i2 != 4) {
            switch (i2) {
                case 10:
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (i2 != 2 && i2 != 4) {
                switch (i2) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        i3 = 3;
                        break;
                }
                objArr = new Object[i3];
                switch (i2) {
                    case 1:
                    case 7:
                        objArr[0] = "name";
                        break;
                    case 2:
                    case 4:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                        break;
                    case 3:
                        objArr[0] = "type";
                        break;
                    case 5:
                    case 8:
                        objArr[0] = "desc";
                        break;
                    case 6:
                        objArr[0] = "primitiveType";
                        break;
                    case 9:
                        objArr[0] = "wrapperClassName";
                        break;
                    default:
                        objArr[0] = "className";
                        break;
                }
                if (i2 == 2 && i2 != 4) {
                    switch (i2) {
                        case 10:
                            objArr[1] = "getPrimitiveType";
                            break;
                        case 11:
                            objArr[1] = "getJavaKeywordName";
                            break;
                        case 12:
                            objArr[1] = "getDesc";
                            break;
                        case 13:
                            objArr[1] = "getWrapperFqName";
                            break;
                        default:
                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType";
                            break;
                    }
                } else {
                    objArr[1] = "get";
                }
                switch (i2) {
                    case 1:
                    case 3:
                        objArr[2] = "get";
                        break;
                    case 2:
                    case 4:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    case 5:
                        objArr[2] = "getByDesc";
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        objArr[2] = "<init>";
                        break;
                    default:
                        objArr[2] = "isWrapperClassName";
                        break;
                }
                String format = String.format(str, objArr);
                if (i2 != 2 && i2 != 4) {
                    switch (i2) {
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            break;
                        default:
                            throw new IllegalArgumentException(format);
                    }
                }
                throw new IllegalStateException(format);
            }
            i3 = 2;
            objArr = new Object[i3];
            switch (i2) {
            }
            if (i2 == 2) {
            }
            objArr[1] = "get";
            switch (i2) {
            }
            String format2 = String.format(str, objArr);
            if (i2 != 2) {
                switch (i2) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i2 != 2) {
            switch (i2) {
            }
            objArr = new Object[i3];
            switch (i2) {
            }
            if (i2 == 2) {
            }
            objArr[1] = "get";
            switch (i2) {
            }
            String format22 = String.format(str, objArr);
            if (i2 != 2) {
            }
            throw new IllegalStateException(format22);
        }
        i3 = 2;
        objArr = new Object[i3];
        switch (i2) {
        }
        if (i2 == 2) {
        }
        objArr[1] = "get";
        switch (i2) {
        }
        String format222 = String.format(str, objArr);
        if (i2 != 2) {
        }
        throw new IllegalStateException(format222);
    }

    public static e k(String str) {
        if (str == null) {
            g(1);
        }
        e eVar = o.get(str);
        if (eVar != null) {
            return eVar;
        }
        throw new AssertionError("Non-primitive type name passed: " + str);
    }

    public static e q(i iVar) {
        if (iVar == null) {
            g(3);
        }
        e eVar = p.get(iVar);
        if (eVar == null) {
            g(4);
        }
        return eVar;
    }

    public String u() {
        String str = this.u;
        if (str == null) {
            g(12);
        }
        return str;
    }

    public String v() {
        String str = this.t;
        if (str == null) {
            g(11);
        }
        return str;
    }

    public i x() {
        i iVar = this.s;
        if (iVar == null) {
            g(10);
        }
        return iVar;
    }

    public c y() {
        c cVar = this.v;
        if (cVar == null) {
            g(13);
        }
        return cVar;
    }
}
