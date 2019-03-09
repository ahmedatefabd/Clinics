package custom_views;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class Arabic_Button extends androidx.appcompat.widget.AppCompatButton {
    public Arabic_Button (Context context, AttributeSet attrs) {
        super (context, attrs);
        this.setTypeface (Typeface.createFromAsset (context.getAssets (), "fonts/GE_SS_Text_Light.otf"));
    }
}
