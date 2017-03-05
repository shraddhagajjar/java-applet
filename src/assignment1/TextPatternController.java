/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author shraddha
 */
public class TextPatternController extends JPanel{
    private TextPatternModel model;
    private String[] Color1 = new String[]{"Blue","Black","Red"};
    private JTextField jtext = new JTextField();
    private JComboBox<String> colorlist = new JComboBox<>(Color1);
    SpinnerModel spinnerModel = new SpinnerNumberModel(12,12,48,12);
    JSpinner spinner = new JSpinner(spinnerModel);
    //Jpanel with few J componet
    public TextPatternController() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,2));
        panel1.add(new JLabel("Enter Text"));
        panel1.add(jtext);
        panel1.add(new JLabel("Select Color"));
        panel1.add(colorlist);
        panel1.add(new JLabel("Select Size"));
        panel1.add(spinner);
        
        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);
        //Event For change Color Of text
        colorlist.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent ae) {
               if(model!=null)
               {
                    model.setText(jtext.getText());
                    TextPatternView.label.setText(model.getText());
                    model.setColor((String)colorlist.getSelectedItem());
                    TextPatternView.label.setForeground(model.getColor());
                }
            }
        });
        //event for setText in model and change text in view
        jtext.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent ae) {
               if(model!= null)
               {
                  model.setText(jtext.getText());
                  TextPatternView.label.setText(model.getText());
               }
            }
        });
        //Event for get value from spinner make change as per spinner is selected
       spinner.addChangeListener(new ChangeListener() {
              @Override
            public void stateChanged(ChangeEvent ce) {
               if(model != null)
               {
                   model.setFontsize( (int)spinner.getValue());
                   TextPatternView.label.setFont(new Font("Times new roman",Font.BOLD,model.getFontsize()));
               }
            }
        });
    }
    public  void setmodel(TextPatternModel newModel)
    {
        model = newModel;
    }
    public TextPatternModel getmodel(){
        return this.model;
    }
}
    
    

