package bagusandinata.t_muslim.View.Fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Observer;

import bagusandinata.t_muslim.View.Adapter.CalendarAdapter;
import bagusandinata.t_muslim.ViewModel.CalendarViewModel;
import bagusandinata.t_muslim.databinding.FragmentCalendarBinding;
import bagusandinata.t_muslim.R;

public class FragmentCalendar extends Fragment{

    Toolbar toolbar;

    private FragmentCalendarBinding fragmentCalendarBinding;
    private CalendarViewModel calendarViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        initDataBinding();
        fragmentCalendarBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_calendar, container, false);
        calendarViewModel = new CalendarViewModel(getContext());
        fragmentCalendarBinding.setFragmentCalendar(calendarViewModel);

        setupListCalenderView(fragmentCalendarBinding.listCalendar);
//        setupObserver(calendarViewModel);

        View view = fragmentCalendarBinding.getRoot();

        toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return view;
    }

    private void setupListCalenderView(RecyclerView listCalendar) {
        CalendarAdapter calendarAdapter = new CalendarAdapter();
        listCalendar.setAdapter(calendarAdapter);
        listCalendar.setLayoutManager(new LinearLayoutManager(getContext()));
    }


//    private void setupObserver(Observable observable) {
//        observable.addObserver(this);
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        calendarViewModel.reset();
    }

//    private void initDataBinding() {
//        fragmentCalendarBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_calendar);
//        calendarViewModel = new CalendarViewModel(getContext());
//        fragmentCalendarBinding.setFragmentCalendar(calendarViewModel);
//    }

//    @Override
//    public void update(Observable observable, Object arg) {
//        if (observable instanceof CalendarViewModel){
//            CalendarAdapter calendarAdapter = fragmentCalendarBinding.listCalendar.getAdapter();
//            CalendarViewModel calendarViewModel = observable;
//            calendarAdapter.setCalendarList(calendarViewModel.getCalendarList());
//        }
//    }
}
