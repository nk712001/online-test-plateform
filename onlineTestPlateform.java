
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTestPlatform extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JLabel label = new JLabel();
    JRadioButton[] radioButton = new JRadioButton[5];
    JButton btnNext;
    JButton btnBookmark;
    ButtonGroup bg;
    int count = 0;
    int current = 0;
    int x = 1;
    int y = 1;
    int now = 0;
    int[] m = new int[10];

    OnlineTestPlatform(String s) {
        super(s);
        this.add(this.label);
        this.bg = new ButtonGroup();

        for(int i = 0; i < 5; ++i) {
            this.radioButton[i] = new JRadioButton();
            this.add(this.radioButton[i]);
            this.bg.add(this.radioButton[i]);
        }

        this.btnNext = new JButton("Next");
        this.btnBookmark = new JButton("Bookmark");
        this.btnNext.addActionListener(this);
        this.btnBookmark.addActionListener(this);
        this.add(this.btnNext);
        this.add(this.btnBookmark);
        this.set();
        this.label.setBounds(30, 40, 450, 20);
        this.radioButton[0].setBounds(50, 80, 450, 20);
        this.radioButton[1].setBounds(50, 110, 200, 20);
        this.radioButton[2].setBounds(50, 140, 200, 20);
        this.radioButton[3].setBounds(50, 170, 200, 20);
        this.btnNext.setBounds(100, 240, 100, 30);
        this.btnBookmark.setBounds(270, 240, 100, 30);
        this.setDefaultCloseOperation(3);
        this.setLayout((LayoutManager)null);
        this.setLocation(250, 100);
        this.setVisible(true);
        this.setSize(800, 500);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnNext) {
            if (this.check()) {
                ++this.count;
            }

            ++this.current;
            this.set();
            if (this.current == 9) {
                this.btnNext.setEnabled(false);
                this.btnBookmark.setText("Result");
            }
        }

        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + this.x);
            bk.setBounds(480, 20 + 30 * this.x, 100, 30);
            this.add(bk);
            bk.addActionListener(this);
            this.m[this.x] = this.current;
            ++this.x;
            ++this.current;
            this.set();
            if (this.current == 9) {
                this.btnBookmark.setText("Result");
            }

            this.setVisible(false);
            this.setVisible(true);
        }

        int i = 0;

        for(int y = 1; i < this.x; ++y) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (this.check()) {
                    ++this.count;
                }

                this.now = this.current;
                this.current = this.m[y];
                this.set();
                ((JButton)e.getSource()).setEnabled(false);
                this.current = this.now;
            }

            ++i;
        }

        if (e.getActionCommand().equals("Result")) {
            if (this.check()) {
                ++this.count;
            }

            ++this.current;
            JOptionPane.showMessageDialog(this, "correct answers= " + this.count);
            System.exit(0);
        }

    }

    void set() {
        this.radioButton[4].setSelected(true);
        if (this.current == 0) {
            this.label.setText("Que1:  Which of the following is not introduced with Java 8?");
            this.radioButton[0].setText("Stream API");
            this.radioButton[1].setText("Serialization");
            this.radioButton[2].setText("Spliterator");
            this.radioButton[3].setText("Lambda Expression");
        }

        if (this.current == 1) {
            this.label.setText("Que2:  Which feature of java 7 allows to not explicitly close IO resource?");
            this.radioButton[0].setText("try catch finally");
            this.radioButton[1].setText("IOException");
            this.radioButton[2].setText("AutoCloseable");
            this.radioButton[3].setText("Streams");
        }

        if (this.current == 2) {
            this.label.setText("Que3: SessionFactory is a thread-safe object.");
            this.radioButton[0].setText("true");
            this.radioButton[1].setText("false");
            this.radioButton[2].setText("don't know");
            this.radioButton[3].setText("false");
        }

        if (this.current == 3) {
            this.label.setText("Que4: Which is the new method introduced in java 8 to iterate over a collection?");
            this.radioButton[0].setText("for (String i : StringList)");
            this.radioButton[1].setText("foreach (String i : StringList)");
            this.radioButton[2].setText("StringList.forEach()");
            this.radioButton[3].setText("List.for()");
        }

        if (this.current == 4) {
            this.label.setText("Que5:  What is the substitute of Rhino javascript engine in Java 8?");
            this.radioButton[0].setText(" Nashorn");
            this.radioButton[1].setText("V8");
            this.radioButton[2].setText("Inscript");
            this.radioButton[3].setText("Narcissus");
        }

        if (this.current == 5) {
            this.label.setText("Que6: How to read entire file in one line using java 8?");
            this.radioButton[0].setText("Files.readAllLines()");
            this.radioButton[1].setText("Files.read()");
            this.radioButton[2].setText("Files.readFile()");
            this.radioButton[3].setText("Files.lines()");
        }

        if (this.current == 6) {
            this.label.setText("Que7:  Which feature of java 7 allows to not explicitly close IO resource?");
            this.radioButton[0].setText("try catch finally");
            this.radioButton[1].setText("IOException");
            this.radioButton[2].setText("AutoCloseable");
            this.radioButton[3].setText("Streams");
        }

        if (this.current == 7) {
            this.label.setText("Que8:  Which of the following is not a core interface of Hibernate?");
            this.radioButton[0].setText("Configuration");
            this.radioButton[1].setText("Criteria");
            this.radioButton[2].setText("SessionManagement");
            this.radioButton[3].setText("Session");
        }

        if (this.current == 8) {
            this.label.setText("Que9: SessionFactory is a thread-safe object.");
            this.radioButton[0].setText("true");
            this.radioButton[1].setText("false");
            this.radioButton[2].setText("don't know");
            this.radioButton[3].setText("false");
        }

        if (this.current == 9) {
            this.label.setText("Que10: Which of the following is not a state of object in Hibernate?");
            this.radioButton[0].setText("Attached()");
            this.radioButton[1].setText("Detached()");
            this.radioButton[2].setText("Persistent()");
            this.radioButton[3].setText("Transient()");
        }

        this.label.setBounds(30, 40, 450, 20);
        int i = 0;

        for(int j = 0; i <= 90; ++j) {
            this.radioButton[j].setBounds(50, 80 + i, 200, 20);
            i += 30;
        }

    }

    boolean check() {
        if (this.current == 0) {
            return this.radioButton[1].isSelected();
        } else if (this.current == 1) {
            return this.radioButton[1].isSelected();
        } else if (this.current == 2) {
            return this.radioButton[0].isSelected();
        } else if (this.current == 3) {
            return this.radioButton[2].isSelected();
        } else if (this.current == 4) {
            return this.radioButton[0].isSelected();
        } else if (this.current == 5) {
            return this.radioButton[0].isSelected();
        } else if (this.current == 6) {
            return this.radioButton[1].isSelected();
        } else if (this.current == 7) {
            return this.radioButton[2].isSelected();
        } else if (this.current == 8) {
            return this.radioButton[0].isSelected();
        } else {
            return this.current == 9 ? this.radioButton[0].isSelected() : false;
        }
    }

    public static void main(String[] s) {
        new OnlineTestPlatform("Online Test App");
    }
}


