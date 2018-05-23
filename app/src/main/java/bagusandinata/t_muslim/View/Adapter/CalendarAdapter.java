package bagusandinata.t_muslim.View.Adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import bagusandinata.t_muslim.R;
import bagusandinata.t_muslim.Model.Calendar;
import bagusandinata.t_muslim.databinding.ItemCalendarBinding;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {

    List<Calendar> calendarList;

    public CalendarAdapter() {
        this.calendarList = Collections.emptyList();
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCalendarBinding itemCalendarBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_calendar, parent, false );
        return new CalendarViewHolder(itemCalendarBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        holder.bindCalendar(calendarList.get(position));
    }

    @Override
    public int getItemCount() {
        return calendarList.size();
    }

    public void setCalendarList(List<Calendar> calendarList) {
        this.calendarList = calendarList;
        notifyDataSetChanged();
    }
}
