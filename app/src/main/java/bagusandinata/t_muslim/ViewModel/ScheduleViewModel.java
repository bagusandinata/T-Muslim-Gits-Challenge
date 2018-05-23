package bagusandinata.t_muslim.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import bagusandinata.t_muslim.Model.Schedule;

public class ScheduleViewModel extends BaseObservable{

    private Schedule mSchedule;
    private Context context;

    public ScheduleViewModel(Schedule mSchedule, Context context) {
        this.mSchedule = mSchedule;
        this.context = context;
        getData();
    }

    private void getData() {

    }

    public String getmLocation(){
        return mSchedule.mLocation;
    }

    public String getmSubuh() {
        return mSchedule.mSubuh;
    }

    public String getmDhuhur() {
        return mSchedule.mDhuhur;
    }

    public String getmAshar() {
        return mSchedule.mAshar;
    }

    public String getmMaghrib() {
        return mSchedule.mMaghrib;
    }

    public String getmIsya() {
        return mSchedule.mIsya;
    }
}
