package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import it.unibo.oop.lab.mvcio.Controller;;
/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    
    private final JFrame frame = new JFrame();
    private final Controller controller = new Controller();
    
    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface.
     * Suggestion: use a second JPanel with a second BorderLayout, put the panel
     * in the North of the main panel, put the text field in the center of the
     * new panel and put the button in the line_end of the new panel.
     * 
     * 2) The JTextField should be non modifiable. And, should display the
     * current selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should
     * use the method showSaveDialog() to display the file chooser, and if the
     * result is equal to JFileChooser.APPROVE_OPTION the program should set as
     * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
     * then the program should do nothing. Otherwise, a message dialog should be
     * shown telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     */
    
    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JButton save = new JButton("save");
        canvas.add(save, BorderLayout.SOUTH);
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JPanel canvas2 = new JPanel();
        canvas2.setLayout(new BorderLayout());
        final JTextField text = new JTextField();
        text.setEditable(false);
        text.setText(controller.getCurrent());
        final JButton browse = new JButton("Browse");
        canvas2.add(text, BorderLayout.CENTER);
        canvas2.add(browse, BorderLayout.LINE_END);
        canvas.add(canvas2, BorderLayout.NORTH);
        
        save.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.write("OK");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                
            }
        });
        
        browse.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser browser = new JFileChooser();
                final int res = browser.showSaveDialog(browser);
                if(res == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrent(browser.getSelectedFile().getName());
                    text.setText(browser.getSelectedFile().getName());
                }else {
                    JOptionPane.showMessageDialog(browse, "An error has occured "
                                                + "while selecting the file");
                }
            }
        });
    }
    
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
      
        
    }
    
    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }

}
