package Adapters;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.x_Rays_Details.X_Rays_Details_Activity;
import java.util.ArrayList;
import java.util.List;
import Model.Sheet_XRays;
import Model.Xrays;
import androidx.recyclerview.widget.RecyclerView;

public class SheetXRayAdapter extends RecyclerView.Adapter<SheetXRayAdapter.SheetXRayHolder>{
    private Context mContext;
    private List<Sheet_XRays> sheet_xRaysList;

    public SheetXRayAdapter(Context mContext, List<Sheet_XRays> sheet_xRaysList) {
        this.mContext = mContext;
        this.sheet_xRaysList = sheet_xRaysList;
    }

    @Override
    public SheetXRayHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_xrays_down, parent, false);
        SheetXRayHolder holder = new SheetXRayHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(SheetXRayHolder holder, int position) {
        final Sheet_XRays sheetXRays = sheet_xRaysList.get(position);
        String string = sheetXRays.getCreatedWhen();
        if (string != null){
            holder.xrayDate.setText("التاريخ:- "+ string);
        }else {
            holder.xrayDate.setText("التاريخ:- "+ "----/--/--");
        }
        holder.xraytName.setText("الاسم:- " + sheetXRays.getSheetName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, X_Rays_Details_Activity.class));
                Intent intent = new Intent(mContext, X_Rays_Details_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("modelXRay", sheetXRays);
                bundle.putParcelableArrayList("listXray", (ArrayList<Xrays>) sheetXRays.getXraysList());
                intent.putExtras(bundle);
                Animatoo.animateSlideLeft(mContext);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sheet_xRaysList.size();
    }

    public class SheetXRayHolder extends RecyclerView.ViewHolder{
        public TextView xraytName;
        public TextView xrayTime;
        public TextView xrayDate;

        public SheetXRayHolder(View view) {
            super(view);
            this.xraytName = view.findViewById(R.id.Name_SheetXRays);
            this.xrayTime = view.findViewById(R.id.Time_SheetXRays);
            this.xrayDate = view.findViewById(R.id.Date_SheetXRays);
        }
    }
}