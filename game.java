package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class game extends JFrame implements ActionListener {
   private JPanel panel;
   private JTextField textField;
   private JTextArea textArea;
   private JLabel label;
   private JScrollPane scrollPane;
   
   public game(){
      panel = new JPanel();
      panel.setLayout(new BorderLayout());
      
      //Overhead Label placement/creating
      label = new JLabel("Mislead", SwingConstants.CENTER);
      panel.add(label, BorderLayout.PAGE_START);
      
      //Text entry field
      textField = new JTextField();
      textField.addActionListener(this);
      panel.add(textField, BorderLayout.PAGE_END);
            
      //Output text area
      textArea = new JTextArea();
      textArea.setEditable(false);
      textArea.setLineWrap(true);
      panel.add(textArea, BorderLayout.CENTER);
      
      //scrolling function
      scrollPane = new JScrollPane(textArea);
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
      panel.add(scrollPane, BorderLayout.CENTER);
      
      //set the games fonts and colors
      //label
      label.setFont(new Font("monospaced", Font.BOLD, 16));
      label.setForeground(Color.white);
      label.setBackground(Color.black);
      label.setOpaque(true);
      label.setBorder(null);
      //textField
      textField.setFont(new Font("monospaced", 0, 16));
      textField.setForeground(Color.white);
      textField.setBackground(Color.black);
      textField.setOpaque(true);
      textField.setBorder(null);
      //textArea
      textArea.setFont(new Font("monospaced", 0, 16));
      textArea.setForeground(Color.white);
      textArea.setBackground(Color.black);
      textArea.setOpaque(true);
      textArea.setBorder(null);
      //scrollPane
      scrollPane.setBorder(null);
      //panel
      panel.setBorder(null);
      panel.setForeground(Color.black);
      panel.setBackground(Color.black);
      add(panel);
      
      
      setSize(600, 400);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
      //panel.setTitle("")   
   }  
   
   public void actionPerformed(ActionEvent e){
      String text = textField.getText();
      if(!(text.equals(""))){
    	  textArea.append(text + "\n");
    	  textArea.setCaretPosition(textArea.getDocument().getLength());
    	  textField.setText("");
    	  textArea.setCaretPosition(textArea.getDocument().getLength());
      }
   }  
   
   public String a(String str){
      String article = "a";
      if(str.substring(0,1).matches("[aeiouAEIOU]")){article = "an";}
      return article + " " + str;
   }   
         
   
   public static void main(String[] args){
      new game();
   }
}       
