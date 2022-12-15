package it.unibo.pss.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class UseIterator {
    public static void main(String[] args) {
        final List<String> list = List.of("ciao", "mamma", "plut");
        final Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
        for(final String s: list) {
            System.out.println(s);
        }
        String[] asArray = list.toArray(new String[list.size()]);
        System.out.println(asArray);
        System.out.println(Arrays.toString(asArray));
    }
}
