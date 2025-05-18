package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlinx.coroutines.t0;
import okhttp3.HttpUrl;

/* compiled from: Tasks.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", HttpUrl.FRAGMENT_ENCODE_SET, "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/TaskContext;)V", "run", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.c3.k, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public final class TaskImpl extends Task {

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f25681h;

    public TaskImpl(Runnable runnable, long j2, TaskContext taskContext) {
        super(j2, taskContext);
        this.f25681h = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f25681h.run();
        } finally {
            this.f25680g.a();
        }
    }

    public String toString() {
        return "Task[" + t0.a(this.f25681h) + '@' + t0.b(this.f25681h) + ", " + this.f25679f + ", " + this.f25680g + ']';
    }
}
