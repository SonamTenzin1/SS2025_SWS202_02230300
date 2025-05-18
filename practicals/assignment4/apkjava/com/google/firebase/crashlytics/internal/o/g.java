package com.google.firebase.crashlytics.internal.o;

import cm.aptoide.pt.account.AndroidAccountManagerPersistence;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.n.t;
import com.google.firebase.crashlytics.internal.r.f;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MetaDataStore.java */
/* loaded from: classes2.dex */
public class g {
    private static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b, reason: collision with root package name */
    private final f f19155b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MetaDataStore.java */
    /* loaded from: classes2.dex */
    public class a extends JSONObject {
        final /* synthetic */ String a;

        a(String str) throws JSONException {
            this.a = str;
            put(AndroidAccountManagerPersistence.ACCOUNT_ID, str);
        }
    }

    public g(f fVar) {
        this.f19155b = fVar;
    }

    private static Map<String, String> e(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, o(jSONObject, next));
        }
        return hashMap;
    }

    private static List<j> f(String str) throws JSONException {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String string = jSONArray.getString(i2);
            try {
                arrayList.add(j.a(string));
            } catch (Exception e2) {
                h.f().l("Failed de-serializing rollouts state. " + string, e2);
            }
        }
        return arrayList;
    }

    private String g(String str) throws JSONException {
        return o(new JSONObject(str), AndroidAccountManagerPersistence.ACCOUNT_ID);
    }

    private static String h(Map<String, String> map) {
        return new JSONObject(map).toString();
    }

    private static String l(List<j> list) {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                jSONArray.put(new JSONObject(j.a.b(list.get(i2))));
            } catch (JSONException e2) {
                h.f().l("Exception parsing rollout assignment!", e2);
            }
        }
        hashMap.put("rolloutsState", jSONArray);
        return new JSONObject(hashMap).toString();
    }

    private static void m(File file) {
        if (file.exists() && file.delete()) {
            h.f().g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    private static String n(String str) throws JSONException {
        return new a(str).toString();
    }

    private static String o(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    public File a(String str) {
        return this.f19155b.o(str, "internal-keys");
    }

    public File b(String str) {
        return this.f19155b.o(str, "keys");
    }

    public File c(String str) {
        return this.f19155b.o(str, "rollouts-state");
    }

    public File d(String str) {
        return this.f19155b.o(str, "user-data");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> i(String str, boolean z) {
        FileInputStream fileInputStream;
        Exception e2;
        File a2 = z ? a(str) : b(str);
        if (a2.exists() && a2.length() != 0) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(a2);
                try {
                    try {
                        Map<String, String> e3 = e(t.A(fileInputStream));
                        t.f(fileInputStream, "Failed to close user metadata file.");
                        return e3;
                    } catch (Exception e4) {
                        e2 = e4;
                        h.f().l("Error deserializing user metadata.", e2);
                        m(a2);
                        t.f(fileInputStream, "Failed to close user metadata file.");
                        return Collections.emptyMap();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    t.f(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e5) {
                fileInputStream = null;
                e2 = e5;
            } catch (Throwable th2) {
                th = th2;
                t.f(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } else {
            m(a2);
            return Collections.emptyMap();
        }
    }

    public List<j> j(String str) {
        FileInputStream fileInputStream;
        File c2 = c(str);
        if (c2.exists() && c2.length() != 0) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(c2);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                List<j> f2 = f(t.A(fileInputStream));
                h.f().b("Loaded rollouts state:\n" + f2 + "\nfor session " + str);
                t.f(fileInputStream, "Failed to close rollouts state file.");
                return f2;
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                h.f().l("Error deserializing rollouts state.", e);
                m(c2);
                t.f(fileInputStream2, "Failed to close rollouts state file.");
                return Collections.emptyList();
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                t.f(fileInputStream2, "Failed to close rollouts state file.");
                throw th;
            }
        }
        m(c2);
        return Collections.emptyList();
    }

    public String k(String str) {
        FileInputStream fileInputStream;
        File d2 = d(str);
        FileInputStream fileInputStream2 = null;
        if (d2.exists() && d2.length() != 0) {
            try {
                fileInputStream = new FileInputStream(d2);
                try {
                    try {
                        String g2 = g(t.A(fileInputStream));
                        h.f().b("Loaded userId " + g2 + " for session " + str);
                        t.f(fileInputStream, "Failed to close user metadata file.");
                        return g2;
                    } catch (Exception e2) {
                        e = e2;
                        h.f().l("Error deserializing user metadata.", e);
                        m(d2);
                        t.f(fileInputStream, "Failed to close user metadata file.");
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    t.f(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                t.f(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
        } else {
            h.f().b("No userId set for session " + str);
            m(d2);
            return null;
        }
    }

    public void p(String str, Map<String, String> map) {
        q(str, map, false);
    }

    public void q(String str, Map<String, String> map, boolean z) {
        String h2;
        BufferedWriter bufferedWriter;
        File a2 = z ? a(str) : b(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                h2 = h(map);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(a2), a));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            bufferedWriter.write(h2);
            bufferedWriter.flush();
            t.f(bufferedWriter, "Failed to close key/value metadata file.");
        } catch (Exception e3) {
            e = e3;
            bufferedWriter2 = bufferedWriter;
            h.f().l("Error serializing key/value metadata.", e);
            m(a2);
            t.f(bufferedWriter2, "Failed to close key/value metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            t.f(bufferedWriter2, "Failed to close key/value metadata file.");
            throw th;
        }
    }

    public void r(String str, List<j> list) {
        String l;
        BufferedWriter bufferedWriter;
        File c2 = c(str);
        if (list.isEmpty()) {
            m(c2);
            return;
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                l = l(list);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c2), a));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            bufferedWriter.write(l);
            bufferedWriter.flush();
            t.f(bufferedWriter, "Failed to close rollouts state file.");
        } catch (Exception e3) {
            e = e3;
            bufferedWriter2 = bufferedWriter;
            h.f().l("Error serializing rollouts state.", e);
            m(c2);
            t.f(bufferedWriter2, "Failed to close rollouts state file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            t.f(bufferedWriter2, "Failed to close rollouts state file.");
            throw th;
        }
    }

    public void s(String str, String str2) {
        String n;
        BufferedWriter bufferedWriter;
        File d2 = d(str);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                n = n(str2);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d2), a));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write(n);
            bufferedWriter.flush();
            t.f(bufferedWriter, "Failed to close user metadata file.");
        } catch (Exception e3) {
            e = e3;
            bufferedWriter2 = bufferedWriter;
            h.f().l("Error serializing user metadata.", e);
            t.f(bufferedWriter2, "Failed to close user metadata file.");
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            t.f(bufferedWriter2, "Failed to close user metadata file.");
            throw th;
        }
    }
}
