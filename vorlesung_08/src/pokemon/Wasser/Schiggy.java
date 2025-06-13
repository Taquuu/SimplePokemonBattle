package pokemon.Wasser;

import pokemon.Moves;
import pokemon.Pokemon;

public class Schiggy extends Pokemon
{

	protected Schiggy(String name, PokemonTyp type, int maxHealth)
	{
		super(name, PokemonTyp.WASSER, maxHealth);
		addMove();
		setHealth(maxHealth);
	}

	public Schiggy()
	{
		
		super("Schiggy", PokemonTyp.WASSER, 40);
		addMove();
		setHealth(40);
	}
	
	public void takeDamage(Moves move)
	{
		if (move.getEffectiveVs().contains(this.getTyp()))
		{
			setHealth(getHealth() - ((move.getDamage() *2) -1));
			System.out.println(move.getName() + " verursacht " + (move.getDamage() *2) + " Schaden. ");
		}
		else if (move.getIneffectiveVs().contains(this.getTyp()))
		{
			setHealth(getHealth() - ((move.getDamage() /2) -1));
			System.out.println(move.getName() + " verursacht " + (move.getDamage() /2) + " Schaden. ");
		}
	}
	
	@Override
	public void jump()
	{
		System.out.println(this.getName() + " springt vor Freude!");
		System.out.println("Schiggy Schiggy!");
	}
}