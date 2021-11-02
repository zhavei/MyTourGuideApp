package com.example.mytourguideapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.text.MessageFormat;

public class DetailsActivity extends AppCompatActivity {
    WorldDataModel worldDataModel;
    private int categoryid = 1;
    private int locationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //get param
        categoryid = getIntent().getExtras().getInt("category");
        locationId = getIntent().getExtras().getInt("location");

        //set title/label activity for toolbar
        CollapsingToolbarLayout collapsingToolbarLayout1;
        collapsingToolbarLayout1 = (CollapsingToolbarLayout) findViewById(R.id.collapsing_tollbar);
        CollapsingToolbarLayout collapsingToolbarLayout2;
        collapsingToolbarLayout2 = (CollapsingToolbarLayout) findViewById(R.id.collapsing_tollbar);
        CollapsingToolbarLayout collapsingToolbarLayout3;
        collapsingToolbarLayout3 = (CollapsingToolbarLayout) findViewById(R.id.collapsing_tollbar);
        CollapsingToolbarLayout collapsingToolbarLayout4;
        collapsingToolbarLayout4 = (CollapsingToolbarLayout) findViewById(R.id.collapsing_tollbar);

        //set activity title
        switch (categoryid) {
            case 1:
                collapsingToolbarLayout1.setTitle(getResources().getString(R.string.category_title_1) + " " + getResources().getString(R.string.in_city_name));
                collapsingToolbarLayout1.setExpandedTitleTextAppearance(R.style.expanded_appbarr);
                collapsingToolbarLayout1.setCollapsedTitleTextAppearance(R.style.collapseAppBar);
                break;
            case 2:
                collapsingToolbarLayout2.setTitle(getResources().getString(R.string.category_title_2) + " " + getResources().getString(R.string.in_city_name));
                collapsingToolbarLayout2.setExpandedTitleTextAppearance(R.style.expanded_appbarr);
                collapsingToolbarLayout2.setCollapsedTitleTextAppearance(R.style.collapseAppBar);
                break;
            case 3:
                collapsingToolbarLayout3.setTitle(getResources().getString(R.string.category_title_3) + " " + getResources().getString(R.string.in_city_name));
                collapsingToolbarLayout3.setExpandedTitleTextAppearance(R.style.expanded_appbarr);
                collapsingToolbarLayout3.setCollapsedTitleTextAppearance(R.style.collapseAppBar);
                break;
            case 4:
                collapsingToolbarLayout4.setTitle(getResources().getString(R.string.category_title_4) + " " + getResources().getString(R.string.in_city_name));
                collapsingToolbarLayout4.setExpandedTitleTextAppearance(R.style.expanded_appbarr);
                collapsingToolbarLayout4.setCollapsedTitleTextAppearance(R.style.collapseAppBar);
                break;
        }
        //method load data to details
        getForDetailsActData();

        // set to each item view
        ImageView imageView = (ImageView) findViewById(R.id.image_view_details);
        imageView.setImageDrawable(worldDataModel.getImage());

        TextView mapsTextView = (TextView) findViewById(R.id.textview_goto_maps);
        mapsTextView.setText(MessageFormat.format("{0}, {1}", worldDataModel.getName(), worldDataModel.getAddress()));

        TextView webTextView = (TextView) findViewById(R.id.textview_goto_web);
        webTextView.setText(worldDataModel.getWebsite());

        TextView shareTextView = (TextView) findViewById(R.id.textview_goto_share);
        shareTextView.setText(worldDataModel.getShare());

        TextView infoTextDeskrip = (TextView) findViewById(R.id.info_text_deskription);
        infoTextDeskrip.setText(worldDataModel.getName());

        TextView textDeskription = (TextView) findViewById(R.id.textview_deskription);
        textDeskription.setText(worldDataModel.getDeskription());

        //behavior click
        RelativeLayout goToWeb = (RelativeLayout) findViewById(R.id._rela_goto_web);
        RelativeLayout goToMap = (RelativeLayout) findViewById(R.id.rela_goto_maps);
        RelativeLayout goToShare = (RelativeLayout) findViewById(R.id.rela_goto_share);

        goToWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(worldDataModel.getWebsite()));
                startActivity(intent);
            }
        });

        goToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=" + worldDataModel.getName() + ", " + getResources().getString(R.string.city_name)));
                startActivity(intent);
            }
        });
        goToShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Create an ACTION_SEND Intent*/
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                /*This will be the actual content you wish you share.*/
                String shareBody = worldDataModel.getName() + ", " + worldDataModel.getAddress() + ", " + worldDataModel.getWebsite();
                /*The type of the content is text, obviously.*/
                intent.setType("text/plain");
                /*Applying information Subject and Body.*/
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.share_subject));
                intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                /*Fire!*/
                startActivity(Intent.createChooser(intent, getString(R.string.share_using)));
            }
        });
    }

    private void getForDetailsActData() {
        int resoureId, imageId;
        String name, imageName, addres, web, share, deskription;
        Drawable image;

        resoureId = getResources().getIdentifier("location_image_" + categoryid + "_" + locationId, "string", getPackageName());
        imageName = getResources().getString(resoureId);
        imageId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        image = getResources().getDrawable(imageId);

        resoureId = getResources().getIdentifier("location_name_" + categoryid + "_" + locationId, "string", getPackageName());
        name = getResources().getString(resoureId);

        resoureId = getResources().getIdentifier("location_address_" + categoryid + "_" + locationId, "string", getPackageName());
        addres = getResources().getString(resoureId);

        resoureId = getResources().getIdentifier("location_web_" + categoryid + "_" + locationId, "string", getPackageName());
        web = getResources().getString(resoureId);

        resoureId = getResources().getIdentifier("share_subject", "string", getPackageName());
        share = getResources().getString(resoureId);

        resoureId = getResources().getIdentifier("location_description_" + categoryid + "_" + locationId, "string", getPackageName());
        deskription = getResources().getString(resoureId);

        worldDataModel = new WorldDataModel(name, image, addres, web, share, deskription);
    }
}