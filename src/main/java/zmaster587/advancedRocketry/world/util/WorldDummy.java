package zmaster587.advancedRocketry.world.util;

import zmaster587.advancedRocketry.util.StorageChunk;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.multiplayer.ChunkProviderClient;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.profiler.Profiler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;

public class WorldDummy extends World {

	private final static ProviderDummy dummyProvider = new ProviderDummy();

	StorageChunk storage;
	public int displayListIndex = -1;
	public WorldDummy(Profiler p_i45368_5_, StorageChunk storage) {
		super(new DummySaveHandler(), new WorldInfo(new NBTTagCompound()), dummyProvider, p_i45368_5_, false);
		this.storage = storage;
		this.chunkProvider = new ChunkProviderDummy(this);
	}

	@Override
	public IBlockState getBlockState(BlockPos pos) {
		return storage.getBlockState(pos);
	}
	
	@Override
	public TileEntity getTileEntity(BlockPos pos) {
		return storage.getTileEntity(pos);
	}

	@Override
	public boolean isSideSolid(BlockPos pos, EnumFacing side, boolean bool) {
		return storage.isSideSolid(pos, side, bool);
	}

	@Override
	public void updateEntities() {
		//Dummy out
	}

	@Override
	public void tick() {
		//Dont tick
	}

	@Override
	public boolean tickUpdates(boolean p_72955_1_) {
		//Dont tick
		return false;
	}

	@Override
	protected IChunkProvider createChunkProvider() {
		if(this.isRemote)
			return new ChunkProviderClient(this);
		else 
			return null;
	}

	//No entities exist
	@Override
	public Entity getEntityByID(int p_73045_1_) {
		return null;
	}

	@Override
	protected boolean isChunkLoaded(int x, int z, boolean allowEmpty) {
		//Dummy out
		return false;
	}

}
