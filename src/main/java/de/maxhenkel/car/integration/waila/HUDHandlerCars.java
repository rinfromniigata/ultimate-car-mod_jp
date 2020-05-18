package de.maxhenkel.car.integration.waila;

import de.maxhenkel.car.entity.car.base.EntityGenericCar;
import de.maxhenkel.tools.MathTools;
import mcp.mobius.waila.Waila;
import mcp.mobius.waila.api.IEntityAccessor;
import mcp.mobius.waila.api.IEntityComponentProvider;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.ITaggableList;
import mcp.mobius.waila.utils.ModIdentification;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraftforge.fluids.FluidStack;

import java.util.List;

public class HUDHandlerCars implements IEntityComponentProvider {

    static final HUDHandlerCars INSTANCE = new HUDHandlerCars();

    @Override
    public void appendHead(List<ITextComponent> tip, IEntityAccessor accessor, IPluginConfig config) {
        ITaggableList<ResourceLocation, ITextComponent> tooltip = (ITaggableList<ResourceLocation, ITextComponent>) tip;
        tooltip.setTag(PluginCar.OBJECT_NAME_TAG, new StringTextComponent(String.format(Waila.CONFIG.get().getFormatting().getEntityName(), accessor.getEntity().getDisplayName().getFormattedText())));
        if (config.get(PluginCar.CONFIG_SHOW_REGISTRY)) {
            tooltip.setTag(PluginCar.REGISTRY_NAME_TAG, new StringTextComponent(String.format(Waila.CONFIG.get().getFormatting().getRegistryName(), accessor.getEntity().getType().getRegistryName().toString())));
        }
    }

    @Override
    public void appendBody(List<ITextComponent> tooltip, IEntityAccessor accessor, IPluginConfig config) {
        if (!(accessor.getEntity() instanceof EntityGenericCar)) {
            return;
        }
        EntityGenericCar car = (EntityGenericCar) accessor.getEntity();

        FluidStack carFluid = car.getFluidInTank(0);
        if (!carFluid.isEmpty()) {
            ITextComponent fluid = new TranslationTextComponent("tooltip.waila.car.fuel", carFluid.getDisplayName());
            ITextComponent amount = new TranslationTextComponent("tooltip.waila.car.fuel_amount", carFluid.getAmount(), car.getMaxFuel());
            tooltip.add(fluid);
            tooltip.add(amount);
        }

        float damage = car.getDamage();
        if (damage > 0F) {
            ITextComponent dmg = new TranslationTextComponent("tooltip.waila.car.damage", MathTools.round(damage, 2));
            tooltip.add(dmg);
        }
    }

    @Override
    public void appendTail(List<ITextComponent> tooltip, IEntityAccessor accessor, IPluginConfig config) {
        tooltip.add(new StringTextComponent(String.format(Waila.CONFIG.get().getFormatting().getModName(), ModIdentification.getModInfo(accessor.getEntity()).getName())));
    }
}