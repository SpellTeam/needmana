package fr.spellTeam.NeedMana.entities;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Spell{
	private int id;
	private String name;
	private String description;
	private int degats;
	private int effetMax;
	private String sprite;
	private String icone;
	private Vector2 position;
	
	public Spell (int id, String name, String description, int degats, int effetMax, String sprite, String icone, Vector2 position) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.degats = degats;
		this.effetMax = effetMax;
		this.sprite = sprite;
		this.icone = icone;
		this.position = position;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getDegats() {
		return degats;
	}

	public int getEffetMax() {
		return effetMax;
	}

	public String getSprite() {
		return sprite;
	}

	public String getIcone() {
		return icone;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDegats(int degats) {
		this.degats = degats;
	}

	public void setEffetMax(int effetMax) {
		this.effetMax = effetMax;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}
	
	public String toString() {
		return "id : "+ id +"- nom : "+ name +"- description : "+ description +"- icone : "+icone;
	}
	
	public abstract void render(float delta, OrthographicCamera camera, SpriteBatch batch);
}
