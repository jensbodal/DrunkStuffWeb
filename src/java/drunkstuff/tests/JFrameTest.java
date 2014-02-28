package drunkstuff.tests;

import drunkstuff.controller.Calculator_Controller;
import drunkstuff.view.JPanelView;
import drunkstuff.calculator.Person;
import javax.swing.JFrame;

/**
 * 
 * @author jensbodal
 * @version 1.0
 * 
 * Compiler Java 1.7 OS: Windows 7, OSX Hardware: PC
 * 
 * Date Day, Year Initials Completed v#
 */

public class JFrameTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person person = new Person();
        JPanelView view = new JPanelView(person);
        Calculator_Controller controller = new Calculator_Controller(view, person);
        JFrame frame = new JFrame();
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(JPanelView.bounds);
        frame.setVisible(true);
    }
}

