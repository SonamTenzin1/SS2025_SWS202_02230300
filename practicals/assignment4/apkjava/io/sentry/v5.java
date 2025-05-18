package io.sentry;

import java.lang.Thread;

/* compiled from: UncaughtExceptionHandler.java */
/* loaded from: classes2.dex */
interface v5 {

    /* compiled from: UncaughtExceptionHandler.java */
    /* loaded from: classes2.dex */
    public static final class a implements v5 {
        private static final a a = new a();

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static v5 c() {
            return a;
        }

        @Override // io.sentry.v5
        public void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }

        @Override // io.sentry.v5
        public Thread.UncaughtExceptionHandler b() {
            return Thread.getDefaultUncaughtExceptionHandler();
        }
    }

    void a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler);

    Thread.UncaughtExceptionHandler b();
}
