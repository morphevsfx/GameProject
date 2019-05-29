/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.lwjgl.opengl.Display;
import static helpers.Artist.*;
import org.lwjgl.Sys;

/**
 * Game project learning java coding.
 * @author Morpheus
 */
public class Boot {
    
    public Boot() {
        
        // Start OpenGL session
        BeginSession();
        
        TileGrid grid = new TileGrid();
        while (!Display.isCloseRequested()) {
            
            grid.Draw();
            
            
            // Set fps_max
            
            Display.update();
            UpdateFPS();   // Show fps counter
            Display.sync(60);
                    
        }
        
        Display.destroy();
    }
    
    /**
     * Get the accurate system time
     * 
     * @return The system time in milliseconds
     */
    public long getTime() {
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    /**
     * Calculate the FPS and set it in the title bar
     */
    public final void UpdateFPS() {
        /** frames per second */
        int fps = 0;
         /** last fps time */
        long lastFPS = 0;
        if (getTime() - lastFPS > 1000) {
            Display.setTitle("GameProject | FPS: " + fps);
            fps = 0; // Reset the FPS counter
            lastFPS += 1000;
        }
        fps++;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Boot boot = new Boot();
    }
    
}
