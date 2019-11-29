package fr.dta.ovg.fixtures;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;

public class UniqFakeStore {

    private final Set<String> uniqStore = new TreeSet<>();

    private Supplier<String> valueGen;

    public UniqFakeStore(final Supplier<String> valueGen) {
        this.valueGen = valueGen;
    }

    public String genUniqValue() {

        boolean notFound = true;

        String value = null;

        while(notFound) {
            value = this.valueGen.get();

            if (!this.uniqStore.contains(value)) {
                this.uniqStore.add(value);
                notFound = false;
            }
        }
        return value;
    }
}
