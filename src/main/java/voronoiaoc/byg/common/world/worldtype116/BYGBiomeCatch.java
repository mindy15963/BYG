//package voronoiaoc.byg.common.world.worldtype116;
//
//import net.minecraft.util.ResourceLocation;
//import net.minecraft.util.registry.WorldGenRegistries;
//import net.minecraft.world.biome.Biome;
//import net.minecraft.world.biome.Biomes;
//import voronoiaoc.byg.BYG;
//import voronoiaoc.byg.common.biomes.BYGBiomeWeightSystem;
//import voronoiaoc.byg.config.BYGWorldConfig;
//
//import java.util.Arrays;
//import java.util.List;
//
//@SuppressWarnings("deprecation")
//public class BYGBiomeCatch {
//
//    static String biomeICYRegistries = BYGWorldConfig.externalICYBiomes.get();
//    static String biomeCOOLRegistries = BYGWorldConfig.externalCOOLBiomes.get();
//    static String biomeWARMRegistries = BYGWorldConfig.externalWARMBiomes.get();
//    static String biomeHOTRegistries = BYGWorldConfig.externalHOTBiomes.get();
//
//
//    public static String configICYBiomes = biomeICYRegistries.trim().replace(" ", "");
//    public static String configCOOLBiomes = biomeCOOLRegistries.trim().replace(" ", "");
//    public static String configWARMBiomes = biomeWARMRegistries.trim().replace(" ", "");
//    public static String configHOTBiomes = biomeHOTRegistries.trim().replace(" ", "");
//    public static List<String> biomeICYList = Arrays.asList(configICYBiomes.split(","));
//    public static List<String> biomeWARMList = Arrays.asList(configWARMBiomes.split(","));
//    public static List<String> biomeCOOLList = Arrays.asList(configCOOLBiomes.split(","));
//    public static List<String> biomeHOTList = Arrays.asList(configHOTBiomes.split(","));
//
//
//    public static void biomeCollection() {
//        BYG.LOGGER.debug("BYG: Biome Config Collection starting...");
//        if (biomeICYList.size() > 0) {
//            int[] getConfigArray = new int[biomeICYList.size()];
//            for (int index = 0; index < biomeICYList.size(); ++index) {
//                final Biome configResource = WorldGenRegistries.BIOME.func_241873_b(new ResourceLocation(biomeICYList.get(index))).orElse(WorldGenRegistries.BIOME.getOrThrow(Biomes.THE_END));
//                if (configResource == null) {
//                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeICYList.get(index));
//                } else if (configResource != null) {
//                    getConfigArray[index] = WorldGenRegistries.BIOME.getId(configResource);
//                    Biome biome = WorldGenRegistries.BIOME.getByValue(getConfigArray[index]);
//                    if (biome == null) {
//                    } else {
//                        BYGBiomeWeightSystem.ICY.add(WorldGenRegistries.BIOME.getId(biome));
//                    }
//                }
//            }
//        }
//
//        if (biomeCOOLList.size() > 0) {
//            int[] getConfigArray = new int[biomeCOOLList.size()];
//            for (int index = 0; index < biomeCOOLList.size(); ++index) {
//                final Biome configResource = WorldGenRegistries.BIOME.func_241873_b(new ResourceLocation(biomeCOOLList.get(index))).orElse(WorldGenRegistries.BIOME.getOrThrow(Biomes.THE_END));
//                if (configResource == null) {
//                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeCOOLList.get(index));
//                } else if (configResource != null) {
//                    getConfigArray[index] = WorldGenRegistries.BIOME.getId(configResource);
//                    Biome biome = WorldGenRegistries.BIOME.getByValue(getConfigArray[index]);
//                    if (biome == null) {
//                    } else {
//                        BYGBiomeWeightSystem.COOL.add(WorldGenRegistries.BIOME.getId(biome));
//                    }
//                }
//            }
//        }
//
//        if (biomeWARMList.size() > 0) {
//            int[] getConfigArray = new int[biomeWARMList.size()];
//            for (int index = 0; index < biomeWARMList.size(); ++index) {
//                final Biome configResource = WorldGenRegistries.BIOME.func_241873_b(new ResourceLocation(biomeWARMList.get(index))).orElse(WorldGenRegistries.BIOME.getOrThrow(Biomes.THE_END));
//                if (configResource == null) {
//                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeWARMList.get(index));
//                } else if (configResource != null) {
//                    getConfigArray[index] = WorldGenRegistries.BIOME.getId(configResource);
//                    Biome biome = WorldGenRegistries.BIOME.getByValue(getConfigArray[index]);
//                    if (biome == null) {
//                    } else {
//                        BYGBiomeWeightSystem.WARM.add(WorldGenRegistries.BIOME.getId(biome));
//                    }
//                }
//            }
//        }
//
//        if (biomeHOTList.size() > 0) {
//            int[] getConfigArray = new int[biomeHOTList.size()];
//            for (int index = 0; index < biomeHOTList.size(); ++index) {
//                final Biome configResource = WorldGenRegistries.BIOME.func_241873_b(new ResourceLocation(biomeHOTList.get(index))).orElse(WorldGenRegistries.BIOME.getOrThrow(Biomes.THE_END));
//                if (configResource == null) {
//                    BYG.LOGGER.warn("Illegal registry name! You put: " + biomeHOTList.get(index));
//                } else if (configResource != null) {
//                    getConfigArray[index] = WorldGenRegistries.BIOME.getId(configResource);
//                    Biome biome = WorldGenRegistries.BIOME.getByValue(getConfigArray[index]);
//                    if (biome == null) {
//                    } else {
//                        BYGBiomeWeightSystem.HOT.add(WorldGenRegistries.BIOME.getId(biome));
//                    }
//                }
//            }
//        }
//    }
//}