package instrument.brass;

import Orchestra.Orchestra;

public class Trumpet extends BrassInstrument {

    public Trumpet(Orchestra orchestra) {
        super(orchestra);
        System.out.println("Trumpet created");
    }

    @Override
    public void play() {
        System.out.println("Trumpet playing a jazzy tune");
    }
}
