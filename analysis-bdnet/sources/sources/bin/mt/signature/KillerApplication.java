package bin.mt.signature;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.lsposed.hiddenapibypass.HiddenApiBypass;

/* loaded from: classes3.dex */
public class KillerApplication extends Application {
    public static final String URL = "https://github.com/L-JINBIN/ApkSignatureKillerEx";

    static {
        killPM("dastan.prince.bdfreevpn", "MIIFiTCCA3GgAwIBAgIVANc10uPZnFM8FPowwA6j9sjqE51nMA0GCSqGSIb3DQEBCwUAMHQxCzAJ\nBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQw\nEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDAg\nFw0yMjEwMDgwNTE0MTlaGA8yMDUyMTAwODA1MTQxOVowdDELMAkGA1UEBhMCVVMxEzARBgNVBAgT\nCkNhbGlmb3JuaWExFjAUBgNVBAcTDU1vdW50YWluIFZpZXcxFDASBgNVBAoTC0dvb2dsZSBJbmMu\nMRAwDgYDVQQLEwdBbmRyb2lkMRAwDgYDVQQDEwdBbmRyb2lkMIICIjANBgkqhkiG9w0BAQEFAAOC\nAg8AMIICCgKCAgEAwU8oL7+K4XRugNqCoq0vCjvPFyBHOiLiOxm84tzN12Y1PWt35VRsgvAoc7Rs\nJMBw7QqGO9ULj0aUYbZEd4VQ8m0Wmd/noCWex5+CSEs7Hlh5uIriJN9LGHAJUJOM5UiGz7Ihi9el\nHbs6sN3LV8bEAt5YE105Zcrrrc+LAm4Q5hIzo43tNo8EyYy/Lz4W2hKYMmNL09UCCZuvbtNp8Bfs\nmL3ZXU/jArXZml6tmOdecVIzPmxOtZetIoBOVemcjGX5+dDftmV5quIDaXYn/AUMEsFODFJH0mCN\n5Xqic3hGu0AByO2XWUQIqJbwhmA5mbE4/vP6jmnDcluSzGO1284I+qtv94eiitCvGv7u83Ohi5+O\n6fno20W4LJERJmm/yMhGbf2t42Q3YemnAoCU4N/XtbyvoC6Nc1nii+xyXY5MdatILnzVQ+/Bzut3\nC28YDgtZcxY6Fotp5mgxzugddrwXeifdDJ9iAGiTlCV7nuri7XCXa+wZ++ViI2/QkQ8LS8/rMeUJ\ntiqIIdqwI9uYuBiStKpl1ig9S/G9sOfuJRHoZUVBN/Lk5I006Qq8jZfbTiuSvu6kTxbR1uP1RzJk\nlPsswlqpsX+x4qHD58GiMlqSc9wPDZ1Gkro9Mpd2Yty4c6En/FOtuk00rTWP/C1G20kHOyxL0rRY\nXBFg05EdzjF70QMCAwEAAaMQMA4wDAYDVR0TBAUwAwEB/zANBgkqhkiG9w0BAQsFAAOCAgEAY4cM\nznz6cDql7oQfpHVPYfmZJN3AG7flk7/mSlJPCiyswsP9OXEQsw6f7QkRN2priytWRgvptWnErw4B\nIvWAeG2iBL6WV3kN3ZpeD9SFx5PfZW1989YR0PuHaXKEodRfCYKkET+WRUHzPC/4Gvk+4R9YJbvz\nZG2ZcbVhqRpr6soRLbgd5Jv+QGvvvS5PMWh/ceNobN4Ut5j0LxbxyYJmqpTkleJo715jQdD3hPdg\nC8CBG8rmHPLO7UG9DN38AW1tCZA6d1C197crM+mpd6T0qRY+CHFegl+wNdnL3fRAWLdciBH+xz/M\ndeMuAowhFiCxf60ALLgZy8M2QO6Z/90KPPlVBIZHOPmib6uL52+uxPcY80xvv0za/yWcHOmsIomD\nwQmWvCMh8n5MiWivuJxcteDAuYjkqxuGFx+I1AWFIGoZWiXifdzVqCgi2PFJ93KU7yKz/TN2l7Wy\neDdP+Th/BpJRXIlJcOMXefkJoeaztKtvWC3l1lxGkz8sM9XsjdOk7m31E89noSP58BbyP3G9w65R\nn/ajBxn94uB1netSDJnBQEUhBINyfZqtFLcx4UjF6z5VJ9CcxRAqVm3uxTJQ64MJ7bIJzbHvrk0J\nc5VXtsckfdgzUBtPG3UNoU+uRhaEKxf8co1yUecju47Iy3kFrs04W9zLDSmhaGE4IKZ8V1g=\n");
        killOpen("dastan.prince.bdfreevpn");
    }

