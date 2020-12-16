package swing;

import account.ExistQuestion;

import javax.swing.*;
import java.awt.*;

public class InformationFromConsol extends JFrame{
    private static boolean buttonaccount;
    private static String log = null;
    private static String password = null;
    private static boolean flagready ;

    public static void write() {

        flagready = true;
        buttonaccount = false;
        JFrame jFrame = getFrame("Вход в приложение");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        JButton buttonYes = new JButton("Yes");
        buttonYes.setBounds(330,45,85,30);
        JButton buttonNo = new JButton("No");
        buttonNo.setBounds(167,45,85,30);
        JLabel jLabelaccount = new JLabel("Есть ли у вас учетная запись?");
        jLabelaccount.setBounds(200,5,250,30);
        String text = ExistQuestion.getText();
        JLabel jLabeltext = new JLabel(text);
        jLabeltext.setBounds(220,80,250,30);
        jPanel.add(jLabeltext);
        jPanel.add(jLabelaccount);
        jPanel.add(buttonYes);
        jPanel.add(buttonNo);
        jFrame.add(jPanel, BorderLayout.CENTER);

        buttonNo.addActionListener(e -> {
            JLabel jLabel = new JLabel("Введите логин:");
            jLabel.setBounds(0,0,125,30);
            JTextField jTextField = new JTextField(20);
            jTextField.setBounds(125,0,200,30);
            JLabel jLabel1 = new JLabel("Введите пароль:");
            jLabel1.setBounds(0,35,125,30);
            JPasswordField jPasswordField = new JPasswordField(20);
            jPasswordField.setBounds(125,35,200,30);
            JButton logbutton = new JButton("Ok");
            logbutton.setBounds(0,70,75,30);
            jPanel.add(logbutton);
            jPanel.add(jLabel);
            jPanel.add(jTextField);
            jPanel.add(jLabel1);
            jPanel.add(jPasswordField);
            jPanel.remove(buttonYes);
            jPanel.remove(buttonNo);
            jPanel.remove(jLabelaccount);
            jPanel.remove(jLabeltext);
            jPanel.revalidate();
            jPanel.repaint();
            logbutton.addActionListener(e1 -> {
                log = jTextField.getText();
                password = String.valueOf(jPasswordField.getPassword());
                flagready =false;
            });
        });

        buttonYes.addActionListener(e -> {
            buttonaccount = true;
            JLabel jLabel = new JLabel("Введите логин:");
            jLabel.setBounds(0,0,125,30);
            JTextField jTextField = new JTextField(20);
            jTextField.setBounds(125,0,200,30);
            JLabel jLabel1 = new JLabel("Введите пароль:");
            jLabel1.setBounds(0,35,125,30);
            JPasswordField jPasswordField = new JPasswordField(20);
            jPasswordField.setBounds(125,35,200,30);
            JButton logbutton = new JButton("Ok");
            logbutton.setBounds(0,70,75,30);
            jPanel.add(logbutton);
            jPanel.add(jLabel);
            jPanel.add(jTextField);
            jPanel.add(jLabel1);
            jPanel.add(jPasswordField);
            jPanel.remove(buttonYes);
            jPanel.remove(buttonNo);
            jPanel.remove(jLabelaccount);
            jPanel.remove(jLabeltext);
            jPanel.revalidate();
            jPanel.repaint();
            logbutton.addActionListener(e1 -> {
                log = jTextField.getText();
                password = String.valueOf(jPasswordField.getPassword());
                flagready =false;
            });
        });

        while (flagready){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        jFrame.dispose();


    }

    public static JFrame getFrame(String string){
        JFrame jFrame = new JFrame(string);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2 - 200, dimension.height/2 - 200, 600, 150);
        jFrame.setVisible(true);
        return jFrame;
    }

    public static boolean getButtonAccount(){return buttonaccount;}
    public static String getLog(){return log;}
    public static String getPassword(){return password;}

}