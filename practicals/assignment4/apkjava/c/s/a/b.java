package c.s.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: Palette.java */
/* loaded from: classes.dex */
public final class b {
    static final c a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final List<e> f3426b;

    /* renamed from: c, reason: collision with root package name */
    private final List<c.s.a.c> f3427c;

    /* renamed from: e, reason: collision with root package name */
    private final SparseBooleanArray f3429e = new SparseBooleanArray();

    /* renamed from: d, reason: collision with root package name */
    private final Map<c.s.a.c, e> f3428d = new c.e.a();

    /* renamed from: f, reason: collision with root package name */
    private final e f3430f = a();

    /* compiled from: Palette.java */
    /* loaded from: classes.dex */
    static class a implements c {
        a() {
        }

        private boolean b(float[] fArr) {
            return fArr[2] <= 0.05f;
        }

        private boolean c(float[] fArr) {
            return fArr[0] >= 10.0f && fArr[0] <= 37.0f && fArr[1] <= 0.82f;
        }

        private boolean d(float[] fArr) {
            return fArr[2] >= 0.95f;
        }

        @Override // c.s.a.b.c
        public boolean a(int i2, float[] fArr) {
            return (d(fArr) || b(fArr) || c(fArr)) ? false : true;
        }
    }

    /* compiled from: Palette.java */
    /* renamed from: c.s.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0093b {
        private final List<e> a;

        /* renamed from: b, reason: collision with root package name */
        private final Bitmap f3431b;

        /* renamed from: c, reason: collision with root package name */
        private final List<c.s.a.c> f3432c;

        /* renamed from: d, reason: collision with root package name */
        private int f3433d;

        /* renamed from: e, reason: collision with root package name */
        private int f3434e;

        /* renamed from: f, reason: collision with root package name */
        private int f3435f;

        /* renamed from: g, reason: collision with root package name */
        private final List<c> f3436g;

        /* renamed from: h, reason: collision with root package name */
        private Rect f3437h;

        /* compiled from: Palette.java */
        /* renamed from: c.s.a.b$b$a */
        /* loaded from: classes.dex */
        class a extends AsyncTask<Bitmap, Void, b> {
            final /* synthetic */ d a;

            a(d dVar) {
                this.a = dVar;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b doInBackground(Bitmap... bitmapArr) {
                try {
                    return C0093b.this.b();
                } catch (Exception e2) {
                    Log.e("Palette", "Exception thrown during async generate", e2);
                    return null;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(b bVar) {
                this.a.a(bVar);
            }
        }

        public C0093b(Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.f3432c = arrayList;
            this.f3433d = 16;
            this.f3434e = 12544;
            this.f3435f = -1;
            ArrayList arrayList2 = new ArrayList();
            this.f3436g = arrayList2;
            if (bitmap != null && !bitmap.isRecycled()) {
                arrayList2.add(b.a);
                this.f3431b = bitmap;
                this.a = null;
                arrayList.add(c.s.a.c.a);
                arrayList.add(c.s.a.c.f3447b);
                arrayList.add(c.s.a.c.f3448c);
                arrayList.add(c.s.a.c.f3449d);
                arrayList.add(c.s.a.c.f3450e);
                arrayList.add(c.s.a.c.f3451f);
                return;
            }
            throw new IllegalArgumentException("Bitmap is not valid");
        }

        private int[] c(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.f3437h;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.f3437h.height();
            int[] iArr2 = new int[width2 * height2];
            for (int i2 = 0; i2 < height2; i2++) {
                Rect rect2 = this.f3437h;
                System.arraycopy(iArr, ((rect2.top + i2) * width) + rect2.left, iArr2, i2 * width2, width2);
            }
            return iArr2;
        }

        private Bitmap e(Bitmap bitmap) {
            int max;
            int i2;
            double d2 = -1.0d;
            if (this.f3434e > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i3 = this.f3434e;
                if (width > i3) {
                    double d3 = i3;
                    double d4 = width;
                    Double.isNaN(d3);
                    Double.isNaN(d4);
                    d2 = Math.sqrt(d3 / d4);
                }
            } else if (this.f3435f > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i2 = this.f3435f)) {
                double d5 = i2;
                double d6 = max;
                Double.isNaN(d5);
                Double.isNaN(d6);
                d2 = d5 / d6;
            }
            if (d2 <= 0.0d) {
                return bitmap;
            }
            double width2 = bitmap.getWidth();
            Double.isNaN(width2);
            int ceil = (int) Math.ceil(width2 * d2);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, ceil, (int) Math.ceil(height * d2), false);
        }

