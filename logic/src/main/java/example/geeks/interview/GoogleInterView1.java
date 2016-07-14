/**
 * In a Formula-1 challenge, there are n teams numbered 1 to n. Each team has a car and a
 * driver.
 * Car’s specification are as follows:
 * – Top speed: (150 + 10 * i) km per hour
 * – Acceleration: (2 * i) meter per second square.
 * – Handling factor (hf) = 0.8
 * – Nitro : Increases the speed to double or top speed, whichever is less. Can be used
 * only once.
 * Here i is the team number.
 * The cars line up for the race. The start line for (i + 1)th car is 200 * i meters
 * behind the ith car.
 * All of them start at the same time and try to attain their top speed. A re-assessment
 * of the positions
 * is done every 2 seconds(So even if the car has crossed the finish line in between,
 * you’ll get to know
 * after 2 seconds). During this assessment, each driver checks if there is any car within
 * 10 meters of his
 * car, his speed reduces to: hf * (speed at that moment). Also, if the driver notices
 * that he is the last
 * one on the race, he uses ‘nitro’.
 * Taking the number of teams and length of track as the input, Calculate the final speeds
 * and the
 * corresponding completion times
 */
package example.geeks.interview;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Arka Ghosh
 */
public class GoogleInterView1
{

	private final long snapShotInterval = 2;
	private final double handlingFactor = 0.8;
	boolean finish = false; // race status

	/**
	 * Method to take command line arguments.
	 * 
	 * @param args
	 *          - 1> Number of cars, 2> Track length
	 */
	public static void main(String[] args)
	{

		int carCount = 0;
		double trackLength = 0;

		if (args.length == 0) {
			System.out.println("Please enter the number of cars & the track length.");
		} else if (args.length == 1) {
			System.out.println("Please enter the track length.");
		} else if (args.length == 2) {
			carCount = Integer.parseInt(args[0]);
			trackLength = Integer.parseInt(args[1]);
		} else {
			System.out.println("We don't need that many inputs.");
		}

		GoogleInterView1 obj = new GoogleInterView1();
		obj.race(carCount, trackLength);
	}

	/**
	 * Method to start the race and calculate the output
	 * 
	 * @param carCount
	 *          - Number of cars
	 * @param trackLength
	 *          - Length of the Track
	 */
	private void race(int carCount, double trackLength)
	{
		// Create an array of cars first
		Car[] cars = new Car[carCount];
		for (int i = 0; i < cars.length; i++) {
			cars[i] = new Car(i + 1);
		}

		// Evaluate till the race id finished
		while (!isFinish()) {
			assessPositions(cars, trackLength, carCount);
		}

		System.out.println("Final Position of the cars:");
		for (int i = 0; i < cars.length; i++) {
			System.out.println("Car " + (i + 1) + ": " + cars[i].toString());
		}
	}

	/**
	 * Method to evaluate the current speed, distance traveled and current
	 * positions of cars.
	 * 
	 * @param cars
	 *          - Array of Cars
	 * @param trackLength
	 *          - Length of the track
	 */
	private void assessPositions(Car[] cars, double trackLength, int carCount)
	{
		for (Car car : cars) {
			if (!car.isRaceCompleted()) {
				/*
				 * Calculate the distance traveled by a car using the below
				 * formula: u = initial speed, f = acceleration, t = time
				 * interval, s = distance traveled,
				 * s = ut + (f(t^2))/2
				 */
				double distTravelled = (car.getSpeed() * getSnapShotInterval()) + (car.getAcceleration() * 4 / 2);
				car.setDistantFromStartLine(car.getDistantFromStartLine() + distTravelled);

				// get the current speed of the car
				getCurrentSpeed(car);

				// increase the completion time of the car by the time interval.
				car.setCompletionTime(car.getCompletionTime() + getSnapShotInterval());
				/*
				 * If the distance traveled by a car is greater than the track
				 * length, then stop the race for that car.
				 */
				if (car.getDistantFromStartLine() >= trackLength) {
					car.setRaceCompleted(true);
				}
			}
		}
		getCurrentPosition(cars, trackLength, carCount);
	}

