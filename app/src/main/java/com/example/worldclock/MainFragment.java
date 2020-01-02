package com.example.worldclock;

import android.os.Bundle;

import androidx.core.util.Preconditions;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class MainFragment extends Fragment {
    private static final String KEY_TIME_ZONE_ID = "timeZoneId";
    private static final String FORMAT_DATE = "yyyy/MM/dd\nHH:mm:ss:SSS";
    private String timeZoneId;
    private TextView textView;

    public MainFragment() {
    }

    public static MainFragment newInstance(String timeZoneId) {
        MainFragment fragment = new MainFragment();
        Bundle arguments = new Bundle();
        arguments.putString(KEY_TIME_ZONE_ID, timeZoneId);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        textView = root.findViewById(R.id.clock);

        Bundle arguments = getArguments();
        Preconditions.checkNotNull(arguments);
        timeZoneId = arguments.getString(KEY_TIME_ZONE_ID);
        updateDate();

        return root;
    }

    public void updateDate() {
        if (timeZoneId == null) return;
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneId));
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE, Locale.JAPAN);

        textView.setText(dateFormat.format(calendar.getTime()));
    }
}
