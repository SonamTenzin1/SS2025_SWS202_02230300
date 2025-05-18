package cm.aptoide.pt.account.view;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import cm.aptoide.pt.logger.Logger;

/* loaded from: classes.dex */
public class UriToPathResolver {
    private static final String TAG = "cm.aptoide.pt.account.view.UriToPathResolver";
    private final ContentResolver contentResolver;

    public UriToPathResolver(ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
    }

    public String getCameraStoragePath(Uri uri) {
        Cursor query = this.contentResolver.query(uri, null, null, null, null);
        if (query != null) {
            query.moveToFirst();
            return query.getString(query.getColumnIndex("_data"));
        }
        return uri.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r1.isClosed() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        if (r1.isClosed() == false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getMediaStoragePath(Uri uri) {
        if (uri != null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = this.contentResolver.query(uri, new String[]{"_data"}, null, null, null);
                } catch (Exception e2) {
                    Logger.getInstance().e(TAG, (Throwable) e2);
                    if (cursor != null) {
                    }
                }
                if (cursor != null) {
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                    cursor.moveToFirst();
                    String string = cursor.getString(columnIndexOrThrow);
                    if (!cursor.isClosed()) {
                        cursor.close();
                    }
                    return string;
                }
                if (cursor != null) {
                }
                return uri.toString();
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }
        throw new NullPointerException("content Uri is null");
    }
}
