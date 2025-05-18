package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Indent.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", HttpUrl.FRAGMENT_ENCODE_SET, "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", HttpUrl.FRAGMENT_ENCODE_SET, "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes3.dex */
public class n extends m {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Indent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "line", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<String, String> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f25083f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str) {
            m.f(str, "line");
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Indent.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "line", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<String, String> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f25084f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f25084f = str;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str) {
            m.f(str, "line");
            return this.f25084f + str;
        }
    }

    private static final Function1<String, String> b(String str) {
        return str.length() == 0 ? a.f25083f : new b(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (!kotlin.text.a.c(str.charAt(i2))) {
                break;
            }
            i2++;
        }
        return i2 == -1 ? str.length() : i2;
    }

    public static final String d(String str, String str2) {
        String invoke;
        m.f(str, "<this>");
        m.f(str2, "newIndent");
        List<String> e0 = v.e0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : e0) {
            if (!l.t((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(s.u(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(c((String) it.next())));
        }
        Integer num = (Integer) s.k0(arrayList2);
        int i2 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * e0.size());
        Function1<String, String> b2 = b(str2);
        int l = s.l(e0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : e0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                s.t();
            }
            String str3 = (String) obj2;
            if ((i2 == 0 || i2 == l) && l.t(str3)) {
                str3 = null;
            } else {
                String P0 = x.P0(str3, intValue);
                if (P0 != null && (invoke = b2.invoke(P0)) != null) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i2 = i3;
        }
        String sb = ((StringBuilder) s.c0(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        m.e(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static final String e(String str, String str2, String str3) {
        int i2;
        String invoke;
        m.f(str, "<this>");
        m.f(str2, "newIndent");
        m.f(str3, "marginPrefix");
        if (!l.t(str3)) {
            List<String> e0 = v.e0(str);
            int length = str.length() + (str2.length() * e0.size());
            Function1<String, String> b2 = b(str2);
            int l = s.l(e0);
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (Object obj : e0) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    s.t();
                }
                String str4 = (String) obj;
                String str5 = null;
                if ((i3 == 0 || i3 == l) && l.t(str4)) {
                    str4 = null;
                } else {
                    int length2 = str4.length();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length2) {
                            i2 = -1;
                            break;
                        }
                        if (!kotlin.text.a.c(str4.charAt(i5))) {
                            i2 = i5;
                            break;
                        }
                        i5++;
                    }
                    if (i2 != -1) {
                        int i6 = i2;
                        if (l.D(str4, str3, i2, false, 4, null)) {
                            int length3 = i6 + str3.length();
                            m.d(str4, "null cannot be cast to non-null type java.lang.String");
                            str5 = str4.substring(length3);
                            m.e(str5, "this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (str5 != null && (invoke = b2.invoke(str5)) != null) {
                        str4 = invoke;
                    }
                }
                if (str4 != null) {
                    arrayList.add(str4);
                }
                i3 = i4;
            }
            String sb = ((StringBuilder) s.c0(arrayList, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
            m.e(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static String f(String str) {
        m.f(str, "<this>");
        return d(str, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    public static final String g(String str, String str2) {
        m.f(str, "<this>");
        m.f(str2, "marginPrefix");
        return e(str, HttpUrl.FRAGMENT_ENCODE_SET, str2);
    }

    public static /* synthetic */ String h(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "|";
        }
        return g(str, str2);
    }
}
