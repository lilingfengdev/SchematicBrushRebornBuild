package de.eldoria.schematicbrush.brush.config;

import de.eldoria.schematicbrush.brush.PasteMutation;
import de.eldoria.schematicbrush.brush.config.builder.SchematicSetBuilder;
import de.eldoria.schematicbrush.brush.config.modifier.SchematicModifier;
import de.eldoria.schematicbrush.brush.config.provider.Mutator;
import de.eldoria.schematicbrush.brush.config.util.Randomable;
import de.eldoria.schematicbrush.schematics.Schematic;

import java.util.List;

/**
 * A class holding a set of schematics with weight and {@link Mutator}
 */
public interface SchematicSet extends Randomable {
    /**
     * Get the mutator
     *
     * @param type type
     * @return mutator
     */
    Mutator<?> getMutator(SchematicModifier type);

    /**
     * Get a random schematic from the set
     *
     * @return schematic
     */
    Schematic getRandomSchematic();

    /**
     * Update a not weighted brush.
     *
     * @param weight weight to set.
     * @throws IllegalStateException    when the weight is not -1 and this method is called.
     * @throws IllegalArgumentException when the weight is less than 1.
     */
    void updateWeight(int weight) throws IllegalStateException, IllegalArgumentException;

    /**
     * Schematics
     *
     * @return schematics
     */
    List<Schematic> schematics();

    /**
     * Weight of set
     *
     * @return weight
     */
    int weight();

    /**
     * Mutate the paste mutation with all mutators
     *
     * @param mutation mutation
     */
    void mutate(PasteMutation mutation);

    /**
     * Convert the set into a builder
     *
     * @return new builder instance
     */
    SchematicSetBuilder toBuilder();

    /**
     * Refresh the values of all mutators
     */
    void refreshMutator();
}
