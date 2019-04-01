package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Xrays {

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
}
