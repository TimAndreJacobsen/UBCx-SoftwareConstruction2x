package instrument.brass;

import Orchestra.Orchestra;

public class Saxophone extends BrassInstrument {

    public Saxophone(Orchestra orchestra) {
        super(orchestra);
        System.out.println("Sax created");
    }

    @Override
    public void play() {
        System.out.println("playing the saxophone, smooth tunes!");
    }
}
