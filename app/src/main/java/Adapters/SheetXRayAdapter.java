package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ragab.clinics.R;

import java.util.List;

import Model.Sheet_XRays;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SheetXRayAdapter extends RecyclerView.Adapter<SheetXRayAdapter.SheetXRayHolder>{

    private Context mContext;
    private List<Sheet_XRays> sheet_xRaysList;

    public SheetXRayAdapter(Context mContext, List<Sheet_XRays> sheet_xRaysList) {
        this.mContext = mContext;
        this.sheet_xRaysList = sheet_xRaysList;
    }

    @NonNull
    @Override
    public SheetXRayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_xrays_down, parent, false);
        SheetXRayHolder holder = new SheetXRayHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SheetXRayHolder holder, int position) {
        Sheet_XRays sheetXRays = sheet_xRaysList.get(position);

        String string = sheetXRays.getCreatedWhen();

        if (string != null){
            String[] parts = string.split("T", 2);

            String part1 = parts[0];
            String part2 = parts[1];

            holder.xrayDate.setText("التاريخ:- "+ part1);
            holder.xrayTime.setText("التوقيت:- " + part2);
        }else {
            holder.xrayDate.setText("التاريخ:- "+ "----/--/--");
            holder.xrayTime.setText("التوقيت:- " + "---/--");
        }



        holder.xraytName.setText("الاسم:- " + sheetXRays.getSheetName());
    }

    @Override
    public int getItemCount() {
        return sheet_xRaysList.size();
    }

    public class SheetXRayHolder extends RecyclerView.ViewHolder{

        public TextView xraytName;
        public TextView xrayTime;
        public TextView xrayDate;

        public SheetXRayHolder(@NonNull View view) {
            super(view);

            this.xraytName = view.findViewById(R.id.Name_SheetXRays);
            this.xrayTime = view.findViewById(R.id.Time_SheetXRays);
            this.xrayDate = view.findViewById(R.id.Date_SheetXRays);
        }
    }
}
