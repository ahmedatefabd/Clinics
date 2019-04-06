package Adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.UploadLabs.UploadLabsActivity;
import java.util.List;
import Model.Labs;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

public class LabsDetailsAdapter extends RecyclerView.Adapter<LabsDetailsAdapter.LabsDetailsHolder>{

    private Context mContext;
    private List<Labs> labsList;

    public LabsDetailsAdapter(Context mContext, List<Labs> labsList1) {
        this.mContext = mContext;
        this.labsList = labsList1;
    }

    @NonNull
    @Override
    public LabsDetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_labs_details, parent, false);
        LabsDetailsHolder holder = new LabsDetailsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LabsDetailsHolder holder, int position) {

//        Labs labs = labsList.get(position);

        holder.name.setText("aaaaaaa");
        holder.description.setText("Ahmed Atef abd el_fattah");
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, UploadLabsActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class LabsDetailsHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView description;
        private AppCompatButton button;

        public LabsDetailsHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.Name_Labs_Details);
            description = itemView.findViewById(R.id.Description_Labs_Details);
            button = itemView.findViewById(R.id.addLabs);
        }
    }

}
