package c.q.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public final class a {
    private static final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static a f3391b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f3392c;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<c>> f3393d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, ArrayList<c>> f3394e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<b> f3395f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    private final Handler f3396g;

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: c.q.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class HandlerC0088a extends Handler {
        HandlerC0088a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class b {
        final Intent a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<c> f3397b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.a = intent;
            this.f3397b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class c {
        final IntentFilter a;

        /* renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f3398b;

        /* renamed from: c, reason: collision with root package name */
        boolean f3399c;

        /* renamed from: d, reason: collision with root package name */
        boolean f3400d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.f3398b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f3398b);
            sb.append(" filter=");
            sb.append(this.a);
            if (this.f3400d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private a(Context context) {
        this.f3392c = context;
        this.f3396g = new HandlerC0088a(context.getMainLooper());
    }

    public static a b(Context context) {
        a aVar;
        synchronized (a) {
            if (f3391b == null) {
                f3391b = new a(context.getApplicationContext());
            }
            aVar = f3391b;
        }
        return aVar;
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f3393d) {
                size = this.f3395f.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.f3395f.toArray(bVarArr);
                this.f3395f.clear();
            }
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = bVarArr[i2];
                int size2 = bVar.f3397b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    c cVar = bVar.f3397b.get(i3);
                    if (!cVar.f3400d) {
                        cVar.f3398b.onReceive(this.f3392c, bVar.a);
                    }
                }
            }
        }
    }

    public void c(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f3393d) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f3393d.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f3393d.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                String action = intentFilter.getAction(i2);
                ArrayList<c> arrayList2 = this.f3394e.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f3394e.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean d(Intent intent) {
        int i2;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        synchronized (this.f3393d) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f3392c.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.f3394e.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    c cVar = arrayList3.get(i3);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.a);
                    }
                    if (cVar.f3399c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i2 = i3;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = cVar.a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f3399c = true;
                            i3 = i2 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i3 = i2 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                        ((c) arrayList5.get(i4)).f3399c = false;
                    }
                    this.f3395f.add(new b(intent, arrayList5));
                    if (!this.f3396g.hasMessages(1)) {
                        this.f3396g.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void e(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f3393d) {
            ArrayList<c> remove = this.f3393d.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                c cVar = remove.get(size);
                cVar.f3400d = true;
                for (int i2 = 0; i2 < cVar.a.countActions(); i2++) {
                    String action = cVar.a.getAction(i2);
                    ArrayList<c> arrayList = this.f3394e.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            c cVar2 = arrayList.get(size2);
                            if (cVar2.f3398b == broadcastReceiver) {
                                cVar2.f3400d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f3394e.remove(action);
                        }
                    }
                }
            }
        }
    }
}
