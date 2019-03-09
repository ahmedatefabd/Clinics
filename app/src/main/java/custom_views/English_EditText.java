package custom_views;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class English_EditText extends androidx.appcompat.widget.AppCompatEditText {
    public English_EditText (Context context, AttributeSet attrs) {
        super (context, attrs);
        this.setTypeface (Typeface.createFromAsset (context.getAssets (), "Poppins-Regular.ttf"));
    }
}
