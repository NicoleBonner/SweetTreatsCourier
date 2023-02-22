package SweetTreats;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class ListOfCouriers {

   List<Courier> listOfCouriers() {
      return List.of(
              new Courier("Bobby Bikes", LocalTime.of(9, 00), LocalTime.of(13, 00) , 5.00, true, 1.75),
              new Courier("Martin Moves", LocalTime.of(9,00), LocalTime.of(17,00), 3.00, false, 1.50),
              new Courier("Geoff Go Go", LocalTime.of(10,00), LocalTime.of(16,00), 4.00, true, 2.00)
      );
   }

   //Logic for refrigeration criteria
   public
   List<Courier> refrigerationCriteria(boolean refrigerationRequirement) {
      if (refrigerationRequirement == true) {
         List<Courier> filteredRefridgeratedCouriers = listOfCouriers().stream()
                 .filter(Courier -> Courier.getRefrigeration() == true)
                 .collect(Collectors.toList());
         return filteredRefridgeratedCouriers;

      } else if (!refrigerationRequirement == false) {
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

//   public List<Courier> deliveryTimeCriteria(LocalTime deliveryTime) {
//      if (deliveryTime.isAfter(LocalTime.of(9,00)) && (deliveryTime.isBefore(LocalTime.of(10,00)))) {
//         List<Courier> filteredListOfCouriersWhoDeliverEarlyDelivery = listOfCouriers().stream()
//                 .filter(Courier -> Courier.getStartTime() > )
//      }
//
//
//   }

}



























