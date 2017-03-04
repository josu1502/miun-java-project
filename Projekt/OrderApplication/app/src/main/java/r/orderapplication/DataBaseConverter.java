package r.orderapplication;

import java.util.ArrayList;
import java.util.List;

import r.orderapplication.dinnerRest.DinnerEntity;
import r.orderapplication.orderRest.OrderEntity;

import static r.orderapplication.MainActivity.tableNumber;

/**
 * Created by Alex on 2017-03-04.
 */

public class DataBaseConverter {
    private List<DinnerEntity> originalList;
    private List<OrderEntity> orderList;
    private List<DinnerEntity> appetizerList;
    private List<DinnerEntity> mainCourseList;

    DataBaseConverter(List<DinnerEntity> de){

        this.originalList = de;

        orderList = new ArrayList<>();
        appetizerList = new ArrayList<>();
        mainCourseList= new ArrayList<>();
        for(int i =0; i < de.size(); i++) {
            if (de.get(i).getType().equals("Förätt")) {
                appetizerList.add(de.get(i));
            }
            if (de.get(i).getType().equals("Huvudrätt")) {
                mainCourseList.add(de.get(i));
            }
            OrderEntity oe = new OrderEntity();
            oe.setTableNr(tableNumber);
            oe.setAmount(0);
            oe.setFinished(false);
            oe.setCourseName(de.get(i).getName());
            oe.setCourseType(de.get(i).getType());

        }
    }

    public List<DinnerEntity> getOriginalList() {
        return originalList;
    }

    public List<OrderEntity> getOrderList() {
        return orderList;
    }

    public List<DinnerEntity> getAppetizerList() {
        return appetizerList;
    }

    public List<DinnerEntity> getMainCourseList() {
        return mainCourseList;
    }
}
