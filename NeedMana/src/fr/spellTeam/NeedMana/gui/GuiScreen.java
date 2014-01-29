package fr.spellTeam.NeedMana.gui;

import com.badlogic.gdx.Screen;

public abstract class GuiScreen implements Screen{

	
	public static final GuiInGame GUI_INGAME = new GuiInGame("main");
	
	public static final GuiMenu GUI_MENU = new GuiMenu();
	
	protected String name;
	
	protected GuiScreen(String name){
		this.name = name;
	}
	
	public abstract void render(float delta);

	public abstract void resize(int width, int height);

	public abstract void show();

	public abstract void hide();

	public abstract void pause();

	public abstract void resume();

	public abstract void dispose();
	
	public String getName(){
		return name;
	}

}
