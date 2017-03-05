/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author shraddha
 */
public class TextPatternModel {
    private int fontsize;
    private String text = "YOUR STUDENT ID#";
    private java.awt.Color color;
    private ArrayList<ActionListener> actionlistenerlist;
            
    public int getFontsize() {
        return this.fontsize;
    }
    public void setFontsize(int fontsize) {
        this.fontsize = fontsize;
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED,"FontSize"));
    }
    public void setColor(String color) {
        if(color == "Blue")
        {
            this.color = Color.BLUE;
        }
        else if(color == "Black")
        {
            this.color = Color.BLACK;
        }
        else
        {
            this.color = Color.RED;
        }
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Color"));
    }
    public Color getColor() {
        return this.color;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "text"));
    }
    
    public synchronized void addActionListner(ActionListener l)
    {
        if(actionlistenerlist == null)
        {
            actionlistenerlist = new ArrayList<ActionListener>();
        }
    }
    public synchronized void removeActionListner(ActionListener l)
    {
        if(actionlistenerlist != null && actionlistenerlist.contains(l))
        {
            actionlistenerlist.remove(l);
        }
    }
    public void processEvent(ActionEvent e)
    {
        ArrayList<ActionListener> list;
        synchronized(this)
        {
            if(actionlistenerlist == null) return;
            list = (ArrayList<ActionListener>) (actionlistenerlist.clone());
        }
        for(int i=0;i<list.size();i++)
        {
            ActionListener listener = list.get(i);
            listener.actionPerformed(e);
            
        }
    }
}
