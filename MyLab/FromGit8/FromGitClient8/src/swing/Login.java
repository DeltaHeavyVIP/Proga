package swing;

import account.ExistQuestion;

import javax.swing.*;

public class Login {

    public synchronized JPanel plusJPanel(){
        JPanel jPanel = new JPanel();
        String user = ExistQuestion.getLog();

        JLabel jLabellogin = new JLabel(Localization.resourceBundle.getString("user.txt"));
        jLabellogin.setBounds(0, 0, 90, 30);
        JLabel jLabeluser = new JLabel(user);
        jLabeluser.setBounds(95,0,300,30);

        jPanel.add(jLabellogin);
        jPanel.add(jLabeluser);

        jPanel.setVisible(true);
        return jPanel;
    }
}
