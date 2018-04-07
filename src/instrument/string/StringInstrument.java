package instrument.string;

import Orchestra.Orchestra;
import instrument.Instrument;

import java.util.Objects;

public abstract class StringInstrument implements Instrument {
    Orchestra orchestra;

    public StringInstrument(Orchestra orchestra) {
        this.orchestra = orchestra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringInstrument)) return false;
        StringInstrument that = (StringInstrument) o;
        return Objects.equals(orchestra, that.orchestra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orchestra);
    }

    public abstract void play();
}
