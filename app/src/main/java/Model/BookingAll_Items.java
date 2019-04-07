package Model;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingAll_Items implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("branch_id")
    @Expose
    private Integer branchId;
    @SerializedName("appointment_date")
    @Expose
    private String appointmentDate;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("status_id")
    @Expose
    private Integer statusId;
    @SerializedName("type_id")
    @Expose
    private Integer typeId;
    @SerializedName("complaint_type")
    @Expose
    private Object complaintType;

    protected BookingAll_Items(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            branchId = null;
        } else {
            branchId = in.readInt();
        }
        appointmentDate = in.readString();
        if (in.readByte() == 0) {
            cost = null;
        } else {
            cost = in.readInt();
        }
        if (in.readByte() == 0) {
            statusId = null;
        } else {
            statusId = in.readInt();
        }
        if (in.readByte() == 0) {
            typeId = null;
        } else {
            typeId = in.readInt();
        }
    }

    public static final Creator<BookingAll_Items> CREATOR = new Creator<BookingAll_Items>() {
        @Override
        public BookingAll_Items createFromParcel(Parcel in) {
            return new BookingAll_Items(in);
        }

        @Override
        public BookingAll_Items[] newArray(int size) {
            return new BookingAll_Items[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Object getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(Object complaintType) {
        this.complaintType = complaintType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (branchId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(branchId);
        }
        dest.writeString(appointmentDate);
        if (cost == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(cost);
        }
        if (statusId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(statusId);
        }
        if (typeId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(typeId);
        }
    }
}