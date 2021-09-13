import javax.swing.*;
import java.awt.*;



public class Menu extends JFrame{
        Menu(){
            ImageIcon imageIcon = new ImageIcon("C:\\Users\\charl\\git\\PrivateMessagingNetwork\\src\\Images/server.png");
            this.setTitle("Private Home Network");  // Sets title for window.
            this.setIconImage(imageIcon.getImage());
            this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);  // Makes the frame close on command.
            this.setResizable(false);  // Makes the frame non resizable.
            this.add(title_of_program());
            this.add(button());
            this.getContentPane().setBackground(new Color(102,102,102));  // Sets color of the background of the frame.
            this.setLayout(null);
            this.setVisible(true);  // Makes frame appear on screen.
            this.setSize(500,500); // Sets the shape of frame.

        }


        public JLabel title_of_program(){

            ImageIcon imageIcon = new ImageIcon("C:\\Users\\charl\\git\\PrivateMessagingNetwork\\src\\Images/server.png");
            Image image = imageIcon.getImage();
            Image icon = image.getScaledInstance(120,120, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(icon);

            JLabel title = new JLabel();
            title.setBounds(120,0,250,250);
            title.setText("Private Home Network");
            title.setIcon(imageIcon);
            title.setHorizontalTextPosition(JLabel.CENTER);
            title.setVerticalTextPosition(JLabel.TOP);
            title.setFont(new Font("Daytona", Font.BOLD, 20));
            title.setVerticalAlignment(JLabel.CENTER);
            title.setHorizontalAlignment(JLabel.CENTER);

            return title;
        }

        public JPanel button(){
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBounds(120,230,250,100);
            panel.setBackground(new Color(102,102,102));

            JButton connectButton = new JButton();
            connectButton.setText("Connect");
            connectButton.setFont(new Font("Daytona", Font.BOLD, 10));
            connectButton.setFocusable(false);
            connectButton.setBounds(65,25,125,50);
            connectButton.addActionListener(e -> action());

            panel.add(connectButton);
            return panel;
        }

        public void action(){
            MessagingWindow myMessageSystem = new MessagingWindow();
            this.dispose();
        }



}
