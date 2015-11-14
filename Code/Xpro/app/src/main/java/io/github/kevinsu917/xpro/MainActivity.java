package io.github.kevinsu917.xpro;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.github.kevinsu917.xpro.common.utils.Functions;
import io.github.kevinsu917.xpro.find.FindFragment;
import io.github.kevinsu917.xpro.messages.MessagesFragment;
import io.github.kevinsu917.xpro.mine.MineFragment;
import io.github.kevinsu917.xpro.setting.FeedbackActivity_;
import io.github.kevinsu917.xpro.setting.SettingsActivity_;
import io.github.kevinsu917.xpro.teach.TeachFragment;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity implements TeachFragment.OnFragmentInteractionListener, MessagesFragment.OnFragmentInteractionListener, FindFragment.OnFragmentInteractionListener, MineFragment.OnFragmentInteractionListener {

    private long exitTime = 0;

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    @ViewById(R.id.navigationView)
    NavigationView navigationView;

    @ViewById(R.id.tvName)
    TextView tvName;

    @ViewById(R.id.tvMood)
    TextView tvMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void initView() {

        Typeface typeFaceName = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        tvName.setTypeface(typeFaceName);
        Typeface typeFaceMood = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        tvMood.setTypeface(typeFaceMood);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                drawerLayout.closeDrawer(navigationView);

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                int itemId = menuItem.getItemId();
                if (itemId == R.id.itemTeach) {
                    fragmentTransaction.replace(R.id.rlContentRoot, TeachFragment.newInstance("", ""));
                    fragmentTransaction.commit();
                    return true;
                } else if (itemId == R.id.itemMessage) {
                    fragmentTransaction.replace(R.id.rlContentRoot, MessagesFragment.newInstance("", ""));
                    fragmentTransaction.commit();
                    return true;
                } else if (itemId == R.id.itemFind) {
                    fragmentTransaction.replace(R.id.rlContentRoot, FindFragment.newInstance("", ""));
                    fragmentTransaction.commit();
                    return true;
                } else if (itemId == R.id.itemMine) {
                    fragmentTransaction.replace(R.id.rlContentRoot, MineFragment.newInstance("", ""));
                    fragmentTransaction.commit();
                    return true;
                } else if (itemId == R.id.itemSettings) {
                    Intent intent = new Intent(MainActivity.this, SettingsActivity_.class);
                    startActivity(intent);
                    return true;
                } else if (itemId == R.id.itemFeedback) {
                    Intent intent = new Intent(MainActivity.this, FeedbackActivity_.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.action_about, R.string.action_settings) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerToggle.syncState();
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(navigationView)){
            drawerLayout.closeDrawer(navigationView);
        }else{
            exitApp();
        }
    }

    private void exitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Functions.toast(this, getString(R.string.common_quit_text));
            exitTime = System.currentTimeMillis();
        } else {
//            Functions.LoginOutSession(this);
            finish();
        }
    }
}
