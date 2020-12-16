package swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TableWorker  {
    private static String[] columns;
    private static JTable dragons;
    private  String dragonsFromServer;
    private static ArrayList<String> id = new ArrayList<>();

    public static JPanel
    createTable(String dragonsFromServer, Class clazz){
        columns = new String[]{Localization.resourceBundle.getString("id.txt"), Localization.resourceBundle.getString("name.txt"), Localization.resourceBundle.getString("coordinatesx.txt"),Localization.resourceBundle.getString("coordinatesy.txt"),
                Localization.resourceBundle.getString("age.txt"), Localization.resourceBundle.getString("color.txt"), Localization.resourceBundle.getString("type.txt"), Localization.resourceBundle.getString("character.txt"), Localization.resourceBundle.getString("namekiller.txt")
                ,Localization.resourceBundle.getString("year.txt"), Localization.resourceBundle.getString("month.txt"),Localization.resourceBundle.getString("day.txt"),Localization.resourceBundle.getString("height.txt"),Localization.resourceBundle.getString("passport.txt"),
                Localization.resourceBundle.getString("townx.txt"), Localization.resourceBundle.getString("towny.txt"),Localization.resourceBundle.getString("townz.txt"),Localization.resourceBundle.getString("townname.txt")};
        JPanel panel = new JPanel();
        panel.setSize(1000,100);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        String[] stringDragons = dragonsFromServer.split("\\|");
        for(int i=0;i<stringDragons.length;i++){
            String stringDragon = stringDragons[i];
            String[] segmentsDragon = stringDragon.split("\\+");
            model.addRow(segmentsDragon);
            id.add(stringDragon);

        }
        dragons = new JTable(model);


        dragons.setPreferredScrollableViewportSize(new Dimension(1000,100));

        for(int index = 0; index < columns.length; index++){
            dragons.getColumnModel().getColumn(index).setMinWidth(40);// two lines of code less
        }

        dragons.setAutoCreateRowSorter(true);
        dragons.setRowHeight(20);
        JScrollPane jScrollPane = new JScrollPane(dragons, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(jScrollPane);


        return panel;
    }
    public static JTable updateTable(String dragonsFromServer){
        String[] stringDragons = dragonsFromServer.split("\\|");
        DefaultTableModel tableModel = (DefaultTableModel) dragons.getModel();
        int rowCount = tableModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        for(int i=0;i<stringDragons.length;i++){
            String stringDragon = stringDragons[i];
            String[] segmentsDragon = stringDragon.split("\\+");
            tableModel.addRow(segmentsDragon);

        }
        dragons.revalidate();
        dragons.repaint();
        return dragons;
    }

    public static JTable removeTable(){
        DefaultTableModel tableModel = (DefaultTableModel) dragons.getModel();
        int rowCount = tableModel.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        dragons.revalidate();
        dragons.repaint();
        return dragons;
    }

    public static ArrayList<String> getDragons(){
        return id;
    }

}