package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Executor;
import okhttp3.HttpUrl;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
final class n0 {
    private final SharedPreferences a;

    /* renamed from: e, reason: collision with root package name */
    private final Executor f19836e;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayDeque<String> f19835d = new ArrayDeque<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f19837f = false;

    /* renamed from: b, reason: collision with root package name */
    private final String f19833b = "topic_operation_queue";

    /* renamed from: c, reason: collision with root package name */
    private final String f19834c = ",";

    private n0(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.a = sharedPreferences;
        this.f19836e = executor;
    }

    private boolean b(boolean z) {
        if (!z || this.f19837f) {
            return z;
        }
        i();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n0 c(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        n0 n0Var = new n0(sharedPreferences, "topic_operation_queue", ",", executor);
        n0Var.d();
        return n0Var;
    }

    private void d() {
        synchronized (this.f19835d) {
            this.f19835d.clear();
            String string = this.a.getString(this.f19833b, HttpUrl.FRAGMENT_ENCODE_SET);
            if (!TextUtils.isEmpty(string) && string.contains(this.f19834c)) {
                String[] split = string.split(this.f19834c, -1);
                if (split.length == 0) {
                    Log.e("FirebaseMessaging", "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f19835d.add(str);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void a() {
        synchronized (this.f19835d) {
            this.a.edit().putString(this.f19833b, g()).commit();
        }
    }

    private void i() {
        this.f19836e.execute(new Runnable(this) { // from class: com.google.firebase.messaging.m0

            /* renamed from: f, reason: collision with root package name */
            private final n0 f19832f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f19832f = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f19832f.a();
            }
        });
    }

    public String e() {
        String peek;
        synchronized (this.f19835d) {
            peek = this.f19835d.peek();
        }
        return peek;
    }

    public boolean f(Object obj) {
        boolean remove;
        synchronized (this.f19835d) {
            remove = this.f19835d.remove(obj);
            b(remove);
        }
        return remove;
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.f19835d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(this.f19834c);
        }
        return sb.toString();
    }
}
