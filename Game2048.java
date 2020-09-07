package com.codegym.games.game2048;

import com.codegym.engine.cell.*;

public class Game2048 extends Game {

    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int x = 0; x < SIDE; x++)
            for (int y = 0; y < SIDE; y++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
    }

    private void createNewNumber() {
        int x;
        int y;
        int numberInCell;
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        } while (gameField[x][y] != 0);

        if (getRandomNumber(10) < 9)
            numberInCell = 2;
        else
            numberInCell = 4;
        gameField[x][y] = numberInCell;
    }

    private Color getColorByValue(int value) {
        switch(value){
            case 0: return Color.WHITE;
            case 2: return Color.BLUE;
            case 4: return Color.RED;
            case 8: return Color.GREEN;
            case 16: return Color.CYAN;
            case 32: return Color.GRAY;
            case 64: return Color.MAGENTA;
            case 128: return Color.ORANGE;
            case 256: return Color.PINK;
            case 512: return Color.YELLOW;
            case 1024: return Color.PURPLE;
            case 2048: return Color.BROWN;
            default: return Color.WHITE;}
    }

    private void setCellColoredNumber(int x, int y, int value) {
        if (value > 0) {
            setCellValueEx(x, y, getColorByValue(value), Integer.toString(value));
        } else {
            setCellValueEx(x, y, getColorByValue(value), "");
        }
    }
}
