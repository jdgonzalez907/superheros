package com.jdgonzalez907.superhero;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jdgonzalez907.superhero.models.SuperHero;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SuperHeroReciclerViewAdapter extends RecyclerView.Adapter<SuperHeroReciclerViewAdapter.SuperHeroViewHolder> {
    public void setSuperHeroList(List<SuperHero> superHeroList) {
        this.superHeroList = superHeroList;
        notifyDataSetChanged();
    }

    private List<SuperHero> superHeroList;

    public SuperHeroReciclerViewAdapter() {
        this.superHeroList = new ArrayList<>();
    }

    @NonNull
    @Override
    public SuperHeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.super_hero_recicler_view_item, viewGroup, false);
        return new SuperHeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperHeroViewHolder superHeroViewHolder, int i) {
        SuperHero superHero = superHeroList.get(i);
        Picasso.get().load(superHero.getImage().getUrl()).error(R.drawable.user_default)
                .resize(48,48).centerCrop().into(superHeroViewHolder.ivImage);
        superHeroViewHolder.tvName.setText(superHero.getName());
        superHeroViewHolder.tvRealName.setText(superHero.getBiography().getFullName());
        superHeroViewHolder.superHero = superHero;
    }

    @Override
    public int getItemCount() {
        return superHeroList.size();
    }

    public class SuperHeroViewHolder extends RecyclerView.ViewHolder  {
        TextView tvName, tvRealName;
        ImageView ivImage;
        SuperHero superHero;

        public SuperHeroViewHolder(@NonNull final View itemView) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.img_super_hero);
            tvName = (TextView) itemView.findViewById(R.id.txt_name_super_hero);
            tvRealName = (TextView) itemView.findViewById(R.id.txt_real_name_super_hero);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailSuperHeroActivity.class);
                    intent.putExtra("superHeroData", superHero);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
