package bagusandinata.t_muslim.View.Adapter;

import android.support.v7.widget.RecyclerView;

import bagusandinata.t_muslim.Model.Calendar;
import bagusandinata.t_muslim.ViewModel.ItemCalendarViewModel;
import bagusandinata.t_muslim.databinding.ItemCalendarBinding;

public class CalendarViewHolder extends RecyclerView.ViewHolder {
    ItemCalendarBinding itemCalendarBinding;

    public CalendarViewHolder(ItemCalendarBinding itemCalendarBinding) {
        super(itemCalendarBinding.itemCalendar);
        this.itemCalendarBinding = itemCalendarBinding;
    }

    void bindCalendar(Calendar calendar) {
        if (itemCalendarBinding.getItemCalendarViewModel() == null){
            itemCalendarBinding.setItemCalendarViewModel(
                    new ItemCalendarViewModel(calendar, itemView.getContext()));
        }else {
            itemCalendarBinding.getItemCalendarViewModel().setCalendar(calendar);
        }
    }
}
