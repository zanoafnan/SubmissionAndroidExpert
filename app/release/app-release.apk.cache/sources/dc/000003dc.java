package g6;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Map f2542a = new ConcurrentHashMap();

    public final boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof c) && v4.a.f(this.f2542a, ((c) obj).f2542a);
        }
        return true;
    }

    public final int hashCode() {
        Map map = this.f2542a;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public final String toString() {
        return "Properties(data=" + this.f2542a + ")";
    }
}