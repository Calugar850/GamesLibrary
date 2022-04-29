package example.T1.controllersTest;
import example.T1.controllers.BillController;
import example.T1.model.Bill;
import example.T1.model.EnumUsers;
import example.T1.services.BillService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest
public class BillControllerTest {
    @InjectMocks
    BillController billController;

    @Mock
    BillService billService;

    /**
     * Test to get all objects
     */
    @Test
    public void testFindAll() {
        Bill bill1 = new Bill("Andrei","Str. Trecutului 35",20);
        Bill bill2 = new Bill("Stefan","Str. Trecutului 350",200);
        List<Bill> billList = new ArrayList<>();
        billList.add(bill1);
        billList.add(bill2);

        when(billService.getBills()).thenReturn(billList);

        ResponseEntity<List<Bill>> result = billController.getAllBills();

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getNume()).isEqualTo(bill1.getNume());
        assertThat(result.getBody().get(1).getNume()).isEqualTo(bill2.getNume());
    }

    /**
     * Test for get a single object by id of item
     */
    @Test
    public void getBillbyIdTest(){
        Bill bill1 = new Bill("Andrei","Str. Trecutului 35",20);

        when(billService.getBillByID(1)).thenReturn(bill1);

        ResponseEntity<Bill> result = billController.getBillByID(1);

        assertThat(result.getBody().getNume()).isEqualTo(bill1.getNume());
    }

    /**
     * Test of creating an object
     */
    @Test
    public void createBillTest(){
        Bill bill1 = new Bill("Andrei","Str. Trecutului 35",20);
        bill1.setIdFactura(1);
        when(billService.createBill(bill1)).thenReturn(bill1);

        ResponseEntity<Bill> result = billController.createbill(bill1);

        assertThat(result.getBody().getNume()).isEqualTo(bill1.getNume());
    }

    /**
     * Testing for delete an object by id of object
     */
    @Test
    public void deleteBillIdTest(){
        Bill bill1 = new Bill("Andrei","Str. Trecutului 35",20);
        billService.deleteBillByID(1);

        ResponseEntity<Bill> result = billController.deleteUserByID(1);

        assertThat(result.getStatusCode().toString()).isEqualTo("204 NO_CONTENT");
    }

    /**
     * Test for update an object properties
     */
    @Test
    public void updateBillTest(){
        Bill bill1 = new Bill("Andrei","Str. Trecutului 35",20);
        billService.updateBill(1,bill1);

        ResponseEntity<Bill> result = billController.updateBill(1,bill1);

        assertThat(result.getStatusCode().toString()).isEqualTo("200 OK");
    }

    /**
     * Test for generating a bill
     */
    @Test
    public void generateBillTest(){
        Bill bill1 = new Bill("Andrei","Str. Trecutului 35",20);
        bill1.setIdFactura(1);
        when(billService.generateBill(1, EnumUsers.BaseUser)).thenReturn(bill1);

        ResponseEntity<Bill> result = billController.generateBill(1,EnumUsers.BaseUser);

        assertThat(result.getStatusCode().toString()).isEqualTo("204 NO_CONTENT");
    }

}
