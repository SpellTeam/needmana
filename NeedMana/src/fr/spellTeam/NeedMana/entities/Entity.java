package fr.spellTeam.NeedMana.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity implements GameObject{
	
	protected String name;
	protected Vector2 position  = new Vector2();
	protected Vector2 mouvement = new Vector2(10,10);
	protected float speed = 60 * 2, gravity = 60 * 1.8f, animationTime = 0;
	protected int width,height;
	protected Sprite sprite_left;
	protected Sprite sprite_right;
	protected int direction = 0;
	protected boolean jumping = false;
	protected SpellAttack currentSpell;
	protected boolean shooting;
	
	protected int pv;
	
	
	protected Entity(String name, Texture left, Texture right){
		this.name = name;
		this.sprite_left = new Sprite(left);
		this.sprite_right = new Sprite(right);
		
	}
	
	public abstract void render(float delta, OrthographicCamera camera, SpriteBatch batch);
	
	public void move(float dx){
		
		if (dx > 0){
			
			direction = 1;
			
		} else if (dx < 0){
			
			direction = 0;
			
		}
		
		position.x += dx * Gdx.graphics.getDeltaTime() * 30;
		
		
	}
	
	public void jump(){
		int i;
		if (!jumping){
			for (i = 0; i<10 ; i+=1)
			{
				position.y += mouvement.y;
			}
			
			//jumping = true;
			
		}
		
	}
	
	public void shoot(SpellAttack spell){
		
		//currentSpell = new SpellAttack("fireBall");
		//Game.getInstance().addGameObject(currentSpell);
		
	}
	
	public void collide(){
		
		
		
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getX() {
		return position.x;
	}

	public void setX(float val) {
		this.position.x = val;
	}
	
	public Vector2 getMouvement(){
		return this.mouvement;
	}

	public float getY() {
		return position.y;
	}

	public void setY(float val) {
		this.position.y = val;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
