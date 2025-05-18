package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcvb<T> {
    private final Set<zzcva<? extends zzcuz<T>>> a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f15663b;

    public zzcvb(Executor executor, Set<zzcva<? extends zzcuz<T>>> set) {
        this.f15663b = executor;
        this.a = set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ Object a(List list, Object obj) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                zzcuz zzcuzVar = (zzcuz) ((zzbbh) it.next()).get();
                if (zzcuzVar != null) {
                    zzcuzVar.a(obj);
                }
            } catch (InterruptedException | ExecutionException e2) {
                zzbad.c("Derive quality signals error.", e2);
                throw new Exception(e2);
            }
        }
        return obj;
    }

    public final zzbbh<T> b(final T t) {
        final ArrayList arrayList = new ArrayList(this.a.size());
        for (final zzcva<? extends zzcuz<T>> zzcvaVar : this.a) {
            zzbbh<? extends zzcuz<T>> b2 = zzcvaVar.b();
            if (((Boolean) zzyt.e().c(zzacu.N1)).booleanValue()) {
                final long b3 = zzk.zzln().b();
                b2.k(new Runnable(zzcvaVar, b3) { // from class: com.google.android.gms.internal.ads.ap

                    /* renamed from: f, reason: collision with root package name */
                    private final zzcva f12264f;

                    /* renamed from: g, reason: collision with root package name */
                    private final long f12265g;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f12264f = zzcvaVar;
                        this.f12265g = b3;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcva zzcvaVar2 = this.f12264f;
                        long j2 = this.f12265g;
                        String canonicalName = zzcvaVar2.getClass().getCanonicalName();
                        long b4 = zzk.zzln().b() - j2;
                        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
                        sb.append("Signal runtime : ");
                        sb.append(canonicalName);
                        sb.append(" = ");
                        sb.append(b4);
                        zzawz.m(sb.toString());
                    }
                }, zzbbm.f14331b);
            }
            arrayList.add(b2);
        }
        return zzbar.n(arrayList).a(new Callable(arrayList, t) { // from class: com.google.android.gms.internal.ads.bp

            /* renamed from: f, reason: collision with root package name */
            private final List f12357f;

            /* renamed from: g, reason: collision with root package name */
            private final Object f12358g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12357f = arrayList;
                this.f12358g = t;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzcvb.a(this.f12357f, this.f12358g);
            }
        }, this.f15663b);
    }
}
