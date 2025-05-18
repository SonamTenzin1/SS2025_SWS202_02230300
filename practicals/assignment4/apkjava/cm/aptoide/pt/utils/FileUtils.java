package cm.aptoide.pt.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import cm.aptoide.pt.logger.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import rx.schedulers.Schedulers;

/* loaded from: classes.dex */
public class FileUtils {
    public static final String COPY = "Copy";
    public static final String MOVE = "Move";
    private static final String TAG = "FileUtils";
    private rx.m.b<String> sendFileMoveEvent;

    public static void createDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static boolean fileExists(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteFolder$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Long a(File file) throws Exception {
        long deleteDir = deleteDir(file);
        Logger.getInstance().d(TAG, "deleting folder " + file.getPath() + " size: " + deleteDir);
        return Long.valueOf(deleteDir);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$deleteFolder$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.e b(final File file) {
        return rx.e.P(new Callable() { // from class: cm.aptoide.pt.utils.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FileUtils.this.a(file);
            }
        }).o0(new rx.m.e() { // from class: cm.aptoide.pt.utils.h
            @Override // rx.m.e
            public final Object call(Object obj) {
                rx.e B;
                B = rx.e.B();
                return B;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long lambda$deleteFolder$3(List list) {
        long j2 = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            j2 += ((Long) list.get(i2)).longValue();
        }
        return Long.valueOf(j2);
    }

    public static boolean removeFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).delete();
    }

    public static boolean saveBitmapToFile(File file, String str, Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i2) {
        IOException e2;
        FileOutputStream fileOutputStream;
        File file2 = new File(file, str);
        try {
            file.mkdirs();
            fileOutputStream = new FileOutputStream(file2);
        } catch (IOException e3) {
            e2 = e3;
            fileOutputStream = null;
        }
        try {
            bitmap.compress(compressFormat, i2, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (IOException e4) {
            e2 = e4;
            Logger.getInstance().e(TAG, e2.getMessage());
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e5) {
                Logger.getInstance().e(TAG, e5.getMessage());
                return false;
            }
        }
    }

    public void cloneFile(String str, String str2, String str3) {
        try {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(str + "/" + str3);
            FileOutputStream fileOutputStream = new FileOutputStream(str2 + "/" + str3);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    new File(str + str3).delete();
                    return;
                }
            }
        } catch (Exception e2) {
            File file2 = new File(str + "/" + str3);
            if (file2.exists()) {
                file2.delete();
            }
            File file3 = new File(str2 + "/" + str3);
            if (file3.exists()) {
                file3.delete();
            }
            Logger.getInstance().e(TAG, e2.getMessage());
            throw new RuntimeException(e2);
        }
    }

    public void copyFile(String str, String str2, String str3) {
        if (str.equals(str2)) {
            return;
        }
        if (fileExists(str + str3)) {
            if (new File(str + str3).renameTo(new File(str2 + str3))) {
                return;
            }
            cloneFile(str, str2, str3);
            return;
        }
        throw new RuntimeException("Input file(" + str + str3 + ") doesn't exists");
    }

    public long deleteDir(File file) {
        if (file != null) {
            long j2 = 0;
            if (file.isDirectory()) {
                for (File file2 : file.listFiles() == null ? new File[0] : file.listFiles()) {
                    j2 += deleteDir(file2);
                }
            }
            long length = j2 + file.length();
            if (!file.exists() || file.delete()) {
                return length;
            }
            throw new RuntimeException("Something went wrong while deleting the file " + file.getPath() + " (if the is the file a directory, is it empty?");
        }
        throw new RuntimeException("The file to be deleted can't be null");
    }

    public rx.e<Long> deleteFolder(File... fileArr) {
        return rx.e.O(fileArr).j0(Schedulers.io()).G(new rx.m.e() { // from class: cm.aptoide.pt.utils.i
            @Override // rx.m.e
            public final Object call(Object obj) {
                return FileUtils.this.b((File) obj);
            }
        }).Y0().X(new rx.m.e() { // from class: cm.aptoide.pt.utils.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return FileUtils.lambda$deleteFolder$3((List) obj);
            }
        });
    }

    public long dirSize(File file) {
        File[] listFiles;
        long length;
        long j2 = 0;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (listFiles[i2].isDirectory()) {
                    length = dirSize(listFiles[i2]);
                } else {
                    length = listFiles[i2].length();
                }
                j2 += length;
            }
        }
        return j2;
    }

    public rx.e<Long> deleteFolder(String... strArr) {
        File[] fileArr = new File[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            fileArr[i2] = new File(strArr[i2]);
        }
        return deleteFolder(fileArr);
    }
}
