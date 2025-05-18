package com.liulishuo.filedownloader.message;

import com.liulishuo.filedownloader.message.BlockCompleteMessage;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import e.h.a.g0.f;
import java.io.File;

/* compiled from: MessageSnapshotTaker.java */
/* loaded from: classes2.dex */
public class c {
    public static MessageSnapshot a(int i2, File file, boolean z) {
        long length = file.length();
        if (length > 2147483647L) {
            if (z) {
                return new LargeMessageSnapshot.CompletedFlowDirectlySnapshot(i2, true, length);
            }
            return new LargeMessageSnapshot.CompletedSnapshot(i2, true, length);
        }
        if (z) {
            return new SmallMessageSnapshot.CompletedFlowDirectlySnapshot(i2, true, (int) length);
        }
        return new SmallMessageSnapshot.CompletedSnapshot(i2, true, (int) length);
    }

    public static MessageSnapshot b(int i2, long j2, Throwable th) {
        if (j2 > 2147483647L) {
            return new LargeMessageSnapshot.ErrorMessageSnapshot(i2, j2, th);
        }
        return new SmallMessageSnapshot.ErrorMessageSnapshot(i2, (int) j2, th);
    }

    public static MessageSnapshot c(e.h.a.a aVar) {
        if (aVar.h()) {
            return new LargeMessageSnapshot.PausedSnapshot(aVar.getId(), aVar.o(), aVar.E());
        }
        return new SmallMessageSnapshot.PausedSnapshot(aVar.getId(), aVar.B(), aVar.i());
    }

    public static MessageSnapshot d(int i2, long j2, long j3, boolean z) {
        if (j3 > 2147483647L) {
            if (z) {
                return new LargeMessageSnapshot.WarnFlowDirectlySnapshot(i2, j2, j3);
            }
            return new LargeMessageSnapshot.WarnMessageSnapshot(i2, j2, j3);
        }
        if (z) {
            return new SmallMessageSnapshot.WarnFlowDirectlySnapshot(i2, (int) j2, (int) j3);
        }
        return new SmallMessageSnapshot.WarnMessageSnapshot(i2, (int) j2, (int) j3);
    }

    public static MessageSnapshot e(byte b2, FileDownloadModel fileDownloadModel, f.a aVar) {
        MessageSnapshot errorMessageSnapshot;
        IllegalStateException illegalStateException;
        int e2 = fileDownloadModel.e();
        if (b2 == -4) {
            throw new IllegalStateException(e.h.a.k0.f.o("please use #catchWarn instead %d", Integer.valueOf(e2)));
        }
        if (b2 == -3) {
            if (fileDownloadModel.o()) {
                return new LargeMessageSnapshot.CompletedSnapshot(e2, false, fileDownloadModel.k());
            }
            return new SmallMessageSnapshot.CompletedSnapshot(e2, false, (int) fileDownloadModel.k());
        }
        if (b2 != -1) {
            if (b2 == 1) {
                if (fileDownloadModel.o()) {
                    return new LargeMessageSnapshot.PendingMessageSnapshot(e2, fileDownloadModel.g(), fileDownloadModel.k());
                }
                return new SmallMessageSnapshot.PendingMessageSnapshot(e2, (int) fileDownloadModel.g(), (int) fileDownloadModel.k());
            }
            if (b2 == 2) {
                String d2 = fileDownloadModel.p() ? fileDownloadModel.d() : null;
                if (fileDownloadModel.o()) {
                    return new LargeMessageSnapshot.ConnectedMessageSnapshot(e2, aVar.c(), fileDownloadModel.k(), fileDownloadModel.b(), d2);
                }
                return new SmallMessageSnapshot.ConnectedMessageSnapshot(e2, aVar.c(), (int) fileDownloadModel.k(), fileDownloadModel.b(), d2);
            }
            if (b2 == 3) {
                if (fileDownloadModel.o()) {
                    return new LargeMessageSnapshot.ProgressMessageSnapshot(e2, fileDownloadModel.g());
                }
                return new SmallMessageSnapshot.ProgressMessageSnapshot(e2, (int) fileDownloadModel.g());
            }
            if (b2 != 5) {
                if (b2 != 6) {
                    String o = e.h.a.k0.f.o("it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, Byte.valueOf(b2));
                    e.h.a.k0.d.i(c.class, "it can't takes a snapshot for the task(%s) when its status is %d,", fileDownloadModel, Byte.valueOf(b2));
                    if (aVar.a() != null) {
                        illegalStateException = new IllegalStateException(o, aVar.a());
                    } else {
                        illegalStateException = new IllegalStateException(o);
                    }
                    if (fileDownloadModel.o()) {
                        return new LargeMessageSnapshot.ErrorMessageSnapshot(e2, fileDownloadModel.g(), illegalStateException);
                    }
                    return new SmallMessageSnapshot.ErrorMessageSnapshot(e2, (int) fileDownloadModel.g(), illegalStateException);
                }
                return new MessageSnapshot.StartedMessageSnapshot(e2);
            }
            if (fileDownloadModel.o()) {
                errorMessageSnapshot = new LargeMessageSnapshot.RetryMessageSnapshot(e2, fileDownloadModel.g(), aVar.a(), aVar.b());
            } else {
                errorMessageSnapshot = new SmallMessageSnapshot.RetryMessageSnapshot(e2, (int) fileDownloadModel.g(), aVar.a(), aVar.b());
            }
        } else if (fileDownloadModel.o()) {
            errorMessageSnapshot = new LargeMessageSnapshot.ErrorMessageSnapshot(e2, fileDownloadModel.g(), aVar.a());
        } else {
            errorMessageSnapshot = new SmallMessageSnapshot.ErrorMessageSnapshot(e2, (int) fileDownloadModel.g(), aVar.a());
        }
        return errorMessageSnapshot;
    }

    public static MessageSnapshot f(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.k() == -3) {
            return new BlockCompleteMessage.BlockCompleteMessageImpl(messageSnapshot);
        }
        throw new IllegalStateException(e.h.a.k0.f.o("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.e()), Byte.valueOf(messageSnapshot.k())));
    }
}
