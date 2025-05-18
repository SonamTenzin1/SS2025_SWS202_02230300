package com.google.gson.t.n;

import com.google.gson.JsonSyntaxException;
import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* compiled from: SqlDateTypeAdapter.java */
/* loaded from: classes2.dex */
public final class j extends q<Date> {
    public static final r a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final DateFormat f20255b = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter.java */
    /* loaded from: classes2.dex */
    static class a implements r {
        a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> b(com.google.gson.e eVar, com.google.gson.u.a<T> aVar) {
            if (aVar.getRawType() == Date.class) {
                return new j();
            }
            return null;
        }
    }

    @Override // com.google.gson.q
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized Date b(com.google.gson.stream.a aVar) throws IOException {
        if (aVar.Q() == com.google.gson.stream.b.NULL) {
            aVar.I();
            return null;
        }
        try {
            return new Date(this.f20255b.parse(aVar.K()).getTime());
        } catch (ParseException e2) {
            throw new JsonSyntaxException(e2);
        }
    }

    @Override // com.google.gson.q
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized void d(com.google.gson.stream.c cVar, Date date) throws IOException {
        cVar.Y(date == null ? null : this.f20255b.format((java.util.Date) date));
    }
}
