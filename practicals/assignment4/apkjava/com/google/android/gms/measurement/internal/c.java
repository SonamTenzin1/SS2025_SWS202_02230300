package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzky;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public final class c extends f7 {

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f17712d = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f17713e = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f17714f = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f17715g = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f17716h = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f17717i = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: j, reason: collision with root package name */
    private static final String[] f17718j = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: k, reason: collision with root package name */
    private static final String[] f17719k = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final d l;
    private final c7 m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(zzkc zzkcVar) {
        super(zzkcVar);
        this.m = new c7(j());
        this.l = new d(this, f(), "google_app_measurement.db");
    }

    private final long A(String str, String[] strArr, long j2) {
        Cursor cursor = null;
        try {
            try {
                cursor = x().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    long j3 = cursor.getLong(0);
                    cursor.close();
                    return j3;
                }
                cursor.close();
                return j2;
            } catch (SQLiteException e2) {
                h().H().c("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @VisibleForTesting
    private final Object F(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            h().H().a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i2));
        }
        if (type == 3) {
            return cursor.getString(i2);
        }
        if (type != 4) {
            h().H().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        h().H().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    private static void M(ContentValues contentValues, String str, Object obj) {
        Preconditions.g(str);
        Preconditions.k(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final boolean V(String str, int i2, zzbj.zzb zzbVar) {
        t();
        d();
        Preconditions.g(str);
        Preconditions.k(zzbVar);
        if (TextUtils.isEmpty(zzbVar.I())) {
            h().K().d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzet.x(str), Integer.valueOf(i2), String.valueOf(zzbVar.G() ? Integer.valueOf(zzbVar.H()) : null));
            return false;
        }
        byte[] j2 = zzbVar.j();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", zzbVar.G() ? Integer.valueOf(zzbVar.H()) : null);
        contentValues.put("event_name", zzbVar.I());
        if (n().B(str, zzap.w0)) {
            contentValues.put("session_scoped", zzbVar.P() ? Boolean.valueOf(zzbVar.Q()) : null);
        }
        contentValues.put("data", j2);
        try {
            if (x().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            h().H().b("Failed to insert event filter (got -1). appId", zzet.x(str));
            return true;
        } catch (SQLiteException e2) {
            h().H().c("Error storing event filter. appId", zzet.x(str), e2);
            return false;
        }
    }

    private final boolean W(String str, int i2, zzbj.zze zzeVar) {
        t();
        d();
        Preconditions.g(str);
        Preconditions.k(zzeVar);
        if (TextUtils.isEmpty(zzeVar.F())) {
            h().K().d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzet.x(str), Integer.valueOf(i2), String.valueOf(zzeVar.D() ? Integer.valueOf(zzeVar.E()) : null));
            return false;
        }
        byte[] j2 = zzeVar.j();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        contentValues.put("filter_id", zzeVar.D() ? Integer.valueOf(zzeVar.E()) : null);
        contentValues.put("property_name", zzeVar.F());
        if (n().B(str, zzap.w0)) {
            contentValues.put("session_scoped", zzeVar.J() ? Boolean.valueOf(zzeVar.K()) : null);
        }
        contentValues.put("data", j2);
        try {
            if (x().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            h().H().b("Failed to insert property filter (got -1). appId", zzet.x(str));
            return false;
        } catch (SQLiteException e2) {
            h().H().c("Error storing property filter. appId", zzet.x(str), e2);
            return false;
        }
    }

    private final boolean h0() {
        return f().getDatabasePath("google_app_measurement.db").exists();
    }

    private final long i0(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = x().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j2 = rawQuery.getLong(0);
                    rawQuery.close();
                    return j2;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e2) {
                h().H().c("Database error", str, e2);
                throw e2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private final boolean p0(String str, List<Integer> list) {
        Preconditions.g(str);
        t();
        d();
        SQLiteDatabase x = x();
        try {
            long i0 = i0("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, n().t(str, zzap.M)));
            if (i0 <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return x.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e2) {
            h().H().c("Database error querying filters. appId", zzet.x(str), e2);
            return false;
        }
    }

    public final void A0() {
        t();
        x().endTransaction();
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x008b */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<zzbr.zzc, Long> B(String str, Long l) {
        Cursor cursor;
        Cursor cursor2;
        d();
        t();
        Cursor cursor3 = null;
        try {
            try {
                cursor = x().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l)});
                try {
                    if (!cursor.moveToFirst()) {
                        h().P().a("Main event not found");
                        cursor.close();
                        return null;
                    }
                    try {
                        Pair<zzbr.zzc, Long> create = Pair.create((zzbr.zzc) ((zzfd) ((zzbr.zzc.zza) zzkg.A(zzbr.zzc.c0(), cursor.getBlob(0))).y()), Long.valueOf(cursor.getLong(1)));
                        cursor.close();
                        return create;
                    } catch (IOException e2) {
                        h().H().d("Failed to merge main event. appId, eventId", zzet.x(str), l, e2);
                        cursor.close();
                        return null;
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    h().H().b("Error selecting main event", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
    }

    public final boolean B0() {
        return i0("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0126  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzab C(long j2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Cursor cursor;
        Cursor cursor2;
        Preconditions.g(str);
        d();
        t();
        String[] strArr = {str};
        zzab zzabVar = new zzab();
        try {
            try {
                SQLiteDatabase x = x();
                cursor2 = x.query(DeepLinkIntentReceiver.DeepLinksTargets.APPS, new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursor2.moveToFirst()) {
                        h().K().b("Not updating daily counts, app is not known. appId", zzet.x(str));
                        cursor2.close();
                        return zzabVar;
                    }
                    if (cursor2.getLong(0) == j2) {
                        zzabVar.f18051b = cursor2.getLong(1);
                        zzabVar.a = cursor2.getLong(2);
                        zzabVar.f18052c = cursor2.getLong(3);
                        zzabVar.f18053d = cursor2.getLong(4);
                        zzabVar.f18054e = cursor2.getLong(5);
                    }
                    if (z) {
                        zzabVar.f18051b++;
                    }
                    if (z2) {
                        zzabVar.a++;
                    }
                    if (z3) {
                        zzabVar.f18052c++;
                    }
                    if (z4) {
                        zzabVar.f18053d++;
                    }
                    if (z5) {
                        zzabVar.f18054e++;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j2));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzabVar.a));
                    contentValues.put("daily_events_count", Long.valueOf(zzabVar.f18051b));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzabVar.f18052c));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzabVar.f18053d));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzabVar.f18054e));
                    x.update(DeepLinkIntentReceiver.DeepLinksTargets.APPS, contentValues, "app_id=?", strArr);
                    cursor2.close();
                    return zzabVar;
                } catch (SQLiteException e2) {
                    e = e2;
                    h().H().c("Error updating daily counts. appId", zzet.x(str), e);
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return zzabVar;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor2 = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (0 != 0) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void C0() {
        int delete;
        d();
        t();
        if (h0()) {
            long a = m().f17925i.a();
            long b2 = j().b();
            if (Math.abs(b2 - a) > zzap.F.a(null).longValue()) {
                m().f17925i.b(b2);
                d();
                t();
                if (!h0() || (delete = x().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(j().a()), String.valueOf(zzx.N())})) <= 0) {
                    return;
                }
                h().P().b("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final h D(String str, String str2) {
        Cursor cursor;
        Cursor cursor2;
        Boolean valueOf;
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        t();
        boolean B = n().B(str, zzap.x0);
        ArrayList arrayList = new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"));
        if (B) {
            arrayList.add("current_session_count");
        }
        Cursor cursor3 = null;
        try {
            cursor = x().query("events", (String[]) arrayList.toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return null;
                }
                long j2 = cursor.getLong(0);
                long j3 = cursor.getLong(1);
                long j4 = cursor.getLong(2);
                long j5 = cursor.isNull(3) ? 0L : cursor.getLong(3);
                Long valueOf2 = cursor.isNull(4) ? null : Long.valueOf(cursor.getLong(4));
                Long valueOf3 = cursor.isNull(5) ? null : Long.valueOf(cursor.getLong(5));
                Long valueOf4 = cursor.isNull(6) ? null : Long.valueOf(cursor.getLong(6));
                if (cursor.isNull(7)) {
                    valueOf = null;
                } else {
                    try {
                        try {
                            valueOf = Boolean.valueOf(cursor.getLong(7) == 1);
                        } catch (SQLiteException e2) {
                            e = e2;
                            h().H().d("Error querying events. appId", zzet.x(str), k().y(str2), e);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor3 = cursor;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                }
                cursor2 = cursor;
                try {
                    h hVar = new h(str, str2, j2, j3, (!B || cursor.isNull(8)) ? 0L : cursor.getLong(8), j4, j5, valueOf2, valueOf3, valueOf4, valueOf);
                    if (cursor2.moveToNext()) {
                        h().H().b("Got multiple records for event aggregates, expected one. appId", zzet.x(str));
                    }
                    cursor2.close();
                    return hVar;
                } catch (SQLiteException e3) {
                    e = e3;
                    cursor = cursor2;
                    h().H().d("Error querying events. appId", zzet.x(str), k().y(str2), e);
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor3 = cursor2;
                    if (cursor3 != null) {
                    }
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
            }
        } catch (SQLiteException e5) {
            e = e5;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public final long D0() {
        return A("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final long E0() {
        return A("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean F0() {
        return i0("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean G0() {
        return i0("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String H(long j2) {
        Cursor cursor;
        d();
        t();
        Cursor cursor2 = null;
        try {
            try {
                cursor = x().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j2)});
                try {
                    if (!cursor.moveToFirst()) {
                        h().P().a("No expired configs for apps with pending events");
                        cursor.close();
                        return null;
                    }
                    String string = cursor.getString(0);
                    cursor.close();
                    return string;
                } catch (SQLiteException e2) {
                    e = e2;
                    h().H().b("Error selecting expired configs", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = j2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<m7> I(String str) {
        Cursor cursor;
        Preconditions.g(str);
        d();
        t();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            try {
                cursor = x().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
            } catch (Throwable th) {
                th = th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        try {
            if (!cursor.moveToFirst()) {
                cursor.close();
                return arrayList;
            }
            do {
                String string = cursor.getString(0);
                String string2 = cursor.getString(1);
                if (string2 == null) {
                    string2 = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                String str2 = string2;
                long j2 = cursor.getLong(2);
                try {
                    Object F = F(cursor, 3);
                    if (F == null) {
                        h().H().b("Read invalid user property value, ignoring it. appId", zzet.x(str));
                    } else {
                        arrayList.add(new m7(str, str2, string, j2, F));
                    }
                } catch (SQLiteException e3) {
                    e = e3;
                    h().H().c("Error querying user properties. appId", zzet.x(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } while (cursor.moveToNext());
            cursor.close();
            return arrayList;
        } catch (SQLiteException e4) {
            e = e4;
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public final List<Pair<zzbr.zzg, Long>> J(String str, int i2, int i3) {
        byte[] V;
        d();
        t();
        Preconditions.a(i2 > 0);
        Preconditions.a(i3 > 0);
        Preconditions.g(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = x().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i2));
                if (!query.moveToFirst()) {
                    List<Pair<zzbr.zzg, Long>> emptyList = Collections.emptyList();
                    query.close();
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                do {
                    long j2 = query.getLong(0);
                    try {
                        V = p().V(query.getBlob(1));
                    } catch (IOException e2) {
                        h().H().c("Failed to unzip queued bundle. appId", zzet.x(str), e2);
                    }
                    if (!arrayList.isEmpty() && V.length + i4 > i3) {
                        break;
                    }
                    try {
                        zzbr.zzg.zza zzaVar = (zzbr.zzg.zza) zzkg.A(zzbr.zzg.R0(), V);
                        if (!query.isNull(2)) {
                            zzaVar.x0(query.getInt(2));
                        }
                        i4 += V.length;
                        arrayList.add(Pair.create((zzbr.zzg) ((zzfd) zzaVar.y()), Long.valueOf(j2)));
                    } catch (IOException e3) {
                        h().H().c("Failed to merge queued bundle. appId", zzet.x(str), e3);
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } while (i4 <= i3);
                query.close();
                return arrayList;
            } catch (SQLiteException e4) {
                h().H().c("Error querying bundles. appId", zzet.x(str), e4);
                List<Pair<zzbr.zzg, Long>> emptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyList2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0098, code lost:
    
        h().H().b("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<m7> K(String str, String str2, String str3) {
        String str4;
        Cursor cursor;
        int i2;
        int i3;
        int i4;
        int i5;
        String str5;
        Preconditions.g(str);
        d();
        t();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            try {
                try {
                    i2 = 3;
                    ArrayList arrayList2 = new ArrayList(3);
                    try {
                        arrayList2.add(str);
                        StringBuilder sb = new StringBuilder("app_id=?");
                        if (TextUtils.isEmpty(str2)) {
                            str4 = str2;
                        } else {
                            str4 = str2;
                            try {
                                arrayList2.add(str4);
                                sb.append(" and origin=?");
                            } catch (SQLiteException e2) {
                                e = e2;
                                cursor = null;
                                h().H().d("(2)Error querying user properties", zzet.x(str), str4, e);
                                if (cursor != null) {
                                }
                                return null;
                            }
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            arrayList2.add(String.valueOf(str3).concat("*"));
                            sb.append(" and name glob ?");
                        }
                        i3 = 0;
                        i4 = 1;
                        i5 = 2;
                        cursor = x().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, sb.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", NativeContentAd.ASSET_HEADLINE);
                    } catch (SQLiteException e3) {
                        e = e3;
                        str4 = str2;
                        cursor = null;
                        h().H().d("(2)Error querying user properties", zzet.x(str), str4, e);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (SQLiteException e4) {
                e = e4;
            }
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        try {
            if (!cursor.moveToFirst()) {
                cursor.close();
                return arrayList;
            }
            while (true) {
                if (arrayList.size() >= 1000) {
                    break;
                }
                String string = cursor.getString(i3);
                long j2 = cursor.getLong(i4);
                try {
                    Object F = F(cursor, i5);
                    String string2 = cursor.getString(i2);
                    if (F == null) {
                        try {
                            h().H().d("(2)Read invalid user property value, ignoring it", zzet.x(str), string2, str3);
                            str5 = string2;
                        } catch (SQLiteException e5) {
                            e = e5;
                            str4 = string2;
                            h().H().d("(2)Error querying user properties", zzet.x(str), str4, e);
                            if (cursor != null) {
                            }
                            return null;
                        }
                    } else {
                        try {
                            str5 = string2;
                            try {
                                arrayList.add(new m7(str, string2, string, j2, F));
                            } catch (SQLiteException e6) {
                                e = e6;
                                str4 = str5;
                                h().H().d("(2)Error querying user properties", zzet.x(str), str4, e);
                                if (cursor != null) {
                                }
                                return null;
                            }
                        } catch (SQLiteException e7) {
                            e = e7;
                            str5 = string2;
                            str4 = str5;
                            h().H().d("(2)Error querying user properties", zzet.x(str), str4, e);
                            if (cursor != null) {
                            }
                            return null;
                        }
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    str4 = str5;
                    i2 = 3;
                    i4 = 1;
                    i5 = 2;
                    i3 = 0;
                } catch (SQLiteException e8) {
                    e = e8;
                }
            }
            cursor.close();
            return arrayList;
        } catch (SQLiteException e9) {
            e = e9;
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:
    
        h().H().b("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<zzv> L(String str, String[] strArr) {
        Cursor cursor;
        d();
        t();
        ArrayList arrayList = new ArrayList();
        try {
            int i2 = 0;
            int i3 = 5;
            Cursor query = x().query("conditional_properties", new String[]{RateAndReviewsFragment.BundleCons.APP_ID, "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", NativeContentAd.ASSET_HEADLINE);
            try {
                if (!query.moveToFirst()) {
                    query.close();
                    return arrayList;
                }
                while (true) {
                    if (arrayList.size() >= 1000) {
                        break;
                    }
                    String string = query.getString(i2);
                    String string2 = query.getString(1);
                    String string3 = query.getString(2);
                    Object F = F(query, 3);
                    boolean z = query.getInt(4) != 0;
                    String string4 = query.getString(i3);
                    long j2 = query.getLong(6);
                    zzkg p = p();
                    byte[] blob = query.getBlob(7);
                    Parcelable.Creator<zzan> creator = zzan.CREATOR;
                    arrayList.add(new zzv(string, string2, new zzkj(string3, query.getLong(10), F, string2), query.getLong(8), z, string4, (zzan) p.y(blob, creator), j2, (zzan) p().y(query.getBlob(9), creator), query.getLong(11), (zzan) p().y(query.getBlob(12), creator)));
                    if (!query.moveToNext()) {
                        break;
                    }
                    i3 = 5;
                    i2 = 0;
                }
                query.close();
                return arrayList;
            } catch (SQLiteException e2) {
                e = e2;
                cursor = query;
                try {
                    h().H().b("Error querying conditional user property value", e);
                    List<zzv> emptyList = Collections.emptyList();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return emptyList;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public final void N(h hVar) {
        Preconditions.k(hVar);
        d();
        t();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, hVar.a);
        contentValues.put("name", hVar.f17784b);
        contentValues.put("lifetime_count", Long.valueOf(hVar.f17785c));
        contentValues.put("current_bundle_count", Long.valueOf(hVar.f17786d));
        contentValues.put("last_fire_timestamp", Long.valueOf(hVar.f17788f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(hVar.f17789g));
        contentValues.put("last_bundled_day", hVar.f17790h);
        contentValues.put("last_sampled_complex_event_id", hVar.f17791i);
        contentValues.put("last_sampling_rate", hVar.f17792j);
        if (n().B(hVar.a, zzap.x0)) {
            contentValues.put("current_session_count", Long.valueOf(hVar.f17787e));
        }
        Boolean bool = hVar.f17793k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (x().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                h().H().b("Failed to insert/update event aggregates (got -1). appId", zzet.x(hVar.a));
            }
        } catch (SQLiteException e2) {
            h().H().c("Error storing event aggregates. appId", zzet.x(hVar.a), e2);
        }
    }

    public final void O(z3 z3Var) {
        Preconditions.k(z3Var);
        d();
        t();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, z3Var.t());
        contentValues.put("app_instance_id", z3Var.x());
        contentValues.put("gmp_app_id", z3Var.A());
        contentValues.put("resettable_device_id_hash", z3Var.J());
        contentValues.put("last_bundle_index", Long.valueOf(z3Var.f0()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(z3Var.P()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(z3Var.R()));
        contentValues.put("app_version", z3Var.T());
        contentValues.put("app_store", z3Var.X());
        contentValues.put("gmp_version", Long.valueOf(z3Var.Z()));
        contentValues.put("dev_cert_hash", Long.valueOf(z3Var.b0()));
        contentValues.put("measurement_enabled", Boolean.valueOf(z3Var.e0()));
        contentValues.put("day", Long.valueOf(z3Var.j0()));
        contentValues.put("daily_public_events_count", Long.valueOf(z3Var.k0()));
        contentValues.put("daily_events_count", Long.valueOf(z3Var.l0()));
        contentValues.put("daily_conversions_count", Long.valueOf(z3Var.m0()));
        contentValues.put("config_fetched_time", Long.valueOf(z3Var.g0()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(z3Var.h0()));
        contentValues.put("app_version_int", Long.valueOf(z3Var.V()));
        contentValues.put("firebase_instance_id", z3Var.M());
        contentValues.put("daily_error_events_count", Long.valueOf(z3Var.h()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(z3Var.g()));
        contentValues.put("health_monitor_sample", z3Var.i());
        contentValues.put("android_id", Long.valueOf(z3Var.k()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(z3Var.l()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(z3Var.m()));
        contentValues.put("admob_app_id", z3Var.D());
        contentValues.put("dynamite_version", Long.valueOf(z3Var.d0()));
        if (z3Var.o() != null) {
            if (z3Var.o().size() == 0) {
                h().K().b("Safelisted events should not be an empty list. appId", z3Var.t());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", z3Var.o()));
            }
        }
        if (zzky.b() && n().B(z3Var.t(), zzap.N0)) {
            contentValues.put("ga_app_id", z3Var.G());
        }
        try {
            SQLiteDatabase x = x();
            if (x.update(DeepLinkIntentReceiver.DeepLinksTargets.APPS, contentValues, "app_id = ?", new String[]{z3Var.t()}) == 0 && x.insertWithOnConflict(DeepLinkIntentReceiver.DeepLinksTargets.APPS, null, contentValues, 5) == -1) {
                h().H().b("Failed to insert/update app (got -1). appId", zzet.x(z3Var.t()));
            }
        } catch (SQLiteException e2) {
            h().H().c("Error storing app. appId", zzet.x(z3Var.t()), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void P(String str, List<zzbj.zza> list) {
        boolean z;
        t();
        d();
        Preconditions.g(str);
        Preconditions.k(list);
        SQLiteDatabase x = x();
        x.beginTransaction();
        try {
            t();
            d();
            Preconditions.g(str);
            SQLiteDatabase x2 = x();
            x2.delete("property_filters", "app_id=?", new String[]{str});
            x2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzbj.zza zzaVar : list) {
                t();
                d();
                Preconditions.g(str);
                Preconditions.k(zzaVar);
                if (!zzaVar.G()) {
                    h().K().b("Audience with no ID. appId", zzet.x(str));
                } else {
                    int H = zzaVar.H();
                    Iterator<zzbj.zzb> it = zzaVar.L().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().G()) {
                                h().K().c("Event filter with no ID. Audience definition ignored. appId, audienceId", zzet.x(str), Integer.valueOf(H));
                                break;
                            }
                        } else {
                            Iterator<zzbj.zze> it2 = zzaVar.J().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().D()) {
                                        h().K().c("Property filter with no ID. Audience definition ignored. appId, audienceId", zzet.x(str), Integer.valueOf(H));
                                        break;
                                    }
                                } else {
                                    Iterator<zzbj.zzb> it3 = zzaVar.L().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!V(str, H, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbj.zze> it4 = zzaVar.J().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!W(str, H, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        t();
                                        d();
                                        Preconditions.g(str);
                                        SQLiteDatabase x3 = x();
                                        x3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(H)});
                                        x3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(H)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbj.zza zzaVar2 : list) {
                arrayList.add(zzaVar2.G() ? Integer.valueOf(zzaVar2.H()) : null);
            }
            p0(str, arrayList);
            x.setTransactionSuccessful();
        } finally {
            x.endTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void Q(List<Long> list) {
        d();
        t();
        Preconditions.k(list);
        Preconditions.m(list.size());
        if (h0()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (i0(sb3.toString(), null) > 0) {
                h().K().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase x = x();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                x.execSQL(sb4.toString());
            } catch (SQLiteException e2) {
                h().H().b("Error incrementing retry count. error", e2);
            }
        }
    }

    public final boolean R(zzbr.zzg zzgVar, boolean z) {
        d();
        t();
        Preconditions.k(zzgVar);
        Preconditions.g(zzgVar.L2());
        Preconditions.n(zzgVar.o2());
        C0();
        long a = j().a();
        if (zzgVar.p2() < a - zzx.N() || zzgVar.p2() > zzx.N() + a) {
            h().K().d("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzet.x(zzgVar.L2()), Long.valueOf(a), Long.valueOf(zzgVar.p2()));
        }
        try {
            byte[] W = p().W(zzgVar.j());
            h().P().b("Saving bundle, size", Integer.valueOf(W.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, zzgVar.L2());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzgVar.p2()));
            contentValues.put("data", W);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzgVar.A0()) {
                contentValues.put("retry_count", Integer.valueOf(zzgVar.N0()));
            }
            try {
                if (x().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                h().H().b("Failed to insert bundle (got -1). appId", zzet.x(zzgVar.L2()));
                return false;
            } catch (SQLiteException e2) {
                h().H().c("Error storing bundle. appId", zzet.x(zzgVar.L2()), e2);
                return false;
            }
        } catch (IOException e3) {
            h().H().c("Data loss. Failed to serialize bundle. appId", zzet.x(zzgVar.L2()), e3);
            return false;
        }
    }

    public final boolean S(zzak zzakVar, long j2, boolean z) {
        d();
        t();
        Preconditions.k(zzakVar);
        Preconditions.g(zzakVar.a);
        zzbr.zzc.zza J = zzbr.zzc.c0().J(zzakVar.f18064e);
        Iterator<String> it = zzakVar.f18065f.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzbr.zze.zza C = zzbr.zze.T().C(next);
            p().J(C, zzakVar.f18065f.W(next));
            J.C(C);
        }
        byte[] j3 = ((zzbr.zzc) ((zzfd) J.y())).j();
        h().P().c("Saving event, name, data size", k().y(zzakVar.f18061b), Integer.valueOf(j3.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, zzakVar.a);
        contentValues.put("name", zzakVar.f18061b);
        contentValues.put("timestamp", Long.valueOf(zzakVar.f18063d));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put("data", j3);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (x().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            h().H().b("Failed to insert raw event (got -1). appId", zzet.x(zzakVar.a));
            return false;
        } catch (SQLiteException e2) {
            h().H().c("Error storing raw event. appId", zzet.x(zzakVar.a), e2);
            return false;
        }
    }

    public final boolean T(m7 m7Var) {
        Preconditions.k(m7Var);
        d();
        t();
        if (o0(m7Var.a, m7Var.f17873c) == null) {
            if (zzkk.Y(m7Var.f17873c)) {
                if (i0("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{m7Var.a}) >= 25) {
                    return false;
                }
            } else if (n().B(m7Var.a, zzap.k0)) {
                if (!"_npa".equals(m7Var.f17873c) && i0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{m7Var.a, m7Var.f17872b}) >= 25) {
                    return false;
                }
            } else if (i0("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{m7Var.a, m7Var.f17872b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, m7Var.a);
        contentValues.put("origin", m7Var.f17872b);
        contentValues.put("name", m7Var.f17873c);
        contentValues.put("set_timestamp", Long.valueOf(m7Var.f17874d));
        M(contentValues, "value", m7Var.f17875e);
        try {
            if (x().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                h().H().b("Failed to insert/update user property (got -1). appId", zzet.x(m7Var.a));
            }
        } catch (SQLiteException e2) {
            h().H().c("Error storing user property. appId", zzet.x(m7Var.a), e2);
        }
        return true;
    }

    public final boolean U(zzv zzvVar) {
        Preconditions.k(zzvVar);
        d();
        t();
        if (o0(zzvVar.f18240f, zzvVar.f18242h.f18224g) == null && i0("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzvVar.f18240f}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, zzvVar.f18240f);
        contentValues.put("origin", zzvVar.f18241g);
        contentValues.put("name", zzvVar.f18242h.f18224g);
        M(contentValues, "value", zzvVar.f18242h.y());
        contentValues.put("active", Boolean.valueOf(zzvVar.f18244j));
        contentValues.put("trigger_event_name", zzvVar.f18245k);
        contentValues.put("trigger_timeout", Long.valueOf(zzvVar.m));
        l();
        contentValues.put("timed_out_event", zzkk.g0(zzvVar.l));
        contentValues.put("creation_timestamp", Long.valueOf(zzvVar.f18243i));
        l();
        contentValues.put("triggered_event", zzkk.g0(zzvVar.n));
        contentValues.put("triggered_timestamp", Long.valueOf(zzvVar.f18242h.f18225h));
        contentValues.put("time_to_live", Long.valueOf(zzvVar.o));
        l();
        contentValues.put("expired_event", zzkk.g0(zzvVar.p));
        try {
            if (x().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                h().H().b("Failed to insert/update conditional user property (got -1)", zzet.x(zzvVar.f18240f));
            }
        } catch (SQLiteException e2) {
            h().H().c("Error storing conditional user property", zzet.x(zzvVar.f18240f), e2);
        }
        return true;
    }

    public final boolean X(String str, Long l, long j2, zzbr.zzc zzcVar) {
        d();
        t();
        Preconditions.k(zzcVar);
        Preconditions.g(str);
        Preconditions.k(l);
        byte[] j3 = zzcVar.j();
        h().P().c("Saving complex main event, appId, data size", k().y(str), Integer.valueOf(j3.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", j3);
        try {
            if (x().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            h().H().b("Failed to insert complex main event (got -1). appId", zzet.x(str));
            return false;
        } catch (SQLiteException e2) {
            h().H().c("Error storing complex main event. appId", zzet.x(str), e2);
            return false;
        }
    }

    public final long Y() {
        Cursor cursor = null;
        try {
            try {
                cursor = x().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return -1L;
                }
                long j2 = cursor.getLong(0);
                cursor.close();
                return j2;
            } catch (SQLiteException e2) {
                h().H().b("Error querying raw events", e2);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01ef A[Catch: SQLiteException -> 0x0267, all -> 0x0290, TryCatch #0 {all -> 0x0290, blocks: (B:14:0x00e8, B:16:0x0145, B:20:0x014f, B:23:0x0199, B:26:0x01cf, B:28:0x01da, B:32:0x01e4, B:34:0x01ef, B:36:0x01f6, B:39:0x0211, B:41:0x021c, B:42:0x022e, B:44:0x0234, B:46:0x0240, B:47:0x0249, B:49:0x0252, B:53:0x020d, B:56:0x01cb, B:57:0x0194, B:60:0x0279), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x021c A[Catch: SQLiteException -> 0x0267, all -> 0x0290, TryCatch #0 {all -> 0x0290, blocks: (B:14:0x00e8, B:16:0x0145, B:20:0x014f, B:23:0x0199, B:26:0x01cf, B:28:0x01da, B:32:0x01e4, B:34:0x01ef, B:36:0x01f6, B:39:0x0211, B:41:0x021c, B:42:0x022e, B:44:0x0234, B:46:0x0240, B:47:0x0249, B:49:0x0252, B:53:0x020d, B:56:0x01cb, B:57:0x0194, B:60:0x0279), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0234 A[Catch: SQLiteException -> 0x0267, all -> 0x0290, TryCatch #0 {all -> 0x0290, blocks: (B:14:0x00e8, B:16:0x0145, B:20:0x014f, B:23:0x0199, B:26:0x01cf, B:28:0x01da, B:32:0x01e4, B:34:0x01ef, B:36:0x01f6, B:39:0x0211, B:41:0x021c, B:42:0x022e, B:44:0x0234, B:46:0x0240, B:47:0x0249, B:49:0x0252, B:53:0x020d, B:56:0x01cb, B:57:0x0194, B:60:0x0279), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0252 A[Catch: SQLiteException -> 0x0267, all -> 0x0290, TRY_LEAVE, TryCatch #0 {all -> 0x0290, blocks: (B:14:0x00e8, B:16:0x0145, B:20:0x014f, B:23:0x0199, B:26:0x01cf, B:28:0x01da, B:32:0x01e4, B:34:0x01ef, B:36:0x01f6, B:39:0x0211, B:41:0x021c, B:42:0x022e, B:44:0x0234, B:46:0x0240, B:47:0x0249, B:49:0x0252, B:53:0x020d, B:56:0x01cb, B:57:0x0194, B:60:0x0279), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x020d A[Catch: SQLiteException -> 0x0267, all -> 0x0290, TryCatch #0 {all -> 0x0290, blocks: (B:14:0x00e8, B:16:0x0145, B:20:0x014f, B:23:0x0199, B:26:0x01cf, B:28:0x01da, B:32:0x01e4, B:34:0x01ef, B:36:0x01f6, B:39:0x0211, B:41:0x021c, B:42:0x022e, B:44:0x0234, B:46:0x0240, B:47:0x0249, B:49:0x0252, B:53:0x020d, B:56:0x01cb, B:57:0x0194, B:60:0x0279), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01cb A[Catch: SQLiteException -> 0x0267, all -> 0x0290, TryCatch #0 {all -> 0x0290, blocks: (B:14:0x00e8, B:16:0x0145, B:20:0x014f, B:23:0x0199, B:26:0x01cf, B:28:0x01da, B:32:0x01e4, B:34:0x01ef, B:36:0x01f6, B:39:0x0211, B:41:0x021c, B:42:0x022e, B:44:0x0234, B:46:0x0240, B:47:0x0249, B:49:0x0252, B:53:0x020d, B:56:0x01cb, B:57:0x0194, B:60:0x0279), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0194 A[Catch: SQLiteException -> 0x0267, all -> 0x0290, TryCatch #0 {all -> 0x0290, blocks: (B:14:0x00e8, B:16:0x0145, B:20:0x014f, B:23:0x0199, B:26:0x01cf, B:28:0x01da, B:32:0x01e4, B:34:0x01ef, B:36:0x01f6, B:39:0x0211, B:41:0x021c, B:42:0x022e, B:44:0x0234, B:46:0x0240, B:47:0x0249, B:49:0x0252, B:53:0x020d, B:56:0x01cb, B:57:0x0194, B:60:0x0279), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0294  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final z3 j0(String str) {
        Cursor cursor;
        boolean z;
        boolean z2;
        Preconditions.g(str);
        d();
        t();
        Cursor cursor2 = null;
        try {
            try {
                cursor = x().query(DeepLinkIntentReceiver.DeepLinksTargets.APPS, new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id"}, "app_id=?", new String[]{str}, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        try {
            if (!cursor.moveToFirst()) {
                cursor.close();
                return null;
            }
            try {
                z3 z3Var = new z3(this.f17811b.g0(), str);
                z3Var.c(cursor.getString(0));
                z3Var.r(cursor.getString(1));
                z3Var.C(cursor.getString(2));
                z3Var.H(cursor.getLong(3));
                z3Var.a(cursor.getLong(4));
                z3Var.q(cursor.getLong(5));
                z3Var.I(cursor.getString(6));
                z3Var.L(cursor.getString(7));
                z3Var.y(cursor.getLong(8));
                z3Var.B(cursor.getLong(9));
                if (!cursor.isNull(10) && cursor.getInt(10) == 0) {
                    z = false;
                    z3Var.e(z);
                    z3Var.Q(cursor.getLong(11));
                    z3Var.S(cursor.getLong(12));
                    z3Var.U(cursor.getLong(13));
                    z3Var.W(cursor.getLong(14));
                    z3Var.K(cursor.getLong(15));
                    z3Var.N(cursor.getLong(16));
                    z3Var.u(!cursor.isNull(17) ? -2147483648L : cursor.getInt(17));
                    z3Var.F(cursor.getString(18));
                    z3Var.a0(cursor.getLong(19));
                    z3Var.Y(cursor.getLong(20));
                    z3Var.O(cursor.getString(21));
                    z3Var.c0(!cursor.isNull(22) ? 0L : cursor.getLong(22));
                    if (!cursor.isNull(23) && cursor.getInt(23) == 0) {
                        z2 = false;
                        z3Var.s(z2);
                        z3Var.w((cursor.isNull(24) && cursor.getInt(24) == 0) ? false : true);
                        z3Var.v(cursor.getString(25));
                        z3Var.E(!cursor.isNull(26) ? 0L : cursor.getLong(26));
                        if (!cursor.isNull(27)) {
                            z3Var.d(Arrays.asList(cursor.getString(27).split(",", -1)));
                        }
                        if (zzky.b() && n().B(str, zzap.N0)) {
                            z3Var.z(cursor.getString(28));
                        }
                        z3Var.p();
                        if (cursor.moveToNext()) {
                            h().H().b("Got multiple records for app, expected one. appId", zzet.x(str));
                        }
                        cursor.close();
                        return z3Var;
                    }
                    z2 = true;
                    z3Var.s(z2);
                    z3Var.w((cursor.isNull(24) && cursor.getInt(24) == 0) ? false : true);
                    z3Var.v(cursor.getString(25));
                    z3Var.E(!cursor.isNull(26) ? 0L : cursor.getLong(26));
                    if (!cursor.isNull(27)) {
                    }
                    if (zzky.b()) {
                        z3Var.z(cursor.getString(28));
                    }
                    z3Var.p();
                    if (cursor.moveToNext()) {
                    }
                    cursor.close();
                    return z3Var;
                }
                z = true;
                z3Var.e(z);
                z3Var.Q(cursor.getLong(11));
                z3Var.S(cursor.getLong(12));
                z3Var.U(cursor.getLong(13));
                z3Var.W(cursor.getLong(14));
                z3Var.K(cursor.getLong(15));
                z3Var.N(cursor.getLong(16));
                z3Var.u(!cursor.isNull(17) ? -2147483648L : cursor.getInt(17));
                z3Var.F(cursor.getString(18));
                z3Var.a0(cursor.getLong(19));
                z3Var.Y(cursor.getLong(20));
                z3Var.O(cursor.getString(21));
                z3Var.c0(!cursor.isNull(22) ? 0L : cursor.getLong(22));
                if (!cursor.isNull(23)) {
                    z2 = false;
                    z3Var.s(z2);
                    z3Var.w((cursor.isNull(24) && cursor.getInt(24) == 0) ? false : true);
                    z3Var.v(cursor.getString(25));
                    z3Var.E(!cursor.isNull(26) ? 0L : cursor.getLong(26));
                    if (!cursor.isNull(27)) {
                    }
                    if (zzky.b()) {
                    }
                    z3Var.p();
                    if (cursor.moveToNext()) {
                    }
                    cursor.close();
                    return z3Var;
                }
                z2 = true;
                z3Var.s(z2);
                z3Var.w((cursor.isNull(24) && cursor.getInt(24) == 0) ? false : true);
                z3Var.v(cursor.getString(25));
                z3Var.E(!cursor.isNull(26) ? 0L : cursor.getLong(26));
                if (!cursor.isNull(27)) {
                }
                if (zzky.b()) {
                }
                z3Var.p();
                if (cursor.moveToNext()) {
                }
                cursor.close();
                return z3Var;
            } catch (SQLiteException e3) {
                e = e3;
                h().H().c("Error querying app. appId", zzet.x(str), e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
        } catch (SQLiteException e4) {
            e = e4;
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public final List<zzv> k0(String str, String str2, String str3) {
        Preconditions.g(str);
        d();
        t();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return L(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Integer, List<Integer>> l0(String str, List<String> list) {
        Cursor cursor;
        t();
        d();
        Preconditions.g(str);
        Preconditions.k(list);
        c.e.a aVar = new c.e.a();
        if (list.isEmpty()) {
            return aVar;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("app_id=? AND property_name in (");
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 > 0) {
                sb.append(",");
            }
            sb.append("?");
        }
        sb.append(")");
        ArrayList arrayList = new ArrayList(list);
        arrayList.add(0, str);
        Cursor cursor2 = null;
        try {
            cursor = x().query("property_filters", new String[]{"audience_id", "filter_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
            try {
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return aVar;
                    }
                    do {
                        int i3 = cursor.getInt(0);
                        List list2 = (List) aVar.get(Integer.valueOf(i3));
                        if (list2 == null) {
                            list2 = new ArrayList();
                            aVar.put(Integer.valueOf(i3), list2);
                        }
                        list2.add(Integer.valueOf(cursor.getInt(1)));
                    } while (cursor.moveToNext());
                    cursor.close();
                    return aVar;
                } catch (SQLiteException e2) {
                    e = e2;
                    h().H().c("Database error querying filters. appId", zzet.x(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public final void m0(String str, String str2) {
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        t();
        try {
            h().P().b("Deleted user attribute rows", Integer.valueOf(x().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e2) {
            h().H().d("Error deleting user attribute. appId", zzet.x(str), k().B(str2), e2);
        }
    }

    public final long n0(String str) {
        Preconditions.g(str);
        d();
        t();
        try {
            return x().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, n().t(str, zzap.w))))});
        } catch (SQLiteException e2) {
            h().H().c("Error deleting over the limit events. appId", zzet.x(str), e2);
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final m7 o0(String str, String str2) {
        Cursor cursor;
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        t();
        Cursor cursor2 = null;
        try {
            try {
                cursor = x().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        try {
            if (!cursor.moveToFirst()) {
                cursor.close();
                return null;
            }
            try {
                m7 m7Var = new m7(str, cursor.getString(2), str2, cursor.getLong(0), F(cursor, 1));
                if (cursor.moveToNext()) {
                    h().H().b("Got multiple records for user property, expected one. appId", zzet.x(str));
                }
                cursor.close();
                return m7Var;
            } catch (SQLiteException e3) {
                e = e3;
                h().H().d("Error querying user property. appId", zzet.x(str), k().B(str2), e);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
        } catch (SQLiteException e4) {
            e = e4;
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzv q0(String str, String str2) {
        Cursor cursor;
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        t();
        Cursor cursor2 = null;
        try {
            cursor = x().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
        } catch (SQLiteException e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th) {
            th = th;
            if (cursor2 != null) {
            }
            throw th;
        }
        try {
            if (!cursor.moveToFirst()) {
                cursor.close();
                return null;
            }
            String string = cursor.getString(0);
            try {
                try {
                    Object F = F(cursor, 1);
                    boolean z = cursor.getInt(2) != 0;
                    String string2 = cursor.getString(3);
                    long j2 = cursor.getLong(4);
                    zzkg p = p();
                    byte[] blob = cursor.getBlob(5);
                    Parcelable.Creator<zzan> creator = zzan.CREATOR;
                    zzv zzvVar = new zzv(str, string, new zzkj(str2, cursor.getLong(8), F, string), cursor.getLong(6), z, string2, (zzan) p.y(blob, creator), j2, (zzan) p().y(cursor.getBlob(7), creator), cursor.getLong(9), (zzan) p().y(cursor.getBlob(10), creator));
                    if (cursor.moveToNext()) {
                        h().H().c("Got multiple records for conditional property, expected one", zzet.x(str), k().B(str2));
                    }
                    cursor.close();
                    return zzvVar;
                } catch (SQLiteException e3) {
                    e = e3;
                    h().H().d("Error querying conditional property", zzet.x(str), k().B(str2), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
        } catch (Throwable th3) {
            th = th3;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0072: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:23:0x0072 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] r0(String str) {
        Cursor cursor;
        Cursor cursor2;
        Preconditions.g(str);
        d();
        t();
        Cursor cursor3 = null;
        try {
            try {
                cursor = x().query(DeepLinkIntentReceiver.DeepLinksTargets.APPS, new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    byte[] blob = cursor.getBlob(0);
                    if (cursor.moveToNext()) {
                        h().H().b("Got multiple records for app config, expected one. appId", zzet.x(str));
                    }
                    cursor.close();
                    return blob;
                } catch (SQLiteException e2) {
                    e = e2;
                    h().H().c("Error querying remote config. appId", zzet.x(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor3 = cursor2;
                if (cursor3 != null) {
                    cursor3.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor3 != null) {
            }
            throw th;
        }
    }

    public final int s0(String str, String str2) {
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        t();
        try {
            return x().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            h().H().d("Error deleting conditional property", zzet.x(str), k().B(str2), e2);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Integer, List<Integer>> t0(String str) {
        Cursor cursor;
        t();
        d();
        Preconditions.g(str);
        c.e.a aVar = new c.e.a();
        SQLiteDatabase x = x();
        ?? r2 = 0;
        try {
            try {
                cursor = x.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                try {
                    if (!cursor.moveToFirst()) {
                        Map<Integer, List<Integer>> emptyMap = Collections.emptyMap();
                        cursor.close();
                        return emptyMap;
                    }
                    do {
                        int i2 = cursor.getInt(0);
                        List list = (List) aVar.get(Integer.valueOf(i2));
                        if (list == null) {
                            list = new ArrayList();
                            aVar.put(Integer.valueOf(i2), list);
                        }
                        list.add(Integer.valueOf(cursor.getInt(1)));
                    } while (cursor.moveToNext());
                    cursor.close();
                    return aVar;
                } catch (SQLiteException e2) {
                    e = e2;
                    h().H().c("Database error querying scoped filters. appId", zzet.x(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r2 = x;
                if (r2 != 0) {
                    r2.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (r2 != 0) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009c  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Integer, zzbr.zzi> u0(String str) {
        Cursor cursor;
        t();
        d();
        Preconditions.g(str);
        SQLiteDatabase x = x();
        ?? r8 = 0;
        try {
            try {
                cursor = x.query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    c.e.a aVar = new c.e.a();
                    do {
                        int i2 = cursor.getInt(0);
                        try {
                            aVar.put(Integer.valueOf(i2), (zzbr.zzi) ((zzfd) ((zzbr.zzi.zza) zzkg.A(zzbr.zzi.a0(), cursor.getBlob(1))).y()));
                        } catch (IOException e2) {
                            h().H().d("Failed to merge filter results. appId, audienceId, error", zzet.x(str), Integer.valueOf(i2), e2);
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                    return aVar;
                } catch (SQLiteException e3) {
                    e = e3;
                    h().H().c("Database error querying filter results. appId", zzet.x(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r8 = x;
                if (r8 != 0) {
                    r8.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (r8 != 0) {
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.measurement.internal.f7
    protected final boolean v() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Integer, List<zzbj.zzb>> v0(String str, String str2) {
        Cursor cursor;
        t();
        d();
        Preconditions.g(str);
        Preconditions.g(str2);
        c.e.a aVar = new c.e.a();
        ?? r9 = 0;
        try {
            try {
                cursor = x().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursor.moveToFirst()) {
                        Map<Integer, List<zzbj.zzb>> emptyMap = Collections.emptyMap();
                        cursor.close();
                        return emptyMap;
                    }
                    do {
                        try {
                            zzbj.zzb zzbVar = (zzbj.zzb) ((zzfd) ((zzbj.zzb.zza) zzkg.A(zzbj.zzb.R(), cursor.getBlob(1))).y());
                            int i2 = cursor.getInt(0);
                            List list = (List) aVar.get(Integer.valueOf(i2));
                            if (list == null) {
                                list = new ArrayList();
                                aVar.put(Integer.valueOf(i2), list);
                            }
                            list.add(zzbVar);
                        } catch (IOException e2) {
                            h().H().c("Failed to merge filter. appId", zzet.x(str), e2);
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                    return aVar;
                } catch (SQLiteException e3) {
                    e = e3;
                    h().H().c("Database error querying filters. appId", zzet.x(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r9 = str2;
                if (r9 != 0) {
                    r9.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (r9 != 0) {
            }
            throw th;
        }
    }

    public final void w() {
        t();
        x().setTransactionSuccessful();
    }

    public final void w0() {
        t();
        x().beginTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final SQLiteDatabase x() {
        d();
        try {
            return this.l.getWritableDatabase();
        } catch (SQLiteException e2) {
            h().K().b("Error opening database", e2);
            throw e2;
        }
    }

    public final long x0(String str) {
        Preconditions.g(str);
        return A("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String y() {
        Throwable th;
        Cursor cursor;
        ?? x = x();
        try {
            try {
                cursor = x.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(0);
                        cursor.close();
                        return string;
                    }
                    cursor.close();
                    return null;
                } catch (SQLiteException e2) {
                    e = e2;
                    h().H().b("Database error getting next bundle app id", e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (x != 0) {
                    x.close();
                }
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            x = 0;
            if (x != 0) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Integer, List<zzbj.zze>> y0(String str, String str2) {
        Cursor cursor;
        t();
        d();
        Preconditions.g(str);
        Preconditions.g(str2);
        c.e.a aVar = new c.e.a();
        ?? r9 = 0;
        try {
            try {
                cursor = x().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursor.moveToFirst()) {
                        Map<Integer, List<zzbj.zze>> emptyMap = Collections.emptyMap();
                        cursor.close();
                        return emptyMap;
                    }
                    do {
                        try {
                            zzbj.zze zzeVar = (zzbj.zze) ((zzfd) ((zzbj.zze.zza) zzkg.A(zzbj.zze.L(), cursor.getBlob(1))).y());
                            int i2 = cursor.getInt(0);
                            List list = (List) aVar.get(Integer.valueOf(i2));
                            if (list == null) {
                                list = new ArrayList();
                                aVar.put(Integer.valueOf(i2), list);
                            }
                            list.add(zzeVar);
                        } catch (IOException e2) {
                            h().H().c("Failed to merge filter", zzet.x(str), e2);
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                    return aVar;
                } catch (SQLiteException e3) {
                    e = e3;
                    h().H().c("Database error querying filters. appId", zzet.x(str), e);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                r9 = str2;
                if (r9 != 0) {
                    r9.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            if (r9 != 0) {
            }
            throw th;
        }
    }

    public final long z(zzbr.zzg zzgVar) throws IOException {
        d();
        t();
        Preconditions.k(zzgVar);
        Preconditions.g(zzgVar.L2());
        byte[] j2 = zzgVar.j();
        long x = p().x(j2);
        ContentValues contentValues = new ContentValues();
        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, zzgVar.L2());
        contentValues.put("metadata_fingerprint", Long.valueOf(x));
        contentValues.put("metadata", j2);
        try {
            x().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return x;
        } catch (SQLiteException e2) {
            h().H().c("Error storing raw event metadata. appId", zzet.x(zzgVar.L2()), e2);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final long z0(String str, String str2) {
        long A;
        Preconditions.g(str);
        Preconditions.g(str2);
        d();
        t();
        SQLiteDatabase x = x();
        x.beginTransaction();
        long j2 = 0;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str2);
            sb.append(" from app2 where app_id=?");
            try {
                try {
                    A = A(sb.toString(), new String[]{str}, -1L);
                    if (A == -1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(RateAndReviewsFragment.BundleCons.APP_ID, str);
                        contentValues.put("first_open_count", (Integer) 0);
                        contentValues.put("previous_install_count", (Integer) 0);
                        if (x.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                            h().H().c("Failed to insert column (got -1). appId", zzet.x(str), str2);
                            x.endTransaction();
                            return -1L;
                        }
                        A = 0;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put(RateAndReviewsFragment.BundleCons.APP_ID, str);
                    contentValues2.put(str2, Long.valueOf(1 + A));
                    if (x.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        h().H().c("Failed to update column (got 0). appId", zzet.x(str), str2);
                        x.endTransaction();
                        return -1L;
                    }
                    x.setTransactionSuccessful();
                    x.endTransaction();
                    return A;
                } catch (SQLiteException e3) {
                    e = e3;
                    j2 = A;
                    h().H().d("Error inserting column. appId", zzet.x(str), str2, e);
                    x.endTransaction();
                    return j2;
                }
            } catch (Throwable th) {
                th = th;
                x.endTransaction();
                throw th;
            }
        } catch (SQLiteException e4) {
            e = e4;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
