package it.unibo.pss.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Player implements Comparable<Player> {
    private final String name;
    private final String surname;
    private int skill;

    public Player(final String name, final String surname, final int skill) {
        this.name = name;
        this.surname = surname;
        this.skill = skill;
    }

    @Override
    public int compareTo(final Player other) {
        final var compareSurnames = surname.compareTo(other.surname);
        if (compareSurnames == 0) {
            return this.name.compareTo(other.name);
        }
        return compareSurnames;
    }

    public int getSkill() {
        return skill;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return surname + " " + name + " level: " + skill;
    }

    public static int generateSkill(Random generator) {
        return 60 + generator.nextInt(40);
    }

    public static void main(String[] args) {
        final Set<Player> playerSet = new TreeSet<Player>();
        final Random randomGenerator = new Random(1);
        for (final String player: CalcettoCasadei.PLAYERS) {
            final String[] identity = player.split(" ");
            playerSet.add(
                new Player(
                    identity[0],
                    identity[1],
                    generateSkill(randomGenerator)
                )
            );
        }
        System.out.println(playerSet);
        final Set<Player> playersBySkill = new TreeSet<Player>(
            new ByBestPlayer()
        );
        playersBySkill.addAll(playerSet);
        System.out.println("=====================");
        System.out.println(playersBySkill);
        final List<Player> playerList = new LinkedList<>(playerSet);
        System.out.println("=====================");
        System.out.println(playerList);
        System.out.println(playerList.get(4));
        Collections.sort(playerList, new ByBestPlayer());
        System.out.println("=====================");
        System.out.println(playerList);
        Collections.shuffle(playerList);
        System.out.println("----------------");
        System.out.println(playerList);
        Collections.shuffle(playerList);
        System.out.println("----------------");
        System.out.println(playerList);
        final var unmodifiable = Collections.unmodifiableList(playerList);
        System.out.println("----------------");
        System.out.println("Unmodifiable: " + unmodifiable);
        Collections.shuffle(unmodifiable);
    }
}
