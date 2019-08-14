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
public class PlainBox implements Box{

    @Override
    public double getWidth() {
       return 5;
    }

    @Override
    public double getHeight() {
       return 6;
    }

    @Override
    public String getDescription() {
        return "basic box";
    }
    
}
