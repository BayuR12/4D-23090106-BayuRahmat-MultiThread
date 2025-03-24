package com.example.stopwatch;

import javax.swing.*;
import java.awt.*;

public class StopwatchPanel extends JPanel {
    private final JLabel timeLabel;
    private final Stopwatch stopwatch;

    public StopwatchPanel() {
        setLayout(new FlowLayout());
        timeLabel = new JLabel("00:00:00");
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JButton resetButton = new JButton("Reset");

        // Gunakan method terpisah agar stopwatch sudah terinisialisasi
        stopwatch = new Stopwatch(this::updateTimeLabel);

        startButton.addActionListener(e -> stopwatch.start());
        stopButton.addActionListener(e -> stopwatch.stop());
        resetButton.addActionListener(e -> stopwatch.reset());

        add(timeLabel);
        add(startButton);
        add(stopButton);
        add(resetButton);
    }

    // Method untuk memperbarui tampilan waktu
    private void updateTimeLabel() {
        SwingUtilities.invokeLater(() -> timeLabel.setText(formatTime(stopwatch.getElapsedTime())));
    }

    private String formatTime(long millis) {
        long seconds = millis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        return String.format("%02d:%02d:%02d", hours, minutes % 60, seconds % 60);
    }
}