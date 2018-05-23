package bagusandinata.t_muslim.View.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import bagusandinata.t_muslim.View.Fragment.FragmentCalendar;
import bagusandinata.t_muslim.View.Fragment.FragmentQibla;
import bagusandinata.t_muslim.View.Fragment.FragmentSchedule;
import bagusandinata.t_muslim.View.Fragment.FragmentSetting;
import bagusandinata.t_muslim.R;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment(new FragmentSchedule());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.schedule:
                fragment = new FragmentSchedule();
                break;
            case R.id.qibla:
                fragment = new FragmentQibla();
                break;
            case R.id.calendar:
                fragment = new FragmentCalendar();
                break;
            case R.id.setting:
                fragment = new FragmentSetting();
                break;
        }
        return initFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private boolean initFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
