package ModelDB;
import Model.BookingAll_Items;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BookingItems")
public class BookingAll_ItemsDB {
    private static BookingAll_ItemsDB instance;
    @PrimaryKey
    private Integer id;
    @ColumnInfo(name = "branchId")
    private Integer branchId;
    @ColumnInfo(name = "appointmentDate")
    private String appointmentDate;
    @ColumnInfo(name = "cost")
    private Integer cost;
    @ColumnInfo(name = "statusId")
    private Integer statusId;
    @ColumnInfo(name = "typeId")
    private Integer typeId;
//    @ColumnInfo(name = "complaintType")
//    private Object complaintType;
//    public BookingAll_ItemsDB(){
//    }

    public BookingAll_ItemsDB(Integer id, Integer branchId, String appointmentDate, Integer cost, Integer statusId, Integer typeId) {
        this.id = id;
        this.branchId = branchId;
        this.appointmentDate = appointmentDate;
        this.cost = cost;
        this.statusId = statusId;
        this.typeId = typeId;
//        this.complaintType = complaintType;
    }

    public static BookingAll_ItemsDB getInstance(Integer id, Integer branchId, String appointmentDate, Integer cost, Integer statusId, Integer typeId) {
        if (instance == null) {
            synchronized (BookingAll_Items.class) {
                if (instance == null) {
                    System.out.println("getInstance(): First time getInstance was invoked!");
                    instance = new BookingAll_ItemsDB(id, branchId, appointmentDate, cost, statusId, typeId);
                }
            }
        }
        return instance;
    }

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
}
