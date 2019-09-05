/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

/**
 *
 * @author Danielhua
 */
public class CommandFactory {
    
      public static Command createCommand(String action) {
    
        Command command = null;

     
        if (action != null) {
    
            switch (action) {
            // all the actions when buttons/input submit like a switch
              case "register":
                    command = new RegisterCommand();
                  break;
                case "loggin":
                  command = new LogginCommand();
                    break;
          
                   case "addCategory":
                command = new AddCategoryCommand();
                    break;
                  case "editUser":
                    command = new UserEditCommand();
                    break;
                     case "AdminEditUser":
                    command = new AdminUserEditCommand();
                    break;
                      case "AddCart":
                    command = new AddCartCommand();
                    break;
                 case "changeLanguage":
                 command = new ChangeLanguageCommand();
                   break;
                      case "DeleteProduct":
                      command = new DeleteProductCommand();
                      break;
                      
                      
                   case "DeleteUser":
                     command = new DeleteUserCommand();
                   break;
              case "checkout":
                    command = new CheckOutCommand();
                    break;
                case "OrderPlace":
                    command = new OrderPlacedCommand();
                    break;
                case "DeleteCartItem":
                    command = new DeleteCartItemCommand();
                    break;
                    default:
                    command = new NoValidActionCommand();
                    break;
                     case "AddWishlist":
                     command = new AddWishlistCommand();
                    break;
            }

        } else {
          
            command = new NoActionSuppliedCommand();
        }

        return command;
    }

}


