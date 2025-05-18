package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.PriorityQueue;
import okhttp3.HttpUrl;

@zzard
/* loaded from: classes2.dex */
public final class zzvh {
    @VisibleForTesting
    private static long a(long j2, int i2) {
        if (i2 == 0) {
            return 1L;
        }
        if (i2 == 1) {
            return j2;
        }
        if (i2 % 2 == 0) {
            return a((j2 * j2) % 1073807359, i2 / 2) % 1073807359;
        }
        return (j2 * (a((j2 * j2) % 1073807359, i2 / 2) % 1073807359)) % 1073807359;
    }

    @VisibleForTesting
    private static String b(String[] strArr, int i2, int i3) {
        int i4 = i3 + i2;
        if (strArr.length < i4) {
            zzbad.g("Unable to construct shingle");
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i5 = i4 - 1;
            if (i2 < i5) {
                sb.append(strArr[i2]);
                sb.append(' ');
                i2++;
            } else {
                sb.append(strArr[i5]);
                return sb.toString();
            }
        }
    }

    @VisibleForTesting
    private static void c(int i2, long j2, String str, int i3, PriorityQueue<zzvi> priorityQueue) {
        zzvi zzviVar = new zzvi(j2, str, i3);
        if ((priorityQueue.size() != i2 || (priorityQueue.peek().f16847c <= zzviVar.f16847c && priorityQueue.peek().a <= zzviVar.a)) && !priorityQueue.contains(zzviVar)) {
            priorityQueue.add(zzviVar);
            if (priorityQueue.size() > i2) {
                priorityQueue.poll();
            }
        }
    }

    public static void d(String[] strArr, int i2, int i3, PriorityQueue<zzvi> priorityQueue) {
        if (strArr.length < i3) {
            c(i2, e(strArr, 0, strArr.length), b(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long e2 = e(strArr, 0, i3);
        c(i2, e2, b(strArr, 0, i3), i3, priorityQueue);
        long a = a(16785407L, i3 - 1);
        for (int i4 = 1; i4 < (strArr.length - i3) + 1; i4++) {
            e2 = ((((((e2 + 1073807359) - ((((zzve.a(strArr[i4 - 1]) + 2147483647L) % 1073807359) * a) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((zzve.a(strArr[(i4 + i3) - 1]) + 2147483647L) % 1073807359)) % 1073807359;
            c(i2, e2, b(strArr, i4, i3), strArr.length, priorityQueue);
        }
    }

    private static long e(String[] strArr, int i2, int i3) {
        long a = (zzve.a(strArr[0]) + 2147483647L) % 1073807359;
        for (int i4 = 1; i4 < i3; i4++) {
            a = (((a * 16785407) % 1073807359) + ((zzve.a(strArr[i4]) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return a;
    }
}
