package pokemon;

import pokemon.Pokemon.PokemonTyp;

public class Moves_Normal extends Moves
{

	public Moves_Normal(String name, int dmg)
	{
		super(name, dmg, PokemonTyp.FEUER);
	
		ineffectiveVs.add(PokemonTyp.GESTEIN);
		ineffectiveVs.add(PokemonTyp.STAHL);
		
		noEffect.add(PokemonTyp.GEIST);
	}

}