package it.unibo.pss.io;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Mkdir {

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException(
                "This program requires exactly one parameter, none passed"
            );
        }
        if (args.length > 1) {
            throw new IllegalArgumentException(
                "This program requires exactly one parameter, passed: "
                + Arrays.toString(args)
            );
        }
        final var pathToCreate = args[0];
        final File myNewFolder = new File(pathToCreate);
        if (myNewFolder.exists()) {
            throw new IllegalArgumentException("The file already exists");
        }
        if (myNewFolder.mkdirs()) {
            System.out.println("Created directory: " + myNewFolder);
        } else {
            throw new IllegalStateException("Cannot create directory " + myNewFolder);
        }
    }
}
