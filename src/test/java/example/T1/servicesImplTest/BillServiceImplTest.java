package example.T1.servicesImplTest;


import example.T1.model.BaseUser;
import example.T1.model.Bill;
import example.T1.repositories.BillRepository;
import example.T1.services.BillServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BillServiceImplTest {

    @InjectMocks
    BillServiceImpl billService;

    @Mock
    private BillRepository billRepository;

    /**
     * Testing to retrieve an object with a specific id
     */
    @Test
    public void getBillIdTest(){
        Bill bill = new Bill("Andrei","Str. Trecutului 35",20);
        bill.setIdFactura(1);

        when(billRepository.findById(1)).thenReturn(java.util.Optional.of(bill));

        Bill result = billService.getBillByID(1);

        assertThat(result.getNume()).isEqualTo(bill.getNume());
    }

    /**
     * Testing to retrieve all objects of this type
     */
    @Test
    public void getAllBillsTest(){
        Bill bill1 = new Bill("Andrei","Str. Trecutului 35",20);
        Bill bill2 = new Bill("Stefan","Str. Trecutului 350",200);
        List<Bill> billList = new ArrayList<>();
        billList.add(bill1);
        billList.add(bill2);

        when(billRepository.findAll()).thenReturn(billList);

        List<Bill> result = billService.getBills();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getNume()).isEqualTo(bill1.getNume());
        assertThat(result.get(1).getNume()).isEqualTo(bill2.getNume());
    }

    /**
     * Testing for creating an object
     */
    @Test
    public void createBillTest(){
        Bill bill = new Bill("Andrei","Str. Trecutului 35",20);
        bill.setIdFactura(1);

        when(billRepository.save(any())).thenReturn(bill);

        Bill result = billService.createBill(bill);

        assertThat(result.getNume()).isEqualTo(bill.getNume());
    }

    /**
     * Test for delete an object with a specific Id
     */
    @Test
    public void deleteBillIdTest(){
        Bill bill = new Bill("Andrei","Str. Trecutului 35",20);
        bill.setIdFactura(1);
        billService.deleteBillByID(1);

        assertThat(bill.getNume()).isEqualTo("Andrei");
    }

    /**
     * Testing for updating an objects properties
     */
    @Test
    public void updateBillTest(){
        Bill bill = new Bill("Andrei","Str. Trecutului 35",20);
        bill.setIdFactura(1);
        billRepository.save(bill);
        bill.setNume("Nume2");

        assertThat(bill.getNume()).isEqualTo("Nume2");
    }

    /**
     * Testing for generating a bill for an user
     */
    @Test
    public void generateBillTest(){
        Bill bill1 = new Bill("Andrei","Str. Trecutului 35",20);
        bill1.setIdFactura(2);
        BaseUser baseUser = new BaseUser("Andrei","andrei@gmail.com","dsadsad","Strada Trecutului 35",0);
        baseUser.setIdUser(1);

        when(billRepository.save(any())).thenReturn(bill1);

        Bill result = billService.createBill(bill1);

        assertThat(result.getNume()).isEqualTo(bill1.getNume());
    }

}
