package AdaptersOfflin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ragab.clinics.R;

import java.util.List;

import Model.BookingAll_Items;
import ModelDB.BookingAll_ItemsDB;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OldRequestAdapterOfflin extends RecyclerView.Adapter<OldRequestAdapterOfflin.OldRequestOfflinHolder> {


    private Context mContext;
    private List<BookingAll_ItemsDB> bookingAll_itemsDBList;
    private int row_index = 0;


    public OldRequestAdapterOfflin(Context mContext, List<BookingAll_ItemsDB> bookingAll_itemsDBList) {
        this.mContext = mContext;
        this.bookingAll_itemsDBList = bookingAll_itemsDBList;
    }


    private static OldRequestAdapterOfflin instance;

    public static OldRequestAdapterOfflin getInstance(Context context, List<BookingAll_ItemsDB> bookingAll_itemsDBList) {
        if (instance == null) {
            synchronized (BookingAll_Items.class) {
                if (instance == null) {
                    System.out.println("getInstance(): First time getInstance was invoked!");
                    instance = new OldRequestAdapterOfflin(context, bookingAll_itemsDBList);
                }
            }
        }
        return instance;
    }

    @NonNull
    @Override
    public OldRequestOfflinHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.old_request_item, parent, false);
        OldRequestOfflinHolder holder = new OldRequestOfflinHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OldRequestOfflinHolder holder, int position) {

        final BookingAll_ItemsDB bookingAll_itemsDB = bookingAll_itemsDBList.get(position);
        String string = bookingAll_itemsDB.getAppointmentDate();
        String[] parts = string.split("T", 2);
        String part1 = parts[0];
        String part2 = parts[1];
        holder.RequestDate.setText("التاريخ:- "+part1);
        holder.RequestTime.setText("التوقيت:- " + part2);
        holder.Requeststatues.setText("تكلفه الحجز:- " +String.valueOf(bookingAll_itemsDB.getCost()));

    }

    @Override
    public int getItemCount() {
        return bookingAll_itemsDBList.size();
    }

    public class OldRequestOfflinHolder extends RecyclerView.ViewHolder {

        public TextView RequestDate;
        public TextView RequestTime;
        public TextView Requeststatues;

        public OldRequestOfflinHolder(@NonNull View itemView) {
            super(itemView);
            this.RequestDate = itemView.findViewById(R.id.oldrequestdate);
            this.RequestTime = itemView.findViewById(R.id.oldrequestTime);
            this.Requeststatues = itemView.findViewById(R.id.requeststatues);
        }
    }
}
