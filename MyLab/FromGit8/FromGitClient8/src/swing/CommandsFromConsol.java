package swing;

import javax.swing.*;
import java.awt.*;

public class CommandsFromConsol extends JPanel {
    private static String command;
    private static boolean flagready;
    private int i = 0;
    public static boolean flagOfClose = true;

    public synchronized JPanel getMeThisFuckingCommand() {

        command = "";
        flagready = true;

        JPanel jPanel = new JPanel(new GridLayout(5,5,20,20));

        JButton jButton_help = new JButton("help");
        JButton jButton_info = new JButton("info");
        JButton jButton_show = new JButton("show");
        JButton jButton_add = new JButton("add");
        JButton jButton_update = new JButton("update");
        JButton jButton_remove_by_id = new JButton("remove_by_id");
        JButton jButton_clear = new JButton("clear");
        JButton jButton_save = new JButton("save");
        JButton jButton_execute_script = new JButton("execute_script");
        JButton jButton_exit = new JButton("exit");
        JButton jButton_add_if_max = new JButton("add_if_max");
        JButton jButton_reorder = new JButton("reorder");
        JButton jButton_sum_of_age = new JButton("sum_of_age");
        JButton jButton_filter_contains_name = new JButton("filter_contains_name");
        JButton jButtonp_rint_field_descending_type = new JButton("print_field_descending_type");
        JButton paint = new JButton("Paint");

        jPanel.add(jButton_help);
        jPanel.add(jButton_info);
        jPanel.add(jButton_show);
        jPanel.add(jButton_add);
        jPanel.add(jButton_update);
        jPanel.add(jButton_remove_by_id);
        jPanel.add(jButton_clear);
        jPanel.add(jButton_save);
        jPanel.add(jButton_execute_script);
        jPanel.add(jButton_exit);
        jPanel.add(jButton_add_if_max);
        jPanel.add(jButton_reorder);
        jPanel.add(jButton_sum_of_age);
        jPanel.add(jButton_filter_contains_name);
        jPanel.add(jButtonp_rint_field_descending_type);
        jPanel.add(paint);

        jPanel.setVisible(true);

        paint.addActionListener(e->{
            Anime.getFrame("Аниме");
        });
        jButton_help.addActionListener(e -> {
            command = "help";
            flagready = false;
        });
        jButton_info.addActionListener(e -> {
            command = "info";
            flagready = false;
        });
        jButton_show.addActionListener(e -> {
            command = "show";
            flagready = false;
        });
        jButton_add.addActionListener(e -> {
            command = "add";
            flagready = false;
        });
        jButton_update.addActionListener(e -> {
            JFrame frame = getFrameForThis(Localization.resourceBundle.getString("updateid.txt"));
            JPanel panel = new JPanel();
            JLabel text = new JLabel(Localization.resourceBundle.getString("enterid.txt"));
            text.setBounds(5, 5, 250, 30);
            JTextField textField = new JTextField(10);
            textField.setBounds(225, 5, 200, 30);
            panel.add(text);
            panel.add(textField);
            frame.add(panel);
            textField.addActionListener(e1 ->{
                command = "update " + textField.getText();
                flagready = false;
                frame.dispose();});
        });
        jButton_remove_by_id.addActionListener(e -> {
            JFrame frame = getFrameForThis(Localization.resourceBundle.getString("dragonremoval.txt"));
            JPanel panel = new JPanel();
            JLabel text = new JLabel(Localization.resourceBundle.getString("enterid.txt"));
            text.setBounds(5, 5, 250, 30);
            JTextField textField = new JTextField(10);
            textField.setBounds(225, 5, 200, 30);
            panel.add(text);
            panel.add(textField);
            frame.add(panel);
            textField.addActionListener(e1 ->{
                command = "remove_by_id " + textField.getText();
                flagready = false;
                frame.dispose();});
        });
        jButton_clear.addActionListener(e -> {
            command = "clear";
            flagready = false;
        });
        jButton_save.addActionListener(e -> {
            command = "save";
            flagready = false;
        });
        jButton_execute_script.addActionListener(e -> {
            command = "execute_script";
            JFrame frame = getFrameForThis(Localization.resourceBundle.getString("customerinteraction.txt"));
            JPanel panel = new JPanel();
            JLabel text = new JLabel(Localization.resourceBundle.getString("enterthefilename.txt"));
            text.setBounds(5, 5, 250, 30);
            JTextField textField = new JTextField(10);
            textField.setBounds(225, 5, 200, 30);
            panel.add(text);
            panel.add(textField);
            frame.add(panel);
            textField.addActionListener(e1 ->{
                command = "execute_script " + textField.getText();
                flagready = false;
                frame.dispose();});
        });
        jButton_exit.addActionListener(e -> {
            command = "exit";
            flagready = false;
        });
        jButton_add_if_max.addActionListener(e -> {
            command = "add_if_max";
            //doThis();
            flagready = false;
        });
        jButton_reorder.addActionListener(e -> {
            command = "reorder";
            flagready = false;
        });
        jButton_sum_of_age.addActionListener(e -> {
            command = "sum_of_age";
            flagready = false;
        });
        jButton_filter_contains_name.addActionListener(e -> {
            JFrame frame = getFrameForThis(Localization.resourceBundle.getString("enterpartsofthename.txt"));
            JPanel panel = new JPanel();
            JLabel text = new JLabel(Localization.resourceBundle.getString("enterasubstring.txt"));
            text.setBounds(5, 5, 250, 30);
            JTextField textField = new JTextField(10);
            textField.setBounds(225, 5, 200, 30);
            panel.add(text);
            panel.add(textField);
            frame.add(panel);
            textField.addActionListener(e1 ->{
                command = "filter_contains_name " + textField.getText();
                flagready = false;
                frame.dispose();});
        });
        jButtonp_rint_field_descending_type.addActionListener(e -> {
            command = "print_field_descending_type";
            // doThis();
            flagready = false;
        });

        return jPanel;
    }

    public String getCommand(){
        while (flagready) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flagready = true;
        return command;
    }

    static synchronized JFrame getFrameForThis(String string) {
        JFrame jFrame = new JFrame(string);
        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 75, 450, 75);
        jFrame.setVisible(true);
        return jFrame;
    }

}