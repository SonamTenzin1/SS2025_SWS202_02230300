package com.flurry.sdk;

import com.flurry.sdk.s0;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public final class r0 {
    public static final Integer a = 50;

    /* renamed from: b, reason: collision with root package name */
    String f11029b;

    /* renamed from: c, reason: collision with root package name */
    LinkedHashMap<String, List<String>> f11030c = new LinkedHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a implements y1<List<s0>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<List<s0>> a(int i2) {
            return new u1(new s0.a());
        }
    }

    /* loaded from: classes2.dex */
    final class b implements y1<List<s0>> {
        b() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<List<s0>> a(int i2) {
            return new u1(new s0.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class c implements y1<List<s0>> {
        c() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<List<s0>> a(int i2) {
            return new u1(new s0.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class d implements y1<List<s0>> {
        d() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<List<s0>> a(int i2) {
            return new u1(new s0.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class e implements y1<List<s0>> {
        e() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<List<s0>> a(int i2) {
            return new u1(new s0.a());
        }
    }

    public r0(String str) {
        this.f11029b = str + "Main";
    }

    private synchronized void d(String str, List<String> list, String str2) {
        c2.d();
        d1.c(5, "FlurryDataSenderIndex", "Saving Index File for " + str + " file name:" + b0.a().getFileStreamPath(i(str)));
        c7 c7Var = new c7(b0.a().getFileStreamPath(i(str)), str2, 1, new c());
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new s0(it.next()));
        }
        c7Var.b(arrayList);
    }

    private synchronized void f() {
        LinkedList linkedList = new LinkedList(this.f11030c.keySet());
        new c7(b0.a().getFileStreamPath(i(this.f11029b)), ".YFlurrySenderIndex.info.", 1, new d()).c();
        if (!linkedList.isEmpty()) {
            String str = this.f11029b;
            d(str, linkedList, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(String str) {
        c2.d();
        d1.c(5, "FlurryDataSenderIndex", "Deleting Index File for " + str + " file name:" + b0.a().getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str))));
        File fileStreamPath = b0.a().getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        if (fileStreamPath.exists()) {
            d1.c(5, "FlurryDataSenderIndex", "Found file for " + str + ". Deleted - " + fileStreamPath.delete());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i(String str) {
        return ".YFlurrySenderIndex.info.".concat(String.valueOf(str));
    }

    private static byte[] l(String str) {
        byte[] bArr;
        DataInputStream dataInputStream;
        c2.d();
        d1.c(5, "FlurryDataSenderIndex", "Reading block File for " + str + " file name:" + b0.a().getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str))));
        File fileStreamPath = b0.a().getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str)));
        DataInputStream dataInputStream2 = null;
        byte[] bArr2 = null;
        if (fileStreamPath.exists()) {
            d1.c(5, "FlurryDataSenderIndex", "Reading Index File for " + str + " Found file.");
            try {
                dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
            } catch (Throwable th) {
                th = th;
                bArr = null;
            }
            try {
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                if (readUnsignedShort == 0) {
                    c2.f(dataInputStream);
                    return null;
                }
                bArr2 = new byte[readUnsignedShort];
                dataInputStream.readFully(bArr2);
                dataInputStream.readUnsignedShort();
                c2.f(dataInputStream);
                return bArr2;
            } catch (Throwable th2) {
                th = th2;
                byte[] bArr3 = bArr2;
                dataInputStream2 = dataInputStream;
                bArr = bArr3;
                try {
                    d1.d(6, "FlurryDataSenderIndex", "Error when loading persistent file", th);
                    c2.f(dataInputStream2);
                    return bArr;
                } catch (Throwable th3) {
                    c2.f(dataInputStream2);
                    throw th3;
                }
            }
        }
        d1.c(4, "FlurryDataSenderIndex", "Agent cache file doesn't exist.");
        return null;
    }

    private synchronized boolean m(String str) {
        boolean c2;
        c2.d();
        c7 c7Var = new c7(b0.a().getFileStreamPath(i(str)), ".YFlurrySenderIndex.info.", 1, new e());
        List<String> k2 = k(str);
        if (k2 != null && !k2.isEmpty()) {
            d1.c(4, "FlurryDataSenderIndex", "discardOutdatedBlocksForDataKey: notSentBlocks = " + k2.size());
            for (String str2 : k2) {
                q0.b(str2).c();
                d1.c(4, "FlurryDataSenderIndex", "discardOutdatedBlocksForDataKey: removed block = ".concat(String.valueOf(str2)));
            }
        }
        this.f11030c.remove(str);
        c2 = c7Var.c();
        f();
        return c2;
    }

    public final List<String> a() {
        return new ArrayList(this.f11030c.keySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized List<String> b(String str) {
        ArrayList arrayList;
        DataInputStream dataInputStream;
        int readUnsignedShort;
        c2.d();
        d1.c(5, "FlurryDataSenderIndex", "Reading Index File for " + str + " file name:" + b0.a().getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str))));
        File fileStreamPath = b0.a().getFileStreamPath(".FlurrySenderIndex.info.".concat(String.valueOf(str)));
        ArrayList arrayList2 = null;
        DataInputStream dataInputStream2 = null;
        if (fileStreamPath.exists()) {
            d1.c(5, "FlurryDataSenderIndex", "Reading Index File for " + str + " Found file.");
            try {
                dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                try {
                    readUnsignedShort = dataInputStream.readUnsignedShort();
                } catch (Throwable th) {
                    th = th;
                    arrayList = null;
                }
            } catch (Throwable th2) {
                th = th2;
                arrayList = null;
            }
            if (readUnsignedShort == 0) {
                c2.f(dataInputStream);
                return null;
            }
            arrayList = new ArrayList(readUnsignedShort);
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                try {
                    int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                    d1.c(4, "FlurryDataSenderIndex", "read iter " + i2 + " dataLength = " + readUnsignedShort2);
                    byte[] bArr = new byte[readUnsignedShort2];
                    dataInputStream.readFully(bArr);
                    arrayList.add(new String(bArr));
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream2 = dataInputStream;
                    try {
                        d1.d(6, "FlurryDataSenderIndex", "Error when loading persistent file", th);
                        arrayList2 = arrayList;
                        return arrayList2;
                    } finally {
                        c2.f(dataInputStream2);
                    }
                }
            }
            dataInputStream.readUnsignedShort();
            c2.f(dataInputStream);
            arrayList2 = arrayList;
        } else {
            d1.c(5, "FlurryDataSenderIndex", "Agent cache file doesn't exist.");
        }
        return arrayList2;
    }

    public final synchronized void c(q0 q0Var, String str) {
        boolean z;
        d1.c(4, "FlurryDataSenderIndex", "addBlockInfo".concat(String.valueOf(str)));
        String str2 = q0Var.a;
        List<String> list = this.f11030c.get(str);
        if (list == null) {
            d1.c(4, "FlurryDataSenderIndex", "New Data Key");
            list = new LinkedList<>();
            z = true;
        } else {
            z = false;
        }
        list.add(str2);
        if (list.size() > a.intValue()) {
            q0.b(list.get(0)).c();
            list.remove(0);
        }
        this.f11030c.put(str, list);
        d(str, list, ".YFlurrySenderIndex.info.");
        if (z) {
            f();
        }
    }

    public final boolean e(String str, String str2) {
        boolean z;
        List<String> list = this.f11030c.get(str2);
        if (list != null) {
            q0.b(str).c();
            z = list.remove(str);
        } else {
            z = false;
        }
        if (list != null && !list.isEmpty()) {
            this.f11030c.put(str2, list);
            d(str2, list, ".YFlurrySenderIndex.info.");
        } else {
            m(str2);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(String str) {
        List<String> b2 = b(str);
        if (b2 == null) {
            d1.l("FlurryDataSenderIndex", "No old file to replace");
            return;
        }
        for (String str2 : b2) {
            byte[] l = l(str2);
            if (l == null) {
                d1.c(6, "FlurryDataSenderIndex", "File does not exist");
            } else {
                c2.d();
                d1.c(5, "FlurryDataSenderIndex", "Saving Block File for " + str2 + " file name:" + b0.a().getFileStreamPath(q0.a(str2)));
                q0.b(str2).b(new q0(l));
                c2.d();
                d1.c(5, "FlurryDataSenderIndex", "Deleting  block File for " + str2 + " file name:" + b0.a().getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str2))));
                File fileStreamPath = b0.a().getFileStreamPath(".flurrydatasenderblock.".concat(String.valueOf(str2)));
                if (fileStreamPath.exists()) {
                    d1.c(5, "FlurryDataSenderIndex", "Found file for " + str2 + ". Deleted - " + fileStreamPath.delete());
                }
            }
        }
        d(str, b2, ".YFlurrySenderIndex.info.");
        h(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized List<String> j(String str) {
        c2.d();
        d1.c(5, "FlurryDataSenderIndex", "Reading Index File for " + str + " file name:" + b0.a().getFileStreamPath(i(str)));
        List list = (List) new c7(b0.a().getFileStreamPath(i(str)), ".YFlurrySenderIndex.info.", 1, new b()).a();
        if (list == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((s0) it.next()).a);
        }
        return arrayList;
    }

    public final List<String> k(String str) {
        List<String> list = this.f11030c.get(str);
        if (list == null) {
            return Collections.emptyList();
        }
        return new ArrayList(list);
    }
}
