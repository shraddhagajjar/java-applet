/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author shraddha
 */
public class TextPatternView extends javax.swing.JPanel {
    private TextPatternModel model;
    private TextPatternModel m = new TextPatternModel();
    public static JLabel label = new JLabel("Your Student ID #");
    
    public TextPatternView() {
        JPanel panel1 = new JPanel();
        label.setText(m.getText());
        label.setFont(new Font("Times new roman",Font.BOLD,24));
        panel1.add(label);
        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);
    }
    
    public void setModel(TextPatternModel newmodel) {
        model = newmodel;
        if(model != null){
            model.addActionListner(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent ae) {
                            label.setText(m.getText());
                            System.out.println(m.getText());
                            label.setForeground(m.getColor());
                            System.out.println(m.getColor());
                            label.setFont(new Font("Times new roman",Font.BOLD,m.getFontsize()));
     
                }
            });
        }
    }
     public TextPatternModel getModel() {
        return this.model;
    }
}
