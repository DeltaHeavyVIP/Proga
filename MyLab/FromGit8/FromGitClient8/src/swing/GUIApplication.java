package swing;
import account.Authorization;
import dragon.Dragon;

import javax.swing.*;
import java.awt.*;

public class GUIApplication {
    private static JFrame app;

    public void createGUI(){
        app = this.getFrame("app");
        JTabbedPane content = new JTabbedPane();
        JPanel locationPanel =new Localization().chooseLanguage();
        content.add(Localization.resourceBundle.getString("tableOfdragon.txt"),new TableWorker().createTable(Authorization.getDrugs(), Dragon.class));
        content.add(Localization.resourceBundle.getString("commands.txt"),new CommandsFromConsol().getMeThisFuckingCommand());
        content.add(Localization.resourceBundle.getString("user.txt"),new Login().plusJPanel());
        content.add(Localization.resourceBundle.getString("language.txt"),locationPanel);
        app.add(content);
    }

    public static JFrame getFrame(String string){
        JFrame jFrame = new JFrame(string);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 550, dimension.height/2 - 150, 1100, 300);
        jFrame.setVisible(true);
        return jFrame;
    }

    public static JFrame getApp(){return app;}
}