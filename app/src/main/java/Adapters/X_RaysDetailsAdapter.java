package Adapters;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.Upload_X_Ray.Upload_X_RayActivity;
import java.util.List;
import Model.Xrays;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

public class X_RaysDetailsAdapter extends RecyclerView.Adapter<X_RaysDetailsAdapter.X_RaysDetailsHolder>{
    private Context mContext;
    private List<Xrays> labsList;

    public X_RaysDetailsAdapter(Context mContext, List<Xrays> labsList1) {
        this.mContext = mContext;
        this.labsList = labsList1;
    }

    @Override
    public X_RaysDetailsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_xrays_details, parent, false);
        X_RaysDetailsHolder holder = new X_RaysDetailsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(X_RaysDetailsHolder holder, int position) {
        holder.nameXRays.setText("aaaaaaaaa");
        holder.nameFile.setText("aaaaaaaaa");
        holder.OldOrNew.setText("aaaaaaaaa");
        holder.NmaePlace.setText("aaaaaaaaa");
        holder.description.setText("Ahmed Atef abd el_fattah");
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, Upload_X_RayActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class X_RaysDetailsHolder extends RecyclerView.ViewHolder{
        private TextView nameXRays;
        private TextView nameFile;
        private TextView OldOrNew;
        private TextView NmaePlace;
        private TextView description;
        private AppCompatButton button;

        public X_RaysDetailsHolder(View itemView) {
            super(itemView);
            nameXRays = itemView.findViewById(R.id.n1);
            nameFile = itemView.findViewById(R.id.n2);
            OldOrNew = itemView.findViewById(R.id.O_N);
            NmaePlace = itemView.findViewById(R.id.n3);
            description = itemView.findViewById(R.id.DE);
            button = itemView.findViewById(R.id.addpictureXrays);
        }
    }
}