	/**
	 * Method to calculate the current speed of a car.
	 * 
	 * @param car
	 *          - An instance of Car
	 */
	private void getCurrentSpeed(Car car)
	{
		if (car.getSpeed() < car.getTopSpeed()) {
			/*
			 * Calculate the current of a car using the below formula:
			 * v = current speed, u = initial speed, f = acceleration, t = time
			 * interval.
			 * v = u +ft
			 */
			double speed = car.getSpeed() + (car.getAcceleration() * getSnapShotInterval());
			changeSpeed(car, speed);
		}
	}

	/**
	 * Method to change the current speed of the car.
	 * 
	 * @param car
	 *          - An instance of Car
	 * @param speed
	 *          - Current speed of that car
	 */
	private void changeSpeed(Car car, double speed)
	{
		if (speed >= car.getTopSpeed()) {
			car.setSpeed(car.getTopSpeed());
		} else {
			car.setSpeed(speed);
		}
	}

	/**
	 * Method to evaluate the current positions of the cars after a time
	 * interval.
	 * 
	 * @param cars
	 *          - Array of Cars.
	 */
	private void getCurrentPosition(Car[] cars, double trackLength, int carCount)
	{
		/*
		 * Define the comparator using which the sorting will take place. It
		 * should compare the completion time and the distant from start line of
		 * each car to evaluate the position.
		 */
		Comparator<GoogleInterView1.Car> comparator = new Comparator<GoogleInterView1.Car>()
		{
			public int compare(Car o1, Car o2)
			{
				if (o1.getCompletionTime() < o2.getCompletionTime())
					return -1;
				else if (o1.getCompletionTime() > o2.getCompletionTime())
					return 1;
				else if (o1.getDistantFromStartLine() < o2.getDistantFromStartLine())
					return 1;
				else if (o1.getDistantFromStartLine() > o2.getDistantFromStartLine())
					return -1;
				else
					return 0;
			}
		};

		// Sort the cars.
		Arrays.sort(cars, comparator);

		// Reset the position of cars based on the sorting output.
		for (int i = 0; i < cars.length; i++) {
			cars[i].setPosition(i + 1);
			/*
			 * If the car is in last position, check whether it has crossed the
			 * finish line. If yes then stop the race. Otherwise apply nitro.
			 */
			if (cars[i].getPosition() == carCount) {
				if (cars[i].getDistantFromStartLine() >= trackLength) {
					this.setFinish(true);
				} else if (!cars[i].isRaceCompleted()) {
					applyNitro(cars[i]);
				}
			} else if (cars[i].getPosition() != 1 && !cars[i].isRaceCompleted()) {
				double accidentalDist = cars[i - 1].getDistantFromStartLine() - cars[i].getDistantFromStartLine();
				if (accidentalDist <= 10) {
					cars[i].setSpeed(cars[i].getSpeed() * getHandlingFactor());
				}
			}
		}
	}

	/**
	 * Method to apply nitro to a car
	 * 
	 * @param car
	 *          - An instance of Car
	 */
	private void applyNitro(Car car)
	{
		if (!car.getNitroFlag()) {
			double currentSpeed = car.getSpeed() * 2;
			changeSpeed(car, currentSpeed);
			car.setNitroFlag(true);
		}
	}

	/**
	 * The inner class Car.
	 * 
	 * @author Arka Ghosh
	 */
	public class Car
	{
		private int teamNumber;
		private double topSpeed;
		private double speed;
		private double acceleration;
		private int position;
		private double distantFromStartLine;
		private boolean nitroFlag = false;
		private boolean raceCompleted = false;
		private long completionTime;

		/**
		 * Constructor to create a <code>Car</code> with team number.
		 * 
		 * @param teamNumber
		 *          - Team Number
		 */
		public Car(int teamNumber)
		{
			this.setTeamNumber(teamNumber);
			this.setTopSpeed((150 + 10 * teamNumber) * 5 / 18);
			this.setAcceleration(2 * teamNumber);
			this.setPosition(teamNumber);
			this.setDistantFromStartLine(0 - (teamNumber * (teamNumber - 1) / 2) * 200);
		}

