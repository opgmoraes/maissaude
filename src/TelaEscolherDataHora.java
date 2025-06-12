import javax.swing.*;
import java.awt.*;

public class TelaEscolherDataHora extends JFrame {
    public TelaEscolherDataHora(String username, String tipoExame) {
        setTitle("Selecionar Data e Hora");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextField tfData = new JTextField("15/07/2025", 10);
        String[] horarios = {"08:00", "09:30", "11:00", "13:30", "15:00"};
        JComboBox<String> comboHora = new JComboBox<>(horarios);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel center = new JPanel();
        center.add(new JLabel("Data:"));
        center.add(tfData);
        center.add(new JLabel("Hora:"));
        center.add(comboHora);

        JPanel bottom = new JPanel();
        JButton btnAvancar = new JButton("Avançar");
        JButton btnVoltar = new JButton("Voltar");

        btnAvancar.addActionListener(e -> {
            String data = tfData.getText();
            String hora = (String) comboHora.getSelectedItem();
            this.dispose();
            new TelaConfirmarExame(username, tipoExame, data, hora).setVisible(true);
        });

        btnVoltar.addActionListener(e -> {
            this.dispose();
            new TelaEscolherTipoExame(username).setVisible(true);
        });

        bottom.add(btnAvancar);
        bottom.add(btnVoltar);

        panel.add(center, BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);
        add(panel);
    }
}
