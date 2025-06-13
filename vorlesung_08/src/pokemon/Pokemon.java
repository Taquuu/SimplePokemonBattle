package pokemon;
import pokemon.Moves;
import pokemon.PokemonMain;
import pokemon.Wasser.Schiggy;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;



public abstract class Pokemon
{
	
	public enum PokemonTyp {NORMAL, FEUER, WASSER, PFLANZE, ELEKTRO, EIS, KAMPF, GIFT, BODEN, FLUG, PSYCHO, KÄFER, GESTEIN, GEIST, DRACHE, UNLICHT, STAHL, FEE};
	
	// Pokemon Class Attribute

	private String _name;
	private int _lvl;
	private int _exp;
	public PokemonTyp _typ;
	private double _health;
	private int _maxHealth;
	private boolean _defeated;
	public List<Moves> _moves = new ArrayList<Moves>();
	public Trainer _trainer;
	
	// Konstruktor
	
	protected Pokemon (String name, PokemonTyp typ, int maxHealth)
	{
		
		setName(name);
		this._lvl = 0;
		this._exp = 0;
		setTyp(typ);
		this._health=_maxHealth;
		setMaxHealth(maxHealth);
		//this.attacks.add(new Attack("Tackle ", 2, PokemonTyp.NORMAL));
	}
	
	// Setter
	
	void setName(String name) 
	{
		_name = name;
	}
	void setLvl(int lvl)
	{
		_lvl = lvl;
	}
	void setExp(int exp)
	{
		_exp = exp;
	}
	void setTyp(PokemonTyp typ)
	{
		_typ = typ;
	}
	public void setHealth(double health)
	{
		_health = health;
		if (_health <= 0)
		{
			_health = 0;
			ko();
		}
	}
	void setMaxHealth(int maxHealth)
	{
		_maxHealth = maxHealth;
	}
	protected void setAttack(Moves moves)
	{
		_moves.add(moves);
	}
	void setAttack1(Moves moves1)
	{
		_moves.add(moves1);
	}
	void setTrainer(Trainer trainer)
	{
		_trainer = trainer;
	}
	
	// Getter
	
	public String getName()
	{
		return _name;
	}
	
	int getLvl()
	{
		return _lvl;
	}
	
	int getExp()
	{
		return _exp;
	}
	
	protected PokemonTyp getTyp()
	{
		return _typ;
	}
	
	protected double getHealth()
	{
		return _health;
	}
	
	int getMaxHealth()
	{
		return _maxHealth;
	}
	
	boolean defeated()
	{
		return _defeated;
	}
	
	List<Moves> getAttack()
	{
		return _moves;
	}
	
	Trainer getTrainer()
	{
		return _trainer;
	}
	
	String getStatus()
	{
		String string ="";
		if (defeated() == true)
		{
			string = "Besiegt";
		}
		else string = "Kampfbereit";
		return string;
	}
	
	// Funktionen
	
	void ko()
	{
		_defeated = true;
	}
	
	void addHealth(int amount)
	{
		int heal = 0; // Skill muss noch eingefügt werden.
		setHealth(getHealth() + heal);
	}
	
	public void takeDamage(Moves move)
	{		
		if (move.getEffectiveVs().contains(this.getTyp()))
		{
			setHealth(getHealth() - (move.getDamage() *2));
			System.out.println(move.getName() + " verursacht " + (move.getDamage() *2) + " Schaden. ");
		}
		else if (move.getIneffectiveVs().contains(this.getTyp()))
		{
			setHealth(getHealth() - (move.getDamage() /2));
			System.out.println(move.getName() + " verursacht " + (move.getDamage() /2) + " Schaden. ");
		}
		else if (move.getNoEffect().contains(this.getTyp()))
		{
			System.out.println(move.getName() + " hat keine Wirkung auf " + this.getName());
		}

	}
	
	public String toString()
	{
		String Name = ("Name: " + getName().toString() + ", KP: " + this.getHealth() + " / " + this.getMaxHealth() + ", Status: " + this.getStatus());
		return Name;
	}
	
	public void addExp()
	{
		setExp(getExp()+1);
		System.out.println(getName() + " hat Erfahrung bekommen.");
	}
	
	public void addMove()
	{
		
		if (this.getTyp() == PokemonTyp.FEUER) {
			setAttack(Moves.Glut);
		}
		if (this.getTyp() == PokemonTyp.PFLANZE) {
			setAttack(Moves.Rankenhieb);
		}
		if (this.getTyp() == PokemonTyp.WASSER) {
			setAttack(Moves.Aquaknarre);
		}
	}
	
	public void attack(Pokemon defender,Moves moves)
	{
		
		defender.takeDamage(moves);
		
	}
	
	abstract public void jump();
	
	

	
	
}