        public AsyncTask<Bitmap, Void, b> a(d dVar) {
            if (dVar != null) {
                return new a(dVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f3431b);
            }
            throw new IllegalArgumentException("listener can not be null");
        }

        public b b() {
            List<e> list;
            c[] cVarArr;
            Bitmap bitmap = this.f3431b;
            if (bitmap != null) {
                Bitmap e2 = e(bitmap);
                Rect rect = this.f3437h;
                if (e2 != this.f3431b && rect != null) {
                    double width = e2.getWidth();
                    double width2 = this.f3431b.getWidth();
                    Double.isNaN(width);
                    Double.isNaN(width2);
                    double d2 = width / width2;
                    double d3 = rect.left;
                    Double.isNaN(d3);
                    rect.left = (int) Math.floor(d3 * d2);
                    double d4 = rect.top;
                    Double.isNaN(d4);
                    rect.top = (int) Math.floor(d4 * d2);
                    double d5 = rect.right;
                    Double.isNaN(d5);
                    rect.right = Math.min((int) Math.ceil(d5 * d2), e2.getWidth());
                    double d6 = rect.bottom;
                    Double.isNaN(d6);
                    rect.bottom = Math.min((int) Math.ceil(d6 * d2), e2.getHeight());
                }
                int[] c2 = c(e2);
                int i2 = this.f3433d;
                if (this.f3436g.isEmpty()) {
                    cVarArr = null;
                } else {
                    List<c> list2 = this.f3436g;
                    cVarArr = (c[]) list2.toArray(new c[list2.size()]);
                }
                c.s.a.a aVar = new c.s.a.a(c2, i2, cVarArr);
                if (e2 != this.f3431b) {
                    e2.recycle();
                }
                list = aVar.d();
            } else {
                list = this.a;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            b bVar = new b(list, this.f3432c);
            bVar.c();
            return bVar;
        }

        public C0093b d(int i2) {
            this.f3433d = i2;
            return this;
        }
    }

    /* compiled from: Palette.java */
    /* loaded from: classes.dex */
    public interface c {
        boolean a(int i2, float[] fArr);
    }

    /* compiled from: Palette.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(b bVar);
    }

    /* compiled from: Palette.java */
    /* loaded from: classes.dex */
    public static final class e {
        private final int a;

        /* renamed from: b, reason: collision with root package name */
        private final int f3439b;

        /* renamed from: c, reason: collision with root package name */
        private final int f3440c;

        /* renamed from: d, reason: collision with root package name */
        private final int f3441d;

        /* renamed from: e, reason: collision with root package name */
        private final int f3442e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f3443f;

        /* renamed from: g, reason: collision with root package name */
        private int f3444g;

        /* renamed from: h, reason: collision with root package name */
        private int f3445h;

        /* renamed from: i, reason: collision with root package name */
        private float[] f3446i;

        public e(int i2, int i3) {
            this.a = Color.red(i2);
            this.f3439b = Color.green(i2);
            this.f3440c = Color.blue(i2);
            this.f3441d = i2;
            this.f3442e = i3;
        }

