package übung12;

public class Punkt {
	int x;
	int y;

	public Punkt(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void verschiebePunkt(int zielX, int zielY) {
		if (zielX < 0 || zielY < 0 || zielX > 1920 || zielY > 1080) {
			throw new RuntimeException();
		}
		x = zielX;
		y = zielY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}