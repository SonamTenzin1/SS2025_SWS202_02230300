package com.facebook.o0;

import android.content.Context;
import android.util.Log;
import com.facebook.internal.p0;
import com.facebook.o0.t;
import com.facebook.o0.v;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

/* compiled from: AppEventDiskStore.kt */
/* loaded from: classes.dex */
public final class x {
    public static final x a = new x();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10549b = x.class.getName();

    /* compiled from: AppEventDiskStore.kt */
    /* loaded from: classes.dex */
    private static final class a extends ObjectInputStream {

        /* renamed from: f, reason: collision with root package name */
        public static final C0152a f10550f = new C0152a(null);

        /* compiled from: AppEventDiskStore.kt */
        /* renamed from: com.facebook.o0.x$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0152a {
            private C0152a() {
            }

            public /* synthetic */ C0152a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (kotlin.jvm.internal.m.a(readClassDescriptor.getName(), "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                readClassDescriptor = ObjectStreamClass.lookup(t.b.class);
            } else if (kotlin.jvm.internal.m.a(readClassDescriptor.getName(), "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2")) {
                readClassDescriptor = ObjectStreamClass.lookup(v.b.class);
            }
            kotlin.jvm.internal.m.e(readClassDescriptor, "resultClassDescriptor");
            return readClassDescriptor;
        }
    }

    private x() {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a5 A[Catch: all -> 0x00ac, TRY_LEAVE, TryCatch #7 {, blocks: (B:4:0x0003, B:12:0x002c, B:14:0x0031, B:17:0x00a5, B:23:0x003c, B:36:0x005c, B:38:0x0061, B:41:0x006c, B:33:0x0070, B:44:0x0075, B:46:0x007a, B:47:0x008c, B:50:0x0085, B:27:0x008e, B:29:0x0093, B:32:0x009e), top: B:3:0x0003, inners: #1, #4, #5, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized h0 a() {
        h0 h0Var;
        Throwable th;
        a aVar;
        String str;
        String str2;
        Object readObject;
        synchronized (x.class) {
            com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
            com.facebook.o0.q0.g.b();
            com.facebook.a0 a0Var = com.facebook.a0.a;
            Context c2 = com.facebook.a0.c();
            h0Var = null;
            try {
                try {
                    FileInputStream openFileInput = c2.openFileInput("AppEventsLogger.persistedevents");
                    kotlin.jvm.internal.m.e(openFileInput, "context.openFileInput(PERSISTED_EVENTS_FILENAME)");
                    aVar = new a(new BufferedInputStream(openFileInput));
                    try {
                        readObject = aVar.readObject();
                    } catch (FileNotFoundException unused) {
                        p0 p0Var = p0.a;
                        p0.h(aVar);
                        try {
                            c2.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                        } catch (Exception e2) {
                            e = e2;
                            str = f10549b;
                            str2 = "Got unexpected exception when removing events file: ";
                            Log.w(str, str2, e);
                            if (h0Var == null) {
                            }
                            return h0Var;
                        }
                        if (h0Var == null) {
                        }
                        return h0Var;
                    } catch (Exception e3) {
                        e = e3;
                        Log.w(f10549b, "Got unexpected exception while reading events: ", e);
                        p0 p0Var2 = p0.a;
                        p0.h(aVar);
                        try {
                            c2.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                        } catch (Exception e4) {
                            e = e4;
                            str = f10549b;
                            str2 = "Got unexpected exception when removing events file: ";
                            Log.w(str, str2, e);
                            if (h0Var == null) {
                            }
                            return h0Var;
                        }
                        if (h0Var == null) {
                        }
                        return h0Var;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    p0 p0Var3 = p0.a;
                    p0.h(null);
                    try {
                        c2.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception e5) {
                        Log.w(f10549b, "Got unexpected exception when removing events file: ", e5);
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
                aVar = null;
            } catch (Exception e6) {
                e = e6;
                aVar = null;
            } catch (Throwable th3) {
                th = th3;
                p0 p0Var32 = p0.a;
                p0.h(null);
                c2.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                throw th;
            }
            if (readObject != null) {
                h0 h0Var2 = (h0) readObject;
                p0 p0Var4 = p0.a;
                p0.h(aVar);
                try {
                    c2.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                } catch (Exception e7) {
                    Log.w(f10549b, "Got unexpected exception when removing events file: ", e7);
                }
                h0Var = h0Var2;
                if (h0Var == null) {
                    h0Var = new h0();
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.PersistedEvents");
            }
        }
        return h0Var;
    }

    public static final void b(h0 h0Var) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        Context c2 = com.facebook.a0.c();
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(c2.openFileOutput("AppEventsLogger.persistedevents", 0)));
            try {
                objectOutputStream2.writeObject(h0Var);
                p0 p0Var = p0.a;
                p0.h(objectOutputStream2);
            } catch (Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                try {
                    Log.w(f10549b, "Got unexpected exception while persisting events: ", th);
                    try {
                        c2.getFileStreamPath("AppEventsLogger.persistedevents").delete();
                    } catch (Exception unused) {
                    }
                } finally {
                    p0 p0Var2 = p0.a;
                    p0.h(objectOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
