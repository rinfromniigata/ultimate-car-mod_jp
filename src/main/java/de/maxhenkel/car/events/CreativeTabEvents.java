package de.maxhenkel.car.events;

import de.maxhenkel.car.Main;
import de.maxhenkel.car.blocks.ModBlocks;
import de.maxhenkel.car.items.ItemCarPart;
import de.maxhenkel.car.items.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabEvents {

    public static CreativeModeTab TAB_CAR;
    public static CreativeModeTab TAB_CAR_PARTS;

    @SubscribeEvent
    public static void onCreativeModeTabRegister(CreativeModeTabEvent.Register event) {
        TAB_CAR = event.registerCreativeModeTab(new ResourceLocation(Main.MODID, "car"), builder -> {
            builder
                    .icon(() -> new ItemStack(ModBlocks.ASPHALT.get()))
                    .displayItems((param, output) -> {
                        output.accept(new ItemStack(ModBlocks.ASPHALT.get()));
                        output.accept(new ItemStack(ModBlocks.ASPHALT_SLOPE.get()));
                        output.accept(new ItemStack(ModBlocks.ASPHALT_SLOPE_FLAT_UPPER.get()));
                        output.accept(new ItemStack(ModBlocks.ASPHALT_SLOPE_FLAT_LOWER.get()));
                        output.accept(new ItemStack(ModBlocks.ASPHALT_SLAB.get()));
                        output.accept(new ItemStack(ModBlocks.GAS_STATION.get()));
                        output.accept(new ItemStack(ModBlocks.CANOLA_CROP.get()));
                        output.accept(new ItemStack(ModBlocks.OIL_MILL.get()));
                        output.accept(new ItemStack(ModBlocks.BLAST_FURNACE.get()));
                        output.accept(new ItemStack(ModBlocks.BACKMIX_REACTOR.get()));
                        output.accept(new ItemStack(ModBlocks.GENERATOR.get()));
                        output.accept(new ItemStack(ModBlocks.SPLIT_TANK.get()));
                        output.accept(new ItemStack(ModBlocks.TANK.get()));
                        output.accept(new ItemStack(ModBlocks.CAR_WORKSHOP.get()));
                        output.accept(new ItemStack(ModBlocks.CAR_WORKSHOP_OUTTER.get()));
                        output.accept(new ItemStack(ModBlocks.CABLE.get()));
                        output.accept(new ItemStack(ModBlocks.FLUID_EXTRACTOR.get()));
                        output.accept(new ItemStack(ModBlocks.FLUID_PIPE.get()));
                        output.accept(new ItemStack(ModBlocks.DYNAMO.get()));
                        output.accept(new ItemStack(ModBlocks.CRANK.get()));
                        output.accept(new ItemStack(ModBlocks.SIGN.get()));
                        output.accept(new ItemStack(ModBlocks.SIGN_POST.get()));
                        output.accept(new ItemStack(ModBlocks.CAR_PRESSURE_PLATE.get()));
                        output.accept(new ItemStack(ModItems.CANOLA_OIL_BUCKET.get()));
                        output.accept(new ItemStack(ModItems.METHANOL_BUCKET.get()));
                        output.accept(new ItemStack(ModItems.CANOLA_METHANOL_MIX_BUCKET.get()));
                        output.accept(new ItemStack(ModItems.GLYCERIN_BUCKET.get()));
                        output.accept(new ItemStack(ModItems.BIO_DIESEL_BUCKET.get()));

                        output.accept(new ItemStack(ModItems.PAINTER.get()));
                        output.accept(new ItemStack(ModItems.PAINTER_YELLOW.get()));
                        output.accept(new ItemStack(ModItems.CANOLA_SEEDS.get()));
                        output.accept(new ItemStack(ModItems.CANOLA.get()));
                        output.accept(new ItemStack(ModItems.CANOLA_CAKE.get()));
                        output.accept(new ItemStack(ModItems.IRON_STICK.get()));
                        output.accept(new ItemStack(ModItems.ENGINE_PISTON.get()));
                        output.accept(new ItemStack(ModItems.CANISTER.get()));
                        output.accept(new ItemStack(ModItems.REPAIR_KIT.get()));
                        output.accept(new ItemStack(ModItems.WRENCH.get()));
                        output.accept(new ItemStack(ModItems.SCREW_DRIVER.get()));
                        output.accept(new ItemStack(ModItems.HAMMER.get()));
                        output.accept(new ItemStack(ModItems.CABLE_INSULATOR.get()));
                        output.accept(new ItemStack(ModItems.KEY.get()));
                        output.accept(new ItemStack(ModItems.BATTERY.get()));
                        output.accept(new ItemStack(ModItems.GUARD_RAIL.get()));
                        output.accept(new ItemStack(ModItems.LICENSE_PLATE.get()));
                    })
                    .title(Component.translatable("itemGroup.car"))
                    .build();
        });

        TAB_CAR_PARTS = event.registerCreativeModeTab(new ResourceLocation(Main.MODID, "car_parts"), builder -> {
            builder
                    .icon(() -> new ItemStack(ModItems.OAK_BODY.get()))
                    .displayItems((param, output) -> {
                        output.accept(new ItemStack(ModItems.ENGINE_3_CYLINDER.get()));
                        output.accept(new ItemStack(ModItems.ENGINE_6_CYLINDER.get()));
                        output.accept(new ItemStack(ModItems.ENGINE_TRUCK.get()));
                        output.accept(new ItemStack(ModItems.WHEEL.get()));
                        output.accept(new ItemStack(ModItems.BIG_WHEEL.get()));
                        output.accept(new ItemStack(ModItems.SMALL_TANK.get()));
                        output.accept(new ItemStack(ModItems.MEDIUM_TANK.get()));
                        output.accept(new ItemStack(ModItems.LARGE_TANK.get()));

                        for (RegistryObject<ItemCarPart> part : ModItems.WOOD_BODIES) {
                            output.accept(new ItemStack(part.get()));
                        }
                        for (RegistryObject<ItemCarPart> part : ModItems.BIG_WOOD_BODIES) {
                            output.accept(new ItemStack(part.get()));
                        }
                        for (RegistryObject<ItemCarPart> part : ModItems.TRANSPORTER_BODIES) {
                            output.accept(new ItemStack(part.get()));
                        }
                        for (RegistryObject<ItemCarPart> part : ModItems.SUV_BODIES) {
                            output.accept(new ItemStack(part.get()));
                        }
                        for (RegistryObject<ItemCarPart> part : ModItems.SPORT_BODIES) {
                            output.accept(new ItemStack(part.get()));
                        }
                        for (RegistryObject<ItemCarPart> part : ModItems.CONTAINERS) {
                            output.accept(new ItemStack(part.get()));
                        }
                        for (RegistryObject<ItemCarPart> part : ModItems.TANK_CONTAINERS) {
                            output.accept(new ItemStack(part.get()));
                        }
                        for (RegistryObject<ItemCarPart> part : ModItems.BUMPERS) {
                            output.accept(new ItemStack(part.get()));
                        }
                        for (RegistryObject<ItemCarPart> part : ModItems.WOODEN_LICENSE_PLATE_HOLDERS) {
                            output.accept(new ItemStack(part.get()));
                        }
                        output.accept(new ItemStack(ModItems.IRON_LICENSE_PLATE_HOLDER.get()));
                        output.accept(new ItemStack(ModItems.DIAMOND_LICENSE_PLATE_HOLDER.get()));
                        output.accept(new ItemStack(ModItems.GOLD_LICENSE_PLATE_HOLDER.get()));
                        output.accept(new ItemStack(ModItems.EMERALD_LICENSE_PLATE_HOLDER.get()));
                        for (RegistryObject<ItemCarPart> part : ModItems.WOODEN_LICENSE_PLATE_HOLDERS) {
                            output.accept(new ItemStack(part.get()));
                        }
                        for (RegistryObject<ItemCarPart> part : ModItems.WOODEN_LICENSE_PLATE_HOLDERS) {
                            output.accept(new ItemStack(part.get()));
                        }
                        for (RegistryObject<ItemCarPart> part : ModItems.WOODEN_LICENSE_PLATE_HOLDERS) {
                            output.accept(new ItemStack(part.get()));
                        }
                        for (RegistryObject<ItemCarPart> part : ModItems.WOODEN_LICENSE_PLATE_HOLDERS) {
                            output.accept(new ItemStack(part.get()));
                        }
                    })
                    .title(Component.translatable("itemGroup.car_parts"))
                    .build();
        });
    }

}