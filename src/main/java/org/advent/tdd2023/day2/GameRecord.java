package org.advent.tdd2023.day2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameRecord {
    private final int id;
    private final List<GameSet> sets = new ArrayList<>();

    public GameRecord(String input) {
        String[] strings = input.split(":");

        String gameId = strings[0];
        id =  Integer.parseInt(gameId.split(" ")[1]);

        String splitSets = strings[1];
        for (String set : splitSets.split(";")) {
            GameSet gameSet = new GameSet(set);
            sets.add(gameSet);
        }
    }

    public int id() {
        return id;
    }

    @Override
    public String toString() {
        return "GameRecord{" +
                "id=" + id +
                ", sets=" + sets +
                '}';
    }

    public Collection<GameSet> sets() {
        return sets;
    }
}
