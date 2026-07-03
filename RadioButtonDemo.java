// BSE-05-0123/2025 MAXWELL GITHINJI
package radiobuttondemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

class RadioButtonDemo extends JFrame {

    private JLabel imageLabel;

    public RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1, 5, 5));

        JRadioButton birdBtn = new JRadioButton("Bird");
        JRadioButton catBtn = new JRadioButton("Cat");
        JRadioButton dogBtn = new JRadioButton("Dog");
        JRadioButton rabbitBtn = new JRadioButton("Rabbit");
        JRadioButton pigBtn = new JRadioButton("Pig");
        pigBtn.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(birdBtn);
        group.add(catBtn);
        group.add(dogBtn);
        group.add(rabbitBtn);
        group.add(pigBtn);

        radioPanel.add(birdBtn);
        radioPanel.add(catBtn);
        radioPanel.add(dogBtn);
        radioPanel.add(rabbitBtn);
        radioPanel.add(pigBtn);

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        imageLabel.setPreferredSize(new Dimension(180, 180));
        

        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.WHITE);
        
        loadAndSetImage("Pig");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedPet = e.getActionCommand();
                loadAndSetImage(selectedPet);
                JOptionPane.showMessageDialog(RadioButtonDemo.this, 
                    "You selected: " + selectedPet, 
                    "Pet Selection", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        };

        birdBtn.addActionListener(listener);
        catBtn.addActionListener(listener);
        dogBtn.addActionListener(listener);
        rabbitBtn.addActionListener(listener);
        pigBtn.addActionListener(listener);

        mainPanel.add(radioPanel, BorderLayout.WEST);
        mainPanel.add(imageLabel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private void loadAndSetImage(String animalName) {
        String imagePath = "/images/" + animalName.toLowerCase() + ".png";
        URL imageUrl = getClass().getResource(imagePath);
        
        if (imageUrl != null) {

            ImageIcon originalIcon = new ImageIcon(imageUrl);
            Image originalImage = originalIcon.getImage();
            

            int labelWidth = 180;
            int labelHeight = 180;
            Image scaledImage = originalImage.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
            
            imageLabel.setIcon(new ImageIcon(scaledImage));
            imageLabel.setText("");
        } else {
            imageLabel.setIcon(null);
            imageLabel.setText("(Image: " + animalName + ")");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RadioButtonDemo().setVisible(true);
        });
    }
}
