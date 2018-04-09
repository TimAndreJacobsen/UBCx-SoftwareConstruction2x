package instrument.string;

import Orchestra.Orchestra;

public class Cello extends StringInstrument {

    public Cello(Orchestra orchestra) {
        super(orchestra);
        System.out.println("Cello created");
    }

    @Override
    public void play() {
        System.out.println("Cello hums a nice low bass");
    }
}
