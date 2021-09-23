import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MessagingWindow extends JFrame {

    // Global Fields to be accessed by multiple methods
    public JTextArea messageField = new JTextArea(); // Message Area where text will be written.
    public JPanel messagesWindow = makeJPanel(420,500,75,50,Color.darkGray); // Message window where messages the last 4 messages sent are shown.
    public ArrayList<JLabel> messagesThatHaveBeenSent = new ArrayList<>();


    // Messaging Window Constructor
    MessagingWindow(){
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\charl\\git\\PrivateMessagingNetwork\\src\\Images/server.png"); // Image icon for the Messaging Window.
        this.setTitle("Messaging Window");  // Sets title for window.
        this.setIconImage(imageIcon.getImage()); // Sets the chosen image to the current Window.
        this.setResizable(false); // Makes window not resizable.
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);  // Makes the frame close on command.
        this.getContentPane().setBackground(new Color(102,102,102));  // Sets color of the background of the frame.
        this.add(serverConnection()); // Adds the title ;  which also identifies the server connected to.
        this.add(returnButton()); // Adds the RETURN button.
        this.add(sendMessageButton()); // Adds SEND button.
        this.add(messageHistory()); // Adds the message History Panel.
        this.add(windowForMessages()); // Adds the Panel for previous sent messages.
        this.pack(); // Organizes everything neatly.
        this.setVisible(true);  // Makes frame appear on screen.
        this.setSize(500,640); // Sets the shape of frame.
    }

    // Re-Usable code that is used throughout.
    public JPanel makeJPanel(int width, int height, int xPos, int yPos, Color color){
        JPanel myJPanel = new JPanel(); // Create a new JPanel.
        myJPanel.setLayout(null); // Sets the layout of the panel to null.
        myJPanel.setBounds(xPos,yPos,width,height); // Sets the boundaries of the Panel: x position, y position, width, and height.
        myJPanel.setBackground(color); // Sets the color of the panel.
        return myJPanel; // Returns the modified Panel.
    }

    // Button that return you to the main Window
    public JPanel returnButton(){
        // Return Button
        JButton returnButton = new JButton(); // Creates a button called returnButton.
        returnButton.setText("Return"); // Sets the text for the button.
        returnButton.setFocusable(false); // Makes the button un-focusable.
        returnButton.setBounds(0,0,75,50); // Sets teh bounds for the button.
        returnButton.addActionListener(e->returnHome()); // Calls the method returnHome once the button is pressed.

        // Panel for Return Button
        JPanel returnJPanel = makeJPanel(75,50,0,0,null); // Creates Panel where thr Button will be added.
        returnJPanel.add(returnButton); // Adds the Button to the Panel.
        return returnJPanel; // Return the Panel with the new Button.
    }

    // Title that will let the user know to what server they are connected to.
    public JPanel serverConnection(){
        //JLabel for the Title
        JLabel messagingTitle = new JLabel(); // Creates the Label for the Title.
        messagingTitle.setBounds(60,0,500,50); // Sets teh bounds for the Label.
        messagingTitle.setText("Connection ::: ServerToConnect"); // Sets the text for the Label.
        messagingTitle.setFont(new Font("Daytona", Font.BOLD, 20)); // Sets teh Font for the Label.
        messagingTitle.setBackground(Color.gray); // Sets the color for the Label.

        //JPanel for the Label to be added to.
        JPanel serverConnectionLabel = makeJPanel(500,50,75,0,null); // Creates the JPanel.
        serverConnectionLabel.add(messagingTitle); // Adds teh JLabel to the JPanel
        return serverConnectionLabel; // Returns the JPanel with the JLabel included.
    }

    // Return Action Method - Makes the window go back to the Menu once the Return Button is pressed.
    public void returnHome(){
        this.dispose(); // Deletes current Window.
        new Menu(); // Creates new Menu Window.
    }

    // Send Message Button and Message Field.
    public JPanel sendMessageButton(){
        // Message Field
        messageField.setBounds(75,0,345,100); // Sets the bounds for the message field.
        messageField.setFont(new Font("Daytona", Font.BOLD, 15)); // Sets the Font for the message field.
        messageField.setBackground(new Color(164,164,164)); // Sets the background color for the message field.
        messageField.setCaretColor(Color.BLACK); // Sets the color for the text that is written in the message field.

        // Send Message Button
        JButton messageButton = new JButton(); // Creates the Button.
        messageButton.setText("Send"); // Sets the text for the Button.
        messageButton.setFocusable(false); // Makes the Send Button un- focusable.
        messageButton.setBounds(0,0,75,90); // Sets the bounds for the Send Button.
        messageButton.addActionListener(e->sendMessage()); // The method sendMessage() is called once the Send Button is pressed.

        // JPanel where thr messageField and Send Message Button will be added.
        JPanel messagePanel = makeJPanel(420,100,75,520,null); // Creates the JPanel.
        messagePanel.add(messageField); // Adds the message field to the panel.
        messagePanel.add(messageButton); // Adds the message button to the panel.

        return messagePanel; // Return the Panel with the message field and send button added.
    }

    // Sends the Message once the button is pressed.
    public void sendMessage(){
        if(messagesThatHaveBeenSent.isEmpty()) {
            JLabel newMessage = new JLabel();
            newMessage.setFont(new Font("Daytona", Font.BOLD, 10));
            newMessage.setBounds(350, 400, 200, 40);
            newMessage.setBackground(Color.orange);
            newMessage.setForeground(Color.GREEN);
            newMessage.setText("<--"+messageField.getText());
            messagesThatHaveBeenSent.add(newMessage); // Adds the new message to the message Array.
            messagesWindow.add(newMessage);
            this.repaint();

        }
        else {
            for (int i=0; i<messagesThatHaveBeenSent.size();i++) {
                JLabel message = messagesThatHaveBeenSent.get(i);
                message.setBounds(350,400-(60*(i+1)), 200, 40);
                this.repaint();
            }

            JLabel newMessage = new JLabel();
            newMessage.setFont(new Font("Daytona", Font.BOLD, 10));
            newMessage.setBounds(350, 400, 200, 40);
            newMessage.setBackground(Color.orange);
            newMessage.setForeground(Color.GREEN);
            newMessage.setText("<--"+messageField.getText());
            messagesThatHaveBeenSent.add(0,newMessage); // Adds the new message to the message Array.
            messagesWindow.add(newMessage);
            this.repaint();
        }
        messageField.setText(""); // Sets the field text back to blank.
    }

    // Window where sent messages are shown
    public JPanel windowForMessages(){
        messagesWindow.setLayout(null);
        return messagesWindow; // returns the already made Window.
    }

    // Message Bubbles that will appear in the Message Window.
    public JLabel messageBubble(String message){
        JLabel messageLabel = new JLabel(); // Creates the JLabel.
        messageLabel.setText(message); // Sets the text to the given text
        messageLabel.setFont(new Font("Daytona", Font.BOLD, 20)); // Sets the Font for the Chat bubble.
        messageLabel.setBounds(0,0,40,20); // Sets the Bounds for the Chat bubble.
        messageLabel.setBackground(Color.white); // Sets the background color of the bubble.
        return messageLabel; // Return the chat bubble.
    }

    // Message History Panel
    public JPanel messageHistory(){
        return makeJPanel(75,640,0,50, new Color(90, 90, 120)); // Creates and return the Panel.
    }





}
