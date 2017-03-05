/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author shraddha
 */
public class MVCDemo extends JApplet{
   
    private JButton jbtcontroller = new JButton("Show Controller");
    private JButton jbview = new JButton("Show View");
    private TextPatternModel model = new TextPatternModel();
    
    public  MVCDemo()
    {
        setLayout(new FlowLayout());
        add(jbtcontroller);
        add(jbview);
        jbtcontroller.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               JFrame frame = new JFrame("Controller");
                TextPatternController controller = new TextPatternController();
                controller.setmodel(model);
                frame.pack();
                frame.add(controller);
                frame.setLocationRelativeTo(null); 
                frame.setSize(400,300);
                frame.setVisible(true);
                
            }
        });
        
        jbview.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JFrame frame = new JFrame("View");
                TextPatternView view  = new TextPatternView();
                view.setModel(model);
                frame.pack();
                frame.add(view);
                frame.setLocationRelativeTo(null); 
                frame.setSize(300,300);
                frame.setVisible(true);
            }
        });
    }
    
    public static void main(String[] args) {
        MVCDemo applet = new MVCDemo();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Text Pattern with color");
        frame.getContentPane().add(applet,BorderLayout.CENTER);
        frame.setSize(400, 90);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
