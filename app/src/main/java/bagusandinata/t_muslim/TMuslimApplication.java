package bagusandinata.t_muslim;

import android.app.Application;
import android.content.Context;

import bagusandinata.t_muslim.Network.ApiFactory;
import bagusandinata.t_muslim.Network.IMyApi;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class TMuslimApplication extends Application{

    private IMyApi iMyApi;
    private Scheduler scheduler;

    private static TMuslimApplication get(Context context){
        return (TMuslimApplication) context.getApplicationContext();
    }

    public static  TMuslimApplication create(Context context){
        return TMuslimApplication.get(context);
    }

    public IMyApi getiMyApi() {
        if (iMyApi == null){
            Retrofit retrofit = ApiFactory.getInstance();
            iMyApi = retrofit.create(IMyApi.class);
        }
        return iMyApi;
    }

    public Scheduler subscribeScheduler(){
        if (scheduler == null){
            scheduler = Schedulers.io();
        }
        return scheduler;
    }
}
