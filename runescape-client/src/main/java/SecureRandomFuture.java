import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.Implements;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
@ObfuscatedName("bw")
@Implements("SecureRandomFuture")
public class SecureRandomFuture {
	@ObfuscatedName("pm")
	@ObfuscatedGetter(intValue = -1419708281)
	static int field960;

	@ObfuscatedName("c")
	@Export("executor")
	ExecutorService executor;

	@ObfuscatedName("v")
	@Export("future")
	Future future;

	SecureRandomFuture() {
		this.executor = Executors.newSingleThreadExecutor();
		this.future = this.executor.submit(new SecureRandomCallable());
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(descriptor = "(B)V", garbageValue = "-33")
	@Export("shutdown")
	void shutdown() {
		this.executor.shutdown();
		this.executor = null;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(descriptor = "(I)Z", garbageValue = "1943813302")
	@Export("isDone")
	boolean isDone() {
		return this.future.isDone();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(descriptor = "(I)Ljava/security/SecureRandom;", garbageValue = "448481251")
	@Export("get")
	SecureRandom get() {
		try {
			return ((SecureRandom) (this.future.get()));
		} catch (Exception var2) {
			return NetFileRequest.method5843();
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(descriptor = "(IB)Lfi;", garbageValue = "81")
	@Export("KitDefinition_get")
	public static KitDefinition KitDefinition_get(int var0) {
		KitDefinition var1 = ((KitDefinition) (KitDefinition.KitDefinition_cached.get(((long) (var0)))));
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = KitDefinition.KitDefinition_archive.takeFile(3, var0);
			var1 = new KitDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}
			KitDefinition.KitDefinition_cached.put(var1, ((long) (var0)));
			return var1;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(descriptor = "(Llh;Llh;IZI)Lda;", garbageValue = "1850622535")
	public static class122 method1963(AbstractArchive var0, AbstractArchive var1, int var2, boolean var3) {
		boolean var4 = true;
		byte[] var5 = var0.getFile(var2 >> 16 & 65535, var2 & 65535);
		if (var5 == null) {
			var4 = false;
			return null;
		} else {
			int var6 = (var5[1] & 255) << 8 | var5[2] & 255;
			byte[] var7;
			if (var3) {
				var7 = var1.getFile(0, var6);
			} else {
				var7 = var1.getFile(var6, 0);
			}
			if (var7 == null) {
				var4 = false;
			}
			if (!var4) {
				return null;
			} else {
				try {
					return new class122(var0, var1, var2, var3);
				} catch (Exception var9) {
					return null;
				}
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(descriptor = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", garbageValue = "1953508485")
	@Export("addChatMessage")
	static void addChatMessage(int var0, String var1, String var2, String var3) {
		ChatChannel var4 = ((ChatChannel) (Messages.Messages_channels.get(var0)));
		if (var4 == null) {
			var4 = new ChatChannel();
			Messages.Messages_channels.put(var0, var4);
		}
		Message var5 = var4.addMessage(var0, var1, var2, var3);
		Messages.Messages_hashTable.put(var5, ((long) (var5.count)));
		Messages.Messages_queue.add(var5);
		Client.chatCycle = Client.cycleCntr;
	}

	@ObfuscatedName("ey")
	@ObfuscatedSignature(descriptor = "(B)V", garbageValue = "7")
	static final void method1967() {
		Scene.Scene_isLowDetail = false;
		Client.isLowDetail = false;
	}
}