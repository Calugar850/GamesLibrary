package example.T1.controllers;

import example.T1.model.Bill;
import example.T1.model.EnumUsers;
import example.T1.model.User;
import example.T1.repositories.BillRepository;
import example.T1.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
/**
 * Class which map the paths for operation which are executed on bill table
 */
@Component
@RequestMapping("/bills")
public class BillController {
    /*@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    BillRepository billRepository;

    @GetMapping({"allBills"})
    public ModelAndView getAllBills(){
        ModelAndView mav3 = new ModelAndView("index3");
        mav3.addObject("bill", billRepository.findAll());
        return mav3;
    }

    @GetMapping(path = "/findBill/{id}")
    public @ResponseBody
    Optional<Bill> getBill(@PathVariable(value="id") Integer idFactura){
        return billRepository.findById(idFactura);
    }

    @RequestMapping(path="/deleteBill")
    public String deleteById(@RequestParam(value="id") Integer idFactura){
        try{
            billRepository.deleteById(idFactura);
            return "confirm";
        }catch (Exception e){
            e.printStackTrace();
            return "confirm";
        }
    }

    @RequestMapping(path="/addOneBill")
    public String saveFactura(Bill factura){
        try{
            saveBillInDB(factura);
        }catch (Exception e){
            e.printStackTrace();
            return "base3";
        }
        return "base3";
    }

    public void saveBillInDB(Bill factura){
        billRepository.save(factura);
    }

    @GetMapping(path="/updateBill")
    public ModelAndView updateBill(@RequestParam(value="id") Integer idFactura){
        try{
            ModelAndView mav3=new ModelAndView("base3");
            Bill factura=billRepository.findById(idFactura).get();
            mav3.addObject("bill", factura);
            return mav3;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }*/


    BillService billService;

    /**
     *
     * @param billService interface
     */
    public BillController(BillService billService) {
        this.billService = billService;
    }

    /**
     * The function receives a GET request, processes it and gives back a list of Bill as a response.
     * @return List bills
     */
    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills(){
        List<Bill> bills = billService.getBills();
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    /**
     * The function receives a GET request, processes it, and gives back a list of Bill as a response.
     * @param idFactura int
     * @return Bill
     */
    @GetMapping({"/{idFactura}"})
    public ResponseEntity<Bill> getBillByID(@PathVariable Integer idFactura){
        return new ResponseEntity<>(billService.getBillByID(idFactura), HttpStatus.OK);
    }

    /**
     * The function receives a POST request, processes it, creates a new Bill and saves it to the database, and returns a resource link to the created user.
     * @param bill object
     * @return Bill
     */
    @PostMapping
    public ResponseEntity<Bill> createbill(@RequestBody Bill bill){
        Bill bill1 = billService.createBill(bill);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("bill", "bills"+bill1.getIdFactura().toString());
        return new ResponseEntity<>(bill1, httpHeaders, HttpStatus.CREATED);
    }

    /**
     * The function receives a PUT request, updates the Bill with the specified Id and returns the updated Bill
     * @param idFactura integer
     * @param bill object
     * @return Bill
     */
    @PutMapping({"/{idFactura}"})
    public ResponseEntity<Bill> updateBill(@PathVariable("idFactura") Integer idFactura, @RequestBody Bill bill){
        billService.updateBill(idFactura, bill);
        return new ResponseEntity<>(billService.getBillByID(idFactura), HttpStatus.OK);
    }

    /**
     * The function receives a DELETE request, deletes the Bill with the specified Id.
     * @param idFactura integer
     * @return Bill
     */
    @DeleteMapping({"/{idFactura}"})
    public ResponseEntity<Bill> deleteUserByID(@PathVariable("idFactura") Integer idFactura){
        billService.deleteBillByID(idFactura);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * A method for generate a final bill before the purchase of a client
     * @param idUser Integer
     * @param tip EnumUser
     * @return bill
     */
    @PutMapping("/generateBill/{idUser}/{tip}")
    public ResponseEntity<Bill> generateBill(@PathVariable("idUser") Integer idUser, @PathVariable EnumUsers tip){
        return new ResponseEntity<>(billService.generateBill(idUser,tip),HttpStatus.NO_CONTENT);
    }

}
