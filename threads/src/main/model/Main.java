package main.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {
    private int FRAME_HEIGHT = 500;
    private int FRAME_WIDTH = 500;
    private Level level;
    private final int IMAGE_SIZE = 20;
    private JPanel panel;
    boolean isPressedMouse = false;
    boolean isChosenKnot = false;
    int numOfChosenKnot = -1;

    public static void main(String[] args) {

        new Main().setVisible(true);
    }

    private Main(){
        level = new Level();
        level.buildBall();
        Game game = new Game(level);
        setImages();
        InitPanel();
        InitFrame();
    }

    private void InitPanel(){

        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                for(int i = 0; i < level.ball.getThreads().size();i++){
                    g.drawLine( (int) level.ball.getThreads().get(i).getBegin().getPosition().getX()*IMAGE_SIZE+IMAGE_SIZE/2,
                            (int) level.ball.getThreads().get(i).getBegin().getPosition().getY()*IMAGE_SIZE+IMAGE_SIZE/2,
                            (int) level.ball.getThreads().get(i).getEnd().getPosition().getX()*IMAGE_SIZE+IMAGE_SIZE/2,
                            (int) level.ball.getThreads().get(i).getEnd().getPosition().getY()*IMAGE_SIZE+IMAGE_SIZE/2);
                }

                for(int i = 0; i < level.ball.getKnots().size(); i++ ) {
                    g.drawImage((Image) level.ball.getKnots().get(i).image, level.ball.getKnots().get(i).getPosition().x * IMAGE_SIZE, level.ball.getKnots().get(i).getPosition().y * IMAGE_SIZE, this);
                }


            }
        };

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               // System.out.println("Мышь зажата");
                isPressedMouse = true;
                panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                for(int i = 0; i < level.ball.getKnots().size(); i++){
                    if(level.ball.getKnots().get(i).getPosition().getX() == e.getX()/IMAGE_SIZE
                            && level.ball.getKnots().get(i).getPosition().getY() == e.getY()/IMAGE_SIZE){
                        numOfChosenKnot = i;
                        isChosenKnot = true;
                    }
                }
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Knot currentKnot = level.ball.getKnots().get(numOfChosenKnot);
                currentKnot.fireKnotMoved();
                int x = currentKnot.getPosition().x;
                int y = currentKnot.getPosition().y;
                if(isPressedMouse){
                    if(isChosenKnot){
                        if(e.getX() < FRAME_WIDTH && e.getY() < FRAME_HEIGHT && e.getY() > 0 && e.getX() > 0){
                            Point newPosition = new Point(e.getX()/IMAGE_SIZE,e.getY()/IMAGE_SIZE);
                            currentKnot.move(newPosition);
                        }
                    }
                }
                panel.repaint();
            }
        });

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                panel.setCursor(Cursor.getDefaultCursor());
                level.ball.getKnots().get(numOfChosenKnot).fireKnotReleased();
                isPressedMouse = false;
                numOfChosenKnot = -1;
                isChosenKnot = false;
                panel.repaint();

            }
        });

        panel.setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        add(panel);
    }

    private void InitFrame(){
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE );
        setTitle("Запутанная схема");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void  setImages(){
        for (int i = 0; i < level.ball.getKnots().size(); i++){

            if (level.ball.getKnots().get(i) instanceof DistanceKnot){
                System.out.println("!!!!!!!!!!!!!!");
                level.ball.getKnots().get(i).setImage(getImage("/knotd.png"));
            } else {
                level.ball.getKnots().get(i).setImage(getImage("/knot2.png"));
            }
        }
    }

    private Image getImage(String name){
        ImageIcon icon = new ImageIcon(getClass().getResource(name));
        return icon.getImage();
    }
}
