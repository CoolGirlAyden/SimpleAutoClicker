package net.ayden.simpleautoclicker;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents
{
    public static boolean isActive = false;

    @Mod.EventBusSubscriber(modid = SimpleAutoClicker.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientForgeEvents
    {


        @SubscribeEvent
        public static void clientTick(TickEvent.ClientTickEvent event)
        {
            if (KeyBind.INSTANCE.toggle.isDown())
            {
                KeyBind.INSTANCE.toggle.consumeClick();
                isActive = !isActive;
            }
        }
        @SubscribeEvent
        public static void Clicker()
        {
            while (isActive)
            {
                Entity Target = Minecraft.getInstance().crosshairPickEntity;
                if (Target != null)
                    Minecraft.getInstance().player.attack(Target);
            }
        }
    }

    @Mod.EventBusSubscriber(modid = SimpleAutoClicker.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents
    {
        @SubscribeEvent
        public static void OnKeyRegister(RegisterKeyMappingsEvent event)
        {
            event.register(KeyBind.INSTANCE.toggle);
        }

    }
}
