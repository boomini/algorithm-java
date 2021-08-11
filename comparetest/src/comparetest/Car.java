package comparetest;

public class Car implements Comparable<Car>{
	private int carNum;
	private String carName;
	private String maker;
	public Car(int carNum, String carName, String maker) {
		super();
		this.carNum = carNum;
		this.carName = carName;
		this.maker = maker;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	@Override
	public String toString() {
		return "Car [carNum=" + carNum + ", carName=" + carName + ", maker=" + maker + "]";
	}
	//this가 car보다 우선순위가 더 높으면 -1, 같으면 0, 낮으면 1을 리턴
	@Override
	public int compareTo(Car car) {
		//if(this.carNum > car.carNum) { //내림차순
		if(this.carNum < car.carNum) {
			//오름차순
			return -1;
		}else if(this.carNum == car.carNum) {
			return 0;
		}else {
			return 1;
		}
	}
	
//	@Override
//	public int compareTo(Car car) {
//		if(this.carName.compareTo(car.carName) > 0) {
//			return 1;//오름차순
//			//return -1;//내림차순
//		}else if(this.carName.compareTo(car.carName) < 0) {
//			return -1;//오름차순
//			//return 1; //내림차순
//		}else {
//			return 0;
//		}
//		
//		//return this.carName.compareTo(car.carName);
//	}
	
}
