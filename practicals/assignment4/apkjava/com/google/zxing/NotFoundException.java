package com.google.zxing;

/* loaded from: classes2.dex */
public final class NotFoundException extends ReaderException {

    /* renamed from: h, reason: collision with root package name */
    private static final NotFoundException f20293h;

    static {
        NotFoundException notFoundException = new NotFoundException();
        f20293h = notFoundException;
        notFoundException.setStackTrace(ReaderException.f20295g);
    }

    private NotFoundException() {
    }
}
