package io.sentry.android.core.internal.threaddump;

import io.sentry.protocol.u;
import io.sentry.protocol.v;
import io.sentry.protocol.w;
import io.sentry.s4;
import io.sentry.t4;
import io.sentry.x4;
import io.sentry.z4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;

/* compiled from: ThreadDumpParser.java */
/* loaded from: classes2.dex */
public class c {
    private static final Pattern a = Pattern.compile("\"(.*)\" (.*) ?prio=(\\d+)\\s+tid=(\\d+)\\s*(.*)");

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f22167b = Pattern.compile("\"(.*)\" (.*) ?sysTid=(\\d+)");

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f22168c = Pattern.compile(" *(?:native: )?#\\d+ \\S+ [0-9a-fA-F]+\\s+(.*?)\\s+\\((.*)\\+(\\d+)\\)(?: \\(.*\\))?");

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f22169d = Pattern.compile(" *(?:native: )?#\\d+ \\S+ [0-9a-fA-F]+\\s+(.*)\\s*\\(?(.*)\\)?(?: \\(.*\\))?");

    /* renamed from: e, reason: collision with root package name */
    private static final Pattern f22170e = Pattern.compile(" *at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\((.*):([\\d-]+)\\)");

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f22171f = Pattern.compile(" *at (?:(.+)\\.)?([^.]+)\\.([^.]+)\\(Native method\\)");