        private void a() {
            int o;
            int o2;
            if (this.f3443f) {
                return;
            }
            int f2 = c.i.e.a.f(-1, this.f3441d, 4.5f);
            int f3 = c.i.e.a.f(-1, this.f3441d, 3.0f);
            if (f2 != -1 && f3 != -1) {
                this.f3445h = c.i.e.a.o(-1, f2);
                this.f3444g = c.i.e.a.o(-1, f3);
                this.f3443f = true;
                return;
            }
            int f4 = c.i.e.a.f(-16777216, this.f3441d, 4.5f);
            int f5 = c.i.e.a.f(-16777216, this.f3441d, 3.0f);
            if (f4 != -1 && f5 != -1) {
                this.f3445h = c.i.e.a.o(-16777216, f4);
                this.f3444g = c.i.e.a.o(-16777216, f5);
                this.f3443f = true;
                return;
            }
            if (f2 != -1) {
                o = c.i.e.a.o(-1, f2);
            } else {
                o = c.i.e.a.o(-16777216, f4);
            }
            this.f3445h = o;
            if (f3 != -1) {
                o2 = c.i.e.a.o(-1, f3);
            } else {
                o2 = c.i.e.a.o(-16777216, f5);
            }
            this.f3444g = o2;
            this.f3443f = true;
        }

        public int b() {
            a();
            return this.f3445h;
        }

        public float[] c() {
            if (this.f3446i == null) {
                this.f3446i = new float[3];
            }
            c.i.e.a.b(this.a, this.f3439b, this.f3440c, this.f3446i);
            return this.f3446i;
        }

        public int d() {
            return this.f3442e;
        }

        public int e() {
            return this.f3441d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f3442e == eVar.f3442e && this.f3441d == eVar.f3441d;
        }

        public int f() {
            a();
            return this.f3444g;
        }

        public int hashCode() {
            return (this.f3441d * 31) + this.f3442e;
        }

        public String toString() {
            return e.class.getSimpleName() + " [RGB: #" + Integer.toHexString(e()) + "] [HSL: " + Arrays.toString(c()) + "] [Population: " + this.f3442e + "] [Title Text: #" + Integer.toHexString(f()) + "] [Body Text: #" + Integer.toHexString(b()) + ']';
        }
    }

    b(List<e> list, List<c.s.a.c> list2) {
        this.f3426b = list;
        this.f3427c = list2;
    }

    private e a() {
        int size = this.f3426b.size();
        int i2 = Integer.MIN_VALUE;
        e eVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            e eVar2 = this.f3426b.get(i3);
            if (eVar2.d() > i2) {
                i2 = eVar2.d();
                eVar = eVar2;
            }
        }
        return eVar;
    }

    public static C0093b b(Bitmap bitmap) {
        return new C0093b(bitmap);
    }

    private float d(e eVar, c.s.a.c cVar) {
        float[] c2 = eVar.c();
        e eVar2 = this.f3430f;
        return (cVar.g() > 0.0f ? cVar.g() * (1.0f - Math.abs(c2[1] - cVar.i())) : 0.0f) + (cVar.a() > 0.0f ? cVar.a() * (1.0f - Math.abs(c2[2] - cVar.h())) : 0.0f) + (cVar.f() > 0.0f ? cVar.f() * (eVar.d() / (eVar2 != null ? eVar2.d() : 1)) : 0.0f);
    }

    private e e(c.s.a.c cVar) {
        e g2 = g(cVar);
        if (g2 != null && cVar.j()) {
            this.f3429e.append(g2.e(), true);
        }
        return g2;
    }

    private e g(c.s.a.c cVar) {
        int size = this.f3426b.size();
        float f2 = 0.0f;
        e eVar = null;
        for (int i2 = 0; i2 < size; i2++) {
            e eVar2 = this.f3426b.get(i2);
            if (h(eVar2, cVar)) {
                float d2 = d(eVar2, cVar);
                if (eVar == null || d2 > f2) {
                    eVar = eVar2;
                    f2 = d2;
                }
            }
        }
        return eVar;
    }

    private boolean h(e eVar, c.s.a.c cVar) {
        float[] c2 = eVar.c();
        return c2[1] >= cVar.e() && c2[1] <= cVar.c() && c2[2] >= cVar.d() && c2[2] <= cVar.b() && !this.f3429e.get(eVar.e());
    }

    void c() {
        int size = this.f3427c.size();
        for (int i2 = 0; i2 < size; i2++) {
            c.s.a.c cVar = this.f3427c.get(i2);
            cVar.k();
            this.f3428d.put(cVar, e(cVar));
        }
        this.f3429e.clear();
    }

    public int f(int i2) {
        e eVar = this.f3430f;
        return eVar != null ? eVar.e() : i2;
    }
}
