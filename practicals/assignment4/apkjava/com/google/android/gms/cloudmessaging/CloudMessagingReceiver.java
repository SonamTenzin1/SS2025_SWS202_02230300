package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import cm.aptoide.pt.FirebaseConstants;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.cloudmessaging.zzf;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public abstract class CloudMessagingReceiver extends BroadcastReceiver {
    private final ExecutorService a = com.google.android.gms.internal.cloudmessaging.zza.a().b(new NamedThreadFactory("firebase-iid-executor"), zzf.a);

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    /* loaded from: classes2.dex */
    public static final class IntentActionKeys {
        private IntentActionKeys() {
        }
    }

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    /* loaded from: classes2.dex */
    public static final class IntentKeys {
        private IntentKeys() {
        }
    }

    private final int e(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            d(context, extras);
            return -1;
        }
        if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            c(context, extras);
            return -1;
        }
        Log.e("CloudMessagingReceiver", "Unknown notification action");
        return 500;
    }

    private final int g(Context context, Intent intent) {
        Task<Void> d2;
        if (intent.getExtras() == null) {
            return 500;
        }
        String stringExtra = intent.getStringExtra(FirebaseConstants.FIREBASE_MESSAGE_ID);
        if (TextUtils.isEmpty(stringExtra)) {
            d2 = Tasks.e(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(FirebaseConstants.FIREBASE_MESSAGE_ID, stringExtra);
            d2 = zze.c(context).d(2, bundle);
        }
        int b2 = b(context, new CloudMessage(intent));
        try {
            Tasks.b(d2, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 20);
            sb.append("Message ack failed: ");
            sb.append(valueOf);
            Log.w("CloudMessagingReceiver", sb.toString());
        }
        return b2;
    }

    protected Executor a() {
        return this.a;
    }

    protected abstract int b(Context context, CloudMessage cloudMessage);

    protected void c(Context context, Bundle bundle) {
    }

    protected void d(Context context, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void f(Intent intent, Context context, boolean z, BroadcastReceiver.PendingResult pendingResult) {
        int g2;
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                g2 = e(context, intent2);
            } else {
                g2 = g(context, intent);
            }
            if (z) {
                pendingResult.setResultCode(g2);
            }
        } finally {
            pendingResult.finish();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (intent == null) {
            return;
        }
        final boolean isOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult goAsync = goAsync();
        a().execute(new Runnable(this, intent, context, isOrderedBroadcast, goAsync) { // from class: com.google.android.gms.cloudmessaging.b

            /* renamed from: f, reason: collision with root package name */
            private final CloudMessagingReceiver f11580f;

            /* renamed from: g, reason: collision with root package name */
            private final Intent f11581g;

            /* renamed from: h, reason: collision with root package name */
            private final Context f11582h;

            /* renamed from: i, reason: collision with root package name */
            private final boolean f11583i;

            /* renamed from: j, reason: collision with root package name */
            private final BroadcastReceiver.PendingResult f11584j;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11580f = this;
                this.f11581g = intent;
                this.f11582h = context;
                this.f11583i = isOrderedBroadcast;
                this.f11584j = goAsync;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f11580f.f(this.f11581g, this.f11582h, this.f11583i, this.f11584j);
            }
        });
    }
}
