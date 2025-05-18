package com.facebook.login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.account.AndroidAccountManagerPersistence;
import com.facebook.AccessToken;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.d0;
import com.facebook.e0;
import com.facebook.internal.o0;
import com.facebook.internal.p0;
import com.facebook.login.LoginClient;
import com.facebook.o0.g0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.q0;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DeviceAuthDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 D2\u00020\u0001:\u0003jklB\u0007¢\u0006\u0004\bi\u0010\u0017J-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u001dH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010#\u001a\u00020\"H\u0015¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)H\u0014¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0010H\u0014¢\u0006\u0004\b-\u0010\u0017J\u000f\u0010.\u001a\u00020\"H\u0014¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00102\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0010H\u0002¢\u0006\u0004\b4\u0010\u0017J\u000f\u00105\u001a\u00020\u0010H\u0002¢\u0006\u0004\b5\u0010\u0017JC\u0010>\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u001d2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\u001d2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010=\u001a\u0004\u0018\u00010;H\u0002¢\u0006\u0004\b>\u0010?J)\u0010B\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u001d2\u0006\u0010A\u001a\u00020@2\b\u0010=\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0004\bB\u0010CJ;\u0010D\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u001d2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u001d2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010=\u001a\u0004\u0018\u00010;H\u0002¢\u0006\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bG\u0010HR\u001c\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010O\u001a\u00020F8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bN\u0010HR\u0016\u0010S\u001a\u00020P8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Z\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010aR\u0016\u0010b\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010YR\u0016\u0010d\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010g¨\u0006m"}, d2 = {"Lcom/facebook/login/DeviceAuthDialog;", "Landroidx/fragment/app/c;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "dialog", "Lkotlin/u;", "onDismiss", "(Landroid/content/DialogInterface;)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "onDestroyView", "()V", "Lcom/facebook/login/LoginClient$Request;", "request", "E", "(Lcom/facebook/login/LoginClient$Request;)V", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "e", "()Ljava/util/Map;", "g", "()Ljava/lang/String;", HttpUrl.FRAGMENT_ENCODE_SET, "isSmartLogin", "j", "(Z)Landroid/view/View;", HttpUrl.FRAGMENT_ENCODE_SET, "h", "(Z)I", "Lcom/facebook/FacebookException;", "ex", "u", "(Lcom/facebook/FacebookException;)V", "t", "s", "()Z", "Lcom/facebook/login/DeviceAuthDialog$RequestState;", "currentRequestState", "D", "(Lcom/facebook/login/DeviceAuthDialog$RequestState;)V", "x", "B", AndroidAccountManagerPersistence.ACCOUNT_ID, "Lcom/facebook/login/DeviceAuthDialog$b;", "permissions", "accessToken", "name", "Ljava/util/Date;", "expirationTime", "dataAccessExpirationTime", "y", "(Ljava/lang/String;Lcom/facebook/login/DeviceAuthDialog$b;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V", HttpUrl.FRAGMENT_ENCODE_SET, "expiresIn", "v", "(Ljava/lang/String;JLjava/lang/Long;)V", "f", "(Ljava/lang/String;Lcom/facebook/login/DeviceAuthDialog$b;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V", "Landroid/widget/TextView;", "k", "Landroid/widget/TextView;", "confirmationCode", "Ljava/util/concurrent/ScheduledFuture;", "p", "Ljava/util/concurrent/ScheduledFuture;", "scheduledPoll", "l", "instructions", "Lcom/facebook/GraphRequest;", "i", "()Lcom/facebook/GraphRequest;", "pollRequest", "Lcom/facebook/b0;", "o", "Lcom/facebook/b0;", "currentGraphRequestPoll", "r", "Z", "isBeingDestroyed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "n", "Ljava/util/concurrent/atomic/AtomicBoolean;", "completed", "q", "Lcom/facebook/login/DeviceAuthDialog$RequestState;", "Lcom/facebook/login/LoginClient$Request;", "isRetry", "Landroid/view/View;", "progressBar", "Lcom/facebook/login/DeviceAuthMethodHandler;", "m", "Lcom/facebook/login/DeviceAuthMethodHandler;", "deviceAuthMethodHandler", "<init>", "a", "b", "RequestState", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class DeviceAuthDialog extends androidx.fragment.app.c {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    private static final String f9934g = "device/login";

    /* renamed from: h, reason: collision with root package name */
    private static final String f9935h = "device/login_status";

    /* renamed from: i, reason: collision with root package name */
    private static final int f9936i = 1349174;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private View progressBar;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private TextView confirmationCode;

    /* renamed from: l, reason: from kotlin metadata */
    private TextView instructions;

    /* renamed from: m, reason: from kotlin metadata */
    private DeviceAuthMethodHandler deviceAuthMethodHandler;

    /* renamed from: n, reason: from kotlin metadata */
    private final AtomicBoolean completed = new AtomicBoolean();

    /* renamed from: o, reason: from kotlin metadata */
    private volatile com.facebook.b0 currentGraphRequestPoll;

    /* renamed from: p, reason: from kotlin metadata */
    private volatile ScheduledFuture<?> scheduledPoll;

    /* renamed from: q, reason: from kotlin metadata */
    private volatile RequestState currentRequestState;

    /* renamed from: r, reason: from kotlin metadata */
    private boolean isBeingDestroyed;

    /* renamed from: s, reason: from kotlin metadata */
    private boolean isRetry;

    /* renamed from: t, reason: from kotlin metadata */
    private LoginClient.Request request;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeviceAuthDialog.kt */
    /* loaded from: classes2.dex */
    public static final class RequestState implements Parcelable {

        /* renamed from: g, reason: collision with root package name */
        private String f9940g;

        /* renamed from: h, reason: collision with root package name */
        private String f9941h;

        /* renamed from: i, reason: collision with root package name */
        private String f9942i;

        /* renamed from: j, reason: collision with root package name */
        private long f9943j;

        /* renamed from: k, reason: collision with root package name */
        private long f9944k;

        /* renamed from: f, reason: collision with root package name */
        public static final b f9939f = new b(null);
        public static final Parcelable.Creator<RequestState> CREATOR = new a();

        /* compiled from: DeviceAuthDialog.kt */
        /* loaded from: classes2.dex */
        public static final class a implements Parcelable.Creator<RequestState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public RequestState createFromParcel(Parcel parcel) {
                kotlin.jvm.internal.m.f(parcel, "parcel");
                return new RequestState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public RequestState[] newArray(int i2) {
                return new RequestState[i2];
            }
        }

        /* compiled from: DeviceAuthDialog.kt */
        /* loaded from: classes2.dex */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public RequestState() {
        }

        public final String a() {
            return this.f9940g;
        }

        public final long b() {
            return this.f9943j;
        }

        public final String c() {
            return this.f9942i;
        }

        public final String d() {
            return this.f9941h;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final void e(long j2) {
            this.f9943j = j2;
        }

        public final void f(long j2) {
            this.f9944k = j2;
        }

        public final void g(String str) {
            this.f9942i = str;
        }

        public final void h(String str) {
            this.f9941h = str;
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            String format = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", Arrays.copyOf(new Object[]{str}, 1));
            kotlin.jvm.internal.m.e(format, "java.lang.String.format(locale, format, *args)");
            this.f9940g = format;
        }

        public final boolean i() {
            return this.f9944k != 0 && (new Date().getTime() - this.f9944k) - (this.f9943j * 1000) < 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            kotlin.jvm.internal.m.f(parcel, "dest");
            parcel.writeString(this.f9940g);
            parcel.writeString(this.f9941h);
            parcel.writeString(this.f9942i);
            parcel.writeLong(this.f9943j);
            parcel.writeLong(this.f9944k);
        }

        protected RequestState(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "parcel");
            this.f9940g = parcel.readString();
            this.f9941h = parcel.readString();
            this.f9942i = parcel.readString();
            this.f9943j = parcel.readLong();
            this.f9944k = parcel.readLong();
        }
    }

    /* compiled from: DeviceAuthDialog.kt */
    /* renamed from: com.facebook.login.DeviceAuthDialog$a, reason: from kotlin metadata */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final b b(JSONObject jSONObject) throws JSONException {
            String optString;
            JSONArray jSONArray = jSONObject.getJSONObject("permissions").getJSONArray("data");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int length = jSONArray.length();
            if (length > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    String optString2 = optJSONObject.optString("permission");
                    kotlin.jvm.internal.m.e(optString2, "permission");
                    if (!(optString2.length() == 0) && !kotlin.jvm.internal.m.a(optString2, "installed") && (optString = optJSONObject.optString("status")) != null) {
                        int hashCode = optString.hashCode();
                        if (hashCode != -1309235419) {
                            if (hashCode != 280295099) {
                                if (hashCode == 568196142 && optString.equals("declined")) {
                                    arrayList2.add(optString2);
                                }
                            } else if (optString.equals("granted")) {
                                arrayList.add(optString2);
                            }
                        } else if (optString.equals("expired")) {
                            arrayList3.add(optString2);
                        }
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return new b(arrayList, arrayList2, arrayList3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeviceAuthDialog.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private List<String> a;

        /* renamed from: b, reason: collision with root package name */
        private List<String> f9945b;

        /* renamed from: c, reason: collision with root package name */
        private List<String> f9946c;

        public b(List<String> list, List<String> list2, List<String> list3) {
            kotlin.jvm.internal.m.f(list, "grantedPermissions");
            kotlin.jvm.internal.m.f(list2, "declinedPermissions");
            kotlin.jvm.internal.m.f(list3, "expiredPermissions");
            this.a = list;
            this.f9945b = list2;
            this.f9946c = list3;
        }

        public final List<String> a() {
            return this.f9945b;
        }

        public final List<String> b() {
            return this.f9946c;
        }

        public final List<String> c() {
            return this.a;
        }
    }

    /* compiled from: DeviceAuthDialog.kt */
    /* loaded from: classes2.dex */
    public static final class c extends Dialog {
        c(androidx.fragment.app.d dVar, int i2) {
            super(dVar, i2);
        }

        @Override // android.app.Dialog
        public void onBackPressed() {
            if (DeviceAuthDialog.this.s()) {
                super.onBackPressed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(DeviceAuthDialog deviceAuthDialog, DialogInterface dialogInterface, int i2) {
        kotlin.jvm.internal.m.f(deviceAuthDialog, "this$0");
        View j2 = deviceAuthDialog.j(false);
        Dialog dialog = deviceAuthDialog.getDialog();
        if (dialog != null) {
            dialog.setContentView(j2);
        }
        LoginClient.Request request = deviceAuthDialog.request;
        if (request == null) {
            return;
        }
        deviceAuthDialog.E(request);
    }

    private final void B() {
        RequestState requestState = this.currentRequestState;
        Long valueOf = requestState == null ? null : Long.valueOf(requestState.b());
        if (valueOf != null) {
            this.scheduledPoll = DeviceAuthMethodHandler.f9948i.a().schedule(new Runnable() { // from class: com.facebook.login.h
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceAuthDialog.C(DeviceAuthDialog.this);
                }
            }, valueOf.longValue(), TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(DeviceAuthDialog deviceAuthDialog) {
        kotlin.jvm.internal.m.f(deviceAuthDialog, "this$0");
        deviceAuthDialog.x();
    }

    private final void D(RequestState currentRequestState) {
        this.currentRequestState = currentRequestState;
        TextView textView = this.confirmationCode;
        if (textView != null) {
            textView.setText(currentRequestState.d());
            com.facebook.p0.a.a aVar = com.facebook.p0.a.a.a;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), com.facebook.p0.a.a.c(currentRequestState.a()));
            TextView textView2 = this.instructions;
            if (textView2 != null) {
                textView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, bitmapDrawable, (Drawable) null, (Drawable) null);
                TextView textView3 = this.confirmationCode;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                    View view = this.progressBar;
                    if (view != null) {
                        view.setVisibility(8);
                        if (!this.isRetry && com.facebook.p0.a.a.f(currentRequestState.d())) {
                            new g0(getContext()).f("fb_smart_login_service");
                        }
                        if (currentRequestState.i()) {
                            B();
                            return;
                        } else {
                            x();
                            return;
                        }
                    }
                    kotlin.jvm.internal.m.w("progressBar");
                    throw null;
                }
                kotlin.jvm.internal.m.w("confirmationCode");
                throw null;
            }
            kotlin.jvm.internal.m.w("instructions");
            throw null;
        }
        kotlin.jvm.internal.m.w("confirmationCode");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(DeviceAuthDialog deviceAuthDialog, d0 d0Var) {
        kotlin.jvm.internal.m.f(deviceAuthDialog, "this$0");
        kotlin.jvm.internal.m.f(d0Var, "response");
        if (deviceAuthDialog.isBeingDestroyed) {
            return;
        }
        if (d0Var.b() != null) {
            FacebookRequestError b2 = d0Var.b();
            FacebookException e2 = b2 == null ? null : b2.e();
            if (e2 == null) {
                e2 = new FacebookException();
            }
            deviceAuthDialog.u(e2);
            return;
        }
        JSONObject c2 = d0Var.c();
        if (c2 == null) {
            c2 = new JSONObject();
        }
        RequestState requestState = new RequestState();
        try {
            requestState.h(c2.getString("user_code"));
            requestState.g(c2.getString("code"));
            requestState.e(c2.getLong("interval"));
            deviceAuthDialog.D(requestState);
        } catch (JSONException e3) {
            deviceAuthDialog.u(new FacebookException(e3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DeviceAuthDialog deviceAuthDialog, d0 d0Var) {
        kotlin.jvm.internal.m.f(deviceAuthDialog, "this$0");
        kotlin.jvm.internal.m.f(d0Var, "response");
        if (deviceAuthDialog.completed.get()) {
            return;
        }
        FacebookRequestError b2 = d0Var.b();
        if (b2 != null) {
            int g2 = b2.g();
            boolean z = true;
            if (g2 != f9936i && g2 != 1349172) {
                z = false;
            }
            if (z) {
                deviceAuthDialog.B();
                return;
            }
            if (g2 != 1349152) {
                if (g2 == 1349173) {
                    deviceAuthDialog.t();
                    return;
                }
                FacebookRequestError b3 = d0Var.b();
                FacebookException e2 = b3 == null ? null : b3.e();
                if (e2 == null) {
                    e2 = new FacebookException();
                }
                deviceAuthDialog.u(e2);
                return;
            }
            RequestState requestState = deviceAuthDialog.currentRequestState;
            if (requestState != null) {
                com.facebook.p0.a.a aVar = com.facebook.p0.a.a.a;
                com.facebook.p0.a.a.a(requestState.d());
            }
            LoginClient.Request request = deviceAuthDialog.request;
            if (request != null) {
                deviceAuthDialog.E(request);
                return;
            } else {
                deviceAuthDialog.t();
                return;
            }
        }
        try {
            JSONObject c2 = d0Var.c();
            if (c2 == null) {
                c2 = new JSONObject();
            }
            String string = c2.getString("access_token");
            kotlin.jvm.internal.m.e(string, "resultObject.getString(\"access_token\")");
            deviceAuthDialog.v(string, c2.getLong("expires_in"), Long.valueOf(c2.optLong("data_access_expiration_time")));
        } catch (JSONException e3) {
            deviceAuthDialog.u(new FacebookException(e3));
        }
    }

    private final void f(String userId, b permissions, String accessToken, Date expirationTime, Date dataAccessExpirationTime) {
        DeviceAuthMethodHandler deviceAuthMethodHandler = this.deviceAuthMethodHandler;
        if (deviceAuthMethodHandler != null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            deviceAuthMethodHandler.u(accessToken, com.facebook.a0.d(), userId, permissions.c(), permissions.a(), permissions.b(), com.facebook.w.DEVICE_AUTH, expirationTime, null, dataAccessExpirationTime);
        }
        Dialog dialog = getDialog();
        if (dialog == null) {
            return;
        }
        dialog.dismiss();
    }

    private final GraphRequest i() {
        Bundle bundle = new Bundle();
        RequestState requestState = this.currentRequestState;
        bundle.putString("code", requestState == null ? null : requestState.c());
        bundle.putString("access_token", g());
        return GraphRequest.a.B(null, f9935h, bundle, new GraphRequest.b() { // from class: com.facebook.login.d
            @Override // com.facebook.GraphRequest.b
            public final void b(d0 d0Var) {
                DeviceAuthDialog.d(DeviceAuthDialog.this, d0Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DeviceAuthDialog deviceAuthDialog, View view) {
        kotlin.jvm.internal.m.f(deviceAuthDialog, "this$0");
        deviceAuthDialog.t();
    }

    private final void v(final String accessToken, long expiresIn, Long dataAccessExpirationTime) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        final Date date = null;
        final Date date2 = expiresIn != 0 ? new Date(new Date().getTime() + (expiresIn * 1000)) : null;
        if ((dataAccessExpirationTime == null || dataAccessExpirationTime.longValue() != 0) && dataAccessExpirationTime != null) {
            date = new Date(dataAccessExpirationTime.longValue() * 1000);
        }
        com.facebook.a0 a0Var = com.facebook.a0.a;
        GraphRequest x = GraphRequest.a.x(new AccessToken(accessToken, com.facebook.a0.d(), "0", null, null, null, null, date2, null, date, null, 1024, null), "me", new GraphRequest.b() { // from class: com.facebook.login.b
            @Override // com.facebook.GraphRequest.b
            public final void b(d0 d0Var) {
                DeviceAuthDialog.w(DeviceAuthDialog.this, accessToken, date2, date, d0Var);
            }
        });
        x.G(e0.GET);
        x.H(bundle);
        x.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(DeviceAuthDialog deviceAuthDialog, String str, Date date, Date date2, d0 d0Var) {
        EnumSet<o0> l;
        kotlin.jvm.internal.m.f(deviceAuthDialog, "this$0");
        kotlin.jvm.internal.m.f(str, "$accessToken");
        kotlin.jvm.internal.m.f(d0Var, "response");
        if (deviceAuthDialog.completed.get()) {
            return;
        }
        FacebookRequestError b2 = d0Var.b();
        if (b2 != null) {
            FacebookException e2 = b2.e();
            if (e2 == null) {
                e2 = new FacebookException();
            }
            deviceAuthDialog.u(e2);
            return;
        }
        try {
            JSONObject c2 = d0Var.c();
            if (c2 == null) {
                c2 = new JSONObject();
            }
            String string = c2.getString(DeepLinkIntentReceiver.DeepLinksKeys.ID);
            kotlin.jvm.internal.m.e(string, "jsonObject.getString(\"id\")");
            b b3 = INSTANCE.b(c2);
            String string2 = c2.getString("name");
            kotlin.jvm.internal.m.e(string2, "jsonObject.getString(\"name\")");
            RequestState requestState = deviceAuthDialog.currentRequestState;
            if (requestState != null) {
                com.facebook.p0.a.a aVar = com.facebook.p0.a.a.a;
                com.facebook.p0.a.a.a(requestState.d());
            }
            com.facebook.internal.d0 d0Var2 = com.facebook.internal.d0.a;
            com.facebook.a0 a0Var = com.facebook.a0.a;
            com.facebook.internal.c0 c3 = com.facebook.internal.d0.c(com.facebook.a0.d());
            Boolean bool = null;
            if (c3 != null && (l = c3.l()) != null) {
                bool = Boolean.valueOf(l.contains(o0.RequireConfirm));
            }
            if (kotlin.jvm.internal.m.a(bool, Boolean.TRUE) && !deviceAuthDialog.isRetry) {
                deviceAuthDialog.isRetry = true;
                deviceAuthDialog.y(string, b3, str, string2, date, date2);
            } else {
                deviceAuthDialog.f(string, b3, str, date, date2);
            }
        } catch (JSONException e3) {
            deviceAuthDialog.u(new FacebookException(e3));
        }
    }

    private final void x() {
        RequestState requestState = this.currentRequestState;
        if (requestState != null) {
            requestState.f(new Date().getTime());
        }
        this.currentGraphRequestPoll = i().k();
    }

    private final void y(final String userId, final b permissions, final String accessToken, String name, final Date expirationTime, final Date dataAccessExpirationTime) {
        String string = getResources().getString(com.facebook.common.d.f9686g);
        kotlin.jvm.internal.m.e(string, "resources.getString(R.string.com_facebook_smart_login_confirmation_title)");
        String string2 = getResources().getString(com.facebook.common.d.f9685f);
        kotlin.jvm.internal.m.e(string2, "resources.getString(R.string.com_facebook_smart_login_confirmation_continue_as)");
        String string3 = getResources().getString(com.facebook.common.d.f9684e);
        kotlin.jvm.internal.m.e(string3, "resources.getString(R.string.com_facebook_smart_login_confirmation_cancel)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format(string2, Arrays.copyOf(new Object[]{name}, 1));
        kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new DialogInterface.OnClickListener() { // from class: com.facebook.login.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                DeviceAuthDialog.z(DeviceAuthDialog.this, userId, permissions, accessToken, expirationTime, dataAccessExpirationTime, dialogInterface, i2);
            }
        }).setPositiveButton(string3, new DialogInterface.OnClickListener() { // from class: com.facebook.login.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                DeviceAuthDialog.A(DeviceAuthDialog.this, dialogInterface, i2);
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(DeviceAuthDialog deviceAuthDialog, String str, b bVar, String str2, Date date, Date date2, DialogInterface dialogInterface, int i2) {
        kotlin.jvm.internal.m.f(deviceAuthDialog, "this$0");
        kotlin.jvm.internal.m.f(str, "$userId");
        kotlin.jvm.internal.m.f(bVar, "$permissions");
        kotlin.jvm.internal.m.f(str2, "$accessToken");
        deviceAuthDialog.f(str, bVar, str2, date, date2);
    }

    public void E(LoginClient.Request request) {
        kotlin.jvm.internal.m.f(request, "request");
        this.request = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.n()));
        p0 p0Var = p0.a;
        p0.q0(bundle, "redirect_uri", request.i());
        p0.q0(bundle, "target_user_id", request.h());
        bundle.putString("access_token", g());
        com.facebook.p0.a.a aVar = com.facebook.p0.a.a.a;
        Map<String, String> e2 = e();
        bundle.putString("device_info", com.facebook.p0.a.a.d(e2 == null ? null : q0.u(e2)));
        GraphRequest.a.B(null, f9934g, bundle, new GraphRequest.b() { // from class: com.facebook.login.c
            @Override // com.facebook.GraphRequest.b
            public final void b(d0 d0Var) {
                DeviceAuthDialog.F(DeviceAuthDialog.this, d0Var);
            }
        }).k();
    }

    public Map<String, String> e() {
        return null;
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        com.facebook.internal.q0 q0Var = com.facebook.internal.q0.a;
        sb.append(com.facebook.internal.q0.b());
        sb.append('|');
        sb.append(com.facebook.internal.q0.c());
        return sb.toString();
    }

    protected int h(boolean isSmartLogin) {
        if (isSmartLogin) {
            return com.facebook.common.c.f9680d;
        }
        return com.facebook.common.c.f9678b;
    }

    protected View j(boolean isSmartLogin) {
        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();
        kotlin.jvm.internal.m.e(layoutInflater, "requireActivity().layoutInflater");
        View inflate = layoutInflater.inflate(h(isSmartLogin), (ViewGroup) null);
        kotlin.jvm.internal.m.e(inflate, "inflater.inflate(getLayoutResId(isSmartLogin), null)");
        View findViewById = inflate.findViewById(com.facebook.common.b.f9677f);
        kotlin.jvm.internal.m.e(findViewById, "view.findViewById(R.id.progress_bar)");
        this.progressBar = findViewById;
        View findViewById2 = inflate.findViewById(com.facebook.common.b.f9676e);
        if (findViewById2 != null) {
            this.confirmationCode = (TextView) findViewById2;
            View findViewById3 = inflate.findViewById(com.facebook.common.b.a);
            if (findViewById3 != null) {
                ((Button) findViewById3).setOnClickListener(new View.OnClickListener() { // from class: com.facebook.login.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DeviceAuthDialog.k(DeviceAuthDialog.this, view);
                    }
                });
                View findViewById4 = inflate.findViewById(com.facebook.common.b.f9673b);
                if (findViewById4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                }
                TextView textView = (TextView) findViewById4;
                this.instructions = textView;
                if (textView != null) {
                    textView.setText(Html.fromHtml(getString(com.facebook.common.d.a)));
                    return inflate;
                }
                kotlin.jvm.internal.m.w("instructions");
                throw null;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Button");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        c cVar = new c(requireActivity(), com.facebook.common.e.f9687b);
        com.facebook.p0.a.a aVar = com.facebook.p0.a.a.a;
        cVar.setContentView(j(com.facebook.p0.a.a.e() && !this.isRetry));
        return cVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RequestState requestState;
        LoginClient i2;
        kotlin.jvm.internal.m.f(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        v vVar = (v) ((FacebookActivity) requireActivity()).getCurrentFragment();
        LoginMethodHandler loginMethodHandler = null;
        if (vVar != null && (i2 = vVar.i()) != null) {
            loginMethodHandler = i2.j();
        }
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) loginMethodHandler;
        if (savedInstanceState != null && (requestState = (RequestState) savedInstanceState.getParcelable("request_state")) != null) {
            D(requestState);
        }
        return onCreateView;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroyView();
        com.facebook.b0 b0Var = this.currentGraphRequestPoll;
        if (b0Var != null) {
            b0Var.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture = this.scheduledPoll;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(true);
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        kotlin.jvm.internal.m.f(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.isBeingDestroyed) {
            return;
        }
        t();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.m.f(outState, "outState");
        super.onSaveInstanceState(outState);
        if (this.currentRequestState != null) {
            outState.putParcelable("request_state", this.currentRequestState);
        }
    }

    protected boolean s() {
        return true;
    }

    protected void t() {
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                com.facebook.p0.a.a aVar = com.facebook.p0.a.a.a;
                com.facebook.p0.a.a.a(requestState.d());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler != null) {
                deviceAuthMethodHandler.s();
            }
            Dialog dialog = getDialog();
            if (dialog == null) {
                return;
            }
            dialog.dismiss();
        }
    }

    protected void u(FacebookException ex) {
        kotlin.jvm.internal.m.f(ex, "ex");
        if (this.completed.compareAndSet(false, true)) {
            RequestState requestState = this.currentRequestState;
            if (requestState != null) {
                com.facebook.p0.a.a aVar = com.facebook.p0.a.a.a;
                com.facebook.p0.a.a.a(requestState.d());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler != null) {
                deviceAuthMethodHandler.t(ex);
            }
            Dialog dialog = getDialog();
            if (dialog == null) {
                return;
            }
            dialog.dismiss();
        }
    }
}
