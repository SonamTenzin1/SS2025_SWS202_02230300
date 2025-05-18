package com.bumptech.glide.load.m.o;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener.java */
/* loaded from: classes.dex */
class e {
    private static final a a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final a f9288b;

    /* renamed from: c, reason: collision with root package name */
    private final d f9289c;

    /* renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f9290d;

    /* renamed from: e, reason: collision with root package name */
    private final ContentResolver f9291e;

    /* renamed from: f, reason: collision with root package name */
    private final List<ImageHeaderParser> f9292f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(List<ImageHeaderParser> list, d dVar, com.bumptech.glide.load.engine.z.b bVar, ContentResolver contentResolver) {
        this(list, a, dVar, bVar, contentResolver);
    }

    private String b(Uri uri) {
        Cursor a2 = this.f9289c.a(uri);
        if (a2 != null) {
            try {
                if (a2.moveToFirst()) {
                    return a2.getString(0);
                }
            } finally {
                a2.close();
            }
        }
        if (a2 != null) {
        }
        return null;
    }

    private boolean c(File file) {
        return this.f9288b.a(file) && 0 < this.f9288b.c(file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f9291e.openInputStream(uri);
                int a2 = com.bumptech.glide.load.e.a(this.f9292f, inputStream, this.f9290d);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return a2;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e2) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e2);
            }
            if (inputStream == null) {
                return -1;
            }
            try {
                inputStream.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        }
    }

    public InputStream d(Uri uri) throws FileNotFoundException {
        String b2 = b(uri);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        File b3 = this.f9288b.b(b2);
        if (!c(b3)) {
            return null;
        }
        Uri fromFile = Uri.fromFile(b3);
        try {
            return this.f9291e.openInputStream(fromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e2));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, com.bumptech.glide.load.engine.z.b bVar, ContentResolver contentResolver) {
        this.f9288b = aVar;
        this.f9289c = dVar;
        this.f9290d = bVar;
        this.f9291e = contentResolver;
        this.f9292f = list;
    }
}
