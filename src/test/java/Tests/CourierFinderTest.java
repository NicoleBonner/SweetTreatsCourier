package Tests;

import SweetTreats.Courier;
import SweetTreats.ListOfCouriers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
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
        bobby_bikes = new Courier("Bobby Bikes", LocalTime.of(9, 00), LocalTime.of(13, 00) , 5.00, true, 1.75);
        martin_Moves = new Courier("Martin Moves", LocalTime.of(9,00), LocalTime.of(17,00), 3.00, false, 1.50);
        geoff_Go_Go = new Courier("Geoff Go Go", LocalTime.of(10,00), LocalTime.of(16,00), 4.00, true, 2.00);
        listOfCouriersTest = new ListOfCouriers();
    }

    //Working hours criteria tests

    @Test
    public void When_Order_Is_Ready_For_Delivery_At_11_45_Then_Return_All_Avalaible_Couriers () {
        List<Courier> expectedlistOfCouriersForDeliveryTimeOf11_45= new ArrayList<>();
        expectedlistOfCouriersForDeliveryTimeOf11_45.add(bobby_bikes);
        expectedlistOfCouriersForDeliveryTimeOf11_45.add(martin_Moves);
        expectedlistOfCouriersForDeliveryTimeOf11_45.add(geoff_Go_Go);
        Assertions.assertEquals(expectedlistOfCouriersForDeliveryTimeOf11_45, listOfCouriersTest.deliveryTimeCriteria(19:00));
    }





    //Refrigeration criteria tests
    @Test
    public void When_Refrigeration_Is_Required_Then_Return_Bobby_And_Geoff() {
        List<Courier> expected_Refrigerated_Couriers = new ArrayList<>();
        expected_Refrigerated_Couriers.add(bobby_bikes);
        expected_Refrigerated_Couriers.add(geoff_Go_Go);
        Assertions.assertEquals(expected_Refrigerated_Couriers, listOfCouriersTest.refrigerationCriteria(true));

    }
    @Test
    public void When_Refrigeration_Is_NOT_Required_Return_Martin() {
        List<Courier> expected_Unrefrigerated_Couriers = new ArrayList<>();
        expected_Unrefrigerated_Couriers.add(martin_Moves);
        Assertions.assertEquals(expected_Unrefrigerated_Couriers, listOfCouriersTest.refrigerationCriteria(false));

    }

    @Test
    public void When_Order_Has_No_Refridgeration_Preferance () {
        Assertions.assertNull(listOfCouriersTest.distanceCriteria(6.0));
    }


    //distance criteria tests
    @Test
    public void When_Order_Had_Delivery_Distance_Of_2_5Miles_Then_Return_All_Couriers () {
        List<Courier> expectedlistOfCouriersForDistanceof2_5Miles= new ArrayList<>();
        expectedlistOfCouriersForDistanceof2_5Miles.add(bobby_bikes);
        expectedlistOfCouriersForDistanceof2_5Miles.add(martin_Moves);
        expectedlistOfCouriersForDistanceof2_5Miles.add(geoff_Go_Go);
       Assertions.assertEquals(expectedlistOfCouriersForDistanceof2_5Miles, listOfCouriersTest.distanceCriteria(2.5));
    }

    @Test
    public void When_Order_Has_Delivery_Distance_Of_4Miles_Then_Return_Bobby_And_Geoff () {
        List<Courier> expectedListOfCouriersWhoCanDleiverupTo4Miles = new ArrayList<>();
        expectedListOfCouriersWhoCanDleiverupTo4Miles.add(bobby_bikes);
        expectedListOfCouriersWhoCanDleiverupTo4Miles.add(geoff_Go_Go);
        Assertions.assertEquals(expectedListOfCouriersWhoCanDleiverupTo4Miles, listOfCouriersTest.distanceCriteria(4.0));
    }
    @Test
    public void When_Order_Has_Delivery_Distance_Of_4_5Miles_Then_Return_Bobby () {
        List<Courier> expectedListOfCouriersWhoCanDleiverupTo4_5Miles = new ArrayList<>();
        expectedListOfCouriersWhoCanDleiverupTo4_5Miles.add(bobby_bikes);
        Assertions.assertEquals(expectedListOfCouriersWhoCanDleiverupTo4_5Miles, listOfCouriersTest.distanceCriteria(4.5));
    }
    @Test
    public void When_Order_Has_Delivery_Distance_Of_6_Miles_Then_Return_No_Couriers () {
        List<Courier> expectedListOfCouriersWhoCanDeliverUpTo6Miles = new ArrayList<>();
        Assertions.assertTrue(expectedListOfCouriersWhoCanDeliverUpTo6Miles.isEmpty());
        Assertions.assertNull(listOfCouriersTest.distanceCriteria(6.0));
    }

    }
















