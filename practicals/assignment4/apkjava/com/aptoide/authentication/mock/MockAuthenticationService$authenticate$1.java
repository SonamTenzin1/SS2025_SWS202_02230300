package com.aptoide.authentication.mock;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MockAuthenticationService.kt */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.aptoide.authentication.mock.MockAuthenticationService", f = "MockAuthenticationService.kt", l = {19}, m = "authenticate")
/* loaded from: classes.dex */
public final class MockAuthenticationService$authenticate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MockAuthenticationService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MockAuthenticationService$authenticate$1(MockAuthenticationService mockAuthenticationService, Continuation<? super MockAuthenticationService$authenticate$1> continuation) {
        super(continuation);
        this.this$0 = mockAuthenticationService;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.authenticate(null, null, null, this);
    }
}
