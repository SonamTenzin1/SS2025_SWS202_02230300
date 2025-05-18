package cm.aptoide.pt.view.rx;

import androidx.preference.Preference;
import rx.e;
import rx.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PreferenceClickOnSubscribe implements e.a<Preference> {
    private final Preference preference;

    public PreferenceClickOnSubscribe(Preference preference) {
        this.preference = preference;
    }

    @Override // rx.m.b
    public void call(final j<? super Preference> jVar) {
        rx.l.a.verifyMainThread();
        Preference.d dVar = new Preference.d() { // from class: cm.aptoide.pt.view.rx.PreferenceClickOnSubscribe.1
            @Override // androidx.preference.Preference.d
            public boolean onPreferenceClick(Preference preference) {
                if (!jVar.isUnsubscribed()) {
                    jVar.onNext(preference);
                }
                return true;
            }
        };
        jVar.add(new rx.l.a() { // from class: cm.aptoide.pt.view.rx.PreferenceClickOnSubscribe.2
            @Override // rx.l.a
            protected void onUnsubscribe() {
                PreferenceClickOnSubscribe.this.preference.N0(null);
            }
        });
        this.preference.N0(dVar);
    }
}
