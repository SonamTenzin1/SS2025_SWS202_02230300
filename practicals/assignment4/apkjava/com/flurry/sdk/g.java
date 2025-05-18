package com.flurry.sdk;

import android.text.TextUtils;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class g {
    String a;

    /* renamed from: b, reason: collision with root package name */
    final Set<String> f10766b;

    /* loaded from: classes2.dex */
    final class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.startsWith(".flurryagent.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        HashSet hashSet = new HashSet();
        hashSet.add(HttpUrl.FRAGMENT_ENCODE_SET);
        hashSet.add(null);
        hashSet.add("null");
        hashSet.add("9774d56d682e549c");
        hashSet.add("dead00beef");
        this.f10766b = Collections.unmodifiableSet(hashSet);
        this.a = HttpUrl.FRAGMENT_ENCODE_SET;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        DataInputStream dataInputStream;
        File fileStreamPath = b0.a().getFileStreamPath(".flurryb.");
        String str = null;
        if (fileStreamPath == null || !fileStreamPath.exists()) {
            return null;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
            try {
                if (1 == dataInputStream.readInt()) {
                    str = dataInputStream.readUTF();
                }
            } catch (Throwable th) {
                th = th;
                try {
                    d1.d(6, "DeviceIdProvider", "Error when loading deviceId", th);
                    return str;
                } finally {
                    c2.f(dataInputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            dataInputStream = null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        DataOutputStream dataOutputStream;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File fileStreamPath = b0.a().getFileStreamPath(".flurryb.");
        if (b2.b(fileStreamPath)) {
            DataOutputStream dataOutputStream2 = null;
            try {
                dataOutputStream = new DataOutputStream(new FileOutputStream(fileStreamPath));
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.writeInt(1);
                dataOutputStream.writeUTF(str);
                c2.f(dataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                try {
                    d1.d(6, "DeviceIdProvider", "Error when saving deviceId", th);
                } finally {
                    c2.f(dataOutputStream2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        String[] list;
        DataInputStream dataInputStream;
        File filesDir = b0.a().getFilesDir();
        String str = null;
        if (filesDir != null && (list = filesDir.list(new a())) != null && list.length != 0) {
            File fileStreamPath = b0.a().getFileStreamPath(list[0]);
            if (fileStreamPath != null && fileStreamPath.exists()) {
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                    try {
                        if (46586 == dataInputStream.readUnsignedShort() && 2 == dataInputStream.readUnsignedShort()) {
                            dataInputStream.readUTF();
                            str = dataInputStream.readUTF();
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            d1.d(6, "DeviceIdProvider", "Error when loading deviceId", th);
                            return str;
                        } finally {
                            c2.f(dataInputStream);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataInputStream = null;
                }
                return str;
            }
        }
        return null;
    }
}
