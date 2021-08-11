package comparetest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarCompareTest {
	public static void main(String[] args) {
		Car car = new Car(2460,"SonataB","HD");
		Car car1 = new Car(2450,"KB","KIA");
		Car car2 = new Car(2440,"QM6","SS");
		Car car3 = new Car(2430,"SonatA","HD");
		Car car4 = new Car(2420,"XM3","SS");
		Car car5 = new Car(2410,"K5","KIA");
		Car car6 = new Car(2960,"GENESIS","HD");
		Car car7 = new Car(2360,"Avante","HD");
		Car car8 = new Car(2160,"SM6","SS");
		
		List<Car> list = new ArrayList<Car>();
		list.add(car1);
		list.add(car2);
		list.add(car3);
		list.add(car4);
		list.add(car5);
		list.add(car6);
		list.add(car7);
		list.add(car8);
		view(list);
		
		System.out.println(">>>>>>>>>>>>>>>차번호로 정렬 후 결과");
		Collections.sort(list);
		view(list);
		
		System.out.println(">>>>>>>>>>>>>>>차이름로 정렬 후 결과");
		Comparator<Car> carNameCompare = new Comparator<Car>() {

			@Override
			public int compare(Car c1, Car c2) {
				if(c1.getCarName().compareTo(c2.getCarName()) > 0) {
				return 1;//오름차순
				//return -1;//내림차순
			}else if(c1.getCarName().compareTo(c2.getCarName()) < 0) {
				return -1;//오름차순
				//return 1; //내림차순
			}else {
				return 0;
			}
			
			//return this.carName.compareTo(car.carName);
			
		}};
		Collections.sort(list, carNameCompare);
		view(list);
		
		Comparator<Car> carMakerCompare = new Comparator<Car>() {

			@Override
			public int compare(Car c1, Car c2) {
				if(c1.getMaker().compareTo(c2.getMaker()) > 0) {
				return 1;//오름차순
				//return -1;//내림차순
			}else if(c1.getMaker().compareTo(c2.getMaker()) < 0) {
				return -1;//오름차순
				//return 1; //내림차순
			}else {
				return 0;
			}
			
			//return this.carName.compareTo(car.carName);
			
		}};
		System.out.println(">>>>>>>>>>>>>>>제조사로 정렬 후 결과");
		Collections.sort(list, carMakerCompare);
		view(list);
	}

	private static void view(List<Car> list) {
		System.out.println("차번호\t차이름\t제조사");
		for (Car car : list) {
			System.out.println(car);
		}

	}

}
