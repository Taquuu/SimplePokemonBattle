package pokemon.Feuer;

import pokemon.Pokemon;

public class Glumanda extends Pokemon
{

	protected Glumanda(String name, PokemonTyp type, int maxHealth)
	{
		super(name, PokemonTyp.FEUER, maxHealth);
		addMove();
		setHealth(maxHealth);
	}

	public Glumanda()
	{
		
		super("Glumanda", PokemonTyp.FEUER, 40);
		addMove();
		setHealth(40);
	}

	@Override
	public void jump()
	{
		System.out.println(this.getName() + " springt vor Freude!");
		System.out.println("Glu!");
	}
	
}
