package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.facebook.FacebookException;
import com.facebook.internal.r0;
import com.facebook.internal.z;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: FacebookDialogFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010\u000eJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u000eR$\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/facebook/internal/w;", "Landroidx/fragment/app/c;", "Landroid/os/Bundle;", "values", "Lcom/facebook/FacebookException;", "error", "Lkotlin/u;", "i", "(Landroid/os/Bundle;Lcom/facebook/FacebookException;)V", "j", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "d", "()V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onDestroyView", "g", "Landroid/app/Dialog;", "getInnerDialog", "()Landroid/app/Dialog;", "k", "(Landroid/app/Dialog;)V", "innerDialog", "<init>", "f", "a", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class w extends androidx.fragment.app.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Dialog innerDialog;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(w wVar, Bundle bundle, FacebookException facebookException) {
        kotlin.jvm.internal.m.f(wVar, "this$0");
        wVar.i(bundle, facebookException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(w wVar, Bundle bundle, FacebookException facebookException) {
        kotlin.jvm.internal.m.f(wVar, "this$0");
        wVar.j(bundle);
    }

    private final void i(Bundle values, FacebookException error) {
        androidx.fragment.app.d activity = getActivity();
        if (activity == null) {
            return;
        }
        k0 k0Var = k0.a;
        Intent intent = activity.getIntent();
        kotlin.jvm.internal.m.e(intent, "fragmentActivity.intent");
        activity.setResult(error == null ? -1 : 0, k0.l(intent, values, error));
        activity.finish();
    }

    private final void j(Bundle values) {
        androidx.fragment.app.d activity = getActivity();
        if (activity == null) {
            return;
        }
        Intent intent = new Intent();
        if (values == null) {
            values = new Bundle();
        }
        intent.putExtras(values);
        activity.setResult(-1, intent);
        activity.finish();
    }

    public final void d() {
        androidx.fragment.app.d activity;
        r0 a;
        if (this.innerDialog == null && (activity = getActivity()) != null) {
            Intent intent = activity.getIntent();
            k0 k0Var = k0.a;
            kotlin.jvm.internal.m.e(intent, "intent");
            Bundle t = k0.t(intent);
            if (!(t == null ? false : t.getBoolean("is_fallback", false))) {
                String string = t == null ? null : t.getString("action");
                Bundle bundle = t != null ? t.getBundle("params") : null;
                p0 p0Var = p0.a;
                if (p0.a0(string)) {
                    p0.j0("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                } else if (string != null) {
                    a = new r0.a(activity, string, bundle).h(new r0.e() { // from class: com.facebook.internal.a
                        @Override // com.facebook.internal.r0.e
                        public final void a(Bundle bundle2, FacebookException facebookException) {
                            w.e(w.this, bundle2, facebookException);
                        }
                    }).a();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                String string2 = t != null ? t.getString("url") : null;
                p0 p0Var2 = p0.a;
                if (p0.a0(string2)) {
                    p0.j0("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.a;
                com.facebook.a0 a0Var = com.facebook.a0.a;
                String format = String.format("fb%s://bridge/", Arrays.copyOf(new Object[]{com.facebook.a0.d()}, 1));
                kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
                z.a aVar = z.v;
                if (string2 != null) {
                    a = aVar.a(activity, string2, format);
                    a.B(new r0.e() { // from class: com.facebook.internal.b
                        @Override // com.facebook.internal.r0.e
                        public final void a(Bundle bundle2, FacebookException facebookException) {
                            w.f(w.this, bundle2, facebookException);
                        }
                    });
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
            this.innerDialog = a;
        }
    }

    public final void k(Dialog dialog) {
        this.innerDialog = dialog;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.m.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if ((this.innerDialog instanceof r0) && isResumed()) {
            Dialog dialog = this.innerDialog;
            if (dialog == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
            }
            ((r0) dialog).x();
        }
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        d();
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = this.innerDialog;
        if (dialog != null) {
            if (dialog != null) {
                return dialog;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Dialog");
        }
        i(null, null);
        setShowsDialog(false);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        kotlin.jvm.internal.m.e(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = this.innerDialog;
        if (dialog instanceof r0) {
            if (dialog == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.WebDialog");
            }
            ((r0) dialog).x();
        }
    }
}
