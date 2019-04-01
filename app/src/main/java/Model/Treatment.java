package Model;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Treatment implements Parcelable {

    @SerializedName("drug_name")
    @Expose
    private String drugName;
    @SerializedName("from_date")
    @Expose
    private Object fromDate;
    @SerializedName("how_long")
    @Expose
    private Object howLong;
    @SerializedName("dose")
    @Expose
    private Object dose;
    @SerializedName("treatment_method")
    @Expose
    private Object treatmentMethod;
    @SerializedName("comments")
    @Expose
    private String comments;

    protected Treatment(Parcel in) {
        drugName = in.readString();
        comments = in.readString();
    }

    public static final Creator<Treatment> CREATOR = new Creator<Treatment>() {
        @Override
        public Treatment createFromParcel(Parcel in) {
            return new Treatment(in);
        }

        @Override
        public Treatment[] newArray(int size) {
            return new Treatment[size];
        }
    };

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Object getFromDate() {
        return fromDate;
    }

    public void setFromDate(Object fromDate) {
        this.fromDate = fromDate;
    }

    public Object getHowLong() {
        return howLong;
    }

    public void setHowLong(Object howLong) {
        this.howLong = howLong;
    }

    public Object getDose() {
        return dose;
    }

    public void setDose(Object dose) {
        this.dose = dose;
    }

    public Object getTreatmentMethod() {
        return treatmentMethod;
    }

    public void setTreatmentMethod(Object treatmentMethod) {
        this.treatmentMethod = treatmentMethod;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(drugName);
        dest.writeString(comments);
    }
}