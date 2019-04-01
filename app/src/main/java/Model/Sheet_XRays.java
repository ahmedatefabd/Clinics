package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sheet_XRays {

    @SerializedName("sheet_name")
    @Expose
    private String sheetName;
    @SerializedName("created_when")
    @Expose
    private String createdWhen;
    @SerializedName("xray")
    @Expose
    private List<Xrays> xraysList = null;

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
}
