package instrument.string;

import Orchestra.Orchestra;

public class Violin extends StringInstrument {

    public Violin(Orchestra orchestra) {
        super(orchestra);
        System.out.println("Violin created");
    }

    @Override
    public void play() {
        System.out.println("Violin vibrates with pleasant sounding tones");
    }
}
