package de.cubeside.custombiomes;

import de.cubeside.nmsutils.BiomeUtils.GrassColorModifier;
import de.cubeside.nmsutils.NMSUtils;
import de.cubeside.nmsutils.biome.Precipitation;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomBiomesPlugin extends JavaPlugin {
    @Override
    public void onLoad() {
        NMSUtils nmsUtils = getServer().getServicesManager().load(NMSUtils.class);
        // nmsUtils.getBiomeUtils().registerCustomBiome(new NamespacedKey("cubeside", "test"), 0.5f, 0.8f, Precipitation.RAIN, null, 0x69fbf9, null, 0x86fefb, 0xffa0fb, 0xabff97);
        nmsUtils.getBiomeUtils().registerCustomBiome(new NamespacedKey("cubeside", "cherry_grove"), 0.5f, 0.8f, Precipitation.RAIN, null, 0x69fbf9, null, 0x86fefb, 0xFF8FF9, 0xabff97); // 0xffa0fb
        nmsUtils.getBiomeUtils().registerCustomBiome(new NamespacedKey("cubeside", "cherry_blossom_valley"), 0.5f, 0.8f, Precipitation.RAIN, 0xA5D3CE, 0x3CB599, 0x1E866F, 0x64B3A9, 0xF4828C, 0x93C13C);
        nmsUtils.getBiomeUtils().registerCustomBiome(new NamespacedKey("cubeside", "red_maple_woods"), 0.5f, 0.8f, Precipitation.RAIN, 0xEFEABE, 0xA0BBF1, 0x6464F0, 0x99C7CA, 0x702822, 0xFF9C35);
        nmsUtils.getBiomeUtils().registerCustomBiome(new NamespacedKey("cubeside", "blue_grove"), 0.5f, 0.8f, Precipitation.RAIN, 0xBF9ED1, 0x51ECB0, 0x3DC7A4, 0xDFB9F3, 0x66F0EB, 0x69D3B3);
        nmsUtils.getBiomeUtils().registerCustomBiome(new NamespacedKey("cubeside", "bloodborn"), 0.5f, 0.8f, Precipitation.RAIN, 0x7D7D7D, 0x862615, 0x55170D, 0x292929, 0x5E4520, 0x775728);
        nmsUtils.getBiomeUtils().registerCustomBiome(new NamespacedKey("cubeside", "bloody_forest"), 0.8f, 0.7f, Precipitation.RAIN, 0xC0D8FF, 0x862615, 0x55170D, 0x78A7FF, null, null, GrassColorModifier.DARK_FOREST);
    }
}
