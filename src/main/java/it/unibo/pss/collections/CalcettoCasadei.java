package it.unibo.pss.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.sound.midi.Patch;

public class CalcettoCasadei {

    static final String[] PLAYERS = new String[] {
        "Roberto Casadei",
        "Danilo Pianini",
        "Dario Bibbo",
        "Alex Bobbo",
        "Alessandro Peepi",
        "Elena Kozman",
        "Lorenzo Giggino",
        "Ran Blu",
        "Sara Montagna"
    };

    public static void main(String[] args) {
        final Set<String> participants = new HashSet<>();
        final Collection<String> candidates =
        // Set.of(
        //     "Roberto Casadei",
        //     "Danilo Pianini",
        //     "Dario",
        //     "Alex",
        //     "Alessandro"
        // );
            new LinkedHashSet<>();
        for (final var player: PLAYERS) {
            candidates.add(player);
            System.out.println("New player: " + player);
        }
        final Iterator<String> canditatesIterator = candidates.iterator();
        for (int i = 0; i < 4 && canditatesIterator.hasNext(); i++) {
            final String player = canditatesIterator.next();
            System.out.println("Aggiungo al calcetto: " + player);
            participants.add(player);
        }
        System.out.println(participants);
        System.out.println("Casadei sta male e lascia il calcetto");
        final Set<String> retired = new HashSet<>();
        retired.add("Roberto Casadei");
        participants.removeAll(retired);
        for (final var player: candidates) {
            if (
                participants.size() < 4
                && !retired.contains(player)
            ) {
                participants.add(player);
            }
        }
        System.out.println("Alla fine giocano: " + participants);
    }
}