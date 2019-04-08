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
    private String comments;
    @SerializedName("rate")
    @Expose
    private String rate;
    @SerializedName("lab_date")
    @Expose
    private String labDate;
    @SerializedName("file_url")
    @Expose
    private String fileUrl;
    @SerializedName("min")
    @Expose
    private String min;
    @SerializedName("max")
    @Expose
    private String max;
    @SerializedName("new_or_old")
    @Expose
    private String newOrOld;

    protected Labs(Parcel in) {
        labName = in.readString();
        comments = in.readString();
        rate = in.readString();
        labDate = in.readString();
        fileUrl = in.readString();
        min = in.readString();
        max = in.readString();
        newOrOld = in.readString();
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getLabDate() {
        return labDate;
    }

    public void setLabDate(String labDate) {
        this.labDate = labDate;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getNewOrOld() {
        return newOrOld;
    }

    public void setNewOrOld(String newOrOld) {
        this.newOrOld = newOrOld;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(labName);
        dest.writeString(comments);
        dest.writeString(rate);
        dest.writeString(labDate);
        dest.writeString(fileUrl);
        dest.writeString(min);
        dest.writeString(max);
        dest.writeString(newOrOld);
    }
}
