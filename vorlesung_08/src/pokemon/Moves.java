package pokemon;
import java.util.ArrayList;
import java.util.List;

import pokemon.Pokemon.PokemonTyp;
public class Moves
{	
	
	private String _name;
	private int _damage;
	private PokemonTyp _typ;
	protected List<PokemonTyp> effectiveVs = new ArrayList<PokemonTyp>();
	protected List<PokemonTyp> ineffectiveVs = new ArrayList<PokemonTyp>();
	protected List<PokemonTyp> noEffect = new ArrayList<PokemonTyp>();
			
	Moves (String name, int damage, PokemonTyp typ)
	{
		
		setName(name);
		setDamage(damage);
		setTyp(typ);
		setEffectiveness(typ);
	}
			
	void setName(String name)
	{
		_name = name;
	}
	
	void setDamage(int damage)
	{
		_damage = damage;
	}
	
	void setTyp(PokemonTyp typ)
	{
		_typ = typ;
	}
	
	void setEffectiveness(PokemonTyp typ)
	{
		if (typ == PokemonTyp.FEUER)
		{
			//Effektiv gegen
			effectiveVs.add(PokemonTyp.PFLANZE);
			
			//Ineffektiv gegen
			
			ineffectiveVs.add(PokemonTyp.WASSER);
		}
		else if (typ == PokemonTyp.PFLANZE)
		{
			//Effektiv gegen
			effectiveVs.add(PokemonTyp.WASSER);
			
			//Ineffektiv gegen
			
			ineffectiveVs.add(PokemonTyp.PFLANZE);
		}
		else if (typ == PokemonTyp.WASSER)
		{
			//Effektiv gegen
			effectiveVs.add(PokemonTyp.FEUER);
			
			//Ineffektiv gegen
			
			ineffectiveVs.add(PokemonTyp.PFLANZE);
		}
	}
	
			
	public String getName()
	{
		return _name;
	}
	
	public int getDamage()
	{
		return _damage;
	}
	
	PokemonTyp getTyp()
	{
		return _typ;
	}
	public List<PokemonTyp> getEffectiveVs()
	{
		return effectiveVs;
	}
	
	public List<PokemonTyp> getIneffectiveVs()
	{
		return ineffectiveVs;
	}
	public List<PokemonTyp> getNoEffect()
	{
		return noEffect;
	}
	
	public String toString()
	{
		return getName() + " ( Schaden: " + getDamage() + "   Typ: " + getTyp() + ")"; 
	}
	
	public static Moves getRankenhieb()
	{
		return Rankenhieb;
	}

	public static void setRankenhieb(Moves rankenhieb)
	{
		Rankenhieb = rankenhieb;
	}
	
	
	
	
	static Moves Tackle = new Moves_Normal("Tackle", 2);
	static Moves Kratzer = new Moves_Normal("Kratzer", 5);
	static Moves Glut = new Moves_Fire("Glut", 10);
	static Moves Aquaknarre = new Moves_Water("Aquaknarre", 10);
	static Moves Rankenhieb = new Moves_Plant("Rankenhieb", 10);
	public static Moves Rasierblatt = new Moves_Plant("Rasierblatt", 20);
	public static Moves Flammenwurf = new Moves_Fire("Flammenwurf", 20);
			
}


