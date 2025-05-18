package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

@zzard
/* loaded from: classes2.dex */
public final class zzbfl {
    private long a;

    public final long a(ByteBuffer byteBuffer) {
        zzbg zzbgVar;
        zzbf zzbfVar;
        long j2 = this.a;
        if (j2 > 0) {
            return j2;
        }
        try {
            ByteBuffer duplicate = byteBuffer.duplicate();
            duplicate.flip();
            Iterator<zzbd> it = new zzbb(new w9(duplicate), x9.f13566c).e().iterator();
            while (true) {
                zzbgVar = null;
                if (!it.hasNext()) {
                    zzbfVar = null;
                    break;
                }
                zzbd next = it.next();
                if (next instanceof zzbf) {
                    zzbfVar = (zzbf) next;
                    break;
                }
            }
            Iterator<zzbd> it2 = zzbfVar.e().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                zzbd next2 = it2.next();
                if (next2 instanceof zzbg) {
                    zzbgVar = (zzbg) next2;
                    break;
                }
            }
            long h2 = (zzbgVar.h() * 1000) / zzbgVar.i();
            this.a = h2;
            return h2;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
