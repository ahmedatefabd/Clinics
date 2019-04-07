package Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sheet_XRays implements Parcelable {

    @SerializedName("sheet_name")
    @Expose
    private String sheetName;
    @SerializedName("created_when")
    @Expose
    private String createdWhen;
    @SerializedName("xray")
    @Expose
    private List<Xrays> xraysList = null;

    protected Sheet_XRays(Parcel in) {
        sheetName = in.readString();
        createdWhen = in.readString();
    }

    public static final Creator<Sheet_XRays> CREATOR = new Creator<Sheet_XRays>() {
        @Override
        public Sheet_XRays createFromParcel(Parcel in) {
            return new Sheet_XRays(in);
        }

        @Override
        public Sheet_XRays[] newArray(int size) {
            return new Sheet_XRays[size];
        }
    };

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getCreatedWhen() {
        return createdWhen;
    }

    public void setCreatedWhen(String createdWhen) {
        this.createdWhen = createdWhen;
    }

    public List<Xrays> getXraysList() {
        return xraysList;
    }

    public void setXraysList(List<Xrays> xraysList) {
        this.xraysList = xraysList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sheetName);
        dest.writeString(createdWhen);
    }
}
