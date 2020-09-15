// Louis Miller and Shane Cranor

public class Burner {
 
  private enum Temp { BLAZING, HOT, WARM, COLD }
  private Temp temperature;
  private Setting setting;
	private int timer = 0;
	private static final int TIME_DURATION = 2;
  public Burner(){
    temperature = Temp.COLD;
    setting = Setting.OFF;
  }
	public boolean isBlazing(){
		return temperature == Temp.BLAZING;
	}
  public void plusButton(){
		//timer = TIME_DURATION;
    switch(setting) {
      case OFF:
        setting = Setting.LOW;
        break;
			case LOW:
        setting = Setting.MEDIUM;
        break;
			case MEDIUM:
        setting = Setting.HIGH;
        break;
    }
  }
  public void minusButton(){
		//timer = TIME_DURATION;
		switch(setting) {
      case HIGH:
        setting = Setting.MEDIUM;
        break;
			case MEDIUM:
        setting = Setting.LOW;
        break;
			case LOW:
        setting = Setting.OFF;
        break;
    }
  }


	public void updateTemperature(){
	
		if(timer > 0){
			timer--;
		}else{
			timer = TIME_DURATION;
			switch(setting) {
      	case HIGH:
					raiseTemp();
      	  break;
				case MEDIUM:
					switch(temperature) {
						case BLAZING:
							lowerTemp();
							break;
						case COLD:
						case WARM:
							raiseTemp();
							break;
					}
       		break;
				case LOW:
					switch(temperature) {
						case BLAZING:
						case HOT:
							lowerTemp();
							break;
						case COLD:
							raiseTemp();
							break;
					}					
        	break;
				case OFF:
					lowerTemp();
					break;
   		}
		}
		//Update timer and temperature as shown in PDF
	}

	private void lowerTemp(){
		switch(temperature) {
      case COLD:
				temperature = Temp.COLD;
				break;
			case WARM:
        temperature = Temp.COLD;
        break;
			case HOT:
        temperature = Temp.WARM;
        break;
			case BLAZING:
        temperature = Temp.HOT;
        break;
    }
	}

	private void raiseTemp(){
		switch(temperature) {
      case COLD:
				temperature = Temp.WARM;
			case WARM:
        temperature = Temp.HOT;
        break;
			case HOT:
        temperature = Temp.BLAZING;
        break;
			case BLAZING:
        temperature = Temp.BLAZING;
        break;
    }
	}
	
	public void display(){
    switch(setting) {
			case HIGH:
        System.out.print("[+++].....");
        break;
			case MEDIUM:
        System.out.print("[-++].....");
        break;
			case LOW:
        System.out.print("[--+].....");
        break;
      case OFF:
        System.out.print("[---].....");
        break;
    }
		
		switch(temperature) {
      case COLD:
        System.out.println("cooool");
        break;
			case WARM:
        System.out.println("warm");
        break;
			case HOT:
        System.out.println("CAREFUL");
        break;
			case BLAZING:
        System.out.println("VERY HOT! DON'T TOUCH");
        break;
    }
	}
}
/*
    A constructor that sets the temperature to Temp.COLD and the setting to Setting.OFF
    A plusButton() raises the setting one notch (e.g., from Setting.OFF to Setting.LOW), unless it's already on Setting.HIGH. If the setting is Setting.HIGH, calling this function will have no effect (i.e., not an error, burner just stays at its Setting.HIGHest setting).
        You must use a switch statement for plusButton() and minusButton() (why? to see how it works with enumerated types).
    minusButton() Setting.LOWers the setting one notch, unless the burner is already Setting.OFF (i.e., this is the reverse of plusButton()).  
    Both of these functions will set timer.
    updateTemperature() will be called (hypothetically) every minute. This method will update the timer and temperature, as shown in the pdf.
    display() will show the status of the burner, in the format shown in the figure beSetting.LOW. You should make use of the toString() method of the Setting enum for part of the display.
	
*/