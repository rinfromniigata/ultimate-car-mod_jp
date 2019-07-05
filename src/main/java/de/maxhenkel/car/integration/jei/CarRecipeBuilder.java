package de.maxhenkel.car.integration.jei;

import de.maxhenkel.car.items.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRecipeBuilder {

    public static List<CarRecipe> getAllRecipes() {
        List<CarRecipe> recipes = new ArrayList<>();

        ItemStack wheel = new ItemStack(ModItems.WHEEL);
        ItemStack largeWheel = new ItemStack(ModItems.BIG_WHEEL);

        for (ItemStack tank : getAllTanks()) {
            for (ItemStack engine : getAllEngines()) {
                for (ItemStack plate : getAllLicensePlateHolders()) {
                    for (ItemStack bumper : getAllBumpers()) {
                        for (ItemStack body : getWoodBodies()) {
                            recipes.add(new CarRecipe(body, bumper, plate, tank, engine, wheel, wheel, wheel, wheel));
                        }
                    }
                    for (ItemStack body : getSUVBodies()) {
                        recipes.add(new CarRecipe(body, plate, tank, engine, largeWheel, largeWheel, largeWheel, largeWheel));
                    }

                    for (ItemStack container : getAllContainers()) {
                        for (ItemStack body : getTransporters()) {
                            recipes.add(new CarRecipe(body, container, plate, tank, engine, wheel, wheel, wheel, wheel, wheel, wheel));
                        }
                    }

                    for (ItemStack container : getAllTankContainers()) {
                        for (ItemStack body : getTransporters()) {
                            recipes.add(new CarRecipe(body, container, plate, tank, engine, wheel, wheel, wheel, wheel, wheel, wheel));
                        }
                    }
                }
            }
        }

        return recipes;
    }

    private static List<ItemStack> getWoodBodies() {
        return concatItems(ModItems.BIG_WOOD_BODIES, ModItems.WOOD_BODIES);
    }

    private static List<ItemStack> getTransporters() {
        return concatItems(ModItems.TRANSPORTER_BODIES);
    }

    private static List<ItemStack> getSUVBodies() {
        return concatItems(ModItems.SUV_BODIES);
    }

    private static List<ItemStack> getAllBodies() {
        return concatItems(ModItems.BIG_WOOD_BODIES, ModItems.WOOD_BODIES, ModItems.SPORT_BODIES, ModItems.SUV_BODIES, ModItems.TRANSPORTER_BODIES);
    }

    private static List<ItemStack> getAllBumpers() {
        return concatItems(ModItems.BUMPERS);
    }

    private static List<ItemStack> getAllContainers() {
        return concatItems(ModItems.CONTAINERS);
    }

    private static List<ItemStack> getAllTankContainers() {
        return concatItems(ModItems.TANK_CONTAINERS);
    }

    private static List<ItemStack> getAllLicensePlateHolders() {
        List<ItemStack> bumpers = concatItems(ModItems.WOODEN_LICENSE_PLATE_HOLDERS);
        bumpers.add(new ItemStack(ModItems.IRON_LICENSE_PLATE_HOLDER));
        bumpers.add(new ItemStack(ModItems.GOLD_LICENSE_PLATE_HOLDER));
        bumpers.add(new ItemStack(ModItems.EMERALD_LICENSE_PLATE_HOLDER));
        bumpers.add(new ItemStack(ModItems.DIAMOND_LICENSE_PLATE_HOLDER));
        return bumpers;
    }

    private static List<ItemStack> getAllEngines() {
        return Arrays.asList(new ItemStack(ModItems.ENGINE_3_CYLINDER), new ItemStack(ModItems.ENGINE_6_CYLINDER));
    }

    private static List<ItemStack> getAllTanks() {
        return Arrays.asList(new ItemStack(ModItems.SMALL_TANK), new ItemStack(ModItems.MEDIUM_TANK), new ItemStack(ModItems.LARGE_TANK));
    }

    private static List<ItemStack> concatItems(Item[]... items) {
        return concatArrays(items).stream().map(item -> new ItemStack(item)).collect(Collectors.toList());
    }

    private static <T> List<T> concatArrays(T[]... arrays) {
        List<T> list = new ArrayList<>();

        for (T[] array : arrays) {
            for (T element : array) {
                list.add(element);
            }
        }

        return list;
    }

}