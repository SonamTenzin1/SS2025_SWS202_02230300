package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* compiled from: Tasks.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b \u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\t\u001a\u00020\n8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "submissionTime", HttpUrl.FRAGMENT_ENCODE_SET, "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(JLkotlinx/coroutines/scheduling/TaskContext;)V", "mode", HttpUrl.FRAGMENT_ENCODE_SET, "getMode", "()I", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.c3.h, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public abstract class Task implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    public long f25679f;

    /* renamed from: g, reason: collision with root package name */
    public TaskContext f25680g;

    public Task(long j2, TaskContext taskContext) {
        this.f25679f = j2;
        this.f25680g = taskContext;
    }

    public Task() {
        this(0L, l.f25686f);
    }
}
