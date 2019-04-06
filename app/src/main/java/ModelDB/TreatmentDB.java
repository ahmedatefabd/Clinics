package ModelDB;
import Model.Treatment;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TreatmentDB")
public class TreatmentDB {
    private static TreatmentDB instance;

    @PrimaryKey
    private Integer id;

    @ColumnInfo(name = "drugName")
    private String drugName;

    @ColumnInfo(name = "fromDate")
    private String fromDate;

    @ColumnInfo(name = "howLong")
    private String howLong;

    @ColumnInfo(name = "dose")
    private String dose;

    @ColumnInfo(name = "treatmentMethod")
    private String treatmentMethod;

    @ColumnInfo(name = "comments")
    private String comments;

    public TreatmentDB(Integer id, String drugName, String fromDate, String howLong, String dose, String treatmentMethod, String comments) {
        this.id = id;
        this.drugName = drugName;
        this.fromDate = fromDate;
        this.howLong = howLong;
        this.dose = dose;
        this.treatmentMethod = treatmentMethod;
        this.comments = comments;
    }

    public static TreatmentDB getInstance(Integer id, String drugName, String fromDate, String howLong, String dose, String treatmentMethod, String comments) {
        if (instance == null) {
            synchronized (Treatment.class) {
                if (instance == null) {
                    System.out.println("getInstance(): First time getInstance was invoked!");
                    instance = new TreatmentDB(id, drugName, fromDate, howLong, dose, treatmentMethod, comments);
                }
            }
        }
        return instance;
    }

    public static TreatmentDB getInstance(String drugName, String fromDate, String howLong, String dose, String treatmentMethod, String comments) {
        return instance;
    }

    public static void setInstance(TreatmentDB instance) {
        TreatmentDB.instance = instance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getHowLong() {
        return howLong;
    }

    public void setHowLong(String howLong) {
        this.howLong = howLong;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getTreatmentMethod() {
        return treatmentMethod;
    }

    public void setTreatmentMethod(String treatmentMethod) {
        this.treatmentMethod = treatmentMethod;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
