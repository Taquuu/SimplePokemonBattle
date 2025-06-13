package pokemon.Feuer;

import pokemon.Moves;

public class Glutexo extends Glumanda
{

	protected Glutexo(String name, PokemonTyp type, int maxHealth)
	{
		super(name, PokemonTyp.FEUER, maxHealth);
		addMove();
		setHealth(maxHealth);
	}

	public Glutexo()
	{
		
		super("Glutexo", PokemonTyp.FEUER, 60);
		setHealth(60);
		setAttack(Moves.Flammenwurf);
	}
	
	@Override
	public void jump()
	{
		System.out.println(this.getName() + " lehnt lässig an der Wand.");
		System.out.println("Glutexo.");
	}
}
