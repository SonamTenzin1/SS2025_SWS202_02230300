package com.google.android.gms.tasks;

import com.google.android.gms.internal.tasks.zza;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes2.dex */
public final /* synthetic */ class zzy implements OnCompleteListener {
    public final /* synthetic */ zza a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f18356b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f18357c;

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void a(Task task) {
        zza zzaVar = this.a;
        TaskCompletionSource taskCompletionSource = this.f18356b;
        d dVar = this.f18357c;
        zzaVar.removeCallbacksAndMessages(null);
        if (task.n()) {
            taskCompletionSource.e(task.j());
        } else {
            if (task.l()) {
                dVar.a();
                return;
            }
            Exception i2 = task.i();
            i2.getClass();
            taskCompletionSource.d(i2);
        }
    }
}
