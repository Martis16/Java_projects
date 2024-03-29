/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pirmas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Martynas
 */
public class Lentele extends javax.swing.JFrame {

    private final ArrayList<Player> Kom;

    /**
     * Creates new form Lentele
     * @param Kom
     */
    public Lentele(java.util.List<pirmas.Player> Kom) {
        initComponents();
        skaičiuoti.setEnabled(false);
        Šalinti.setEnabled(false);
        this.Kom = (ArrayList<Player>) Kom;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        laukas = new javax.swing.JTextArea();
        tekstas = new javax.swing.JLabel();
        IvedimoLaukas = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Ivesti = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        skaičiuoti = new javax.swing.JMenuItem();
        Šalinti = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        laukas.setColumns(20);
        laukas.setRows(5);
        jScrollPane1.setViewportView(laukas);

        tekstas.setText("Įveskite amžių");

        jMenu1.setText("File");

        Ivesti.setText("Ivesti");
        Ivesti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IvestiActionPerformed(evt);
            }
        });
        jMenu1.add(Ivesti);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        skaičiuoti.setText("Skaičiuoti");
        skaičiuoti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skaičiuotiActionPerformed(evt);
            }
        });
        jMenu2.add(skaičiuoti);

        Šalinti.setText("Šalinti");
        Šalinti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ŠalintiActionPerformed(evt);
            }
        });
        jMenu2.add(Šalinti);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tekstas, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(IvedimoLaukas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(tekstas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IvedimoLaukas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private final  ArrayList<Player> Tornadas = new ArrayList<>();;
     private final  ArrayList<Player> Žalgiris = new ArrayList<>();;
      private final  ArrayList<Player> Sujungtas = new ArrayList<>();;
    
    Player A = new Player("Mantas", 18, 180);
    Player B = new Player("Matas", 20, 190);
    Player C = new Player("Nojus", 19, 185);
    Player D = new Player("Rokas", 19, 192);
    
    Player e = new Player("Rytis", 18, 195);
    Player f = new Player("Benas", 18, 184);
    Player g = new Player("Darius", 18, 185);
    Player h = new Player("Giedrius", 18, 192);
    
    
    
    /**
     * Spausdina sąrašą
     * @param Kom sąrašas
     * @param heading pavadinimas
     */
    void Print(ArrayList<Player> Kom, String heading){
        
        laukas.append(heading+ "\n");
        laukas.append("""
                      =============================
                      |    Vardas     |  Amžius      |       Ūgis       |
                      =============================
                      """);
              for (int i = 0; i < Kom.size(); i++) {
                  Player pl = Kom.get(i); 
                  laukas.append(pl.toString());
                  laukas.append("\n");
                  
              }
               laukas.append("=============================\n\n\n");
     }
    /**
     * Randa vidutinį amžių
     * @param Kom sąrašas
     * @return vidutinį amžių
     */
    static double AvgAge(ArrayList<Player>Kom){
        double a = 0;
        double avg = 0;
        for (int i = 0; i < Kom.size(); i++) {
            a = a + Kom.get(i).getAge();
        }
        if (Kom.size() > 0) {
            avg = a/Kom.size();
        }
        return avg;
    }
    /**
     * Randa vidutinį ūgį 
     * @param Kom sąrašas
     * @return vidutinį ūgį
     */
        static double AvgHeight(ArrayList<Player>Kom){
        double a = 0;
        double avg = 0;
        for (int i = 0; i < Kom.size(); i++) {
            a = a + Kom.get(i).getHeight();
        }
        if (Kom.size() > 0) {
            avg = a/Kom.size();
        }
        return avg;
    }
     /**
      * Sujungia dviejų sąrašų žaidėjus kurių ūgiai didesni už komandos vidurkį
      * @param t pirmas sąrašas 
      * @param t2 antras sąrašas
      */
    static void ConnectByHeight(ArrayList<Player> t, ArrayList<Player> t2){
     for (int i = 0; i < t.size(); i++)
     {
         if (t.get(i).getHeight() > AvgHeight(t))
        {
        Player plr = new Player(t.get(i).getName(),
        t.get(i).getAge(), t.get(i).getHeight());
         t2.add(plr);
        }
    }
 }

      
    
    private void IvestiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IvestiActionPerformed
        // TODO add your handling code here:
        
        skaičiuoti.setEnabled(true);
        Ivesti.setEnabled(false);        
        Tornadas.add(A);
        Tornadas.add(B);
        Tornadas.add(C);
        Tornadas.add(D);
       Žalgiris.add(e);
        Žalgiris.add(f);
        Žalgiris.add(g);
        Žalgiris.add(h);
        Print(Tornadas, "Tornadas");
        Print(Žalgiris, "Žalgiris");
        
    }//GEN-LAST:event_IvestiActionPerformed

    private void skaičiuotiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skaičiuotiActionPerformed
        // TODO add your handling code here:
        Šalinti.setEnabled(true);
        skaičiuoti.setEnabled(false);
        ConnectByHeight(Tornadas, Sujungtas);
        ConnectByHeight(Žalgiris, Sujungtas);
        Print(Sujungtas, "Žaidėjai aukštesni už ūgio vidurkį");
        Collections.sort(Sujungtas);
        Print(Sujungtas, "Surikiuotas sąrašas");
        laukas.append("Vidutinis Tornado krepšininkų amžius: "+ AvgAge(Tornadas)+ "\n");
        laukas.append("Vidutinis Tornado krepšininkų ūgis: "+ AvgHeight(Tornadas)+ "\n\n");
         laukas.append("Vidutinis Žalgirio krepšininkų amžius: "+ AvgAge(Žalgiris)+ "\n");
         laukas.append("Vidutinis Žalgirio krepšininkų ūgis: "+ AvgHeight(Žalgiris)+ "\n\n");
        
    }//GEN-LAST:event_skaičiuotiActionPerformed

    private void ŠalintiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ŠalintiActionPerformed
        // TODO add your handling code here:
        
        int age = Integer.parseInt(IvedimoLaukas.getText());        
        Sujungtas.removeIf(item -> item.getAge() > age);
        if (Sujungtas.isEmpty()) {
            laukas.append("Visi žaidėjai pašalinti");
        }
        else
            Print(Sujungtas, "Sąrašas po pašalinimo");
    }//GEN-LAST:event_ŠalintiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lentele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lentele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lentele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lentele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Lentele(null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IvedimoLaukas;
    private javax.swing.JMenuItem Ivesti;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea laukas;
    private javax.swing.JMenuItem skaičiuoti;
    private javax.swing.JLabel tekstas;
    private javax.swing.JMenuItem Šalinti;
    // End of variables declaration//GEN-END:variables
}
