import java.io.IOException;

public class GuideMain {

	static GuideManager manager = GuideManager.createManagerInst();
	static GuideGUI gg = new GuideGUI();
	
	public static void main(String[] args) throws IOException {

		gg.guideMain();
		gg.showRecord();
		
	}

}
