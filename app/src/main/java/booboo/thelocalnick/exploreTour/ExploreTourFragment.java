package booboo.thelocalnick.exploreTour;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

import booboo.thelocalnick.R;

/**
 * Created by ishankothari on 2/16/17.
 */

public class ExploreTourFragment extends AppCompatActivity {
    //TODO convert to fragment once the other team finishes the home page and this fragment can be linked to

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_explore_tour);

        LinearLayout llMore = (LinearLayout) findViewById(R.id.llMore);
        llMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(ExploreTourFragment.this, view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menuItemReport:
                                return true;
                            case R.id.menuItemCreate:
                                return true;
                        }
                        return false;
                    }
                });
                popupMenu.inflate(R.menu.more_popup);
                popupMenu.show();
            }
        });

        ImageView bookImage = (ImageView) findViewById(R.id.bookBtn);
        bookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_explore_tour, new ConfirmTourFragment()).commit();


            }
        });
        Calendar now = Calendar.getInstance();
        final TimePickerDialog tpd = TimePickerDialog.newInstance(
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
                        String time = "You picked the following time: " + hourOfDay + "h" + minute + "m" + second;

                    }
                },
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                false
        );
        tpd.setAccentColor(getResources().getColor(R.color.colorPrimary));
        ImageView clockBtn=(ImageView)findViewById(R.id.pickTimeBtn);
        clockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tpd.show(getFragmentManager(), "TimePickerDialog");
            }
        });

    }






    /*@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_explore_tour, container, false);

        return rootView;
    }*/
}
