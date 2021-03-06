package fr.toss.magiccrusade.common.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import fr.toss.magiccrusade.client.ClientPlayer;
import fr.toss.magiccrusade.client.gui.ChatColor;
import fr.toss.magiccrusade.common.entity.IMagicEntity;
import fr.toss.magiccrusade.common.items.IItemStatable;

public class Stats
{
	/** 
	 * floateger package class to deal with stats
	 */
	
	/** magic is increased by clarity. increase spells damages depending on it ratio. 100 magic = 1 damage, mean 1 magic == 0.01f damages*/
	private float	magic;
	
	/** endurance increase player health; (+0.1f per endurance points). Means 20 endurance == 1 hearth */
	private float	endurance;
	
	/** Strength increase player damages; (+0.1f per strength points). Means 20 strength == 1 hearth */
	private float	strength;
	
	/** stamina increase critical ratio: (+0.25% per point) */
	private float	stamina;
	
	/** increase magic and mana. 1 clarity = 10 magic. 1 clarity = 50 mana */
	private float	clarity;
	
	/** increase mana regeneration. stat to fix */
	private float	spirit;
	
	/** increase mana stat per 1 */
	private int		mana;

	public Stats()
	{
		this.magic = 0;
		this.endurance = 0;
		this.strength = 0;
		this.stamina = 0;
		this.clarity = 0;
		this.spirit = 0;
		this.mana = 0;
	}
	

	/**
	 * Set player stats depending on equipements. Also call `set_default_stats`
	 * @param equipements : player equipements
	 * @see Stats.set_default_stats
	 */
	@SideOnly(Side.CLIENT)
	public static Stats	get_player_stats(ClientPlayer player)
	{
		Stats	stats;
		
		player = ClientPlayer.instance();
		stats = Stats.get_default_stats(player);
		stats.combine(Stats.get_equipement_stats(player.get_player().inventory.armorInventory, player.get_player().inventory.getCurrentItem()));
		return (stats);
	}
	
	public static Stats	get_player_stats(ServerPlayer player)
	{
		Stats	stats;
		
		stats = Stats.get_default_stats(player);
		stats.combine(Stats.get_equipement_stats(player.get_player().inventory.armorInventory, player.get_player().inventory.getCurrentItem()));
		return (stats);
	}
	
	/** combine two stats */
	public void	combine(Stats stat)
	{
		this.endurance += stat.endurance;
		this.clarity += stat.clarity;
		this.magic += stat.magic;
		this.strength += stat.strength;
		this.spirit += stat.spirit;
		this.stamina += stat.stamina;
		this.mana += stat.mana;
	}
	
	
	/** return desc for magic stat */
	public static String	get_magic_desc()
	{
		return (I18n.format("stats.desc.magic"));
	}
	
	/** return desc for strength stat */
	public static String	get_strength_desc()
	{
		return (I18n.format("stats.desc.strength"));
	}
	
	/** return desc for endurance stat */
	public static String	get_endurance_desc()
	{
		return (I18n.format("stats.desc.endurance"));
	}
	
	/** return desc for stamina stat */
	public static String	get_stamina_desc()
	{
		return (I18n.format("stats.desc.stamina"));
	}
	
	/** return desc for clarity stat */
	public static String	get_clarity_desc()
	{
		return (I18n.format("stats.desc.clarity"));
	}
	
	/** return desc for spirit stat */
	public static String	get_spirit_desc()
	{
		return (I18n.format("stats.desc.spirit"));
	}
	
	/** return desc for mana stat */
	public static String get_mana_desc()
	{
		return (I18n.format("stats.desc.mana"));
	}
	
	
	

	/** return name for magic stat */
	public static String	get_magic_name()
	{
		return (I18n.format("stats.name.magic"));
	}
	
	/** return name for strength stat */
	public static String	get_strength_name()
	{
		return (I18n.format("stats.name.strength"));
	}
	
	/** return name for endurance stat */
	public static String	get_endurance_name()
	{
		return (I18n.format("stats.name.endurance"));
	}
	
	/** return name for stamina stat */
	public static String	get_stamina_name()
	{
		return (I18n.format("stats.name.stamina"));
	}
	
	/** return name for clarity stat */
	public static String	get_clarity_name()
	{
		return (I18n.format("stats.name.clarity"));
	}
	
	/** return name for spirit stat */
	public static String	get_spirit_name()
	{
		return (I18n.format("stats.name.spirit"));
	}
	
	/** return name for mana stat */
	public static String get_mana_name()
	{
		return (I18n.format("stats.name.mana"));
	}

	
	
	
	/** return stats endurance */
	public float	get_magic()
	{
		return (this.clarity * 5.0f);
	}
	
