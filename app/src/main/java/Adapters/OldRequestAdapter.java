package Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ragab.clinics.R;
import java.util.List;
import Model.BookingAll_Items;
import androidx.recyclerview.widget.RecyclerView;

public class OldRequestAdapter extends RecyclerView.Adapter<OldRequestAdapter.OldRequestHolder> {
    private Context mContext;
    private List<BookingAll_Items> bookingAll_items;

    public OldRequestAdapter(Context mContext, List<BookingAll_Items> bookingAll_items) {
        this.mContext = mContext;
        this.bookingAll_items = bookingAll_items;
    }

    @Override
    public OldRequestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.old_request_item, parent, false);
        OldRequestHolder holder = new OldRequestHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(OldRequestHolder holder, int position) {
        final BookingAll_Items bookingAllItems = bookingAll_items.get(position);
        holder.requestName.setText("الدكتور احمد الجعلى");
        holder.RequestDate.setText(bookingAllItems.getAppointmentDate());
        holder.Requeststatues.setText("Cost:- " + String.valueOf(bookingAllItems.getCost()));
    }

    @Override
    public int getItemCount() {
        return bookingAll_items.size();
    }

    public class OldRequestHolder extends RecyclerView.ViewHolder {
        protected TextView RequestDate;
        protected TextView Requeststatues;
        protected TextView requestName;

        public OldRequestHolder(View view) {
            super(view);
            this.requestName = view.findViewById(R.id.requestname);
            this.RequestDate = view.findViewById(R.id.oldrequestdate);
            this.Requeststatues = view.findViewById(R.id.requeststatues);
        }
    }
}