		/**
		 * @return the teamNumber
		 */
		public int getTeamNumber()
		{
			return teamNumber;
		}

		/**
		 * @param teamNumber
		 *          the teamNumber to set
		 */
		public void setTeamNumber(int teamNumber)
		{
			this.teamNumber = teamNumber;
		}

		/**
		 * @return the topSpeed
		 */
		public double getTopSpeed()
		{
			return topSpeed;
		}

		/**
		 * @param topSpeed
		 *          the topSpeed to set
		 */
		public void setTopSpeed(double topSpeed)
		{
			this.topSpeed = topSpeed;
		}

		/**
		 * @return the speed
		 */
		public double getSpeed()
		{
			return speed;
		}

		/**
		 * @param speed
		 *          the speed to set
		 */
		public void setSpeed(double speed)
		{
			this.speed = speed;
		}

		/**
		 * @return the acceleration
		 */
		public double getAcceleration()
		{
			return acceleration;
		}

		/**
		 * @param acceleration
		 *          the acceleration to set
		 */
		public void setAcceleration(double acceleration)
		{
			this.acceleration = acceleration;
		}

		/**
		 * @return the position
		 */
		public int getPosition()
		{
			return position;
		}

		/**
		 * @param position
		 *          the position to set
		 */
		public void setPosition(int position)
		{
			this.position = position;
		}

		/**
		 * @return the distantFromStartLine
		 */
		public double getDistantFromStartLine()
		{
			return distantFromStartLine;
		}

		/**
		 * @param distantFromStartLine
		 *          the distantFromStartLine to set
		 */
		public void setDistantFromStartLine(double distantFromStartLine)
		{
			this.distantFromStartLine = distantFromStartLine;
		}

		/**
		 * @return the nitroFlag
		 */
		public boolean getNitroFlag()
		{
			return nitroFlag;
		}

		/**
		 * @param nitroFlag
		 *          the nitroFlag to set
		 */
		public void setNitroFlag(boolean nitroFlag)
		{
			this.nitroFlag = nitroFlag;
		}

		/**
		 * @return the raceCompleted
		 */
		public boolean isRaceCompleted()
		{
			return raceCompleted;
		}

		/**
		 * @param raceCompleted
		 *          the raceCompleted to set
		 */
		public void setRaceCompleted(boolean raceCompleted)
		{
			this.raceCompleted = raceCompleted;
		}

		/**
		 * @return the completionTime
		 */
		public long getCompletionTime()
		{
			return completionTime;
		}

		/**
		 * @param completionTime
		 *          the completionTime to set
		 */
		public void setCompletionTime(long completionTime)
		{
			this.completionTime = completionTime;
		}

		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString()
		{
			StringBuilder builder = new StringBuilder();
			builder.append("Car [teamNumber=");
			builder.append(teamNumber);
			builder.append(", topSpeed=");
			builder.append(topSpeed);
			builder.append(", speed=");
			builder.append(speed);
			builder.append(", acceleration=");
			builder.append(acceleration);
			builder.append(", position=");
			builder.append(position);
			builder.append(", distantFromStartLine=");
			builder.append(distantFromStartLine);
			builder.append(", nitroFlag=");
			builder.append(nitroFlag);
			builder.append(", raceCompleted=");
			builder.append(raceCompleted);
			builder.append(", completionTime=");
			builder.append(completionTime);
			builder.append("]");
			return builder.toString();
		}
	}

	/**
	 * @return the finish
	 */
	public boolean isFinish()
	{
		return finish;
	}

	/**
	 * @param finish
	 *          the finish to set
	 */
	public void setFinish(boolean finish)
	{
		this.finish = finish;
	}

	/**
	 * @return the snapShotInterval
	 */
	public long getSnapShotInterval()
	{
		return snapShotInterval;
	}

	/**
	 * @return the handlingFactor
	 */
	public double getHandlingFactor()
	{
		return handlingFactor;
	}
}
