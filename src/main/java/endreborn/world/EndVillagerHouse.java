package endreborn.world;

import endreborn.handlers.EndVillagerHandler;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import net.minecraft.world.gen.structure.StructureVillagePieces.Village;
import net.minecraftforge.fml.common.registry.VillagerRegistry.IVillageCreationHandler;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;

import java.util.List;
import java.util.Random;


public class EndVillagerHouse extends Village
{
	

	public EndVillagerHouse()
	{
	}

	public EndVillagerHouse(Start villagePiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, EnumFacing facing)
	{
		super(villagePiece, par2);
		this.setCoordBaseMode(facing);
		this.boundingBox = par4StructureBoundingBox;
	}

	private int averageGroundLevel = -1;

	@Override
	public boolean addComponentParts(World world, Random random, StructureBoundingBox structBoundingBox) {

		if (averageGroundLevel < 0) {
			averageGroundLevel = getAverageGroundLevel(world, structBoundingBox);
			if (averageGroundLevel < 0) {
				return true;
			}

			boundingBox.offset(0, averageGroundLevel - boundingBox.maxY + 9 - 1, 0);
		}

	
		//Stair
		this.setBlockState(world, Blocks.STONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH), 4, 0, 0, structBoundingBox);

		// Floor
		IBlockState planks = Blocks.PLANKS.getDefaultState();
		IBlockState slabFloor = Blocks.WOODEN_SLAB.getDefaultState();
		fillWithBlocks(world, structBoundingBox, 2, 0, 1, 6, 0, 4, slabFloor, slabFloor, false);
		fillWithBlocks(world, structBoundingBox, 1, 0, 1, 1, 0, 4, planks, planks, false);
		fillWithBlocks(world, structBoundingBox, 7, 0, 1, 7, 0, 4, planks, planks, false);

		IBlockState cobblestoneState = Blocks.COBBLESTONE.getDefaultState();
		fillWithBlocks(world, structBoundingBox, 0, 0, 0, 0, 2, 5, cobblestoneState, cobblestoneState, false);
		fillWithBlocks(world, structBoundingBox, 8, 0, 0, 8, 2, 5, cobblestoneState, cobblestoneState, false);
		fillWithBlocks(world, structBoundingBox, 1, 0, 0, 7, 1, 0, cobblestoneState, cobblestoneState, false);
		fillWithBlocks(world, structBoundingBox, 1, 0, 5, 7, 1, 5, cobblestoneState, cobblestoneState, false);

		fillWithBlocks(world, structBoundingBox, 0, 3, 0, 0, 3, 5, planks, planks, false);
		fillWithBlocks(world, structBoundingBox, 8, 3, 0, 8, 3, 5, planks, planks, false);
		fillWithBlocks(world, structBoundingBox, 1, 2, 0, 7, 3, 0, planks, planks, false);
		fillWithBlocks(world, structBoundingBox, 1, 2, 5, 7, 3, 5, planks, planks, false);

		// Ceiling
		IBlockState slabCeiling = Blocks.WOODEN_SLAB.getDefaultState();
		fillWithBlocks(world, structBoundingBox, 1, 4, 1, 7, 4, 4, slabCeiling, slabCeiling, false);

		IBlockState logBracing = Blocks.STONEBRICK.getDefaultState();
		fillWithBlocks(world, structBoundingBox, 0, 4, 1, 8, 4, 1, logBracing, logBracing, false);
		fillWithBlocks(world, structBoundingBox, 0, 4, 4, 8, 4, 4, logBracing, logBracing, false);

		fillWithBlocks(world, structBoundingBox, 0, 5, 2, 8, 5, 3, planks, planks, false);

		setBlockState(world, planks, 0, 4, 2, structBoundingBox);
		setBlockState(world, planks, 0, 4, 3, structBoundingBox);
		setBlockState(world, planks, 8, 4, 2, structBoundingBox);
		setBlockState(world, planks, 8, 4, 3, structBoundingBox);

		buildRoof(world, structBoundingBox);

		// sides of windows
		setBlockState(world, planks, 0, 2, 1, structBoundingBox);
		setBlockState(world, planks, 0, 2, 4, structBoundingBox);
		setBlockState(world, planks, 8, 2, 1, structBoundingBox);
		setBlockState(world, planks, 8, 2, 4, structBoundingBox);

		IBlockState glassPaneState = Blocks.IRON_BARS.getDefaultState();

