package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SharedSQLiteStatement.java */
/* loaded from: classes.dex */
public abstract class q {
    private final j mDatabase;
    private final AtomicBoolean mLock = new AtomicBoolean(false);
    private volatile c.u.a.f mStmt;

    public q(j jVar) {
        this.mDatabase = jVar;
    }

    private c.u.a.f createNewStatement() {
        return this.mDatabase.compileStatement(createQuery());
    }

    private c.u.a.f getStmt(boolean z) {
        if (z) {
            if (this.mStmt == null) {
                this.mStmt = createNewStatement();
            }
            return this.mStmt;
        }
        return createNewStatement();
    }

    public c.u.a.f acquire() {
        assertNotMainThread();
        return getStmt(this.mLock.compareAndSet(false, true));
    }

    protected void assertNotMainThread() {
        this.mDatabase.assertNotMainThread();
    }

    protected abstract String createQuery();

    public void release(c.u.a.f fVar) {
        if (fVar == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
