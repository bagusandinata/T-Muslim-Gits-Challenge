package bagusandinata.t_muslim.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import bagusandinata.t_muslim.Model.Calendar;
import bagusandinata.t_muslim.Network.IMyApi;
import bagusandinata.t_muslim.TMuslimApplication;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class CalendarViewModel extends BaseObservable{

    private List<Calendar> calendarList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public CalendarViewModel(@NonNull Context context) {
        this.context = context;
        this.calendarList = new ArrayList<>();
        fetchCalendarList();
    }

    public void fetchCalendarList(){
        TMuslimApplication tMuslimApplication = TMuslimApplication.create(context);
        IMyApi iMyApi = tMuslimApplication.getiMyApi();

        Disposable disposable = iMyApi.getCalendar()
                .subscribeOn(tMuslimApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Calendar>>() {
                    @Override
                    public void accept(List<Calendar> calendars) throws Exception {
                        changeCalendarDataSet(calendars);
                    }
                });

        compositeDisposable.add(disposable);
    }

    private void changeCalendarDataSet(List<Calendar> calendars){
        calendarList.addAll(calendars);
    }

    public List<Calendar> getCalendarList() {
        return calendarList;
    }

    private void unSubscribeFromObservable(){
        if (compositeDisposable != null && !compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }

    public void reset(){
        unSubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }
}
