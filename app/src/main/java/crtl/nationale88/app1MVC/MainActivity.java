package crtl.nationale88.app1MVC;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Vue v;
    Modele m = new Modele();
    Controleur c = new Controleur(m);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = new Vue(this, c, m);
        c.setV(v);
        setContentView(v);
    }
}