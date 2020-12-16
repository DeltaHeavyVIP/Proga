package swing;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {
    public static ResourceBundle resourceBundle;

    public JPanel chooseLanguage(){

        resourceBundle = ResourceBundle.getBundle("resources/locals", Locale.forLanguageTag("ru"));
        JPanel panel = new JPanel(new GridLayout(2,2,20,20));
        JButton russian_button = new JButton("Russian");
        JButton portugalian_button = new JButton("Portugalian");
        JButton spanish_button = new JButton("Spanish");
        JButton xorvation_Button = new JButton("Croatian");
        panel.add(russian_button);
        panel.add(portugalian_button);
        panel.add(spanish_button);
        panel.add(xorvation_Button);

        panel.setVisible(true);


        russian_button.addActionListener(e ->{
            resourceBundle = ResourceBundle.getBundle("resources/locals", Locale.forLanguageTag("ru"));
        });
        portugalian_button.addActionListener(e ->{
            resourceBundle = ResourceBundle.getBundle("resources/locals", Locale.forLanguageTag("pt"));
        });
        spanish_button.addActionListener(e ->{
            resourceBundle = ResourceBundle.getBundle("resources/locals", Locale.forLanguageTag("es"));
        });
        xorvation_Button.addActionListener(e->{
            resourceBundle = ResourceBundle.getBundle("resources/locals", Locale.forLanguageTag("hr"));
        });

        return panel;
    }

}