package instrument.brass;

import Orchestra.Orchestra;
import instrument.Instrument;

import java.util.Objects;

public abstract class BrassInstrument implements Instrument {
    Orchestra orchestra;

    public BrassInstrument(Orchestra orchestra) {
        this.orchestra = orchestra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BrassInstrument)) return false;
        BrassInstrument that = (BrassInstrument) o;
        return Objects.equals(orchestra, that.orchestra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orchestra);
    }

    public abstract void play();
}
