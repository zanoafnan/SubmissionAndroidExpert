package g6;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2540a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f2541b;

    public b(boolean z6, boolean z7) {
        this.f2540a = z6;
        this.f2541b = z7;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f2540a == bVar.f2540a && this.f2541b == bVar.f2541b;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        boolean z6 = this.f2540a;
        int i7 = z6;
        if (z6 != 0) {
            i7 = 1;
        }
        int i8 = i7 * 31;
        boolean z7 = this.f2541b;
        return i8 + (z7 ? 1 : z7 ? 1 : 0);
    }

    public final String toString() {
        return "Options(isCreatedAtStart=" + this.f2540a + ", override=" + this.f2541b + ")";
    }
}