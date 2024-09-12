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
    private static final ForgeConfigSpec.BooleanValue RequireFly;

    static
    {
        BUILDER.push("Fasted Fly Block Breaking Config");

        SpeedMulti = BUILDER
                .comment("Break Speed Multiplier")
                .defineInRange("Speed Multiplier", 5, 0, 50);

        RequireFly = BUILDER
                .comment("Whether the player needs to be in flying mode, in case some mods bypass the vanilla flying mode.")
                .comment("If it is set to false, anyone that is not on ground will gain extra breaking speed.")
                .define("Need to be in flying mode", true);

        SPEC = BUILDER.build();
    }


    public int getSpeedMulti ()
    {
        return SpeedMulti.get();
    }

    public boolean getRequireFly ()
    {
        return RequireFly.get();
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