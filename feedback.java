import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;


//feedback form
public class feedback implements ActionListener {
    JFrame window=new JFrame("FEEDBACK FORM");
    JTextField nameTextField = new JTextField();
    JTextField ratingTextField= new JTextField();
    JTextField suggestionsTextField= new JTextField();
    JLabel nameLabel= new JLabel("CUSTOMER NAME");
    JLabel ratingLabel= new JLabel("RATING OUT OF 5");
    JLabel suggestionLabel= new JLabel("ANY REVIEWS?");
    JButton SubmitButton = new JButton("SUBMIT");
    JLabel blank=new JLabel();


    //constructor
    feedback()
    {
        GridLayout gl= new GridLayout();
        gl.setColumns(3);
        gl.setRows(4);
        window.setLayout(gl);
        SubmitButton.addActionListener(this);
        window.add(nameLabel);
        window.add(nameTextField);
        window.add(ratingLabel);
        window.add(ratingTextField);
        window.add(suggestionLabel);
        window.add(suggestionsTextField);
        window.add(blank);
        window.add(SubmitButton);
        window.setSize(500,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        //WHEN I CLICK ON SUBMIT BUTTON I WANT A NEW FILE
        if(ae.getActionCommand()==SubmitButton.getActionCommand())
        {
            try{
                BufferedWriter out = new BufferedWriter(new FileWriter("feedback.txt"));
                out.write(nameLabel.getText() + " : "+ nameTextField.getText()+"; ");
                out.write(ratingLabel.getText() + " : "+ ratingTextField.getText()+"; ");
                out.write(suggestionLabel.getText() + " : "+ suggestionsTextField.getText()+"; ");//to get string from textfield
                out.close();
                JOptionPane.showMessageDialog(null,"FILE WRITTEN SUCCESSFULLY");
            }
            catch(Exception e)
            {
                //default java message box
                JOptionPane.showMessageDialog(null,e+"");
            }
        }
    }
}
