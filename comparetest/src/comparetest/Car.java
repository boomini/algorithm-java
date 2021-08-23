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
	//차번호로 compare하여 정렬하기
	@Override
	public int compareTo(Car car) {
		if(this.carNum > car.carNum) { //내림차순
//		if(this.carNum < car.carNum) {
			//오름차순
			return -1;
		}else if(this.carNum == car.carNum) {
			return 0;
		}else {
			return 1;
		}
	}
	//차이름으로 compare하여 정렬하기
//	@Override
//	public int compareTo(Car car) {
//		if(this.carName.compareTo(car.carName) > 0) {
//			//return 1;//오름차순
//			return -1;//내림차순
//		}else if(this.carName.compareTo(car.carName) < 0) {
//			//return -1;//오름차순
//			return 1; //내림차순
//		}else {
//			return 0;
//		}
//		
//		//return this.carName.compareTo(car.carName);
//	}
	
}
