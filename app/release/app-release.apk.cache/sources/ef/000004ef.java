package k4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ d[] f3310i;

    static {
        d[] dVarArr = {new d("SYNCHRONIZED", 0), new d("PUBLICATION", 1), new d("NONE", 2)};
        f3310i = dVarArr;
        new r4.a(dVarArr);
    }

    public d(String str, int i7) {
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) f3310i.clone();
    }
}