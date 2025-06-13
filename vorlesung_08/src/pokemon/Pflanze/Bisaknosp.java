package pokemon.Pflanze;
import pokemon.Moves;
public class Bisaknosp extends Bisasam
{

	protected Bisaknosp(String name, PokemonTyp type, int maxHealth)
	{
		super(name, PokemonTyp.PFLANZE, maxHealth);
		addMove();
		setHealth(maxHealth);
	}

	public Bisaknosp()
	{
		
		super("Bisaknosp", PokemonTyp.PFLANZE, 60);
		setHealth(60);
		setAttack(Moves.Rasierblatt);
	}
	
	@Override
	public void jump()
	{
		System.out.println(this.getName() + " springt vor Freude!");
		System.out.println("Bisaaknosp!");
	}
}