package example.T1.services;

import example.T1.model.*;
import example.T1.repositories.AdminUserRepository;
import example.T1.repositories.BillRepository;
import example.T1.repositories.PremiumUserRepository;
import example.T1.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * This class implement the logic for operation on bill table from database
 */
@Service
public class BillServiceImpl implements BillService {

    BillRepository billRepository;
    UserRepository userRepository;
    PremiumUserRepository premiumUserRepository;
    AdminUserRepository adminUserRepository;

    /**
     *
     * @param billRepository
     * @param userRepository
     * @param premiumUserRepository
     * @param adminUserRepository
     */
    public BillServiceImpl(BillRepository billRepository, UserRepository userRepository, PremiumUserRepository premiumUserRepository, AdminUserRepository adminUserRepository) {
        this.billRepository = billRepository;
        this.userRepository = userRepository;
        this.premiumUserRepository = premiumUserRepository;
        this.adminUserRepository = adminUserRepository;
    }

    /**
     *
     * @return List bills
     */
    @Override
    public List<Bill> getBills() {
        List<Bill> bills=new ArrayList<>();
        billRepository.findAll().forEach(bills::add);
        return bills;
    }

    /**
     *
     * @param id integer
     * @return Bill
     */
    @Override
    public Bill getBillByID(Integer id) {
        return billRepository.findById(id).get();
    }

    /**
     *
     * @param bill object
     * @return Bill
     */
    @Override
    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }

    /**
     *
     * @param id integer
     * @param bill object
     */
    @Override
    public void updateBill(Integer id, Bill bill) {
        Bill bill1=billRepository.findById(id).get();
        bill1.setNume(bill.getNume());
        bill1.setAdresa(bill.getAdresa());
        bill1.setSuma(bill.getSuma());
        billRepository.save(bill1);
    }

    /**
     *
     * @param id integer
     */
    @Override
    public void deleteBillByID(Integer id) {
        billRepository.deleteById(id);
    }

    /**
     * A method for generate a final bill before the purchase of a client
     * @param idUser Integer
     * @param tip EnumUser
     * @return bill
     */
    @Override
    public Bill generateBill(Integer idUser, EnumUsers tip){
        Bill b = null;
        float s = 0;
        if(tip==EnumUsers.BaseUser){
            BaseUser user1 = userRepository.findById(idUser).get();
            for(Game g: user1.getGames()){
                s+=g.getPret();
            }
            b = new Bill(user1.getUsername(), user1.getAdresa(), s);
            createBill(b);
        }else if(tip==EnumUsers.PremiumUser){
            PremiumUser user1 = premiumUserRepository.findById(idUser).get();
            for(Game g: user1.getGames()){
                s+=g.getPret();
            }
            b = new Bill(user1.getUsername(), user1.getAdresa(), s);
            createBill(b);
        }else if(tip==EnumUsers.AdminUser){
            AdminUser user1 = adminUserRepository.findById(idUser).get();
            for(Game g: user1.getGames()){
                s+=g.getPret();
            }
            b = new Bill(user1.getUsername(), user1.getAdresa(), s);
            createBill(b);
        }
        return billRepository.findById(b.getIdFactura()).get();
    }
}
