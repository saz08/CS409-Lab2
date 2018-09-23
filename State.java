import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class State {

    private Player player1;
    private Player player2;

    private boolean whiteWin = false;
    private boolean blackWin = false;
    private Board board;


    public void newGame1(){
        JFrame frame = new JFrame("Kamisado");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("Enter player 1's name");
        panel.add(label1);

        JTextField player1 = new JTextField(10);
        panel.add(player1);

        JButton quit = new JButton("Quit Game");
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(quit);

        JButton play = new JButton("Play Kamisado!");
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name1 = player1.getText();
                Player player1 = new Player(name1,"Player1","White");
                Player computer1 = new Player("Computer","Computer","White");
                frame.dispose();
                play(player1, computer1);
            }
        });
        panel.add(play);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void newGame2(){
        JFrame frame = new JFrame("Kamisado");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("Enter player 1's name (white)");
        panel.add(label1);

        JTextField player1 = new JTextField(10);
        panel.add(player1);

        JLabel label2 = new JLabel("Enter player 2's name (black)");
        panel.add(label2);

        JTextField player2 = new JTextField(10);
        panel.add(player2);

        JButton quit = new JButton("Quit Game");
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(quit);

        JButton play = new JButton("Play Kamisado!");
        play.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name1 = player1.getText();
                Player player1 = new Player(name1,"Player1","White");
                String name2 = player2.getText();
                Player player2 = new Player(name2,"Player2","Black");
                frame.dispose();
                play(player1, player2);
            }
        });
        panel.add(play);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void loadGame(){

    }

    public void play(Player player1, Player player2){
        board = new Board();
        board.makeBoard(player1,player2);
        board.firstMove();
    }

    public boolean isLegal(Move move){



        return false;
    }

    public boolean gameFinished(){
        if (whiteWin==true)
            return true;
        else if (blackWin==true)
            return true;
        else
            return false;
    }
}
