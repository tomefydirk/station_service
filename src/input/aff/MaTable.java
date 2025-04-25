package aff;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MaTable extends JPanel{
    JTable t;
   public void setT(JTable t) {
        this.t = t;
    }
   public MaTable(String[][] donnee,String[] colone){
            t=new JTable(donnee,colone);
            JScrollPane sp=new JScrollPane(t);
            add(sp);
   }
  public MaTable(){
          JScrollPane sp=new JScrollPane(t);
          add(sp);
   }

}
