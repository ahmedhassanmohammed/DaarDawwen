package app.sunshine.com.example.android.daardawwen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout myDrawerlayout;
    private ActionBarDrawerToggle myToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDrawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        myToggle = new ActionBarDrawerToggle(this, myDrawerlayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        myDrawerlayout.addDrawerListener(myToggle);
        myToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Dashboard_Fragment dashboard_fragment = new Dashboard_Fragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, dashboard_fragment, "").commit();



        navigationView = (NavigationView) findViewById(R.id.navDrawer);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String title = item.getTitle().toString();

                switch (title) {
                    case "Dashboard":
                        Dashboard_Fragment dashboardFragment = new Dashboard_Fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, dashboardFragment, "").commit();
                        myDrawerlayout.closeDrawers();
                        break;
//                    case "Popular":
//                        Popular_Fragment popular_fragment = new Popular_Fragment();
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, popular_fragment, "").commit();
//                        myDrawerlayout.closeDrawers();
//                        break;
//                    case "Favorites":
//                        Favorites_Fragment favorites_fragment = new Favorites_Fragment();
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, favorites_fragment, "").commit();
//                        myDrawerlayout.closeDrawers();
//                        break;
//                    case "Logout":
//                        // intent to login activity
//                        break;
//                    case "Profile":
//                        profile_Fragment profileFragment = new profile_Fragment();
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_home, profileFragment, "").commit();
//                        myDrawerlayout.closeDrawers();
//                        break;
//                    case "Settings":
//                        // intent to settings
//                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (myToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

}
