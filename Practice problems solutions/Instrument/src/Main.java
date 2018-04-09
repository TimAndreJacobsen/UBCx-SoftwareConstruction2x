import Orchestra.Orchestra;
import instrument.brass.BrassInstrument;
import instrument.brass.Saxophone;
import instrument.brass.Trumpet;
import instrument.string.Cello;
import instrument.string.StringInstrument;
import instrument.string.Violin;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Initializing
        ArrayList<BrassInstrument> brassInstruments = new ArrayList<>();
        ArrayList<StringInstrument> stringInstruments = new ArrayList<>();

        Orchestra orchestra = new Orchestra(brassInstruments, stringInstruments);
        System.out.println();

        BrassInstrument saxophone = new Saxophone(orchestra);
        BrassInstrument trumpet = new Trumpet(orchestra);
        brassInstruments.add(saxophone);
        brassInstruments.add(trumpet);

        StringInstrument cello = new Cello(orchestra);
        StringInstrument violin = new Violin(orchestra);
        stringInstruments.add(cello);
        stringInstruments.add(violin);
        System.out.println();

        // Play some music
        orchestra.play();

    }



}
