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
import com.example.ragab.clinics.labs_Details.Labs_Details_Activity;
import java.util.ArrayList;
import java.util.List;
import Model.Labs;
import Model.Sheet_Labs;
import androidx.recyclerview.widget.RecyclerView;

public class SheetLabsAdapter extends RecyclerView.Adapter<SheetLabsAdapter.SheetLabsHolder>{
    private Context mContext;
    private List<Sheet_Labs> sheet_labsList;

    public SheetLabsAdapter(Context mContext, List<Sheet_Labs> sheet_labsList) {
        this.mContext = mContext;
        this.sheet_labsList = sheet_labsList;
    }

    @Override
    public SheetLabsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(mContext).inflate(R.layout.row_labs_down, parent, false);
        SheetLabsHolder holder = new SheetLabsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(SheetLabsHolder holder, int position) {
        final Sheet_Labs sheetLabs = sheet_labsList.get(position);
        String string = sheetLabs.getCreatedWhen();
        if (string != null){
            holder.labsDate.setText("التاريخ:- "+ string);
        }else {
            holder.labsDate.setText("التاريخ:- "+ "----/--/--");
        }
        holder.labstName.setText("الاسم:- " + sheetLabs.getSheetName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, Labs_Details_Activity.class));
                Intent intent = new Intent(mContext, Labs_Details_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("modelLabs", sheetLabs);
                bundle.putParcelableArrayList("listLabs", (ArrayList<Labs>) sheetLabs.getLabsList());
                intent.putExtras(bundle);
                Animatoo.animateSlideLeft(mContext);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sheet_labsList.size();
    }

    public class SheetLabsHolder extends RecyclerView.ViewHolder{
        public TextView labstName;
        public TextView labsTime;
        public TextView labsDate;


        public SheetLabsHolder(View view) {
            super(view);
            this.labstName = view.findViewById(R.id.Name_SheetLabs);
            this.labsTime = view.findViewById(R.id.Time_SheetLabs);
            this.labsDate = view.findViewById(R.id.Date_SheetLabs);
        }
    }
}