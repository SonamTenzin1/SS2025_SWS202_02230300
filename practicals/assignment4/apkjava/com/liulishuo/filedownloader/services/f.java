package com.liulishuo.filedownloader.services;

import android.content.Intent;
import com.liulishuo.filedownloader.model.FileDownloadModel;

/* compiled from: FileDownloadBroadcastHandler.java */
/* loaded from: classes2.dex */
public class f {
    public static void a(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel != null) {
            if (fileDownloadModel.h() == -3) {
                Intent intent = new Intent("filedownloader.intent.action.completed");
                intent.putExtra("model", fileDownloadModel);
                e.h.a.k0.c.a().sendBroadcast(intent);
                return;
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }
}
