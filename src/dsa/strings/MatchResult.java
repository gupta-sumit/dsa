package dsa.strings;

import java.util.ArrayList;
import java.util.List;

public class MatchResult {

    private boolean match = false;
    private List<Integer> matchIndexes = new ArrayList<>();

    public MatchResult() {

    }

    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public List<Integer> getMatchIndexes() {
        return matchIndexes;
    }

    public void setMatchIndexes(List<Integer> matchIndexes) {
        this.matchIndexes = matchIndexes;
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "match=" + match +
                ", matchIndexes=" + matchIndexes +
                '}';
    }
}
