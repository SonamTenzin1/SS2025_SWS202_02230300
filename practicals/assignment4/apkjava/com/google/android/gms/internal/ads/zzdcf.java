package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdha;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzdcf {
    private static final Logger a = Logger.getLogger(zzdcf.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentMap<String, zzdbs> f15866b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final ConcurrentMap<String, Boolean> f15867c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private static final ConcurrentMap<String, zzdbk> f15868d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private static final ConcurrentMap<Class<?>, zzdcc<?>> f15869e = new ConcurrentHashMap();

    private static <T> T a(T t) {
        t.getClass();
        return t;
    }

    private static <P> zzdbs<P> b(String str, Class<P> cls) throws GeneralSecurityException {
        zzdbs<P> zzdbsVar = f15866b.get(str);
        if (zzdbsVar != null) {
            if (cls == null || zzdbsVar.a().equals(cls)) {
                return zzdbsVar;
            }
            String name = zzdbsVar.a().getName();
            String name2 = cls.getName();
            StringBuilder sb = new StringBuilder(name.length() + 80 + String.valueOf(str).length() + name2.length());
            sb.append("Primitive type ");
            sb.append(name);
            sb.append(" of keymanager for type ");
            sb.append(str);
            sb.append(" does not match requested primitive type ");
            sb.append(name2);
            throw new GeneralSecurityException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 78);
        sb2.append("No key manager found for key type: ");
        sb2.append(str);
        sb2.append(".  Check the configuration of the registry.");
        throw new GeneralSecurityException(sb2.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <P> zzdca<P> c(zzdbu zzdbuVar, zzdbs<P> zzdbsVar, Class<P> cls) throws GeneralSecurityException {
        Class cls2 = (Class) a(cls);
        cr.b(zzdbuVar.b());
        zzdca<P> zzdcaVar = (zzdca<P>) zzdca.a(cls2);
        for (zzdha.zzb zzbVar : zzdbuVar.b().y()) {
            if (zzbVar.A() == zzdgu.ENABLED) {
                zzdcb b2 = zzdcaVar.b(g(zzbVar.z().B(), zzbVar.z().C(), cls2), zzbVar);
                if (zzbVar.B() == zzdbuVar.b().x()) {
                    zzdcaVar.c(b2);
                }
            }
        }
        return zzdcaVar;
    }

    public static synchronized zzdgr d(zzdgw zzdgwVar) throws GeneralSecurityException {
        zzdgr e2;
        synchronized (zzdcf.class) {
            zzdbs b2 = b(zzdgwVar.x(), null);
            if (f15867c.get(zzdgwVar.x()).booleanValue()) {
                e2 = b2.e(zzdgwVar.y());
            } else {
                String valueOf = String.valueOf(zzdgwVar.x());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return e2;
    }

    public static synchronized zzdpk e(String str, zzdpk zzdpkVar) throws GeneralSecurityException {
        zzdpk c2;
        synchronized (zzdcf.class) {
            zzdbs b2 = b(str, null);
            if (f15867c.get(str).booleanValue()) {
                c2 = b2.c(zzdpkVar);
            } else {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return c2;
    }

    public static <P> P f(zzdca<P> zzdcaVar) throws GeneralSecurityException {
        zzdcc<?> zzdccVar = f15869e.get(zzdcaVar.d());
        if (zzdccVar == null) {
            String name = zzdcaVar.d().getName();
            throw new GeneralSecurityException(name.length() != 0 ? "No wrapper found for ".concat(name) : new String("No wrapper found for "));
        }
        return (P) zzdccVar.b(zzdcaVar);
    }

    private static <P> P g(String str, zzdmr zzdmrVar, Class<P> cls) throws GeneralSecurityException {
        return (P) b(str, cls).g(zzdmrVar);
    }

    public static <P> P h(String str, zzdpk zzdpkVar, Class<P> cls) throws GeneralSecurityException {
        return (P) b(str, (Class) a(cls)).d(zzdpkVar);
    }

    public static <P> P i(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return (P) g(str, zzdmr.D(bArr), (Class) a(cls));
    }

    public static synchronized <P> void j(zzdbs<P> zzdbsVar) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            k(zzdbsVar, true);
        }
    }

    public static synchronized <P> void k(zzdbs<P> zzdbsVar, boolean z) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            if (zzdbsVar != null) {
                String b2 = zzdbsVar.b();
                ConcurrentMap<String, zzdbs> concurrentMap = f15866b;
                if (concurrentMap.containsKey(b2)) {
                    zzdbs b3 = b(b2, null);
                    boolean booleanValue = f15867c.get(b2).booleanValue();
                    if (!zzdbsVar.getClass().equals(b3.getClass()) || (!booleanValue && z)) {
                        Logger logger = a;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(b2);
                        logger.logp(level, "com.google.crypto.tink.Registry", "registerKeyManager", valueOf.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(valueOf) : new String("Attempted overwrite of a registered key manager for key type "));
                        throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", b2, b3.getClass().getName(), zzdbsVar.getClass().getName()));
                    }
                }
                concurrentMap.put(b2, zzdbsVar);
                f15867c.put(b2, Boolean.valueOf(z));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <P> void l(zzdcc<P> zzdccVar) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            if (zzdccVar != null) {
                Class<P> a2 = zzdccVar.a();
                ConcurrentMap<Class<?>, zzdcc<?>> concurrentMap = f15869e;
                if (concurrentMap.containsKey(a2)) {
                    zzdcc<?> zzdccVar2 = concurrentMap.get(a2);
                    if (!zzdccVar.getClass().equals(zzdccVar2.getClass())) {
                        Logger logger = a;
                        Level level = Level.WARNING;
                        String valueOf = String.valueOf(a2.toString());
                        logger.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", valueOf.length() != 0 ? "Attempted overwrite of a registered SetWrapper for type ".concat(valueOf) : new String("Attempted overwrite of a registered SetWrapper for type "));
                        throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", a2.getName(), zzdccVar2.getClass().getName(), zzdccVar.getClass().getName()));
                    }
                }
                concurrentMap.put(a2, zzdccVar);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    public static synchronized void m(String str, zzdbk<?> zzdbkVar) throws GeneralSecurityException {
        synchronized (zzdcf.class) {
            ConcurrentMap<String, zzdbk> concurrentMap = f15868d;
            if (concurrentMap.containsKey(str.toLowerCase())) {
                if (!zzdbkVar.getClass().equals(concurrentMap.get(str.toLowerCase()).getClass())) {
                    a.logp(Level.WARNING, "com.google.crypto.tink.Registry", "addCatalogue", str.length() != 0 ? "Attempted overwrite of a catalogueName catalogue for name ".concat(str) : new String("Attempted overwrite of a catalogueName catalogue for name "));
                    StringBuilder sb = new StringBuilder(str.length() + 47);
                    sb.append("catalogue for name ");
                    sb.append(str);
                    sb.append(" has been already registered");
                    throw new GeneralSecurityException(sb.toString());
                }
            }
            concurrentMap.put(str.toLowerCase(), zzdbkVar);
        }
    }

    public static synchronized zzdpk n(zzdgw zzdgwVar) throws GeneralSecurityException {
        zzdpk f2;
        synchronized (zzdcf.class) {
            zzdbs b2 = b(zzdgwVar.x(), null);
            if (f15867c.get(zzdgwVar.x()).booleanValue()) {
                f2 = b2.f(zzdgwVar.y());
            } else {
                String valueOf = String.valueOf(zzdgwVar.x());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return f2;
    }

    public static zzdbk<?> o(String str) throws GeneralSecurityException {
        if (str != null) {
            zzdbk<?> zzdbkVar = f15868d.get(str.toLowerCase());
            if (zzdbkVar != null) {
                return zzdbkVar;
            }
            String format = String.format("no catalogue found for %s. ", str);
            if (str.toLowerCase().startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (!str.toLowerCase().startsWith("tinkdeterministicaead")) {
                if (!str.toLowerCase().startsWith("tinkstreamingaead")) {
                    if (!str.toLowerCase().startsWith("tinkhybriddecrypt") && !str.toLowerCase().startsWith("tinkhybridencrypt")) {
                        if (!str.toLowerCase().startsWith("tinkmac")) {
                            if (!str.toLowerCase().startsWith("tinkpublickeysign") && !str.toLowerCase().startsWith("tinkpublickeyverify")) {
                                if (str.toLowerCase().startsWith("tink")) {
                                    format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
                                }
                            } else {
                                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
                            }
                        } else {
                            format = String.valueOf(format).concat("Maybe call MacConfig.register().");
                        }
                    } else {
                        format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
                    }
                } else {
                    format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
                }
            } else {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }
}