    private static Field findField(Class<?> cls, String str) throws NoSuchFieldException {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException e) {
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls.equals(Object.class)) {
                    break;
                }
                try {
                    Field declaredField2 = cls.getDeclaredField(str);
                    declaredField2.setAccessible(true);
                    return declaredField2;
                } catch (NoSuchFieldException unused) {
                }
            }
            throw e;
        }
    }

    private static String getApkPath(String str) {
        String str2;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/maps"));
            do {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        return null;
                    }
                    str2 = readLine.split("\\s+")[r1.length - 1];
                } finally {
                }
            } while (!isApkPath(str, str2));
            bufferedReader.close();
            return str2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static File getDataFile(String str) {
        String name = Environment.getExternalStorageDirectory().getName();
        if (name.matches("\\d+")) {
            File file = new File("/data/user/" + name + "/" + str);
            if (file.canWrite()) {
                return file;
            }
        }
        return new File("/data/data/" + str);
    }

    private static native void hookApkPath(String str, String str2);

    private static boolean isApkPath(String str, String str2) {
        if (str2.startsWith("/") && str2.endsWith(".apk")) {
            String[] split = str2.substring(1).split("/", 6);
            int length = split.length;
            if (length == 4 || length == 5) {
                if (split[0].equals("data") && split[1].equals("app") && split[length - 1].equals("base.apk")) {
                    return split[length - 2].startsWith(str);
                }
                if (split[0].equals("mnt") && split[1].equals("asec") && split[length - 1].equals("pkg.apk")) {
                    return split[length - 2].startsWith(str);
                }
            } else if (length == 3) {
                if (split[0].equals("data") && split[1].equals("app")) {
                    return split[2].startsWith(str);
                }
            } else if (length == 6 && split[0].equals("mnt") && split[1].equals("expand") && split[3].equals("app") && split[5].equals("base.apk")) {
                return split[4].endsWith(str);
            }
        }
        return false;
    }

    private static void killOpen(String str) {
        try {
            System.loadLibrary("SignatureKiller");
            String apkPath = getApkPath(str);
            if (apkPath == null) {
                System.err.println("Get apk path failed");
                return;
            }
            File file = new File(apkPath);
            File file2 = new File(getDataFile(str), "origin.apk");
            try {
                ZipFile zipFile = new ZipFile(file);
                try {
                    ZipEntry entry = zipFile.getEntry("assets/SignatureKiller/origin.apk");
                    if (entry == null) {
                        System.err.println("Entry not found: assets/SignatureKiller/origin.apk");
                        zipFile.close();
                        return;
                    }
                    if (!file2.exists() || file2.length() != entry.getSize()) {
                        InputStream inputStream = zipFile.getInputStream(entry);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            try {
                                byte[] bArr = new byte[102400];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                }
                                fileOutputStream.close();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            } finally {
                            }
                        } finally {
                        }
                    }
                    zipFile.close();
                    hookApkPath(file.getAbsolutePath(), file2.getAbsolutePath());
                } finally {
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable unused) {
            System.err.println("Load SignatureKiller library failed");
        }
    }

    private static void killPM(final String str, String str2) {
        final Signature signature = new Signature(Base64.decode(str2, 0));
        final Parcelable.Creator creator = PackageInfo.CREATOR;
        try {
            findField(PackageInfo.class, "CREATOR").set(null, new Parcelable.Creator<PackageInfo>() { // from class: bin.mt.signature.KillerApplication.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public PackageInfo createFromParcel(Parcel parcel) {
                    Signature[] apkContentsSigners;
                    PackageInfo packageInfo = (PackageInfo) creator.createFromParcel(parcel);
                    if (packageInfo.packageName.equals(str)) {
                        if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                            packageInfo.signatures[0] = signature;
                        }
                        if (Build.VERSION.SDK_INT >= 28 && packageInfo.signingInfo != null && (apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners()) != null && apkContentsSigners.length > 0) {
                            apkContentsSigners[0] = signature;
                        }
                    }
                    return packageInfo;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public PackageInfo[] newArray(int i) {
                    return (PackageInfo[]) creator.newArray(i);
                }
            });
            if (Build.VERSION.SDK_INT >= 28) {
                HiddenApiBypass.addHiddenApiExemptions("Landroid/os/Parcel;", "Landroid/content/pm", "Landroid/app");
            }
            try {
                Object obj = findField(PackageManager.class, "sPackageInfoCache").get(null);
                obj.getClass().getMethod("clear", new Class[0]).invoke(obj, new Object[0]);
            } catch (Throwable unused) {
            }
            try {
                ((Map) findField(Parcel.class, "mCreators").get(null)).clear();
            } catch (Throwable unused2) {
            }
            try {
                ((Map) findField(Parcel.class, "sPairedCreators").get(null)).clear();
            } catch (Throwable unused3) {
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
