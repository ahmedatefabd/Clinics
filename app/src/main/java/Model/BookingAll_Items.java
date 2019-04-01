package Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookingAll_Items {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("branch_id")
    @Expose
    private Integer branchId;
    @SerializedName("appointment_date")
    @Expose
    private String appointmentDate;
    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("status_id")
    @Expose
    private Integer statusId;
    @SerializedName("type_id")
    @Expose
    private Integer typeId;
    @SerializedName("complaint_type")
    @Expose
    private Object complaintType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Object getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(Object complaintType) {
        this.complaintType = complaintType;
    }

}