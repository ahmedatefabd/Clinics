package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ragab.clinics.R;

import java.util.List;

import Model.Sheet_Treatment;
import Model.Treatment;
import ModelDB.TreatmentDB;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SheetTreatmentDetailsAdapter extends RecyclerView.Adapter<SheetTreatmentDetailsAdapter.SheetTreatmentDetailsHolder>{

    private Context mContext;
    private List<Treatment> treatmentList;

    public SheetTreatmentDetailsAdapter(Context mContext, List<Treatment> treatments) {
        this.mContext = mContext;
        this.treatmentList = treatments;
    }

    @NonNull
    @Override
    public SheetTreatmentDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_sheet_treatment, parent, false);
        SheetTreatmentDetailsHolder holder = new SheetTreatmentDetailsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SheetTreatmentDetailsHolder holder, int position) {

        Treatment treatment = treatmentList.get(position);

        holder.treatmentNameDT.setText(treatment.getDrugName());
        holder.treatmentDescriptionDT.setText(treatment.getComments());

    }

    @Override
    public int getItemCount() {
        return treatmentList.size();
    }

    public class SheetTreatmentDetailsHolder extends RecyclerView.ViewHolder {

        public TextView treatmentNameDT;
        public TextView treatmentDescriptionDT;

        public SheetTreatmentDetailsHolder(@NonNull View itemView) {
            super(itemView);

            treatmentNameDT = itemView.findViewById(R.id.name_SheetTreatmentDetails);
            treatmentDescriptionDT = itemView.findViewById(R.id.Description_SheetTreatment);
        }
    }
}
