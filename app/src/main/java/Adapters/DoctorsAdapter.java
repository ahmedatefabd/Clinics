package Adapters;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.ragab.clinics.R;
import com.example.ragab.clinics.booking.BookingActivity;
import com.example.ragab.clinics.detailsClinic.DetailsClinicActivity;
import com.example.ragab.clinics.newRequest.newRequestActivity;
import com.squareup.picasso.Picasso;
import com.willy.ratingbar.ScaleRatingBar;
import java.util.List;
import Model.Doctors;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.DoctorsHolder> {

    private Context mContext;
    private List<Doctors> doctorsList;

    public DoctorsAdapter(Context mContext, List<Doctors> doctorsList) {
        this.mContext = mContext;
        this.doctorsList = doctorsList;
    }

    @NonNull
    @Override
    public DoctorsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(mContext).inflate(R.layout.row_doctor, parent, false);
        DoctorsHolder holder = new DoctorsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsHolder holder, int position) {
        holder.titleDoc.setText("الدكتور احمد الجعلى");
        Picasso.get().load(R.drawable.doctor).into(holder.ImgDoc);
        holder.branchName.setText("Eng - Ahmed Bahaa");
        holder.FavDoc.setImageResource(R.drawable.favorite);
        holder.ratingDoc.setIsIndicator(true);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, DetailsClinicActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public class DoctorsHolder extends RecyclerView.ViewHolder {

        ImageView ImgDoc;
        TextView titleDoc;
        ImageView FavDoc;
        TextView branchName;
        ScaleRatingBar ratingDoc;

        public DoctorsHolder(@NonNull View itemView) {
            super(itemView);
            ImgDoc = itemView.findViewById(R.id.ImgDoc);
            titleDoc = itemView.findViewById(R.id.titleDoc);
            FavDoc = itemView.findViewById(R.id.FavDoc);
            branchName = itemView.findViewById(R.id.branch_name);
            ratingDoc = itemView.findViewById(R.id.ratingDoc);
        }
    }
}
