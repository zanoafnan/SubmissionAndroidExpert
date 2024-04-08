package d5;

import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class d implements Serializable {

    /* renamed from: i  reason: collision with root package name */
    public final Pattern f1975i;

    public d() {
        Pattern compile = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        v4.a.m(compile, "compile(pattern)");
        this.f1975i = compile;
    }

    public final String toString() {
        String pattern = this.f1975i.toString();
        v4.a.m(pattern, "nativePattern.toString()");
        return pattern;
    }
}