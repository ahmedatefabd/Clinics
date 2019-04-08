package Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ragab.clinics.R;
import java.util.List;
import Model.Treatment;
import androidx.recyclerview.widget.RecyclerView;

public class SheetTreatmentDetailsAdapter extends RecyclerView.Adapter<SheetTreatmentDetailsAdapter.SheetTreatmentDetailsHolder>{
    private Context mContext;
    private List<Treatment> treatmentList;

    public SheetTreatmentDetailsAdapter(Context mContext, List<Treatment> treatments) {
        this.mContext = mContext;
        this.treatmentList = treatments;
    }

    @Override
    public SheetTreatmentDetailsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_sheet_treatmentdetails, parent, false);
        SheetTreatmentDetailsHolder holder = new SheetTreatmentDetailsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(SheetTreatmentDetailsHolder holder, int position) {
        Treatment treatment = treatmentList.get(position);
        holder.treatmentNameDT.setText("اسم العلاج :- " + treatment.getDrugName());
        holder.treatmentDescriptionDT.setText("مواعيد العلاج :- " + treatment.getComments());
    }

    @Override
    public int getItemCount() {
        return treatmentList.size();
    }

    public class SheetTreatmentDetailsHolder extends RecyclerView.ViewHolder {
        public TextView treatmentNameDT;
        public TextView treatmentDescriptionDT;
        public TextView From_Date;
        public TextView How_Date;
        public TextView Treatment_method;

        public SheetTreatmentDetailsHolder(View itemView) {
            super(itemView);
            treatmentNameDT = itemView.findViewById(R.id.name_SheetTreatmentDetails);
            treatmentDescriptionDT = itemView.findViewById(R.id.Description_SheetTreatment);
            From_Date = itemView.findViewById(R.id.from_Date);
            How_Date = itemView.findViewById(R.id.how_Date);
            Treatment_method = itemView.findViewById(R.id.treatment_method);
        }
    }
}