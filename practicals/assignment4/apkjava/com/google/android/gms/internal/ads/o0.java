package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

/* loaded from: classes2.dex */
final class o0 extends zzaj {
    private final zzas a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(zzas zzasVar) {
        this.a = zzasVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaj
    public final zzar b(zzr<?> zzrVar, Map<String, String> map) throws IOException, zza {
        try {
            HttpResponse a = this.a.a(zzrVar, map);
            int statusCode = a.getStatusLine().getStatusCode();
            Header[] allHeaders = a.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new zzl(header.getName(), header.getValue()));
            }
            if (a.getEntity() == null) {
                return new zzar(statusCode, arrayList);
            }
            long contentLength = a.getEntity().getContentLength();
            if (((int) contentLength) == contentLength) {
                return new zzar(statusCode, arrayList, (int) a.getEntity().getContentLength(), a.getEntity().getContent());
            }
            StringBuilder sb = new StringBuilder(40);
            sb.append("Response too large: ");
            sb.append(contentLength);
            throw new IOException(sb.toString());
        } catch (ConnectTimeoutException e2) {
            throw new SocketTimeoutException(e2.getMessage());
        }
    }
}
