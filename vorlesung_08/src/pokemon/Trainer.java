package pokemon;
import java.util.List;
import java.util.Scanner;

import item.HealthPotion;
import item.Item;

import java.util.ArrayList;
import item.Pokeball;


public class Trainer
{

	public String _name;
	private List<Pokemon> _myPokemon = new ArrayList<Pokemon>();
	public Pokemon _activePokemon;
	public boolean _fainted;
	public int _teamHealth;
	public List<InventoryComponent> inventory;
	
	Trainer (String name)
	{
		
		setName(name);
		//inventory.add(new InventoryComponent(new HealthPotion(),2));
		//inventory.add(new InventoryComponent(new Pokeball(),2));
	}
	
	void setName(String name) 
	{
		_name = name;
	}
	
	void setTeam(Pokemon pokemon)
	{
		_myPokemon.add(pokemon);
	}
	
	void setActive(Pokemon pokemon)
	{
		_activePokemon = pokemon;
	}
	
	void setTeamHealth(int teamHealth)
	{
		_teamHealth = teamHealth;
		if (_teamHealth <= 0)
		{
			_teamHealth = 0;
			ko();
		}
	}
	
	String getName()
	{
		return _name;
	}
	
	List<Pokemon> getTeam()
	{
		return _myPokemon;
	}
	
	Pokemon getActive()
	{
		return _activePokemon;
	}
	
	boolean getIsReadyToFight()
	{
		return !_fainted;
	}
	
	void ko()
	{
		_fainted = true;
	}
	
	void catchPokemon(Pokemon poke)
	{
		if (this.getTeam().size() == 0)
		{
			
			setTeam(poke);
			setActive(poke);
		}
		else setTeam(poke);
		poke.setTrainer(this);
	}
	
	void callPokemon()
	{
		
		while (this.getActive().getHealth() <= 0)
		{
			for (Pokemon p : this.getTeam())
			{
				if (p.getHealth() > 0)
				{
					this.setActive(p);
					System.out.println("\n" + this._name + " schickt " + p.getName() + " in den Kampf!" );
					p.jump();
				}
			}
			if (getIsReadyToFight() == false)
			{
				System.out.println("Alle Pokemon von " + getName() + " sind kampfunfähig.");
			}
		}
		
	}
	
	void callPokemon(Pokemon poke)
	{
		if (poke.defeated() != true)
		{
			setActive(poke);
			System.out.println("\n" + this._name + " schickt " + poke.getName() + " in den Kampf!" );
			poke.jump();
		}
		else System.out.println(poke.getName() + " ist besiegt und kann nicht kämpfen!");
	}
	
	public String teamToString()
	{
		String string = "\nDein Team: ";
		for (Pokemon p : this.getTeam())
		{
			string += "\n" + (this.getTeam().indexOf(p) + 1) + " - " + p.toString();
		}
		return string;
	}
	
	
	
	void checkTeam()
	{
		
		int h = this.getTeam().size();
		for (Pokemon p : this.getTeam())
		{
			if (p.getHealth() <= 0)
			{
				h-=1;
			}
		}
		setTeamHealth(h);
	}
	
	private void lostItem(Item item, Trainer trainer)
	{
		
	}
	
	
	public Trainer battle(Trainer t1, Trainer t2)
	{
		Trainer winner = null;
		Scanner in = new Scanner(System.in);
		
		if(t1.getTeam().size() > 1)
		{
			System.out.println(t1.teamToString());
			System.out.println("\nWelches Pokemon möchtest du in den Kampf rufen?");
			int choice  = (in.nextInt() -1);
			t1.callPokemon(t1.getTeam().get(choice));
		}
		else t1.callPokemon();		
		
		t2.callPokemon();
			
		System.out.println("Was möchtest du tun? -> 1: Kampf");
		
		int choice = in.nextInt();
		String test = in.nextLine();
		
		if (choice == 1)
		{
			System.out.println("Der Kampf beginnt!");
			
			while (t1.getIsReadyToFight() == true && t2.getIsReadyToFight() == true)
			{
				
				PokemonMain.fight(t1.getActive(), t2.getActive());
				t1.checkTeam();
				t2.checkTeam();
				
				if (t1.getActive().defeated() == true && t1.getIsReadyToFight() == true)
				{
					
					
					System.out.println("Wähle ein anderes Pokemon aus!");
					t1.teamToString();
					
					if (in.hasNextInt())
					{
						int choice1 = in.nextInt();
					
						if (choice1 >= 0 && choice1 < t1.getTeam().size())
						{
						t1.callPokemon(t1.getTeam().get(choice1));
						}
						else System.out.println("Ungültige Auswahl.");
					}
				}
				else if (t2.getActive().defeated() == true && t2.getIsReadyToFight() == true)
				{
					t2.callPokemon();
				}
			
			}
			if (t1.getIsReadyToFight() == false)
			{
				System.out.println("Alle deine Pokemon wurden besiegt. Du fällst in Ohnmacht.");
				winner = t2;
			}
			else if (t2.getIsReadyToFight() == false)
			{
				System.out.println(t2.getName() + " wurde besiegt!");
				winner = t1;
			}
		}
		else System.out.println("Das geht leider noch nicht.");
		
		
		return winner;
	}
	
	public static class InventoryComponent
	{
		private Item item;
		private int quantity;
		
		public InventoryComponent(Item item, int quantity)
		{
			this.item = item;
			this.quantity = quantity;
		}
		
		public String toString()
		{
			return item.getName() + ", " + quantity;
		}
		
	}
	
	
	
	
	
	
}
