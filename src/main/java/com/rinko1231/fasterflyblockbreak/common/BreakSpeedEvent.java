package com.rinko1231.fasterflyblockbreak.common;

import com.rinko1231.fasterflyblockbreak.common.Config.FFConfiguration;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BreakSpeedEvent {

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();


        // 检查玩家是否处于浮空状态
        if (!player.onGround()&&player.getAbilities().flying) {
            // 将挖掘速度提高
            event.setNewSpeed(event.getOriginalSpeed() * FFConfiguration.getInstance().getSpeedMulti());
        }
    }
}