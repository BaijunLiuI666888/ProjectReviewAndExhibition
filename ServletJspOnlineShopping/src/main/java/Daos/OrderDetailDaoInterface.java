/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.OrderProduct;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LYJni
 */
public interface OrderDetailDaoInterface {
        public int addToDetail(int orderID, int productId, int quantity);
        
          public List<OrderProduct> AllInOrderByOrderId(int id);
           public int addDetail(Map items, int orderid);
}
