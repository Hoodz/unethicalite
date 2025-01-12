import net.runelite.mapping.ObfuscatedName;
import java.io.InvalidClassException;
import net.runelite.mapping.Implements;
import java.io.IOException;
import java.lang.reflect.Method;
import net.runelite.rs.Reflection;
import java.io.OptionalDataException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import net.runelite.mapping.ObfuscatedSignature;
import java.io.ByteArrayInputStream;
import net.runelite.mapping.ObfuscatedGetter;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import net.runelite.mapping.Export;
@ObfuscatedName("kv")
@Implements("ArchiveDiskAction")
public class ArchiveDiskAction extends Node {
	@ObfuscatedName("c")
	@ObfuscatedGetter(intValue = -1477037843)
	@Export("type")
	int type;

	@ObfuscatedName("v")
	@Export("data")
	public byte[] data;

	@ObfuscatedName("q")
	@ObfuscatedSignature(descriptor = "Lnd;")
	@Export("archiveDisk")
	public ArchiveDisk archiveDisk;

	@ObfuscatedName("f")
	@ObfuscatedSignature(descriptor = "Llc;")
	@Export("archive")
	public Archive archive;

	ArchiveDiskAction() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(descriptor = "(Lpq;I)V", garbageValue = "206933702")
	@Export("performReflectionCheck")
	public static void performReflectionCheck(PacketBuffer var0) {
		ReflectionCheck var1 = ((ReflectionCheck) (class33.reflectionChecks.last()));
		if (var1 != null) {
			int var2 = var0.offset;
			var0.writeInt(var1.id);
			for (int var3 = 0; var3 < var1.size; ++var3) {
				if (var1.creationErrors[var3] != 0) {
					var0.writeByte(var1.creationErrors[var3]);
				} else {
					try {
						int var4 = var1.operations[var3];
						Field var5;
						int var6;
						if (var4 == 0) {
							var5 = var1.fields[var3];
							var6 = Reflection.getInt(var5, ((Object) (null)));
							var0.writeByte(0);
							var0.writeInt(var6);
						} else if (var4 == 1) {
							var5 = var1.fields[var3];
							Reflection.setInt(var5, ((Object) (null)), var1.intReplaceValues[var3]);
							var0.writeByte(0);
						} else if (var4 == 2) {
							var5 = var1.fields[var3];
							var6 = var5.getModifiers();
							var0.writeByte(0);
							var0.writeInt(var6);
						}
						Method var25;
						if (var4 != 3) {
							if (var4 == 4) {
								var25 = var1.methods[var3];
								var6 = var25.getModifiers();
								var0.writeByte(0);
								var0.writeInt(var6);
							}
						} else {
							var25 = var1.methods[var3];
							byte[][] var10 = var1.arguments[var3];
							Object[] var7 = new Object[var10.length];
							for (int var8 = 0; var8 < var10.length; ++var8) {
								ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
								var7[var8] = var9.readObject();
							}
							Object var11 = Reflection.invoke(var25, ((Object) (null)), var7);
							if (var11 == null) {
								var0.writeByte(0);
							} else if (var11 instanceof Number) {
								var0.writeByte(1);
								var0.writeLong(((Number) (var11)).longValue());
							} else if (var11 instanceof String) {
								var0.writeByte(2);
								var0.writeStringCp1252NullTerminated(((String) (var11)));
							} else {
								var0.writeByte(4);
							}
						}
					} catch (ClassNotFoundException var13) {
						var0.writeByte(-10);
					} catch (InvalidClassException var14) {
						var0.writeByte(-11);
					} catch (StreamCorruptedException var15) {
						var0.writeByte(-12);
					} catch (OptionalDataException var16) {
						var0.writeByte(-13);
					} catch (IllegalAccessException var17) {
						var0.writeByte(-14);
					} catch (IllegalArgumentException var18) {
						var0.writeByte(-15);
					} catch (InvocationTargetException var19) {
						var0.writeByte(-16);
					} catch (SecurityException var20) {
						var0.writeByte(-17);
					} catch (IOException var21) {
						var0.writeByte(-18);
					} catch (NullPointerException var22) {
						var0.writeByte(-19);
					} catch (Exception var23) {
						var0.writeByte(-20);
					} catch (Throwable var24) {
						var0.writeByte(-21);
					}
				}
			}
			var0.writeCrc(var2);
			var1.remove();
		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(descriptor = "(Ljava/lang/String;I)Ljava/lang/String;", garbageValue = "1685326414")
	public static String method5777(String var0) {
		int var1 = var0.length();
		char[] var2 = new char[var1];
		byte var3 = 2;
		for (int var4 = 0; var4 < var1; ++var4) {
			char var5 = var0.charAt(var4);
			if (var3 == 0) {
				var5 = Character.toLowerCase(var5);
			} else if (var3 == 2 || Character.isUpperCase(var5)) {
				var5 = class326.method6050(var5);
			}
			if (Character.isLetter(var5)) {
				var3 = 0;
			} else if (var5 != '.' && var5 != '?' && var5 != '!') {
				if (Character.isSpaceChar(var5)) {
					if (var3 != 2) {
						var3 = 1;
					}
				} else {
					var3 = 1;
				}
			} else {
				var3 = 2;
			}
			var2[var4] = var5;
		}
		return new String(var2);
	}
}