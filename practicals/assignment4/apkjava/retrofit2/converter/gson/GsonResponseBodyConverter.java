package retrofit2.converter.gson;

import com.google.gson.JsonIOException;
import com.google.gson.e;
import com.google.gson.q;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes3.dex */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final q<T> adapter;
    private final e gson;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GsonResponseBodyConverter(e eVar, q<T> qVar) {
        this.gson = eVar;
        this.adapter = qVar;
    }

    @Override // retrofit2.Converter
    public T convert(ResponseBody responseBody) throws IOException {
        a n = this.gson.n(responseBody.charStream());
        try {
            T b2 = this.adapter.b(n);
            if (n.Q() == b.END_DOCUMENT) {
                return b2;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
