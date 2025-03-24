package com.example.stopwatch;

import javax.swing.*;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {
    private final JPanel timersPanel;
    private final List<StopwatchPanel> stopwatches;

    public GUI() {
        // Gunakan tema modern
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException e) {
        }

        setTitle("Multi-Stopwatch Timer");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        timersPanel = new JPanel();
        timersPanel.setLayout(new BoxLayout(timersPanel, BoxLayout.Y_AXIS));
        timersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        stopwatches = new ArrayList<>();

        // Tombol tambah stopwatch dengan desain modern
        JButton addTimerButton = new JButton("+ Tambah Stopwatch");
        addTimerButton.setFont(new Font("Arial", Font.BOLD, 14));
        addTimerButton.setBackground(new Color(33, 150, 243));
        addTimerButton.setForeground(Color.WHITE);
        addTimerButton.setFocusPainted(false);
        addTimerButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        addTimerButton.addActionListener(e -> addNewTimer());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addTimerButton);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(new JScrollPane(timersPanel), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addNewTimer() {
        StopwatchPanel newTimer = new StopwatchPanel();
        stopwatches.add(newTimer);
        timersPanel.add(newTimer);
        timersPanel.revalidate();
        timersPanel.repaint();
    }
}