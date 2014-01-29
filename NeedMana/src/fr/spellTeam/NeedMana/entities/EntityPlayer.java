package fr.spellTeam.NeedMana.entities;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class EntityPlayer extends Entity
{
	private Rectangle hitbox;
	//private boolean collisionX=false;
	//private boolean collisionY=false;
	private boolean jumping = false;
	private int pv = 3;
	
	
	private int actualPositionY;
	private int oldPositionY;
	
	public EntityPlayer(String name, int width, int height)
	
	{
		
		
		super(name, new Texture(Gdx.files.internal("texture/char_left.png")), 
				new Texture(Gdx.files.internal("texture/char_right.png")));
		this.name = name;
		this.width = width;
		this.height = height;
		hitbox = new Rectangle(this.getX(), this.getY(), this.height, this.width);
		hitbox.x= this.getX();
		hitbox.y= this.getY();
		spawn(400,400);
		
	}
	
	public Rectangle getHitbox(){
		return hitbox;
	}
	
	public void setPV(int valeur){
		this.pv = valeur;
	}
	
	public int getPV(){
		return this.pv;
	}
	
	public void incrementerPV(int valeur){
		if (this.pv < 3){
			this.pv += valeur;
		}
		if (this.pv >3){
			this.pv =3;
		}
	}
	
	public void decrementerPV(int valeur){
		this.pv -= valeur;
	}
	
	public void spawn(int x, int y){
		
		this.position.x = x;
		this.position.y = y;
	
	}
	
	public boolean getJumping(){
		return jumping;
	}
	
	public void setJumping (boolean b){
		this.jumping = b;
	}
	 
	public void AffectWithGravity(){
		
		position.y -= 2;
	}
	
	public void updateHitbox(){
		hitbox.x = this.position.x;
		hitbox.y= this.position.y;
	}
	
	public boolean isJumping(){
		if(this.position.y >0){
			return true;
		}
		return false;
	}
	
	public void render(float delta, OrthographicCamera camera, SpriteBatch batch){
		batch.setProjectionMatrix(camera.combined);	
		actualPositionY = (int)position.y;
		if (actualPositionY != oldPositionY){
			setJumping(true);
		}
		else{
			setJumping(false);
		}
		//camera.position.set(getX(), getY(), 0);
		camera.update();
		
		
		updateHitbox();
		
		/*float tileWidth = collisionLayer.getTileWidth();
		float tileHeight = collisionLayer.getTileHeight();
		
		if (mouvement.y <0){
			
			//top left
			collisionX = collisionLayer.getCell((int)(getX()/ tileWidth),(int)((getY()+getHeight())/tileHeight))
					.getTile().getProperties().containsKey("blocked");
			
			//middle left
			if (!collisionX)collisionX = collisionLayer.getCell((int)(getX()/ tileWidth),(int)((getY()+(getHeight())/2)/tileHeight))
					.getTile().getProperties().containsKey("blocked");
			
			//bottom left
			if (!collisionX)collisionX = collisionLayer.getCell((int)(getX()/ tileWidth),(int)((getY()+getHeight())/tileHeight))
					.getTile().getProperties().containsKey("blocked");
		}
		else{
			//top right
			
			collisionX = collisionLayer.getCell((int)((getX()+getWidth())/ tileWidth),(int)((getY()+getHeight())/tileHeight))
					.getTile().getProperties().containsKey("blocked");
			
			//middle right
			
			if(!collisionX)collisionX = collisionLayer.getCell((int)((getX()+getWidth())/ tileWidth),(int)((getY()+(getHeight()/2))/tileHeight))
					.getTile().getProperties().containsKey("blocked");
			
			//bottom right
			
			if (!collisionX) collisionX = collisionLayer.getCell((int)(getX()/ tileWidth),(int)((getY()+getHeight())/tileHeight))
					.getTile().getProperties().containsKey("blocked");
			
		}
		
		if (collisionX) mouvement.x=0;
		
		
		if (mouvement.x < 0 ){
			//bottom left 
			
			collisionY = collisionLayer.getCell((int) ((getX() / tileWidth)), (int) (getY()/tileHeight))
					.getTile().getProperties().containsKey("blocked"); 
			
			//bottom middle
			
			if (!collisionY) collisionY = collisionLayer.getCell((int) ((((getX()+getWidth())/2) / tileWidth)), (int) (getY()/tileHeight))
					.getTile().getProperties().containsKey("blocked");
			
			//bottom right
			
			if (!collisionY) collisionY= collisionLayer.getCell((int) (((getX()+getWidth()) / tileWidth)), (int) ((getY()+getHeight())/tileHeight))
					.getTile().getProperties().containsKey("blocked");
			
		}
		else{
			//top left
			
			collisionY = collisionLayer.getCell((int) ((getX() / tileWidth)), (int) (getY()/tileHeight))
					.getTile().getProperties().containsKey("blocked");
			
			//top middle
			
			if (!collisionY) collisionY = collisionLayer.getCell((int) ((((getX()+getWidth())/2) / tileWidth)), (int) ((getY()+getHeight())/tileHeight))
					.getTile().getProperties().containsKey("blocked");
			
			//top right
			
			if(!collisionY) collisionY = collisionLayer.getCell((int) (((getX()+getWidth()) / tileWidth)), (int) ((getY()+getHeight())/tileHeight))
					.getTile().getProperties().containsKey("blocked");
		}
		
		if (collisionY) mouvement.y=0;
		*/
		 
		 
		 
		if (position.y <63 ){
			position.y = 63;
		}
		
		
		if (direction == 0){
				batch.draw(sprite_left,position.x ,position.y ,width, height);
				
		} else if (direction == 1){
				batch.draw(sprite_right,position.x ,position.y ,width, height);
		}
		AffectWithGravity();
		position.y -= gravity * delta;

		oldPositionY = actualPositionY;	
			
	}
}
