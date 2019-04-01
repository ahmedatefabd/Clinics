package Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ragab.clinics.R;
import java.util.List;
import Model.Sheet_Labs;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SheetLabsAdapter extends RecyclerView.Adapter<SheetLabsAdapter.SheetLabsHolder>{

    private Context mContext;
    private List<Sheet_Labs> sheet_labsList;

    public SheetLabsAdapter(Context mContext, List<Sheet_Labs> sheet_labsList) {
        this.mContext = mContext;
        this.sheet_labsList = sheet_labsList;
    }

    @NonNull
    @Override
    public SheetLabsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_labs_down, parent, false);
        SheetLabsHolder holder = new SheetLabsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SheetLabsHolder holder, int position) {

        Sheet_Labs sheetLabs = sheet_labsList.get(position);

        String string = sheetLabs.getCreatedWhen();

        if (string != null){
            String[] parts = string.split("T", 2);

            String part1 = parts[0];
            String part2 = parts[1];

            holder.labsDate.setText("التاريخ:- "+ part1);
            holder.labsTime.setText("التوقيت:- " + part2);
        }else {
            holder.labsDate.setText("التاريخ:- "+ "----/--/--");
            holder.labsTime.setText("التوقيت:- " + "---/--");
        }



        holder.labstName.setText("الاسم:- " + sheetLabs.getSheetName());
    }

    @Override
    public int getItemCount() {
        return sheet_labsList.size();
    }

    public class SheetLabsHolder extends RecyclerView.ViewHolder{

        public TextView labstName;
        public TextView labsTime;
        public TextView labsDate;


        public SheetLabsHolder(@NonNull View view) {
            super(view);

            this.labstName = view.findViewById(R.id.Name_SheetLabs);
            this.labsTime = view.findViewById(R.id.Time_SheetLabs);
            this.labsDate = view.findViewById(R.id.Date_SheetLabs);
        }
    }
}
