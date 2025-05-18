package androidx.core.app;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import okhttp3.HttpUrl;

/* compiled from: Person.java */
/* loaded from: classes.dex */
public class m {
    CharSequence a;

    /* renamed from: b, reason: collision with root package name */
    IconCompat f929b;

    /* renamed from: c, reason: collision with root package name */
    String f930c;

    /* renamed from: d, reason: collision with root package name */
    String f931d;

    /* renamed from: e, reason: collision with root package name */
    boolean f932e;

    /* renamed from: f, reason: collision with root package name */
    boolean f933f;

    public IconCompat a() {
        return this.f929b;
    }

    public String b() {
        return this.f931d;
    }

    public CharSequence c() {
        return this.a;
    }

    public String d() {
        return this.f930c;
    }

    public boolean e() {
        return this.f932e;
    }

    public boolean f() {
        return this.f933f;
    }

    public String g() {
        String str = this.f930c;
        if (str != null) {
            return str;
        }
        if (this.a == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return "name:" + ((Object) this.a);
    }

    public Person h() {
        return new Person.Builder().setName(c()).setIcon(a() != null ? a().p() : null).setUri(d()).setKey(b()).setBot(e()).setImportant(f()).build();
    }
}
