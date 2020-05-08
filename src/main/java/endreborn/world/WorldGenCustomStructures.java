package endreborn.world;

import java.util.Random;

import endreborn.handlers.ConfigsHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Arrays;
import java.util.List;

public class WorldGenCustomStructures implements IWorldGenerator

{

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator generator,
			IChunkProvider provider)
	{
		switch(world.provider.getDimension())
		{
			case 1:
				if(ConfigsHandler.GENERAL.spawnEndRuines)
				{
				generateStructure2(new WorldGenStructure("end_deco"), world, rand, chunkX, chunkZ, ConfigsHandler.BALANCE.ruinesRare, Blocks.END_STONE, BiomeEnd.class);
				}
				break;
				
			case 0:
				if(ConfigsHandler.GENERAL.spawnEndIsland)
				{
				generateStructure(new WorldGenStructure("end_island"), world, rand, chunkX, chunkZ, ConfigsHandler.BALANCE.islandRare, Blocks.AIR, BiomePlains.class);
				generateStructure(new WorldGenStructure("end_island"), world, rand, chunkX, chunkZ, ConfigsHandler.BALANCE.islandRare, Blocks.AIR, BiomeDesert.class);
				generateStructure(new WorldGenStructure("end_island"), world, rand, chunkX, chunkZ, ConfigsHandler.BALANCE.islandRare, Blocks.AIR, BiomeOcean.class);
				generateStructure(new WorldGenStructure("end_island"), world, rand, chunkX, chunkZ, ConfigsHandler.BALANCE.islandRare, Blocks.AIR, BiomeSavanna.class);
				}
				if(ConfigsHandler.GENERAL.spawnObservatory)
				{
				generateStructure3(new WorldGenStructure("observ"), world, rand, chunkX, chunkZ, ConfigsHandler.BALANCE.obsRare, Blocks.STONE, BiomeSwamp.class);
				generateStructure3(new WorldGenStructure("observ"), world, rand, chunkX, chunkZ, ConfigsHandler.BALANCE.obsRare, Blocks.STONE, BiomeForest.class);
				generateStructure3(new WorldGenStructure("observ"), world, rand, chunkX, chunkZ, ConfigsHandler.BALANCE.obsRare, Blocks.STONE, BiomeDesert.class);
				generateStructure3(new WorldGenStructure("observ"), world, rand, chunkX, chunkZ, ConfigsHandler.BALANCE.obsRare, Blocks.STONE, BiomeOcean.class);
				}
		
				break;

			case -1:
				
				
				break;

			case -64:

			
		}
	}

	private void generateStructure(WorldGenerator generator, World world, Random rand, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		List<Class<?>> classesList = Arrays.asList(classes);
		int x = (chunkX * 16) + rand.nextInt(15);
		int z = (chunkZ * 16) + rand.nextInt(15);
		int y = 90 + rand.nextInt(15);
		BlockPos pos = new BlockPos(x, y, z);
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(rand.nextInt(chance) == 0)
				{
					generator.generate(world, rand, pos);
				}
			}
		}
	}
	private void generateStructure2(WorldGenerator generator, World world, Random rand, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		List<Class<?>> classesList = Arrays.asList(classes);
		int x = (chunkX * 16) + rand.nextInt(15);
		int z = (chunkZ * 16) + rand.nextInt(15);
		int y = 50 + rand.nextInt(15);
		BlockPos pos = new BlockPos(x, y, z);
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
		if(world.getWorldType() != WorldType.FLAT && world.isBlockFullCube(pos.down()))
		{
			if(classesList.contains(biome))
			{
				if(rand.nextInt(chance) == 0)
				{
					generator.generate(world, rand, pos);
				}
			}
		}
	}

	private void generateStructure3(WorldGenerator generator, World world, Random rand, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes)
	{
		List<Class<?>> classesList = Arrays.asList(classes);
		int x = (chunkX * 16) + rand.nextInt(15);
		int z = (chunkZ * 16) + rand.nextInt(15);
		int y = 3;
		BlockPos pos = new BlockPos(x, y, z);
		Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();

		if(world.getWorldType() != WorldType.FLAT)
		{
			if(classesList.contains(biome))
			{
				if(rand.nextInt(chance) == 0)
				{
					generator.generate(world, rand, pos);
				}
			}
		}
	}

}

