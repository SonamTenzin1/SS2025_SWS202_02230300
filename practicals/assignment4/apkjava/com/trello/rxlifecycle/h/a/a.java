package com.trello.rxlifecycle.h.a;

import android.os.Bundle;
import rx.e;

/* compiled from: RxAppCompatActivity.java */
/* loaded from: classes.dex */
public abstract class a extends androidx.appcompat.app.d {
    private final rx.s.a<com.trello.rxlifecycle.g.a> lifecycleSubject = rx.s.a.g1();

    public final <T> com.trello.rxlifecycle.b<T> bindToLifecycle() {
        return com.trello.rxlifecycle.g.c.a(this.lifecycleSubject);
    }

    public final e<com.trello.rxlifecycle.g.a> lifecycle() {
        return this.lifecycleSubject.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.a.CREATE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    public void onDestroy() {
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.a.DESTROY);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onPause() {
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.a.PAUSE);
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onResume() {
        super.onResume();
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.a.RESUME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    public void onStart() {
        super.onStart();
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.a.START);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, android.app.Activity
    public void onStop() {
        this.lifecycleSubject.onNext(com.trello.rxlifecycle.g.a.STOP);
        super.onStop();
    }

    public final <T> com.trello.rxlifecycle.b<T> bindUntilEvent(com.trello.rxlifecycle.g.a aVar) {
        return com.trello.rxlifecycle.c.b(this.lifecycleSubject, aVar);
    }
}
