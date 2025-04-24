package aff;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MaTable extends JPanel{
    JTable t;
   MaTable(){
            String[][] donnee={
                {"1","Gerard","bleu"},
                {"2","Claude","bleu"}
            };
            String[] colone={
                "id","nom","couleur"
            };
            t=new JTable(donnee,colone);
            JScrollPane sp=new JScrollPane(t);
            add(sp);
   }
   public void paint(){
       new MaTable();
      } 
}