    /* renamed from: g, reason: collision with root package name */
    private static final Pattern f22172g = Pattern.compile(" *- locked \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f22173h = Pattern.compile(" *- sleeping on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");

    /* renamed from: i, reason: collision with root package name */
    private static final Pattern f22174i = Pattern.compile(" *- waiting on \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f22175j = Pattern.compile(" *- waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)");

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f22176k = Pattern.compile(" *- waiting to lock \\<([0x0-9a-fA-F]{1,16})\\> \\(a (?:(.+)\\.)?([^.]+)\\)(?: held by thread (\\d+))");
    private static final Pattern l = Pattern.compile(" *- waiting to lock an unknown object");
    private static final Pattern m = Pattern.compile("\\s+");
    private final x4 n;
    private final boolean o;
    private final z4 p;

    public c(x4 x4Var, boolean z) {
        this.n = x4Var;
        this.o = z;
        this.p = new z4(x4Var);
    }

    private void a(w wVar, t4 t4Var) {
        Map<String, t4> k2 = wVar.k();
        if (k2 == null) {
            k2 = new HashMap<>();
        }
        t4 t4Var2 = k2.get(t4Var.f());
        if (t4Var2 != null) {
            t4Var2.l(Math.max(t4Var2.g(), t4Var.g()));
        } else {
            k2.put(t4Var.f(), new t4(t4Var));
        }
        wVar.t(k2);
    }

    private Integer b(Matcher matcher, int i2, Integer num) {
        String group = matcher.group(i2);
        return (group == null || group.length() == 0) ? num : Integer.valueOf(Integer.parseInt(group));
    }

    private Long c(Matcher matcher, int i2, Long l2) {
        String group = matcher.group(i2);
        return (group == null || group.length() == 0) ? l2 : Long.valueOf(Long.parseLong(group));
    }

    private Integer d(Matcher matcher, int i2, Integer num) {
        String group = matcher.group(i2);
        if (group == null || group.length() == 0) {
            return num;
        }
        Integer valueOf = Integer.valueOf(Integer.parseInt(group));
        return valueOf.intValue() >= 0 ? valueOf : num;
    }

    private boolean e(Matcher matcher, String str) {
        matcher.reset(str);
        return matcher.matches();
    }

    private v g(b bVar, w wVar) {
        Matcher matcher;
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = f22168c.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        Matcher matcher3 = f22169d.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        Matcher matcher4 = f22170e.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        Matcher matcher5 = f22171f.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        Matcher matcher6 = f22172g.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        Matcher matcher7 = f22174i.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        Matcher matcher8 = f22173h.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        Matcher matcher9 = f22176k.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        Matcher matcher10 = f22175j.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        Matcher matcher11 = l.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        Matcher matcher12 = m.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        u uVar = null;
        while (true) {
            if (!bVar.a()) {
                break;
            }
            a b2 = bVar.b();
            Matcher matcher13 = matcher12;
            if (b2 == null) {
                this.n.getLogger().c(s4.WARNING, "Internal error while parsing thread dump.", new Object[0]);
                break;
            }
            String str = b2.f22163b;
            if (e(matcher2, str)) {
                u uVar2 = new u();
                uVar2.y(matcher2.group(1));
                uVar2.s(matcher2.group(2));
                uVar2.u(b(matcher2, 3, null));
                arrayList.add(uVar2);
            } else if (e(matcher3, str)) {
                u uVar3 = new u();
                uVar3.y(matcher3.group(1));
                uVar3.s(matcher3.group(2));
                arrayList.add(uVar3);
            } else {
                matcher = matcher2;
                if (e(matcher4, str)) {
                    uVar = new u();
                    String format = String.format("%s.%s", matcher4.group(1), matcher4.group(2));
                    uVar.w(format);
                    uVar.s(matcher4.group(3));
                    uVar.r(matcher4.group(4));
                    uVar.u(d(matcher4, 5, null));
                    uVar.t(this.p.b(format));
                    arrayList.add(uVar);
                } else if (e(matcher5, str)) {
                    uVar = new u();
                    String format2 = String.format("%s.%s", matcher5.group(1), matcher5.group(2));
                    uVar.w(format2);
                    uVar.s(matcher5.group(3));
                    uVar.t(this.p.b(format2));
                    arrayList.add(uVar);
                } else if (e(matcher6, str)) {
                    if (uVar != null) {
                        t4 t4Var = new t4();
                        t4Var.l(1);
                        t4Var.h(matcher6.group(1));
                        t4Var.j(matcher6.group(2));
                        t4Var.i(matcher6.group(3));
                        uVar.v(t4Var);
                        a(wVar, t4Var);
                    }
                } else if (e(matcher7, str)) {
                    if (uVar != null) {
                        t4 t4Var2 = new t4();
                        t4Var2.l(2);
                        t4Var2.h(matcher7.group(1));
                        t4Var2.j(matcher7.group(2));
                        t4Var2.i(matcher7.group(3));
                        uVar.v(t4Var2);
                        a(wVar, t4Var2);
                    }
                } else if (!e(matcher8, str)) {
                    if (!e(matcher9, str)) {
                        if (!e(matcher10, str)) {
                            if (!e(matcher11, str)) {
                                if (str.length() == 0) {
                                    break;
                                }
                                matcher12 = matcher13;
                                if (e(matcher12, str)) {
                                    break;
                                }
                                matcher2 = matcher;
                            } else if (uVar != null) {
                                t4 t4Var3 = new t4();
                                t4Var3.l(8);
                                uVar.v(t4Var3);
                                a(wVar, t4Var3);
                            }
                        } else if (uVar != null) {
                            t4 t4Var4 = new t4();
                            t4Var4.l(8);
                            t4Var4.h(matcher10.group(1));
                            t4Var4.j(matcher10.group(2));
                            t4Var4.i(matcher10.group(3));
                            uVar.v(t4Var4);
                            a(wVar, t4Var4);
                        }
                    } else if (uVar != null) {
                        t4 t4Var5 = new t4();
                        t4Var5.l(8);
                        t4Var5.h(matcher9.group(1));
                        t4Var5.j(matcher9.group(2));
                        t4Var5.i(matcher9.group(3));
                        t4Var5.k(c(matcher9, 4, null));
                        uVar.v(t4Var5);
                        a(wVar, t4Var5);
                    }
                    matcher12 = matcher13;
                    matcher2 = matcher;
                } else if (uVar != null) {
                    t4 t4Var6 = new t4();
                    t4Var6.l(4);
                    t4Var6.h(matcher8.group(1));
                    t4Var6.j(matcher8.group(2));
                    t4Var6.i(matcher8.group(3));
                    uVar.v(t4Var6);
                    a(wVar, t4Var6);
                }
                matcher12 = matcher13;
                matcher2 = matcher;
            }
            matcher = matcher2;
            matcher12 = matcher13;
            uVar = null;
            matcher2 = matcher;
        }
        Collections.reverse(arrayList);
        v vVar = new v(arrayList);
        vVar.e(Boolean.TRUE);
        return vVar;
    }

    private w h(b bVar) {
        w wVar = new w();
        Matcher matcher = a.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        Matcher matcher2 = f22167b.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        if (!bVar.a()) {
            return null;
        }
        a b2 = bVar.b();
        boolean z = false;
        if (b2 == null) {
            this.n.getLogger().c(s4.WARNING, "Internal error while parsing thread dump.", new Object[0]);
            return null;
        }
        if (e(matcher, b2.f22163b)) {
            Long c2 = c(matcher, 4, null);
            if (c2 == null) {
                this.n.getLogger().c(s4.DEBUG, "No thread id in the dump, skipping thread.", new Object[0]);
                return null;
            }
            wVar.u(c2);
            wVar.w(matcher.group(1));
            String group = matcher.group(5);
            if (group != null) {
                if (group.contains(" ")) {
                    wVar.z(group.substring(0, group.indexOf(32)));
                } else {
                    wVar.z(group);
                }
            }
        } else if (e(matcher2, b2.f22163b)) {
            Long c3 = c(matcher2, 3, null);
            if (c3 == null) {
                this.n.getLogger().c(s4.DEBUG, "No thread id in the dump, skipping thread.", new Object[0]);
                return null;
            }
            wVar.u(c3);
            wVar.w(matcher2.group(1));
        }
        String m2 = wVar.m();
        if (m2 != null) {
            boolean equals = m2.equals("main");
            wVar.v(Boolean.valueOf(equals));
            wVar.q(Boolean.valueOf(equals));
            if (equals && !this.o) {
                z = true;
            }
            wVar.r(Boolean.valueOf(z));
        }
        wVar.y(g(bVar, wVar));
        return wVar;
    }

    public List<w> f(b bVar) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = a.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        Matcher matcher2 = f22167b.matcher(HttpUrl.FRAGMENT_ENCODE_SET);
        while (bVar.a()) {
            a b2 = bVar.b();
            if (b2 == null) {
                this.n.getLogger().c(s4.WARNING, "Internal error while parsing thread dump.", new Object[0]);
                return arrayList;
            }
            String str = b2.f22163b;
            if (e(matcher, str) || e(matcher2, str)) {
                bVar.d();
                w h2 = h(bVar);
                if (h2 != null) {
                    arrayList.add(h2);
                }
            }
        }
        return arrayList;
    }
}
