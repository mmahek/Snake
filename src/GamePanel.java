//import javax.swing.*;
//import java.awt.Color;
//import java.awt.*;
//import java.util.Random;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//public class GamePanel extends JPanel implements ActionListener{
//    static final int SCREEN_WIDTH= 600;
//    static final int SCREEN_HEIGHT= 600;
//    static final int UNIT_SIZE = 40;
//    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
//    static final int DELAY = 75;
//    final int x[] = new int[GAME_UNITS]; //  holds x coordinates
//    final int y[] = new int[GAME_UNITS]; //  holds x coordinates
//    int bodyParts = 6;
//    int applesEaten = 0;
//    int appleX;
//    int appleY;
//    char direction = 'R';
//    boolean running = false;
//    Timer timer;
//    Random random;
//    GamePanel(){
//        random = new Random();
//        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
//        this.setBackground(Color.black);
//        this.setFocusable(true);
//        this.addKeyListener(new MyKeyAdapter());
//        startGame();
//    }
//    public void startGame(){
//        newApple();
//        running = true;
//        timer = new Timer(DELAY, this);
//        timer.start();
//    }
//    public void paintComponent(Graphics g){
//        super.paintComponent(g);
//        draw(g);
//    }
//    public void draw(Graphics g){
//        if(running) {
//            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) { // grid
//                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
//                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
//            }
//            // draws the apple
//            g.setColor(Color.red);
//            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
//
//            for (int i = 0; i < bodyParts; i++) { // making the snake
//                if (i == 0) { // dealing with the head of snake
//                    g.setColor(Color.cyan);
//                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
//                } else { //dealing with the body
//                    g.setColor(new Color(15, 150, 240));
//                    g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
//                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
//                }
//            }
//            g.setColor(Color.red);
//            g.setFont(new Font("Ink Free",Font.BOLD, 40));
//            FontMetrics metrics = getFontMetrics(g.getFont());
//            g.drawString("Score: "+ applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+ applesEaten))/2,  g.getFont().getSize());
//
//        }
//        else{
//            gameOver(g);
//        }
//    }
//    public void newApple(){
//        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
//        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
//    }
//    public void move(){
//        for(int i = bodyParts ; i > 0 ; i--){
//            x[i] = x[i-1];//shifting coordinates by 1
//            y[i] = y[i-1];
//        }
//        switch(direction){
//            case 'U':
//                y[0] = y[0] - UNIT_SIZE;//shifts to next position
//                break;
//            case 'D':
//                y[0] = y[0] + UNIT_SIZE;//shifts to next position
//                break;
//            case 'L':
//                x[0] = x[0] - UNIT_SIZE;//shifts to next position
//                break;
//            case 'R':
//                x[0] = x[0] + UNIT_SIZE;//shifts to next position
//                break;
//        }
//    }
//    public void checkApple(){
//        if((x[0] == appleX) && (y[0] == appleY)){
//            bodyParts++;
//            applesEaten++;
//            newApple();
//        }
//    }
//    public void checkCollisions(){
//        // checks if head collides with body
//        for(int i = bodyParts ; i > 0 ; i--){
//            if((x[0] == x[i]) && y[0] == y[i]){
//                running = false;
//            }
//        }
//        // checks if head touches left border
//        if(x[0] < 0 ){
//            running = false;
//        }
//        // checks if head touches right border
//        if(x[0] > SCREEN_WIDTH){
//            running = false;
//        }
//        //checks if head touches top border
//        if(y[0] < 0){
//            running = false;
//        }
//        // checks if head touches bottom border
//        if(y[0] > SCREEN_HEIGHT ){
//            running = false;
//        }
//        if(!running){
//            timer.stop();
//        }
//    }
//    public void gameOver(Graphics g){
//        // Score
//        g.setColor(Color.red);
//        g.setFont(new Font("Ink Free",Font.BOLD, 40));
//        FontMetrics metrics1 = getFontMetrics(g.getFont());
//        g.drawString("Score: "+ applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+ applesEaten))/2,  g.getFont().getSize());
//
//        // GameOver Text
//        g.setColor(Color.red);
//        g.setFont(new Font("Ink Free",Font.BOLD, 75));
//        FontMetrics metrics2 = getFontMetrics(g.getFont());
//        g.drawString("GAME OVER", (SCREEN_WIDTH - metrics2.stringWidth("GAME OVER"))/2,  SCREEN_HEIGHT/2);
//    }
//    @Override
//    public void actionPerformed(ActionEvent e){
//        if (running) {
//
//            move();
//            checkApple();
//            checkCollisions();
//        }
//        repaint();
//    }
//    public class MyKeyAdapter extends KeyAdapter{
//        @Override
//        public void keyPressed(KeyEvent e){
//            switch(e.getKeyCode()){
//                case KeyEvent.VK_LEFT :
//                    if(direction != 'R'){
//                        direction = 'L';
//                    }
//                    break;
//                case KeyEvent.VK_RIGHT:
//                    if(direction != 'L'){
//                        direction = 'R';
//                    }
//                    break;
//                case KeyEvent.VK_UP :
//                    if(direction != 'D'){
//                        direction = 'U';
//                    }
//                    break;
//                case KeyEvent.VK_DOWN:
//                    if(direction != 'U'){
//                        direction = 'D';
//                    }
//                    break;
//            }
//        }
//    }
//}

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 40;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    final int[] snakeX = new int[GAME_UNITS]; // holds x coordinates
    final int[] snakeY = new int[GAME_UNITS]; // holds y coordinates
    int bodyParts = 6;
    int applesEaten = 0;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;

    public GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (running) {
            draw(g);
        } else {
            gameOver(g);
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) { // grid
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
        // draws the apple
        g.setColor(Color.red);
        g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

        for (int i = 0; i < bodyParts; i++) { // making the snake
            if (i == 0) { // dealing with the head of snake
                g.setColor(Color.cyan);
            } else { // dealing with the body
                g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            }
            g.fillRect(snakeX[i], snakeY[i], UNIT_SIZE, UNIT_SIZE);
        }

        // Score
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
                g.getFont().getSize());
    }

    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }

    public void move() {
        for (int i = bodyParts; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];// shifting coordinates by 1
            snakeY[i] = snakeY[i - 1];
        }
        switch (direction) {
            case 'U':
                snakeY[0] = snakeY[0] - UNIT_SIZE;// shifts to next position
                break;
            case 'D':
                snakeY[0] = snakeY[0] + UNIT_SIZE;// shifts to next position
                break;
            case 'L':
                snakeX[0] = snakeX[0] - UNIT_SIZE;// shifts to next position
                break;
            case 'R':
                snakeX[0] = snakeX[0] + UNIT_SIZE;// shifts to next position
                break;
        }
    }

    public void checkApple() {
        if ((snakeX[0] == appleX) && (snakeY[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
    }

    public void checkCollisions() {
        // checks if head touches left border
        if (snakeX[0] < 0 || snakeX[0] >= SCREEN_WIDTH || snakeY[0] < 0 || snakeY[0] >= SCREEN_HEIGHT) {
            running = false;
        }
        // checks if head collides with body
        for (int i = bodyParts; i > 0; i--) {
            if ((snakeX[0] == snakeX[i]) && snakeY[0] == snakeY[i]) {
                running = false;
            }
        }
    }

    public void gameOver(Graphics g) {
        // Score
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten)) / 2,
                g.getFont().getSize());

        // Game Over Text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - metrics2.stringWidth("GAME OVER")) / 2, SCREEN_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
