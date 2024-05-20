import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Client {

    private final JFrame frame = new JFrame("Tic Tac Toe");
    private final JLabel messageLabel = new JLabel("");
    private ImageIcon icon;
    private ImageIcon opponentIcon;

    private final Tile[] board = new Tile[9];
    private Tile currentTile;

    private static int PORT = 8001;
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    public Client(String serverAddress) throws Exception {
        socket = new Socket(serverAddress, PORT);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        messageLabel.setBackground(Color.lightGray);
        frame.getContentPane().add(messageLabel, "South");

        JPanel boardPanel = new JPanel();
        boardPanel.setBackground(Color.RED);
        boardPanel.setLayout(new GridLayout(3, 3, 5, 5));
        for (int i = 0; i < board.length; i++) {
            final int j = i;
            board[i] = new Tile();
            board[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    currentTile = board[j];
                    out.println("MOVE " + j);}});
            boardPanel.add(board[i]);
        }
        frame.getContentPane().add(boardPanel, "Center");
    }

    public void play() throws Exception {
        String response;
        try {
            response = in.readLine();
            if (response.startsWith("Welcome!")) {
                char mark = response.charAt(8);
                icon = new ImageIcon(mark == 'X' ? "x.png" : "o.png");
                Image image = icon
                        .getImage()
                        .getScaledInstance(20,20,Image.SCALE_SMOOTH);
                icon = new ImageIcon(image);
                opponentIcon  = new ImageIcon(mark == 'X' ? "x.png" : "o.png");
                Image image2 = icon
                        .getImage()
                        .getScaledInstance(20,20,Image.SCALE_SMOOTH);
                opponentIcon = new ImageIcon(image2);
                frame.setTitle("Player " + mark);
            }
            while (true) {
                response = in.readLine();
                if (response.startsWith("VALID_MOVE")) {
                    messageLabel.setText("Valid move, please wait");
                    currentTile.setIcon(opponentIcon);
                    currentTile.repaint();
                } else if (response.startsWith("OPPONENT_MOVED")) {
                    int loc = Integer.parseInt(response.substring(15));
                    board[loc].setIcon(opponentIcon);
                    board[loc].repaint();
                    messageLabel.setText("Opponent moved, your turn");
                } else if (response.startsWith("VICTORY")) {
                    messageLabel.setText("You win");
                    break;
                } else if (response.startsWith("DEFEAT")) {
                    messageLabel.setText("You lose");
                    break;
                } else if (response.startsWith("TIE")) {
                    messageLabel.setText("You tied");
                    break;
                } else if (response.startsWith("MESSAGE")) {
                    messageLabel.setText(response.substring(8));
                }
            }
            out.println("QUIT");
        }
        finally {
            socket.close();
        }
    }

    private boolean wantsToPlayAgain() {
        int response = JOptionPane.showConfirmDialog(frame,
                "Want to play again?",
                "Tic Tac Toe is Fun Fun Fun",
                JOptionPane.YES_NO_OPTION);
        frame.dispose();
        return response == JOptionPane.YES_OPTION;
    }

    static class Tile extends JPanel {
        JLabel label = new JLabel((Icon)null);

        public Tile() {
            setBackground(Color.WHITE);
            add(label);
        }

        public void setIcon(Icon icon) {
            label.setIcon(icon);
        }
    }
    
    public static void main(String[] args) throws Exception {
        while (true) {
            String serverAddress = (args.length == 0) ? "localhost" : args[1];
            Client client = new Client(serverAddress);
            client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            client.frame.setSize(200, 200);
            client.frame.setVisible(true);
            client.frame.setResizable(false);
            client.play();
            if (!client.wantsToPlayAgain()) {
                break;
            }
        }
    }
}