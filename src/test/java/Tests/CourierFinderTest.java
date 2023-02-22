package Tests;

import SweetTreats.Courier;
import SweetTreats.ListOfCouriers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class CourierFinderTest {
    private Courier bobby_bikes;
    private Courier martin_Moves;
    private Courier geoff_Go_Go;
    private ListOfCouriers listOfCouriersTest;

    @BeforeEach
    void setUp() {
        bobby_bikes = new Courier("Bobby Bikes", "9:00", "13:00", 5.0, true, 1.75);
        martin_Moves = new Courier("Martin Moves", "9:00", "17:00", 3, false, 1.50);
        geoff_Go_Go = new Courier("Geoff Go Go", "10:00", "16:00", 4.0, true, 2.00);
        listOfCouriersTest = new ListOfCouriers();
    }

    //Refrigeration criteria tests
    @Test
    public void When_Refrigeration_Is_Required_Return_Bobby_And_Geoff() {
        List<Courier> expected_Refrigerated_Couriers = new ArrayList<>();
        expected_Refrigerated_Couriers.add(bobby_bikes);
        expected_Refrigerated_Couriers.add(geoff_Go_Go);

        //Assertions
        Assertions.assertEquals(expected_Refrigerated_Couriers, listOfCouriersTest.refrigerationCriteria(true));

    }
    @Test
    public void When_Refrigeration_Is_NOT_Required_Return_Martin() {
        List<Courier> expected_Unrefrigerated_Couriers = new ArrayList<>();
        expected_Unrefrigerated_Couriers.add(martin_Moves);
        Assertions.assertEquals(expected_Unrefrigerated_Couriers, listOfCouriersTest.refrigerationCriteria(false));

    }

    //distance criteria tests
    @Test
    public void When_Order_Is_Ready_For_Delivery_At_11_45 () {
        List<Courier> expectedlistOfCouriersForOrderAt11_45= new ArrayList<>();
       expectedlistOfCouriersForOrderAt11_45.add(bobby_bikes);
       expectedlistOfCouriersForOrderAt11_45.add(martin_Moves);
       expectedlistOfCouriersForOrderAt11_45.add(geoff_Go_Go);
       Assertions.assertEquals(expectedlistOfCouriersForOrderAt11_45, listOfCouriersTest.distanceCriteria(2.5));

    }
}












//distance criteria test
//
//    @Test
//    void WhenDeliveryHasADistanceOf2_5milesThenReturnAllCouriers () {
//        //Given distance of 2.5 miles
//        double distance = 2.5;
//        //when courier finder is called
//        String
//        Assertions.assertEquals(3, );
//
//
//    }


