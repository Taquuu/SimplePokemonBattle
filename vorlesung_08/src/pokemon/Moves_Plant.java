package pokemon;

import pokemon.Pokemon.PokemonTyp;

public class Moves_Plant extends Moves
{

	public Moves_Plant(String name, int dmg)
	{
		super(name, dmg, PokemonTyp.PFLANZE);
		
		effectiveVs.add(PokemonTyp.WASSER);
		effectiveVs.add(PokemonTyp.BODEN);
		effectiveVs.add(PokemonTyp.GESTEIN);
		
		ineffectiveVs.add(PokemonTyp.FEUER);
		ineffectiveVs.add(PokemonTyp.PFLANZE);
		ineffectiveVs.add(PokemonTyp.GIFT);
		ineffectiveVs.add(PokemonTyp.FLUG);
		ineffectiveVs.add(PokemonTyp.KÄFER);
		ineffectiveVs.add(PokemonTyp.DRACHE);
		ineffectiveVs.add(PokemonTyp.STAHL);
	}

}