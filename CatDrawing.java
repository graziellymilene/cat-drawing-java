import javax.swing.*;
import java.awt.*;

public class CatDrawing extends JPanel {

    private int step = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Desenho de um Gato");
        CatDrawing catDrawing = new CatDrawing();
        frame.add(catDrawing);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Animação simples para desenhar o gato
        new Timer(500, e -> {
            catDrawing.step++;
            catDrawing.repaint();
            if (catDrawing.step > 5) {
                ((Timer) e.getSource()).stop(); // Para a animação após desenhar
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCat(g, step);
    }

    private void drawCat(Graphics g, int step) {
        // Desenha a cabeça
        g.setColor(Color.GRAY);
        if (step >= 1) g.fillOval(150, 50, 100, 100); // Cabeça

        // Desenha as orelhas
        g.setColor(Color.GRAY);
        if (step >= 2) {
            int[] xPoints = {150, 130, 170};
            int[] yPoints = {50, 0, 0};
            g.fillPolygon(xPoints, yPoints, 3); // Orelha esquerda
            xPoints = new int[]{250, 230, 270};
            yPoints = new int[]{50, 0, 0};
            g.fillPolygon(xPoints, yPoints, 3); // Orelha direita
        }

        // Desenha os olhos
        g.setColor(Color.WHITE);
        if (step >= 3) {
            g.fillOval(175, 80, 20, 20); // Olho esquerdo
            g.fillOval(205, 80, 20, 20); // Olho direito
        }

        // Desenha as pupilas
        g.setColor(Color.BLACK);
        if (step >= 4) {
            g.fillOval(180, 85, 10, 10); // Pupila esquerda
            g.fillOval(210, 85, 10, 10); // Pupila direita
        }

        // Desenha o nariz
        g.setColor(Color.PINK);
        if (step >= 5) {
            g.fillOval(195, 100, 10, 10); // Nariz
        }
    }
}
