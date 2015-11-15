package io.github.kevinsu917.xpro.entrance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.prolificinteractive.parallaxpager.ParallaxContainer;
import com.prolificinteractive.parallaxpager.ParallaxContextWrapper;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import io.github.kevinsu917.xpro.BaseActivity;
import io.github.kevinsu917.xpro.R;

@EActivity(R.layout.activity_guide)
public class GuideActivity extends BaseActivity {

    @ViewById(R.id.parallax_container)
    ParallaxContainer parallaxContainer;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(new ParallaxContextWrapper(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    public void initView(){

        // specify whether pager will loop
        parallaxContainer.setLooping(false);

        // wrap the inflater and inflate children with custom attributes
        parallaxContainer.setupChildren(getLayoutInflater(),
                R.layout.guide_page_1,
                R.layout.guide_page_2,
                R.layout.guide_page_3,
                R.layout.guide_page_4);

    }

    public void enter(View view){
        Intent intent = new Intent(this, LoginActivity_.class);
        startActivity(intent);
        finish();
    }

}
