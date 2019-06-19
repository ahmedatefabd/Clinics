package Adapters;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ragab.clinics.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import Model.BookingAll_Items;
import androidx.annotation.RequiresApi;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(OldRequestHolder holder, int position) {
        final BookingAll_Items bookingAllItems = bookingAll_items.get(position);
        String string = bookingAllItems.getAppointmentDate();
        String[] parts = string.split("T", 2);
        String part1 = parts[0];
        String part2 = parts[1];
        holder.RequestDate.setText(part1);
        String time = part2.replace(":00Z","");
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            final Date dateObj = sdf.parse(time);
            time = new SimpleDateFormat("hh:mm a").format(dateObj);
            holder.RequestTime.setText(time);
        } catch (final ParseException e) {
            e.printStackTrace();
        }

        holder.Requeststatues.setText("تكلفه الحجز:- " +String.valueOf(bookingAllItems.getCost()));
    }

    @Override
    public int getItemCount() {
        return bookingAll_items.size();
    }

    public class OldRequestHolder extends RecyclerView.ViewHolder {
        public TextView RequestDate;
        public TextView RequestTime;
        public TextView Requeststatues;

        public OldRequestHolder(View view) {
            super(view);
            this.RequestDate = view.findViewById(R.id.oldrequestdate);
            this.RequestTime = view.findViewById(R.id.oldrequestTime);
            this.Requeststatues = view.findViewById(R.id.requeststatues);
        }
    }
}