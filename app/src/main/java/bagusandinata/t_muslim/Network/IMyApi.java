package bagusandinata.t_muslim.Network;

import java.util.List;

import bagusandinata.t_muslim.Model.Calendar;
import bagusandinata.t_muslim.Model.Schedule;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface IMyApi {
    @GET("calendar")
    Observable<List<Calendar>> getCalendar();
}
