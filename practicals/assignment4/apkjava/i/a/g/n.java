package i.a.g;

import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: NameRegister.java */
/* loaded from: classes2.dex */
public interface n {

    /* compiled from: NameRegister.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.HOST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: NameRegister.java */
    /* loaded from: classes2.dex */
    public static abstract class b implements n {
        protected String b(String str) {
            StringBuilder sb = new StringBuilder(str.length() + 5);
            int indexOf = str.indexOf(".local.");
            int lastIndexOf = str.lastIndexOf(45);
            int i2 = 1;
            if (lastIndexOf < 0) {
                sb.append(str.substring(0, indexOf));
            } else {
                try {
                    int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1, indexOf)) + 1;
                    sb.append(str.substring(0, lastIndexOf));
                    i2 = parseInt;
                } catch (Exception unused) {
                    sb.append(str.substring(0, indexOf));
                }
            }
            sb.append('-');
            sb.append(i2);
            sb.append(".local.");
            return sb.toString();
        }

        protected String c(String str) {
            StringBuilder sb = new StringBuilder(str.length() + 5);
            int lastIndexOf = str.lastIndexOf(40);
            int lastIndexOf2 = str.lastIndexOf(41);
            if (lastIndexOf >= 0 && lastIndexOf < lastIndexOf2) {
                try {
                    sb.append(str.substring(0, lastIndexOf));
                    sb.append('(');
                    sb.append(Integer.parseInt(str.substring(lastIndexOf + 1, lastIndexOf2)) + 1);
                    sb.append(')');
                } catch (NumberFormatException unused) {
                    sb.setLength(0);
                    sb.append(str);
                    sb.append(" (2)");
                }
            } else {
                sb.append(str);
                sb.append(" (2)");
            }
            return sb.toString();
        }
    }

    /* compiled from: NameRegister.java */
    /* loaded from: classes2.dex */
    public static class c {
        private static volatile n a;

        public static n a() {
            if (a == null) {
                a = new e();
            }
            return a;
        }
    }

    /* compiled from: NameRegister.java */
    /* loaded from: classes2.dex */
    public enum d {
        HOST,
        SERVICE
    }

    /* compiled from: NameRegister.java */
    /* loaded from: classes2.dex */
    public static class e extends b {
        private final ConcurrentMap<InetAddress, String> a = new ConcurrentHashMap();

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentMap<InetAddress, Set<String>> f21843b = new ConcurrentHashMap();

        @Override // i.a.g.n
        public String a(InetAddress inetAddress, String str, d dVar) {
            int i2 = a.a[dVar.ordinal()];
            if (i2 != 1) {
                return i2 != 2 ? str : c(str);
            }
            return b(str);
        }
    }

    String a(InetAddress inetAddress, String str, d dVar);
}
