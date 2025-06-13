package pokemon;

import java.util.Random;
import java.util.Scanner;

import pokemon.Pokemon.PokemonTyp;
import pokemon.Feuer.Glumanda;
import pokemon.Feuer.Glutexo;
import pokemon.Pflanze.Bisaknosp;
import pokemon.Pflanze.Bisasam;
import pokemon.Wasser.Schiggy;

public class PokemonMain
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	/*Pokemon (String name, int lvl, int exp, PokemonTyp typ, int health, int maxHealth, List<Move> moves);
    // this.moves.add(new Attack("Tackle ", 2, PokemonTyp.NORMAL));
    //Trainer (String name, List<Pokemon> team);
		*/
		Scanner in = new Scanner(System.in);
		Random rnd = new Random();
		
		System.out.println("Hallo Trainer! Wie lautet dein Name?");
		Trainer Trainer = new Trainer(in.next());
		System.out.println("Schön dich kennenzulernen " + Trainer.getName() + " .");
		
		// Sicherstellen, dass die Namen gültig sind! Abfrage
		
		System.out.println("Wie war nochmal der Name deines Rivalen?");
		Trainer Rivale = new Trainer(in.next());
		System.out.println("Richtig, " + Rivale.getName() + " war sein Name. Es lag mir auf der Zunge!");
		
	
		Glumanda p1 = new Glumanda();
		Schiggy p2 = new Schiggy();
		Bisasam p3 = new Bisasam();
		Bisaknosp p4 = new Bisaknosp();
		Glutexo p5 = new Glutexo();
		
		
		
		
		
		System.out.println("Wähle dein Starterpokemon!");
		System.out.println(p1.getName() +", " + p2.getName() + ", oder " + p3.getName() + ".");
		
		StringBuilder choice = new StringBuilder(in.next());
		
		while (Trainer.getActive() == null)
		{
		
			if (choice.toString().equalsIgnoreCase(p1.getName()))
			{
				Trainer.catchPokemon(p1);
				System.out.println("Du hast " + p1.getName() + " ausgewählt!");
			}
			else if (choice.toString().equalsIgnoreCase(p2.getName()))
			{
				Trainer.catchPokemon(p2);
				System.out.println("Du hast " + p2.getName() + " ausgewählt!");
			}
			else if (choice.toString().equalsIgnoreCase(p3.getName()))
			{
				Trainer.catchPokemon(p3);
				System.out.println("Du hast " + p3.getName() + " ausgewählt!");
			}
			else System.out.println("Ungültige Auswahl.");
			
			if (Trainer.getTeam().contains(p1))
			{
				Rivale.catchPokemon(p2);
				System.out.println("Dein Rivale " + Rivale.getName() + " hat " + p2.getName() + " ausgewählt!");
			}
			else if (Trainer.getTeam().contains(p2))
			{
				Rivale.catchPokemon(p3);
				System.out.println("Dein Rivale " + Rivale.getName() + " hat " + p3.getName() + " ausgewählt!");
			}
			else if (Trainer.getTeam().contains(p3))
			{
				Rivale.catchPokemon(p1);
				System.out.println("Dein Rivale " + Rivale.getName() + " hat " + p1.getName() + " ausgewählt!");
			}
		}
		System.out.println(Rivale.getName() + " fordert dich zu einem Kampf heraus!");
		Trainer.catchPokemon(p4);
		Rivale.catchPokemon(p5);
		//System.out.println("\n" + Trainer.battle(Trainer, Rivale).getName() + " hat den Kampf gewonnen!");
		Trainer.battle(Trainer, Rivale);
		System.out.println("Was möchtest du tun?");
		//in.close();
	}

	
	
	public static Pokemon fight(Pokemon p1, Pokemon p2)
	{
		
		Scanner in = new Scanner(System.in);
		Pokemon attacker = p1;
		Pokemon defender = p2;
		Pokemon winner = null;
		
		while (!attacker.defeated() && !defender.defeated())
		{
			
			if (attacker == p1)
			{
				
				System.out.println("Welche Attacke soll " +p1.getName() + " ausführen?");
				for (Moves i : p1.getAttack())
				{
					System.out.print((p1.getAttack().indexOf(i) + 1) + " : ");
					System.out.println(i);
				}
				
				System.out.println("Angriff mit Attacke Nr. ?");
				
				boolean valid = false;
				int choice = (in.nextInt() -1);
				
				if (choice >= 0 && choice < p1.getAttack().size())
				{
					
					valid = true;
					Moves chosenAttack = p1.getAttack().get(choice);
		
					System.out.println("Dein " + p1.getName() + " greift " + p2.getName() + " an mit " + chosenAttack.getName() + ".");
					p1.attack(p2, chosenAttack);
					System.out.println(p2.getName() + " hat noch " + p2.getHealth() + " HP.");
					
					if (!defender.defeated() == true)
					{
						attacker = p2;
						defender = p1;
					}
					
					
				}
				
				if (valid == false)
				{
					
					System.out.println("Dies ist keine Attacke, die dein Pokemon beherrscht! Probiere es erneut.");
				}
				
				if (defender.defeated() == true)
				{
					
					winner = attacker;
					
					System.out.println("Das " + defender.getName() + " von " + defender.getTrainer().getName() + " wurde besiegt!");
					
				}
				
			} else if (attacker == p2)
			{
				
				/*System.out.println("Welche Attacke soll " +p2.getName() + " ausführen?");
				for (Moves i : p2.getAttack()) {
					System.out.print(p2.getAttack().indexOf(i) + " : ");
					System.out.println(i);
				}
				System.out.println("Angriff mit Attacke Nr. ?");
				
				Moves chosenAttack = p2.getAttack().get(in.nextInt());
				*/
				
				//int rnd = new Random().ints(0, (p2.getAttack().size() +1));
				Random rnd = new Random();
				
				System.out.println();
				Moves chosenAttack = p2.getAttack().get(rnd.nextInt(p2.getAttack().size()));
				System.out.println(p2.getName() + " greift " + p1.getName() + " an mit " + chosenAttack.getName() + ".");
				p2.attack(p1, chosenAttack);
				System.out.println(p1.getName() + " hat noch " + p1.getHealth() + " HP.");
				
				if (defender.defeated() == true)
				{
					
					winner = attacker;
					
					System.out.println("Das " + defender.getName() + " von " + defender.getTrainer().getName() + " wurde besiegt!");
					System.out.println("Dein " + defender.getName() + " kann nicht mehr kämpfen.");
					
				}
				else if (defender.defeated() == !true)
				{

					attacker = p1;
					defender = p2;
					
				}
				
			}	
			
		} 
		//in.close();
		return winner;
	}
}
