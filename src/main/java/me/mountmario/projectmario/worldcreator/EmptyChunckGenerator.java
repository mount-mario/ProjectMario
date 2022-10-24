package me.mountmario.projectmario.worldcreator;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import javax.annotation.Nonnull;
import java.util.Random;

public class EmptyChunckGenerator extends ChunkGenerator {
    public ChunkData generateChunckData(World world, Random random, int x, int z, BiomeGrid biome) {
        return  createChunkData(world);
    }
}
