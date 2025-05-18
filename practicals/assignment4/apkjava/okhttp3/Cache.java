package okhttp3;

import cm.aptoide.pt.database.room.RoomNotification;
import j.b0;
import j.d0;
import j.f;
import j.h;
import j.i;
import j.k;
import j.l;
import j.q;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.w0;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;

/* compiled from: Cache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0004ONPQB!\b\u0000\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010J\u001a\u00020I¢\u0006\u0004\bK\u0010LB\u0019\b\u0016\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\bK\u0010MJ\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0018\u00010\u0003R\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u001dJ\u0013\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\u0004\b\"\u0010#J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020$¢\u0006\u0004\b'\u0010&J\r\u0010)\u001a\u00020(¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020(¢\u0006\u0004\b+\u0010*J\u000f\u0010,\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010\u001dJ\u000f\u0010-\u001a\u00020\u0006H\u0016¢\u0006\u0004\b-\u0010\u001dJ\u000f\u00101\u001a\u00020.H\u0007¢\u0006\u0004\b/\u00100J\u0017\u00106\u001a\u00020\u00062\u0006\u00103\u001a\u000202H\u0000¢\u0006\u0004\b4\u00105J\u000f\u00108\u001a\u00020\u0006H\u0000¢\u0006\u0004\b7\u0010\u001dJ\r\u00109\u001a\u00020$¢\u0006\u0004\b9\u0010&J\r\u0010:\u001a\u00020$¢\u0006\u0004\b:\u0010&J\r\u0010;\u001a\u00020$¢\u0006\u0004\b;\u0010&R\u0016\u0010;\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010:\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010<R\u0013\u00101\u001a\u00020.8G@\u0006¢\u0006\u0006\u001a\u0004\b1\u00100R\"\u0010%\u001a\u00020$8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010<\u001a\u0004\b=\u0010&\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u00020\u00048\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\"\u0010'\u001a\u00020$8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010<\u001a\u0004\bD\u0010&\"\u0004\bE\u0010?R\u0016\u00109\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010<R\u0013\u0010G\u001a\u00020F8F@\u0006¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006R"}, d2 = {"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "Lkotlin/u;", "abortQuietly", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "get$okhttp", "(Lokhttp3/Request;)Lokhttp3/Response;", "get", "response", "Lokhttp3/internal/cache/CacheRequest;", "put$okhttp", "(Lokhttp3/Response;)Lokhttp3/internal/cache/CacheRequest;", "put", "remove$okhttp", "(Lokhttp3/Request;)V", "remove", "cached", "network", "update$okhttp", "(Lokhttp3/Response;Lokhttp3/Response;)V", "update", "initialize", "()V", "delete", "evictAll", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "urls", "()Ljava/util/Iterator;", HttpUrl.FRAGMENT_ENCODE_SET, "writeAbortCount", "()I", "writeSuccessCount", HttpUrl.FRAGMENT_ENCODE_SET, "size", "()J", "maxSize", "flush", "close", "Ljava/io/File;", "-deprecated_directory", "()Ljava/io/File;", "directory", "Lokhttp3/internal/cache/CacheStrategy;", "cacheStrategy", "trackResponse$okhttp", "(Lokhttp3/internal/cache/CacheStrategy;)V", "trackResponse", "trackConditionalCacheHit$okhttp", "trackConditionalCacheHit", "networkCount", "hitCount", "requestCount", "I", "getWriteAbortCount$okhttp", "setWriteAbortCount$okhttp", "(I)V", "cache", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "getWriteSuccessCount$okhttp", "setWriteSuccessCount$okhttp", HttpUrl.FRAGMENT_ENCODE_SET, "isClosed", "()Z", "Lokhttp3/internal/io/FileSystem;", "fileSystem", "<init>", "(Ljava/io/File;JLokhttp3/internal/io/FileSystem;)V", "(Ljava/io/File;J)V", "Companion", "CacheResponseBody", "Entry", "RealCacheRequest", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Cache implements Closeable, Flushable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Cache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B'\u0012\n\u0010\r\u001a\u00060\u000bR\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u00060\u000bR\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014¨\u0006\u0017"}, d2 = {"Lokhttp3/Cache$CacheResponseBody;", "Lokhttp3/ResponseBody;", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", HttpUrl.FRAGMENT_ENCODE_SET, "contentLength", "()J", "Lj/h;", "source", "()Lj/h;", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "getSnapshot", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "bodySource", "Lj/h;", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/String;", "<init>", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class CacheResponseBody extends ResponseBody {
        private final h bodySource;
        private final String contentLength;
        private final String contentType;
        private final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(DiskLruCache.Snapshot snapshot, String str, String str2) {
            m.f(snapshot, "snapshot");
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            final d0 source = snapshot.getSource(1);
            this.bodySource = q.d(new l(source) { // from class: okhttp3.Cache.CacheResponseBody.1
                @Override // j.l, j.d0, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    CacheResponseBody.this.getSnapshot().close();
                    super.close();
                }
            });
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentLength */
        public long getContentLength() {
            String str = this.contentLength;
            if (str != null) {
                return Util.toLongOrDefault(str, -1L);
            }
            return -1L;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: contentType */
        public MediaType get$contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.INSTANCE.parse(str);
            }
            return null;
        }

        public final DiskLruCache.Snapshot getSnapshot() {
            return this.snapshot;
        }

        @Override // okhttp3.ResponseBody
        /* renamed from: source, reason: from getter */
        public h getBodySource() {
            return this.bodySource;
        }
    }

    /* compiled from: Cache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u00020\u001a*\u00020\u0015¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\t\u001a\u00020\u0002*\u00020\u0015¢\u0006\u0004\b\t\u0010\u001fR\u0016\u0010 \u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010!R\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010$\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010!¨\u0006'"}, d2 = {"Lokhttp3/Cache$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/Headers;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "varyFields", "(Lokhttp3/Headers;)Ljava/util/Set;", "requestHeaders", "responseHeaders", "varyHeaders", "(Lokhttp3/Headers;Lokhttp3/Headers;)Lokhttp3/Headers;", "Lokhttp3/HttpUrl;", "url", RoomNotification.KEY, "(Lokhttp3/HttpUrl;)Ljava/lang/String;", "Lj/h;", "source", HttpUrl.FRAGMENT_ENCODE_SET, "readInt$okhttp", "(Lj/h;)I", "readInt", "Lokhttp3/Response;", "cachedResponse", "cachedRequest", "Lokhttp3/Request;", "newRequest", HttpUrl.FRAGMENT_ENCODE_SET, "varyMatches", "(Lokhttp3/Response;Lokhttp3/Headers;Lokhttp3/Request;)Z", "hasVaryAll", "(Lokhttp3/Response;)Z", "(Lokhttp3/Response;)Lokhttp3/Headers;", "ENTRY_BODY", "I", "ENTRY_COUNT", "ENTRY_METADATA", "VERSION", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        private final Set<String> varyFields(Headers headers) {
            Set<String> d2;
            boolean q;
            List<String> u0;
            CharSequence O0;
            Comparator<String> s;
            int size = headers.size();
            TreeSet treeSet = null;
            for (int i2 = 0; i2 < size; i2++) {
                q = u.q("Vary", headers.name(i2), true);
                if (q) {
                    String value = headers.value(i2);
                    if (treeSet == null) {
                        s = u.s(StringCompanionObject.a);
                        treeSet = new TreeSet(s);
                    }
                    u0 = v.u0(value, new char[]{','}, false, 0, 6, null);
                    for (String str : u0) {
                        if (str == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        O0 = v.O0(str);
                        treeSet.add(O0.toString());
                    }
                }
            }
            if (treeSet != null) {
                return treeSet;
            }
            d2 = w0.d();
            return d2;
        }

        public final boolean hasVaryAll(Response response) {
            m.f(response, "$this$hasVaryAll");
            return varyFields(response.headers()).contains("*");
        }

        public final String key(HttpUrl url) {
            m.f(url, "url");
            return i.f22842g.d(url.getUrl()).I().F();
        }

        public final int readInt$okhttp(h source) throws IOException {
            m.f(source, "source");
            try {
                long d0 = source.d0();
                String L0 = source.L0();
                if (d0 >= 0 && d0 <= Integer.MAX_VALUE) {
                    if (!(L0.length() > 0)) {
                        return (int) d0;
                    }
                }
                throw new IOException("expected an int but was \"" + d0 + L0 + '\"');
            } catch (NumberFormatException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public final Headers varyHeaders(Response response) {
            m.f(response, "$this$varyHeaders");
            Response networkResponse = response.networkResponse();
            m.c(networkResponse);
            return varyHeaders(networkResponse.request().headers(), response.headers());
        }

        public final boolean varyMatches(Response cachedResponse, Headers cachedRequest, Request newRequest) {
            m.f(cachedResponse, "cachedResponse");
            m.f(cachedRequest, "cachedRequest");
            m.f(newRequest, "newRequest");
            Set<String> varyFields = varyFields(cachedResponse.headers());
            if ((varyFields instanceof Collection) && varyFields.isEmpty()) {
                return true;
            }
            for (String str : varyFields) {
                if (!m.a(cachedRequest.values(str), newRequest.headers(str))) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private final Headers varyHeaders(Headers requestHeaders, Headers responseHeaders) {
            Set<String> varyFields = varyFields(responseHeaders);
            if (varyFields.isEmpty()) {
                return Util.EMPTY_HEADERS;
            }
            Headers.Builder builder = new Headers.Builder();
            int size = requestHeaders.size();
            for (int i2 = 0; i2 < size; i2++) {
                String name = requestHeaders.name(i2);
                if (varyFields.contains(name)) {
                    builder.add(name, requestHeaders.value(i2));
                }
            }
            return builder.build();
        }
    }

    /* compiled from: Cache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\n\u001a\u00060\bR\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\u00060\bR\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0017"}, d2 = {"Lokhttp3/Cache$RealCacheRequest;", "Lokhttp3/internal/cache/CacheRequest;", "Lkotlin/u;", "abort", "()V", "Lj/b0;", "body", "()Lj/b0;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", HttpUrl.FRAGMENT_ENCODE_SET, "done", "Z", "getDone", "()Z", "setDone", "(Z)V", "Lj/b0;", "cacheOut", "<init>", "(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    private final class RealCacheRequest implements CacheRequest {
        private final b0 body;
        private final b0 cacheOut;
        private boolean done;
        private final DiskLruCache.Editor editor;
        final /* synthetic */ Cache this$0;

        public RealCacheRequest(Cache cache, DiskLruCache.Editor editor) {
            m.f(editor, "editor");
            this.this$0 = cache;
            this.editor = editor;
            b0 newSink = editor.newSink(1);
            this.cacheOut = newSink;
            this.body = new k(newSink) { // from class: okhttp3.Cache.RealCacheRequest.1
                @Override // j.k, j.b0, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    synchronized (RealCacheRequest.this.this$0) {
                        if (RealCacheRequest.this.getDone()) {
                            return;
                        }
                        RealCacheRequest.this.setDone(true);
                        Cache cache2 = RealCacheRequest.this.this$0;
                        cache2.setWriteSuccessCount$okhttp(cache2.getWriteSuccessCount() + 1);
                        super.close();
                        RealCacheRequest.this.editor.commit();
                    }
                }
            };
        }

        @Override // okhttp3.internal.cache.CacheRequest
        public void abort() {
            synchronized (this.this$0) {
                if (this.done) {
                    return;
                }
                this.done = true;
                Cache cache = this.this$0;
                cache.setWriteAbortCount$okhttp(cache.getWriteAbortCount() + 1);
                Util.closeQuietly(this.cacheOut);
                try {
                    this.editor.abort();
                } catch (IOException unused) {
                }
            }
        }

        @Override // okhttp3.internal.cache.CacheRequest
        /* renamed from: body, reason: from getter */
        public b0 getBody() {
            return this.body;
        }

        public final boolean getDone() {
            return this.done;
        }

        public final void setDone(boolean z) {
            this.done = z;
        }
    }

    public Cache(File file, long j2, FileSystem fileSystem) {
        m.f(file, "directory");
        m.f(fileSystem, "fileSystem");
        this.cache = new DiskLruCache(fileSystem, file, VERSION, 2, j2, TaskRunner.INSTANCE);
    }

    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static final String key(HttpUrl httpUrl) {
        return INSTANCE.key(httpUrl);
    }

    /* renamed from: -deprecated_directory, reason: not valid java name */
    public final File m387deprecated_directory() {
        return this.cache.getDirectory();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.cache.flush();
    }

    public final Response get$okhttp(Request request) {
        m.f(request, "request");
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(INSTANCE.key(request.url()));
            if (snapshot != null) {
                try {
                    Entry entry = new Entry(snapshot.getSource(0));
                    Response response = entry.response(snapshot);
                    if (entry.matches(request, response)) {
                        return response;
                    }
                    ResponseBody body = response.body();
                    if (body != null) {
                        Util.closeQuietly(body);
                    }
                    return null;
                } catch (IOException unused) {
                    Util.closeQuietly(snapshot);
                }
            }
        } catch (IOException unused2) {
        }
        return null;
    }

    /* renamed from: getCache$okhttp, reason: from getter */
    public final DiskLruCache getCache() {
        return this.cache;
    }

    /* renamed from: getWriteAbortCount$okhttp, reason: from getter */
    public final int getWriteAbortCount() {
        return this.writeAbortCount;
    }

    /* renamed from: getWriteSuccessCount$okhttp, reason: from getter */
    public final int getWriteSuccessCount() {
        return this.writeSuccessCount;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final synchronized int networkCount() {
        return this.networkCount;
    }

    public final CacheRequest put$okhttp(Response response) {
        DiskLruCache.Editor editor;
        m.f(response, "response");
        String method = response.request().method();
        if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
            try {
                remove$okhttp(response.request());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!m.a(method, "GET")) {
            return null;
        }
        Companion companion = INSTANCE;
        if (companion.hasVaryAll(response)) {
            return null;
        }
        Entry entry = new Entry(response);
        try {
            editor = DiskLruCache.edit$default(this.cache, companion.key(response.request().url()), 0L, 2, null);
            if (editor == null) {
                return null;
            }
            try {
                entry.writeTo(editor);
                return new RealCacheRequest(this, editor);
            } catch (IOException unused2) {
                abortQuietly(editor);
                return null;
            }
        } catch (IOException unused3) {
            editor = null;
        }
    }

    public final void remove$okhttp(Request request) throws IOException {
        m.f(request, "request");
        this.cache.remove(INSTANCE.key(request.url()));
    }

    public final synchronized int requestCount() {
        return this.requestCount;
    }

    public final void setWriteAbortCount$okhttp(int i2) {
        this.writeAbortCount = i2;
    }

    public final void setWriteSuccessCount$okhttp(int i2) {
        this.writeSuccessCount = i2;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final synchronized void trackConditionalCacheHit$okhttp() {
        this.hitCount++;
    }

    public final synchronized void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        m.f(cacheStrategy, "cacheStrategy");
        this.requestCount++;
        if (cacheStrategy.getNetworkRequest() != null) {
            this.networkCount++;
        } else if (cacheStrategy.getCacheResponse() != null) {
            this.hitCount++;
        }
    }

    public final void update$okhttp(Response cached, Response network) {
        m.f(cached, "cached");
        m.f(network, "network");
        Entry entry = new Entry(network);
        ResponseBody body = cached.body();
        if (body != null) {
            DiskLruCache.Editor editor = null;
            try {
                editor = ((CacheResponseBody) body).getSnapshot().edit();
                if (editor != null) {
                    entry.writeTo(editor);
                    editor.commit();
                    return;
                }
                return;
            } catch (IOException unused) {
                abortQuietly(editor);
                return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
    }

    public final Iterator<String> urls() throws IOException {
        return new Cache$urls$1(this);
    }

    public final synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public final synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Cache(File file, long j2) {
        this(file, j2, FileSystem.SYSTEM);
        m.f(file, "directory");
    }

    /* compiled from: Cache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u0011\b\u0016\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b7\u00109J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u000eR\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u0016\u001a\u00020\u00152\n\u0010\u001b\u001a\u00060\u001aR\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001fR\u0016\u0010(\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001fR\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00178B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u0006;"}, d2 = {"Lokhttp3/Cache$Entry;", HttpUrl.FRAGMENT_ENCODE_SET, "Lj/h;", "source", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/security/cert/Certificate;", "readCertificateList", "(Lj/h;)Ljava/util/List;", "Lj/g;", "sink", "certificates", "Lkotlin/u;", "writeCertList", "(Lj/g;Ljava/util/List;)V", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "writeTo", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "Lokhttp3/Request;", "request", "Lokhttp3/Response;", "response", HttpUrl.FRAGMENT_ENCODE_SET, "matches", "(Lokhttp3/Request;Lokhttp3/Response;)Z", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot", "(Lokhttp3/internal/cache/DiskLruCache$Snapshot;)Lokhttp3/Response;", HttpUrl.FRAGMENT_ENCODE_SET, "url", "Ljava/lang/String;", HttpUrl.FRAGMENT_ENCODE_SET, "sentRequestMillis", "J", "receivedResponseMillis", "Lokhttp3/Headers;", "responseHeaders", "Lokhttp3/Headers;", "message", "requestMethod", "varyHeaders", "Lokhttp3/Handshake;", "handshake", "Lokhttp3/Handshake;", "isHttps", "()Z", HttpUrl.FRAGMENT_ENCODE_SET, "code", "I", "Lokhttp3/Protocol;", "protocol", "Lokhttp3/Protocol;", "Lj/d0;", "rawSource", "<init>", "(Lj/d0;)V", "(Lokhttp3/Response;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    private static final class Entry {
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        static {
            StringBuilder sb = new StringBuilder();
            Platform.Companion companion = Platform.INSTANCE;
            sb.append(companion.get().getPrefix());
            sb.append("-Sent-Millis");
            SENT_MILLIS = sb.toString();
            RECEIVED_MILLIS = companion.get().getPrefix() + "-Received-Millis";
        }

        public Entry(d0 d0Var) throws IOException {
            TlsVersion tlsVersion;
            m.f(d0Var, "rawSource");
            try {
                h d2 = q.d(d0Var);
                this.url = d2.L0();
                this.requestMethod = d2.L0();
                Headers.Builder builder = new Headers.Builder();
                int readInt$okhttp = Cache.INSTANCE.readInt$okhttp(d2);
                for (int i2 = 0; i2 < readInt$okhttp; i2++) {
                    builder.addLenient$okhttp(d2.L0());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.INSTANCE.parse(d2.L0());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt$okhttp2 = Cache.INSTANCE.readInt$okhttp(d2);
                for (int i3 = 0; i3 < readInt$okhttp2; i3++) {
                    builder2.addLenient$okhttp(d2.L0());
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0L;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : 0L;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String L0 = d2.L0();
                    if (!(L0.length() > 0)) {
                        CipherSuite forJavaName = CipherSuite.INSTANCE.forJavaName(d2.L0());
                        List<Certificate> readCertificateList = readCertificateList(d2);
                        List<Certificate> readCertificateList2 = readCertificateList(d2);
                        if (!d2.R()) {
                            tlsVersion = TlsVersion.INSTANCE.forJavaName(d2.L0());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.handshake = Handshake.INSTANCE.get(tlsVersion, forJavaName, readCertificateList, readCertificateList2);
                    } else {
                        throw new IOException("expected \"\" but was \"" + L0 + '\"');
                    }
                } else {
                    this.handshake = null;
                }
            } finally {
                d0Var.close();
            }
        }

        private final boolean isHttps() {
            boolean E;
            E = u.E(this.url, "https://", false, 2, null);
            return E;
        }

        private final List<Certificate> readCertificateList(h source) throws IOException {
            List<Certificate> j2;
            int readInt$okhttp = Cache.INSTANCE.readInt$okhttp(source);
            if (readInt$okhttp == -1) {
                j2 = kotlin.collections.u.j();
                return j2;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt$okhttp);
                for (int i2 = 0; i2 < readInt$okhttp; i2++) {
                    String L0 = source.L0();
                    f fVar = new f();
                    i a = i.f22842g.a(L0);
                    m.c(a);
                    fVar.U0(a);
                    arrayList.add(certificateFactory.generateCertificate(fVar.o1()));
                }
                return arrayList;
            } catch (CertificateException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        private final void writeCertList(j.g sink, List<? extends Certificate> certificates) throws IOException {
            try {
                sink.i1(certificates.size()).writeByte(10);
                int size = certificates.size();
                for (int i2 = 0; i2 < size; i2++) {
                    byte[] encoded = certificates.get(i2).getEncoded();
                    i.a aVar = i.f22842g;
                    m.e(encoded, "bytes");
                    sink.r0(i.a.f(aVar, encoded, 0, 0, 3, null).g()).writeByte(10);
                }
            } catch (CertificateEncodingException e2) {
                throw new IOException(e2.getMessage());
            }
        }

        public final boolean matches(Request request, Response response) {
            m.f(request, "request");
            m.f(response, "response");
            return m.a(this.url, request.url().getUrl()) && m.a(this.requestMethod, request.method()) && Cache.INSTANCE.varyMatches(response, this.varyHeaders, request);
        }

        public final Response response(DiskLruCache.Snapshot snapshot) {
            m.f(snapshot, "snapshot");
            String str = this.responseHeaders.get("Content-Type");
            String str2 = this.responseHeaders.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public final void writeTo(DiskLruCache.Editor editor) throws IOException {
            m.f(editor, "editor");
            j.g c2 = q.c(editor.newSink(0));
            try {
                c2.r0(this.url).writeByte(10);
                c2.r0(this.requestMethod).writeByte(10);
                c2.i1(this.varyHeaders.size()).writeByte(10);
                int size = this.varyHeaders.size();
                for (int i2 = 0; i2 < size; i2++) {
                    c2.r0(this.varyHeaders.name(i2)).r0(": ").r0(this.varyHeaders.value(i2)).writeByte(10);
                }
                c2.r0(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
                c2.i1(this.responseHeaders.size() + 2).writeByte(10);
                int size2 = this.responseHeaders.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    c2.r0(this.responseHeaders.name(i3)).r0(": ").r0(this.responseHeaders.value(i3)).writeByte(10);
                }
                c2.r0(SENT_MILLIS).r0(": ").i1(this.sentRequestMillis).writeByte(10);
                c2.r0(RECEIVED_MILLIS).r0(": ").i1(this.receivedResponseMillis).writeByte(10);
                if (isHttps()) {
                    c2.writeByte(10);
                    Handshake handshake = this.handshake;
                    m.c(handshake);
                    c2.r0(handshake.cipherSuite().javaName()).writeByte(10);
                    writeCertList(c2, this.handshake.peerCertificates());
                    writeCertList(c2, this.handshake.localCertificates());
                    c2.r0(this.handshake.tlsVersion().javaName()).writeByte(10);
                }
                kotlin.u uVar = kotlin.u.a;
                kotlin.io.a.a(c2, null);
            } finally {
            }
        }

        public Entry(Response response) {
            m.f(response, "response");
            this.url = response.request().url().getUrl();
            this.varyHeaders = Cache.INSTANCE.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
