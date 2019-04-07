package Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Xrays implements Parcelable {

    @SerializedName("xray_name")
    @Expose
    private String xrayName;
    @SerializedName("place_name")
    @Expose
    private String placeName;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("file_url")
    @Expose
    private String fileUrl;
    @SerializedName("new_or_old")
    @Expose
    private String newOrOld;


    protected Xrays(Parcel in) {
        xrayName = in.readString();
        placeName = in.readString();
        comments = in.readString();
        fileUrl = in.readString();
        newOrOld = in.readString();
    }

    public static final Creator<Xrays> CREATOR = new Creator<Xrays>() {
        @Override
        public Xrays createFromParcel(Parcel in) {
            return new Xrays(in);
        }

        @Override
        public Xrays[] newArray(int size) {
            return new Xrays[size];
        }
    };

    public String getXrayName() {
        return xrayName;
    }

    public void setXrayName(String xrayName) {
        this.xrayName = xrayName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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
        dest.writeString(xrayName);
        dest.writeString(placeName);
        dest.writeString(comments);
        dest.writeString(fileUrl);
        dest.writeString(newOrOld);
    }
}
