package c.r;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import cm.aptoide.pt.utils.MultiDexHelper;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import okhttp3.internal.http2.Http2;

/* compiled from: MultiDexExtractor.java */
/* loaded from: classes.dex */
final class b implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    private final File f3403f;

    /* renamed from: g, reason: collision with root package name */
    private final long f3404g;

    /* renamed from: h, reason: collision with root package name */
    private final File f3405h;

    /* renamed from: i, reason: collision with root package name */
    private final RandomAccessFile f3406i;

    /* renamed from: j, reason: collision with root package name */
    private final FileChannel f3407j;

    /* renamed from: k, reason: collision with root package name */
    private final FileLock f3408k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiDexExtractor.java */
    /* loaded from: classes.dex */
    public class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MultiDexExtractor.java */
    /* renamed from: c.r.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0091b extends File {

        /* renamed from: f, reason: collision with root package name */
        public long f3409f;

        public C0091b(File file, String str) {
            super(file, str);
            this.f3409f = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(File file, File file2) throws IOException {
        Log.i("MultiDex", "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.f3403f = file;
        this.f3405h = file2;
        this.f3404g = f(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f3406i = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f3407j = channel;
            try {
                Log.i("MultiDex", "Blocking on lock " + file3.getPath());
                this.f3408k = channel.lock();
                Log.i("MultiDex", file3.getPath() + " locked");
            } catch (IOException e2) {
                e = e2;
                b(this.f3407j);
                throw e;
            } catch (Error e3) {
                e = e3;
                b(this.f3407j);
                throw e;
            } catch (RuntimeException e4) {
                e = e4;
                b(this.f3407j);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            b(this.f3406i);
            throw e5;
        }
    }

    private void a() {
        File[] listFiles = this.f3405h.listFiles(new a());
        if (listFiles == null) {
            Log.w("MultiDex", "Failed to list secondary dex dir content (" + this.f3405h.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i("MultiDex", "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old file " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete old file " + file.getPath());
            }
        }
    }

    private static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("MultiDex", "Failed to close resource", e2);
        }
    }

    private static void c(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, MultiDexHelper.EXTRACTED_SUFFIX, file.getParentFile());
        Log.i("MultiDex", "Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (createTempFile.setReadOnly()) {
                    Log.i("MultiDex", "Renaming to " + file.getPath());
                    if (createTempFile.renameTo(file)) {
                        return;
                    }
                    throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
                }
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            b(inputStream);
            createTempFile.delete();
        }
    }

    private static SharedPreferences d(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static long e(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long f(File file) throws IOException {
        long c2 = c.c(file);
        return c2 == -1 ? c2 - 1 : c2;
    }

    private static boolean j(Context context, File file, long j2, String str) {
        SharedPreferences d2 = d(context);
        if (d2.getLong(str + "timestamp", -1L) == e(file)) {
            if (d2.getLong(str + "crc", -1L) == j2) {
                return false;
            }
        }
        return true;
    }

    private List<C0091b> l(Context context, String str) throws IOException {
        Log.i("MultiDex", "loading existing secondary dex files");
        String str2 = this.f3403f.getName() + ".classes";
        SharedPreferences d2 = d(context);
        int i2 = d2.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i2 + (-1));
        int i3 = 2;
        while (i3 <= i2) {
            C0091b c0091b = new C0091b(this.f3405h, str2 + i3 + MultiDexHelper.EXTRACTED_SUFFIX);
            if (c0091b.isFile()) {
                c0091b.f3409f = f(c0091b);
                long j2 = d2.getLong(str + "dex.crc." + i3, -1L);
                long j3 = d2.getLong(str + "dex.time." + i3, -1L);
                long lastModified = c0091b.lastModified();
                if (j3 == lastModified) {
                    String str3 = str2;
                    SharedPreferences sharedPreferences = d2;
                    if (j2 == c0091b.f3409f) {
                        arrayList.add(c0091b);
                        i3++;
                        d2 = sharedPreferences;
                        str2 = str3;
                    }
                }
                throw new IOException("Invalid extracted dex: " + c0091b + " (key \"" + str + "\"), expected modification time: " + j3 + ", modification time: " + lastModified + ", expected crc: " + j2 + ", file crc: " + c0091b.f3409f);
            }
            throw new IOException("Missing extracted secondary dex file '" + c0091b.getPath() + "'");
        }
        return arrayList;
    }

    private List<C0091b> m() throws IOException {
        boolean z;
        String str = this.f3403f.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f3403f);
        try {
            ZipEntry entry = zipFile.getEntry("classes2.dex");
            int i2 = 2;
            while (entry != null) {
                C0091b c0091b = new C0091b(this.f3405h, str + i2 + MultiDexHelper.EXTRACTED_SUFFIX);
                arrayList.add(c0091b);
                Log.i("MultiDex", "Extraction is needed for file " + c0091b);
                int i3 = 0;
                boolean z2 = false;
                while (i3 < 3 && !z2) {
                    int i4 = i3 + 1;
                    c(zipFile, entry, c0091b, str);
                    try {
                        c0091b.f3409f = f(c0091b);
                        z = true;
                    } catch (IOException e2) {
                        Log.w("MultiDex", "Failed to read crc from " + c0091b.getAbsolutePath(), e2);
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "succeeded" : "failed");
                    sb.append(" '");
                    sb.append(c0091b.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(c0091b.length());
                    sb.append(" - crc: ");
                    sb.append(c0091b.f3409f);
                    Log.i("MultiDex", sb.toString());
                    if (!z) {
                        c0091b.delete();
                        if (c0091b.exists()) {
                            Log.w("MultiDex", "Failed to delete corrupted secondary dex '" + c0091b.getPath() + "'");
                        }
                    }
                    z2 = z;
                    i3 = i4;
                }
                if (z2) {
                    i2++;
                    entry = zipFile.getEntry("classes" + i2 + ".dex");
                } else {
                    throw new IOException("Could not create zip file " + c0091b.getAbsolutePath() + " for secondary dex (" + i2 + ")");
                }
            }
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w("MultiDex", "Failed to close resource", e3);
            }
            return arrayList;
        } finally {
        }
    }

    private static void p(Context context, String str, long j2, long j3, List<C0091b> list) {
        SharedPreferences.Editor edit = d(context).edit();
        edit.putLong(str + "timestamp", j2);
        edit.putLong(str + "crc", j3);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i2 = 2;
        for (C0091b c0091b : list) {
            edit.putLong(str + "dex.crc." + i2, c0091b.f3409f);
            edit.putLong(str + "dex.time." + i2, c0091b.lastModified());
            i2++;
        }
        edit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3408k.release();
        this.f3407j.close();
        this.f3406i.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<? extends File> k(Context context, String str, boolean z) throws IOException {
        List<C0091b> m;
        List<C0091b> list;
        Log.i("MultiDex", "MultiDexExtractor.load(" + this.f3403f.getPath() + ", " + z + ", " + str + ")");
        if (this.f3408k.isValid()) {
            if (!z && !j(context, this.f3403f, this.f3404g, str)) {
                try {
                    list = l(context, str);
                } catch (IOException e2) {
                    Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e2);
                    m = m();
                    p(context, str, e(this.f3403f), this.f3404g, m);
                }
                Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
                return list;
            }
            if (z) {
                Log.i("MultiDex", "Forced extraction must be performed.");
            } else {
                Log.i("MultiDex", "Detected that extraction must be performed.");
            }
            m = m();
            p(context, str, e(this.f3403f), this.f3404g, m);
            list = m;
            Log.i("MultiDex", "load found " + list.size() + " secondary dex files");
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }
}
