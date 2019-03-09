package custom_views;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class English_TextView extends androidx.appcompat.widget.AppCompatTextView {
    public English_TextView (Context context, AttributeSet attrs) {
        super (context, attrs);
        this.setTypeface (Typeface.createFromAsset (context.getAssets (), "Cairo_Light.ttf"));
    }
}
