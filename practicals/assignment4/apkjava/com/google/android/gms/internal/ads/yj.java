package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes2.dex */
final class yj implements zzban<SQLiteDatabase> {
    private final /* synthetic */ zzczc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public yj(zzcjc zzcjcVar, zzczc zzczcVar) {
        this.a = zzczcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        String valueOf = String.valueOf(th.getMessage());
        zzbad.g(valueOf.length() != 0 ? "Failed to get offline signal database: ".concat(valueOf) : new String("Failed to get offline signal database: "));
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.a.a(sQLiteDatabase);
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            zzbad.g(valueOf.length() != 0 ? "Error executing function on offline signal database: ".concat(valueOf) : new String("Error executing function on offline signal database: "));
        }
    }
}
