package dragon;

import person.Location;
import person.Person;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;

public class DragonBuilder implements Serializable {
    private String nameplus;
    private Long ageplus;
    private Color colorplus;
    private DragonType dragonTypeplus;
    private DragonCharacter dragonCharacterplus;
    private int xplus;
    private Float yplus;
    private String nameKillerPlus;
    private int year;
    private int month;
    private int day;
    private Float height;
    private Double xtown;
    private float ytown;
    private Integer ztown;
    private String nametown;
    private String passportID;

    private String nameplusa;
    private String ageplusa;
    private String xplusa;
    private String yplusa;
    private String nameKillerPlusa;
    private String yeara;
    private String montha;
    private String daya;
    private String heighta;
    private String xtowna;
    private String ytowna;
    private String ztowna;
    private String nametowna;
    private String passportIDa;

    private boolean dragonName;
    private boolean dragonAge;
    private boolean colorplusbol;
    private boolean dragonTypeplusbol;
    private boolean dragonCharacterplusbol;
    private boolean dragonX;
    private boolean dragonY;
    private boolean dragonPersonName;
    private boolean dragonPersonYear;
    private boolean dragonPersonMonth;
    private boolean dragonPersonDay;
    private boolean dragonHeight;
    private boolean dragonPassport;
    private boolean dragonTownX;
    private boolean dragonTownY;
    private boolean dragonTownZ;
    private boolean dragonTownName;

