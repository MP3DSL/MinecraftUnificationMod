package com.mp3dsl.minecraftunificationmod.util;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.oredict.OreDictionary;

public class OreDict
{
	public static ArrayList<NonNullList<ItemStack>> oreDict = new ArrayList<NonNullList<ItemStack>>();
	public static void getOres()
	{
		//NonNullList<ItemStack> copper = OreDictionary.getOres("oreCopper");
		//String modname = copper.get(0).getItem().getCreatorModId(copper.get(0));

		for(int a = 0; a<References.searchPrefix.length; a++)
		{
			for(int b = 0; b<References.searchSuffix.length; b++)
			{
				String item = References.searchPrefix[a] + References.searchSuffix[b];
				//System.out.println(item);
				if(OreDictionary.getOres(item).size() > 1)
					oreDict.add(OreDictionary.getOres(item));				
			}
		}
		
		References.preferedModIDList = Settings.configuration.getStringList("Unification Preferences", "Mod Hierarchy Preference", References.defaultPreferedModIDList, "This list is auto-generated with mods found to have similar items. Starting from the top, put your prefered order of how you would like the mod to go about unifying items. For example, if you would like Thermal Expansion copper to be generated instead of IC2, put Thermal Expansion above IC2");
		References.generatedModIDList.addAll(Arrays.asList(References.preferedModIDList));
		ArrayList<String> generated = new ArrayList<String>();
		ArrayList<String> generatedCopy = new ArrayList<String>();
		generatedCopy.addAll(References.generatedModIDList);
		
		System.out.println("Made lists");
		
		for(int a = 0; a<oreDict.size(); a++)
		{
			for(int b = 0; b<oreDict.get(a).size(); b++) {
				NonNullList<ItemStack> itemStack = oreDict.get(a);
				String modID = itemStack.get(b).getItem().getCreatorModId(itemStack.get(b));
				System.out.println("ModId for " + itemStack.get(b).getDisplayName() + " is: " + modID);
				if(!generated.contains(modID)) {
					System.out.println("Generated Array does not contain: " + modID + " adding it now!");
					generated.add(modID);
				}
				if(!References.generatedModIDList.contains(modID)) {
					System.out.println("GeneratedModIDList does not contain: " + modID + " adding it now!");
					References.generatedModIDList.add(modID);
				}
			}
		}
		
		System.out.println("Checked OreDict for ModID's");
		
		if(!generatedCopy.equals(References.generatedModIDList) || generated.size() != References.generatedModIDList.size())
		{
			for(int i = 0; i<References.generatedModIDList.size(); i++)
			{
				while(i<References.generatedModIDList.size() && !generated.contains(References.generatedModIDList.get(i)))
					References.generatedModIDList.remove(i);
			}
			References.defaultPreferedModIDList = References.generatedModIDList.toArray(new String[0]);
			Settings.configuration.getCategory("Mod Hierarchy Preference").remove("Unification Preferences");
		}
		
		References.preferedModIDList = Settings.configuration.getStringList("Unification Preferences", "Mod Hierarchy Preference", References.defaultPreferedModIDList, "This list is auto-generated with mods found to have similar items. Starting from the top, re-arrange the order in how you would like the mod to go about unifying items. For example, if you would like Thermal Expansion copper to be generated instead of IC2, put Thermal Expansion above IC2");
	}
}
