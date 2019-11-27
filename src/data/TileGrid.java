/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static helpers.Artist.DrawQuadTex;

/**
 *
 * @author Morpheus
 */
public class TileGrid {
    
    public Tile[][] map;
    
    public TileGrid() {
        map = new Tile[20][15];
        for (int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
            }
        }
    }
    
    public TileGrid(int [][] newMap) {
        map = new Tile[20][15];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                 switch (newMap[j][i]) {
                        case 0:
                            map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Grass);
                            break;
                        case 1:
                            map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Dirt);
                            break;
                        case 2:
                            map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.Water);
                            break;
                }
                    
            }
        }
    }
    
    public void SetTile(int xCoord, int yCoord, TileType type) {
        map[xCoord][yCoord] = new Tile(xCoord * 64, yCoord * 64, 64, 64, type);
    }
    
    public Tile GetTile(int xCoord, int yCoord) {
        return map[xCoord][yCoord];
    }
    
    public void Draw() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++){
                Tile t = map[i][j];
                DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
            }
        }
    }

    void SetTile(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
