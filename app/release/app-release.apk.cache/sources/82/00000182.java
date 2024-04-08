package c;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.u0;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.material.datepicker.q;
import com.google.android.material.timepicker.g;
import k0.l;
import net.sqlcipher.IBulkCursor;
import t0.k0;
import t0.o0;
import t0.r0;
import z0.a2;
import z0.i0;
import z0.z1;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1082a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f1082a) {
            case 0:
                return new b(parcel);
            case 1:
                return new u0(parcel);
            case 2:
                return new l(parcel);
            case 3:
                return new t0.b(parcel);
            case 4:
                return new k0(parcel);
            case 5:
                return new o0(parcel);
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                return new r0(parcel);
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                return new i0(parcel);
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                return new z1(parcel);
            case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                return new a2(parcel);
            case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                return new ParcelImpl(parcel);
            case IBulkCursor.RESPOND_TRANSACTION /* 11 */:
                return new p2.b(parcel);
            case IBulkCursor.CLOSE_TRANSACTION /* 12 */:
                return new com.google.android.material.datepicker.c((q) parcel.readParcelable(q.class.getClassLoader()), (q) parcel.readParcelable(q.class.getClassLoader()), (com.google.android.material.datepicker.b) parcel.readParcelable(com.google.android.material.datepicker.b.class.getClassLoader()), (q) parcel.readParcelable(q.class.getClassLoader()), parcel.readInt());
            case 13:
                return new com.google.android.material.datepicker.e(parcel.readLong());
            case 14:
                return q.a(parcel.readInt(), parcel.readInt());
            case 15:
                return new g(parcel);
            default:
                v4.a.n(parcel, "parcel");
                return new c4.a(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i7) {
        switch (this.f1082a) {
            case 0:
                return new b[i7];
            case 1:
                return new u0[i7];
            case 2:
                return new l[i7];
            case 3:
                return new t0.b[i7];
            case 4:
                return new k0[i7];
            case 5:
                return new o0[i7];
            case IBulkCursor.DEACTIVATE_TRANSACTION /* 6 */:
                return new r0[i7];
            case IBulkCursor.REQUERY_TRANSACTION /* 7 */:
                return new i0[i7];
            case IBulkCursor.ON_MOVE_TRANSACTION /* 8 */:
                return new z1[i7];
            case IBulkCursor.WANTS_ON_MOVE_TRANSACTION /* 9 */:
                return new a2[i7];
            case IBulkCursor.GET_EXTRAS_TRANSACTION /* 10 */:
                return new ParcelImpl[i7];
            case IBulkCursor.RESPOND_TRANSACTION /* 11 */:
                return new p2.b[i7];
            case IBulkCursor.CLOSE_TRANSACTION /* 12 */:
                return new com.google.android.material.datepicker.c[i7];
            case 13:
                return new com.google.android.material.datepicker.e[i7];
            case 14:
                return new q[i7];
            case 15:
                return new g[i7];
            default:
                return new c4.a[i7];
        }
    }
}