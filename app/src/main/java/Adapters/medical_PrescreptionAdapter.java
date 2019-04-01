package Adapters;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.sheet_TreatmentDetails.sheet_TreatmentDetailsActivity;

import java.util.List;
import Model.medical_Prescreption;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class medical_PrescreptionAdapter extends RecyclerView.Adapter<medical_PrescreptionAdapter.medical_PrescreptionHolder> {
    private Context mContext;
    private List<medical_Prescreption> bookingAll_items;


    public medical_PrescreptionAdapter(Context mContext, List<medical_Prescreption> bookingAll_items) {
        this.mContext = mContext;
        this.bookingAll_items = bookingAll_items;

    }

    @NonNull
    @Override
    public medical_PrescreptionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_sheet_treatment, parent, false);
        medical_PrescreptionHolder holder = new medical_PrescreptionHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull medical_PrescreptionHolder holder, int position) {

//        holder.prescreptionName.setText("الدكتور احمد الجعلى");
//        holder.prescreptiondate.setText("25/10/2019");
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                mContext.startActivity(new Intent(mContext, sheet_TreatmentDetailsActivity.class));
//                Animatoo.animateZoom(mContext);
//
//
////                mContext.startActivity(new Intent(mContext, sheet_TreatmentDetailsActivity.class));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class medical_PrescreptionHolder extends RecyclerView.ViewHolder{

//        protected TextView prescreptionName;
//        protected TextView prescreptiondate;

        public medical_PrescreptionHolder(@NonNull View itemView) {
            super(itemView);
//            this.prescreptionName = itemView.findViewById(R.id.prescreptionName);
//            this.prescreptiondate = itemView.findViewById(R.id.prescreptiondate);
        }
    }
}
