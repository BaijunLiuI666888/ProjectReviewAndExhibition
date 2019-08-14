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
public abstract class BoxDecorator implements Box {
    protected Box baseBox;
     public BoxDecorator (Box newBox){
     this.baseBox=newBox;
     }
    @Override
     public double getWidth(){
         return baseBox.getWidth()*2;
     }
    @Override
     public double getHeight(){
         return baseBox.getHeight()*2;        
     }
    @Override
     public String getDescription(){
         return baseBox.getDescription()+"de part";
     }
}
