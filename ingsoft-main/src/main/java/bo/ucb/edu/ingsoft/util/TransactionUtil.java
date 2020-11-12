package bo.ucb.edu.ingsoft.util;

import bo.ucb.edu.ingsoft.model.Transaction;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class TransactionUtil {

    //Creando la funcion de tipo Transaction createTransaction para crear una transaccion nueva
    //con los datos de auditoria que son el txId, txUserId, txHost, txDate, txUpdate
    public static Transaction createTransaction(HttpServletRequest request) {
        Transaction transaction = new Transaction();
        transaction.setTxDate(new Date()); // Fecha Actual
        transaction.setTxUpdate(new Date());
        transaction.setTxHost(request.getRemoteHost()); // Direccion Ip
        //transaction.setTxUserId(request.getUserPrincipal().getName()); //TODO fix username instead of userId
        transaction.setTxId(0); // Id de la transaccion
        transaction.setTxUserId(0); // Id del usuario que hizo la transaccion
        return transaction;
    }
}
