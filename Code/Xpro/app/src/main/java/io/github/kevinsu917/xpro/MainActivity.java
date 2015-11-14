package io.github.kevinsu917.xpro;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.github.kevinsu917.xpro.setting.SettingsActivity_;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity {


    //  这是一次错误的提交

    FloatingActionButton btn;
    ShareActionProvider shareActionProvider;

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

        Typeface typeFaceName =Typeface.createFromAsset(getAssets(),"fonts/Roboto-Medium.ttf");
        tvName.setTypeface(typeFaceName);
        Typeface typeFaceMood =Typeface.createFromAsset(getAssets(),"fonts/Roboto-Regular.ttf");
        tvMood.setTypeface(typeFaceMood);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setShowHideAnimationEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int itemId = menuItem.getItemId();
                if(itemId == R.id.itemSettings){
                    Intent intent = new Intent(MainActivity.this, SettingsActivity_.class);
                    startActivity(intent);
                    return true;
                }

                return false;
            }
        });

        btn = (FloatingActionButton) findViewById(R.id.fab);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if (actionBar.isShowing()) {
//                    actionBar.hide();
//                    showSnackbar(view);
//                } else {
//                    showSnackbar(view);
//                    actionBar.show();
//                }

//                HttpReqManager.getInstance(MainActivity.this).requet();

                Intent intent = new Intent(MainActivity.this, ChildActivity_.class);
                startActivity(intent);
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//        MenuItem aboutItem = menu.findItem(R.id.action_about);
//        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(aboutItem);
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_SEND);
//        intent.setType("image/*");
//        intent.putExtra(Intent.EXTRA_STREAM, "....");
//        setShareIntent(intent);
//        return true;
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        } else if (id == R.id.action_about) {
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_SEND);
//            intent.setType("image/*");
//            intent.putExtra(Intent.EXTRA_STREAM, "....");
//            setShareIntent(intent);
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }



    private void showSnackbar(View view) {

        final Snackbar snackbar = Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG);
        snackbar.setAction("ok", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
        snackbar.show();
    }

    private void setShareIntent(Intent shareIntent){
        if(shareActionProvider != null){
            shareActionProvider.setShareIntent(shareIntent);
        }
    }
}
