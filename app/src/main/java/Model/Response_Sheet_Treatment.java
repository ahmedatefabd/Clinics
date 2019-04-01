package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response_Sheet_Treatment {

    @SerializedName("sheet")
    @Expose
    private List<Sheet_Treatment> sheet_treatmentList = null;

    public List<Sheet_Treatment> getSheet_treatmentList() {
        return sheet_treatmentList;
    }

    public void setSheet_treatmentList(List<Sheet_Treatment> sheet_treatmentList) {
        this.sheet_treatmentList = sheet_treatmentList;
    }
}