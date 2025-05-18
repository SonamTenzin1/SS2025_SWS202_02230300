package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import io.sentry.q4;
import io.sentry.s4;
import io.sentry.w1;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.HttpUrl;

/* compiled from: ManifestMetadataReader.java */
/* loaded from: classes2.dex */
final class d1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01c9 A[Catch: all -> 0x0329, TryCatch #0 {all -> 0x0329, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0051, B:12:0x0079, B:14:0x0087, B:15:0x008a, B:18:0x00bc, B:22:0x00c5, B:23:0x00e0, B:25:0x01c9, B:26:0x01d3, B:28:0x01d9, B:30:0x01e7, B:31:0x01ea, B:33:0x0224, B:35:0x0232, B:36:0x0235, B:38:0x025b, B:39:0x0262, B:43:0x0270, B:45:0x0276, B:46:0x027a, B:48:0x0280, B:51:0x0292, B:52:0x0295, B:54:0x02b2, B:55:0x02b7, B:57:0x02e9, B:58:0x02ed, B:60:0x02f3, B:62:0x0301, B:64:0x0288, B:65:0x00d3, B:66:0x031b), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01d9 A[Catch: all -> 0x0329, TryCatch #0 {all -> 0x0329, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0051, B:12:0x0079, B:14:0x0087, B:15:0x008a, B:18:0x00bc, B:22:0x00c5, B:23:0x00e0, B:25:0x01c9, B:26:0x01d3, B:28:0x01d9, B:30:0x01e7, B:31:0x01ea, B:33:0x0224, B:35:0x0232, B:36:0x0235, B:38:0x025b, B:39:0x0262, B:43:0x0270, B:45:0x0276, B:46:0x027a, B:48:0x0280, B:51:0x0292, B:52:0x0295, B:54:0x02b2, B:55:0x02b7, B:57:0x02e9, B:58:0x02ed, B:60:0x02f3, B:62:0x0301, B:64:0x0288, B:65:0x00d3, B:66:0x031b), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0224 A[Catch: all -> 0x0329, TryCatch #0 {all -> 0x0329, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0051, B:12:0x0079, B:14:0x0087, B:15:0x008a, B:18:0x00bc, B:22:0x00c5, B:23:0x00e0, B:25:0x01c9, B:26:0x01d3, B:28:0x01d9, B:30:0x01e7, B:31:0x01ea, B:33:0x0224, B:35:0x0232, B:36:0x0235, B:38:0x025b, B:39:0x0262, B:43:0x0270, B:45:0x0276, B:46:0x027a, B:48:0x0280, B:51:0x0292, B:52:0x0295, B:54:0x02b2, B:55:0x02b7, B:57:0x02e9, B:58:0x02ed, B:60:0x02f3, B:62:0x0301, B:64:0x0288, B:65:0x00d3, B:66:0x031b), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x025b A[Catch: all -> 0x0329, TryCatch #0 {all -> 0x0329, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0051, B:12:0x0079, B:14:0x0087, B:15:0x008a, B:18:0x00bc, B:22:0x00c5, B:23:0x00e0, B:25:0x01c9, B:26:0x01d3, B:28:0x01d9, B:30:0x01e7, B:31:0x01ea, B:33:0x0224, B:35:0x0232, B:36:0x0235, B:38:0x025b, B:39:0x0262, B:43:0x0270, B:45:0x0276, B:46:0x027a, B:48:0x0280, B:51:0x0292, B:52:0x0295, B:54:0x02b2, B:55:0x02b7, B:57:0x02e9, B:58:0x02ed, B:60:0x02f3, B:62:0x0301, B:64:0x0288, B:65:0x00d3, B:66:0x031b), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02b2 A[Catch: all -> 0x0329, TryCatch #0 {all -> 0x0329, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0051, B:12:0x0079, B:14:0x0087, B:15:0x008a, B:18:0x00bc, B:22:0x00c5, B:23:0x00e0, B:25:0x01c9, B:26:0x01d3, B:28:0x01d9, B:30:0x01e7, B:31:0x01ea, B:33:0x0224, B:35:0x0232, B:36:0x0235, B:38:0x025b, B:39:0x0262, B:43:0x0270, B:45:0x0276, B:46:0x027a, B:48:0x0280, B:51:0x0292, B:52:0x0295, B:54:0x02b2, B:55:0x02b7, B:57:0x02e9, B:58:0x02ed, B:60:0x02f3, B:62:0x0301, B:64:0x0288, B:65:0x00d3, B:66:0x031b), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02e9 A[Catch: all -> 0x0329, TryCatch #0 {all -> 0x0329, blocks: (B:3:0x000e, B:5:0x001d, B:7:0x0030, B:9:0x0046, B:10:0x0051, B:12:0x0079, B:14:0x0087, B:15:0x008a, B:18:0x00bc, B:22:0x00c5, B:23:0x00e0, B:25:0x01c9, B:26:0x01d3, B:28:0x01d9, B:30:0x01e7, B:31:0x01ea, B:33:0x0224, B:35:0x0232, B:36:0x0235, B:38:0x025b, B:39:0x0262, B:43:0x0270, B:45:0x0276, B:46:0x027a, B:48:0x0280, B:51:0x0292, B:52:0x0295, B:54:0x02b2, B:55:0x02b7, B:57:0x02e9, B:58:0x02ed, B:60:0x02f3, B:62:0x0301, B:64:0x0288, B:65:0x00d3, B:66:0x031b), top: B:2:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, SentryAndroidOptions sentryAndroidOptions, s0 s0Var) {
        long h2;
        List<String> g2;
        io.sentry.protocol.o sdkVersion;
        List<String> g3;
        io.sentry.util.q.c(context, "The application context is required.");
        io.sentry.util.q.c(sentryAndroidOptions, "The options object is required.");
        try {
            Bundle b2 = b(context, sentryAndroidOptions.getLogger(), s0Var);
            w1 logger = sentryAndroidOptions.getLogger();
            if (b2 != null) {
                sentryAndroidOptions.setDebug(d(b2, logger, "io.sentry.debug", sentryAndroidOptions.isDebug()));
                if (sentryAndroidOptions.isDebug()) {
                    String name = sentryAndroidOptions.getDiagnosticLevel().name();
                    Locale locale = Locale.ROOT;
                    String i2 = i(b2, logger, "io.sentry.debug.level", name.toLowerCase(locale));
                    if (i2 != null) {
                        sentryAndroidOptions.setDiagnosticLevel(s4.valueOf(i2.toUpperCase(locale)));
                    }
                }
                sentryAndroidOptions.setAnrEnabled(d(b2, logger, "io.sentry.anr.enable", sentryAndroidOptions.isAnrEnabled()));
                sentryAndroidOptions.setEnableAutoSessionTracking(d(b2, logger, "io.sentry.auto-session-tracking.enable", d(b2, logger, "io.sentry.session-tracking.enable", sentryAndroidOptions.isEnableAutoSessionTracking())));
                if (sentryAndroidOptions.getSampleRate() == null) {
                    Double f2 = f(b2, logger, "io.sentry.sample-rate");
                    if (f2.doubleValue() != -1.0d) {
                        sentryAndroidOptions.setSampleRate(f2);
                    }
                }
                sentryAndroidOptions.setAnrReportInDebug(d(b2, logger, "io.sentry.anr.report-debug", sentryAndroidOptions.isAnrReportInDebug()));
                sentryAndroidOptions.setAnrTimeoutIntervalMillis(h(b2, logger, "io.sentry.anr.timeout-interval-millis", sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                String i3 = i(b2, logger, "io.sentry.dsn", sentryAndroidOptions.getDsn());
                boolean d2 = d(b2, logger, "io.sentry.enabled", sentryAndroidOptions.isEnabled());
                if (d2 && (i3 == null || !i3.isEmpty())) {
                    if (i3 == null) {
                        sentryAndroidOptions.getLogger().c(s4.FATAL, "DSN is required. Use empty string to disable SDK.", new Object[0]);
                    }
                    sentryAndroidOptions.setEnabled(d2);
                    sentryAndroidOptions.setDsn(i3);
                    sentryAndroidOptions.setEnableNdk(d(b2, logger, "io.sentry.ndk.enable", sentryAndroidOptions.isEnableNdk()));
                    sentryAndroidOptions.setEnableScopeSync(d(b2, logger, "io.sentry.ndk.scope-sync.enable", sentryAndroidOptions.isEnableScopeSync()));
                    sentryAndroidOptions.setRelease(i(b2, logger, "io.sentry.release", sentryAndroidOptions.getRelease()));
                    sentryAndroidOptions.setEnvironment(i(b2, logger, "io.sentry.environment", sentryAndroidOptions.getEnvironment()));
                    sentryAndroidOptions.setSessionTrackingIntervalMillis(h(b2, logger, "io.sentry.session-tracking.timeout-interval-millis", sentryAndroidOptions.getSessionTrackingIntervalMillis()));
                    sentryAndroidOptions.setEnableActivityLifecycleBreadcrumbs(d(b2, logger, "io.sentry.breadcrumbs.activity-lifecycle", sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs()));
                    sentryAndroidOptions.setEnableAppLifecycleBreadcrumbs(d(b2, logger, "io.sentry.breadcrumbs.app-lifecycle", sentryAndroidOptions.isEnableAppLifecycleBreadcrumbs()));
                    sentryAndroidOptions.setEnableSystemEventBreadcrumbs(d(b2, logger, "io.sentry.breadcrumbs.system-events", sentryAndroidOptions.isEnableSystemEventBreadcrumbs()));
                    sentryAndroidOptions.setEnableAppComponentBreadcrumbs(d(b2, logger, "io.sentry.breadcrumbs.app-components", sentryAndroidOptions.isEnableAppComponentBreadcrumbs()));
                    sentryAndroidOptions.setEnableUserInteractionBreadcrumbs(d(b2, logger, "io.sentry.breadcrumbs.user-interaction", sentryAndroidOptions.isEnableUserInteractionBreadcrumbs()));
                    sentryAndroidOptions.setEnableNetworkEventBreadcrumbs(d(b2, logger, "io.sentry.breadcrumbs.network-events", sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()));
                    sentryAndroidOptions.setEnableUncaughtExceptionHandler(d(b2, logger, "io.sentry.uncaught-exception-handler.enable", sentryAndroidOptions.isEnableUncaughtExceptionHandler()));
                    sentryAndroidOptions.setAttachThreads(d(b2, logger, "io.sentry.attach-threads", sentryAndroidOptions.isAttachThreads()));
                    sentryAndroidOptions.setAttachScreenshot(d(b2, logger, "io.sentry.attach-screenshot", sentryAndroidOptions.isAttachScreenshot()));
                    sentryAndroidOptions.setAttachViewHierarchy(d(b2, logger, "io.sentry.attach-view-hierarchy", sentryAndroidOptions.isAttachViewHierarchy()));
                    sentryAndroidOptions.setSendClientReports(d(b2, logger, "io.sentry.send-client-reports", sentryAndroidOptions.isSendClientReports()));
                    sentryAndroidOptions.setCollectAdditionalContext(d(b2, logger, "io.sentry.additional-context", sentryAndroidOptions.isCollectAdditionalContext()));
                    if (sentryAndroidOptions.getEnableTracing() == null) {
                        sentryAndroidOptions.setEnableTracing(e(b2, logger, "io.sentry.traces.enable", null));
                    }
                    if (sentryAndroidOptions.getTracesSampleRate() == null) {
                        Double f3 = f(b2, logger, "io.sentry.traces.sample-rate");
                        if (f3.doubleValue() != -1.0d) {
                            sentryAndroidOptions.setTracesSampleRate(f3);
                        }
                    }
                    sentryAndroidOptions.setTraceSampling(d(b2, logger, "io.sentry.traces.trace-sampling", sentryAndroidOptions.isTraceSampling()));
                    sentryAndroidOptions.setEnableAutoActivityLifecycleTracing(d(b2, logger, "io.sentry.traces.activity.enable", sentryAndroidOptions.isEnableAutoActivityLifecycleTracing()));
                    sentryAndroidOptions.setEnableActivityLifecycleTracingAutoFinish(d(b2, logger, "io.sentry.traces.activity.auto-finish.enable", sentryAndroidOptions.isEnableActivityLifecycleTracingAutoFinish()));
                    sentryAndroidOptions.setProfilingEnabled(d(b2, logger, "io.sentry.traces.profiling.enable", sentryAndroidOptions.isProfilingEnabled()));
                    if (sentryAndroidOptions.getProfilesSampleRate() == null) {
                        Double f4 = f(b2, logger, "io.sentry.traces.profiling.sample-rate");
                        if (f4.doubleValue() != -1.0d) {
                            sentryAndroidOptions.setProfilesSampleRate(f4);
                        }
                    }
                    sentryAndroidOptions.setEnableUserInteractionTracing(d(b2, logger, "io.sentry.traces.user-interaction.enable", sentryAndroidOptions.isEnableUserInteractionTracing()));
                    sentryAndroidOptions.setEnableTimeToFullDisplayTracing(d(b2, logger, "io.sentry.traces.time-to-full-display.enable", sentryAndroidOptions.isEnableTimeToFullDisplayTracing()));
                    h2 = h(b2, logger, "io.sentry.traces.idle-timeout", -1L);
                    if (h2 != -1) {
                        sentryAndroidOptions.setIdleTimeout(Long.valueOf(h2));
                    }
                    g2 = g(b2, logger, "io.sentry.traces.trace-propagation-targets");
                    if (!b2.containsKey("io.sentry.traces.trace-propagation-targets") && (g2 == null || g2.isEmpty())) {
                        g2 = g(b2, logger, "io.sentry.traces.tracing-origins");
                    }
                    if ((!b2.containsKey("io.sentry.traces.trace-propagation-targets") || b2.containsKey("io.sentry.traces.tracing-origins")) && g2 == null) {
                        sentryAndroidOptions.setTracePropagationTargets(Collections.emptyList());
                    } else if (g2 != null) {
                        sentryAndroidOptions.setTracePropagationTargets(g2);
                    }
                    sentryAndroidOptions.setEnableFramesTracking(d(b2, logger, "io.sentry.traces.frames-tracking", true));
                    sentryAndroidOptions.setProguardUuid(i(b2, logger, "io.sentry.proguard-uuid", sentryAndroidOptions.getProguardUuid()));
                    sdkVersion = sentryAndroidOptions.getSdkVersion();
                    if (sdkVersion == null) {
                        sdkVersion = new io.sentry.protocol.o(HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET);
                    }
                    sdkVersion.h(j(b2, logger, "io.sentry.sdk.name", sdkVersion.e()));
                    sdkVersion.j(j(b2, logger, "io.sentry.sdk.version", sdkVersion.g()));
                    sentryAndroidOptions.setSdkVersion(sdkVersion);
                    sentryAndroidOptions.setSendDefaultPii(d(b2, logger, "io.sentry.send-default-pii", sentryAndroidOptions.isSendDefaultPii()));
                    g3 = g(b2, logger, "io.sentry.gradle-plugin-integrations");
                    if (g3 != null) {
                        Iterator<String> it = g3.iterator();
                        while (it.hasNext()) {
                            q4.c().a(it.next());
                        }
                    }
                    sentryAndroidOptions.setEnableRootCheck(d(b2, logger, "io.sentry.enable-root-check", sentryAndroidOptions.isEnableRootCheck()));
                    sentryAndroidOptions.setSendModules(d(b2, logger, "io.sentry.send-modules", sentryAndroidOptions.isSendModules()));
                }
                sentryAndroidOptions.getLogger().c(s4.DEBUG, "Sentry enabled flag set to false or DSN is empty: disabling sentry-android", new Object[0]);
                sentryAndroidOptions.setEnabled(d2);
                sentryAndroidOptions.setDsn(i3);
                sentryAndroidOptions.setEnableNdk(d(b2, logger, "io.sentry.ndk.enable", sentryAndroidOptions.isEnableNdk()));
                sentryAndroidOptions.setEnableScopeSync(d(b2, logger, "io.sentry.ndk.scope-sync.enable", sentryAndroidOptions.isEnableScopeSync()));
                sentryAndroidOptions.setRelease(i(b2, logger, "io.sentry.release", sentryAndroidOptions.getRelease()));
                sentryAndroidOptions.setEnvironment(i(b2, logger, "io.sentry.environment", sentryAndroidOptions.getEnvironment()));
                sentryAndroidOptions.setSessionTrackingIntervalMillis(h(b2, logger, "io.sentry.session-tracking.timeout-interval-millis", sentryAndroidOptions.getSessionTrackingIntervalMillis()));
                sentryAndroidOptions.setEnableActivityLifecycleBreadcrumbs(d(b2, logger, "io.sentry.breadcrumbs.activity-lifecycle", sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableAppLifecycleBreadcrumbs(d(b2, logger, "io.sentry.breadcrumbs.app-lifecycle", sentryAndroidOptions.isEnableAppLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableSystemEventBreadcrumbs(d(b2, logger, "io.sentry.breadcrumbs.system-events", sentryAndroidOptions.isEnableSystemEventBreadcrumbs()));
                sentryAndroidOptions.setEnableAppComponentBreadcrumbs(d(b2, logger, "io.sentry.breadcrumbs.app-components", sentryAndroidOptions.isEnableAppComponentBreadcrumbs()));
                sentryAndroidOptions.setEnableUserInteractionBreadcrumbs(d(b2, logger, "io.sentry.breadcrumbs.user-interaction", sentryAndroidOptions.isEnableUserInteractionBreadcrumbs()));
                sentryAndroidOptions.setEnableNetworkEventBreadcrumbs(d(b2, logger, "io.sentry.breadcrumbs.network-events", sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()));
                sentryAndroidOptions.setEnableUncaughtExceptionHandler(d(b2, logger, "io.sentry.uncaught-exception-handler.enable", sentryAndroidOptions.isEnableUncaughtExceptionHandler()));
                sentryAndroidOptions.setAttachThreads(d(b2, logger, "io.sentry.attach-threads", sentryAndroidOptions.isAttachThreads()));
                sentryAndroidOptions.setAttachScreenshot(d(b2, logger, "io.sentry.attach-screenshot", sentryAndroidOptions.isAttachScreenshot()));
                sentryAndroidOptions.setAttachViewHierarchy(d(b2, logger, "io.sentry.attach-view-hierarchy", sentryAndroidOptions.isAttachViewHierarchy()));
                sentryAndroidOptions.setSendClientReports(d(b2, logger, "io.sentry.send-client-reports", sentryAndroidOptions.isSendClientReports()));
                sentryAndroidOptions.setCollectAdditionalContext(d(b2, logger, "io.sentry.additional-context", sentryAndroidOptions.isCollectAdditionalContext()));
                if (sentryAndroidOptions.getEnableTracing() == null) {
                }
                if (sentryAndroidOptions.getTracesSampleRate() == null) {
                }
                sentryAndroidOptions.setTraceSampling(d(b2, logger, "io.sentry.traces.trace-sampling", sentryAndroidOptions.isTraceSampling()));
                sentryAndroidOptions.setEnableAutoActivityLifecycleTracing(d(b2, logger, "io.sentry.traces.activity.enable", sentryAndroidOptions.isEnableAutoActivityLifecycleTracing()));
                sentryAndroidOptions.setEnableActivityLifecycleTracingAutoFinish(d(b2, logger, "io.sentry.traces.activity.auto-finish.enable", sentryAndroidOptions.isEnableActivityLifecycleTracingAutoFinish()));
                sentryAndroidOptions.setProfilingEnabled(d(b2, logger, "io.sentry.traces.profiling.enable", sentryAndroidOptions.isProfilingEnabled()));
                if (sentryAndroidOptions.getProfilesSampleRate() == null) {
                }
                sentryAndroidOptions.setEnableUserInteractionTracing(d(b2, logger, "io.sentry.traces.user-interaction.enable", sentryAndroidOptions.isEnableUserInteractionTracing()));
                sentryAndroidOptions.setEnableTimeToFullDisplayTracing(d(b2, logger, "io.sentry.traces.time-to-full-display.enable", sentryAndroidOptions.isEnableTimeToFullDisplayTracing()));
                h2 = h(b2, logger, "io.sentry.traces.idle-timeout", -1L);
                if (h2 != -1) {
                }
                g2 = g(b2, logger, "io.sentry.traces.trace-propagation-targets");
                if (!b2.containsKey("io.sentry.traces.trace-propagation-targets")) {
                    g2 = g(b2, logger, "io.sentry.traces.tracing-origins");
                }
                if (b2.containsKey("io.sentry.traces.trace-propagation-targets")) {
                }
                sentryAndroidOptions.setTracePropagationTargets(Collections.emptyList());
                sentryAndroidOptions.setEnableFramesTracking(d(b2, logger, "io.sentry.traces.frames-tracking", true));
                sentryAndroidOptions.setProguardUuid(i(b2, logger, "io.sentry.proguard-uuid", sentryAndroidOptions.getProguardUuid()));
                sdkVersion = sentryAndroidOptions.getSdkVersion();
                if (sdkVersion == null) {
                }
                sdkVersion.h(j(b2, logger, "io.sentry.sdk.name", sdkVersion.e()));
                sdkVersion.j(j(b2, logger, "io.sentry.sdk.version", sdkVersion.g()));
                sentryAndroidOptions.setSdkVersion(sdkVersion);
                sentryAndroidOptions.setSendDefaultPii(d(b2, logger, "io.sentry.send-default-pii", sentryAndroidOptions.isSendDefaultPii()));
                g3 = g(b2, logger, "io.sentry.gradle-plugin-integrations");
                if (g3 != null) {
                }
                sentryAndroidOptions.setEnableRootCheck(d(b2, logger, "io.sentry.enable-root-check", sentryAndroidOptions.isEnableRootCheck()));
                sentryAndroidOptions.setSendModules(d(b2, logger, "io.sentry.send-modules", sentryAndroidOptions.isSendModules()));
            }
            sentryAndroidOptions.getLogger().c(s4.INFO, "Retrieving configuration from AndroidManifest.xml", new Object[0]);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(s4.ERROR, "Failed to read configuration from android manifest metadata.", th);
        }
    }

    private static Bundle b(Context context, w1 w1Var, s0 s0Var) throws PackageManager.NameNotFoundException {
        if (s0Var == null) {
            s0Var = new s0(w1Var);
        }
        return t0.a(context, 128L, s0Var).metaData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context, w1 w1Var) {
        io.sentry.util.q.c(context, "The application context is required.");
        try {
            Bundle b2 = b(context, w1Var, null);
            r1 = b2 != null ? d(b2, w1Var, "io.sentry.auto-init", true) : true;
            w1Var.c(s4.INFO, "Retrieving auto-init from AndroidManifest.xml", new Object[0]);
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Failed to read auto-init from android manifest metadata.", th);
        }
        return r1;
    }

    private static boolean d(Bundle bundle, w1 w1Var, String str, boolean z) {
        boolean z2 = bundle.getBoolean(str, z);
        w1Var.c(s4.DEBUG, "%s read: %s", str, Boolean.valueOf(z2));
        return z2;
    }

    private static Boolean e(Bundle bundle, w1 w1Var, String str, Boolean bool) {
        if (bundle.getSerializable(str) != null) {
            boolean z = bundle.getBoolean(str, bool != null);
            w1Var.c(s4.DEBUG, "%s read: %s", str, Boolean.valueOf(z));
            return Boolean.valueOf(z);
        }
        w1Var.c(s4.DEBUG, "%s used default %s", str, bool);
        return bool;
    }

    private static Double f(Bundle bundle, w1 w1Var, String str) {
        Double valueOf = Double.valueOf(Float.valueOf(bundle.getFloat(str, -1.0f)).doubleValue());
        w1Var.c(s4.DEBUG, "%s read: %s", str, valueOf);
        return valueOf;
    }

    private static List<String> g(Bundle bundle, w1 w1Var, String str) {
        String string = bundle.getString(str);
        w1Var.c(s4.DEBUG, "%s read: %s", str, string);
        if (string != null) {
            return Arrays.asList(string.split(",", -1));
        }
        return null;
    }

    private static long h(Bundle bundle, w1 w1Var, String str, long j2) {
        long j3 = bundle.getInt(str, (int) j2);
        w1Var.c(s4.DEBUG, "%s read: %s", str, Long.valueOf(j3));
        return j3;
    }

    private static String i(Bundle bundle, w1 w1Var, String str, String str2) {
        String string = bundle.getString(str, str2);
        w1Var.c(s4.DEBUG, "%s read: %s", str, string);
        return string;
    }

    private static String j(Bundle bundle, w1 w1Var, String str, String str2) {
        String string = bundle.getString(str, str2);
        w1Var.c(s4.DEBUG, "%s read: %s", str, string);
        return string;
    }
}
