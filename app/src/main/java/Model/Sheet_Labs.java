package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sheet_Labs {

    @SerializedName("sheet_name")
    @Expose
    private String sheetName;
    @SerializedName("created_when")
    @Expose
    private String createdWhen;
    @SerializedName("labs")
    @Expose
    private List<Labs> labsList = null;

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
}
