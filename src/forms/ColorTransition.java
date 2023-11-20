/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author karam
 */
public class ColorTransition {
    
    private static final int STEPS = 20;
        private final JLabel label;
        private final Color startBackgroundColor;
        private final Color endBackgroundColor;
        private final Color startForegroundColor;
        private final Color endForegroundColor;

        public ColorTransition(JLabel label, Color startBackgroundColor, Color endBackgroundColor, Color startForegroundColor, Color endForegroundColor) {
            this.label = label;
            this.startBackgroundColor = startBackgroundColor;
            this.endBackgroundColor = endBackgroundColor;
            this.startForegroundColor = startForegroundColor;
            this.endForegroundColor = endForegroundColor;
        }

        public void execute() {
            Timer timer = new Timer(200 / STEPS, new ActionListener() {
                private int step = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (step < STEPS) {
                        float ratio = (float) step / STEPS;
                        int bgR = (int) (startBackgroundColor.getRed() + ratio * (endBackgroundColor.getRed() - startBackgroundColor.getRed()));
                        int bgG = (int) (startBackgroundColor.getGreen() + ratio * (endBackgroundColor.getGreen() - startBackgroundColor.getGreen()));
                        int bgB = (int) (startBackgroundColor.getBlue() + ratio * (endBackgroundColor.getBlue() - startBackgroundColor.getBlue()));
                        label.setBackground(new Color(bgR, bgG, bgB));

                        int fgR = (int) (startForegroundColor.getRed() + ratio * (endForegroundColor.getRed() - startForegroundColor.getRed()));
                        int fgG = (int) (startForegroundColor.getGreen() + ratio * (endForegroundColor.getGreen() - startForegroundColor.getGreen()));
                        int fgB = (int) (startForegroundColor.getBlue() + ratio * (endForegroundColor.getBlue() - startForegroundColor.getBlue()));
                        label.setForeground(new Color(fgR, fgG, fgB));

                        step++;
                    } else {
                        ((Timer) e.getSource()).stop();
                    }
                }
            });
            timer.start();
        }
    
}
