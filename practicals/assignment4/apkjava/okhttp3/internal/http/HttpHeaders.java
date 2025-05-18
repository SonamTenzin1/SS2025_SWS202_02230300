package okhttp3.internal.http;

import j.f;
import j.i;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

/* compiled from: HttpHeaders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\u000b\u001a\u00020\n*\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0012\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0001*\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0015\u001a!\u0010\u001b\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001e\u001a\u00020\r*\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001dH\u0007¢\u0006\u0004\b!\u0010\u001f\"\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$\"\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006&"}, d2 = {"Lokhttp3/Headers;", HttpUrl.FRAGMENT_ENCODE_SET, "headerName", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/Challenge;", "parseChallenges", "(Lokhttp3/Headers;Ljava/lang/String;)Ljava/util/List;", "Lj/f;", HttpUrl.FRAGMENT_ENCODE_SET, "result", "Lkotlin/u;", "readChallengeHeader", "(Lj/f;Ljava/util/List;)V", HttpUrl.FRAGMENT_ENCODE_SET, "skipCommasAndWhitespace", "(Lj/f;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "prefix", "startsWith", "(Lj/f;B)Z", "readQuotedString", "(Lj/f;)Ljava/lang/String;", "readToken", "Lokhttp3/CookieJar;", "Lokhttp3/HttpUrl;", "url", "headers", "receiveHeaders", "(Lokhttp3/CookieJar;Lokhttp3/HttpUrl;Lokhttp3/Headers;)V", "Lokhttp3/Response;", "promisesBody", "(Lokhttp3/Response;)Z", "response", "hasBody", "Lj/i;", "TOKEN_DELIMITERS", "Lj/i;", "QUOTED_STRING_DELIMITERS", "okhttp"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class HttpHeaders {
    private static final i QUOTED_STRING_DELIMITERS;
    private static final i TOKEN_DELIMITERS;

    static {
        i.a aVar = i.f22842g;
        QUOTED_STRING_DELIMITERS = aVar.d("\"\\");
        TOKEN_DELIMITERS = aVar.d("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        m.f(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String str) {
        boolean q;
        m.f(headers, "$this$parseChallenges");
        m.f(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            q = u.q(str, headers.name(i2), true);
            if (q) {
                try {
                    readChallengeHeader(new f().r0(headers.value(i2)), arrayList);
                } catch (EOFException e2) {
                    Platform.INSTANCE.get().log("Unable to parse challenge", 5, e2);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        boolean q;
        m.f(response, "$this$promisesBody");
        if (m.a(response.request().method(), "HEAD")) {
            return false;
        }
        int code = response.code();
        if (((code >= 100 && code < 200) || code == 204 || code == 304) && Util.headersContentLength(response) == -1) {
            q = u.q("chunked", Response.header$default(response, "Transfer-Encoding", null, 2, null), true);
            if (!q) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0085, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void readChallengeHeader(f fVar, List<Challenge> list) throws EOFException {
        String readToken;
        Map i2;
        int skipAll;
        String w;
        while (true) {
            String str = null;
            while (true) {
                if (str == null) {
                    skipCommasAndWhitespace(fVar);
                    str = readToken(fVar);
                    if (str == null) {
                        return;
                    }
                }
                boolean skipCommasAndWhitespace = skipCommasAndWhitespace(fVar);
                readToken = readToken(fVar);
                if (readToken == null) {
                    if (fVar.R()) {
                        i2 = q0.i();
                        list.add(new Challenge(str, (Map<String, String>) i2));
                        return;
                    }
                    return;
                }
                byte b2 = (byte) 61;
                skipAll = Util.skipAll(fVar, b2);
                boolean skipCommasAndWhitespace2 = skipCommasAndWhitespace(fVar);
                if (skipCommasAndWhitespace || (!skipCommasAndWhitespace2 && !fVar.R())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int skipAll2 = skipAll + Util.skipAll(fVar, b2);
                    while (true) {
                        if (readToken == null) {
                            readToken = readToken(fVar);
                            if (skipCommasAndWhitespace(fVar)) {
                                break;
                            } else {
                                skipAll2 = Util.skipAll(fVar, b2);
                            }
                        }
                        if (skipAll2 == 0) {
                            break;
                        }
                        if (skipAll2 > 1 || skipCommasAndWhitespace(fVar)) {
                            return;
                        }
                        String readQuotedString = startsWith(fVar, (byte) 34) ? readQuotedString(fVar) : readToken(fVar);
                        if (readQuotedString == null || ((String) linkedHashMap.put(readToken, readQuotedString)) != null) {
                            return;
                        }
                        if (!skipCommasAndWhitespace(fVar) && !fVar.R()) {
                            return;
                        } else {
                            readToken = null;
                        }
                    }
                    list.add(new Challenge(str, linkedHashMap));
                    str = readToken;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(readToken);
            w = u.w("=", skipAll);
            sb.append(w);
            Map singletonMap = Collections.singletonMap(null, sb.toString());
            m.e(singletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
            list.add(new Challenge(str, (Map<String, String>) singletonMap));
        }
    }

    private static final String readQuotedString(f fVar) throws EOFException {
        byte b2 = (byte) 34;
        if (fVar.readByte() == b2) {
            f fVar2 = new f();
            while (true) {
                long b0 = fVar.b0(QUOTED_STRING_DELIMITERS);
                if (b0 == -1) {
                    return null;
                }
                if (fVar.m(b0) == b2) {
                    fVar2.write(fVar, b0);
                    fVar.readByte();
                    return fVar2.T();
                }
                if (fVar.size() == b0 + 1) {
                    return null;
                }
                fVar2.write(fVar, b0);
                fVar.readByte();
                fVar2.write(fVar, 1L);
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private static final String readToken(f fVar) {
        long b0 = fVar.b0(TOKEN_DELIMITERS);
        if (b0 == -1) {
            b0 = fVar.size();
        }
        if (b0 != 0) {
            return fVar.Z(b0);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        m.f(cookieJar, "$this$receiveHeaders");
        m.f(httpUrl, "url");
        m.f(headers, "headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.INSTANCE.parseAll(httpUrl, headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, parseAll);
    }

    private static final boolean skipCommasAndWhitespace(f fVar) {
        boolean z = false;
        while (!fVar.R()) {
            byte m = fVar.m(0L);
            if (m == 9 || m == 32) {
                fVar.readByte();
            } else {
                if (m != 44) {
                    break;
                }
                fVar.readByte();
                z = true;
            }
        }
        return z;
    }

    private static final boolean startsWith(f fVar, byte b2) {
        return !fVar.R() && fVar.m(0L) == b2;
    }
}
