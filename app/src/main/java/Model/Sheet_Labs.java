package Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sheet_Labs implements Parcelable {

    @SerializedName("sheet_name")
    @Expose
    private String sheetName;
    @SerializedName("created_when")
    @Expose
    private String createdWhen;
    @SerializedName("labs")
    @Expose
    private List<Labs> labsList = null;

    protected Sheet_Labs(Parcel in) {
        sheetName = in.readString();
        createdWhen = in.readString();
    }

    public static final Creator<Sheet_Labs> CREATOR = new Creator<Sheet_Labs>() {
        @Override
        public Sheet_Labs createFromParcel(Parcel in) {
            return new Sheet_Labs(in);
        }

        @Override
        public Sheet_Labs[] newArray(int size) {
            return new Sheet_Labs[size];
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

    public List<Labs> getLabsList() {
        return labsList;
    }

    public void setLabsList(List<Labs> labsList) {
        this.labsList = labsList;
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
