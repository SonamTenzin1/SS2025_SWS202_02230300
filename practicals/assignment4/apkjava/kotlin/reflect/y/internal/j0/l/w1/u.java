package kotlin.reflect.y.internal.j0.l.w1;

import okhttp3.HttpUrl;

/* compiled from: TypeSystemContext.kt */
/* loaded from: classes3.dex */
public enum u {
    IN("in"),
    OUT("out"),
    INV(HttpUrl.FRAGMENT_ENCODE_SET);


    /* renamed from: j, reason: collision with root package name */
    private final String f24875j;

    u(String str) {
        this.f24875j = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f24875j;
    }
}
