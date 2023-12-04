import java.util.prefs.Preferences;

class RechnerPreferences {
		
	public Preferences getState() {
		return Preferences.userNodeForPackage(getClass());
	}

}