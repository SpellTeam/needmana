package fr.spellTeam.NeedMana.entities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import fr.spellTeam.NeedMana.Game;



public class EntityMob extends Entity{

	private Rectangle hitbox;
	
	
	public EntityMob(String name, int width, int height)
	{
		
		
		super(name, new Texture(Gdx.files.internal("texture/mob_left.png")), 
				new Texture(Gdx.files.internal("texture/mob_right.png")));
		this.name = name;
		this.width = width;
		this.height = height;
		
		spawn(Game.WIDTH-100,100);
		hitbox = new Rectangle(this.getX(),0,this.getWidth(),this.getHeight());
	}

	public void spawn(int x, int y){
		
		this.position.x = x;
		this.position.y = y;
	}
	
	public void AffectWithGravity(){
		
		position.y -= 2;
	}
	
	
	public void updateHitbox(Vector2 position){
		hitbox.setPosition(new Vector2(position));
		if (hitbox.overlaps(Game.getInstance().getPlayer().getHitbox())){
			Game.getInstance().getPlayer().setX(Game.getInstance().getPlayer().getX()-100);
		}
	}
	public void moveRdm(){
		position.x += Math.random()* 20 * Gdx.graphics.getDeltaTime()*30;
		position.x -= Math.random()* 18 * Gdx.graphics.getDeltaTime()*30;
		
	}
	
	public void render(float delta, OrthographicCamera camera, SpriteBatch batch){
		batch.setProjectionMatrix(camera.combined);	
		if (position.y < 0){
			position.y=0;
		}
		if (direction == 0){
				batch.draw(sprite_left,position.x ,position.y ,width, height);
				
			} else if (direction == 1){
				batch.draw(sprite_right,position.x ,position.y ,width, height);
			}

		AffectWithGravity();
		
		if (this.hitbox.overlaps(Game.getInstance().getPlayer().getHitbox())){
			Game.getInstance().getPlayer().decrementerPV(1);
			//Game.getInstance().getPlayer().setX(Game.getInstance().getPlayer().getX()-10);
		}
		if ((int)this.position.y - (int)Game.getInstance().getPlayer().getY() < 5 ||
				(int)this.position.y - (int)Game.getInstance().getPlayer().getY() > -5){
			if (this.position.x > Game.getInstance().getPlayer().getX()) this.move(-mouvement.x/4);
			else this.move(mouvement.x/4);
		}
		
		//updateHitbox(this.position);
		//moveRdm();
	}

}
