package drunkstuff.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jensb
 */
class NumberExpectedException extends RuntimeException {
    static final Logger myLogger = 
            Logger.getLogger(Calculator_Controller.class.getName());
    
    public NumberExpectedException(String string) {
        myLogger.log(Level.WARNING, "Number expected: {0}", string);
        
    }
    
    @Override
    public void printStackTrace() {
        
    }

}
