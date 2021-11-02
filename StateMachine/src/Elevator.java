public class Elevator {

	public static int current_Floor = 5;
	int dest_floor;

	private Elv_States State = new Elv_States();

	public Elevator(int dest_floor) {
		this.dest_floor = dest_floor;
		System.out.println("*** Destination floor is: " + dest_floor);
		State.currentState = State.Idle;
		arrive_atFloor();

	}

	private void arrive_atFloor() {
		if (current_Floor < dest_floor) {
			go_up();
		} else if (current_Floor == dest_floor) {
			exit();
		} else if (current_Floor > dest_floor) {
			go_down();
		}

	}

	private void go_up() {
		System.out.println("Current State: " + State.currentState);
		System.out.println("Current Floor: " + current_Floor);
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		State.currentState = State.Moving_up;
		current_Floor++;
		if (current_Floor == dest_floor) {
			arrive_to_floor();
			exit();
		} else {
			go_up();
		}
	}

	private void arrive_to_floor() {
		State.currentState = State.Idle;

	}

	private void exit() {
		System.out.println("Current State: " + State.currentState);
		System.out.println("Current Floor: " + current_Floor);
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		System.out.println("-----ARRIVED-----");

	}

	public void go_down() {
		System.out.println("Current State: " + State.currentState);
		System.out.println("Current Floor: " + current_Floor);
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		State.currentState = State.Moving_down;
		current_Floor--;
		if (current_Floor == dest_floor) {
			arrive_to_floor();
			exit();
		} else {
			go_down();
		}
	}

}
