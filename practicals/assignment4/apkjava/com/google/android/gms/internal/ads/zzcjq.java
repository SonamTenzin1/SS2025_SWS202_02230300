package com.google.android.gms.internal.ads;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzwt;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzcjq {
    public static int a(SQLiteDatabase sQLiteDatabase, int i2) {
        int i3 = 0;
        String[] strArr = {"total"};
        String[] strArr2 = new String[1];
        if (i2 == 1) {
            strArr2[0] = "failed_requests";
        } else if (i2 == 2) {
            strArr2[0] = "total_requests";
        }
        Cursor query = sQLiteDatabase.query("offline_signal_statistics", strArr, "statistic_name = ?", strArr2, null, null, null);
        if (query.getCount() > 0) {
            query.moveToNext();
            i3 = 0 + query.getInt(query.getColumnIndexOrThrow("total"));
        }
        query.close();
        return i3;
    }

    public static ArrayList<zzwt.zzi.zza> b(SQLiteDatabase sQLiteDatabase) {
        ArrayList<zzwt.zzi.zza> arrayList = new ArrayList<>();
        Cursor query = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
        while (query.moveToNext()) {
            try {
                arrayList.add(zzwt.zzi.zza.V(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
            } catch (zzdok e2) {
                zzbad.g("Unable to deserialize proto from offline signals database:");
                zzbad.g(e2.getMessage());
            }
        }
        query.close();
        return arrayList;
    }
}
