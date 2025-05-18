package io.rakam.api;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* compiled from: DeviceInfo.java */
/* loaded from: classes2.dex */
public class d {
    private boolean a = true;

    /* renamed from: b, reason: collision with root package name */
    private Context f21923b;

    /* renamed from: c, reason: collision with root package name */
    private b f21924c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeviceInfo.java */
    /* loaded from: classes2.dex */
    public class b {
        private String a;

        /* renamed from: b, reason: collision with root package name */
        private String f21925b;

        /* renamed from: c, reason: collision with root package name */
        private String f21926c;

        /* renamed from: d, reason: collision with root package name */
        private String f21927d;

        /* renamed from: e, reason: collision with root package name */
        private String f21928e;

        /* renamed from: f, reason: collision with root package name */
        private String f21929f;

        /* renamed from: g, reason: collision with root package name */
        private String f21930g;

        /* renamed from: h, reason: collision with root package name */
        private String f21931h;

        /* renamed from: i, reason: collision with root package name */
        private String f21932i;

        /* renamed from: j, reason: collision with root package name */
        private String f21933j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f21934k;
        private boolean l;

        private String A() {
            return Build.VERSION.RELEASE;
        }

        private String B() {
            try {
                return d.this.f21923b.getPackageManager().getPackageInfo(d.this.f21923b.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e.e().g("Failed to get version name", e2);
                return null;
            }
        }

        private boolean m() {
            try {
                Integer num = (Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", Context.class).invoke(null, d.this.f21923b);
                if (num != null) {
                    return num.intValue() == 0;
                }
                return false;
            } catch (ClassNotFoundException e2) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services Util not found!");
                e.e().g("Failed to check GPS enabled", e2);
                return false;
            } catch (IllegalAccessException e3) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services not available");
                e.e().g("Failed to check GPS enabled", e3);
                return false;
            } catch (NoClassDefFoundError e4) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services Util not found!");
                e.e().g("Failed to check GPS enabled", e4);
                return false;
            } catch (NoSuchMethodException e5) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services not available");
                e.e().g("Failed to check GPS enabled", e5);
                return false;
            } catch (InvocationTargetException e6) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services not available");
                e.e().g("Failed to check GPS enabled", e6);
                return false;
            } catch (Exception e7) {
                h.d().g("io.rakam.api.DeviceInfo", "Error when checking for Google Play Services: " + e7);
                e.e().g("Failed to check GPS enabled", e7);
                return false;
            }
        }

        private String n() {
            if ("Amazon".equals(x())) {
                return o();
            }
            return p();
        }

        private String o() {
            ContentResolver contentResolver = d.this.f21923b.getContentResolver();
            this.f21934k = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 0) == 1;
            String string = Settings.Secure.getString(contentResolver, "advertising_id");
            this.a = string;
            return string;
        }

        private String p() {
            try {
                boolean z = true;
                Object invoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, d.this.f21923b);
                Boolean bool = (Boolean) invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0]);
                if (bool == null || !bool.booleanValue()) {
                    z = false;
                }
                this.f21934k = z;
                this.a = (String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
            } catch (ClassNotFoundException e2) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services SDK not found!");
                e.e().g("Failed to get ADID", e2);
            } catch (InvocationTargetException e3) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services not available");
                e.e().g("Failed to get ADID", e3);
            } catch (Exception e4) {
                h.d().c("io.rakam.api.DeviceInfo", "Encountered an error connecting to Google Play Services", e4);
                e.e().g("Failed to get ADID", e4);
            }
            return this.a;
        }

        private String q() {
            return Build.BRAND;
        }

        private String r() {
            try {
                return ((TelephonyManager) d.this.f21923b.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception e2) {
                e.e().g("Failed to get carrier", e2);
                return null;
            }
        }

        private String s() {
            String u = u();
            if (!j.d(u)) {
                return u;
            }
            String v = v();
            return !j.d(v) ? v : t();
        }

        private String t() {
            return Locale.getDefault().getCountry();
        }

        private String u() {
            Location l;
            List<Address> fromLocation;
            if (d.this.r() && (l = d.this.l()) != null) {
                try {
                    if (Geocoder.isPresent() && (fromLocation = d.this.h().getFromLocation(l.getLatitude(), l.getLongitude(), 1)) != null) {
                        for (Address address : fromLocation) {
                            if (address != null) {
                                return address.getCountryCode();
                            }
                        }
                    }
                } catch (IOException e2) {
                    e.e().g("Failed to get country from location", e2);
                } catch (IllegalArgumentException e3) {
                    e.e().g("Failed to get country from location", e3);
                } catch (IllegalStateException e4) {
                    e.e().g("Failed to get country from location", e4);
                } catch (NoSuchMethodError e5) {
                    e.e().g("Failed to get country from location", e5);
                } catch (NullPointerException e6) {
                    e.e().g("Failed to get country from location", e6);
                }
            }
            return null;
        }

        private String v() {
            String networkCountryIso;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) d.this.f21923b.getSystemService("phone");
                if (telephonyManager.getPhoneType() == 2 || (networkCountryIso = telephonyManager.getNetworkCountryIso()) == null) {
                    return null;
                }
                return networkCountryIso.toUpperCase(Locale.US);
            } catch (Exception e2) {
                e.e().g("Failed to get country from network", e2);
                return null;
            }
        }

        private String w() {
            return Locale.getDefault().getLanguage();
        }

        private String x() {
            return Build.MANUFACTURER;
        }

        private String y() {
            return Build.MODEL;
        }

        private String z() {
            return "android";
        }

        private b() {
            this.a = n();
            this.f21926c = B();
            this.f21927d = z();
            this.f21928e = A();
            this.f21929f = q();
            this.f21930g = x();
            this.f21931h = y();
            this.f21932i = r();
            this.f21925b = s();
            this.f21933j = w();
            this.l = m();
        }
    }

    public d(Context context) {
        this.f21923b = context;
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    private b e() {
        if (this.f21924c == null) {
            this.f21924c = new b();
        }
        return this.f21924c;
    }

    public String c() {
        return e().a;
    }

    public String d() {
        return e().f21929f;
    }

    public String f() {
        return e().f21932i;
    }

    public String g() {
        return e().f21925b;
    }

    protected Geocoder h() {
        return new Geocoder(this.f21923b, Locale.ENGLISH);
    }

    public String i() {
        return e().f21933j;
    }

    public String j() {
        return e().f21930g;
    }

    public String k() {
        return e().f21931h;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0032 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Location l() {
        LocationManager locationManager;
        List<String> list;
        Location location;
        Location location2 = null;
        if (!r() || (locationManager = (LocationManager) this.f21923b.getSystemService("location")) == null) {
            return null;
        }
        try {
            list = locationManager.getProviders(true);
        } catch (SecurityException e2) {
            e.e().g("Failed to get most recent location", e2);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList<Location> arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            try {
                location = locationManager.getLastKnownLocation(it.next());
            } catch (IllegalArgumentException e3) {
                e.e().g("Failed to get most recent location", e3);
                location = null;
                if (location != null) {
                }
            } catch (SecurityException e4) {
                e.e().g("Failed to get most recent location", e4);
                location = null;
                if (location != null) {
                }
            }
            if (location != null) {
                arrayList.add(location);
            }
        }
        long j2 = -1;
        for (Location location3 : arrayList) {
            if (location3.getTime() > j2) {
                j2 = location3.getTime();
                location2 = location3;
            }
        }
        return location2;
    }

    public String m() {
        return e().f21927d;
    }

    public String n() {
        return e().f21928e;
    }

    public String o() {
        return e().f21926c;
    }

    public boolean p() {
        return e().l;
    }

    public boolean q() {
        return e().f21934k;
    }

    public boolean r() {
        return this.a;
    }

    public void s() {
        e();
    }
}
