import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import java.io.StringWriter;
import net.runelite.mapping.ObfuscatedGetter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.PrintWriter;
@ObfuscatedName("kg")
public class class301 {
	@ObfuscatedName("c")
	@ObfuscatedSignature(descriptor = "Lkg;")
	static final class301 field3575;

	@ObfuscatedName("v")
	@ObfuscatedSignature(descriptor = "Lkg;")
	static final class301 field3576;

	@ObfuscatedName("q")
	@ObfuscatedGetter(intValue = 1219700947)
	final int field3580;

	@ObfuscatedName("f")
	@ObfuscatedGetter(intValue = 1464012369)
	final int field3578;

	static {
		field3575 = new class301(51, 27, 800, 0, 16, 16);
		field3576 = new class301(25, 28, 800, 656, 40, 40);
	}

	class301(int var1, int var2, int var3, int var4, int var5, int var6) {
		this.field3580 = var5;
		this.field3578 = var6;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(descriptor = "(Ljava/lang/Throwable;I)Ljava/lang/String;", garbageValue = "2142234614")
	static String method5755(Throwable var0) throws IOException {
		String var1;
		if (var0 instanceof RunException) {
			RunException var2 = ((RunException) (var0));
			var1 = var2.message + " | ";
			var0 = var2.throwable;
		} else {
			var1 = "";
		}
		StringWriter var12 = new StringWriter();
		PrintWriter var3 = new PrintWriter(var12);
		var0.printStackTrace(var3);
		var3.close();
		String var4 = var12.toString();
		BufferedReader var5 = new BufferedReader(new StringReader(var4));
		String var6 = var5.readLine();
		while (true) {
			while (true) {
				String var7 = var5.readLine();
				if (var7 == null) {
					var1 = var1 + "| " + var6;
					return var1;
				}
				int var8 = var7.indexOf(40);
				int var9 = var7.indexOf(41, var8 + 1);
				if (var8 >= 0 && var9 >= 0) {
					String var10 = var7.substring(var8 + 1, var9);
					int var11 = var10.indexOf(".java:");
					if (var11 >= 0) {
						var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
						var1 = var1 + var10 + ' ';
						continue;
					}
					var7 = var7.substring(0, var8);
				}
				var7 = var7.trim();
				var7 = var7.substring(var7.lastIndexOf(32) + 1);
				var7 = var7.substring(var7.lastIndexOf(9) + 1);
				var1 = var1 + var7 + ' ';
			} 
		} 
	}
}