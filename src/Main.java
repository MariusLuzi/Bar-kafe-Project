import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

public class Main {
    public static void main(String[] args) {
        // Create the main application frame
        JFrame f = new JFrame("BarKafe");

        // Display the login dialog
        LoginDialog loginDlg = new LoginDialog(f);
        loginDlg.setVisible(true);

        // Check if login was successful
        if (loginDlg.isSucceeded()) {
            // Proceed with application setup if login succeeds
            f.setSize(688, 688);
            f.setVisible(true);
            f.setLayout(null);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel titulli = new JLabel("BarKafe");
            titulli.setBounds(50, 50, 288, 30);
            titulli.setHorizontalAlignment(SwingConstants.CENTER);
            titulli.setForeground(Color.BLUE);
            f.add(titulli);

            JLabel sasia = new JLabel("Sasia:");
            sasia.setBounds(250, 100, 200, 30);
            f.add(sasia);

            JLabel Fatura = new JLabel("Fatura:");
            Fatura.setBounds(500, 100, 200, 30);
            f.add(Fatura);

            JTextArea rezultati = new JTextArea();
            rezultati.setEditable(false);
            rezultati.setBackground(Color.BLUE);
            rezultati.setBounds(500, 150, 200, 300);
            rezultati.setSize(200, 300);
            rezultati.setForeground(Color.WHITE);
            f.add(rezultati);

            JButton printimi = new JButton("Print");
            printimi.setBounds(500, 500, 100, 50);
            f.add(printimi);

            JCheckBox kafe = new JCheckBox("Kafe 70 Leke");
            kafe.setBounds(50, 150, 200, 30);
            f.add(kafe);

            JCheckBox uje = new JCheckBox("Uje 80 Leke");
            uje.setBounds(50, 200, 200, 30);
            f.add(uje);

            JCheckBox makiato = new JCheckBox("Makiato 100 Leke");
            makiato.setBounds(50, 250, 200, 30);
            f.add(makiato);

            JCheckBox fanta = new JCheckBox("Fanta 150 Leke");
            fanta.setBounds(50, 300, 200, 30);
            f.add(fanta);

            JCheckBox sprite = new JCheckBox("Sprite 160 Leke");
            sprite.setBounds(50, 350, 200, 30);
            f.add(sprite);

            JTextField input_kafe = new JTextField();
            input_kafe.setBounds(250, 150, 200, 30);
            f.add(input_kafe);

            JTextField input_uje = new JTextField();
            input_uje.setBounds(250, 200, 200, 30);
            f.add(input_uje);

            JTextField input_makiato = new JTextField();
            input_makiato.setBounds(250, 250, 200, 30);
            f.add(input_makiato);

            JTextField input_fanta = new JTextField();
            input_fanta.setBounds(250, 300, 200, 30);
            f.add(input_fanta);

            JTextField input_sprite = new JTextField();
            input_sprite.setBounds(250, 350, 200, 30);
            f.add(input_sprite);

            JButton llogarit = new JButton("Llogarit");
            llogarit.setBounds(50, 400, 200, 30);
            f.add(llogarit);

            JPanel  paneli= new JPanel();
            f.add(paneli);
           paneli.setBackground (Color.black);
           
            printimi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        rezultati.print();
                    } catch (PrinterException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            llogarit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int total = 0;
                    String fatura = "";

                    if (kafe.isSelected()) {
                        int sasia_kafe = Integer.parseInt(input_kafe.getText());
                        total += sasia_kafe * 70;
                        fatura += "Kafe 70*" + sasia_kafe + "\n";
                    }

                    if (uje.isSelected()) {
                        int sasia_uje = Integer.parseInt(input_uje.getText());
                        total += sasia_uje * 80;
                        fatura += "Uje 80*" + sasia_uje + "\n";
                    }

                    if (makiato.isSelected()) {
                        int sasia_makiato = Integer.parseInt(input_makiato.getText());
                        total += sasia_makiato * 100;
                        fatura += "Makiato 100*" + sasia_makiato + "\n";
                    }

                    if (fanta.isSelected()) {
                        int sasia_fanta = Integer.parseInt(input_fanta.getText());
                        total += sasia_fanta * 150;
                        fatura += "Fanta 150*" + sasia_fanta + "\n";
                    }

                    if (sprite.isSelected()) {
                        int sasia_sprite = Integer.parseInt(input_sprite.getText());
                        total += sasia_sprite * 160;
                        fatura += "Sprite 160*" + sasia_sprite + "\n";
                    }

                    fatura += "________\n" + "Total per tu paguar:" + total;
                    rezultati.setText(fatura);
                }
            });
        } else {
            // Close the application if login fails
            System.exit(0);
        }
    }
}

