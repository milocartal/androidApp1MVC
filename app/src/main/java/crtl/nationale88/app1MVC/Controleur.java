package crtl.nationale88.app1MVC;

import android.view.View;

public class Controleur implements View.OnClickListener{
    Vue RefV;
    Modele RefM;

    public Controleur(Modele m){
        //setV(v);
        RefM = m;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case 0:
                RefM.plus();
                break;
            case 1:
                RefM.menos();
                break;
        }
    }

    void setV(Vue v){
        RefV = v;
    }

}
