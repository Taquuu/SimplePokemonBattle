package pokemon;

import pokemon.Pokemon.PokemonTyp;

public class Moves_Water extends Moves
{

	public Moves_Water(String name, int dmg)
	{
		super(name, dmg, PokemonTyp.WASSER);
		
		effectiveVs.add(PokemonTyp.FEUER);
		effectiveVs.add(PokemonTyp.BODEN);
		effectiveVs.add(PokemonTyp.GESTEIN);
		
		ineffectiveVs.add(PokemonTyp.WASSER);
		ineffectiveVs.add(PokemonTyp.PFLANZE);
		ineffectiveVs.add(PokemonTyp.DRACHE);
		
	}

}