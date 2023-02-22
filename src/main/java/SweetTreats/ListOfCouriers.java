package SweetTreats;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ListOfCouriers {

   List<Courier> listOfCouriers() {
      return List.of(
              new Courier("Bobby Bikes", "9:00", "13:00", 5.00, true, 1.75),
              new Courier("Martin Moves", "9:00", "17:00", 3.00, false, 1.50),
              new Courier("Geoff Go Go", "10:00", "16:00", 4.00, true, 2.00)
      );
   }

   //Logic to filter our if order requires refridggeration
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

   public List<Courier> distanceCriteria(double distanceOfDelivery) {
      if ((distanceOfDelivery <= 3.00 )) {
         List<Courier> filteredListOfCouriersWhoDeliverUpTo3Miles = listOfCouriers().stream()
                 .filter(Courier -> Courier.getMaxDistance() > 0.00)
                 .collect(Collectors.toList());
         return filteredListOfCouriersWhoDeliverUpTo3Miles;

      }  if ((distanceOfDelivery> 0.00) && (distanceOfDelivery<=4)) {
         List<Courier> filteredListOfCouriersWhoDeliverUpTo4Miles = listOfCouriers().stream()
                 .filter(Courier -> Courier.getMaxDistance() < 4.00)
                 .collect(Collectors.toList());
         return  filteredListOfCouriersWhoDeliverUpTo4Miles;

      } if ((distanceOfDelivery>0.00) && (distanceOfDelivery<=5.00)) {
         List<Courier> filteredListOfCouriersWhoDeliverUpTo5Miles = listOfCouriers().stream()
                 .filter(Courier -> Courier.getMaxDistance() <=5.00)
                 .collect(Collectors.toList());
         return  filteredListOfCouriersWhoDeliverUpTo5Miles;

      } else
      return null;
   }
}

























//      for (int i = 0; i < listOfCouriers().size(); i++) {
//         if (refridgerationRequirement == true) {
//            filtered.add(i);
//         }
//      }
//      return filteredRefridgeratedCouriers;
//   }
//}




//         } else {
//            return false;
//         }
//      }

//      public List<Person> filtered = new ArrayList<>();
//      for(Person p : people) {
//         if(p.age() < 19) {
//            filtered.add(p);
//         }
//      }
//      return filtered;
//


//      }
//         if (orderInput == 'Y') {
//            return true;
//         } else
//            return false;
//      }






