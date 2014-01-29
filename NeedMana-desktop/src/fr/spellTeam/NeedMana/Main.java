package fr.spellTeam.NeedMana;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		new LwjglApplication(new Game(), cfg);
		cfg.title = Game.NAME+" "+ Game.VERSION;
		cfg.useGL20 = Game.needsOpenGL20();
		cfg.width = Game.WIDTH;
		cfg.height = Game.HEIGTH;
	}
}
