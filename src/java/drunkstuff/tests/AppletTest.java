/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package drunkstuff.tests;

import drunkstuff.controller.Calculator_Controller;
import drunkstuff.view.Calculator_View;
import drunkstuff.calculator.Person;
import javax.swing.JApplet;

/**
 * 
 * @author jensbodal
 * @version 1.0
 * 
 * Compiler Java 1.7 OS: Windows 7, OSX Hardware: PC
 * 
 * Date Day, Year Initials Completed v#
 */

public class AppletTest extends JApplet {
    public AppletTest() {
        Person person = new Person();
        Calculator_View view = new Calculator_View(person);
        Calculator_Controller controller = 
                new Calculator_Controller(view, person);
        this.add(view);
    }
}

