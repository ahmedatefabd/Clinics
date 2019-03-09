package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseBookingItem {


    @SerializedName("items")
    @Expose
    private List<BookingAll_Items> bookingAll_items = null;

    public List<BookingAll_Items> getItems() {
        return bookingAll_items;
    }

    public void setItems(List<BookingAll_Items> items) {
        this.bookingAll_items = items;
    }
}
