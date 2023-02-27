package crtl.nationale88.app1MVC;

import java.util.Observable;

public class Modele extends Observable {

    //def limit
    final int MAX = 125;
    final int MIN = 65;

    //def of the cpt
    int cpt = MIN;

    //function to add
    void plus(){
        if(cpt<125){
            cpt++;
            setChanged();
            notifyObservers();
        }
    }

    void menos(){
        if(cpt>65){
            cpt--;
            setChanged();
            notifyObservers();
        }
    }

}
