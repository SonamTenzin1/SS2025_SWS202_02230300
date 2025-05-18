package rx.n.a;

import java.util.ArrayList;
import java.util.Queue;
import rx.b;
import rx.exceptions.CompositeException;

/* compiled from: CompletableOnSubscribeMerge.java */
/* loaded from: classes3.dex */
public final class e implements b.w {
    public static Throwable a(Queue<Throwable> queue) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Throwable poll = queue.poll();
            if (poll == null) {
                break;
            }
            arrayList.add(poll);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return (Throwable) arrayList.get(0);
        }
        return new CompositeException(arrayList);
    }
}
