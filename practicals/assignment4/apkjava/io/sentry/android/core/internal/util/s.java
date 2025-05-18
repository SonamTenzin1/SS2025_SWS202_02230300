package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import io.sentry.android.core.s0;
import io.sentry.s4;
import io.sentry.w1;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: ScreenshotUtils.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public class s {
    @SuppressLint({"NewApi"})
    private static boolean a(Activity activity, s0 s0Var) {
        if (s0Var.d() >= 17) {
            return (activity.isFinishing() || activity.isDestroyed()) ? false : true;
        }
        return !activity.isFinishing();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(AtomicBoolean atomicBoolean, CountDownLatch countDownLatch, int i2) {
        atomicBoolean.set(i2 == 0);
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(View view, Canvas canvas, w1 w1Var, CountDownLatch countDownLatch) {
        try {
            view.draw(canvas);
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009f, code lost:
    
        if (r14.get() != false) goto L33;
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] d(Activity activity, io.sentry.util.thread.b bVar, final w1 w1Var, s0 s0Var) {
        if (!a(activity, s0Var)) {
            w1Var.c(s4.DEBUG, "Activity isn't valid, not taking screenshot.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            w1Var.c(s4.DEBUG, "Activity window is null, not taking screenshot.", new Object[0]);
            return null;
        }
        View peekDecorView = window.peekDecorView();
        if (peekDecorView == null) {
            w1Var.c(s4.DEBUG, "DecorView is null, not taking screenshot.", new Object[0]);
            return null;
        }
        final View rootView = peekDecorView.getRootView();
        if (rootView == null) {
            w1Var.c(s4.DEBUG, "Root view is null, not taking screenshot.", new Object[0]);
            return null;
        }
        if (rootView.getWidth() > 0 && rootView.getHeight() > 0) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
                    boolean z = true;
                    final CountDownLatch countDownLatch = new CountDownLatch(1);
                    if (s0Var.d() >= 26) {
                        HandlerThread handlerThread = new HandlerThread("SentryScreenshot");
                        handlerThread.start();
                        try {
                            Handler handler = new Handler(handlerThread.getLooper());
                            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                            PixelCopy.request(window, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: io.sentry.android.core.internal.util.c
                                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                                public final void onPixelCopyFinished(int i2) {
                                    s.b(atomicBoolean, countDownLatch, i2);
                                }
                            }, handler);
                            if (countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                            }
                            z = false;
                        } catch (Throwable th) {
                            try {
                                w1Var.b(s4.ERROR, "Taking screenshot using PixelCopy failed.", th);
                                z = false;
                            } finally {
                                handlerThread.quit();
                            }
                        }
                        if (!z) {
                            return null;
                        }
                    } else {
                        final Canvas canvas = new Canvas(createBitmap);
                        if (bVar.d()) {
                            rootView.draw(canvas);
                            countDownLatch.countDown();
                        } else {
                            activity.runOnUiThread(new Runnable() { // from class: io.sentry.android.core.internal.util.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    s.c(rootView, canvas, w1Var, countDownLatch);
                                }
                            });
                        }
                        if (!countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                            byteArrayOutputStream.close();
                            return null;
                        }
                    }
                    createBitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                    if (byteArrayOutputStream.size() <= 0) {
                        w1Var.c(s4.DEBUG, "Screenshot is 0 bytes, not attaching the image.", new Object[0]);
                        byteArrayOutputStream.close();
                        return null;
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                } finally {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable th2) {
                w1Var.b(s4.ERROR, "Taking screenshot failed.", th2);
                return null;
            }
        }
        w1Var.c(s4.DEBUG, "View's width and height is zeroed, not taking screenshot.", new Object[0]);
        return null;
    }
}
