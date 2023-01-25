package de.cubeside.custombiomes;

import de.cubeside.nmsutils.NMSUtils;
import de.cubeside.nmsutils.biome.CustomBiome;
import de.cubeside.nmsutils.biome.Precipitation;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CustomBiomesPlugin extends JavaPlugin {
    private NMSUtils nmsUtils;
    private CustomBiome CHERRY_GROVE;

    @Override
    public void onLoad() {
        nmsUtils = getServer().getServicesManager().load(NMSUtils.class);
        CHERRY_GROVE = nmsUtils.getBiomeUtils().registerCustomBiome(new NamespacedKey(this, "cherry_grove"), 0.5f, 0.8f, Precipitation.RAIN, null, 0x69fbf9, null, 0x86fefb, 0xffa0fb, 0xabff97);
    }

    @Override
    public void onEnable() {

    }

    private static double lengthSq(double x, double y, double z) {
        return (x * x) + (y * y) + (z * z);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Location loc = player.getLocation();
            int px = loc.getBlockX();
            int py = loc.getBlockY();
            int pz = loc.getBlockZ();
            double size = 4.8;
            int sizeInt = (int) size;

            int minx = px - sizeInt;
            int maxx = px + sizeInt;
            int miny = py - sizeInt;
            int maxy = py + sizeInt;
            int minz = pz - sizeInt;
            int maxz = pz + sizeInt;

            double sizesq = size * size;

            for (int x = minx; x <= maxx; x++) {
                for (int y = miny; y <= maxy; y++) {
                    for (int z = minz; z <= maxz; z++) {
                        if (lengthSq(x - px, y - py, z - pz) < sizesq) {
                            loc.set(x, y, z);
                            CHERRY_GROVE.setBiome(loc);
                        }
                    }
                }
            }

            int minChunkX = minx >> 4;
            int minChunkZ = minz >> 4;
            int maxChunkX = maxx >> 4;
            int maxChunkZ = maxz >> 4;

            for (int x = minChunkX; x <= maxChunkX; x++) {
                for (int z = minChunkZ; z <= maxChunkZ; z++) {
                    loc.getWorld().refreshChunk(x, z);
                }
            }
        }
        return true;
    }
}
