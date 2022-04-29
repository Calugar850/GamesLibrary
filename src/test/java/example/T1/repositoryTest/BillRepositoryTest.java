package example.T1.repositoryTest;

import example.T1.model.Bill;
import example.T1.repositories.BillRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class BillRepositoryTest {

    @Mock
    BillRepository billRepository;

    /**
     * Testing repository for find an object
     */
    @Test
    public void getByIdBillTest(){
        Bill bill = new Bill("Andrei","Strada Trecutului 33", 20);
        bill.setIdFactura(1);

        when(billRepository.findById(1)).thenReturn(java.util.Optional.of(bill));

        Bill result = billRepository.findById(1).get();
        assertThat(result.getNume()).isEqualTo(bill.getNume());
    }

    /**
     * Testing for getting all object from the table
     */
    @Test
    public void findAllBillsTest(){
        Bill bill1 = new Bill("Andrei","Str. Trecutului 35",20);
        Bill bill2 = new Bill("Stefan","Str. Trecutului 350",200);
        List<Bill> billList = new ArrayList<>();
        billList.add(bill1);
        billList.add(bill2);

        when(billRepository.findAll()).thenReturn(billList);

        List<Bill> result = (List<Bill>)billRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getNume()).isEqualTo(bill1.getNume());
        assertThat(result.get(1).getNume()).isEqualTo(bill2.getNume());
    }

    /**
     * Testing repository for delete an object
     */
    @Test
    public void deleteByIdBillTest(){
        Bill bill = new Bill("Andrei","Strada Trecutului 33", 20);
        bill.setIdFactura(1);
        billRepository.deleteById(1);

        Optional<Bill> result = billRepository.findById(1);

        assertThat(result.isEmpty()).isEqualTo(true);
    }

    /**
     * Testing for saving an object in the table
     */
    @Test
    public void saveBaseUserTest(){
        Bill bill = new Bill("Andrei","Strada Trecutului 33", 20);
        bill.setIdFactura(1);
        when(billRepository.save(any())).thenReturn(bill);

        Bill result = billRepository.save(bill);

        assertThat(result.getNume()).isEqualTo(bill.getNume());
    }
}
