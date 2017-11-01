/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg261017;
import java.util.ArrayList;
/**
 *
 * @author Ahmet
 */
public class kume {
    ArrayList<Integer> elemanlar;
    
    public kume(){
        this.elemanlar = new ArrayList<Integer>();
    }
    public kume(int[] a){
        this.elemanlar = new ArrayList<Integer>(a.length);
        for(int i=0; i<a.length; i++){
            this.elemanlar.add(a[i]);
        }
    }
    public kume(kume a){
        this.elemanlar = new ArrayList<Integer>(a.elemanlar);
    }
    public void ekle(int a){
        this.elemanlar.add(a);
    }
    public void yazdir(){
        for(int i=0; i<this.elemanlar.size(); i++){
            if(i != this.elemanlar.size()-1){
                System.out.print(this.elemanlar.get(i) + ",");
            }
            else{
                System.out.print(this.elemanlar.get(i) + " ");   
            }
        }
    }
    public boolean denk(kume a){
        return (this.elemanlar.size() == a.elemanlar.size());
    }
    public boolean esit(kume a){
        return (this.elemanlar.equals(a.elemanlar));
    }
    public kume birlesim(kume a){
        kume birlesimKumesi = new kume(this);
        for(int i=0; i<a.elemanlar.size(); i++){
            birlesimKumesi.elemanlar.add(a.elemanlar.get(i));
        }
        return birlesimKumesi;
    }
    public kume kesisim(kume a){
        kume kesisimKumesi = new kume(this);
        kesisimKumesi.elemanlar.retainAll(a.elemanlar);
        return kesisimKumesi;
        
    }
    public kume fark(kume a){
        kume farkKumesi = new kume(this);
        farkKumesi.elemanlar.removeAll(a.elemanlar);
        return farkKumesi;
    }
    public ArrayList<kume>altKumeler(){
        ArrayList<kume>altkume = new ArrayList<kume>();
        for(int i=0; i<(1<<this.elemanlar.size()); i++){
            kume alt = new kume();
            for(int j=0; j<this.elemanlar.size(); j++)
            if((i& (1 << j)) > 0){
                alt.elemanlar.add(this.elemanlar.get(j));
            }
            altkume.add(alt);
        }
        return altkume;
    }
    
}
