
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main extends JFrame {

    private Vis mainPanel;

    public Main() {

        JMenuBar mb = setupMenu();
        setJMenuBar(mb);

        mainPanel = new Vis();
        setContentPane(mainPanel);

        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Seth Villalon's GUI");
        setVisible(true);
    }

    private JMenuBar setupMenu() {
        //instantiate menubar, menus, and menu options
        JMenuBar menuBar = new JMenuBar();
        
        JMenuItem fileMenu = new JMenu("File");
        JMenuItem actions = new JMenu("Actions");
        JMenuItem action1 = new JMenuItem("Action 1");
        JMenuItem action2 = new JMenuItem("Action 2");
        JMenuItem action3 = new JMenuItem("Action 3");

        JMenuItem item1 = new JMenuItem("Item 1");
        JMenu subMenu = new JMenu("Submenu");
        JMenuItem item2 = new JMenuItem("Item 2");

        //setup action listeners
        subMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Just clicked sub menu ");
            }
        });
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Just clicked menu item 1");

                
            }
        });

        
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Just clicked menu item 2");
            }
        });
        
        action1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Just clicked Action 1");

                mainPanel.boxC= Color.BLUE;
                mainPanel.starsC= Color.BLUE;

            	try {
	            		repaint();
	            		System.out.println("The try worked");

            		}
            		catch(Exception excep) {
                        System.out.println("The repaint didnt work");
            		}
                


            }
        });
        
        action2.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Just clicked Action 2");
                mainPanel.stripesC = Color.WHITE;
            	try {
            			repaint();

            		}
            		catch(Exception excep) {
                        System.out.println("The repaint didnt work");
            		}
                


            }
        });
        
        action3.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Just clicked Action 3");
                mainPanel.starsC = Color.WHITE;
            	try {
            			repaint();

            		}
            		catch(Exception excep) {
                        System.out.println("The repaint didnt work");
            		}
                


            }
        });


        //now hook them all together
        subMenu.add(item2);
        fileMenu.add(item1);
        fileMenu.add(subMenu);
        menuBar.add(fileMenu);
        actions.add(action1);
        actions.add(action2);
        actions.add(action3);
        menuBar.add(actions);

        return menuBar;
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}