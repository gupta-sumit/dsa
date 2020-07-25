package design.callcenter;

import java.util.Objects;

public class Level implements Comparable<Level> {

    private final int value;
    private final Role role;

    public Level(int value, Role role) {
        this.value = value;
        this.role = role;
    }

    @Override
    public int compareTo(Level level) {
        return this.value > level.value ? 1 : (this.value < level.value ?  -1 : 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Level level = (Level) o;
        return value == level.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
