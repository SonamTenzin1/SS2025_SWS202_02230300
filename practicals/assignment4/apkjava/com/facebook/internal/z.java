package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.facebook.internal.r0;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FacebookWebFallbackDialog.kt */
/* loaded from: classes2.dex */
public final class z extends r0 {
    public static final a v = new a(null);
    private static final String w = z.class.getName();
    private boolean x;

    /* compiled from: FacebookWebFallbackDialog.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final z a(Context context, String str, String str2) {
            kotlin.jvm.internal.m.f(context, "context");
            kotlin.jvm.internal.m.f(str, "url");
            kotlin.jvm.internal.m.f(str2, "expectedRedirectUrl");
            r0.b bVar = r0.f9841f;
            r0.p(context);
            return new z(context, str, str2, null);
        }
    }

    private z(Context context, String str, String str2) {
        super(context, str);
        A(str2);
    }

    public /* synthetic */ z(Context context, String str, String str2, kotlin.jvm.internal.g gVar) {
        this(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(z zVar) {
        kotlin.jvm.internal.m.f(zVar, "this$0");
        super.cancel();
    }

    @Override // com.facebook.internal.r0, android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        WebView o = o();
        if (r() && !q() && o != null && o.isShown()) {
            if (this.x) {
                return;
            }
            this.x = true;
            o.loadUrl(kotlin.jvm.internal.m.n("javascript:", "(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();"));
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.facebook.internal.c
                @Override // java.lang.Runnable
                public final void run() {
                    z.E(z.this);
                }
            }, 1500L);
            return;
        }
        super.cancel();
    }

    @Override // com.facebook.internal.r0
    public Bundle w(String str) {
        Uri parse = Uri.parse(str);
        p0 p0Var = p0.a;
        Bundle o0 = p0.o0(parse.getQuery());
        String string = o0.getString("bridge_args");
        o0.remove("bridge_args");
        if (!p0.a0(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                s sVar = s.a;
                o0.putBundle("com.facebook.platform.protocol.BRIDGE_ARGS", s.a(jSONObject));
            } catch (JSONException e2) {
                p0 p0Var2 = p0.a;
                p0.k0(w, "Unable to parse bridge_args JSON", e2);
            }
        }
        String string2 = o0.getString("method_results");
        o0.remove("method_results");
        p0 p0Var3 = p0.a;
        if (!p0.a0(string2)) {
            try {
                JSONObject jSONObject2 = new JSONObject(string2);
                s sVar2 = s.a;
                o0.putBundle("com.facebook.platform.protocol.RESULT_ARGS", s.a(jSONObject2));
            } catch (JSONException e3) {
                p0 p0Var4 = p0.a;
                p0.k0(w, "Unable to parse bridge_args JSON", e3);
            }
        }
        o0.remove("version");
        k0 k0Var = k0.a;
        o0.putInt("com.facebook.platform.protocol.PROTOCOL_VERSION", k0.s());
        return o0;
    }
}
