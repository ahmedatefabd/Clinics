package Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Labs implements Parcelable {

    @SerializedName("lab_name")
    @Expose
    private String labName;
    @SerializedName("comments")
    @Expose
    private Object comments;
    @SerializedName("rate")
    @Expose
    private Object rate;
    @SerializedName("lab_date")
    @Expose
    private Object labDate;
    @SerializedName("file_url")
    @Expose
    private Object fileUrl;
    @SerializedName("min")
    @Expose
    private Object min;
    @SerializedName("max")
    @Expose
    private Object max;
    @SerializedName("new_or_old")
    @Expose
    private Object newOrOld;

    protected Labs(Parcel in) {
        labName = in.readString();
    }

    public static final Creator<Labs> CREATOR = new Creator<Labs>() {
        @Override
        public Labs createFromParcel(Parcel in) {
            return new Labs(in);
        }

        @Override
        public Labs[] newArray(int size) {
            return new Labs[size];
        }
    };

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public Object getComments() {
        return comments;
    }

    public void setComments(Object comments) {
        this.comments = comments;
    }

    public Object getRate() {
        return rate;
    }

    public void setRate(Object rate) {
        this.rate = rate;
    }

    public Object getLabDate() {
        return labDate;
    }

    public void setLabDate(Object labDate) {
        this.labDate = labDate;
    }

    public Object getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(Object fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Object getMin() {
        return min;
    }

    public void setMin(Object min) {
        this.min = min;
    }

    public Object getMax() {
        return max;
    }

    public void setMax(Object max) {
        this.max = max;
    }

    public Object getNewOrOld() {
        return newOrOld;
    }

    public void setNewOrOld(Object newOrOld) {
        this.newOrOld = newOrOld;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(labName);
    }
}
