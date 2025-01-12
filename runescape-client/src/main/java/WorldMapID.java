import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.Implements;
import net.runelite.mapping.Export;
@ObfuscatedName("il")
@Implements("WorldMapID")
public class WorldMapID {
	@ObfuscatedName("c")
	@ObfuscatedSignature(descriptor = "Lil;")
	static final WorldMapID field2843;

	@ObfuscatedName("v")
	@ObfuscatedSignature(descriptor = "Lil;")
	static final WorldMapID field2840;

	@ObfuscatedName("k")
	@ObfuscatedSignature(descriptor = "Len;")
	static ClanSettings field2842;

	@ObfuscatedName("q")
	@ObfuscatedGetter(intValue = 785745011)
	@Export("value")
	final int value;

	static {
		field2843 = new WorldMapID(0);
		field2840 = new WorldMapID(1);
	}

	WorldMapID(int var1) {
		this.value = var1;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(descriptor = "(II)I", garbageValue = "-1614868880")
	@Export("Widget_unpackTargetMask")
	public static int Widget_unpackTargetMask(int var0) {
		return var0 >> 11 & 63;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(descriptor = "(IS)Z", garbageValue = "255")
	public static boolean method5003(int var0) {
		return (var0 >> 20 & 1) != 0;
	}
}