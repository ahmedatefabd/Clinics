package Adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.UploadLabs.UploadLabsActivity;
import java.util.List;
import Model.Labs;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

public class LabsDetailsAdapter extends RecyclerView.Adapter<LabsDetailsAdapter.LabsDetailsHolder>{
    private Context mContext;
    private List<Labs> labsList;

    public LabsDetailsAdapter(Context mContext, List<Labs> labsList1) {
        this.mContext = mContext;
        this.labsList = labsList1;
    }

    @Override
    public LabsDetailsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_labs_details, parent, false);
        LabsDetailsHolder holder = new LabsDetailsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(LabsDetailsHolder holder, int position) {
//        Labs labs = labsList.get(position);

        holder.name.setText("الاسم:- " + "CMV IgM");
        holder.Lab_Date.setText("التاريخ:- " + "12-JAN-2019");
        holder.description.setText("الوصف :- " + "في اي وقت");
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, UploadLabsActivity.class));
                Animatoo.animateSlideLeft(mContext);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class LabsDetailsHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView Lab_Date;
        private TextView description;
        private AppCompatButton button;

        public LabsDetailsHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name_Labs_Details);
            Lab_Date = itemView.findViewById(R.id.lab_Date);
            description = itemView.findViewById(R.id.Description_Labs_Details);
            button = itemView.findViewById(R.id.addLabs);
        }
    }

}
