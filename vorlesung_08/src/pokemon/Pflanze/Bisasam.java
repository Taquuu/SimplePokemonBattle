package pokemon.Pflanze;
import pokemon.Moves;
import pokemon.Pokemon;

public class Bisasam extends Pokemon
{

	protected Bisasam(String name, PokemonTyp type, int maxHealth)
	{
		super(name, PokemonTyp.PFLANZE, maxHealth);
		addMove();
		setHealth(maxHealth);
	}

	public Bisasam()
	{
		
		super("Bisasam", PokemonTyp.PFLANZE, 40);
		addMove();
		setHealth(40);
	}
	
	void addRankenHieb()
	{
		
		setAttack(Moves.getRankenhieb());
	}
	
	@Override
	public void jump()
	{
		System.out.println(this.getName() + " springt vor Freude!");
		System.out.println("Bisa Bisasam!");
	}
	
}