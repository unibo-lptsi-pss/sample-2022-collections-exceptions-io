package it.unibo.pss.collections;

import java.util.Objects;

public class Moka {
    private final String brand;
    private final String model;
    private final int maxCoffees;
    private boolean coffeeLoaded;
    private boolean waterLoaded;

    public Moka(final String brand, final String model, final int maxCoffees) {
        this.brand = brand;
        this.model = model;
        this.maxCoffees = maxCoffees;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Moka && obj.getClass().equals(Moka.class)) {
            final Moka moka = (Moka) obj;
            return brand.equals(moka.brand)
                && model.equals(moka.model)
                && maxCoffees == moka.maxCoffees;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, maxCoffees);
    }
}
