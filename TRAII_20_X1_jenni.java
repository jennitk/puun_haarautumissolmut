/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traii_20_x1_jenni;

import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;

import java.util.HashSet;
import java.util.Set;

public class TRAII_20_X1_jenni implements TRAII_20_X1 {

    /**
     * Puun haarautumissolmut. Palauttaa joukkona kaikki ne binĆ¤Ć¤ripuun T
     * solmut joilla on yksi tai kaksi lasta.
     *
     * ITSEARVIOINTI:
     * Aikavaativuus O(n), kun n on parametrina saadun puun solmujen määrä
     * O(n), koska kaikki solmut käydään läpi kerran rekursiivisesti
     * 
     * @param T syĆ¶tepuu
     * @return haarautusmissolmujen joukko
     */
    @Override
    public <E> Set<BTreeNode<E>> haarautumisSolmut(BTree<E> T) {
        //alustetaan palautettava HashSet
        //O(1)
        Set<BTreeNode<E>> hsj = new HashSet<>();
        //alustetaan muuttujaan x parametrina saadun binääripuun juuri
        //O(1)
        BTreeNode<E> x = T.getRoot();
        //kutsutaan onkoLapsia() funktiota ja viedään sinne palautettava HashSet ja juuri
        //sijoitetaan funktion palautusarvo palautettavaan HashSetiin
        //O(n), koska funktiota kutsutaan rekursiivisesti käyden läpi KAIKKI solmut
        hsj = onkoLapsia(hsj, x);
        //palautetaan päämetodissa HashSet hsj
        //O(1)
        return hsj;
    }

    public <E> Set<BTreeNode<E>> onkoLapsia(Set<BTreeNode<E>> hsj, BTreeNode<E> x) {
        //funktio onkoLapsia toimii rekursiivisesti, se saa parametrinaan palautettavan 
        //HashSetin ja ensimmäisellä kutsulla juuren, myöhemmissä kutsuissa edellisen 
        //kutsun solmun lapsen
        
        //jos parametrina saatu solmu erisuuri kuin null
        //O(1)
        if (x != null) {
            //jos solmun vasen lapsi erisuuri kuin null
            //O(1)
            if (x.getLeftChild() != null) {
                //lisätään solmu palautettavaan HashSetiin
                //O(1)
                hsj.add(x);
                //kutsutaan onkoLapsia() funktiota rekursiivisesti 
                //tämän suorituksen solmun vasemmalla lapsella
                onkoLapsia(hsj, x.getLeftChild());
            }
            //jos solmun oikea lapsi erisuuri kuin null
            //O(1)
            if (x.getRightChild() != null) {
                //lisätään solmu palautettavaan HashSetiin
                //O(1)
                hsj.add(x);
                //kutsutaan onkoLapsia() funktiota rekursiivisesti 
                //tämän suorituksen solmun oikealla lapsella
                onkoLapsia(hsj, x.getRightChild());
            }
        }
        //palautetaan HashSet
        //O(1)
        return hsj;
    }
}
