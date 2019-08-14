/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxshop;

/**
 *
 * @author LYJni
 */
public class BoxShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("plain box");
        PlainBox baseBox = new PlainBox();
        System.out.println(baseBox.getWidth());
        System.out.println(baseBox.getHeight());
        System.out.println(baseBox.getDescription());
        System.out.println("round cornered box");
        baseBox= new boxRoundCorner(baseBox);
    }

}
