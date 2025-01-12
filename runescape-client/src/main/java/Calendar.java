import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Implements;
import net.runelite.mapping.Export;
@ObfuscatedName("jf")
@Implements("Calendar")
public class Calendar {
	@ObfuscatedName("c")
	@Export("MONTH_NAMES_ENGLISH_GERMAN")
	static final String[][] MONTH_NAMES_ENGLISH_GERMAN;

	@ObfuscatedName("v")
	@Export("DAYS_OF_THE_WEEK")
	static final String[] DAYS_OF_THE_WEEK;

	@ObfuscatedName("q")
	@Export("Calendar_calendar")
	static java.util.Calendar Calendar_calendar;

	static {
		MONTH_NAMES_ENGLISH_GERMAN = new String[][]{ new String[]{ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }, new String[]{ "Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez" }, new String[]{ "jan", "fév", "mars", "avr", "mai", "juin", "juil", "août", "sept", "oct", "nov", "déc" }, new String[]{ "jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez" }, new String[]{ "jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec" }, new String[]{ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }, new String[]{ "ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic" } };
		DAYS_OF_THE_WEEK = new String[]{ "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		java.util.Calendar.getInstance();
		Calendar_calendar = java.util.Calendar.getInstance(TimeZone.getTimeZone("GMT"));
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(descriptor = "(Llh;Llh;IZI)Lgh;", garbageValue = "603221838")
	public static Frames method5499(AbstractArchive var0, AbstractArchive var1, int var2, boolean var3) {
		boolean var4 = true;
		int[] var5 = var0.getGroupFileIds(var2);
		for (int var6 = 0; var6 < var5.length; ++var6) {
			byte[] var7 = var0.getFile(var2, var5[var6]);
			if (var7 == null) {
				var4 = false;
			} else {
				int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
				byte[] var9;
				if (var3) {
					var9 = var1.getFile(0, var8);
				} else {
					var9 = var1.getFile(var8, 0);
				}
				if (var9 == null) {
					var4 = false;
				}
			}
		}
		if (!var4) {
			return null;
		} else {
			try {
				return new Frames(var0, var1, var2, var3);
			} catch (Exception var11) {
				return null;
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(descriptor = "(IB)Lfc;", garbageValue = "71")
	@Export("getInvDefinition")
	public static InvDefinition getInvDefinition(int var0) {
		InvDefinition var1 = ((InvDefinition) (InvDefinition.InvDefinition_cached.get(((long) (var0)))));
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = InvDefinition.InvDefinition_archive.takeFile(5, var0);
			var1 = new InvDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}
			InvDefinition.InvDefinition_cached.put(var1, ((long) (var0)));
			return var1;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(descriptor = "(I)V", garbageValue = "-197646586")
	protected static final void method5504() {
		class10.clock.mark();
		int var0;
		for (var0 = 0; var0 < 32; ++var0) {
			GameEngine.graphicsTickTimes[var0] = 0L;
		}
		for (var0 = 0; var0 < 32; ++var0) {
			GameEngine.clientTickTimes[var0] = 0L;
		}
		Messages.gameCyclesToDo = 0;
	}
}