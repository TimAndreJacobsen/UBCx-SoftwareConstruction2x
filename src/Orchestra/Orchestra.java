package Orchestra;

import instrument.brass.BrassInstrument;
import instrument.string.StringInstrument;

import java.util.ArrayList;

public class Orchestra {
    ArrayList <BrassInstrument> brassInstruments;
    ArrayList <StringInstrument> stringInstruments;

    public Orchestra(ArrayList<BrassInstrument> brassInstruments, ArrayList<StringInstrument> stringInstruments) {
        this.brassInstruments = brassInstruments;
        this.stringInstruments = stringInstruments;
        System.out.println("Orchestra booting up");
    }

    public void play() {
        System.out.println("Let the music begin!\n");
        for (BrassInstrument brassInstrument : brassInstruments) {
            brassInstrument.play();
        }

        for (StringInstrument stringInstrument : stringInstruments) {
            stringInstrument.play();
        }
    }

}
