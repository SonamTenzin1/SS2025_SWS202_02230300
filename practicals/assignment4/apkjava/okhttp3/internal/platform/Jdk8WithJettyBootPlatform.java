package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import okhttp3.Protocol;

/* compiled from: Jdk8WithJettyBootPlatform.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001bB7\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0015\u0012\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0015¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform;", "Lokhttp3/internal/platform/Platform;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", HttpUrl.FRAGMENT_ENCODE_SET, "hostname", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/Protocol;", "protocols", "Lkotlin/u;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "afterHandshake", "(Ljavax/net/ssl/SSLSocket;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljava/lang/reflect/Method;", "putMethod", "Ljava/lang/reflect/Method;", "removeMethod", "getMethod", "Ljava/lang/Class;", "serverProviderClass", "Ljava/lang/Class;", "clientProviderClass", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "Companion", "AlpnProvider", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Jdk8WithJettyBootPlatform extends Platform {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    /* compiled from: Jdk8WithJettyBootPlatform.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u001b\u0010\u001cJ2\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$AlpnProvider;", "Ljava/lang/reflect/InvocationHandler;", HttpUrl.FRAGMENT_ENCODE_SET, "proxy", "Ljava/lang/reflect/Method;", "method", HttpUrl.FRAGMENT_ENCODE_SET, "args", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "protocols", "Ljava/util/List;", HttpUrl.FRAGMENT_ENCODE_SET, "unsupported", "Z", "getUnsupported", "()Z", "setUnsupported", "(Z)V", "selected", "Ljava/lang/String;", "getSelected", "()Ljava/lang/String;", "setSelected", "(Ljava/lang/String;)V", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    private static final class AlpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public AlpnProvider(List<String> list) {
            m.f(list, "protocols");
            this.protocols = list;
        }

        public final String getSelected() {
            return this.selected;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            m.f(proxy, "proxy");
            m.f(method, "method");
            if (args == null) {
                args = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (m.a(name, "supports") && m.a(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (m.a(name, "unsupported") && m.a(Void.TYPE, returnType)) {
                this.unsupported = true;
                return null;
            }
            if (m.a(name, "protocols")) {
                if (args.length == 0) {
                    return this.protocols;
                }
            }
            if ((m.a(name, "selectProtocol") || m.a(name, "select")) && m.a(String.class, returnType) && args.length == 1 && (args[0] instanceof List)) {
                Object obj = args[0];
                if (obj != null) {
                    List list = (List) obj;
                    int size = list.size();
                    if (size >= 0) {
                        int i2 = 0;
                        while (true) {
                            Object obj2 = list.get(i2);
                            if (obj2 != null) {
                                String str = (String) obj2;
                                if (!this.protocols.contains(str)) {
                                    if (i2 == size) {
                                        break;
                                    }
                                    i2++;
                                } else {
                                    this.selected = str;
                                    return str;
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                        }
                    }
                    String str2 = this.protocols.get(0);
                    this.selected = str2;
                    return str2;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
            }
            if ((m.a(name, "protocolSelected") || m.a(name, "selected")) && args.length == 1) {
                Object obj3 = args[0];
                if (obj3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                this.selected = (String) obj3;
                return null;
            }
            return method.invoke(this, Arrays.copyOf(args, args.length));
        }

        public final void setSelected(String str) {
            this.selected = str;
        }

        public final void setUnsupported(boolean z) {
            this.unsupported = z;
        }
    }

    /* compiled from: Jdk8WithJettyBootPlatform.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/internal/platform/Platform;", "buildIfSupported", "()Lokhttp3/internal/platform/Platform;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public final Platform buildIfSupported() {
            String property = System.getProperty("java.specification.version", "unknown");
            try {
                m.e(property, "jvmVersion");
                if (Integer.parseInt(property) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                Method method = cls.getMethod("put", SSLSocket.class, cls2);
                Method method2 = cls.getMethod("get", SSLSocket.class);
                Method method3 = cls.getMethod("remove", SSLSocket.class);
                m.e(method, "putMethod");
                m.e(method2, "getMethod");
                m.e(method3, "removeMethod");
                m.e(cls3, "clientProviderClass");
                m.e(cls4, "serverProviderClass");
                return new Jdk8WithJettyBootPlatform(method, method2, method3, cls3, cls4);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        m.f(method, "putMethod");
        m.f(method2, "getMethod");
        m.f(method3, "removeMethod");
        m.f(cls, "clientProviderClass");
        m.f(cls2, "serverProviderClass");
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(SSLSocket sslSocket) {
        m.f(sslSocket, "sslSocket");
        try {
            this.removeMethod.invoke(null, sslSocket);
        } catch (IllegalAccessException e2) {
            AssertionError assertionError = new AssertionError("failed to remove ALPN");
            assertionError.initCause(e2);
            throw assertionError;
        } catch (InvocationTargetException e3) {
            AssertionError assertionError2 = new AssertionError("failed to remove ALPN");
            assertionError2.initCause(e3);
            throw assertionError2;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sslSocket, String hostname, List<? extends Protocol> protocols) {
        m.f(sslSocket, "sslSocket");
        m.f(protocols, "protocols");
        try {
            this.putMethod.invoke(null, sslSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(Platform.INSTANCE.alpnProtocolNames(protocols))));
        } catch (IllegalAccessException e2) {
            AssertionError assertionError = new AssertionError("failed to set ALPN");
            assertionError.initCause(e2);
            throw assertionError;
        } catch (InvocationTargetException e3) {
            AssertionError assertionError2 = new AssertionError("failed to set ALPN");
            assertionError2.initCause(e3);
            throw assertionError2;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sslSocket) {
        m.f(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke(null, sslSocket));
            if (invocationHandler != null) {
                AlpnProvider alpnProvider = (AlpnProvider) invocationHandler;
                if (!alpnProvider.getUnsupported() && alpnProvider.getSelected() == null) {
                    Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                    return null;
                }
                if (alpnProvider.getUnsupported()) {
                    return null;
                }
                return alpnProvider.getSelected();
            }
            throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
        } catch (IllegalAccessException e2) {
            AssertionError assertionError = new AssertionError("failed to get ALPN selected protocol");
            assertionError.initCause(e2);
            throw assertionError;
        } catch (InvocationTargetException e3) {
            AssertionError assertionError2 = new AssertionError("failed to get ALPN selected protocol");
            assertionError2.initCause(e3);
            throw assertionError2;
        }
    }
}
