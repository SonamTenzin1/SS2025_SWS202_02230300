package c.l.b.i;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.flow.Flow;

/* compiled from: PreferenceDataStoreFactory.kt */
/* loaded from: classes.dex */
public final class b implements androidx.datastore.core.e<d> {
    private final androidx.datastore.core.e<d> a;

    /* compiled from: PreferenceDataStoreFactory.kt */
    @DebugMetadata(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {85}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    static final class a extends SuspendLambda implements Function2<d, Continuation<? super d>, Object> {

        /* renamed from: f, reason: collision with root package name */
        int f3328f;

        /* renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f3329g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function2<d, Continuation<? super d>, Object> f3330h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function2<? super d, ? super Continuation<? super d>, ? extends Object> function2, Continuation<? super a> continuation) {
            super(2, continuation);
            this.f3330h = function2;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.f3330h, continuation);
            aVar.f3329g = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(d dVar, Continuation<? super d> continuation) {
            return ((a) create(dVar, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object c2;
            c2 = kotlin.coroutines.intrinsics.d.c();
            int i2 = this.f3328f;
            if (i2 == 0) {
                o.b(obj);
                d dVar = (d) this.f3329g;
                Function2<d, Continuation<? super d>, Object> function2 = this.f3330h;
                this.f3328f = 1;
                obj = function2.invoke(dVar, this);
                if (obj == c2) {
                    return c2;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o.b(obj);
            }
            d dVar2 = (d) obj;
            ((c.l.b.i.a) dVar2).f();
            return dVar2;
        }
    }

    public b(androidx.datastore.core.e<d> eVar) {
        m.f(eVar, "delegate");
        this.a = eVar;
    }

    @Override // androidx.datastore.core.e
    public Object a(Function2<? super d, ? super Continuation<? super d>, ? extends Object> function2, Continuation<? super d> continuation) {
        return this.a.a(new a(function2, null), continuation);
    }

    @Override // androidx.datastore.core.e
    public Flow<d> b() {
        return this.a.b();
    }
}
