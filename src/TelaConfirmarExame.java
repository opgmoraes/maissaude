import javax.swing.*;
import java.awt.*;

public class TelaConfirmarExame extends JFrame {
    public TelaConfirmarExame(String username, String tipo, String data, String hora) {
        setTitle("Confirmar Solicitação");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel infoPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel lblTitulo = new JLabel("Confirmar Solicitação", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        infoPanel.add(lblTitulo);

        JLabel lblTipo = new JLabel("Tipo: " + tipo);
        JLabel lblData = new JLabel("Data: " + data);
        JLabel lblHora = new JLabel("Hora: " + hora);

        infoPanel.add(lblTipo);
        infoPanel.add(lblData);
        infoPanel.add(lblHora);

        panel.add(infoPanel, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnCancelar = new JButton("Cancelar");

        btnConfirmar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Exame solicitado com sucesso!");
            this.dispose();
            new TelaHome(username).setVisible(true);
        });

        btnCancelar.addActionListener(e -> {
            this.dispose();
            new TelaHome(username).setVisible(true);
        });

        bottom.add(btnConfirmar);
        bottom.add(btnCancelar);

        panel.add(bottom, BorderLayout.SOUTH);
        add(panel);
    }
}
