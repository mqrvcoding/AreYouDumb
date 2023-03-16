package de.moeckel.areyoudumb;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() -> {
            try {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public MainFrame() {
        setTitle("Hello :)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setResizable(false);

        JPanel contentPane = new JPanel(null);
        setContentPane(contentPane);

        JLabel lbl = new JLabel("Are you dumb?");
        lbl.setBounds(40, 20, 250, 50);
        contentPane.add(lbl);

        JButton btnYes = new JButton("Yes");
        btnYes.setBounds(70, 170, 90, 60);
        btnYes.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "I knew it :3");
            System.exit(0);
        });
        contentPane.add(btnYes);

        JButton btnNo = new JButton("No");
        btnNo.setBounds(300, 170, 90, 60);
        btnNo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                var random = ThreadLocalRandom.current();
                btnNo.setLocation(random.nextInt(165, 405 + 1),
                        random.nextInt(150, 335 + 1));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNo.setBackground(UIManager.getColor("control"));
            }
        });
        contentPane.add(btnNo);
    }

}
