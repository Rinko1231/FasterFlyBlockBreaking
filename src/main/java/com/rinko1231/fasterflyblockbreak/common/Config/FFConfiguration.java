package com.rinko1231.fasterflyblockbreak.common.Config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;


public class FFConfiguration
{
    private static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final FFConfiguration INSTANCE = new FFConfiguration();

    private static final ForgeConfigSpec.IntValue SpeedMulti;

    static
    {
        BUILDER.push("Fasted Fly Block Breaking Config");

        SpeedMulti = BUILDER
                .comment("Break Speed Multiplier")
                .defineInRange("Speed Multiplier", 5, 0, 50);

        SPEC = BUILDER.build();
    }


    public int getSpeedMulti ()
    {
        return SpeedMulti.get();
    }

    public static void setup()
    {

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SPEC, "fasterFlyBlockBreak.toml");
    }
    public static FFConfiguration getInstance()
    {
        return INSTANCE;
    }

}