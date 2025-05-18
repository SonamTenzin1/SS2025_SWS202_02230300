package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.p0;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: GraphRequestAsyncTask.kt */
/* loaded from: classes.dex */
public class b0 extends AsyncTask<Void, Void, List<? extends d0>> {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final String f9654b = b0.class.getCanonicalName();

    /* renamed from: c, reason: collision with root package name */
    private final HttpURLConnection f9655c;

    /* renamed from: d, reason: collision with root package name */
    private final c0 f9656d;

    /* renamed from: e, reason: collision with root package name */
    private Exception f9657e;

    /* compiled from: GraphRequestAsyncTask.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public b0(HttpURLConnection httpURLConnection, c0 c0Var) {
        kotlin.jvm.internal.m.f(c0Var, "requests");
        this.f9655c = httpURLConnection;
        this.f9656d = c0Var;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<d0> doInBackground(Void... voidArr) {
        List<d0> m;
        kotlin.jvm.internal.m.f(voidArr, "params");
        try {
            HttpURLConnection httpURLConnection = this.f9655c;
            if (httpURLConnection == null) {
                m = this.f9656d.i();
            } else {
                m = GraphRequest.a.m(httpURLConnection, this.f9656d);
            }
            return m;
        } catch (Exception e2) {
            this.f9657e = e2;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<d0> list) {
        kotlin.jvm.internal.m.f(list, "result");
        super.onPostExecute(list);
        Exception exc = this.f9657e;
        if (exc != null) {
            p0 p0Var = p0.a;
            String str = f9654b;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format("onPostExecute: exception encountered during request: %s", Arrays.copyOf(new Object[]{exc.getMessage()}, 1));
            kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
            p0.j0(str, format);
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        Handler handler;
        super.onPreExecute();
        a0 a0Var = a0.a;
        if (a0.u()) {
            p0 p0Var = p0.a;
            String str = f9654b;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format("execute async task: %s", Arrays.copyOf(new Object[]{this}, 1));
            kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
            p0.j0(str, format);
        }
        if (this.f9656d.t() == null) {
            if (Thread.currentThread() instanceof HandlerThread) {
                handler = new Handler();
            } else {
                handler = new Handler(Looper.getMainLooper());
            }
            this.f9656d.G(handler);
        }
    }

    public String toString() {
        String str = "{RequestAsyncTask:  connection: " + this.f9655c + ", requests: " + this.f9656d + "}";
        kotlin.jvm.internal.m.e(str, "StringBuilder()\n        .append(\"{RequestAsyncTask: \")\n        .append(\" connection: \")\n        .append(connection)\n        .append(\", requests: \")\n        .append(requests)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0(c0 c0Var) {
        this(null, c0Var);
        kotlin.jvm.internal.m.f(c0Var, "requests");
    }
}
