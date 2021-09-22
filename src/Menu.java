import javax.swing.*;
import java.awt.*;


public class Menu extends JFrame{

        // Main Window for th Program.
        Menu(){
            ImageIcon imageIcon = new ImageIcon("C:\\Users\\charl\\git\\PrivateMessagingNetwork\\src\\Images/server.png"); // Saves teh Image for Icon and Logo.
            this.setTitle("Private Home Network");  // Sets title for window.
            this.setIconImage(imageIcon.getImage()); // Sets the saved image as the Window Icon.
            this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);  // Makes the frame close on command.
            this.setResizable(false);  // Makes the frame non resizable.
            this.add(title_of_program()); // Adds the Title to the Menu JFrame.
            this.add(button());// Adds the Connect Button to the Menu JFrame.
            this.getContentPane().setBackground(new Color(102,102,102));  // Sets color of the background of the frame.
            this.setLayout(null); // Sets layout to null.
            this.setVisible(true);  // Makes frame appear on screen.
            this.setSize(500,500); // Sets the shape of frame.
        }

        // Creates Title for the Program.
        public JLabel title_of_program(){
            // Image for Title.
            ImageIcon imageIcon = new ImageIcon("C:\\Users\\charl\\git\\PrivateMessagingNetwork\\src\\Images/server.png"); // Sets the Image for Title.
            Image image = imageIcon.getImage(); // Converts ImageIcon to Image.
            Image icon = image.getScaledInstance(120,120, Image.SCALE_SMOOTH); // Scales the Image to a manageable size.
            imageIcon = new ImageIcon(icon); // Converts Image back to ImageIcon.

            // Title for Menu
            JLabel title = new JLabel(); // Creates the Title JLabel.
            title.setBounds(120,0,250,250); // Sets the bounds for the Title.
            title.setText("Private Home Network"); // Sets the text for the Title.
            title.setIcon(imageIcon); // Sets the ImageIcon for the Title.
            title.setHorizontalTextPosition(JLabel.CENTER); // Sets the horizontal position for Text.
            title.setVerticalTextPosition(JLabel.TOP); // Sets the vertical position for Text.
            title.setFont(new Font("Daytona", Font.BOLD, 20)); // Sets the Font for the Title.
            title.setVerticalAlignment(JLabel.CENTER); // Aligns the Title Vertically.
            title.setHorizontalAlignment(JLabel.CENTER); // Aligns the Title Horizontally.
            return title; // Returns the Title with the modified changes.
        }

        // Connect Button.
        public JPanel button(){
            // Connect Button
            JButton connectButton = new JButton(); // Creates the Connect Button.
            connectButton.setText("Connect"); // Sets the Text of the Button to Connect.
            connectButton.setFont(new Font("Daytona", Font.BOLD, 10)); // Sets the Font for the Button.
            connectButton.setFocusable(false); // Makes the Button un-focusable.
            connectButton.setBounds(65,25,125,50); // Sets the boundaries for the button.
            connectButton.addActionListener(e -> action()); // Sets the action for when the button is pressed. Calls action().

            // Panel for Button.
            JPanel panel = new JPanel(); // Creates the Panel for the Button.
            panel.setLayout(null); // Sets teh Layout to null.
            panel.setBounds(120,230,250,100); // Sets the boundaries for the JPanel.
            panel.setBackground(new Color(102,102,102)); // Sets teh Color background for the Panel.
            panel.add(connectButton); // Adds the Button to the Panel.
            return panel; // Return the Panel with the Button included.
        }

        // Connection Action.
        public void action(){
            // Action
            MessagingWindow myMessageSystem = new MessagingWindow(); // Creates a new Window called myMessageSystem.
            this.dispose(); // Closes current Window.
        }



}
