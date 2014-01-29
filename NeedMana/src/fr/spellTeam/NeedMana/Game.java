package fr.spellTeam.NeedMana;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import fr.spellTeam.NeedMana.entities.EntityPlayer;
import fr.spellTeam.NeedMana.entities.GameObject;
import fr.spellTeam.NeedMana.gui.GuiInGame;
import fr.spellTeam.NeedMana.gui.GuiLevels;
import fr.spellTeam.NeedMana.gui.GuiMenu;
import fr.spellTeam.NeedMana.gui.GuiSelectSpell;
import fr.spellTeam.NeedMana.utils.KeyListener;
import fr.spellTeam.NeedMana.utils.world.Region;

public class Game extends com.badlogic.gdx.Game{
	
	public static final String NAME = "NeedMana";
	public static final String VERSION = "0.0.1";
	public static final int SCALE = 2;
	public static final int WIDTH = 600 * SCALE;
	public static final int HEIGTH = WIDTH /2;
	
	private static Game instance;
	private KeyListener keyListener;
	private static Region region;
	
	public Game(){
		instance = this;
	}
	

	
	//gameobjects
	private Array<GameObject> gameObject = new Array<GameObject>();
	private EntityPlayer player;

	public void create() {
		keyListener = new KeyListener();
		Gdx.input.setInputProcessor(keyListener);
		
		super.setScreen(new GuiMenu());
		player = new EntityPlayer("Bob", 40, 40);
		gameObject.add(player);
		/*guiIg = GuiInGame.GUI_INGAME;
		
		super.setScreen(guiIg);
		player = new EntityPlayer("Player", 64, 64);
		mob = new EntityMob("mob", 64, 64);
		
		gameObject.add(mob);
		gameObject.add(player);
		
		
		region = new Region("main");*/
	}

	@Override
	
	public void resize(int width, int height) {
		super.resize(width,  height);
	}
	@Override
	public void render() {	
		keyListener.tick();
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
	
	public Array<GameObject> getGameObject(){
		
		return gameObject;
		
	}
	
	public void addGameObject(GameObject go){
		
		gameObject.add(go);
		
	}
	
	public EntityPlayer getPlayer(){
		
		return player;
		
	}
	
	public static Game getInstance(){
		
		return instance;
	}
	
	public void quit(){
		
		Gdx.app.exit();
	}
	
	public static boolean needsOpenGL20(){
		
		return true;
		
	}
	
	public static void appelerGuiLevels(){
		((Game) Gdx.app.getApplicationListener()).setScreen(new GuiLevels());
	}
	
	public static void appelerGuiMenu(){
		((Game) Gdx.app.getApplicationListener()).setScreen(new GuiMenu());
	}
	
	public static void appelerGuiInGame(){
		((Game) Gdx.app.getApplicationListener()).setScreen(new GuiInGame("main"));
		region = new Region("main", 300, 300);
		// comme il faut une region, je l'ai mise en dure mais en gros le principe est que
		// a chaque fois qu'on lancera un monde il faudrat que ce monde soit stocké la dedans.

	}
	
	public static void appelerGuiSpell(){
		((Game) Gdx.app.getApplicationListener()).setScreen(new GuiSelectSpell());
	}
	
	public Region getCurrentRegion(){
		return region;
		
	}
}
