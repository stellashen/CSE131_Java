package exercises2;

public class Diagram {

	public static void main(String[] args) {
		// Do I want to do sth?
		boolean doIt = Math.random()<0.5;
		// If not, would it be dangerous
		boolean isDangerous = Math.random()<0.5;
		// If so, would it make a good story
		boolean doItAnyway = Math.random()<0.5;
		
		if (doIt){
			System.out.println("I want to do it!");
		}
		else {
			if (isDangerous){
				if (doItAnyway){
					System.out.println("It would make a good story, let's do it!");
				}
				else {
					System.out.println("Forget about it, dangerous & no good story.");
				}
			}
			else {
				System.out.println("Not dangerous, so let's do it!");
			}
		}

	}

}
