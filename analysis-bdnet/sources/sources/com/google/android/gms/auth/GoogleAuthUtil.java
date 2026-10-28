package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

/* loaded from: classes.dex */
public final class GoogleAuthUtil extends zzl {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String WORK_ACCOUNT_TYPE = "com.google.work";

    private GoogleAuthUtil() {
    }

    public static void clearToken(Context context, String str) {
        zzl.clearToken(context, str);
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) {
        return zzl.getAccountChangeEvents(context, i, str);
    }

    public static String getAccountId(Context context, String str) {
        return zzl.getAccountId(context, str);
    }

    public static String getToken(Context context, Account account, String str) {
        return zzl.getToken(context, account, str);
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("handle_notification", true);
        return zzg(context, account, str, bundle).zza();
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        zzl.invalidateToken(context, str);
    }

    public static Bundle removeAccount(Context context, Account account) {
        return zzl.removeAccount(context, account);
    }

    public static Boolean requestGoogleAccountsAccess(Context context) {
        return zzl.requestGoogleAccountsAccess(context);
    }

    private static TokenData zzg(Context context, Account account, String str, Bundle bundle) {
        try {
            TokenData zza = zzl.zza(context, account, str, bundle);
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            return zza;
        } catch (GooglePlayServicesAvailabilityException e) {
            GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            Log.w("GoogleAuthUtil", "Error when getting token", e);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.", e);
        } catch (UserRecoverableAuthException e2) {
            GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
            Log.w("GoogleAuthUtil", "Error when getting token", e2);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.", e2);
        }
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) {
        return zzl.getToken(context, account, str, bundle);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) {
        return zzl.getToken(context, str, str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) {
        return zzl.getToken(context, str, str2, bundle);
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, Intent intent) {
        zzl.zzf(intent);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putParcelable("callback_intent", intent);
        bundle.putBoolean("handle_notification", true);
        return zzg(context, account, str, bundle).zza();
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, String str2, Bundle bundle2) {
        Preconditions.checkNotEmpty(str2, "Authority cannot be empty or null.");
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(bundle2);
        bundle.putString("authority", str2);
        bundle.putBundle("sync_extras", bundle2);
        bundle.putBoolean("handle_notification", true);
        return zzg(context, account, str, bundle).zza();
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle) {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, Intent intent) {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, intent);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, String str3, Bundle bundle2) {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, str3, bundle2);
    }
}
