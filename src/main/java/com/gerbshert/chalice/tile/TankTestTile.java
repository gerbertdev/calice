package com.gerbshert.chalice.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;

import javax.annotation.Nullable;

/**
 * Created by Gabriel on 03-Jan-17.
 */
public class TankTestTile extends TileEntity implements IFluidHandler, IFluidTank {
    public TankTestTile() {
    }

    @Override
    public IFluidTankProperties[] getTankProperties() {
        return new IFluidTankProperties[0];
    }

    @Nullable
    @Override
    public FluidStack getFluid() {
        return new FluidStack(FluidRegistry.WATER, getFluidAmount());
    }

    @Override
    public int getFluidAmount() {
        return (int) Double.POSITIVE_INFINITY;
    }

    @Override
    public int getCapacity() {
        return (int) Double.POSITIVE_INFINITY;
    }

    @Override
    public FluidTankInfo getInfo() {
        return new FluidTankInfo(this.getFluid(), this.getCapacity());
    }

    @Override
    public int fill(FluidStack resource, boolean doFill) {
        return 0;
    }

    @Nullable
    @Override
    public FluidStack drain(FluidStack resource, boolean doDrain) {
        return null;
    }

    @Nullable
    @Override
    public FluidStack drain(int maxDrain, boolean doDrain) {
        return null;
    }
}
