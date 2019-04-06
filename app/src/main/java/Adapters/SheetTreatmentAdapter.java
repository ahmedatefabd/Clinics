package Adapters;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ragab.clinics.DataBase.RoomDB.RoomBD_Abstract.RoomDataBase_TreatmentDB;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.sheet_TreatmentDetails.sheet_TreatmentDetailsActivity;

import java.util.ArrayList;
import java.util.List;
import Model.Sheet_Treatment;
import Model.Treatment;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SheetTreatmentAdapter extends RecyclerView.Adapter<SheetTreatmentAdapter.SheetTreatmentHolder>{

    private Context mContext;
    private List<Sheet_Treatment> sheet_treatmentList;
    private RoomDataBase_TreatmentDB dataBaseTreatmentDB;

    public SheetTreatmentAdapter(Context mContext, List<Sheet_Treatment> sheet_treatmentList, RoomDataBase_TreatmentDB db) {
        this.mContext = mContext;
        this.sheet_treatmentList = sheet_treatmentList;
        this.dataBaseTreatmentDB = db;
    }

    @NonNull
    @Override
    public SheetTreatmentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_sheet_treatment, parent, false);
        SheetTreatmentHolder holder = new SheetTreatmentHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SheetTreatmentHolder holder, int position) {

        final Sheet_Treatment sheetTreatment = sheet_treatmentList.get(position);

        holder.treatmentDate.setText("التاريخ:- " + sheetTreatment.getCreatedWhen());
        holder.treatmentName.setText("الاسم:- " + sheetTreatment.getSheetName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Gson gson = new Gson();

                Intent intent = new Intent(mContext, sheet_TreatmentDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("model", sheetTreatment);
                bundle.putParcelableArrayList("sheet", (ArrayList<Treatment>) sheetTreatment.getTreatmentList());
                intent.putExtras(bundle);
//                intent.putExtra("model", sheetTreatment);
//                intent.putExtra("sheet", gson.toJson(list));
//                intent.putParcelableArrayListExtra("sheet", (ArrayList<Treatment>) list);

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sheet_treatmentList.size();
    }

    public class SheetTreatmentHolder extends RecyclerView.ViewHolder{
        public TextView treatmentName;
        public TextView treatmentTime;
        public TextView treatmentDate;

        public SheetTreatmentHolder(@NonNull View view) {
            super(view);
            this.treatmentName = view.findViewById(R.id.Name_SheetTreatment);
            this.treatmentTime = view.findViewById(R.id.Time_SheetTreatment);
            this.treatmentDate = view.findViewById(R.id.Date_SheetTreatment);
        }
    }
}