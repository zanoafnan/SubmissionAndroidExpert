package f1;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    public static final HashMap f2257e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2258a;

    /* renamed from: b  reason: collision with root package name */
    public final File f2259b;

    /* renamed from: c  reason: collision with root package name */
    public final Lock f2260c;

    /* renamed from: d  reason: collision with root package name */
    public FileChannel f2261d;

    public a(String str, File file, boolean z6) {
        Lock lock;
        this.f2258a = z6;
        this.f2259b = file != null ? new File(file, str.concat(".lck")) : null;
        HashMap hashMap = f2257e;
        synchronized (hashMap) {
            Object obj = hashMap.get(str);
            if (obj == null) {
                obj = new ReentrantLock();
                hashMap.put(str, obj);
            }
            lock = (Lock) obj;
        }
        this.f2260c = lock;
    }

    public final void a(boolean z6) {
        this.f2260c.lock();
        if (z6) {
            File file = this.f2259b;
            try {
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(file).getChannel();
                channel.lock();
                this.f2261d = channel;
            } catch (IOException e2) {
                this.f2261d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e2);
            }
        }
    }

    public final void b() {
        try {
            FileChannel fileChannel = this.f2261d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f2260c.unlock();
    }
}