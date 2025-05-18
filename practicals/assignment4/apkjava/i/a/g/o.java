package i.a.g;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;

/* compiled from: NetworkTopologyDiscoveryImpl.java */
/* loaded from: classes2.dex */
public class o implements i.a.b {
    private static final k.b.b a = k.b.c.i(o.class.getName());

    @Override // i.a.b
    public InetAddress[] a() {
        HashSet hashSet = new HashSet();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement2 = inetAddresses.nextElement();
                    k.b.b bVar = a;
                    if (bVar.d()) {
                        bVar.i("Found NetworkInterface/InetAddress: " + nextElement + " -- " + nextElement2);
                    }
                    if (b(nextElement, nextElement2)) {
                        hashSet.add(nextElement2);
                    }
                }
            }
        } catch (SocketException e2) {
            a.h("Error while fetching network interfaces addresses: " + e2);
        }
        return (InetAddress[]) hashSet.toArray(new InetAddress[hashSet.size()]);
    }

    public boolean b(NetworkInterface networkInterface, InetAddress inetAddress) {
        try {
            if (networkInterface.isUp() && networkInterface.supportsMulticast()) {
                return !networkInterface.isLoopback();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
