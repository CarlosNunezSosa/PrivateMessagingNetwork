import javax.swing.*;
import java.awt.*;

public class MessagingWindow extends JFrame {

    MessagingWindow(){
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\charl\\git\\PrivateMessagingNetwork\\src\\Images/server.png");
        this.setTitle("Messaging Window");  // Sets title for window.
        this.setIconImage(imageIcon.getImage());
        this.setResizable(false);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);  // Makes the frame close on command.
        this.getContentPane().setBackground(new Color(102,102,102));  // Sets color of the background of the frame.
        this.setLayout(null);
        this.add(serverConnection());
        this.add(returnButton());
        this.add(sendMessageButton());
        this.add(makeJPanel(800,800,75,50,Color.GRAY));
        this.add(makeJPanel(75,640,0,50,Color.RED));

        this.setVisible(true);  // Makes frame appear on screen.
        this.setSize(500,640); // Sets the shape of frame.
    }

    public JPanel makeJPanel(int width, int height, int xPos, int yPos, Color color){
        JPanel myJPanel = new JPanel();
        myJPanel.setLayout(null);
        myJPanel.setBounds(xPos,yPos,width,height);
        myJPanel.setBackground(color);
        return myJPanel;
    }

    public JPanel returnButton(){
        //ImageIcon imageIcon = new ImageIcon("C:\\Users\\charl\\git\\PrivateMessagingNetwork\\src\\Images/return.png");

        JButton returnButton = new JButton();
        //returnButton.setIcon(imageIcon);
        returnButton.setText("Return");
        returnButton.setFocusable(false);
        returnButton.setBounds(0,0,75,50);
        returnButton.addActionListener(e->returnHome());

        JPanel returnJPanel = makeJPanel(75,50,0,0,Color.magenta);
        returnJPanel.add(returnButton);
        return returnJPanel;
    }

    public JPanel serverConnection(){
        JLabel messagingTitle = new JLabel();
        messagingTitle.setLayout(null);
        messagingTitle.setBounds(60,0,500,50);
        messagingTitle.setText("Connection ::: ServerToConnect");
        messagingTitle.setFont(new Font("Daytona", Font.BOLD, 20));

        messagingTitle.setBackground(Color.gray);

        JPanel serverConnectionLabel = makeJPanel(500,50,75,0,null);
        serverConnectionLabel.add(messagingTitle);
        return serverConnectionLabel;
    }

    public void returnHome(){
        this.dispose();
        new Menu();
    }

    public JPanel sendMessageButton(){

        JButton messageButton = new JButton();

        messageButton.setText("Send");
        messageButton.setFocusable(false);
        messageButton.setBounds(0,0,75,90);
        messageButton.addActionListener(e->sendMessage());

        JPanel messagePanel = makeJPanel(420,100,75,520,Color.BLACK);
        messagePanel.setLayout(null);
        messagePanel.add(messageButton);
        return messagePanel;
    }

    public void sendMessage(){
        System.out.println("Sending Message Now");
    }




}