    public Dragon plusDragon() {

        String regex = "[0-9]+";
        Dragon dragonplus = null;
        dragonName = true;
        dragonAge = true;
        dragonX = true;
        dragonY = true;
        dragonPersonName = true;
        dragonPersonYear = true;
        dragonPersonMonth = true;
        dragonPersonDay = true;
        dragonHeight = true;
        dragonPassport = true;
        dragonTownX = true;
        dragonTownY = true;
        dragonTownZ = true;
        dragonTownName = true;

        JFrame jFrame = getFrame("Вход в приложение");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        JLabel jLabelName = new JLabel("Имя дракона: ");
        jLabelName.setBounds(5,5,200,30);
        jPanel.add(jLabelName);
        JTextField jTextFieldName = new JTextField(20);
        jTextFieldName.setBounds(200,5,200,30);
        jPanel.add(jTextFieldName);

        JLabel jLabelAge = new JLabel("Возраст дракона: ");
        jLabelAge.setBounds(5,40,200,30);
        jPanel.add(jLabelAge);
        JTextField jTextFieldAge = new JTextField(20);
        jTextFieldAge.setBounds(200,40,200,30);
        jPanel.add(jTextFieldAge);

        JLabel jLabelColor = new JLabel("Выберите цвет дракона: ");
        jLabelColor.setBounds(5,75,200,30);
        jPanel.add(jLabelColor);
        JToggleButton jButtonGREEN = new JToggleButton("GREEN");
        jButtonGREEN.setBounds(200,75,80,30);
        jPanel.add(jButtonGREEN);
        jButtonGREEN.addActionListener(e ->{colorplus = Color.GREEN;colorplusbol = false;});
        JToggleButton jButtonRED = new JToggleButton("RED");
        jButtonRED.setBounds(285,75,80,30);
        jPanel.add(jButtonRED);
        jButtonRED.addActionListener(e ->{colorplus = Color.RED;colorplusbol = false;});
        JToggleButton jButtonORANGE = new JToggleButton("ORANGE");
        jButtonORANGE.setBounds(370,75,90,30);
        jPanel.add(jButtonORANGE);
        jButtonORANGE.addActionListener(e ->{colorplus = Color.ORANGE;colorplusbol = false;});
        JToggleButton jButtonBROWN = new JToggleButton("BROWN");
        jButtonBROWN.setBounds(465,75,90,30);
        jPanel.add(jButtonBROWN);
        jButtonBROWN.addActionListener(e ->{colorplus = Color.BROWN;colorplusbol = false;});

        JLabel jLabelType = new JLabel("Выберите тип дракона: ");
        jLabelType.setBounds(5,110,200,30);
        jPanel.add(jLabelType);
        JToggleButton jButtonWATER = new JToggleButton("WATER");
        jButtonWATER.setBounds(200,110,80,30);
        jPanel.add(jButtonWATER);
        jButtonWATER.addActionListener(e ->{dragonTypeplus = DragonType.WATER;dragonTypeplusbol = false;});
        JToggleButton jButtonUNDERGROUND = new JToggleButton("UNDERGROUND");
        jButtonUNDERGROUND.setBounds(285,110,140,30);
        jPanel.add(jButtonUNDERGROUND);
        jButtonUNDERGROUND.addActionListener(e ->{dragonTypeplus = DragonType.UNDERGROUND;dragonTypeplusbol = false;});
        JToggleButton jButtonAIR = new JToggleButton("AIR");
        jButtonAIR.setBounds(430,110,90,30);
        jPanel.add(jButtonAIR);
        jButtonAIR.addActionListener(e ->{dragonTypeplus = DragonType.AIR;dragonTypeplusbol = false;});
        JToggleButton jButtonFIRE = new JToggleButton("FIRE");
        jButtonFIRE.setBounds(525,110,90,30);
        jPanel.add(jButtonFIRE);
        jButtonFIRE.addActionListener(e ->{dragonTypeplus = DragonType.FIRE;dragonTypeplusbol = false;});

        JLabel jLabelCharacter = new JLabel("Выберите характер дракона: ");
        jLabelCharacter.setBounds(5,145,200,30);
        jPanel.add(jLabelCharacter);
        JToggleButton jButtonWISE = new JToggleButton("WISE");
        jButtonWISE.setBounds(200,145,80,30);
        jPanel.add(jButtonWISE);
        jButtonWISE.addActionListener(e ->{dragonCharacterplus = DragonCharacter.WISE;dragonCharacterplusbol= false;});
        JToggleButton jButtonGOOD = new JToggleButton("GOOD");
        jButtonGOOD.setBounds(285,145,80,30);
        jPanel.add(jButtonGOOD);
        jButtonGOOD.addActionListener(e ->{dragonCharacterplus = DragonCharacter.GOOD;dragonCharacterplusbol= false;});
        JToggleButton jButtonCHAOTIC_EVIL = new JToggleButton("CHAOTIC_EVIL");
        jButtonCHAOTIC_EVIL.setBounds(370,145,140,30);
        jPanel.add(jButtonCHAOTIC_EVIL);
        jButtonCHAOTIC_EVIL.addActionListener(e ->{dragonCharacterplus = DragonCharacter.CHAOTIC_EVIL;dragonCharacterplusbol= false;});
        JToggleButton jButtonFICKEL = new JToggleButton("FICKEL");
        jButtonFICKEL.setBounds(515,145,100,30);
        jPanel.add(jButtonFICKEL);
        jButtonFICKEL.addActionListener(e ->{dragonCharacterplus = DragonCharacter.FICKLE;dragonCharacterplusbol= false;});

        JLabel jLabelDragonX = new JLabel("Где расположен дракон(х): ");
        jLabelDragonX.setBounds(5,180,200,30);
        jPanel.add(jLabelDragonX);
        JTextField jTextFieldDragonX = new JTextField(20);
        jTextFieldDragonX.setBounds(200,180,200,30);
        jPanel.add(jTextFieldDragonX);

        JLabel jLabelDragonY = new JLabel("Где расположен дракон(y): ");
        jLabelDragonY.setBounds(5,215,200,30);
        jPanel.add(jLabelDragonY);
        JTextField jTextFieldDragonY = new JTextField(20);
        jTextFieldDragonY.setBounds(200,215,200,30);
        jPanel.add(jTextFieldDragonY);

        JLabel jLabelPersonName = new JLabel("Имя рыцаря: ");
        jLabelPersonName.setBounds(5,250,200,30);
        jPanel.add(jLabelPersonName);
        JTextField jTextFieldPersonName = new JTextField(20);
        jTextFieldPersonName.setBounds(200,250,200,30);
        jPanel.add(jTextFieldPersonName);

        JLabel jLabelYear = new JLabel("Год рождения рыцаря: ");
        jLabelYear.setBounds(5,285,200,30);
        jPanel.add(jLabelYear);
        JTextField jTextFieldYear = new JTextField(20);
        jTextFieldYear.setBounds(200,285,200,30);
        jPanel.add(jTextFieldYear);

        JLabel jLabelMonth = new JLabel("Месяц рождения рыцаря: ");
        jLabelMonth.setBounds(5,320,200,30);
        jPanel.add(jLabelMonth);
        JTextField jTextFieldMonth = new JTextField(20);
        jTextFieldMonth.setBounds(200,320,200,30);
        jPanel.add(jTextFieldMonth);

        JLabel jLabelDay = new JLabel("День рождения рыцаря: ");
        jLabelDay.setBounds(5,355,200,30);
        jPanel.add(jLabelDay);
        JTextField jTextFieldDay = new JTextField(20);
        jTextFieldDay.setBounds(200,355,200,30);
        jPanel.add(jTextFieldDay);

        JLabel jLabelHight = new JLabel("Рост рыцаря: ");
        jLabelHight.setBounds(5,390,200,30);
        jPanel.add(jLabelHight);
        JTextField jTextFieldHight = new JTextField(20);
        jTextFieldHight.setBounds(200,390,200,30);
        jPanel.add(jTextFieldHight);

        JLabel jLabelPassport = new JLabel("Паспортные данные рыцаря: ");
        jLabelPassport.setBounds(5,425,200,30);
        jPanel.add(jLabelPassport);
        JTextField jTextFieldPassport = new JTextField(20);
        jTextFieldPassport.setBounds(200,425,200,30);
        jPanel.add(jTextFieldPassport);

        JLabel jLabelPersonX = new JLabel("Месторасположение рыцаря(х): ");
        jLabelPersonX.setBounds(5,460,200,30);
        jPanel.add(jLabelPersonX);
        JTextField jTextFieldPersonX = new JTextField(20);
        jTextFieldPersonX.setBounds(200,460,200,30);
        jPanel.add(jTextFieldPersonX);

        JLabel jLabelPersonY = new JLabel("Месторасположение рыцаря(y): ");
        jLabelPersonY.setBounds(5,495,200,30);
        jPanel.add(jLabelPersonY);
        JTextField jTextFieldPersonY = new JTextField(20);
        jTextFieldPersonY.setBounds(200,495,200,30);
        jPanel.add(jTextFieldPersonY);

        JLabel jLabelPersonZ = new JLabel("Месторасположение рыцаря(z): ");
        jLabelPersonZ.setBounds(5,530,200,30);
        jPanel.add(jLabelPersonZ);
        JTextField jTextFieldPersonZ = new JTextField(20);
        jTextFieldPersonZ.setBounds(200,530,200,30);
        jPanel.add(jTextFieldPersonZ);

        JLabel jLabelTownName = new JLabel("Название города: ");
        jLabelTownName.setBounds(5,565,200,30);
        jPanel.add(jLabelTownName);
        JTextField jTextFieldTownName = new JTextField(20);
        jTextFieldTownName.setBounds(200,565,200,30);
        jPanel.add(jTextFieldTownName);

        JButton ok = new JButton("ОК");
        ok.setBounds(5, 600, 60, 30);
        jPanel.add(ok);

        jFrame.add(jPanel, BorderLayout.CENTER);

        ok.addActionListener(e->{

            nameplusa = jTextFieldName.getText();
            ageplusa = jTextFieldAge.getText();
            xplusa = jTextFieldDragonX.getText();
            yplusa = jTextFieldDragonY.getText();
            nameKillerPlusa = jTextFieldPersonName.getText();
            yeara = jTextFieldYear.getText();
            montha = jTextFieldMonth.getText();
            daya = jTextFieldDay.getText();
            heighta = jTextFieldHight.getText();
            xtowna = jTextFieldPersonX.getText();
            ytowna = jTextFieldPersonY.getText();
            ztowna = jTextFieldPersonZ.getText();
            nametowna = jTextFieldTownName.getText();
            passportIDa =jTextFieldPassport.getText();

            if (nameplusa.isEmpty() || nameplusa == null) {
                JLabel jLabelIt = getLabel(5);
                jPanel.add(jLabelIt);
            } else {
                nameplus = nameplusa;
                dragonName = false;
            }

            if (ageplusa.isEmpty() || ageplusa == null) {
                JLabel jLabelIt = getLabel(40);
                jPanel.add(jLabelIt);
            } else {
                if (!ageplusa.matches(regex)) {
                    JLabel jLabelIt = getLabel(40);
                    jPanel.add(jLabelIt);
                } else {
                    ageplus = Long.parseLong(ageplusa);
                    dragonAge = false;
                }
            }

            if (xplusa.isEmpty() || xplusa == null) {
                JLabel jLabelIt = getLabel(180);
                jPanel.add(jLabelIt);
            } else {
                if (!xplusa.matches(regex)) {
                    JLabel jLabelIt = getLabel(180);
                    jPanel.add(jLabelIt);
                } else {
                    xplus = Integer.parseInt(xplusa);
                    if (xplus > 77) {
                        JLabel jLabelIt = getLabel(180);
                        jPanel.add(jLabelIt);
                    } else {
                        dragonX = false;
                    }
                }
            }

            if (yplusa.isEmpty() || yplusa == null) {
                JLabel jLabelIt = getLabel(215);
                jPanel.add(jLabelIt);
            } else {
                if (!yplusa.matches(regex)) {
                    JLabel jLabelIt = getLabel(215);
                    jPanel.add(jLabelIt);
                } else {
                    yplus = Float.parseFloat(yplusa);
                    if (yplus > 927 || yplus == 0) {
                        JLabel jLabelIt = getLabel(215);
                        jPanel.add(jLabelIt);
                    } else {
                        dragonY = false;
                    }
                }
            }

            if (nameKillerPlusa == null || nameKillerPlusa.isEmpty()) {
                JLabel jLabelIt = getLabel(250);
                jPanel.add(jLabelIt);
            } else {
                nameKillerPlus =nameKillerPlusa;
                dragonPersonName = false;
            }

            if (yeara.isEmpty() || yeara == null) {
                JLabel jLabelIt = getLabel(285);
                jPanel.add(jLabelIt);
            } else {
                if (!yeara.matches(regex)) {
                    JLabel jLabelIt = getLabel(285);
                    jPanel.add(jLabelIt);
                } else {
                    year = Integer.parseInt(yeara);
                    dragonPersonYear = false;
                }
            }

            if (montha.isEmpty() || montha == null) {
                JLabel jLabelIt = getLabel(320);
                jPanel.add(jLabelIt);
            } else {
                if (!montha.matches(regex)) {
                    JLabel jLabelIt = getLabel(320);
                    jPanel.add(jLabelIt);
                } else {
                    month = Integer.parseInt(montha);
                    if (month > 12 || month <= 0) {
                        JLabel jLabelIt = getLabel(320);
                        jPanel.add(jLabelIt);
                    } else {
                        dragonPersonMonth = false;
                    }
                }
            }

            if (daya.isEmpty() || daya == null) {
                JLabel jLabelIt = getLabel(355);
                jPanel.add(jLabelIt);
            } else {
                if (!daya.matches(regex)) {
                    JLabel jLabelIt = getLabel(355);
                    jPanel.add(jLabelIt);
                } else {
                    day = Integer.parseInt(daya);
                    if (day > 31 || day <= 0) {
                        JLabel jLabelIt = getLabel(355);
                        jPanel.add(jLabelIt);
                    } else {
                        dragonPersonDay = false;
                    }
                }
            }

            if (heighta.isEmpty() || heighta == null) {
                JLabel jLabelIt = getLabel(390);
                jPanel.add(jLabelIt);
            } else {
                if (!heighta.matches(regex)) {
                    JLabel jLabelIt = getLabel(390);
                    jPanel.add(jLabelIt);
                } else {
                    height = Float.parseFloat(heighta);
                    if (height <= 0) {
                        JLabel jLabelIt = getLabel(390);
                        jPanel.add(jLabelIt);
                    } else {
                        dragonHeight = false;
                    }
                }
            }

            if (passportIDa.length() >= 35 || passportIDa.length() < 7 || passportIDa == null || passportIDa.isEmpty()) {
                JLabel jLabelIt = getLabel(425);
                jPanel.add(jLabelIt);
            } else {
                passportID =passportIDa;
                dragonPassport = false;
            }

            if (xtowna.isEmpty() || xtowna == null) {
                JLabel jLabelIt = getLabel(460);
                jPanel.add(jLabelIt);
            } else {
                if (!xtowna.matches(regex)) {
                    JLabel jLabelIt = getLabel(460);
                    jPanel.add(jLabelIt);
                } else {
                    xtown = Double.parseDouble(xtowna);
                    dragonTownX = false;
                }
            }

            if (ytowna.isEmpty() || ytowna == null) {
                JLabel jLabelIt = getLabel(49);
                jPanel.add(jLabelIt);
            } else {
                if (!ytowna.matches(regex)) {
                    JLabel jLabelIt = getLabel(495);
                    jPanel.add(jLabelIt);
                } else {
                    ytown = Float.parseFloat(ytowna);
                    dragonTownY = false;
                }
            }

            if (ztowna.isEmpty() || ztowna == null) {
                JLabel jLabelIt = getLabel(530);
                jPanel.add(jLabelIt);
            } else {
                if (!ztowna.matches(regex)) {
                    JLabel jLabelIt = getLabel(530);
                    jPanel.add(jLabelIt);
                } else {
                    ztown = Integer.parseInt(ztowna);
                    dragonTownZ = false;
                }
            }

            if (nametowna == null || nametowna.isEmpty()) {
                JLabel jLabelIt = getLabel(565);
                jPanel.add(jLabelIt);
            } else {
                nametown = nametowna;
                dragonTownName = false;
            }
        });

        while( dragonName || dragonAge || colorplusbol || dragonTypeplusbol || dragonCharacterplusbol ||
                    dragonX || dragonY || dragonPersonName || dragonPersonYear || dragonPersonMonth ||
                        dragonPersonDay || dragonHeight || dragonPassport || dragonTownX || dragonTownY ||
                                dragonTownZ || dragonTownName){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        jFrame.dispose();

        LocalDate birthday = LocalDate.of(year, month, day);

        Location town = new Location(xtown, ytown, ztown, nametown);

        Person killer = new Person(nameKillerPlus, birthday, height, passportID, town);

        Coordinates coordinates = new Coordinates(xplus, yplus);

        dragonplus = new Dragon(nameplus, coordinates, ageplus, colorplus, dragonTypeplus, dragonCharacterplus, killer);

        return dragonplus;

    }

    private JLabel getLabel(int y){
        JLabel jLabelIt = new JLabel("Неправильно!");
        jLabelIt.setBounds(405,y, 100, 30);
        return jLabelIt;
    }

    private JFrame getFrame(String string){
        JFrame jFrame = new JFrame(string);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 325, dimension.height / 2 - 350, 650, 700);
        jFrame.setVisible(true);
        return jFrame;
    }

}

