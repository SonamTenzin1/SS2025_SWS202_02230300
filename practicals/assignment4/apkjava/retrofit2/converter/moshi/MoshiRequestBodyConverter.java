package retrofit2.converter.moshi;

import com.squareup.moshi.f;
import com.squareup.moshi.o;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* loaded from: classes3.dex */
final class MoshiRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    private final f<T> adapter;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MoshiRequestBodyConverter(f<T> fVar) {
        this.adapter = fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
        return convert((MoshiRequestBodyConverter<T>) obj);
    }

    @Override // retrofit2.Converter
    public RequestBody convert(T t) throws IOException {
        j.f fVar = new j.f();
        this.adapter.toJson(o.p(fVar), (o) t);
        return RequestBody.create(MEDIA_TYPE, fVar.D0());
    }
}