	/** return stats endurance */
	public float	get_strength()
	{
		return (this.strength);
	}
	
	/** return stats endurance */
	public float	get_endurance()
	{
		return (this.endurance);
	}
	
	/** return stats endurance */
	public float	get_stamina()
	{
		return (this.stamina);
	}
	
	/** return stats endurance */
	public float	get_clarity()
	{
		return (this.clarity);
	}
	
	/** return stats endurance */
	public float	get_spirit()
	{
		return (this.spirit);
	}
	
	/** get mana value */
	public int get_mana()
	{
		return (this.mana);
	}
	
	
	/** set stats magic */
	public void	set_magic(float value)
	{
		this.magic = value;
	}
	
	/** set stats magic */
	public void	set_endurance(float value)
	{
		this.endurance = value;
	}
	
	/** set stats strength */
	public void	set_strength(float value)
	{
		this.strength = value;
	}
	
	/** set stats stamina */
	public void	set_stamina(float value)
	{
		this.stamina = value;
	}
	
	/** set stats clarity */
	public void	set_clarity(float value)
	{
		this.clarity = value;
	}
	
	/** set stats spirit */
	public void	set_spirit(float value)
	{
		this.spirit = value;
	}
	
	/** set stats mana */
	public void	set_mana(int value)
	{
		this.mana = value;
	}

	public Collection to_string_list()
	{
		List	list;
		float	values[] = {this.endurance, this.stamina, this.strength,
							this.clarity, this.magic, this.spirit, this.mana};
		String	names[] = {get_endurance_name(), get_stamina_name(), get_strength_name(),
						get_clarity_name(), get_magic_name(), get_spirit_name(), get_mana_name()};

		list = new ArrayList();
		for (int i = 0; i < values.length; i++)
		{
			if (values[i] == 0)
				continue ;
			if (values[i] > 0)
			{
				list.add(ChatColor.GREEN + "+ " + values[i] + " " + names[i]);
			}
			else
			{
				list.add(ChatColor.RED + "- " + values[i] + " " + names[i]);
			}
		}
    	return (list);
	}

	
	/**
	 * set player default stat for classe and level
	 * 
	 * @param classe:	player classe (for stats ratios*)
	 * @param level	:	player level (to calcul per level stats)
	 */
	public static Stats	get_default_stats(IMagicEntity entity)
	{
		Stats	stats;
		Stats	stats_per_lvl;
		
		stats = entity.get_classe().get_default_stats();
		stats_per_lvl = entity.get_classe().get_stats_per_lvl();
		stats.endurance += stats_per_lvl.endurance * entity.get_level();
		stats.stamina += stats_per_lvl.stamina * entity.get_level();
		stats.mana += stats_per_lvl.mana * entity.get_level();
		stats.magic += stats_per_lvl.magic * entity.get_level();
		stats.strength += stats_per_lvl.strength * entity.get_level();
		stats.clarity += stats_per_lvl.clarity * entity.get_level();
		stats.spirit += stats_per_lvl.spirit * entity.get_level();
		return (stats);
	}

	/**
	 * Set player stats depending on equipements. Also call `set_default_stats`
	 * @param equipements : player equipements
	 * @see Stats.set_default_stats
	 */
	public static Stats	get_equipement_stats(ItemStack equipements[], ItemStack hand)
	{
		Stats	stats;
		
		stats = new Stats();
		if (hand != null && hand.getItem() instanceof IItemStatable)
		{
			stats.combine(((IItemStatable)hand.getItem()).get_stats());
		}
		for (ItemStack item : equipements)
		{
			if (item != null && item.getItem() != null)
			{
				if (item.getItem() instanceof IItemStatable)
				{
					stats.combine(((IItemStatable)item.getItem()).get_stats());
				}
			}
		}
		return (stats);
	}
	
	
	/** Return stats for this entity */
	public static Stats	get_entity_stats(EntityPlayer player)
	{
		return (get_equipement_stats(player.inventory.armorInventory, player.inventory.getCurrentItem()));
	}
	
	/** Return stats for this entity */
	public static Stats	get_entity_stats(EntityLivingBase entity)
	{
		Stats			stats;
		IItemStatable	tmp;
		
		stats = new Stats();
		for (ItemStack is : entity.getInventory())
		{
			if (is != null && is.getItem() instanceof IItemStatable)
			{
				tmp = (IItemStatable)is.getItem();
				stats.combine(tmp.get_stats());
			}
		}
		return (stats);
	}
}
