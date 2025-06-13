package pokemon;

import pokemon.Pokemon.PokemonTyp;

public class Moves_Fire extends Moves
{

	public Moves_Fire(String name, int dmg)
	{
		super(name, dmg, PokemonTyp.FEUER);
		
		effectiveVs.add(PokemonTyp.PFLANZE);
		effectiveVs.add(PokemonTyp.KÄFER);
		effectiveVs.add(PokemonTyp.STAHL);
		
		ineffectiveVs.add(PokemonTyp.FEUER);
		ineffectiveVs.add(PokemonTyp.WASSER);
		ineffectiveVs.add(PokemonTyp.GESTEIN);
		ineffectiveVs.add(PokemonTyp.DRACHE);
		
	}

}
