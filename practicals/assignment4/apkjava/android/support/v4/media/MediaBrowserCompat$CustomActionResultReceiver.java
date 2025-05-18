package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

/* loaded from: classes.dex */
class MediaBrowserCompat$CustomActionResultReceiver extends ResultReceiver {

    /* renamed from: i, reason: collision with root package name */
    private final Bundle f2i;

    /* renamed from: j, reason: collision with root package name */
    private final a f3j;

    @Override // android.support.v4.os.ResultReceiver
    protected void a(int i2, Bundle bundle) {
        if (this.f3j == null) {
            return;
        }
        MediaSessionCompat.a(bundle);
        if (i2 == -1) {
            throw null;
        }
        if (i2 == 0) {
            throw null;
        }
        if (i2 != 1) {
            Log.w("MediaBrowserCompat", "Unknown result code: " + i2 + " (extras=" + this.f2i + ", resultData=" + bundle + ")");
            return;
        }
        throw null;
    }
}
