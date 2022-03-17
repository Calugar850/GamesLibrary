package example.T1.services;

import example.T1.model.Bill;
import example.T1.repositories.BillRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * This class implement the logic for operation on bill table from database
 */
@Service
public class BillServiceImpl implements BillService {

    BillRepository billRepository;

    /**
     *
     * @param billRepository interface
     */
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
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
}
