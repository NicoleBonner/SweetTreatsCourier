package SweetTreats;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class ListOfCouriers {

   List<Courier> listOfCouriers() {
      return List.of(
              new Courier("Bobby Bikes", LocalTime.of(9, 00), LocalTime.of(13, 00), 5.00, true, 1.75),
              new Courier("Martin Moves", LocalTime.of(9, 00), LocalTime.of(17, 00), 3.00, false, 1.50),
              new Courier("Geoff Go Go", LocalTime.of(10, 00), LocalTime.of(16, 00), 4.00, true, 2.00)
      );
   }

   //Logic for refrigeration criteria
   public List<Courier> refrigerationCriteria(boolean refrigerationRequirement) {
      if (refrigerationRequirement == true) {
         List<Courier> filteredRefridgeratedCouriers = listOfCouriers().stream()
                 .filter(Courier -> Courier.getRefrigeration() == true)
                 .collect(Collectors.toList());
         return filteredRefridgeratedCouriers;

      } else if (refrigerationRequirement == false) {
         List<Courier> filteredUnrefrigeratedCouriers = listOfCouriers().stream()
                 .filter(Courier -> Courier.getRefrigeration() == false)
                 .collect(Collectors.toList());
         return filteredUnrefrigeratedCouriers;
      }
      return null;
   }

   //logic for distance criteria
   public List<Courier> distanceCriteria(double distanceOfDelivery) {
      if ((distanceOfDelivery > 0.00) && (distanceOfDelivery <= 3.00)) {
         List<Courier> filteredListOfCouriersWhoDeliverUpTo3Miles = listOfCouriers().stream()
                 .filter(Courier -> Courier.getMaxDistance() > 2.5)
                 .collect(Collectors.toList());
         return filteredListOfCouriersWhoDeliverUpTo3Miles;
         //returning all
      }
      if ((distanceOfDelivery > 3.00) && (distanceOfDelivery <= 4.00)) {
         List<Courier> filteredListOfCouriersWhoDeliverUpTo4Miles = listOfCouriers().stream()
                 .filter(Courier -> Courier.getMaxDistance() > 3.0)
                 .collect(Collectors.toList());
         return filteredListOfCouriersWhoDeliverUpTo4Miles;
         //retuning Bobby & Geoff
      }
      if (distanceOfDelivery > 4.00 & (distanceOfDelivery <= 5.00)) {
         List<Courier> filteredListOfCouriersWhoDeliverUpTo5Miles = listOfCouriers().stream()
                 .filter(Courier -> Courier.getMaxDistance() > 4.00)
                 .collect(Collectors.toList());
         return filteredListOfCouriersWhoDeliverUpTo5Miles;
         // returning only Bobby

      } else
         return null;
   }

   public List<Courier> getListOfCourierMatchTheDeliveryCriteriaStartEndTime(LocalTime deliveryTime) {
      List<Courier> courierDatabase = listOfCouriers(); // Bring a copy of the list to a local field

      List<Courier> matchingCouriers; //Init a empty list to store our matching couriers

      // Loading all values from the courierDatabase list, then stream each value
      // Using a filter to iterate over each value in the list and asserting if deliveryTime is after courierStartTime, then add them to a temporary list
      // Using another filter to iterate over the values in the temporary list, then assering if deliveryTime is before courierEndTime, then add them to a *new* temporary list
      matchingCouriers = courierDatabase.stream()
              .filter(courier -> deliveryTime.isAfter(courier.getStartTime()))
              .filter(courier -> deliveryTime.isBefore(courier.getEndTime()))
              .collect(Collectors.toList());

      return matchingCouriers;
   }
}