		// Windows on east side
		setBlockState(world, glassPaneState, 0, 2, 2, structBoundingBox);
		setBlockState(world, glassPaneState, 0, 2, 3, structBoundingBox);
		// stairs over window
		IBlockState eastStairs = Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.EAST);
		setBlockState(world, eastStairs, -1, 3, 2, structBoundingBox);
		setBlockState(world, eastStairs, -1, 3, 3, structBoundingBox);

		// Windows on west side
		setBlockState(world, glassPaneState, 8, 2, 2, structBoundingBox);
		setBlockState(world, glassPaneState, 8, 2, 3, structBoundingBox);
		// stairs over window
		IBlockState westStairs = Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.WEST);
		setBlockState(world, westStairs, 9, 3, 2, structBoundingBox);
		setBlockState(world, westStairs, 9, 3, 3, structBoundingBox);

		// Windows garden side
		setBlockState(world, glassPaneState, 2, 2, 5, structBoundingBox);
		setBlockState(world, glassPaneState, 3, 2, 5, structBoundingBox);
		setBlockState(world, glassPaneState, 4, 2, 5, structBoundingBox);

		// Windows front side
		setBlockState(world, glassPaneState, 5, 2, 0, structBoundingBox);
		setBlockState(world, glassPaneState, 6, 2, 5, structBoundingBox);


		IBlockState airState = Blocks.AIR.getDefaultState();

		this.setBlockState(world, Blocks.DARK_OAK_DOOR.getDefaultState().withProperty(BlockDoor.FACING, EnumFacing.NORTH), 2, 1, 0, structBoundingBox);
		this.setBlockState(world, Blocks.DARK_OAK_DOOR.getDefaultState().withProperty(BlockDoor.FACING, EnumFacing.NORTH).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER), 2, 2, 0, structBoundingBox);

		this.setBlockState(world, Blocks.TORCH.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.NORTH), 2, 3, 1, structBoundingBox);

		if (isAirBlockAtCurrentPosition(world, new BlockPos(2, 0, -1), structBoundingBox) && !isAirBlockAtCurrentPosition(world, new BlockPos(2, -1, -1), structBoundingBox)) {
			setBlockState(world, Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH), 2, 0, -1, structBoundingBox);
		}

		setBlockState(world, airState, 6, 1, 5, structBoundingBox);
		setBlockState(world, airState, 6, 2, 5, structBoundingBox);

		this.setBlockState(world, Blocks.TORCH.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.SOUTH), 6, 3, 4, structBoundingBox);

		this.setBlockState(world, Blocks.DARK_OAK_DOOR.getDefaultState().withProperty(BlockDoor.FACING, EnumFacing.SOUTH), 6, 1, 5, structBoundingBox);
		this.setBlockState(world, Blocks.DARK_OAK_DOOR.getDefaultState().withProperty(BlockDoor.FACING, EnumFacing.SOUTH).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER), 6, 2, 5, structBoundingBox);

		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 9; ++j) {
				clearCurrentPositionBlocksUpwards(world, j, 7, i, structBoundingBox);
				replaceAirAndLiquidDownwards(world, Blocks.COBBLESTONE.getDefaultState(), j, -1, i, structBoundingBox);
			}
		}

		return true;
	}

	private void buildRoof(World world, StructureBoundingBox structBoundingBox) {
		for (int z = -1; z <= 2; ++z) {
			for (int x = 0; x <= 8; ++x) {
				IBlockState northStairs = Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.NORTH);
				setBlockState(world, northStairs, x, 4 + z, z, structBoundingBox);

				IBlockState southStairs = Blocks.OAK_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, EnumFacing.SOUTH);
				setBlockState(world, southStairs, x, 4 + z, 5 - z, structBoundingBox);
			}
		}

			this.spawnVillagers(world, structBoundingBox, 4, 1, 2, 1);
	}
	private boolean isAirBlockAtCurrentPosition(World world, BlockPos pos, StructureBoundingBox box) {
		IBlockState blockStateFromPos = getBlockStateFromPos(world, pos.getX(), pos.getY(), pos.getZ(), box);
		return blockStateFromPos.getBlock().isAir(blockStateFromPos, world, pos);
	}

	

	@Override
	protected VillagerProfession chooseForgeProfession(int count, net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession prof)
	{
		return EndVillagerHandler.PROF_EXPLORER;
	}
	public static class VillageManager implements IVillageCreationHandler
	{
		@Override
		public Village buildComponent(PieceWeight villagePiece, Start startPiece, List<StructureComponent> pieces, Random random, int p1, int p2, int p3, EnumFacing facing, int p5)
		{
			StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, 11, 10, 9, facing);
			return (!canVillageGoDeeper(box))||(StructureComponent.findIntersecting(pieces, box)!=null)?null: new EndVillagerHouse(startPiece, p5, random, box, facing);
		}

		@Override
		public PieceWeight getVillagePieceWeight(Random random, int i)
		{
			return new PieceWeight(EndVillagerHouse.class, 15, MathHelper.getInt(random, 0+i, 1+i));
		}

		@Override
		public Class<?> getComponentClass()
		{
			return EndVillagerHouse.class;
		}
	}
}