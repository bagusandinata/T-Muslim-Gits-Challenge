package bagusandinata.t_muslim.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import bagusandinata.t_muslim.Model.Calendar;

public class ItemCalendarViewModel extends BaseObservable {

    private Calendar calendar;
    private Context context;

    public ItemCalendarViewModel(Calendar calendar, Context context) {
        this.calendar = calendar;
        this.context = context;
    }

    public int getDate(){
        return calendar.getDate();
    }

    public int getMonth(){
        return calendar.getMonth();
    }

    public int getYear(){
        return calendar.getYear();
    }

    public String getActivities(){
        return getActivities();
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
        notifyChange();
    }
}
