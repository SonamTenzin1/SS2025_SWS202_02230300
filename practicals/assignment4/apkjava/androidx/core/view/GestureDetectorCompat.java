package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public final class GestureDetectorCompat {
    private final a a;

    /* loaded from: classes.dex */
    interface a {
        boolean a(MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    static class b implements a {
        private static final int a = ViewConfiguration.getTapTimeout();

        /* renamed from: b, reason: collision with root package name */
        private static final int f993b = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: c, reason: collision with root package name */
        private int f994c;

        /* renamed from: d, reason: collision with root package name */
        private int f995d;

        /* renamed from: e, reason: collision with root package name */
        private int f996e;

        /* renamed from: f, reason: collision with root package name */
        private int f997f;

        /* renamed from: g, reason: collision with root package name */
        private final Handler f998g;

        /* renamed from: h, reason: collision with root package name */
        final GestureDetector.OnGestureListener f999h;

        /* renamed from: i, reason: collision with root package name */
        GestureDetector.OnDoubleTapListener f1000i;

        /* renamed from: j, reason: collision with root package name */
        boolean f1001j;

        /* renamed from: k, reason: collision with root package name */
        boolean f1002k;
        private boolean l;
        private boolean m;
        private boolean n;
        MotionEvent o;
        private MotionEvent p;
        private boolean q;
        private float r;
        private float s;
        private float t;
        private float u;
        private boolean v;
        private VelocityTracker w;

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f998g = new a(handler);
            } else {
                this.f998g = new a();
            }
            this.f999h = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                g((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            e(context);
        }

        private void b() {
            this.f998g.removeMessages(1);
            this.f998g.removeMessages(2);
            this.f998g.removeMessages(3);
            this.w.recycle();
            this.w = null;
            this.q = false;
            this.f1001j = false;
            this.m = false;
            this.n = false;
            this.f1002k = false;
            if (this.l) {
                this.l = false;
            }
        }

        private void c() {
            this.f998g.removeMessages(1);
            this.f998g.removeMessages(2);
            this.f998g.removeMessages(3);
            this.q = false;
            this.m = false;
            this.n = false;
            this.f1002k = false;
            if (this.l) {
                this.l = false;
            }
        }

        private void e(Context context) {
            if (context != null) {
                if (this.f999h != null) {
                    this.v = true;
                    ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                    int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                    int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                    this.f996e = viewConfiguration.getScaledMinimumFlingVelocity();
                    this.f997f = viewConfiguration.getScaledMaximumFlingVelocity();
                    this.f994c = scaledTouchSlop * scaledTouchSlop;
                    this.f995d = scaledDoubleTapSlop * scaledDoubleTapSlop;
                    return;
                }
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            throw new IllegalArgumentException("Context must not be null");
        }

        private boolean f(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.n || motionEvent3.getEventTime() - motionEvent2.getEventTime() > f993b) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.f995d;
        }

        /* JADX WARN: Removed duplicated region for block: B:114:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x021f  */
        @Override // androidx.core.view.GestureDetectorCompat.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(MotionEvent motionEvent) {
            boolean z;
            MotionEvent motionEvent2;
            MotionEvent motionEvent3;
            boolean onFling;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            int action = motionEvent.getAction();
            if (this.w == null) {
                this.w = VelocityTracker.obtain();
            }
            this.w.addMovement(motionEvent);
            int i2 = action & 255;
            boolean z2 = i2 == 6;
            int actionIndex = z2 ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i3 = 0; i3 < pointerCount; i3++) {
                if (actionIndex != i3) {
                    f2 += motionEvent.getX(i3);
                    f3 += motionEvent.getY(i3);
                }
            }
            float f4 = z2 ? pointerCount - 1 : pointerCount;
            float f5 = f2 / f4;
            float f6 = f3 / f4;
            if (i2 == 0) {
                if (this.f1000i != null) {
                    boolean hasMessages = this.f998g.hasMessages(3);
                    if (hasMessages) {
                        this.f998g.removeMessages(3);
                    }
                    MotionEvent motionEvent4 = this.o;
                    if (motionEvent4 != null && (motionEvent3 = this.p) != null && hasMessages && f(motionEvent4, motionEvent3, motionEvent)) {
                        this.q = true;
                        z = this.f1000i.onDoubleTap(this.o) | false | this.f1000i.onDoubleTapEvent(motionEvent);
                        this.r = f5;
                        this.t = f5;
                        this.s = f6;
                        this.u = f6;
                        motionEvent2 = this.o;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.o = MotionEvent.obtain(motionEvent);
                        this.m = true;
                        this.n = true;
                        this.f1001j = true;
                        this.l = false;
                        this.f1002k = false;
                        if (this.v) {
                            this.f998g.removeMessages(2);
                            this.f998g.sendEmptyMessageAtTime(2, this.o.getDownTime() + a + ViewConfiguration.getLongPressTimeout());
                        }
                        this.f998g.sendEmptyMessageAtTime(1, this.o.getDownTime() + a);
                        return z | this.f999h.onDown(motionEvent);
                    }
                    this.f998g.sendEmptyMessageDelayed(3, f993b);
                }
                z = false;
                this.r = f5;
                this.t = f5;
                this.s = f6;
                this.u = f6;
                motionEvent2 = this.o;
                if (motionEvent2 != null) {
                }
                this.o = MotionEvent.obtain(motionEvent);
                this.m = true;
                this.n = true;
                this.f1001j = true;
                this.l = false;
                this.f1002k = false;
                if (this.v) {
                }
                this.f998g.sendEmptyMessageAtTime(1, this.o.getDownTime() + a);
                return z | this.f999h.onDown(motionEvent);
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        b();
                        return false;
                    }
                    if (i2 == 5) {
                        this.r = f5;
                        this.t = f5;
                        this.s = f6;
                        this.u = f6;
                        c();
                        return false;
                    }
                    if (i2 != 6) {
                        return false;
                    }
                    this.r = f5;
                    this.t = f5;
                    this.s = f6;
                    this.u = f6;
                    this.w.computeCurrentVelocity(1000, this.f997f);
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex2);
                    float xVelocity = this.w.getXVelocity(pointerId);
                    float yVelocity = this.w.getYVelocity(pointerId);
                    for (int i4 = 0; i4 < pointerCount; i4++) {
                        if (i4 != actionIndex2) {
                            int pointerId2 = motionEvent.getPointerId(i4);
                            if ((this.w.getXVelocity(pointerId2) * xVelocity) + (this.w.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                                this.w.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                }
                if (this.l) {
                    return false;
                }
                float f7 = this.r - f5;
                float f8 = this.s - f6;
                if (this.q) {
                    return false | this.f1000i.onDoubleTapEvent(motionEvent);
                }
                if (!this.m) {
                    if (Math.abs(f7) < 1.0f && Math.abs(f8) < 1.0f) {
                        return false;
                    }
                    boolean onScroll = this.f999h.onScroll(this.o, motionEvent, f7, f8);
                    this.r = f5;
                    this.s = f6;
                    return onScroll;
                }
                int i5 = (int) (f5 - this.t);
                int i6 = (int) (f6 - this.u);
                int i7 = (i5 * i5) + (i6 * i6);
                if (i7 > this.f994c) {
                    onFling = this.f999h.onScroll(this.o, motionEvent, f7, f8);
                    this.r = f5;
                    this.s = f6;
                    this.m = false;
                    this.f998g.removeMessages(3);
                    this.f998g.removeMessages(1);
                    this.f998g.removeMessages(2);
                } else {
                    onFling = false;
                }
                if (i7 > this.f994c) {
                    this.n = false;
                }
            } else {
                this.f1001j = false;
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                if (this.q) {
                    onFling = this.f1000i.onDoubleTapEvent(motionEvent) | false;
                } else {
                    if (this.l) {
                        this.f998g.removeMessages(3);
                        this.l = false;
                    } else if (this.m) {
                        boolean onSingleTapUp = this.f999h.onSingleTapUp(motionEvent);
                        if (this.f1002k && (onDoubleTapListener = this.f1000i) != null) {
                            onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                        }
                        onFling = onSingleTapUp;
                    } else {
                        VelocityTracker velocityTracker = this.w;
                        int pointerId3 = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, this.f997f);
                        float yVelocity2 = velocityTracker.getYVelocity(pointerId3);
                        float xVelocity2 = velocityTracker.getXVelocity(pointerId3);
                        if (Math.abs(yVelocity2) > this.f996e || Math.abs(xVelocity2) > this.f996e) {
                            onFling = this.f999h.onFling(this.o, motionEvent, xVelocity2, yVelocity2);
                        }
                    }
                    onFling = false;
                }
                MotionEvent motionEvent5 = this.p;
                if (motionEvent5 != null) {
                    motionEvent5.recycle();
                }
                this.p = obtain;
                VelocityTracker velocityTracker2 = this.w;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.w = null;
                }
                this.q = false;
                this.f1002k = false;
                this.f998g.removeMessages(1);
                this.f998g.removeMessages(2);
            }
            return onFling;
        }

        void d() {
            this.f998g.removeMessages(3);
            this.f1002k = false;
            this.l = true;
            this.f999h.onLongPress(this.o);
        }

        public void g(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f1000i = onDoubleTapListener;
        }

        /* loaded from: classes.dex */
        private class a extends Handler {
            a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1) {
                    b bVar = b.this;
                    bVar.f999h.onShowPress(bVar.o);
                    return;
                }
                if (i2 == 2) {
                    b.this.d();
                    return;
                }
                if (i2 == 3) {
                    b bVar2 = b.this;
                    GestureDetector.OnDoubleTapListener onDoubleTapListener = bVar2.f1000i;
                    if (onDoubleTapListener != null) {
                        if (!bVar2.f1001j) {
                            onDoubleTapListener.onSingleTapConfirmed(bVar2.o);
                            return;
                        } else {
                            bVar2.f1002k = true;
                            return;
                        }
                    }
                    return;
                }
                throw new RuntimeException("Unknown message " + message);
            }

            a(Handler handler) {
                super(handler.getLooper());
            }
        }
    }

    /* loaded from: classes.dex */
    static class c implements a {
        private final GestureDetector a;

        c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.GestureDetectorCompat.a
        public boolean a(MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.a = new c(context, onGestureListener, handler);
        } else {
            this.a = new b(context, onGestureListener, handler);
        }
    }
}
