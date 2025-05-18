package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
abstract class m<T> {
    final int a;

    /* renamed from: b, reason: collision with root package name */
    final TaskCompletionSource<T> f11600b = new TaskCompletionSource<>();

    /* renamed from: c, reason: collision with root package name */
    final int f11601c;

    /* renamed from: d, reason: collision with root package name */
    final Bundle f11602d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(int i2, int i3, Bundle bundle) {
        this.a = i2;
        this.f11601c = i3;
        this.f11602d = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Bundle bundle);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzp zzpVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzpVar);
            StringBuilder sb = new StringBuilder(valueOf.length() + 14 + valueOf2.length());
            sb.append("Failing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f11600b.b(zzpVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            StringBuilder sb = new StringBuilder(valueOf.length() + 16 + valueOf2.length());
            sb.append("Finishing ");
            sb.append(valueOf);
            sb.append(" with ");
            sb.append(valueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.f11600b.c(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean d();

    public String toString() {
        int i2 = this.f11601c;
        int i3 = this.a;
        boolean d2 = d();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i2);
        sb.append(" id=");
        sb.append(i3);
        sb.append(" oneWay=");
        sb.append(d2);
        sb.append("}");
        return sb.toString();
    }
}
