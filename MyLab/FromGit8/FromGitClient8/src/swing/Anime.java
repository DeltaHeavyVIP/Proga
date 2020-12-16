package swing;

import dragon.Dragon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Anime extends Canvas {
    public static Graphics2D canvas;
    static final int WINDOW_X = 1000;
    static final int WINDOW_Y = 800;
    private static ArrayList<Dragon> dragons;
    private static boolean checkflag = true;

    public void paint(Graphics g) {
            g.clearRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
            for (int i=0;i<dragons.size();i++) {
                double offset = System.currentTimeMillis() / 300.;

                switch (dragons.get(i).getColor().toString()) {
                    case "RED":
                        g.setColor(Color.RED);
                        break;
                    case "GREEN":
                        g.setColor(Color.GREEN);
                        break;
                    case "ORANGE":
                        g.setColor(Color.ORANGE);
                        break;
                    case "BROWN":
                        g.setColor(Color.BLACK);
                        break;
                    default:
                        g.setColor(Color.BLUE);
                }

                g.fillOval(dragons.get(i).getCoordinates().getX() + 200, (int) (dragons.get(i).getCoordinates().getY() + Math.sin(offset) * 10 + 200), (int) (dragons.get(i).getAge() * 3), (int) (dragons.get(i).getKiller().getHeight() * 3));
            }
            repaint();
        }

        public static JFrame getFrame(String string){
        JFrame jFrame = new JFrame(string);
        Anime anime = new Anime();
        jFrame.add(anime);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 450, dimension.height/2 - 450, 900, 900);
        jFrame.setVisible(true);
        return jFrame;
    }

    public static void setDragons(ArrayList<Dragon> dragons){Anime.dragons =dragons;}

}


