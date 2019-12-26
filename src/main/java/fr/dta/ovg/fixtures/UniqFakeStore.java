/* Uniq Fake Store Fixture Class.
 * @author Colin Cerveaux @C-ambium
 * Action : Initialize DB with initials data.
 * License : ©2019 All rights reserved
 */
package fr.dta.ovg.fixtures;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;

/* UniqFakeStore Fixture Class.*/
public class UniqFakeStore {

    /** Unique local storage.*/
    private final Set<String> uniqStore = new TreeSet<>();

    /** String supplier local storage.*/
    private Supplier<String> valueGen;

    /** Local Constructor.
     * @param valueGen : the value to test.*/
    public UniqFakeStore(final Supplier<String> valueGen) {
        this.valueGen = valueGen;
    }

    /** Unique value generator function.
     * @return String never create before.
     * TODO Pass generic parameters to use it with any testing values.*/
    public String genUniqValue() {

        boolean notFound = true;

        String value = null;

        while (notFound) {
            value = this.valueGen.get();

            if (!this.uniqStore.contains(value)) {
                this.uniqStore.add(value);
                notFound = false;
            }
        }
        return value;
    }
}
