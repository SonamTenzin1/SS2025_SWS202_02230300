package com.aptoide.authentication.network;

import com.aptoide.authentication.network.RemoteAuthenticationService;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.o;
import com.squareup.moshi.r;
import com.squareup.moshi.u;
import com.squareup.moshi.w.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* compiled from: RemoteAuthenticationService_CredentialsJsonAdapter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/aptoide/authentication/network/RemoteAuthenticationService_CredentialsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/aptoide/authentication/network/RemoteAuthenticationService$Credentials;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "arrayOfStringAdapter", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", HttpUrl.FRAGMENT_ENCODE_SET, "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "aptoide-authentication-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.aptoide.authentication.network.RemoteAuthenticationService_CredentialsJsonAdapter, reason: from toString */
/* loaded from: classes.dex */
public final class GeneratedJsonAdapter extends f<RemoteAuthenticationService.Credentials> {
    private final f<String[]> arrayOfStringAdapter;
    private final i.a options;
    private final f<String> stringAdapter;

    public GeneratedJsonAdapter(r rVar) {
        Set<? extends Annotation> d2;
        Set<? extends Annotation> d3;
        m.f(rVar, "moshi");
        i.a a = i.a.a("credential", "supported");
        m.e(a, "of(\"credential\", \"supported\")");
        this.options = a;
        d2 = w0.d();
        f<String> f2 = rVar.f(String.class, d2, "credential");
        m.e(f2, "moshi.adapter(String::cl…et(),\n      \"credential\")");
        this.stringAdapter = f2;
        GenericArrayType b2 = u.b(String.class);
        d3 = w0.d();
        f<String[]> f3 = rVar.f(b2, d3, "supported");
        m.e(f3, "moshi.adapter(Types.arra… emptySet(), \"supported\")");
        this.arrayOfStringAdapter = f3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(61);
        sb.append("GeneratedJsonAdapter(");
        sb.append("RemoteAuthenticationService.Credentials");
        sb.append(')');
        String sb2 = sb.toString();
        m.e(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.f
    public RemoteAuthenticationService.Credentials fromJson(i iVar) {
        m.f(iVar, "reader");
        iVar.b();
        String str = null;
        String[] strArr = null;
        while (iVar.f()) {
            int H = iVar.H(this.options);
            if (H == -1) {
                iVar.N();
                iVar.Q();
            } else if (H == 0) {
                str = this.stringAdapter.fromJson(iVar);
                if (str == null) {
                    JsonDataException v = c.v("credential", "credential", iVar);
                    m.e(v, "unexpectedNull(\"credenti…    \"credential\", reader)");
                    throw v;
                }
            } else if (H == 1 && (strArr = this.arrayOfStringAdapter.fromJson(iVar)) == null) {
                JsonDataException v2 = c.v("supported", "supported", iVar);
                m.e(v2, "unexpectedNull(\"supported\", \"supported\", reader)");
                throw v2;
            }
        }
        iVar.d();
        if (str == null) {
            JsonDataException n = c.n("credential", "credential", iVar);
            m.e(n, "missingProperty(\"credent…l\", \"credential\", reader)");
            throw n;
        }
        if (strArr != null) {
            return new RemoteAuthenticationService.Credentials(str, strArr);
        }
        JsonDataException n2 = c.n("supported", "supported", iVar);
        m.e(n2, "missingProperty(\"supported\", \"supported\", reader)");
        throw n2;
    }

    @Override // com.squareup.moshi.f
    public void toJson(o oVar, RemoteAuthenticationService.Credentials credentials) {
        m.f(oVar, "writer");
        if (credentials != null) {
            oVar.b();
            oVar.l("credential");
            this.stringAdapter.toJson(oVar, (o) credentials.getCredential());
            oVar.l("supported");
            this.arrayOfStringAdapter.toJson(oVar, (o) credentials.getSupported());
            oVar.e();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
