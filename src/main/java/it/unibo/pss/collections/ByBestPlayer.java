package it.unibo.pss.collections;

import java.util.Comparator;

class ByBestPlayer implements Comparator<Player> {
    @Override public int compare(
        final Player player1,
        final Player player2
    ) {
        return Integer.compare(player2.getSkill(), player1.getSkill());
    }
}