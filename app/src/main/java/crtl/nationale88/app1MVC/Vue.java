package crtl.nationale88.app1MVC;

import android.content.Context;
import android.graphics.Color;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class Vue extends LinearLayout implements Observer{
    //Def graphic objects
    Button btnPlus;
    Button btnMoin;
    TextView txt;
    TextClock clock;

    //Def ID Button
    final int BTN_PLUS = 0;
    final int BTN_MOIN = 1;

    Modele RefM;
    Controleur RefC;
    //constructor
    public Vue(Context context, Controleur c, Modele m) {
        super(context);
        setOrientation(VERTICAL);
        RefM = m;
        RefC = c;

        RefM.addObserver(this);

        //btnPlus set up
        btnPlus = new Button(context);
        btnPlus.setText("+");
        btnPlus.setId(BTN_PLUS);
        btnPlus.setOnClickListener(c);
        btnPlus.setTextSize(30);

        //btnMoin set Up
        btnMoin = new Button(context);
        btnMoin.setText("-");
        btnMoin.setId(BTN_MOIN);
        btnMoin.setOnClickListener(c);
        btnMoin.setTextSize(30);

        //txt set up
        txt = new TextView(context);
        txt.setText(Integer.toString(m.cpt));
        txt.setTextColor(Color.argb(255,255,255,255));
        txt.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        txt.setTextSize(40);

        clock=new TextClock(context);
        clock.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        clock.setTextSize(50);
        clock.setTextColor(Color.argb(255,125,0,125));

        //Add view of all
        addView(clock);
        addView(btnPlus);
        addView(txt);
        addView(btnMoin);

    }

    @Override
    public void update(Observable observable, Object o) {
        txt.setText(Integer.toString(RefM.cpt));
        if(RefM.cpt == RefM.MAX){
            btnPlus.setEnabled(false);
        }
        if(RefM.cpt == RefM.MIN){
            btnMoin.setEnabled(false);
        }
        if(RefM.cpt > RefM.MIN && RefM.cpt < RefM.MAX){
            btnMoin.setEnabled(true);
            btnPlus.setEnabled(true);
        }
        if(RefM.cpt >= 100){
            txt.setTextColor(Color.argb(255,255,0,0));
        }
        if(RefM.cpt < 100){
            txt.setTextColor(Color.argb(255,255,255,255));
        }
    }
}
