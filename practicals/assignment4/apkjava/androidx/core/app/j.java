package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.i;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.gms.ads.AdRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationCompatBuilder.java */
/* loaded from: classes.dex */
class j implements h {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final Notification.Builder f899b;

    /* renamed from: c, reason: collision with root package name */
    private final i.e f900c;

    /* renamed from: d, reason: collision with root package name */
    private RemoteViews f901d;

    /* renamed from: e, reason: collision with root package name */
    private RemoteViews f902e;

    /* renamed from: f, reason: collision with root package name */
    private final List<Bundle> f903f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final Bundle f904g = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    private int f905h;

    /* renamed from: i, reason: collision with root package name */
    private RemoteViews f906i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i.e eVar) {
        Icon icon;
        List list;
        List<String> e2;
        this.f900c = eVar;
        this.a = eVar.a;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            this.f899b = new Notification.Builder(eVar.a, eVar.K);
        } else {
            this.f899b = new Notification.Builder(eVar.a);
        }
        Notification notification = eVar.S;
        this.f899b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f893i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.f889e).setContentText(eVar.f890f).setContentInfo(eVar.f895k).setContentIntent(eVar.f891g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.f892h, (notification.flags & 128) != 0).setLargeIcon(eVar.f894j).setNumber(eVar.l).setProgress(eVar.t, eVar.u, eVar.v);
        if (i2 < 21) {
            this.f899b.setSound(notification.sound, notification.audioStreamType);
        }
        if (i2 >= 16) {
            this.f899b.setSubText(eVar.q).setUsesChronometer(eVar.o).setPriority(eVar.m);
            Iterator<i.a> it = eVar.f886b.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            Bundle bundle = eVar.D;
            if (bundle != null) {
                this.f904g.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (eVar.z) {
                    this.f904g.putBoolean("android.support.localOnly", true);
                }
                String str = eVar.w;
                if (str != null) {
                    this.f904g.putString("android.support.groupKey", str);
                    if (eVar.x) {
                        this.f904g.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f904g.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = eVar.y;
                if (str2 != null) {
                    this.f904g.putString("android.support.sortKey", str2);
                }
            }
            this.f901d = eVar.H;
            this.f902e = eVar.I;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 17) {
            this.f899b.setShowWhen(eVar.n);
        }
        if (i3 >= 19 && i3 < 21 && (e2 = e(g(eVar.f887c), eVar.V)) != null && !e2.isEmpty()) {
            this.f904g.putStringArray("android.people", (String[]) e2.toArray(new String[e2.size()]));
        }
        if (i3 >= 20) {
            this.f899b.setLocalOnly(eVar.z).setGroup(eVar.w).setGroupSummary(eVar.x).setSortKey(eVar.y);
            this.f905h = eVar.P;
        }
        if (i3 >= 21) {
            this.f899b.setCategory(eVar.C).setColor(eVar.E).setVisibility(eVar.F).setPublicVersion(eVar.G).setSound(notification.sound, notification.audioAttributes);
            if (i3 < 28) {
                list = e(g(eVar.f887c), eVar.V);
            } else {
                list = eVar.V;
            }
            if (list != null && !list.isEmpty()) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    this.f899b.addPerson((String) it2.next());
                }
            }
            this.f906i = eVar.J;
            if (eVar.f888d.size() > 0) {
                Bundle bundle2 = eVar.d().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i4 = 0; i4 < eVar.f888d.size(); i4++) {
                    bundle4.putBundle(Integer.toString(i4), k.b(eVar.f888d.get(i4)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                eVar.d().putBundle("android.car.EXTENSIONS", bundle2);
                this.f904g.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 23 && (icon = eVar.U) != null) {
            this.f899b.setSmallIcon(icon);
        }
        if (i5 >= 24) {
            this.f899b.setExtras(eVar.D).setRemoteInputHistory(eVar.s);
            RemoteViews remoteViews = eVar.H;
            if (remoteViews != null) {
                this.f899b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = eVar.I;
            if (remoteViews2 != null) {
                this.f899b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = eVar.J;
            if (remoteViews3 != null) {
                this.f899b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i5 >= 26) {
            this.f899b.setBadgeIconType(eVar.L).setSettingsText(eVar.r).setShortcutId(eVar.M).setTimeoutAfter(eVar.O).setGroupAlertBehavior(eVar.P);
            if (eVar.B) {
                this.f899b.setColorized(eVar.A);
            }
            if (!TextUtils.isEmpty(eVar.K)) {
                this.f899b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i5 >= 28) {
            Iterator<m> it3 = eVar.f887c.iterator();
            while (it3.hasNext()) {
                this.f899b.addPerson(it3.next().h());
            }
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 29) {
            this.f899b.setAllowSystemGeneratedContextualActions(eVar.Q);
            this.f899b.setBubbleMetadata(i.d.a(eVar.R));
            if (eVar.N != null) {
                throw null;
            }
        }
        if (eVar.T) {
            if (this.f900c.x) {
                this.f905h = 2;
            } else {
                this.f905h = 1;
            }
            this.f899b.setVibrate(null);
            this.f899b.setSound(null);
            int i7 = notification.defaults & (-2);
            notification.defaults = i7;
            int i8 = i7 & (-3);
            notification.defaults = i8;
            this.f899b.setDefaults(i8);
            if (i6 >= 26) {
                if (TextUtils.isEmpty(this.f900c.w)) {
                    this.f899b.setGroup("silent");
                }
                this.f899b.setGroupAlertBehavior(this.f905h);
            }
        }
    }

    private void b(i.a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 20) {
            if (i2 >= 16) {
                this.f903f.add(k.f(this.f899b, aVar));
                return;
            }
            return;
        }
        IconCompat e2 = aVar.e();
        if (i2 >= 23) {
            builder = new Notification.Action.Builder(e2 != null ? e2.p() : null, aVar.i(), aVar.a());
        } else {
            builder = new Notification.Action.Builder(e2 != null ? e2.e() : 0, aVar.i(), aVar.a());
        }
        if (aVar.f() != null) {
            for (RemoteInput remoteInput : n.b(aVar.f())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 24) {
            builder.setAllowGeneratedReplies(aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.g());
        if (i3 >= 28) {
            builder.setSemanticAction(aVar.g());
        }
        if (i3 >= 29) {
            builder.setContextual(aVar.j());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
        builder.addExtras(bundle);
        this.f899b.addAction(builder.build());
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        c.e.b bVar = new c.e.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> g(List<m> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<m> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().g());
        }
        return arrayList;
    }

    private void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i2 = notification.defaults & (-2);
        notification.defaults = i2;
        notification.defaults = i2 & (-3);
    }

    @Override // androidx.core.app.h
    public Notification.Builder a() {
        return this.f899b;
    }

    public Notification c() {
        Bundle a;
        RemoteViews f2;
        RemoteViews d2;
        i.f fVar = this.f900c.p;
        if (fVar != null) {
            fVar.b(this);
        }
        RemoteViews e2 = fVar != null ? fVar.e(this) : null;
        Notification d3 = d();
        if (e2 != null) {
            d3.contentView = e2;
        } else {
            RemoteViews remoteViews = this.f900c.H;
            if (remoteViews != null) {
                d3.contentView = remoteViews;
            }
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16 && fVar != null && (d2 = fVar.d(this)) != null) {
            d3.bigContentView = d2;
        }
        if (i2 >= 21 && fVar != null && (f2 = this.f900c.p.f(this)) != null) {
            d3.headsUpContentView = f2;
        }
        if (i2 >= 16 && fVar != null && (a = i.a(d3)) != null) {
            fVar.a(a);
        }
        return d3;
    }

    protected Notification d() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return this.f899b.build();
        }
        if (i2 >= 24) {
            Notification build = this.f899b.build();
            if (this.f905h != 0) {
                if (build.getGroup() != null && (build.flags & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 && this.f905h == 2) {
                    h(build);
                }
                if (build.getGroup() != null && (build.flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 && this.f905h == 1) {
                    h(build);
                }
            }
            return build;
        }
        if (i2 >= 21) {
            this.f899b.setExtras(this.f904g);
            Notification build2 = this.f899b.build();
            RemoteViews remoteViews = this.f901d;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f902e;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f906i;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f905h != 0) {
                if (build2.getGroup() != null && (build2.flags & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 && this.f905h == 2) {
                    h(build2);
                }
                if (build2.getGroup() != null && (build2.flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 && this.f905h == 1) {
                    h(build2);
                }
            }
            return build2;
        }
        if (i2 >= 20) {
            this.f899b.setExtras(this.f904g);
            Notification build3 = this.f899b.build();
            RemoteViews remoteViews4 = this.f901d;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f902e;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f905h != 0) {
                if (build3.getGroup() != null && (build3.flags & AdRequest.MAX_CONTENT_URL_LENGTH) != 0 && this.f905h == 2) {
                    h(build3);
                }
                if (build3.getGroup() != null && (build3.flags & AdRequest.MAX_CONTENT_URL_LENGTH) == 0 && this.f905h == 1) {
                    h(build3);
                }
            }
            return build3;
        }
        if (i2 >= 19) {
            SparseArray<Bundle> a = k.a(this.f903f);
            if (a != null) {
                this.f904g.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.f899b.setExtras(this.f904g);
            Notification build4 = this.f899b.build();
            RemoteViews remoteViews6 = this.f901d;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f902e;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        }
        if (i2 >= 16) {
            Notification build5 = this.f899b.build();
            Bundle a2 = i.a(build5);
            Bundle bundle = new Bundle(this.f904g);
            for (String str : this.f904g.keySet()) {
                if (a2.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a2.putAll(bundle);
            SparseArray<Bundle> a3 = k.a(this.f903f);
            if (a3 != null) {
                i.a(build5).putSparseParcelableArray("android.support.actionExtras", a3);
            }
            RemoteViews remoteViews8 = this.f901d;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f902e;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
        return this.f899b.getNotification();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context f() {
        return this.a;
    }
}
