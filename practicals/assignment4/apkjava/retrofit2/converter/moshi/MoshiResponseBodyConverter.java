package retrofit2.converter.moshi;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.f;
import com.squareup.moshi.i;
import j.h;
import j.i;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes3.dex */
final class MoshiResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final i UTF8_BOM = i.q("EFBBBF");
    private final f<T> adapter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MoshiResponseBodyConverter(f<T> fVar) {
        this.adapter = fVar;
    }

    @Override // retrofit2.Converter
    public T convert(ResponseBody responseBody) throws IOException {
        h bodySource = responseBody.getBodySource();
        try {
            if (bodySource.v0(0L, UTF8_BOM)) {
                bodySource.skip(r3.P());
            }
            com.squareup.moshi.i z = com.squareup.moshi.i.z(bodySource);
            T fromJson = this.adapter.fromJson(z);
            if (z.A() == i.b.END_DOCUMENT) {
                return fromJson;
            }
            throw new JsonDataException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
