package com.gerbshert.chalice.utility;

import com.gerbshert.chalice.item.ModItems;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

/**
 * Created by Gabriel on 06-Feb-17.
 */
public class Achievements {
    public static Achievement achievementCorporealVoid = new Achievement("achievement.chalice.corporealVoid", "chalice.corporealVoid", 0, 0, ModItems.corporealVoid, (Achievement)null);

    public static void registerAchievements(){
        achievementCorporealVoid.registerStat();

        Achievement[] array_a = new Achievement[] {achievementCorporealVoid};

        AchievementPage.registerAchievementPage(new AchievementPage("Chalice", array_a));
    }



}
