package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.UserBl;

import bo.ucb.edu.ingsoft.dto.CategoryRequest;
import bo.ucb.edu.ingsoft.dto.UserRequest;
import bo.ucb.edu.ingsoft.model.User;

import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/user")
public class UserApi {
    private UserBl userBl;

    //Constructor de la clase UserApi recibe un parametro de tipo UserBl
    @Autowired
    public UserApi(UserBl userBl) {
        this.userBl = userBl;
    }

    //Metodo que obtiene un usuario por el ID a traves del
    // requestMethod GET con los parametros para la vista del usuario de
    // tipo admin
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User findUserById(@RequestParam Integer userId, HttpServletRequest request) {

        return userBl.findUserById(userId);
    }

    @RequestMapping(path="/allUsers",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserRequest> allusers(HttpServletRequest request) {
        List<UserRequest> user=userBl.allusers();
        return user;
    }

    //Metodo que obtiene un usuario por el ID a traves del
    // requestMethod GET con los parametros para la vista del usuario de
    // tipo cliente
    @RequestMapping(value = "/userRequest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserRequest findAccountTypeById(@RequestParam Integer userId, HttpServletRequest request) {

        return userBl.findUserReqById(userId);
    }

    //Inicio de sesion
    @RequestMapping(value = "/userRequest/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer findUserByEmailPassword(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {

        return userBl.findUserByEmailPassword(email, password);
    }

    //Obtener ReceiverId
    @RequestMapping(value = "/receiverid", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer findReceiverUser(@RequestParam Integer userId, Integer chatId, HttpServletRequest request) {

        return userBl.findReceiverUser(userId, chatId);
    }

    //Obtener userType
    @RequestMapping(value = "/userType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String findUserTypeByEmailPassword(@RequestParam String email, @RequestParam String password, HttpServletRequest request) {

        return userBl.findUserTypeByEmailPassword(email, password);
    }

    //Metodo que agrega un usuario a traves del requestMethod PUT
    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public User insertUser(@RequestBody User user, HttpServletRequest request) {
        TransactionUtil transactionUtil= new TransactionUtil();
        Transaction transaction = transactionUtil.createTransaction(request);
        userBl.insertUser(user,transaction);
        return  user;
    }

    //Metodo que actualiza un usuario a traves del requestMethod DELETE es decir cambia el status a 0
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user, HttpServletRequest request) {
        TransactionUtil transactionUtil= new TransactionUtil();
        Transaction transaction = transactionUtil.createTransaction(request);
        userBl.updateUser(user,transaction);
        return  user;
    }

    //Metodo que elimina un usuario a traves del requestMethod PUT
    @RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User deleteUser(@RequestBody User user, HttpServletRequest request) {
        return userBl.deleteUser(user);
    }


}
