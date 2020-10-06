package com.jdgonzalez907.superhero;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.jdgonzalez907.superhero.models.SuperHero;
import com.squareup.picasso.Picasso;

public class DetailSuperHeroActivity extends AppCompatActivity {

    private SuperHero superHero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_super_hero);

        Intent intent = getIntent();
        Bundle args = intent.getExtras();
        superHero = (SuperHero)args.getSerializable("superHeroData");

        ImageView ivImage = (ImageView)findViewById(R.id.img_super_hero_detail);
        TextView tvName = (TextView) findViewById(R.id.txt_name_super_hero_detail);
        TextView tvRealName = (TextView) findViewById(R.id.txt_real_name_super_hero_detail);
        TextView tvStrengthtDetail = (TextView) findViewById(R.id.txt_strength_detail);
        TextView tvSpeedDetail = (TextView) findViewById(R.id.txt_speed_detail);
        TextView tvDurabilityDetail = (TextView) findViewById(R.id.txt_durability_detail);
        TextView tvPowerDetail = (TextView) findViewById(R.id.txt_power_detail);
        TextView tvCombatDetail = (TextView) findViewById(R.id.txt_combat_detail);

        Picasso.get().load(superHero.getImage().getUrl()).error(R.drawable.user_default)
                .resize(240,240).centerCrop().into(ivImage);
        tvName.setText(superHero.getName());
        tvRealName.setText(superHero.getBiography().getFullName());
        tvStrengthtDetail.setText(superHero.getPowerstats().getStrength());
        tvSpeedDetail.setText(superHero.getPowerstats().getSpeed());
        tvDurabilityDetail.setText(superHero.getPowerstats().getDurability());
        tvPowerDetail.setText(superHero.getPowerstats().getPower());
        tvCombatDetail.setText(superHero.getPowerstats().getCombat());
    }
}