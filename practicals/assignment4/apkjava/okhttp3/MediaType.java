package okhttp3;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import kotlin.text.u;

/* compiled from: MediaType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\b\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000e\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lokhttp3/MediaType;", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/nio/charset/Charset;", "defaultValue", "charset", "(Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", HttpUrl.FRAGMENT_ENCODE_SET, "name", MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD, "(Ljava/lang/String;)Ljava/lang/String;", "-deprecated_type", "()Ljava/lang/String;", "type", "-deprecated_subtype", "subtype", "toString", "other", HttpUrl.FRAGMENT_ENCODE_SET, "equals", "(Ljava/lang/Object;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "()I", "Ljava/lang/String;", "mediaType", HttpUrl.FRAGMENT_ENCODE_SET, "parameterNamesAndValues", "[Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* compiled from: MediaType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u0005J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0005R\u001e\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u001e\u0010\u0013\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lokhttp3/MediaType$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/MediaType;", "get", "(Ljava/lang/String;)Lokhttp3/MediaType;", "toMediaType", "parse", "toMediaTypeOrNull", "mediaType", "-deprecated_get", "-deprecated_parse", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PARAMETER", "Ljava/util/regex/Pattern;", "QUOTED", "Ljava/lang/String;", "TOKEN", "TYPE_SUBTYPE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        /* renamed from: -deprecated_get, reason: not valid java name */
        public final MediaType m452deprecated_get(String mediaType) {
            m.f(mediaType, "mediaType");
            return get(mediaType);
        }

        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final MediaType m453deprecated_parse(String mediaType) {
            m.f(mediaType, "mediaType");
            return parse(mediaType);
        }

        public final MediaType get(String str) {
            boolean E;
            boolean p;
            m.f(str, "$this$toMediaType");
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(str);
            if (matcher.lookingAt()) {
                String group = matcher.group(1);
                m.e(group, "typeSubtype.group(1)");
                Locale locale = Locale.US;
                m.e(locale, "Locale.US");
                if (group != null) {
                    String lowerCase = group.toLowerCase(locale);
                    m.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String group2 = matcher.group(2);
                    m.e(group2, "typeSubtype.group(2)");
                    m.e(locale, "Locale.US");
                    if (group2 != null) {
                        String lowerCase2 = group2.toLowerCase(locale);
                        m.e(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        ArrayList arrayList = new ArrayList();
                        Matcher matcher2 = MediaType.PARAMETER.matcher(str);
                        int end = matcher.end();
                        while (end < str.length()) {
                            matcher2.region(end, str.length());
                            if (matcher2.lookingAt()) {
                                String group3 = matcher2.group(1);
                                if (group3 == null) {
                                    end = matcher2.end();
                                } else {
                                    String group4 = matcher2.group(2);
                                    if (group4 == null) {
                                        group4 = matcher2.group(3);
                                    } else {
                                        E = u.E(group4, "'", false, 2, null);
                                        if (E) {
                                            p = u.p(group4, "'", false, 2, null);
                                            if (p && group4.length() > 2) {
                                                group4 = group4.substring(1, group4.length() - 1);
                                                m.e(group4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                            }
                                        }
                                    }
                                    arrayList.add(group3);
                                    arrayList.add(group4);
                                    end = matcher2.end();
                                }
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Parameter is not formatted correctly: \"");
                                String substring = str.substring(end);
                                m.e(substring, "(this as java.lang.String).substring(startIndex)");
                                sb.append(substring);
                                sb.append("\" for: \"");
                                sb.append(str);
                                sb.append('\"');
                                throw new IllegalArgumentException(sb.toString().toString());
                            }
                        }
                        Object[] array = arrayList.toArray(new String[0]);
                        if (array != null) {
                            return new MediaType(str, lowerCase, lowerCase2, (String[]) array, null);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
        }

        public final MediaType parse(String str) {
            m.f(str, "$this$toMediaTypeOrNull");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    private MediaType(String str, String str2, String str3, String[] strArr) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    public static final MediaType get(String str) {
        return INSTANCE.get(str);
    }

    public static final MediaType parse(String str) {
        return INSTANCE.parse(str);
    }

    /* renamed from: -deprecated_subtype, reason: not valid java name and from getter */
    public final String getSubtype() {
        return this.subtype;
    }

    /* renamed from: -deprecated_type, reason: not valid java name and from getter */
    public final String getType() {
        return this.type;
    }

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public final Charset charset(Charset defaultValue) {
        String parameter = parameter("charset");
        if (parameter == null) {
            return defaultValue;
        }
        try {
            return Charset.forName(parameter);
        } catch (IllegalArgumentException unused) {
            return defaultValue;
        }
    }

    public boolean equals(Object other) {
        return (other instanceof MediaType) && m.a(((MediaType) other).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x002c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String parameter(String name) {
        IntRange y;
        IntProgression j2;
        boolean q;
        m.f(name, "name");
        y = n.y(this.parameterNamesAndValues);
        j2 = l.j(y, 2);
        int f22972g = j2.getF22972g();
        int f22973h = j2.getF22973h();
        int f22974i = j2.getF22974i();
        if (f22974i >= 0) {
            if (f22972g > f22973h) {
                return null;
            }
        } else if (f22972g < f22973h) {
            return null;
        }
        while (!q) {
            if (f22972g == f22973h) {
                return null;
            }
            f22972g += f22974i;
        }
        return this.parameterNamesAndValues[f22972g + 1];
    }

    public final String subtype() {
        return this.subtype;
    }

    /* renamed from: toString, reason: from getter */
    public String getMediaType() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }

    public /* synthetic */ MediaType(String str, String str2, String str3, String[] strArr, g gVar) {
        this(str, str2, str3, strArr);
    }
}
