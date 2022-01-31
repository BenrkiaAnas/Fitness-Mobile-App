package com.example.miniprojet.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.miniprojet.R;

public class SlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4
    };

    // list of titles
    public String[] lst_title = {
            "Entraînement",
            "Repas",
            "Exercices",
            "Régime"
    }   ;
    // list of descriptions
    public String[] lst_description = {
            "Amélioration de l'endurance, de la force musculaire et de la flexibilité diminution de la fatigue, augmentation de l'énergie, de la capacité de concentration et réduction du stress",
            "Nutriment essentiel qui permet à de nombreuses réactions d'avoir lieu, de sorte qu'il est indispensable au fonctionnement des organismes vivants. Il permet également le transport des nutriments et l'hydratation des tissus de l'organisme",
            "Un programme d'entraînement est une séquence harmonieuse de séance en vue d’atteindre un objectif. Celui-ci doit être Spécifique, Mesurable, Atteignable, Réaliste et situé dans le Temps",
            "Un régime alimentaire rassemble ce qu'une personne consomme, quel que soit l'objectif à atteindre : perte ou gain de poids, diminution de l'apport en graisses ou en glucides, ou aucun objectif particulier"
    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };


    public SlideAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

}
