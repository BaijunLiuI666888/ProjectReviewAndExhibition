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
public class boxRoundCorner extends BoxDecorator {

    public boxRoundCorner(Box newBox) {
        super(newBox);
    }

    @Override
    public double getWidth() {
        return baseBox.getWidth();
    }

    @Override
    public double getHeight() {
        return baseBox.getHeight();
    }

    @Override
    public String getDescription() {
        return baseBox.getDescription()+"rounded type";
    }
}
