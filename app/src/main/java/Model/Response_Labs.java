package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response_Labs {

    @SerializedName("sheet")
    @Expose
    private List<Sheet_Labs> sheet_labsList = null;

    public List<Sheet_Labs> getSheet_labsList() {
        return sheet_labsList;
    }

    public void setSheet_labsList(List<Sheet_Labs> sheet_labsList) {
        this.sheet_labsList = sheet_labsList;
    }
}
