package crtl.nationale88.app1MVC;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class Vue extends LinearLayout implements Observer{
    //Def graphic objects
    Button btnPlus;
    Button btnMoin;
    TextView txt;

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

        btnPlus = new Button(context);
        btnMoin = new Button(context);
        txt = new TextView(context);

        btnPlus.setText("+");
        btnMoin.setText("-");
        txt.setText(Integer.toString(m.cpt));

        btnPlus.setId(BTN_PLUS);
        btnMoin.setId(BTN_MOIN);

        btnPlus.setOnClickListener(c);
        btnMoin.setOnClickListener(c);

        addView(btnPlus);
        addView(txt);
        addView(btnMoin);
    }

    @Override
    public void update(Observable observable, Object o) {
        txt.setText(Integer.toString(RefM.cpt));
    }
}
