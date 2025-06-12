import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MaisInformacoes extends JFrame {
    private final CardLayout cardLayout;
    private final JPanel cardPanel;
    private final String username;
    private final String[][] especialidades = {
            {"Dr. João", "12345", "Cardiologia"},
            {"Dra. Marina", "12346", "Cardiologia"},
            {"Dra. Ana", "54321", "Pediatria"},
            {"Dr. Fabrício", "54322", "Pediatria"},
            {"Dr. Carlos", "67890", "Dermatologia"},
            {"Dra. Camila", "67891", "Dermatologia"},
            {"Dr. José", "11111", "Neurologia"},
            {"Dra. Fernanda", "11112", "Neurologia"},
            {"Dr. Pedro", "22222", "Ortopedia"},
            {"Dra. Maria", "22223", "Ortopedia"},
            {"Dr. Mateus", "33333", "Ginecologia"},
            {"Dra. Juliana", "33334", "Ginecologia"},
            {"Dr. Tiago", "44444", "Oftalmologia"},
            {"Dra. Letícia", "44445", "Oftalmologia"},
            {"Dr. Fábio", "55555", "Psiquiatria"},
            {"Dra. Vitória", "55556", "Psiquiatria"},
            {"Dr. Izaque", "66666", "Endocrinologia"},
            {"Dra. Sara", "66667", "Endocrinologia"}
    };

    public MaisInformacoes(String username) {
        this.username = username;
        setTitle("Mais Informações");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        criarMenuPrincipal();
        criarTelaContatos();
        criarTelaQuemSomos();
        criarTelaEspecialidades();
        criarTelaConvenios();

        add(cardPanel);
        setVisible(true);
    }

    private void criarMenuPrincipal() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("Clínica Mais Saúde", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);
        headerPanel.add(titleLabel);

        JPanel buttonsPanel = new JPanel(new GridLayout(4, 1, 20, 20)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                int width = getWidth();
                int height = getHeight();
                Color color1 = new Color(230, 240, 255);
                Color color2 = new Color(180, 200, 240);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, width, height);
            }
        };
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        buttonsPanel.setOpaque(false);

        String[] opcoes = {"Contatos", "Quem Somos", "Especialidades", "Convênios"};
        for (String opcao : opcoes) {
            JButton button = new JButton(opcao);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.setBackground(new Color(245, 250, 255));
            button.setForeground(Color.BLACK);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            button.setPreferredSize(new Dimension(300, 40));
            button.addActionListener(e -> cardLayout.show(cardPanel, opcao));
            buttonsPanel.add(wrapInPanel(button));
        }

        JButton backButton = new JButton("Voltar para Home");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        backButton.setPreferredSize(new Dimension(200, 35));
        backButton.addActionListener(e -> voltarParaHome());

        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(buttonsPanel, BorderLayout.CENTER);
        panel.add(wrapInPanel(backButton), BorderLayout.SOUTH);

        cardPanel.add(panel, "Menu");
    }

    private JPanel wrapInPanel(JComponent component) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0, 0));
        panel.add(component);
        return panel;
    }

    private void criarTelaContatos() {
        JPanel panel = criarTelaBase("Contatos");

        JPanel contentPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        String[] contatos = {
                "Telefone: (11) 1234-5678",
                "WhatsApp: (11) 98765-4321",
                "Email: contato@clinicamaissaude.com.br",
                "Endereço: Av. Principal, 1234 - Centro",
                "Horário: Segunda a Sexta, 8h às 18h"
        };

        for (String contato : contatos) {
            JLabel label = new JLabel(contato, JLabel.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 16));
            contentPanel.add(label);
        }

        panel.add(contentPanel, BorderLayout.CENTER);
        cardPanel.add(panel, "Contatos");
    }

    private void criarTelaQuemSomos() {
        JPanel panel = criarTelaBase("Quem Somos");

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setText("Fundada em 2010, a Clínica Mais Saúde tem como objetivo oferecer atendimento médico \n"
                + "de qualidade com profissionais altamente qualificados.\n\n"
                + "Nossa missão é proporcionar saúde e bem-estar através de um atendimento humanizado \n"
                + "e com tecnologia de ponta.\n\n"
                + "Valores: Ética, transparência e compromisso com a saúde dos nossos pacientes.");

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        cardPanel.add(panel, "Quem Somos");
    }

    private void criarTelaEspecialidades() {
        JPanel panel = criarTelaBase("Especialidades");

        Map<String, StringBuilder> especialidadesMap = new HashMap<>();

        for (String[] medico : especialidades) {
            String nome = medico[0];
            String crm = medico[1];
            String especialidade = medico[2];

            especialidadesMap.putIfAbsent(especialidade, new StringBuilder());
            especialidadesMap.get(especialidade)
                    .append("Médico - ").append(nome).append(" CRM ").append(crm).append("\n");
        }

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        for (Map.Entry<String, StringBuilder> entry : especialidadesMap.entrySet()) {
            JLabel especialidadeLabel = new JLabel(entry.getKey());
            especialidadeLabel.setFont(new Font("Arial", Font.BOLD, 18));
            especialidadeLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 5, 0));
            especialidadeLabel.setForeground(Color.BLACK);

            JTextArea medicosTextArea = new JTextArea(entry.getValue().toString());
            medicosTextArea.setEditable(false);
            medicosTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
            medicosTextArea.setBackground(contentPanel.getBackground());

            contentPanel.add(especialidadeLabel);
            contentPanel.add(medicosTextArea);
            contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        panel.add(new JScrollPane(contentPanel), BorderLayout.CENTER);
        cardPanel.add(panel, "Especialidades");
    }

    private void criarTelaConvenios() {
        JPanel panel = criarTelaBase("Convênios");

        JPanel contentPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        String[] convenios = {
                "• Saúde Total",
                "• Bem Estar Saúde",
                "• Med Mais",
                "• Plano Saúde Fácil",
                "• Vida Plena"
        };

        for (String conv : convenios) {
            JLabel label = new JLabel(conv);
            label.setFont(new Font("Arial", Font.PLAIN, 16));
            contentPanel.add(label);
        }

        panel.add(contentPanel, BorderLayout.CENTER);
        cardPanel.add(panel, "Convênios");
    }

    private JPanel criarTelaBase(String titulo) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        JButton backButton = new JButton("Voltar");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "Menu"));

        JLabel titleLabel = new JLabel(titulo, JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(Color.BLACK);

        headerPanel.add(backButton, BorderLayout.WEST);
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        panel.add(headerPanel, BorderLayout.NORTH);
        return panel;
    }

    private void voltarParaHome() {
        this.dispose();
        new TelaHome(username).setVisible(true);
    }
}
