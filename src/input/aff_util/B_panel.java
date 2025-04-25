package aff_util;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import aff.Formulaire;
import aff_button.ButtonCount;
import aff_button.ButtonCuve;
import aff_button.ButtonFinance;
import aff_button.ButtonSave;
import fonction.Station;

public class B_panel extends JPanel{
    Station s;
    public static JPanel make_bouton(JButton b){
        JPanel p=new JPanel();
        p.add(b);
        return p;
     
    }
    void make_text_field(JTextField a){
        
        JPanel p=new JPanel();
        JLabel l=new JLabel("Nom de la sauvegarde : ");
        p.add(l);
        p.add(a);
        add(p);
    }
    void make_label(JLabel l){
        JPanel p=new JPanel();
        p.add(l);
        add(p);
    }
    void make_all_bouton(Formulaire f,JTextField a){
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(4, 0));
        p.add(make_bouton(new ButtonSave(f,a)));
        p.add(make_bouton(new ButtonCount(a)));
        p.add(make_bouton(new ButtonCuve(a,s)));
        p.add(make_bouton(new ButtonFinance(a)));
        add(p);
    }
    public B_panel(Formulaire f,Station s){
        super();
        this.s=s;
        setLayout(new GridLayout(6, 1));
        JTextField a=new JTextField("default_save",10);    
        make_text_field(a);
        make_all_bouton(f, a);
    }
}
