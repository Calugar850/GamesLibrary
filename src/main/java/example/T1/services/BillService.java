package example.T1.services;

import example.T1.model.Bill;
import example.T1.model.EnumUsers;

import java.util.List;

/**
 * Is an interface for declaration of methods which will applied for bill table
 */
public interface BillService {
    /**
     *
     * @return List bills
     */
    List<Bill> getBills();

    /**
     *
     * @param id integer
     * @return Bill
     */
    Bill getBillByID(Integer id);

    /**
     *
     * @param bill object
     * @return Bill
     */
    Bill createBill(Bill bill);

    /**
     *
     * @param id integer
     * @param bill object
     */
    void updateBill(Integer id, Bill bill);

    /**
     *
     * @param id integer
     */
    void deleteBillByID(Integer id);

    /**
     * A method for generate a final bill before the purchase of a client
     * @param idUser Integer
     * @param tip EnumUser
     * @return bill
     */
    Bill generateBill(Integer idUser, EnumUsers tip);
}
