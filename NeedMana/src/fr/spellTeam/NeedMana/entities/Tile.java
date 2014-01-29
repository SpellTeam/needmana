package fr.spellTeam.NeedMana.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public abstract class Tile implements GameObject{

	protected String name;
	protected Sprite Texture;
	protected Vector2 pos;
	protected Rectangle bounds;
	    
	
	public Tile(String name, Texture texture) {
		
	       this.name = name;
	       this.Texture = new Sprite(texture);
	       this.pos = new Vector2();
	     
	       
	}
	
	public Vector2 getPos(){
		
		return pos;
	}
	
	public Rectangle getBounds(){
		
		return bounds;
		
	}


	@Override
	public abstract void render(float delta, OrthographicCamera camera, SpriteBatch batch);

	
	

}