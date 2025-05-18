package c.i.h;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import c.i.j.i;

/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class f {

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class a {
        private final int a;

        /* renamed from: b, reason: collision with root package name */
        private final b[] f3233b;

        @Deprecated
        public a(int i2, b[] bVarArr) {
            this.a = i2;
            this.f3233b = bVarArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(int i2, b[] bVarArr) {
            return new a(i2, bVarArr);
        }

        public b[] b() {
            return this.f3233b;
        }

        public int c() {
            return this.a;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class b {
        private final Uri a;

        /* renamed from: b, reason: collision with root package name */
        private final int f3234b;

        /* renamed from: c, reason: collision with root package name */
        private final int f3235c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f3236d;

        /* renamed from: e, reason: collision with root package name */
        private final int f3237e;

        @Deprecated
        public b(Uri uri, int i2, int i3, boolean z, int i4) {
            this.a = (Uri) i.c(uri);
            this.f3234b = i2;
            this.f3235c = i3;
            this.f3236d = z;
            this.f3237e = i4;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(Uri uri, int i2, int i3, boolean z, int i4) {
            return new b(uri, i2, i3, z, i4);
        }

        public int b() {
            return this.f3237e;
        }

        public int c() {
            return this.f3234b;
        }

        public Uri d() {
            return this.a;
        }

        public int e() {
            return this.f3235c;
        }

        public boolean f() {
            return this.f3236d;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        public void a(int i2) {
            throw null;
        }

        public void b(Typeface typeface) {
            throw null;
        }
    }

    public static Typeface a(Context context, d dVar, int i2, boolean z, int i3, Handler handler, c cVar) {
        c.i.h.a aVar = new c.i.h.a(cVar, handler);
        if (z) {
            return e.e(context, dVar, aVar, i2, i3);
        }
        return e.d(context, dVar, i2, null, aVar);
    }
}
