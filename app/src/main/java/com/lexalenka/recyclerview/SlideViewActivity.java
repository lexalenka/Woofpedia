package com.lexalenka.recyclerview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by v622721 on 1/19/17.
 */
public class SlideViewActivity extends AppCompatActivity implements View.OnClickListener{
    //public int librarySize = getResources().getStringArray(R.array.titles).length;
    private List<Properties> dogList;
    int position;
    TextView slideTitle, infoContents;
    ImageView centerImage;
    Toolbar slideToolbar;
    ImageButton backButton, favoriteButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.infoslide);

        dogList = (List<Properties>)getIntent().getSerializableExtra("list");

        position= (int) getIntent().getExtras().get("position");

        slideTitle = (TextView) findViewById(R.id.slideTitle);
        slideTitle.setText(dogList.get(position).getName());

        infoContents = (TextView) findViewById(R.id.infoContents);
        infoContents.setText(dogList.get(position).getInfo());


        centerImage = (ImageView) findViewById(R.id.centerImage);
        centerImage.setImageResource(dogList.get(position).getThumbnail());


        slideToolbar = (Toolbar) findViewById(R.id.slideToolbar);
        slideToolbar.setTitle("");

        backButton = (ImageButton) findViewById(R.id.backButton);
        backButton.setOnClickListener(SlideViewActivity.this);

        favoriteButton = (ImageButton) findViewById(R.id.favoriteButton);
        favoriteButton.setOnClickListener(SlideViewActivity.this);

    }



    @Override
    public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.favoriteButton:
                        //Toast.makeText(this, "Add to favourite", Toast.LENGTH_SHORT).show();
                        SharedPreferences favorites = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

                        SharedPreferences.Editor editor = favorites.edit();
                        editor.putString("favorite",dogList.get(position).getName());
                        editor.commit();

                        Toast.makeText(this, favorites.getString("favorite",""), Toast.LENGTH_LONG).show();



                        break;

                    case R.id.backButton:
                        Intent mainStart = new Intent(this, MainActivity.class);
                        startActivity(mainStart);
                        break;


                }
    }
}
