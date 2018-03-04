package nl.elridge.sudoku.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import nl.elridge.sudoku.controller.ButtonController;
import nl.elridge.sudoku.model.UpdateAction;

/**
 * This class draws the button panel and reacts to updates from the model.
 *
 * @author Eric Beijer
 */
public class ButtonPanel extends JPanel implements Observer {
    JButton btnNew, btnCheck, btnExit,btneasy,btnmedium,btnhard,btnmail;  // Used buttons.
    JCheckBox cbHelp;               // Used check box.
    ButtonGroup bgNumbers;          // Group for grouping the toggle buttons.
    JToggleButton[] btnNumbers; 
    JTextField fname;
    // Used toggle buttons.

    /**
     * Constructs the panel and arranges all components.
     */
    public ButtonPanel() {
        super(new BorderLayout());
         
        
        JPanel pnlAlign = new JPanel();
        pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.PAGE_AXIS));
        add(pnlAlign, BorderLayout.NORTH);
       
        JPanel pnlOptions = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlOptions.setBorder(BorderFactory.createTitledBorder(" Options "));
        pnlAlign.add(pnlOptions);

        btnNew = new JButton("NEW");
        btnNew.setFocusable(false);
        pnlOptions.add(btnNew);
         
         btneasy = new JButton("EASY");
        btneasy.setFocusable(false);
        pnlOptions.add(btneasy);
        
         btnmedium = new JButton("MEDIUM");
        btnmedium.setFocusable(false);
        pnlOptions.add(btnmedium);
        
         btnhard = new JButton("HARD");
        btnhard.setFocusable(false);
        pnlOptions.add(btnhard);
         
        btnCheck = new JButton("CHECK");
        btnCheck.setFocusable(false);
        pnlOptions.add(btnCheck);
        
        btnmail = new JButton("SEND_MAIL");
        btnmail.setFocusable(false);
        pnlOptions.add(btnmail);

        btnExit = new JButton("EXIT");
        btnExit.setFocusable(false);
        pnlOptions.add(btnExit);
        
        JPanel pnlname= new JPanel();
        pnlname.setLayout(new BoxLayout(pnlname, BoxLayout.PAGE_AXIS));
        pnlname.setBorder(BorderFactory.createTitledBorder("ARE YOU READY TO PLAY"));
        pnlAlign.add(pnlname);

        JPanel pnlnamef = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlname.add(pnlnamef);

        fname = new JTextField();
        fname.setEditable(false);
        fname.setBounds(120, 120, 130, 140);
        pnlnamef.add(fname);
        fname.setVisible(true);

        JPanel pnlNumbers = new JPanel();
        pnlNumbers.setLayout(new BoxLayout(pnlNumbers, BoxLayout.PAGE_AXIS));
        pnlNumbers.setBorder(BorderFactory.createTitledBorder(" Numbers "));
        pnlAlign.add(pnlNumbers);

        JPanel pnlNumbersHelp = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlNumbers.add(pnlNumbersHelp);

        cbHelp = new JCheckBox("Help on", true);
        cbHelp.setFocusable(false);
        pnlNumbersHelp.add(cbHelp);

        JPanel pnlNumbersNumbers = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlNumbers.add(pnlNumbersNumbers);

        bgNumbers = new ButtonGroup();
        btnNumbers = new JToggleButton[9];
        for (int i = 0; i < 9; i++) {
            btnNumbers[i] = new JToggleButton("" + (i + 1));
            btnNumbers[i].setPreferredSize(new Dimension(40, 40));
            btnNumbers[i].setFocusable(false);
            bgNumbers.add(btnNumbers[i]);
            pnlNumbersNumbers.add(btnNumbers[i]);
        }
    }
       
         
    /**
     * Method called when model sends update notification.
     *
     * @param o     The model.
     * @param arg   The UpdateAction.
     */
    @Override
    public void update(Observable o, Object arg) {
        switch ((UpdateAction)arg) {
            case NEW_GAME:
            case CHECK:
                bgNumbers.clearSelection();
                break;
        }
    }

    /**
     * Adds controller to all components.
     *
     * @param buttonController  Controller which controls all user actions.
     */
    public void setController(ButtonController buttonController) {
        btnNew.addActionListener(buttonController);
        btneasy.addActionListener(buttonController);
        btnmedium.addActionListener(buttonController);
        btnhard.addActionListener(buttonController);
        btnCheck.addActionListener(buttonController); 
         btnmail.addActionListener(buttonController);
        btnExit.addActionListener(buttonController);
        cbHelp.addActionListener(buttonController);
        for (int i = 0; i < 9; i++)
            btnNumbers[i].addActionListener(buttonController);
    }
}