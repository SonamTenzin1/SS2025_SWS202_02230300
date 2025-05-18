package io.sentry.android.core.internal.threaddump;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: Lines.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class b {
    private final ArrayList<? extends a> a;

    /* renamed from: b, reason: collision with root package name */
    private final int f22164b = 0;

    /* renamed from: c, reason: collision with root package name */
    private final int f22165c;

    /* renamed from: d, reason: collision with root package name */
    public int f22166d;

    public b(ArrayList<? extends a> arrayList) {
        this.a = arrayList;
        this.f22165c = arrayList.size();
    }

    public static b c(BufferedReader bufferedReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                i2++;
                arrayList.add(new a(i2, readLine));
            } else {
                return new b(arrayList);
            }
        }
    }

    public boolean a() {
        return this.f22166d < this.f22165c;
    }

    public a b() {
        int i2 = this.f22166d;
        if (i2 < this.f22164b || i2 >= this.f22165c) {
            return null;
        }
        ArrayList<? extends a> arrayList = this.a;
        this.f22166d = i2 + 1;
        return arrayList.get(i2);
    }

    public void d() {
        this.f22166d--;
    }
}
