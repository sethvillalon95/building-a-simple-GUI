
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main extends JFrame {
    
	int dx = 0;
	int dy = 0;
	int x = 0; 
	int y = 0 ;

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
        
		 dx = 2;
		 dy = 0;
		 x = 50; 
		 y = 50 ;
        
    }

    private JMenuBar setupMenu() {
        //instantiate menubar, menus, and menu options
        JMenuBar menuBar = new JMenuBar();
        
        JMenuItem fileMenu = new JMenu("File");
        JMenuItem actions = new JMenu("Actions");
        JMenuItem action = new JMenuItem("Red");
        JMenuItem action1 = new JMenuItem("Action 1");
        JMenuItem action2 = new JMenuItem("Action 2");
        JMenuItem action3 = new JMenuItem("Action 3");
        JMenuItem action4 = new JMenuItem("Reset");
        JMenuItem action5 = new JMenuItem("Animation");



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
        
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Just clicked Red");

                mainPanel.background= Color.RED;

            	try {
	            		repaint();

            		}
            		catch(Exception excep) {
                        System.out.println("The repaint didnt work");
            		}
                


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
        action4.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Just clicked Action 4");
                mainPanel.background = Color.WHITE;
                mainPanel.boxC = Color.WHITE;
                mainPanel.stripesC = Color.WHITE;
                mainPanel.starsC = Color.WHITE;

            	try {
            			repaint();
//            			dx+=10;
//            			dy+=10;

            		}
            		catch(Exception excep) {
                        System.out.println("The repaint didnt work");
            		}
                System.out.println("End of code");



            }
        });
        
        // Animation 
        action5.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {

        	
                Timer t = new Timer(10, this);
                System.out.println("Started time");
                
                Graphics g = mainPanel.getGraphics();
                g.setColor(Color.WHITE);
                g.fillRect(x,y,200,200);
             


                t.start();
                x+=dx;
                y+=dy;
                repaint();






                System.out.println("End of code");



            }
        });

        //now hook them all together
        subMenu.add(item2);
        fileMenu.add(item1);
        fileMenu.add(subMenu);
        menuBar.add(fileMenu);
        actions.add(action);
        actions.add(action1);
        actions.add(action2);
        actions.add(action3);
        actions.add(action4);
        actions.add(action5);

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