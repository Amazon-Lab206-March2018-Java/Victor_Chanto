public class Main {

	public static void main(String[] args) {
		Human Javier = new Human();
		Human Alejandro = new Human();
		Wizard Harry = new Wizard();
		Ninja Gerardo = new Ninja();
		Samurai Victor = new Samurai();
		Alejandro.attack(Javier);
		System.out.println(Javier.getHealth());
		Harry.fireball(Javier);
		System.out.println(Javier.getHealth());
		Harry.heal(Javier);
		System.out.println(Javier.getHealth());
		Gerardo.steal(Alejandro);
		System.out.println(Alejandro.getHealth());
		Gerardo.runAway();
		System.out.println(Gerardo.getHealth());
		Gerardo.runAway();
		System.out.println(Gerardo.getHealth());
		Victor.deathBlow(Javier);
		System.out.println(Javier.getHealth());
		System.out.println(Victor.getHealth());
		System.out.println(Victor.howMany());
		 
	}

}
