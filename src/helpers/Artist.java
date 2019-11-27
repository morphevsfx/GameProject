/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import data.Boot;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.glEnd;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author Morpheus
 */
public class Artist {
    public static final int WIDTH = 1280, HEIGHT = 960;
    
    /**
     * Function BeginSession. Set up and create initial display.
     */
    public static void BeginSession() {
        // Display.setTitle("GameProject");
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(Boot.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // init OpenGL
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }
    
    /**
     * Function DrawQuad
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public static void DrawQuad(float x, float y,float width, float height) {
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x, y); // Top left corner
        GL11.glVertex2f(x + width, y); // Top right corner
        GL11.glVertex2f(x + height, y + height); // Bottom right corner
        GL11.glVertex2f(x, y + height); // Bottom left corner
        glEnd();
    }
    
    /**
     * Function DrawQuadTex
     * @param tex
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public static void DrawQuadTex(Texture tex, float x, float y, float width, float height) {
        tex.bind();
        GL11.glTranslatef(x, y, 0);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(0, 0);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(width, 0);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(width, height);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(0, height);
        glEnd();
        GL11.glLoadIdentity();
    }
    
    /**
     * Function LoadTexture (load texture from file)
     * @param path
     * @param fileType
     * @return texture
     */
    public static Texture LoadTexture(String path, String fileType) {
        Texture tex = null;
        InputStream in = ResourceLoader.getResourceAsStream(path);
        try {
            tex = TextureLoader.getTexture(fileType, in);
        } catch (IOException ex) {
            Logger.getLogger(Boot.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return tex;
    }
     
    public static Texture QuickLoad(String name) {
        Texture tex = null;
        tex = LoadTexture("res/" + name + ".png", "PNG");
        return tex;
    }
}
