package fr.spellTeam.NeedMana.utils.world;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

import fr.spellTeam.NeedMana.Game;
import fr.spellTeam.NeedMana.entities.Tile;
import fr.spellTeam.NeedMana.entities.TileC;

public class Region{
	
	private static int nextId = 0;
	
	private int id;
	private String name;
	private int width, height;
	private OrthogonalTiledMapRenderer renderer;
	private int tileSize = 64;
	private Tile[][] tiles;
	
	public Region(String name, int width, int height){
		this.id = nextId++;
		this.name = name;
		this.width = width;
		this.height = height;
		
		this.tiles = new Tile[width][height];
		
		createWorld();
	}
	
	public void createWorld(){
		
		int i = 0;
		for (int x = 0; x < width; x++){
			for (int y = 0; y < height; y++){
				if (y == 0){
					
					Vector2 tilePos = new Vector2(x*tileSize,y*tileSize);
					tiles[x][y] = new TileC("sol", 64, tilePos);
					Game.getInstance().getGameObject().add(tiles[x][y]);

				} else {
					if (x > 6){
						if (y == 2 && i < 3){
							Vector2 tilePos = new Vector2(x*tileSize,y*tileSize);
							tiles[x][y] = new TileC("sol", 64, tilePos);
							Game.getInstance().getGameObject().add(tiles[x][y]);
							i++;
						}
						
					}
					
					
				}
			}
			
		}
		
	}
	
	public void render(float delta, OrthographicCamera camera, SpriteBatch batch){}

	public static int getNextId() {
		return nextId;
	}

	public int getId() {
		return id;
	}
	
	public Tile[][] getTiles(){
		
		return tiles;
		
	}

	public String getName() {
		return name;
	}

	public OrthogonalTiledMapRenderer getRenderer() {
		return renderer;
	}
	
	

	
	
	
} 
