package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class s5 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f13308f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f13309g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ boolean f13310h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ boolean f13311i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s5(zzayi zzayiVar, Context context, String str, boolean z, boolean z2) {
        this.f13308f = context;
        this.f13309g = str;
        this.f13310h = z;
        this.f13311i = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f13308f);
        builder.setMessage(this.f13309g);
        if (this.f13310h) {
            builder.setTitle("Error");
        } else {
            builder.setTitle("Info");
        }
        if (this.f13311i) {
            builder.setNeutralButton("Dismiss", (DialogInterface.OnClickListener) null);
        } else {
            builder.setPositiveButton("Learn More", new t5(this));
            builder.setNegativeButton("Dismiss", (DialogInterface.OnClickListener) null);
        }
        builder.create().show();
    }
}
