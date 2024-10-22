package net.ayden.simpleautoclicker;


import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;

public final class KeyBind
{
        public static final KeyBind INSTANCE = new KeyBind();
        private KeyBind() {}
        private static final String CATEGORY = "key.categories.simple-auto-clicker";
        public final KeyMapping toggle = new KeyMapping("key.simple-auto-clicker.toggle", KeyConflictContext.IN_GAME, InputConstants.getKey(InputConstants.KEY_O, -1), CATEGORY);
}
