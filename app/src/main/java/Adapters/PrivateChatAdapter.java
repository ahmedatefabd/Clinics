package Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.ragab.clinics.R;
import java.util.List;
import Model.ChatMessage;
import androidx.recyclerview.widget.RecyclerView;

public class PrivateChatAdapter extends RecyclerView.Adapter<PrivateChatAdapter.PrivateChatHolder> {
    private static final int MSG_TYPE_LEFT = 0;
    private static final int MSG_TYPE_RIGHT = 1;
    private Context context;
    private List<ChatMessage> chatMessageList;

    public PrivateChatAdapter(Context context, List<ChatMessage> messageList) {
        this.context = context;
        this.chatMessageList = messageList;
    }

    @Override
    public PrivateChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == MSG_TYPE_LEFT) {
            View row = LayoutInflater.from(context).inflate(R.layout.chat_item_right, parent, false);
            PrivateChatHolder holder = new PrivateChatHolder(row);
            return holder;
        }
        else {
            View row = LayoutInflater.from(context).inflate(R.layout.chat_item_left, parent, false);
            PrivateChatHolder holder = new PrivateChatHolder(row);
            return holder;
        }
    }

    @Override
    public void onBindViewHolder(PrivateChatHolder holder, int position) {
//        ChatMessage chatMessage = chatMessageList.get(position);
        holder.showMessage.setText("Ahmed Bahaa");
    }

    @Override
    public int getItemCount() {
       return 3;
    }

    public class PrivateChatHolder extends RecyclerView.ViewHolder {
        public TextView showMessage;

        public PrivateChatHolder(View itemView) {
            super(itemView);
            showMessage = itemView.findViewById(R.id.show_message);
        }
    }
}