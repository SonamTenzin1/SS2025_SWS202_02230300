package cm.aptoide.pt.preferences;

/* loaded from: classes.dex */
public class LocalPersistenceAdultContent {
    private static final String ADULT_CONTENT_PIN_PREFERENCES_KEY = "Maturepin";
    private static final String ADULT_CONTENT_PREFERENCES_KEY = "matureChkBox";
    private final Preferences preferences;
    private final SecurePreferences securePreferences;

    public LocalPersistenceAdultContent(Preferences preferences, SecurePreferences securePreferences) {
        this.preferences = preferences;
        this.securePreferences = securePreferences;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$enable$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(int i2, Integer num) {
        if (num.equals(Integer.valueOf(i2))) {
            return enable();
        }
        return rx.b.s(new SecurityException("Pin does not match."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$removePin$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b b(int i2, Integer num) {
        if (num.equals(Integer.valueOf(i2))) {
            return this.securePreferences.remove(ADULT_CONTENT_PIN_PREFERENCES_KEY);
        }
        return rx.b.s(new SecurityException("Pin does not match."));
    }

    public rx.b disable() {
        return this.preferences.save(ADULT_CONTENT_PREFERENCES_KEY, false);
    }

    public rx.b enable() {
        return this.preferences.save(ADULT_CONTENT_PREFERENCES_KEY, true);
    }

    public rx.e<Boolean> enabled() {
        return this.preferences.getBoolean(ADULT_CONTENT_PREFERENCES_KEY, false);
    }

    public rx.e<Boolean> pinRequired() {
        return this.securePreferences.getInt(ADULT_CONTENT_PIN_PREFERENCES_KEY, -1).X(new rx.m.e() { // from class: cm.aptoide.pt.preferences.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(r1.intValue() != -1);
                return valueOf;
            }
        });
    }

    public rx.b removePin(final int i2) {
        return this.securePreferences.getInt(ADULT_CONTENT_PIN_PREFERENCES_KEY, -1).E().Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.preferences.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return LocalPersistenceAdultContent.this.b(i2, (Integer) obj);
            }
        });
    }

    public rx.b requirePin(int i2) {
        return this.securePreferences.save(ADULT_CONTENT_PIN_PREFERENCES_KEY, i2);
    }

    public rx.b enable(final int i2) {
        return this.securePreferences.getInt(ADULT_CONTENT_PIN_PREFERENCES_KEY, -1).E().Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.preferences.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return LocalPersistenceAdultContent.this.a(i2, (Integer) obj);
            }
        });
    }
}
