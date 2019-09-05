/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Cart;
import Dtos.CartProduct;
import java.util.List;

/**
 *
 * @author d00172193
 */
public interface CartDaoInterface {
    public int addToCart(int userId,int productId, int quantity);
    public List<CartProduct> AllInCartByUserId(int id);
              public int EmptyCart(int id) ;
              public int deleteCartItem(int productId,int userId);

}
