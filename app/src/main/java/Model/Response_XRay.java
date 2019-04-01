package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response_XRay {

    @SerializedName("sheet")
    @Expose
    private List<Sheet_XRays> sheet_xRaysList = null;

    public List<Sheet_XRays> getSheet_xRaysList() {
        return sheet_xRaysList;
    }

    public void setSheet_xRaysList(List<Sheet_XRays> sheet_xRaysList) {
        this.sheet_xRaysList = sheet_xRaysList;
    }
}
