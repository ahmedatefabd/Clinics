package Model;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Sheet_Treatment implements Parcelable {

    @SerializedName("sheet_name")
    @Expose
    private String sheetName;
    @SerializedName("created_when")
    @Expose
    private String createdWhen;
    @SerializedName("treatments")
    @Expose
    private List<Treatment> treatmentList = null;

    protected Sheet_Treatment(Parcel in) {
        sheetName = in.readString();
        createdWhen = in.readString();
    }

    public static final Creator<Sheet_Treatment> CREATOR = new Creator<Sheet_Treatment>() {
        @Override
        public Sheet_Treatment createFromParcel(Parcel in) {
            return new Sheet_Treatment(in);
        }

        @Override
        public Sheet_Treatment[] newArray(int size) {
            return new Sheet_Treatment[size];
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

    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    public void setTreatmentList(List<Treatment> treatmentList) {
        this.treatmentList = treatmentList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sheetName);
        dest.writeString(createdWhen);
        dest.writeList(treatmentList);
    }
}