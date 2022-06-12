package net.runelite.client.plugins.unethicalite;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.InventoryID;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.Config;
import net.runelite.client.eventbus.EventBus;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.unethicalite.regions.RegionHandler;
import net.unethicalite.api.movement.pathfinder.TransportLoader;
import net.unethicalite.api.plugins.SettingsPlugin;
import net.unethicalite.client.config.UnethicaliteConfig;

import javax.inject.Inject;
import java.util.Set;

@PluginDescriptor(
		name = "Unethicalite",
		hidden = true
)
@Slf4j
public class UnethicalitePlugin extends SettingsPlugin
{

	private static final Set<Integer> REFRESH_WIDGET_IDS = Set.of(
			WidgetInfo.QUEST_COMPLETED_NAME_TEXT.getGroupId(),
			WidgetInfo.LEVEL_UP_LEVEL.getGroupId()
	);

	@Inject
	private UnethicaliteConfig config;

	@Inject
	private EventBus eventBus;

	@Inject
	private RegionHandler regionHandler;

	@Override
	protected void startUp() throws Exception
	{
		eventBus.register(regionHandler);
	}

	@Override
	protected void shutDown() throws Exception
	{
		eventBus.unregister(regionHandler);
	}

	@Override
	public Config getConfig()
	{
		return config;
	}

	@Override
	public String getPluginName()
	{
		return "Unethicalite";
	}

	@Override
	public String getPluginDescription()
	{
		return "Unethicalite settings";
	}

	@Override
	public String[] getPluginTags()
	{
		return new String[]{"unethicalite"};
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (REFRESH_WIDGET_IDS.contains(event.getGroupId()))
		{
			TransportLoader.refreshStaticTransports();
		}
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getContainerId() == InventoryID.INVENTORY.getId())
		{
			TransportLoader.refreshStaticTransports();
		}
	}
}